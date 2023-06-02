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

 Date: 02/06/2023 12:50:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `address` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆所在城市',
  `vehicle_no` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆号牌',
  `plate_color` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车牌颜色（1：蓝色，2：黄色，3：黑色，4：白色，5：绿色，9：其他）',
  `seats` int NULL DEFAULT NULL COMMENT '核定载客位',
  `brand` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆厂牌',
  `model` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆型号',
  `vehicle_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆类型',
  `owner_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆所有人',
  `vehicle_color` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆颜色（1：白色，2：黑色）',
  `engine_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发动机号',
  `vin` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `certify_date_a` date NULL DEFAULT NULL COMMENT '车辆注册日期',
  `fue_type` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '燃料类型(1：汽油，2：柴油，3：天然气，4：液化气，5：电动，9：其他）',
  `engine_displace` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发动机排量（毫升）',
  `trans_agency` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆运输证发证机构',
  `trans_area` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆经验区域',
  `trans_date_start` date NULL DEFAULT NULL COMMENT '车辆运输证有效期起',
  `trans_date_end` date NULL DEFAULT NULL COMMENT '车辆运输证有效期止',
  `certify_date_b` date NULL DEFAULT NULL COMMENT '车辆初次登记日期',
  `fix_state` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆的检修状态(0：未检修，1：已检修，2：未知）',
  `next_fix_date` date NULL DEFAULT NULL COMMENT '下次年检时间',
  `check_state` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '年度审验状态（0：未年审，1：年审合格，2：年审不合格）',
  `fee_print_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发票打印设备序列号',
  `gps_brand` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卫星定位装置品牌',
  `gps_model` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卫星型号',
  `gps_install_date` date NULL DEFAULT NULL COMMENT '卫星定位设备安装日期',
  `register_date` date NULL DEFAULT NULL COMMENT '报备日期',
  `commercial_type` int NULL DEFAULT NULL COMMENT '服务类型：1：网络预约出租车，2：巡游出租车，3：私人小客车合乘',
  `fare_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '运价编码 关联计价规则',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '状态：0:有效，1：失效',
  `tid` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '终端Id',
  `trid` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '轨迹ID',
  `trname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '轨迹名称',
  `gmt_create` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1637412208978272259 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
