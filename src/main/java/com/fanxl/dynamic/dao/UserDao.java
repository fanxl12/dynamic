package com.fanxl.dynamic.dao;

import com.fanxl.dynamic.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/26 0026 11:43
 */
@Repository
public interface UserDao {

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    User getByUsername(String username);

    /**
     * 创建用户
     * @param user
     * @return
     */
    int createUser(User user);

}
