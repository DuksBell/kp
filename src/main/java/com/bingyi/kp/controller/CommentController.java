package com.bingyi.kp.controller;

import com.bingyi.kp.pojo.Comment;
import com.bingyi.kp.service.CommentService;
import com.bingyi.kp.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author: dusk
 */
@Controller
public class CommentController extends BaseController {

    @Autowired
    public CommentService commentService;

    @PostMapping("/comment/add")
    @CrossOrigin
    @ResponseBody
    public String addComment(Comment comment,HttpSession session){
        System.out.println(comment);
        String uuid = UuidUtils.getUuid();
        comment.setAid(uuid);
        comment.setCtime(new Date());
//        HttpSession session = request.getSession();
//        System.out.println("comment_add # " + session.getId());
//        System.out.println(session.getAttribute("loginUser"));
        System.out.println(comment);
        commentService.insert(comment);
        Comment comment1 = new Comment();
        comment1.setArticleid(comment.getArticleid());
        List<Comment> comments = commentService.selectByComment(comment1);
        return resultOk("评论保存成功",comments);
    }
}
