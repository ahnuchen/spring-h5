package com.ccy.makaserver.service;


import com.ccy.makaserver.document.Pages;
import com.ccy.makaserver.repository.PagesRepository;
import com.ccy.makaserver.response.CommonReturnType;
import com.ccy.makaserver.utils.TemplateUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

@Service
public class PagesService {
  @Autowired
  private PagesRepository pagesRepository;

  @Autowired
  private HttpServletRequest request;

  public List<Pages> getCurrentUserPage(String loginUserId, String type) {
    List<Pages> pages = pagesRepository.findByLoginIdAndType(loginUserId, type);
    return pages;
  }

  public Pages getCurrentPage(String loginId, String id) {
    Pages pages = pagesRepository.findBy_idAndLoginId(new ObjectId(id), loginId);
    return pages;
  }

  public Pages updatePage(String id, String loginId, Pages page) throws IOException {
    Pages currentPage = pagesRepository.findBy_idAndLoginId(new ObjectId(id), loginId);
    Pages savedPage = new Pages();
    if (currentPage != null) {
      savedPage = pagesRepository.save(page);
    }

    PagesService _this = this;
    _this.renderFile(page);
    return savedPage;
  }

  public Pages createPage(Pages pages) {
    Pages p = pagesRepository.save(pages);
    return p;
  }

  public void deletePage(String id, String loginId) {
    pagesRepository.deleteBy_idAndLoginId(id, loginId);
  }


  private void renderFile(Pages page) {
    //创建字符输出流并且自定义输出文件的位置和文件名
    String serverpath = request.getServletContext().getRealPath("/");
    Path path = Paths.get(serverpath, "pages", "basic.html");
    String htmlFilePath = path.toString();
    //创建Context对象(存放Model)
    Context context = new Context();
    //放入数据
    context.setVariable("hello", page.getTitle());
    System.out.println("htmlFilePath");
    System.out.println(htmlFilePath);
    TemplateUtils.process("basic",context,htmlFilePath);
  }
}
