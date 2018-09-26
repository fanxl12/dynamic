# Spring boot动态创建数据源
> Spring boot + Mybatis + Mysql

***************************
数据源从主库中查询并动态创建和切换

主库中存储其他库的配置信息，用户传入库名，动态创建数据源并切换

关键实现类：

[RoutingDataSource](https://github.com/fanxl12/dynamic/blob/master/src/main/java/com/fanxl/dynamic/datasource/RoutingDataSource.java)

[文件说明](https://blog.csdn.net/fanxl10/article/details/82855439)

