package com.ccy.makaserver.repository;


import com.ccy.makaserver.document.Files;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilesRepository extends MongoRepository<Files, String> {
}
