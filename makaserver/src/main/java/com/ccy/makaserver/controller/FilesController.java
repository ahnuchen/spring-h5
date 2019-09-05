package com.ccy.makaserver.controller;


import com.ccy.makaserver.document.Files;
import com.ccy.makaserver.formdata.UploadFileFormData;
import com.ccy.makaserver.repository.FilesRepository;
import com.ccy.makaserver.response.CommonReturnType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class FilesController extends BaseController {
  @Autowired
  private FilesRepository filesRepository;

  @Autowired
  private HttpServletRequest request;

  @RequestMapping("/files")
  public List<Files> files() {
    List<Files> files = filesRepository.findAll();
    return files;
  }

  @PostMapping("/upload")
  public CommonReturnType uploadFile(UploadFileFormData formData) throws IOException {
    String serverpath = request.getServletContext().getRealPath("/");
    Files files = new Files();
    MultipartFile file = formData.getImage();
    byte[] bytes = file.getBytes();
    String uid = UUID.randomUUID().toString().replace("-","");
    String fileName = file.getOriginalFilename();
    Path path = Paths.get(serverpath,"upload",
      formData.getThemeId(), uid+fileName.substring(fileName.lastIndexOf(".")).toLowerCase());
    java.nio.file.Files.createDirectories(Paths.get(serverpath,"upload",
      formData.getThemeId()));
    java.nio.file.Files.write(path, bytes);
    BeanUtils.copyProperties(formData, files);
    files.setCreateDate(new Date().getTime());
    files.setFilePath("/upload" + "/" +
      formData.getThemeId() + "/" + uid +
      fileName.substring(fileName.lastIndexOf(".")).toLowerCase());
    Files savedFile = filesRepository.save(files);
    return CommonReturnType.success(savedFile);
  }
}
