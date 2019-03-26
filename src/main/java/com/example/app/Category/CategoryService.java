package com.example.app.Category;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService {

//    private Category category;

    List<Category> categories = new ArrayList<>(Arrays.asList(
            new Category("Hair"),
            new Category("Skin"),
            new Category("Lip")
    ));

    //Get All Category
    public List getAllCategories(){
        return categories;
    }

    //Add Category
    public String addCategories(Category category){
        categories.add(category);
        return "Add Complete";
    }

    //Remove Category
    public String removeCategories(Category category){
        categories.removeIf(c -> c.getCategoryName().toLowerCase().equals(category.getCategoryName().toLowerCase()));
        return "Remove Complete";
    }


}
