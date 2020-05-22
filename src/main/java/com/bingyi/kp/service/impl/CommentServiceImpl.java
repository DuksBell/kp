package com.bingyi.kp.service.impl;

import com.bingyi.kp.mapper.CommentMapper;
import com.bingyi.kp.pojo.Comment;
import com.bingyi.kp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: dusk
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int insert(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public int deleteByAid(String aid) {
        return commentMapper.deleteByAid(aid);
    }

    @Override
    public int update(Comment comment) {
        return commentMapper.update(comment);
    }

    @Override
    public List<Comment> selectByComment(Comment comment) {
        return commentMapper.selectByComment(comment);
    }

    @Override
    public List<Comment> selectByAll() {
        return commentMapper.selectByAll();
    }
}
