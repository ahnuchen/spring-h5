/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : h5maker

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 07/08/2019 00:24:14 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `element`
-- ----------------------------
DROP TABLE IF EXISTS `element`;
CREATE TABLE `element` (
  `eid` varchar(128) NOT NULL,
  `page_id` int(11) NOT NULL,
  `zindex` int(11) NOT NULL DEFAULT '0',
  `color` varchar(16) NOT NULL DEFAULT '',
  `font_weight` varchar(16) NOT NULL DEFAULT '',
  `bg` varchar(16) NOT NULL DEFAULT '',
  `icon_key` varchar(16) NOT NULL DEFAULT '',
  `text_align` varchar(16) NOT NULL DEFAULT '',
  `text` varchar(2048) NOT NULL DEFAULT '',
  `transform` int(11) NOT NULL DEFAULT '0',
  `opacity` int(11) NOT NULL DEFAULT '0',
  `loop` tinyint(4) NOT NULL DEFAULT '0',
  `playing` tinyint(4) NOT NULL DEFAULT '0',
  `delay` int(11) NOT NULL DEFAULT '0',
  `duration` int(11) NOT NULL DEFAULT '0',
  `animated_name` varchar(255) NOT NULL DEFAULT '',
  `line_height` double NOT NULL,
  `height` double NOT NULL,
  `width` double NOT NULL,
  `top` int(11) NOT NULL,
  `left` int(11) NOT NULL,
  `video_src` varchar(256) NOT NULL,
  `img_src` varchar(256) NOT NULL,
  `type` varchar(16) NOT NULL COMMENT '文件类型video/pic',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `fid` varchar(255) NOT NULL,
  `page_id` int(11) NOT NULL,
  `file_path` varchar(255) NOT NULL DEFAULT '',
  `file_type` varchar(255) NOT NULL,
  `width` double NOT NULL,
  `height` double NOT NULL,
  `created_at` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `page`
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL COMMENT '页面标题',
  `description` varchar(512) NOT NULL COMMENT '页面描述',
  `user_id` int(11) NOT NULL COMMENT '页面的所有者',
  `type` varchar(32) NOT NULL COMMENT '页面类型h5/spa',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
  `mobile` varchar(11) NOT NULL COMMENT '手机号，可以用于登录',
  `role_id` int(11) NOT NULL DEFAULT '1' COMMENT '用户角色id',
  `encrypt_pwd` varchar(128) NOT NULL DEFAULT '',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL DEFAULT '' COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_role`
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES ('1', '普通用户'), ('2', '管理员'), ('3', '系统管理员');
COMMIT;

-- ----------------------------
--  Table structure for `user_token`
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) NOT NULL DEFAULT '',
  `expire_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
