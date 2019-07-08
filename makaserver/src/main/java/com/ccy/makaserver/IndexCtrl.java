package com.ccy.makaserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexCtrl {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
