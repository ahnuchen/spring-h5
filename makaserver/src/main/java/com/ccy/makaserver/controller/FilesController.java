package com.ccy.makaserver.controller;


import com.ccy.makaserver.document.Files;
import com.ccy.makaserver.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilesController extends BaseController{
    @Autowired
    private FilesRepository filesRepository;

    @RequestMapping("/files")
    public List<Files> files() {
        List<Files> files = filesRepository.findAll();
        return files;
    }
}
