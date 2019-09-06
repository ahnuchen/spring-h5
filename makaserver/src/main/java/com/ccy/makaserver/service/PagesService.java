package com.ccy.makaserver.service;


import com.ccy.makaserver.document.Pages;
import com.ccy.makaserver.repository.PagesRepository;
import com.ccy.makaserver.response.CommonReturnType;
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
    ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
    resolver.setPrefix("templates/");  //模板文件的所在目录
    resolver.setSuffix(".html");       //模板文件后缀
    resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
    resolver.setTemplateMode(TemplateMode.HTML);
    //创建模板引擎
    TemplateEngine templateEngine = new TemplateEngine();
    //将加载器放入模板引擎
    templateEngine.setTemplateResolver(resolver);
    //创建字符输出流并且自定义输出文件的位置和文件名
    String serverpath = request.getServletContext().getRealPath("/");
    Path path = Paths.get(serverpath, "pages", "basic.html");
    String htmlFilePath = path.toString();
    try {
      FileWriter writer = new FileWriter(htmlFilePath);
      //创建Context对象(存放Model)
      Context context = new Context();
      //放入数据
      context.setVariable("hello", page.getTitle());
      //创建静态文件,"text"是模板html名字
      try{
        templateEngine.process("basic.html", context, writer);
        String html = templateEngine.process("basic", context);
      }catch (Exception e){
        System.out.println("获取模板异常");
        System.out.println(e.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
