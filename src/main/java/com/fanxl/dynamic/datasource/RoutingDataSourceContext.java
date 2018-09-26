package com.fanxl.dynamic.datasource;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/26 0026 12:10
 */
public class RoutingDataSourceContext  {

    static final ThreadLocal<String> threadLocalDataSourceKey = new ThreadLocal<>();

    /**
     * 获取主数据库的key
     * @return
     */
    public static String getMainKey() {
        return "fan_main";
    }

    /**
     * 获取数据库key
     * @return
     */
    public static String getDataSourceRoutingKey() {
        String key = threadLocalDataSourceKey.get();
        return key == null ? getMainKey() : key;
    }

    /**
     * 设置数据库的key
     * @param key
     */
    public static void setThreadLocalDataSourceKey(String key) {
        threadLocalDataSourceKey.set(key);
    }

}
