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
    @Autowired
    FurnitureTypeService furnitureTypeService;


    @GetMapping("/registration")
    public String getRegistry(){
        return "registration";
    }


    @PostMapping("/index")
    public String gtIndex(Model model){
        model.addAttribute("furnitureTypes",furnitureTypeService.findAll());
        model.addAttribute("test","workingHarf") ;
        return "index";
    }
    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("test","pidor");
        return "login";
    }

}
