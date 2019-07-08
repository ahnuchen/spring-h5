package com.ccy.makaserver.controller;


import com.ccy.makaserver.document.Pages;
import com.ccy.makaserver.repository.PagesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PagesController extends BaseController{
    @Autowired
    private PagesRepository pagesRepository;


    @RequestMapping("/pages")
    public List<Pages> pagesList(){
        List<Pages> pages = pagesRepository.findAll();
        return pages;
    }

    @RequestMapping("/page")
    public Pages page(@RequestParam(value = "id") String id){
        ObjectId objectId = new ObjectId(id);
        return pagesRepository.findBy_id(objectId);
    }
}
