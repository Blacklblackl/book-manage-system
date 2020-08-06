package com.luojs.bookmanagesystem.core;

import com.luojs.bookmanagesystem.user.entity.User;
import com.luojs.bookmanagesystem.user.service.UserService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import com.luojs.bookmanagesystem.common.utils.MD5Utils;

import javax.annotation.Resource;

/**
 * 登录验证类
 * @author: luojs
 * @since: 2020/8/4
 */
@Component
public class LoginValidateAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //获取输入的用户名
        String username = authentication.getName();
        //获取输入的明文
        String rawPassword = (String) authentication.getCredentials();
        //将密码用MD5加密
        String md5Password = MD5Utils.getMd5Simple(rawPassword);

        //查询用户是否存在
        User user = (User) userService.loadUserByUsername(username);

        if (!user.isEnabled()) {
            throw new DisabledException("该账户已被禁用，请联系管理员");

        } else if (!user.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定");

        } else if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期，请联系管理员");

        } else if (!user.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("该账户的登录凭证已过期，请重新登录");
        }

        String userPassword = user.getPassword();
        //验证密码
        if (!md5Password.equals(user.getPassword())) {
            throw new BadCredentialsException("输入密码错误!");
        }

        return new UsernamePasswordAuthenticationToken(user, rawPassword, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //确保authentication能转成该类
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
