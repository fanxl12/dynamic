package com.fanxl.dynamic.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/26 0026 16:37
 */
public class RoutingDataSource1 extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }
}
