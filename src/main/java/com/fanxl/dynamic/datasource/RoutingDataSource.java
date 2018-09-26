package com.fanxl.dynamic.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.fanxl.dynamic.entity.FanDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.StringUtils;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/26 0026 11:27
 */
@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {

    private JdbcTemplate jdbcTemplate;

    private static Map<Object, Object> dataSources = new HashMap<>();

    public RoutingDataSource() {
        log.info("初始化动态数据源");
        createAndSaveDataSource(RoutingDataSourceContext.getMainKey());

        log.info("创建jdbcTemplate");
        DruidDataSource dataSource = getDruidDataSource("fan_main");
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String currentAccountSuit = RoutingDataSourceContext.getDataSourceRoutingKey();
        if (StringUtils.isEmpty(currentAccountSuit)) {
            currentAccountSuit = RoutingDataSourceContext.getMainKey();
        }
        log.info("当前操作账套:{}", currentAccountSuit);
        if (!dataSources.containsKey(currentAccountSuit)){
           log.info("{}数据源不存在, 创建对应的数据源", currentAccountSuit);
            createAndSaveDataSource(currentAccountSuit);
        } else {
            log.info("{}数据源已存在不需要创建", currentAccountSuit);
        }
        log.info("切换到{}数据源", currentAccountSuit);
        return currentAccountSuit;
    }

    private synchronized void createAndSaveDataSource(String currentAccountSuit) {
        DruidDataSource dataSource = createDataSource(currentAccountSuit);
        log.info("{}数据源创建成功", currentAccountSuit);
        dataSources.put(currentAccountSuit, dataSource);
        super.setTargetDataSources(dataSources);
        afterPropertiesSet();
    }

    /**
     * 创建数据源
     * @param currentAccountSuit
     * @return
     */
    private DruidDataSource createDataSource(String currentAccountSuit) {
        FanDataSource fanDataSource;
        if (currentAccountSuit.equalsIgnoreCase("fan_main")) {
            fanDataSource = new FanDataSource();
            fanDataSource.setName("fan_main");
            fanDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/fan_main?useUnicode=true&allowMultiQueries=true&useSSL=false");
            fanDataSource.setUsername("root");
            fanDataSource.setPassword("fxl421125");
        } else {
            fanDataSource = getFanDataSource(currentAccountSuit);
        }
        if (fanDataSource == null) {
            throw new InvalidParameterException("账套不存在");
        }
        return createDruidDataSource(fanDataSource);
    }

    /**
     * 通过jdbc从数据库中查找数据源配置
     * @param name
     * @return
     */
    private FanDataSource getFanDataSource(String name) {
        String sql = "select name, url, username, password from fan_datasource where name = ?";
        RowMapper<FanDataSource> rowMapper = new BeanPropertyRowMapper<>(FanDataSource.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, name);
    }

    /**
     * 根据配置创建DruidDataSource
     * @param fanDataSource
     * @return
     */
    public static DruidDataSource createDruidDataSource(FanDataSource fanDataSource) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setName(fanDataSource.getName());
        dataSource.setUrl(fanDataSource.getUrl());
        dataSource.setUsername(fanDataSource.getUsername());
        dataSource.setPassword(fanDataSource.getPassword());

        dataSource.setInitialSize(2);
        // 从池中取得链接时做健康检查，该做法十分保守
        dataSource.setTestOnBorrow(true);
        // 如果连接空闲超过1小时就断开
        dataSource.setMinEvictableIdleTimeMillis(1 * 60000 * 60);
        // 每十分钟验证一下连接
        dataSource.setTimeBetweenEvictionRunsMillis(600000);
        // 运行ilde链接测试线程，剔除不可用的链接
        dataSource.setTestWhileIdle(true);
        dataSource.setMaxWait(-1);
        return dataSource;
    }

    /**
     * 通过账套获取DruidDataSource
     * @param currentAccountSuit
     * @return
     */
    public static DruidDataSource getDruidDataSource(String currentAccountSuit) {
        return (DruidDataSource) dataSources.get(currentAccountSuit);
    }


}
