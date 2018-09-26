package com.fanxl.dynamic.service.impl;

import com.fanxl.dynamic.dao.UserDao;
import com.fanxl.dynamic.datasource.RoutingDataSourceContext;
import com.fanxl.dynamic.entity.User;
import com.fanxl.dynamic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/26 0026 11:46
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public boolean copyData2MainByUsername(String username, String as) {
        RoutingDataSourceContext.setThreadLocalDataSourceKey(null);
        User user = getByUsername(username);
        RoutingDataSourceContext.setThreadLocalDataSourceKey("fan_001");
        return userDao.createUser(user)>0;
    }
}
