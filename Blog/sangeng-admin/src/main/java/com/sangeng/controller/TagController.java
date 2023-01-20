package com.sangeng.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.TagListDto;
import com.sangeng.domain.entity.Article;
import com.sangeng.domain.entity.Tag;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.domain.vo.TagInfoVo;
import com.sangeng.domain.vo.TagVo;
import com.sangeng.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/content/tag")
public class TagController {
    @Autowired
    private   TagService tagService;


    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }

    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        List<TagVo> list = tagService.listAllTag();
        return ResponseResult.okResult(list);
    }
    @PostMapping
    public ResponseResult add(@RequestBody Tag tag){
        tagService.save(tag);
        return ResponseResult.okResult();
    }
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable String id){
        tagService.removeById(id);
        return ResponseResult.okResult();
    }

    @GetMapping("/{id}")
    public ResponseResult search(@PathVariable String id){
       TagInfoVo tagInfoVo= tagService.selectOne(id);
        return ResponseResult.okResult(tagInfoVo);
    }

    @PutMapping
    public ResponseResult updateTag(@RequestBody Tag tag){
        tagService.updateById(tag);
        return ResponseResult.okResult();
    }
}

