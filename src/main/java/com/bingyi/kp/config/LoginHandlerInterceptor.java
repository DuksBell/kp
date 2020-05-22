//package com.bingyi.kp.config;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 登陆成功，应该有用户的Session
//        Object loginUser = request.getSession().getAttribute("userid");
//        System.out.println();
//        System.out.println();
//        if (loginUser == null) { // 没有登录
//            request.setAttribute("msg", "没有权限，请先登录");
//            request.getRequestDispatcher("/toLogin").forward(request, response);
//            return false;
//        } else {
//            return true;
//        }
//    }
//}
