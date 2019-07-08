package com.ccy.makaserver.repository;

import com.ccy.makaserver.document.Pages;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagesRepository extends MongoRepository<Pages, String> {
    public Pages findBy_id(ObjectId _id);

    public void deleteBy_id(ObjectId id);
}
