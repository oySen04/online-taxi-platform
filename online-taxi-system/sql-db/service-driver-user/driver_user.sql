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

 Date: 02/06/2023 12:50:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for driver_user
-- ----------------------------
DROP TABLE IF EXISTS `driver_user`;
CREATE TABLE `driver_user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `address` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '司机注册地行政区划代码',
  `driver_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '司机姓名',
  `driver_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `driver_gender` tinyint NULL DEFAULT NULL COMMENT '1:男，2：女',
  `driver_birthday` date NULL DEFAULT NULL,
  `driver_nation` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '驾驶员民族',
  `driver_contact_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `license_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机动车驾驶证号',
  `get_driver_license_date` date NULL DEFAULT NULL COMMENT '初次领取驾驶证日期',
  `driver_license_on` date NULL DEFAULT NULL COMMENT '驾驶证有效期起',
  `driver_license_off` date NULL DEFAULT NULL COMMENT '驾驶证有效期止',
  `taxi_driver` tinyint NULL DEFAULT NULL COMMENT '是否巡游出租汽车：1：是，0：否',
  `certificate_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '网络预约出租汽车驾驶员资格证号',
  `network_car_issue_organization` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '网络预约出租汽车驾驶员发证机构',
  `network_car_issue_date` date NULL DEFAULT NULL COMMENT '资格证发证日期',
  `get_network_car_proof_date` date NULL DEFAULT NULL COMMENT '初次领取资格证日期',
  `network_car_proof_on` date NULL DEFAULT NULL COMMENT '资格证有效起始日期',
  `network_car_proof_off` date NULL DEFAULT NULL COMMENT '资格证有效截止日期',
  `register_date` date NULL DEFAULT NULL COMMENT '报备日期',
  `commercial_type` tinyint NULL DEFAULT NULL COMMENT '服务类型：1：网络预约出租汽车，2：巡游出租汽车，3：私人小客车合乘',
  `contract_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '驾驶员合同（协议）签署公司',
  `contract_on` date NULL DEFAULT NULL COMMENT '合同（协议）有效期起',
  `contract_off` date NULL DEFAULT NULL COMMENT '合同有效期止',
  `state` tinyint NULL DEFAULT NULL COMMENT '司机状态：0：有效，1：失效',
  `gmt_create` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1637414047429795843 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
