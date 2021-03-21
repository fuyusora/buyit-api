package com.gyh.buyit.controller;

import com.gyh.buyit.annotation.AdminLoginToken;
import com.gyh.buyit.entity.Category;
import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/findCategoryByCategoryId/{categoryId}")
    Category findCategoryByCategoryId(@PathVariable("categoryId") int categoryId){
        return categoryMapper.findCategoryByCategoryId(categoryId);
    }

    @AdminLoginToken
    @RequestMapping("/createCategory")
    int createCategory(@RequestBody Category category){
        return categoryMapper.createCategory(category);
    }

    @RequestMapping("/findAllCategory")
    List<Category> findAllCategory(){
        return categoryMapper.findAllCategory();
    }

    @RequestMapping("/findAllCategoryByPage")
    List<Category> findAllCategoryByPage(@RequestBody ListInfo listInfo){
        return categoryMapper.findAllCategoryByPage(listInfo);
    }

    @AdminLoginToken
    @RequestMapping("/setCategoryInfo")
    int setCategoryInfo(@RequestBody Category category){
        return categoryMapper.setCategoryInfo(category);
    }

    @RequestMapping("/categoryCount")
    int categoryCount(){
        return categoryMapper.categoryCount();
    }

    @AdminLoginToken
    @RequestMapping("/deleteCategoryByCategoryId/{categoryId}")
    int deleteCategoryByCategoryId(@PathVariable("categoryId") int categoryId){
        return categoryMapper.deleteCategoryByCategoryId(categoryId);
    }

}
