SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS `springboot-ehcache` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `springboot-ehcache`;

-- ----------------------------
-- Table structure for USER
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(16) NOT NULL COMMENT '用户名称',
  `password` varchar(64) NOT NULL COMMENT '登录密码',
  `realname` varchar(32) NOT NULL COMMENT '真实姓名',
  `sex` varchar(1) NOT NULL COMMENT '性别(0:男 1:女)',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `phone` varchar(15) DEFAULT NULL COMMENT '办公电话',
  `avatar` varchar(32) DEFAULT NULL COMMENT '头像',
  `status` varchar(2) NOT NULL COMMENT '状态(00:正常 11:锁定 55:停用 99:删除)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `update_by` varchar(16) DEFAULT NULL COMMENT '更新人',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_by` varchar(16) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_USER_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
BEGIN;
INSERT INTO `USER` VALUES (1, 'system', '796532d88848e58dc43c074f3a281647bc08ca0d', '超级管理员', '0', 'system@zrcoffee.com', NULL, NULL, NULL, '00', NULL, NULL, NULL, SYSDATE(), 'system');
INSERT INTO `USER` VALUES (2, 'admin', '19ee1f75b9174f927d79c73f810e173f5305d33b', '系统管理员', '0', 'admin@zrcoffee.com', NULL, NULL, NULL, '00', NULL, NULL, NULL, SYSDATE(), 'system');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
