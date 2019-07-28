package com.ccy.makaserver.repository;

import com.ccy.makaserver.document.Pages;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PagesRepository extends MongoRepository<Pages, String> {
  public Pages findBy_id(ObjectId _id);

  public void deleteBy_id(ObjectId id);

  public List<Pages> findByLoginIdAndType(String loginId, String type);

  public Pages findPagesByLoginIdAnd_id(String loginId, String id);
}
