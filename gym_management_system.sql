SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
                          `admin_account` int NOT NULL ,
                          `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL  ,
                          PRIMARY KEY (`admin_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1001, '123456');
INSERT INTO `admin` VALUES (1002, '123456');
INSERT INTO `admin` VALUES (1003, '123456');

-- ----------------------------
-- Table structure for classtable
-- ----------------------------
DROP TABLE IF EXISTS `class_table`;
CREATE TABLE `class_table`  (
                                `class_id` int NOT NULL DEFAULT 0 ,
                                `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                                `class_begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                                `class_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                                `coach` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                                PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classtable
-- ----------------------------
INSERT INTO `class_table` VALUES (0001, 'Muscle Building', '01/01/2024 15:00', '60 minutes', 'Muscle Building Coach');
INSERT INTO `class_table` VALUES (0002, 'Yoga', '02/01/2024 10:20', '90 minutes', 'Yoga Coach');
INSERT INTO `class_table` VALUES (0003, 'Fat Loss', '06/03/2024 18:00', '90 minutes', 'Fat Loss Coach');
INSERT INTO `class_table` VALUES (0004, 'Sports Rehabilitation', '02/02/2024 10:00', '45 minutes', 'Sports Rehabilitation Coach');
INSERT INTO `class_table` VALUES (0005, 'Mixed Martial Arts', '03/02/2024 15:00', '60 minutes', 'Mixed Martial Arts Coach');
INSERT INTO `class_table` VALUES (0006, 'Shaping', '03/02/2024 15:00', '60 minutes', 'Shaping Coach');
INSERT INTO `class_table` VALUES (0007, 'Pilates', '01/03/2024 17:30', '60 minutes', 'Pilates Coach');
INSERT INTO `class_table` VALUES (0008, 'Jazz Dance', '22/02/2024 09:00', '90 minutes', 'Jazz Dance Coach');
INSERT INTO `class_table` VALUES (0009, 'Barbell Exercise', '04/02/2024 15:00', '60 minutes', 'Barbell Exercise Coach');
INSERT INTO `class_table` VALUES (0010, 'Spinning', '08/03/2024 15:00', '45 minutes', 'Spinning Coach');
INSERT INTO `class_table` VALUES (0011, 'Aerobics', '22/02/2024 18:00', '60 minutes', 'Aerobics Coach');



-- ----------------------------
-- Table structure for classorder
-- ----------------------------
DROP TABLE IF EXISTS `class_order`;
CREATE TABLE `class_order`  (
                                `class_order_id` int NOT NULL AUTO_INCREMENT ,
                                `class_id` int NULL DEFAULT NULL ,
                                `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                                `coach` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                                `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                                `member_account` int NULL DEFAULT NULL ,
                                `class_begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                                PRIMARY KEY (`class_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classorder
-- ----------------------------
INSERT INTO class_order VALUES (1, 0002, 'Yoga', 'Yoga Coach', 'Alex', 202100788, '02/01/2024 10:20');
INSERT INTO class_order VALUES (2, 0002, 'Yoga', 'Yoga Coach', 'John', 202132539, '02/01/2024 10:20');
INSERT INTO class_order VALUES (3, 0004, 'Sports Rehabilitation', 'Sports Rehabilitation Coach', 'Mike', 202156754, '02/02/2024 10:00');
INSERT INTO class_order VALUES (4, 0001, 'Muscle Building', 'Muscle Building Coach', 'Mike', 202156754, '02/01/2024 15:00');
INSERT INTO class_order VALUES (5, 0001, 'Muscle Building', 'Muscle Building Coach', 'Tylor', 202183406, '02/01/2024 15:00');
INSERT INTO class_order VALUES (6, 0002, 'Yoga', 'Yoga Coach', 'Tylor', 202183406, '02/01/2024 10:20');
INSERT INTO class_order VALUES (7, 0001, 'Muscle Building', 'Muscle Building Coach', 'Alex', 202100788, '02/01/2024 15:00');
INSERT INTO class_order VALUES (8, 0001, 'Muscle Building', 'Muscle Building Coach', 'Joyce', 202186416, '02/01/2024 15:00');
INSERT INTO class_order VALUES (9, 0003, 'Fat Loss', 'Fat Loss Coach', 'Joyce', 202186416, '02/01/2024 18:00');
INSERT INTO class_order VALUES (10, 0003, 'Fat Loss', 'Fat Loss Coach', 'Lily', 202123664, '02/01/2024 18:00');
INSERT INTO class_order VALUES (11, 0003, 'Fat Loss', 'Fat Loss Coach', 'Emma', 202153468, '02/01/2024 18:00');



-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
                           `member_account` int NOT NULL ,
                           `member_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456' ,
                           `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                           `member_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' ,
                           `member_age` int NULL DEFAULT NULL ,
                           `member_height` int NULL DEFAULT NULL ,
                           `member_weight` int NULL DEFAULT NULL ,
                           `member_phone` bigint NULL DEFAULT NULL ,
                           `card_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                           `card_class` int NULL DEFAULT NULL ,
                           `card_next_class` int NULL DEFAULT NULL ,
                           PRIMARY KEY (`member_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (202009867, '123456', 'Anna', 'F', 24, 182, 60, 85265548482, '05/06/2023', 40, 40);
INSERT INTO `member` VALUES (202100788, '123456', 'Alex', 'M', 31, 178, 60, 85261554873, '01/01/2024', 50, 50);
INSERT INTO `member` VALUES (202132539, '123456', 'John', 'M', 31, 178, 60, 85264875489, '01/01/2024', 40, 40);
INSERT INTO `member` VALUES (202186416, '123456', 'Joyce', 'F', 23, 160, 45, 85224576857, '16/01/2024', 30, 30);
INSERT INTO `member` VALUES (202106725, '123456', 'Tom', 'M', 24, 178, 88, 85258784959, '26/02/2024', 30, 30);
INSERT INTO `member` VALUES (202183406, '123456', 'Tylor', 'F', 19, 170, 60, 85286457488,'27/02/2024', 30, 30);
INSERT INTO `member` VALUES (202176587, '123456', 'Jack', 'M', 33, 177, 90, 85267546666, '27/02/2024', 30, 30);
INSERT INTO `member` VALUES (202156754, '123456', 'Mike', 'M', 36, 166, 67, 85286532448, '28/02/2024', 30, 30);
INSERT INTO `member` VALUES (202153468, '123456', 'Emma', 'F', 25, 173, 44, 85286457124,  '01/03/2024', 50, 50);
INSERT INTO `member` VALUES (202121345, '123456', 'Ava', 'F', 28, 160, 40, 85254457488, '02/03/2024', 30, 30);
INSERT INTO `member` VALUES (202189776, '123456', 'Chloe', 'F', 27, 170, 50, 85286337489,  '03/23/2024', 30, 30);
INSERT INTO `member` VALUES (202123664, '123456', 'Lily', 'F', 25, 165, 51, 85286457423,  '27/03/2023', 30, 30);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
                             `employee_account` int NOT NULL ,
                             `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                             `employee_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                             `employee_age` int NULL DEFAULT NULL ,
                             `entry_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                             `staff` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                             `employee_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                             PRIMARY KEY (`employee_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (101038721,  'Coach 1', 'Female', 26, '06/29/2016', 'Fitness Coach', 'Bodybuilding Champion');
INSERT INTO `employee` VALUES (101068283,  'Coach 2', 'Male', 34, '01/06/2021', 'Fitness Coach', 'Professional Coach');
INSERT INTO `employee` VALUES (101053687,  'Coach 3', 'Male', 30, '06/06/2021', 'Fitness Coach', 'Professional Coach');
INSERT INTO `employee` VALUES (101045354,  'Coach 4', 'Male', 24, '01/07/2020', 'Fitness Coach', 'Professional Coach');
INSERT INTO `employee` VALUES (101058973,  'Cleaner 1', 'Female', 48, '08/24/2019', 'Cleaner', 'Model Employee');
INSERT INTO `employee` VALUES (101034208,  'Cleaner 2', 'Female', 48, '08/01/2010', 'Cleaner', '');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
                              `equipment_id` int NOT NULL AUTO_INCREMENT ,
                              `equipment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                              `equipment_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                              `equipment_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                              `equipment_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
                              PRIMARY KEY (`equipment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES (1, 'Dumbbell 1', 'Room 1', 'Normal', '');
INSERT INTO `equipment` VALUES (2, 'Barbell 1', 'Room 2', 'Damaged', 'Awaiting Repair');
INSERT INTO `equipment` VALUES (3, 'Treadmill 1', 'Room 2', 'Under Repair', 'Contacting Manufacturer for Repair');
INSERT INTO `equipment` VALUES (4, 'Treadmill 2', 'Room 2', 'Normal', '');
INSERT INTO `equipment` VALUES (5, 'Treadmill 3', 'Room 2', 'Normal', '');
INSERT INTO `equipment` VALUES (6, 'Barbell 1', 'Room 1', 'Normal', '');
INSERT INTO `equipment` VALUES (7, 'Barbell 2', 'Room 1', 'Normal', '');




SET FOREIGN_KEY_CHECKS = 1;
