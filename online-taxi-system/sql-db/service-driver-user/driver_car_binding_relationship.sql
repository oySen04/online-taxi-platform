/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : service-driver-user

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/06/2023 12:50:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for driver_car_binding_relationship
-- ----------------------------
DROP TABLE IF EXISTS `driver_car_binding_relationship`;
CREATE TABLE `driver_car_binding_relationship`  (
  `id` bigint NOT NULL,
  `driver_id` bigint NULL DEFAULT NULL,
  `car_id` bigint NULL DEFAULT NULL,
  `bind_state` int NULL DEFAULT NULL,
  `binding_time` datetime NULL DEFAULT NULL,
  `un_binding_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
