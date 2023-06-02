/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : service-passenger-user

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/06/2023 13:39:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for passenger_user
-- ----------------------------
DROP TABLE IF EXISTS `passenger_user`;
CREATE TABLE `passenger_user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NULL DEFAULT NULL,
  `gmt_modified` datetime NULL DEFAULT NULL,
  `passenger_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `passenger_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `passenger_gender` tinyint(1) NULL DEFAULT NULL COMMENT '0：未知，1：男，2：女',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '0：成功，1：失败',
  `profile_photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像url地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1664505547514707970 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
