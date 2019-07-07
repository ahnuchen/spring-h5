package com.ccy.springh5.dao.impl;

import com.ccy.springh5.dao.BaseDao;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public class BaseDaoImpl<T, ID extends Serializable> extends SimpleMongoRepository<T, ID> implements BaseDao<T, ID> {

  protected final MongoOperations mongoTemplate;

  protected final MongoEntityInformation<T, ID> entityInformation;

  private Class<T> clazz;

  public BaseDaoImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
    super(metadata, mongoOperations);
    this.mongoTemplate = mongoOperations;
    this.entityInformation = metadata;
    clazz = entityInformation.getJavaType();
  }

  /**
   * 修改
   * @param id
   * @param t
   **/
  @Override
  public void update(ID id, T t) {
    Update update = new Update();
    // 获取实体类的所有属性，返回Field数组
    Query query = new Query();
    query.addCriteria(new Criteria("_id").is(id));
    // 利用反射获取部位空的属性值
    Field[] field = clazz.getDeclaredFields();
    for (int i = 0; i < field.length; i++) {
      Field f = field[i];
      // 设置些属性是可以访问的
      f.setAccessible(true);
      try {
        Object object = f.get(t);
        if (object != null) {
          update.set(f.getName(), object);
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    this.mongoTemplate.updateFirst(query, update, clazz);
  }

  /**
   * @param id  更新主键
   * @param updateFieldMap  key:需要更新的属性  value:对应的属性值
   */
  @Override
  public void update(ID id, Map<String, Object> updateFieldMap) {
    if (updateFieldMap != null && !updateFieldMap.isEmpty()) {
      Criteria criteria = new Criteria("_id").is(id);
      Update update = new Update();
      updateFieldMap.forEach(update::set);
      mongoTemplate.updateFirst(new Query(criteria), update, clazz);
    }
  }

  /**
   * @param queryFieldMap  字段名
   * @param updateFieldMap  key:需要更新的属性  value:对应的属性值
   */
  @Override
  public void update(Map<String, Object> queryFieldMap, Map<String, Object> updateFieldMap) {
    Criteria criteria = new Criteria();
    if (null != queryFieldMap && !queryFieldMap.isEmpty()) {
      queryFieldMap.forEach((key, value) -> criteria.and(key).is(value));
    }

    if (updateFieldMap != null && !updateFieldMap.isEmpty()) {
      Update update = new Update();
      updateFieldMap.forEach(update::set);
      mongoTemplate.updateFirst(new Query(criteria), update, clazz);
    }
  }
}
