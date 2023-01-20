package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Link;
import com.sangeng.domain.entity.Menu;
import com.sangeng.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("system/menu")
public class MenuController {
    @Autowired
    public MenuService menuService;

    @GetMapping("/list")
    public ResponseResult listAll(String menuName){

        return  menuService.listAll(menuName);
    }

    @PostMapping
    public ResponseResult add(@RequestBody Menu menu){
        menuService.save(menu);
        return ResponseResult.okResult();
    }
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable String id){
        menuService.removeById(id);
        return ResponseResult.okResult();
    }

    @GetMapping("/{id}")
    public ResponseResult search(@PathVariable String id){
        Menu tagInfoVo= menuService.getById(id);
        return ResponseResult.okResult(tagInfoVo);
    }

    @PutMapping
    public ResponseResult updateTag(@RequestBody Menu menu){
        menuService.updateById(menu);
        return ResponseResult.okResult();
    }
}
