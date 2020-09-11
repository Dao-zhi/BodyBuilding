/*
Navicat MySQL Data Transfer

Source Server         : blog
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : bodybuilding

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-09-11 22:15:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `lastlogintime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `apparatus`
-- ----------------------------
DROP TABLE IF EXISTS `apparatus`;
CREATE TABLE `apparatus` (
  `appid` int(20) NOT NULL,
  `aname` int(20) NOT NULL,
  `astate` int(2) NOT NULL,
  `bstate` int(20) NOT NULL,
  `account` int(10) DEFAULT NULL,
  PRIMARY KEY (`appid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apparatus
-- ----------------------------

-- ----------------------------
-- Table structure for `authority`
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` int(20) NOT NULL,
  `authority` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` varchar(20) NOT NULL,
  `cid` varchar(20) NOT NULL,
  `cname` varchar(20) NOT NULL,
  `tid` int(20) NOT NULL,
  `uid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `sid` int(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `age` int(10) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `salary` int(10) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------

-- ----------------------------
-- Table structure for `teach`
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach` (
  `tid` int(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `salary` int(10) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teach
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `account` int(2) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `time` int(10) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `wardrobe`
-- ----------------------------
DROP TABLE IF EXISTS `wardrobe`;
CREATE TABLE `wardrobe` (
  `id` varchar(20) NOT NULL,
  `state` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wardrobe
-- ----------------------------
