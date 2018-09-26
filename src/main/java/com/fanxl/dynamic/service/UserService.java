package com.fanxl.dynamic.service;

import com.fanxl.dynamic.entity.User;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/26 0026 11:46
 */
public interface UserService {

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    User getByUsername(String username);

    /**
     * 复制主库的用户到指定库
     * @param username
     * @param as
     * @return
     */
    boolean copyData2MainByUsername(String username, String as);

}
