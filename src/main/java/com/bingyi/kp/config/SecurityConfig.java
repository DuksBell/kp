//package com.bingyi.kp.config;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * SpringSecurity 配置类
// * AOP：拦截器
// * @author bingyi
// */
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    /**
//     * http的安全策略
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 首页所有人可以访问，但是功能页只有对应有权限的人才能访问
//        // 请求授权的规则（链式编程）
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/admin/**").hasRole("admin");
//        // 没有权限默认会到登录页，需要开启登录的页面
//        http.formLogin();
//
//        // 注销，开启了注销功能，且注销之成功后回到登录页
//        http.logout().logoutSuccessUrl("/");
//    }
//
//    /**
//     * 认证
//     * springboot2.1.x及以前可以使用
//     * 现在的2.2.1就不一定能用了
//     *      密码编码：PasswordEncoder
//     *      在 SpringSecurity 5.0+ 中新增了很多的加密方式
//     *          使用 .passwordEncoder(xxx) 指定加密方式
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("bingyi").password(new BCryptPasswordEncoder().encode("123456")).roles("admin", "vip")
//                .and()
//                .withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("admin", "root")
//                .and()
//                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("guest");
//    }
//}
