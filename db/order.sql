/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50617
 Source Host           : localhost:3306
 Source Schema         : order

 Target Server Type    : MySQL
 Target Server Version : 50617
 File Encoding         : 65001

 Date: 13/04/2019 20:22:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单名称',
  `order_createtime` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `order_state` int(11) NULL DEFAULT NULL COMMENT '订单状态 0 已经未支付 1已经支付 2已退单',
  `order_money` double(10, 0) NULL DEFAULT NULL COMMENT '订单价格',
  `commodity_id` int(10) NULL DEFAULT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (20, '购物手机支付订单', '2019-04-08 02:50:31', 300, 0, 30);

SET FOREIGN_KEY_CHECKS = 1;
