package com.favoris.shopStore.controllers;

import com.favoris.shopStore.entity.User;
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
//    @GetMapping("/")
//    public String index(){
//        return "login";
//    }

    @Autowired
    UserService userService;
    @GetMapping("/registration")
    public String getRegistry(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addNewUser(User user, Map<String,Object> model){
        User userFromDB = userService.selectByUsername(user.getUsername());
        if(userFromDB!=null){
            model.put("message","User alredy exists!");
            return "registration";
        }

        user.setActive(true);
        userService.save(user);


        return "redirect:/";
    }

    @PostMapping("/index")
    public String gtIndex(Model model){
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
    @GetMapping("/adminPage")
    public String getAdminPage(){
        return "adminPage";
    }
//    @PostMapping("/login")
//    public String postLogin(Model model){
////        System.out.println(model.getAttribute("error").toString());
////        if (model.getAttribute("error")!=null){
////            model.addAttribute("errorMessage","Something wrong! Check your data.");
////        }
//        return "redirect:/login";
//    }
}
