package com.bingyi.kp.controller;

import com.bingyi.kp.pojo.Article;
import com.bingyi.kp.pojo.User;
import com.bingyi.kp.service.ArticleService;
import com.bingyi.kp.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.UUID;

/**
 * 处理用户登录
 * @author bingyi
 */
@Controller
public class LoginController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/user/login")
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model,
                            HttpSession session,
                            HttpServletResponse response) {

        // 检查用户名和密码
        User user = userService.SelectByName(username);
        if(!StringUtils.isEmpty(username) && user!=null&&password.equals(user.getPwd())) {
            // 登录成功，跳转主页
            session.setAttribute("userid",user.getId());
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

            System.out.println(username);
            session.setAttribute("loginUser", username);

//            System.out.println("login # " + session.getId());

            return "index";
        } else {
            // 登录失败，告诉用户
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        return "login";
    }

    @PostMapping("/user/resgister")
    public String resgister(User user,Model model){
        if(user!=null){
            user.setId(UUID.randomUUID().toString());
            user.setStatus(0);
            User user1 = userService.SelectByName(user.getName());
            if(user1==null){
                int insert = userService.insert(user);
                return "login";
            }else{
                model.addAttribute("msg","账号重复");
                return "registered";
            }
        }
        return "registered";
    }
}
