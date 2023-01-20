package com.sangeng.controller;

import com.sangeng.domain.AddArticleDto;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.RoleDto;
import com.sangeng.domain.entity.Article;
import com.sangeng.domain.entity.Role;
import com.sangeng.service.RoleService;
import com.sangeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("system/role")
public class RoleController {
    @Autowired
    public UserService userService;
    @Autowired
    public RoleService roleService;
    @GetMapping("/list")
    public ResponseResult listArticle(Integer pageNum, Integer pageSize, String name){
        return roleService.pageList(pageNum,pageSize,name);
    }
    @GetMapping("/changeStatus")
    public ResponseResult search(@PathVariable("roleId") String roleId,@PathVariable("status") String status){
        roleService.changeStatus(roleId,status);
        return ResponseResult.okResult();
    }
    @GetMapping("/listAllRole")
    public ResponseResult listAll(){
        return userService.listAll();
    }
    @PutMapping
    public ResponseResult updateArticle(@RequestBody Role role){
        roleService.updateById(role);
        return ResponseResult.okResult();
    }
    @DeleteMapping("/{id}")
    public ResponseResult deleteArticle(@PathVariable String id){
        roleService.removeById(id);
        return ResponseResult.okResult();
    }
    @PostMapping
    public ResponseResult add(@RequestBody RoleDto role){
        return roleService.add(role);
    }
}
