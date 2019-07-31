package com.ccy.makaserver.controller;


import com.ccy.makaserver.document.Pages;
import com.ccy.makaserver.document.Users;
import com.ccy.makaserver.repository.PagesRepository;
import com.ccy.makaserver.response.CommonReturnType;
import com.ccy.makaserver.service.PagesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PagesController extends BaseController {
  @Autowired
  private PagesService pagesService;

  @Autowired
  private HttpServletRequest request;

  @GetMapping("/pages")
  public CommonReturnType pages(@RequestParam("type") String type) {
    String loginId = (String) request.getAttribute("loginId");
    List<Pages> pagesList = pagesService.getCurrentUserPage(loginId, type);
    return CommonReturnType.success(pagesList);
  }

  @GetMapping("/pages/{id}")
  public CommonReturnType page(@PathVariable("id") String id) {
    String loginId = (String) request.getAttribute("loginId");
    Pages pages = pagesService.getCurrentPage(loginId, id);
    return CommonReturnType.success(pages);
  }

  @PutMapping("/pages/{id}")
  public CommonReturnType updatePage(@PathVariable("id") String id,Pages pages) {
    String loginId = (String) request.getAttribute("loginId");
    Pages savedPage =  pagesService.updatePage(id,loginId,pages);
    return CommonReturnType.success(savedPage);
  }

  @PostMapping("/pages")
  public CommonReturnType createPage(Pages pages){
    Pages p = pagesService.createPage(pages);
    return CommonReturnType.success(p);
  }

  @DeleteMapping("/pages/{id}")
  public CommonReturnType deletePage(@PathVariable("id") String id){
    String loginId = (String) request.getAttribute("loginId");
    pagesService.deletePage(id,loginId);
    return CommonReturnType.success("删除成功");
  }

}
