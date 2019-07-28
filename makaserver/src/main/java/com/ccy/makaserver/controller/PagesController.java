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

//router.get('/', auth.isAuthenticated(), controller.findByLoginId)
//  router.get('/:id', auth.isAuthenticated(), controller.show)
//  router.post('/', auth.isAuthenticated(), controller.create)
//  router.put('/:id', auth.isAuthenticated(), controller.update)
//  router.patch('/:id', auth.isAuthenticated(), controller.patch)
//  router.delete('/:id', auth.isAuthenticated(), controller.destroy)
@RestController
@RequestMapping("/api")
public class PagesController extends BaseController {
  @Autowired
  private PagesService pagesService;

  @Autowired
  private HttpServletRequest request;

  @GetMapping("/pages")
  private CommonReturnType pages(@RequestParam("type") String type) {
    String loginId = (String) request.getAttribute("loginId");
    List<Pages> pagesList = pagesService.getCurrentUserPage(loginId, type);
    return CommonReturnType.success(pagesList);
  }

  @GetMapping("/pages/{id}")
  private CommonReturnType page(@PathVariable("id") String id) {
    String loginId = (String) request.getAttribute("loginId");
    Pages pages = pagesService.getCurrentPage(loginId, id);
    return CommonReturnType.success(pages);
  }

  @PatchMapping("/pages/{id}")
  private CommonReturnType updatePage(@PathVariable("id") String id,Pages pages) {
    String loginId = (String) request.getAttribute("loginId");
    // todo
    return CommonReturnType.success("TODO");
  }

}
