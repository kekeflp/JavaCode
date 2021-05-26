/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : javatest

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 25/05/2021 13:04:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, 'admin', '123456');
INSERT INTO `manager` VALUES (2, 'root', '123456');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `xingming` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bianhao` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `shengri` date NULL DEFAULT NULL,
  `jiaxiang` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `yuwen_defeng` int NULL DEFAULT NULL,
  `yingyu_defeng` int NULL DEFAULT NULL,
  `shuxue_defeng` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (3, '姓名3', 'BH000003', '2021-05-24', 'HB', 13, 43, 73);
INSERT INTO `student` VALUES (5, '姓名5', 'BH000005', '2021-05-24', 'HB', 15, 45, 75);
INSERT INTO `student` VALUES (6, '姓名6', 'BH000006', '2021-05-24', 'HB', 16, 46, 76);
INSERT INTO `student` VALUES (7, '姓名7', 'BH000007', '2021-05-24', 'HB', 17, 47, 77);
INSERT INTO `student` VALUES (8, '姓名8', 'BH000008', '2021-05-24', 'HB', 18, 48, 78);
INSERT INTO `student` VALUES (9, '姓名9', 'BH000009', '2021-05-24', 'HB', 19, 49, 79);
INSERT INTO `student` VALUES (20, '张三', 'BH000021', '1990-12-12', '西藏', 66, 79, 79);
INSERT INTO `student` VALUES (21, '里斯', 'BH000001', '1900-01-01', 'HB', 33, 44, 66);

SET FOREIGN_KEY_CHECKS = 1;
