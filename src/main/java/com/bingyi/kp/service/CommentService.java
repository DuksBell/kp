package com.bingyi.kp.service;

import com.bingyi.kp.pojo.Comment;

import java.util.List;

public interface CommentService {

    int insert(Comment comment);

    int deleteByAid(String aid);

    int update(Comment comment);

    List<Comment> selectByComment(Comment comment);

    List<Comment> selectByAll();
}
