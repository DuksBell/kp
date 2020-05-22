package com.bingyi.kp.mapper;

import com.bingyi.kp.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    int insert(Comment comment);

    int deleteByAid(String aid);

    int update(Comment comment);

    List<Comment> selectByComment(Comment Comment);

    List<Comment> selectByAll();
}
