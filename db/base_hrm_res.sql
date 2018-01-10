/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : wdb

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-01-10 14:20:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_hrm_res
-- ----------------------------
DROP TABLE IF EXISTS `base_hrm_res`;
CREATE TABLE `base_hrm_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hrm_name` varchar(100) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_hrm_res
-- ----------------------------
INSERT INTO `base_hrm_res` VALUES ('1', '1111');
INSERT INTO `base_hrm_res` VALUES ('2', '2222');
SET FOREIGN_KEY_CHECKS=1;
