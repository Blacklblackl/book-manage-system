package com.luojs.bookmanagesystem.user.dao;

import com.luojs.bookmanagesystem.user.entity.User;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author: luojs
 * @since: 2020/8/4
 */
@Repository
public interface UserDAO {

    User findUserByUsername(String username);

}
