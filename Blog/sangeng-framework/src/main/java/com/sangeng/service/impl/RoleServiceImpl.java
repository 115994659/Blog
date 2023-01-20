package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.RoleDto;
import com.sangeng.domain.entity.Article;
import com.sangeng.domain.entity.Role;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.mapper.RoleMapper;
import com.sangeng.service.RoleService;
import com.sangeng.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2023-01-05 10:52:19
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<String> selectRoleKeyByUserId(Long id) {
        //判断是否是管理员 如果是返回集合中只需要有admin
        if(id == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }
        //否则查询用户所具有的角色信息
        return getBaseMapper().selectRoleKeyByUserId(id);
    }

    @Override
    public ResponseResult pageList(Integer pageNum, Integer pageSize, String name) {
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleLambdaQueryWrapper.like(StringUtils.hasText(name), Role::getRoleName,name);
        Page<Role> articlePage = new Page<>();
        articlePage.setCurrent(pageNum);
        articlePage.setSize(pageSize);
        page(articlePage, roleLambdaQueryWrapper);
        PageVo pageVo = new PageVo(articlePage.getRecords(),articlePage.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public void changeStatus(String roleId, String status) {
        Role role = new Role();
        role.setStatus(status);
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleLambdaQueryWrapper.eq(Role::getId,roleId);
        this.update(role,roleLambdaQueryWrapper);
    }

    @Override
    public ResponseResult add(RoleDto role) {
        Role newRole=BeanCopyUtils.copyBean(role,Role.class);
        save(newRole);

        return null;
    }


}

