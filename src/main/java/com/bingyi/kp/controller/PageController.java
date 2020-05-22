package com.bingyi.kp.controller;

import com.bingyi.kp.pojo.Article;
import com.bingyi.kp.pojo.Comment;
import com.bingyi.kp.service.ArticleService;
import com.bingyi.kp.service.CommentService;
import com.bingyi.kp.utils.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 处理页面跳转
 *
 * @author bingyi
 */
@Controller
public class PageController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;

    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        List<Article> pageArticles = articleService.getPageArticles(10, 1);
        Integer articleCount = articleService.getArticleCount();

        Integer pageNum = 1;
        Integer pageSize = 10;
        Integer pageCount = articleCount / pageSize;
        Integer pageBegin = pageNum - 8 < 1 ? 1 : pageNum - 8;
        Integer pageEnd = pageNum + 8 > pageCount ? pageCount : pageNum + 8;

        model.addAttribute("articles", pageArticles);
        model.addAttribute("pageNum", 1);
        model.addAttribute("pageSize", 10);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("pageBegin", pageBegin);
        model.addAttribute("pageEnd", pageEnd);

        return "index";
    }

    /**
     * 跳转到登陆页
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 跳转到后台管理页面
     *
     * @return
     */
    @RequestMapping("/toAdmin")
    public String admin() {
        return "";
    }

    @RequestMapping("/toHelp")
    public String help() {
        return "help";
    }

    @RequestMapping("/toNewMessage")
    public String newMessage() {
        return "new_message";
    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/toResource")
    public String toResource() {
        return "resources";
    }

    @RequestMapping("/toSales")
    public String toSales() {
        return "sales";
    }

    @RequestMapping("/toRegistered")
    public String toRegistered() {
        return "registered";
    }

    @RequestMapping("/toArticleDetail/{articleID}")
    public String toArticleDetail(@PathVariable String articleID, Model model, HttpSession session, HttpServletResponse response) {
//        System.out.println(session.getAttribute("loginUser"));
        Article article = articleService.selectArticleById(Integer.valueOf(articleID));
        Comment comment = new Comment();
        comment.setArticleid(Integer.valueOf(articleID));
        List<Comment> comments = commentService.selectByComment(comment);
        model.addAttribute("article", article);
        model.addAttribute("comments",comments);
        Cookie cookie=new Cookie("JSESSIONID", session.getId());
        response.addCookie(cookie);

        return "article_detail";
    }
}
