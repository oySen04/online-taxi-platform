/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : service-order

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/06/2023 13:38:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `passenger_id` bigint NULL DEFAULT NULL COMMENT '乘客ID',
  `passenger_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '乘客手机号',
  `driver_id` bigint NULL DEFAULT NULL COMMENT '司机ID',
  `driver_phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '司机手机号',
  `car_id` bigint NULL DEFAULT NULL COMMENT '车辆Id',
  `vehicle_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆类型',
  `address` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发起地行政区划代码',
  `order_time` datetime NULL DEFAULT NULL COMMENT '订单发起时间',
  `depart_time` datetime NULL DEFAULT NULL COMMENT '预计用车时间',
  `departure` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计出发地点详细地址',
  `dep_longitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计出发地点经度',
  `dep_latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计出发地点纬度',
  `destination` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计目的地',
  `dest_longitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计目的地经度',
  `dest_latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '预计目的地纬度',
  `encrypt` int NULL DEFAULT NULL COMMENT '坐标加密标识\r\n1:GCJ-02测绘局标准\r\n2:WGS84 GPS标准\r\n3:BD-09 百度标准\r\n4:CGCS2000 北斗标准\r\n0:其他',
  `fare_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '运价类型编码',
  `fare_version` int NULL DEFAULT NULL COMMENT '运价版本号',
  `receive_order_car_longitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接单时车辆经度',
  `receive_order_car_latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接单时车辆纬度',
  `receive_order_time` datetime NULL DEFAULT NULL COMMENT '接单时间，派单成功时间',
  `license_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机动车驾驶证号',
  `vehicle_no` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '车辆号牌',
  `to_pick_up_passenger_time` datetime NULL DEFAULT NULL COMMENT '司机去接乘客出发时间',
  `to_pick_up_passenger_longitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '去接乘客时，司机的经度',
  `to_pick_up_passenger_latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '去接乘客时，司机的纬度',
  `to_pick_up_passenger_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '去接乘客时，司机的地点',
  `driver_arrived_departure_time` datetime NULL DEFAULT NULL COMMENT '司机到达上车点时间',
  `pick_up_passenger_time` datetime NULL DEFAULT NULL COMMENT '接到乘客，乘客上车时间',
  `pick_up_passenger_longitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接到乘客，乘客上车经度',
  `pick_up_passenger_latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接到乘客，乘客上车纬度',
  `passenger_getoff_time` datetime NULL DEFAULT NULL COMMENT '乘客下车时间',
  `passenger_getoff_longitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '乘客下车经度',
  `passenger_getoff_latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '乘客下车纬度',
  `cancel_time` datetime NULL DEFAULT NULL COMMENT '订单撤销时间',
  `cancel_operator` int NULL DEFAULT NULL COMMENT '撤销发起者：1:乘客\r\n2:驾驶员\r\n3:平台公司',
  `cancel_type_code` int NULL DEFAULT NULL COMMENT '撤销类型代码\r\n1:乘客提前撤销\r\n2:驾驶员提前撤销\r\n3:平台公司撤销\r\n4;乘客违约撤销\r\n5:驾驶员违约撤销',
  `drive_mile` bigint NULL DEFAULT NULL COMMENT '载客里程（米）',
  `drive_time` bigint NULL DEFAULT NULL COMMENT '载客时间(分)',
  `order_status` int NULL DEFAULT NULL COMMENT '订单状态1：订单开始 2：司机接单 3：去接乘客 4：司机到达乘客起点 5：乘客上车，司机开始行程 6：到达目的地，行程结束，未支付 7：发起收款 8: 支付完成 9.订单取消\'',
  `price` double(10, 2) NULL DEFAULT NULL,
  `gmt_create` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1637480804941148163 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
