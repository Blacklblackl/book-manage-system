package com.luojs.bookmanagesystem.config;

import com.luojs.bookmanagesystem.core.handler.LoginFailureHandler;
import com.luojs.bookmanagesystem.core.handler.LoginSuccessHandler;
import com.luojs.bookmanagesystem.core.LoginValidateAuthenticationProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/**
 * spring security的配置类
 * @author: luojs
 * @since: 2020/8/4
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //自定义认证
    @Resource
    private LoginValidateAuthenticationProvider loginValidateAuthenticationProvider;

    //登录成功handler
    @Resource
    private LoginSuccessHandler loginSuccessHandler;

    //登录失败handler
    @Resource
    private LoginFailureHandler loginFailureHandler;

    /**
     * 权限核心配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //基础设置
        http.httpBasic()//配置HTTP基本身份验证
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()//所有请求都需要认证
                .and()
                .formLogin() //登录表单
                .loginPage("/login")//登录页面url
                .loginProcessingUrl("/login")//登录验证url
                .defaultSuccessUrl("/index")//成功登录跳转
                .successHandler(loginSuccessHandler)//成功登录处理器
                .failureHandler(loginFailureHandler)//失败登录处理器
                .permitAll();//登录成功后有权限访问所有页面

        //关闭csrf跨域攻击防御
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这里要设置自定义认证
        auth.authenticationProvider(loginValidateAuthenticationProvider);
    }

}