/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : didwallet

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 05/06/2023 17:55:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for active
-- ----------------------------
DROP TABLE IF EXISTS `active`;
CREATE TABLE `active`  (
  `email` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `id_active` int NOT NULL DEFAULT 0 COMMENT '身份证授权状态，1为授权，0为不授权',
  `st_active` int NOT NULL DEFAULT 0 COMMENT '学籍授权状态',
  `cp_active` int NOT NULL DEFAULT 0 COMMENT '公司授权状态',
  `vc_active` int NOT NULL DEFAULT 0 COMMENT '疫苗授权状态',
  PRIMARY KEY (`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of active
-- ----------------------------
INSERT INTO `active` VALUES ('1234567890@qq.com', 0, 0, 0, 0);
INSERT INTO `active` VALUES ('1234567891@qq.com', 0, 0, 0, 0);
INSERT INTO `active` VALUES ('1234567892@qq.com', 1, 1, 0, 0);

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `id` bigint NOT NULL,
  `email` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名，中文、字母、空格',
  `birthday` date NOT NULL COMMENT '生日',
  `country` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '国家，字母、空格',
  `area` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '地区',
  `speciality` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '专业',
  `university` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学校',
  `enrollment_year` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '入学年份',
  `vaccinum` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '接种疫苗',
  `vaccination_date` date NOT NULL COMMENT '接种日期',
  `location` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '接种地址',
  `company` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT ' 公司',
  `position` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT ' 职位',
  `joined_date` date NOT NULL COMMENT ' 入职日期',
  `did` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES (1658732486496120833, '1234567890@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1990-01-01', 'CHN', 'Shang Hai', '软件工程', '东华大学', '2015', 'Pfizer-BioNTech COVID-19 Vaccine', '2021-09-15', 'Health Center A', 'Baidu', 'Bei Jing', '2021-03-20', 'diddididididididid');
INSERT INTO `information` VALUES (1658760917556514818, '1234567891@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1990-01-01', 'CHN', 'Shang Hai', '软件工程', '东华大学', '2015', 'Pfizer-BioNTech COVID-19 Vaccine', '2021-09-15', 'Health Center A', 'Baidu', 'Bei Jing', '2021-03-20', 'diddididididididid');
INSERT INTO `information` VALUES (1658789985211469826, '1234567892@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '张三', '1990-01-01', 'CHN', 'Shang Hai', '软件工程', '东华大学', '2015', 'Pfizer-BioNTech COVID-19 Vaccine', '2021-09-15', 'Health Center A', 'Baidu', 'Bei Jing', '2021-03-20', 'diddididididididid');

SET FOREIGN_KEY_CHECKS = 1;
