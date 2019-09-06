package com.ccy.makaserver.service;


import com.ccy.makaserver.document.Pages;
import com.ccy.makaserver.repository.PagesRepository;
import com.ccy.makaserver.response.CommonReturnType;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagesService {
  @Autowired
  private PagesRepository pagesRepository;

  public List<Pages> getCurrentUserPage(String loginUserId, String type) {
    List<Pages> pages = pagesRepository.findByLoginIdAndType(loginUserId, type);
    return pages;
  }

  public Pages getCurrentPage(String loginId, String id) {
    Pages pages = pagesRepository.findBy_idAndLoginId(new ObjectId(id), loginId);
    return pages;
  }

  public Pages updatePage(String id, String loginId, Pages page) {
    Pages currentPage = pagesRepository.findBy_idAndLoginId(new ObjectId(id), loginId);
    Pages savedPage = new Pages();
    if(currentPage != null){
       savedPage = pagesRepository.save(page);
    }
    return savedPage;
  }

  public Pages createPage(Pages pages){
    Pages p = pagesRepository.save(pages);
    return p;
  }

  public void deletePage (String id,String loginId){
    pagesRepository.deleteBy_idAndLoginId(id, loginId);
  }


  private void renderFile (Pages page){

  }
}
