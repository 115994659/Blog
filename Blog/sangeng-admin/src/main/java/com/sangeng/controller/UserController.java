package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.RoleDto;
import com.sangeng.domain.entity.Article;
import com.sangeng.domain.entity.Category;
import com.sangeng.domain.entity.Role;
import com.sangeng.domain.entity.User;
import com.sangeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("system/user")
public class UserController {
    @Autowired
    public UserService userService;
    @GetMapping("/list")
    public ResponseResult listArticle(Integer pageNum, Integer pageSize, String userName){
        return userService.pageList(pageNum,pageSize,userName);
    }

    @PostMapping
    public ResponseResult add(@RequestBody User role){
        userService.save(role);
        return ResponseResult.okResult();
    }
    @PutMapping
    public ResponseResult updateArticle(@RequestBody User user){
        userService.updateById(user);
        return ResponseResult.okResult();
    }
    @DeleteMapping("/{id}")
    public ResponseResult deleteArticle(@PathVariable String id){
        userService.removeById(id);
        return ResponseResult.okResult();
    }
    @GetMapping("/{id}")
    public ResponseResult search(@PathVariable String id){
        User tagInfoVo= userService.getById(id);
        return ResponseResult.okResult(tagInfoVo);
    }
}
