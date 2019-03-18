package com.demo.cosmetic.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/category")
    public List getAllCategory(){return categoryService.getAllCategories();}

    // Add Category
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String addCategories(@RequestBody String cate){
        return categoryService.addCategories(new Category(cate));
    }

    // Remove Category
    @RequestMapping(value = "/category", method = RequestMethod.DELETE)
    public String removeCategories(@RequestBody String cate){
        return categoryService.removeCategories(new Category(cate));
    }

}
