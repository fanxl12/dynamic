package com.fanxl.dynamic.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/26 0026 12:15
 */
@Data
public class FanDataSource {

    private Long id;

    private String name;

    private String url;

    private String username;

    private String password;

    private Date createDate;

    private Date updateDate;

}
