/*
 Navicat MySQL Data Transfer

 Source Server         : 实验室电脑
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 10.10.5.130:3306
 Source Schema         : qiandao

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 24/11/2019 16:21:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_mac
-- ----------------------------
DROP TABLE IF EXISTS `t_mac`;
CREATE TABLE `t_mac`  (
  `mac_address` varchar(17) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`mac_address`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mac
-- ----------------------------
INSERT INTO `t_mac` VALUES ('8C-21-0A-5D-8E-20');
INSERT INTO `t_mac` VALUES ('D8-15-0D-A0-66-6C');
INSERT INTO `t_mac` VALUES ('F0-79-59-C6-22-80');

-- ----------------------------
-- Table structure for t_online_log
-- ----------------------------
DROP TABLE IF EXISTS `t_online_log`;
CREATE TABLE `t_online_log`  (
  `log_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `login_time` datetime(0) NOT NULL,
  `last_time` datetime(0) NULL DEFAULT NULL,
  `log_week` int(11) UNSIGNED NOT NULL,
  `user_id` int(11) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `Ref_01`(`user_id`) USING BTREE,
  CONSTRAINT `Ref_01` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 172 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_online_log
-- ----------------------------
INSERT INTO `t_online_log` VALUES (60, '2019-11-17 13:48:18', '2019-11-17 14:27:00', 201946, 58);
INSERT INTO `t_online_log` VALUES (61, '2019-11-17 13:54:30', '2019-11-17 17:31:55', 201946, 59);
INSERT INTO `t_online_log` VALUES (62, '2019-11-17 18:26:02', '2019-11-17 20:48:51', 201946, 60);
INSERT INTO `t_online_log` VALUES (63, '2019-11-17 19:47:55', '2019-11-17 21:33:44', 201946, 58);
INSERT INTO `t_online_log` VALUES (64, '2019-11-17 19:48:43', '2019-11-17 22:03:57', 201946, 62);
INSERT INTO `t_online_log` VALUES (65, '2019-11-17 20:07:51', '2019-11-17 20:35:41', 201946, 63);
INSERT INTO `t_online_log` VALUES (66, '2019-11-17 20:20:31', '2019-11-17 20:57:54', 201946, 64);
INSERT INTO `t_online_log` VALUES (68, '2019-11-17 20:51:34', '2019-11-17 21:41:32', 201946, 66);
INSERT INTO `t_online_log` VALUES (69, '2019-11-18 12:37:34', '2019-11-18 12:55:41', 201947, 63);
INSERT INTO `t_online_log` VALUES (70, '2019-11-18 14:32:55', '2019-11-18 15:32:27', 201947, 60);
INSERT INTO `t_online_log` VALUES (71, '2019-11-18 16:07:55', '2019-11-18 22:11:55', 201947, 58);
INSERT INTO `t_online_log` VALUES (72, '2019-11-18 16:16:11', '2019-11-18 17:04:36', 201947, 67);
INSERT INTO `t_online_log` VALUES (73, '2019-11-18 18:04:05', '2019-11-18 18:35:20', 201947, 67);
INSERT INTO `t_online_log` VALUES (74, '2019-11-18 18:53:15', '2019-11-18 21:03:02', 201947, 63);
INSERT INTO `t_online_log` VALUES (75, '2019-11-18 18:55:11', '2019-11-18 20:49:22', 201947, 67);
INSERT INTO `t_online_log` VALUES (76, '2019-11-18 19:30:37', '2019-11-18 21:22:11', 201947, 68);
INSERT INTO `t_online_log` VALUES (77, '2019-11-18 19:43:10', '2019-11-18 21:03:05', 201947, 62);
INSERT INTO `t_online_log` VALUES (78, '2019-11-18 21:21:23', '2019-11-18 21:34:30', 201947, 62);
INSERT INTO `t_online_log` VALUES (79, '2019-11-19 10:01:03', '2019-11-19 11:12:08', 201947, 63);
INSERT INTO `t_online_log` VALUES (80, '2019-11-19 10:27:29', '2019-11-19 11:46:04', 201947, 59);
INSERT INTO `t_online_log` VALUES (81, '2019-11-19 12:57:44', '2019-11-19 13:12:50', 201947, 59);
INSERT INTO `t_online_log` VALUES (82, '2019-11-19 14:50:15', '2019-11-19 17:40:56', 201947, 70);
INSERT INTO `t_online_log` VALUES (83, '2019-11-19 15:54:24', '2019-11-19 20:09:37', 201947, 58);
INSERT INTO `t_online_log` VALUES (84, '2019-11-19 18:42:19', '2019-11-19 19:28:23', 201947, 72);
INSERT INTO `t_online_log` VALUES (85, '2019-11-19 18:44:00', '2019-11-19 22:13:29', 201947, 63);
INSERT INTO `t_online_log` VALUES (86, '2019-11-19 18:55:29', '2019-11-19 21:39:17', 201947, 73);
INSERT INTO `t_online_log` VALUES (87, '2019-11-19 19:58:41', '2019-11-19 20:01:43', 201947, 72);
INSERT INTO `t_online_log` VALUES (88, '2019-11-19 20:14:39', '2019-11-19 21:16:23', 201947, 72);
INSERT INTO `t_online_log` VALUES (89, '2019-11-19 20:47:33', '2019-11-19 21:35:10', 201947, 75);
INSERT INTO `t_online_log` VALUES (90, '2019-11-19 20:53:13', '2019-11-19 21:09:26', 201947, 67);
INSERT INTO `t_online_log` VALUES (91, '2019-11-20 09:24:07', '2019-11-20 14:20:02', 201947, 63);
INSERT INTO `t_online_log` VALUES (92, '2019-11-20 09:52:51', '2019-11-20 10:36:53', 201947, 67);
INSERT INTO `t_online_log` VALUES (93, '2019-11-20 11:34:42', '2019-11-20 15:43:55', 201947, 70);
INSERT INTO `t_online_log` VALUES (94, '2019-11-20 12:10:46', '2019-11-20 12:25:56', 201947, 67);
INSERT INTO `t_online_log` VALUES (95, '2019-11-20 18:53:26', '2019-11-20 21:15:46', 201947, 62);
INSERT INTO `t_online_log` VALUES (96, '2019-11-21 09:55:40', '2019-11-21 21:40:27', 201947, 58);
INSERT INTO `t_online_log` VALUES (100, '2019-11-21 10:49:05', '2019-11-21 11:59:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (101, '2019-11-21 14:00:00', '2019-11-21 17:59:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (102, '2019-11-21 14:48:18', '2019-11-21 16:40:26', 201947, 66);
INSERT INTO `t_online_log` VALUES (103, '2019-11-21 15:06:55', '2019-11-21 18:00:33', 201947, 70);
INSERT INTO `t_online_log` VALUES (104, '2019-11-21 15:24:49', '2019-11-21 15:38:56', 201947, 62);
INSERT INTO `t_online_log` VALUES (105, '2019-11-21 18:53:50', '2019-11-21 21:13:33', 201947, 66);
INSERT INTO `t_online_log` VALUES (106, '2019-11-21 18:57:26', '2019-11-21 21:21:16', 201947, 75);
INSERT INTO `t_online_log` VALUES (107, '2019-11-21 19:00:00', '2019-11-21 21:59:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (108, '2019-11-21 19:20:39', '2019-11-21 21:58:16', 201947, 72);
INSERT INTO `t_online_log` VALUES (109, '2019-11-21 19:23:51', '2019-11-21 21:48:05', 201947, 62);
INSERT INTO `t_online_log` VALUES (110, '2019-11-21 19:29:49', '2019-11-21 21:48:31', 201947, 76);
INSERT INTO `t_online_log` VALUES (111, '2019-11-21 19:59:49', '2019-11-21 20:17:04', 201947, 67);
INSERT INTO `t_online_log` VALUES (112, '2019-11-21 20:03:14', '2019-11-21 21:17:49', 201947, 78);
INSERT INTO `t_online_log` VALUES (113, '2019-11-21 21:27:10', '2019-11-21 21:41:55', 201947, 67);
INSERT INTO `t_online_log` VALUES (114, '2019-11-21 21:27:28', '2019-11-21 21:30:29', 201947, 63);
INSERT INTO `t_online_log` VALUES (115, '2019-11-22 08:00:00', '2019-11-22 11:59:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (116, '2019-11-22 08:36:12', '2019-11-22 10:15:13', 201947, 60);
INSERT INTO `t_online_log` VALUES (117, '2019-11-22 09:37:16', '2019-11-22 09:52:54', 201947, 66);
INSERT INTO `t_online_log` VALUES (118, '2019-11-22 09:49:14', '2019-11-22 11:59:23', 201947, 75);
INSERT INTO `t_online_log` VALUES (119, '2019-11-22 10:11:33', '2019-11-22 10:42:06', 201947, 66);
INSERT INTO `t_online_log` VALUES (120, '2019-11-22 10:46:56', '2019-11-22 11:32:03', 201947, 60);
INSERT INTO `t_online_log` VALUES (121, '2019-11-22 13:34:09', '2019-11-22 22:01:32', 201947, 63);
INSERT INTO `t_online_log` VALUES (122, '2019-11-22 14:00:00', '2019-11-22 17:59:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (123, '2019-11-22 14:48:03', '2019-11-22 16:41:06', 201947, 64);
INSERT INTO `t_online_log` VALUES (124, '2019-11-22 15:18:18', '2019-11-22 17:40:18', 201947, 75);
INSERT INTO `t_online_log` VALUES (125, '2019-11-22 15:19:56', '2019-11-22 17:09:07', 201947, 66);
INSERT INTO `t_online_log` VALUES (126, '2019-11-22 15:55:38', '2019-11-22 20:18:11', 201947, 62);
INSERT INTO `t_online_log` VALUES (127, '2019-11-22 15:56:54', '2019-11-22 17:43:48', 201947, 67);
INSERT INTO `t_online_log` VALUES (128, '2019-11-22 15:59:34', '2019-11-22 17:27:36', 201947, 60);
INSERT INTO `t_online_log` VALUES (130, '2019-11-22 17:50:09', '2019-11-22 21:15:29', 201947, 78);
INSERT INTO `t_online_log` VALUES (131, '2019-11-22 19:00:00', '2019-11-22 21:59:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (132, '2019-11-22 19:35:27', '2019-11-22 21:16:43', 201947, 75);
INSERT INTO `t_online_log` VALUES (133, '2019-11-22 20:05:03', '2019-11-22 21:16:29', 201947, 66);
INSERT INTO `t_online_log` VALUES (134, '2019-11-23 08:00:00', '2019-11-23 11:59:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (135, '2019-11-23 10:26:39', '2019-11-23 11:08:47', 201947, 66);
INSERT INTO `t_online_log` VALUES (137, '2019-11-23 10:38:08', '2019-11-23 22:01:01', 201947, 63);
INSERT INTO `t_online_log` VALUES (138, '2019-11-23 11:28:14', '2019-11-23 11:37:20', 201947, 66);
INSERT INTO `t_online_log` VALUES (140, '2019-11-23 14:00:00', '2019-11-23 17:59:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (141, '2019-11-23 14:19:20', '2019-11-23 15:50:19', 201947, 80);
INSERT INTO `t_online_log` VALUES (142, '2019-11-23 16:57:53', '2019-11-23 16:57:53', 201947, 66);
INSERT INTO `t_online_log` VALUES (143, '2019-11-23 16:58:35', '2019-11-23 18:25:05', 201947, 75);
INSERT INTO `t_online_log` VALUES (144, '2019-11-23 16:59:10', '2019-11-23 18:02:57', 201947, 72);
INSERT INTO `t_online_log` VALUES (145, '2019-11-23 17:09:45', '2019-11-23 18:24:49', 201947, 70);
INSERT INTO `t_online_log` VALUES (146, '2019-11-23 17:18:42', '2019-11-23 19:19:22', 201947, 76);
INSERT INTO `t_online_log` VALUES (147, '2019-11-23 17:27:30', '2019-11-23 20:55:50', 201947, 66);
INSERT INTO `t_online_log` VALUES (148, '2019-11-23 18:05:37', '2019-11-23 18:11:40', 201947, 82);
INSERT INTO `t_online_log` VALUES (149, '2019-11-23 18:10:49', '2019-11-23 20:53:42', 201947, 83);
INSERT INTO `t_online_log` VALUES (150, '2019-11-23 18:14:32', '2019-11-23 21:14:18', 201947, 80);
INSERT INTO `t_online_log` VALUES (151, '2019-11-23 18:46:36', '2019-11-23 18:50:48', 201947, 62);
INSERT INTO `t_online_log` VALUES (152, '2019-11-23 18:54:48', '2019-11-23 20:57:48', 201947, 84);
INSERT INTO `t_online_log` VALUES (153, '2019-11-23 18:55:25', '2019-11-23 20:53:33', 201947, 71);
INSERT INTO `t_online_log` VALUES (154, '2019-11-23 19:00:00', '2019-11-23 21:59:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (155, '2019-11-23 19:00:14', '2019-11-23 20:57:46', 201947, 85);
INSERT INTO `t_online_log` VALUES (156, '2019-11-23 19:01:56', '2019-11-23 19:56:27', 201947, 86);
INSERT INTO `t_online_log` VALUES (157, '2019-11-23 19:19:21', '2019-11-23 20:44:14', 201947, 78);
INSERT INTO `t_online_log` VALUES (158, '2019-11-23 19:32:15', '2019-11-23 19:42:17', 201947, 70);
INSERT INTO `t_online_log` VALUES (159, '2019-11-23 19:38:52', '2019-11-23 20:58:30', 201947, 75);
INSERT INTO `t_online_log` VALUES (160, '2019-11-23 19:41:41', '2019-11-23 19:43:42', 201947, 76);
INSERT INTO `t_online_log` VALUES (161, '2019-11-23 19:47:45', '2019-11-23 20:53:31', 201947, 64);
INSERT INTO `t_online_log` VALUES (162, '2019-11-23 19:55:29', '2019-11-23 19:59:33', 201947, 89);
INSERT INTO `t_online_log` VALUES (163, '2019-11-23 20:57:00', '2019-11-23 21:24:22', 201947, 72);
INSERT INTO `t_online_log` VALUES (164, '2019-11-23 21:06:05', '2019-11-23 21:07:06', 201947, 92);
INSERT INTO `t_online_log` VALUES (165, '2019-11-23 21:17:54', '2019-11-23 21:20:58', 201947, 91);
INSERT INTO `t_online_log` VALUES (166, '2019-11-23 21:18:37', '2019-11-23 21:22:41', 201947, 76);
INSERT INTO `t_online_log` VALUES (167, '2019-11-24 08:00:00', '2019-11-24 11:59:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (168, '2019-11-24 12:51:01', '2019-11-24 16:21:20', 201947, 58);
INSERT INTO `t_online_log` VALUES (169, '2019-11-24 12:56:18', '2019-11-24 16:20:07', 201947, 63);
INSERT INTO `t_online_log` VALUES (170, '2019-11-24 14:00:00', '2019-11-24 16:21:00', 201947, 59);
INSERT INTO `t_online_log` VALUES (171, '2019-11-24 14:14:47', '2019-11-24 16:21:18', 201947, 80);

-- ----------------------------
-- Table structure for t_upload
-- ----------------------------
DROP TABLE IF EXISTS `t_upload`;
CREATE TABLE `t_upload`  (
  `upload_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '上传id',
  `upload_file_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件地址',
  `upload_time` datetime(0) NOT NULL COMMENT '上传时间',
  `upload_version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件版本号',
  `upload_file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上传文件名',
  `upload_file_size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上传文件大小',
  PRIMARY KEY (`upload_id`) USING BTREE,
  UNIQUE INDEX `version_unique`(`upload_version`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_upload
-- ----------------------------
INSERT INTO `t_upload` VALUES (2, '/upload/iotSIS@1.0.0-beta安装程序.exe', '2019-11-23 14:20:12', '@1.0.0-beta安装程序', 'iotSIS@1.0.0-beta安装程序.exe', '55442783');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_mac` varchar(17) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `mac_unique`(`user_mac`) USING BTREE,
  UNIQUE INDEX `user_name_unique`(`user_name`) USING BTREE,
  UNIQUE INDEX `user_mail_unique`(`user_mail`) USING BTREE,
  UNIQUE INDEX `stu_id_unique`(`stu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (58, 'EdBric', '陈尔达', '��Y�8���%!W�		�?Y�V:y\\0C��gY9��', 'B0-35-9F-D4-A0-AD', '1356319586@qq.com', '5120187209');
INSERT INTO `t_user` VALUES (59, 'xiaopangemm', '张星宇', '�/�(����vކ`���\'�&��\r�d\n�.��', '70-1C-E7-87-33-09', 'a904237539@qq.com', '5120170586');
INSERT INTO `t_user` VALUES (60, 'Overlord', '赵志航', '� #�6gHz\\��O����؎@��}�;�8�L', 'B4-69-21-9F-04-BB', '2845015722@qq.com', '5120185041');
INSERT INTO `t_user` VALUES (62, 'master_zsh', '张书豪', 'r�G�\Zy����0�n��[V\'�ؠI�:ZBT�', 'D8-9C-67-34-5B-01', '1070903073@qq.com', '5120186617');
INSERT INTO `t_user` VALUES (63, '5120175317', '樊国一', 'r����5P:D-����{d}9ׅD�����', 'B8-EE-65-7B-D0-66', '2398409722@qq.com', '5120175317');
INSERT INTO `t_user` VALUES (64, '2297240298', '徐锐', '{�Fk�N�C��֢FH�b���aƢ���bCM', '00-E1-8C-96-50-64', '2297240298@qq.com', '5120185759');
INSERT INTO `t_user` VALUES (66, 'chao123', '谭本超', '{O����>�T�`|��Yɩ�C-�s��$�è�%', '28-3A-4D-7D-4C-A1', '1149284750@qq.com', '5120181541');
INSERT INTO `t_user` VALUES (67, 'wxr_0830', '王晓冉', '�����ˋh���F����[��y���	�+�', '30-24-32-4C-64-D6', '2334830945@qq.com', '5120180937');
INSERT INTO `t_user` VALUES (68, 'gzj123', '郭志坚', 'O-n/��9��ucI�������Í����', '30-D1-6B-F8-3B-45', '1729654154@qq.com', '5120186837');
INSERT INTO `t_user` VALUES (70, '77427915', '张三春', '��f�0����F;�%�-:����Yz�\r�C��', '7C-2A-31-CC-73-D8', '77427915@qq.com', '5120183132');
INSERT INTO `t_user` VALUES (71, 'wangwei', '王威', '�Y�;�z�VKdG�U��+���Fx]�=�l�M', '94-B8-6D-6F-D7-A4', '2529262147@qq.com', '5120185502');
INSERT INTO `t_user` VALUES (72, '5120184213', '刘嵘彦', '�9��Y	D��������R�t�GW�GT/���\\', 'F8-28-19-0C-7A-AB', '383168082@qq.com', '5120184213');
INSERT INTO `t_user` VALUES (73, 'GUOZIRUI98', '郭子锐', '��9�!�����h��X��h���9��e����', '1C-1B-B5-0B-C8-13', '954960129@qq.com', '5120175347');
INSERT INTO `t_user` VALUES (74, 'Tenyond', '何腾洋', '����\n��v�������go%��t�yxȉ�,�', 'F8-28-19-6A-1A-A3', 'yank.tenyond@gmail.com', '5120164263');
INSERT INTO `t_user` VALUES (75, 'hy0320', '黄越', '4��@��k`+�+~~�<�����Em�5����', '80-C5-F2-FA-BD-A7', '418817150@qq.com', '5120186065');
INSERT INTO `t_user` VALUES (76, 'bj20001114', '柏梦涵', '���K�R���_���;�H�G��a�w��$֓', '70-C9-4E-48-E4-15', '2426080593@qq.com', '5120183266');
INSERT INTO `t_user` VALUES (78, 'Showmaker', '曾维鹏', '��0`�Sr�39�|\\}���I��ԐQ1/J�', '80-C5-F2-D2-60-A9', '1596387535@qq.com', '5120184430');
INSERT INTO `t_user` VALUES (80, '5120175320', '高鑫洁', 'E�0Xb*�8��a$�ʭ���۾O7Hb^��=', '06-0C-29-E7-B2-8C', '761725455@qq.com', '5120175320');
INSERT INTO `t_user` VALUES (82, 'yuanjiaqian520', '袁家乾', '=;m�Z�U�_�Hݸ�cHU�j-�vzr��', 'F8-A2-D6-4E-DB-8D', '1693503674@qq.com', '5120185403');
INSERT INTO `t_user` VALUES (83, 'Rosanna', '缪玲', 'y9���1uɏ|���\'�c�&J��)�D��', '74-70-FD-05-DC-69', '2236103111@qq.com', '5120185004');
INSERT INTO `t_user` VALUES (84, '5120183698', '黄波', ')E��K�K�Ik׫.���8�ǟ�>F]1����$', '60-F6-77-DF-CF-55', '858637824@qq.com', '5120183698');
INSERT INTO `t_user` VALUES (85, '5120183073', '蔡元毅', '���8����`��B � Δ�_��3D��%', 'E4-70-B8-8D-A2-7A', '2308669192@qq.com', '5120183073');
INSERT INTO `t_user` VALUES (86, 'SwaggyP', '鄢凌云', 'v�Ң��ȃׇ�\'��ےG��p�Y��L+p', 'B4-69-21-52-DA-A5', '695154659@qq.com', '5120186447');
INSERT INTO `t_user` VALUES (87, '5120185135', '李柯', '��@��0$����:�cG�{a�	�\"8���I', '74-40-BB-21-E2-81', '1350038711@qq.com', '5120185135');
INSERT INTO `t_user` VALUES (88, 'nz940731331', '聂志', '���7\\+�-����*�<u��؊����[', '74-D0-2B-62-95-3C', '940731331@qq.com', '5120182066');
INSERT INTO `t_user` VALUES (89, 'lmx4008', '李明晓', '�af<i��^�.)�\0gk�#�o���������6', 'B4-6B-FC-1F-A8-F1', '1186555365@qq.com', '5120184008');
INSERT INTO `t_user` VALUES (91, 'double_flower', '戴若诗', '�j&�m��q� ݿ뛺?�9D\n��c�ۭg��', '58-00-E3-E7-1A-77', '1466255084@qq.com', '5120186200');
INSERT INTO `t_user` VALUES (92, '5120182536', '赵雪峰', '�9��>��j���^���|~=m�jR~YCѧ3��', '1C-1B-B5-63-13-CA', '32898731@qq.com', '5120182536');
INSERT INTO `t_user` VALUES (93, 'Lily_111', '刘丽莉', '����5��@����9M�)�(���B��ky', '14-4F-8A-E2-F3-F6', '2841862482@qq.com', '5120184688');

SET FOREIGN_KEY_CHECKS = 1;
