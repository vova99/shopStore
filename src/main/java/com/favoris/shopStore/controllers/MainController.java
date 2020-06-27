package com.favoris.shopStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
//    @GetMapping("/")
//    public String index(){
//        return "login";
//    }
    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("test","pidor");
        return "login";
    }
}
