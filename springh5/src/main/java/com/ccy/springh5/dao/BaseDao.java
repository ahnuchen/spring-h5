package com.ccy.springh5.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Map;

@NoRepositoryBean
public interface BaseDao<T, ID extends Serializable> extends MongoRepository<T, ID> {

  /**
   * 根据传入的对象 修改
   *
   * @param id
   * @param t
   */
  void update(ID id, T t);

  /**
   * 根据id修改
   *
   * @param id             更新主键
   * @param updateFieldMap key:需要更新的属性  value:对应的属性值
   */
  void update(ID id, Map<String, Object> updateFieldMap);

  /**
   * 根据传入值修改
   *
   * @param queryFieldMap  key:查询条件的属性  value:对应的属性值
   * @param updateFieldMap key:需要更新的属性  value:对应的属性值
   */
  void update(Map<String, Object> queryFieldMap, Map<String, Object> updateFieldMap);
}
