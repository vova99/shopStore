package com.favoris.shopStore.controllers;

import com.favoris.shopStore.entity.FurnitureType;
import com.favoris.shopStore.entity.User;
import com.favoris.shopStore.service.FurnitureTypeService;
import com.favoris.shopStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Map;
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    FurnitureTypeService furnitureTypeService;


    @GetMapping("/adminPage")
    public String getAdminPage(){
        return "adminPage";
    }


//    USER CONTROLLERS
    @GetMapping("/allUsers")
    public String getAdminPage(Model model){
        model.addAttribute("users",userService.findAll());
        model.addAttribute("fragmentPathUser","allUsers");
        return "adminPage";
    }

    @GetMapping("/changeUser-{id}")
    public String changeUser(@PathVariable("id") int id, User user, Model model){
        User userDB = userService.findById(id);
        model.addAttribute("usr",userDB);
        model.addAttribute("fragmentPathUser","changeUser");
        return "adminPage";
    }
    @PostMapping("/changeUser")
    public String changeUser(User usr){
        User userDB = userService.findById(usr.getId());
        userDB.setFirstName(usr.getFirstName());
        userDB.setSecondName(usr.getSecondName());
        userDB.setPassword(usr.getPassword());
        userDB.setUsername(usr.getUsername());
        userService.save(userDB);
        return "redirect:/admin/allUsers";
    }

    @GetMapping("/deleteUser-{id}")
    public String deleteUser(@PathVariable("id") int id, Model model){
        userService.deleteByID(id);
        return "redirect:/admin/allUsers";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("fragmentPathUser","addUser");
        return "adminPage";
    }

    @PostMapping("/addUser")
    public String addNewUser(User user, Map<String,Object> model){
        User userFromDB = userService.selectByUsername(user.getUsername());
        if(userFromDB!=null){
            model.put("message","User alredy exists!");
            return "registration";
        }

        user.setActive(true);
        userService.save(user);
        return "redirect:/admin/addUser";
    }

    //  FURNITURE TYPE CONTROLLERS

    @GetMapping("/allFurnitureTypes")
    public String allFurnitureTypes(Model model){
        model.addAttribute("furnitureTypes",furnitureTypeService.findAll());
        model.addAttribute("fragmentPathFurnitureType","allFurnitureType");
        return "adminPage";
    }

    @PostMapping("/addFurnitureType")
    public String addFurnitureTypes(FurnitureType ft ,Model model, @RequestParam MultipartFile photo) throws IOException {
        String path = System.getProperty("user.home")+ File.separator;
        photo.transferTo(new File(path+photo.getOriginalFilename()));
        ft.setPhotoPath("/img/"+photo.getOriginalFilename());
        furnitureTypeService.save(ft);
        return "redirect:/admin/allFurnitureTypes";
    }
    @GetMapping("/deleteFurnitureType-{id}")
    public String deleteFurnitureType(@PathVariable("id") int id, Model model){
        furnitureTypeService.deleteByID(id);
        return "redirect:/admin/allFurnitureTypes";
    }

}
