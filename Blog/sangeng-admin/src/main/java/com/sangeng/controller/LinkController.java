package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Link;
import com.sangeng.domain.entity.Tag;
import com.sangeng.domain.vo.TagInfoVo;
import com.sangeng.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content/link")
public class LinkController {
    @Autowired
    public LinkService linkService;
    @GetMapping("/list")
    public ResponseResult listAll(Integer pageNum, Integer pageSize,String name){
        return linkService.pageList(pageNum,pageSize,name);
    }
    @PostMapping
    public ResponseResult add(@RequestBody Link link){
        linkService.save(link);
        return ResponseResult.okResult();
    }
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable String id){
        linkService.removeById(id);
        return ResponseResult.okResult();
    }

    @GetMapping("/{id}")
    public ResponseResult search(@PathVariable String id){
       Link tagInfoVo= linkService.getById(id);
        return ResponseResult.okResult(tagInfoVo);
    }

    @PutMapping
    public ResponseResult updateTag(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }
}
