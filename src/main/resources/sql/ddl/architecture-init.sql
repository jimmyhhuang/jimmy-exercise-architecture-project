--  创建项目数据库
create database architecture_project_db;
use architecture_project_db;
-- 优化后的建表语句
CREATE TABLE user_info (
                           user_id      VARCHAR(64)   NOT NULL COMMENT '用户ID',
                           username     VARCHAR(100)  NOT NULL COMMENT '用户名',
                           age          TINYINT UNSIGNED NULL COMMENT '年龄',
                           gender       TINYINT(1)    NULL COMMENT '性别: 0-女, 1-男, 2-未知',
                           remark       VARCHAR(255)  NULL COMMENT '备注',
                           create_time  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           create_id    VARCHAR(64)   NULL COMMENT '创建人ID',
                           update_time  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                           update_id    VARCHAR(64)   NULL COMMENT '更新人ID',
                           enabled      TINYINT(1)    NOT NULL DEFAULT 1 COMMENT '启用状态: 1-启用, 0-禁用',

                           PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';
