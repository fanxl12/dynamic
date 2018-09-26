package com.fanxl.dynamic.rest;

import com.fanxl.dynamic.entity.User;
import com.fanxl.dynamic.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/26 0026 11:47
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("{username}")
    public String getUser(@PathVariable String username) {
        User user = userService.getByUsername(username);
        if (user == null) {
            log.error("未查找到{}的用户", username);
            return "未查找用户";
        }
        log.error("查找到{}的用户", user.getUsername());
        return user.getUsername();
    }

    @GetMapping("copy/{username}")
    public Boolean copyUser(@PathVariable String username, @RequestParam String as) {
        log.info("as:{}", as);
        return userService.copyData2MainByUsername(username, as);
    }


}
