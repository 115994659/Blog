package com.sangeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangeng.domain.entity.User;
import com.sangeng.domain.vo.UserAndRoleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-01 15:51:17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<UserAndRoleVo> listAll();
}
