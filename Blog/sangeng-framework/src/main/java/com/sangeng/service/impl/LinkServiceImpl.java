package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.constants.SystemConstants;
import com.sangeng.domain.entity.Article;
import com.sangeng.domain.entity.Link;
import com.sangeng.domain.vo.LinkVo;
import com.sangeng.domain.vo.PageVo;
import com.sangeng.mapper.LinkMapper;
import com.sangeng.service.LinkService;
import com.sangeng.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2023-01-01 13:38:59
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {

            //查询所有审核通过的
            LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
            List<Link> links = list(queryWrapper);
            //转换成vo
            List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);
            //封装返回
            return ResponseResult.okResult(linkVos);

    }

    @Override
    public ResponseResult pageList(Integer pageNum, Integer pageSize, String name) {
        LambdaQueryWrapper<Link> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(name),Link::getName,name);
        Page<Link> articlePage = new Page<>();
        articlePage.setCurrent(pageNum);
        articlePage.setSize(pageSize);
        page(articlePage, queryWrapper);
        PageVo pageVo = new PageVo(articlePage.getRecords(),articlePage.getTotal());
        return ResponseResult.okResult(pageVo);

    }
}

