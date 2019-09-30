package com.ccy.makaserver.repository;


import com.ccy.makaserver.document.Files;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilesRepository extends MongoRepository<Files, String> {
  public List<Files> findAllByThemeId(String themeId);
  public List<Files> findAllByThemeIdAndFileType(String themeId, String fileType);
}
