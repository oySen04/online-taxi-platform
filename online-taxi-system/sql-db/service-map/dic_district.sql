/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : service-map

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/06/2023 13:38:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dic_district
-- ----------------------------
DROP TABLE IF EXISTS `dic_district`;
CREATE TABLE `dic_district`  (
  `address_code` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地区编码',
  `address_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地区名称',
  `parent_address_code` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父地区编码',
  `level` tinyint NULL DEFAULT NULL COMMENT '级别',
  PRIMARY KEY (`address_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
