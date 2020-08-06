package com.luojs.bookmanagesystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * spring session配置类
 * @author: luojs
 * @since: 2020/08/05
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

}
