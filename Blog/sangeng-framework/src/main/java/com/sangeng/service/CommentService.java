package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.domain.ResponseResult;
import com.sangeng.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2023-01-02 10:17:30
 */
public interface CommentService extends IService<Comment> {

   ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);;

    ResponseResult addComment(Comment comment);
}
