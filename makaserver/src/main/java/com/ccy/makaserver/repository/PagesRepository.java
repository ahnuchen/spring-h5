package com.ccy.makaserver.repository;

import com.ccy.makaserver.document.Pages;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PagesRepository extends MongoRepository<Pages, String> {

  public List<Pages> findByLoginIdAndType(String loginId, String type);

  public Pages findBy_idAndLoginId(String loginId,String id);

  public void deleteBy_idAndLoginId(String id,String loginId);

}
