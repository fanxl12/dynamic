# 创建数据库fan_main
CREATE DATABASE `fan_main`;
# 数据库fan_main创建表fan_datasource
CREATE TABLE `fan_datasource` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(32) NOT NULL COMMENT '数据库名称',
    `url` VARCHAR(128) NOT NULL COMMENT '数据库地址',
    `username` VARCHAR(32) NOT NULL COMMENT '数据库用户名',
    `password` VARCHAR(32) NOT NULL COMMENT '数据库密码',
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)ENGINE=INNODB DEFAULT CHARSET = utf8mb4 COMMENT '数据源表';

CREATE TABLE `f_user` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(32) NOT NULL COMMENT '用户名',
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)ENGINE=INNODB DEFAULT CHARSET = utf8mb4 COMMENT '用户表';

# 创建数据库fan_001
CREATE DATABASE `fan_001`;
# 数据库fan_001创建表f_user
CREATE TABLE `f_user` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(32) NOT NULL COMMENT '用户名',
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)ENGINE=INNODB DEFAULT CHARSET = utf8mb4 COMMENT '用户表';

# 创建数据库fan_002
CREATE DATABASE `fan_002`;
# 数据库fan_002创建表f_user
CREATE TABLE `f_user` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(32) NOT NULL COMMENT '用户名',
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)ENGINE=INNODB DEFAULT CHARSET = utf8mb4 COMMENT '用户表';

# 创建数据库fan_003
CREATE DATABASE `fan_003`;
# 数据库fan_003创建表f_user
CREATE TABLE `f_user` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(32) NOT NULL COMMENT '用户名',
    `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)ENGINE=INNODB DEFAULT CHARSET = utf8mb4 COMMENT '用户表';

#fan_main导入默认数据
INSERT INTO `fan_datasource` (`name`, `url`, `username`, `password`) VALUES
('fan_001', 'jdbc:mysql://127.0.0.1:3306/fan_001?useUnicode=true&allowMultiQueries=true&useSSL=false', 'root', 'fxl123'),
('fan_002', 'jdbc:mysql://127.0.0.1:3306/fan_002?useUnicode=true&allowMultiQueries=true&useSSL=false', 'root', 'fxl123'),
('fan_003', 'jdbc:mysql://127.0.0.1:3306/fan_003?useUnicode=true&allowMultiQueries=true&useSSL=false', 'root', 'fxl123');

INSERT INTO `f_user` (`username`) VALUES ('main_01'), ('main_02'), ('main_03'), ('main_04');

#fan_001导入默认数据
INSERT INTO `f_user` (`username`) VALUES ('001_01'), ('001_02'), ('001_03'), ('001_04');

#fan_002导入默认数据
INSERT INTO `f_user` (`username`) VALUES ('002_01'), ('002_02'), ('002_03'), ('002_04');

#fan_003导入默认数据
INSERT INTO `f_user` (`username`) VALUES ('003_01'), ('003_02'), ('003_03'), ('003_04');