package com.favoris.shopStore.controllers;

import com.favoris.shopStore.entity.User;
import com.favoris.shopStore.service.FurnitureTypeService;
import com.favoris.shopStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MainController {


    @Autowired
    UserService userService;


    @GetMapping("/")
    public String getMainPage(){
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistry(){
        return "registration";
    }



    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        return "login";
    }

}
