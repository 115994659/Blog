package com.sangeng.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVo {

    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;
    //所属分类名
    private String categoryName;
    private Long categoryId;
    //缩略图
    private String thumbnail;

    private String content;
    //访问量
    private Long viewCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
