package com.ccy.makaserver.service;


import com.ccy.makaserver.document.Pages;
import com.ccy.makaserver.repository.PagesRepository;
import com.ccy.makaserver.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagesService {
  @Autowired
  private PagesRepository pagesRepository;

  public List<Pages> getCurrentUserPage(String loginUserId, String type){
    List<Pages> pages  = pagesRepository.findByLoginIdAndType(loginUserId,type);
    return pages;
  }

  public Pages getCurrentPage(String loginId, String id){
    Pages pages = pagesRepository.findPagesByLoginIdAnd_id(loginId,id);
    return pages;
  }

  public void updatePage(String loginId){
  }
}
