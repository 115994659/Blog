package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Article;
import com.sangeng.domain.entity.Category;
import com.sangeng.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }
    @GetMapping("/{id}")
    public ResponseResult search(@PathVariable String id){
        return ResponseResult.okResult(categoryService.getById(id));
    }

    @PutMapping
    public ResponseResult updateArticle(@RequestBody Category article){
        categoryService.updateById(article);
        return ResponseResult.okResult();
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteArticle(@PathVariable String id){
        categoryService.removeById(id);
        return ResponseResult.okResult();
    }
}
