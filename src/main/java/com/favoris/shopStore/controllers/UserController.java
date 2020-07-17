package com.favoris.shopStore.controllers;

import com.favoris.shopStore.entity.FurnitureType;
import com.favoris.shopStore.service.FurnitureTypeService;
import com.favoris.shopStore.service.FurnituresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    FurnitureTypeService furnitureTypeService;
    @Autowired
    FurnituresService furnituresService;


    @PostMapping("/index")
    public String gtIndex(Model model){
        model.addAttribute("furnitureTypes",furnitureTypeService.findAll());
        return "index";
    }

//    @GetMapping("/getFurnitureByTypeId-{id}")
//    public String getFurnitureByTypeId(@PathVariable("id") int id, Model model){
//        FurnitureType furnitureType = furnitureTypeService.findById(id);
//
//        return "redirect:/admin/allFurnitureTypes";
//    }
}
