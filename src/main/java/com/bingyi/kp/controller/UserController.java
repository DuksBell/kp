package com.bingyi.kp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bingyi.kp.pojo.User;
import com.bingyi.kp.service.UserService;
import com.bingyi.kp.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: dusk
 */
@Controller
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/all",method = RequestMethod.POST)
    @ResponseBody
    public String getAll(HttpSession session){
        User loginUser = userService.SelectByName(session.getAttribute("loginUser").toString());
        if(loginUser.getStatus()==1){
            List<User> all = userService.getAll();
            return resultOk("请求成功",all);
        }else{
            return resultError(404,"请求失败");
        }
    }
}
