package com.sangeng.controller;

import com.sangeng.domain.AddArticleDto;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.TagListDto;
import com.sangeng.domain.entity.Article;
import com.sangeng.domain.entity.Tag;
import com.sangeng.domain.vo.TagInfoVo;
import com.sangeng.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 三更  B站： https://space.bilibili.com/663528522
 */
@RestController
@RequestMapping("/content/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article){
        return articleService.add(article);
    }

    @GetMapping("/list")
    public ResponseResult listArticle(Integer pageNum, Integer pageSize,String title){
        return articleService.pageList(pageNum,pageSize,title);
    }
    @GetMapping("/{id}")
    public ResponseResult search(@PathVariable String id){
        Article articleInfoVo= articleService.selectOne(id);
        return ResponseResult.okResult(articleInfoVo);
    }

    @PutMapping
    public ResponseResult updateArticle(@RequestBody Article article){
        articleService.updateById(article);
        return ResponseResult.okResult();
    }
    @DeleteMapping("/{id}")
    public ResponseResult deleteArticle(@PathVariable String id){
        articleService.removeById(id);
        return ResponseResult.okResult();
    }
}
