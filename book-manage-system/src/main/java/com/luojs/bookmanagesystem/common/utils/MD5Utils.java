package com.luojs.bookmanagesystem.common.utils;

import org.springframework.util.DigestUtils;

/**
 * MD5加密类
 * @author: luojs
 * @since: 2020/08/05
 */
public class MD5Utils {

    public static String getMd5Simple(String password){
        String md502 = DigestUtils.md5DigestAsHex(password.getBytes());
        return md502;
    }

}
