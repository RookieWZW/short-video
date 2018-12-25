/*
Navicat MariaDB Data Transfer

Source Server         : .
Source Server Version : 100122
Source Host           : localhost:3306
Source Database       : imooc-video-dev

Target Server Type    : MariaDB
Target Server Version : 100122
File Encoding         : 65001

Date: 2018-05-30 19:37:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bgm
-- ----------------------------
DROP TABLE IF EXISTS `bgm`;
CREATE TABLE `bgm` (
  `id` varchar(64) NOT NULL,
  `author` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL COMMENT '播放地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bgm
-- ----------------------------
INSERT INTO `bgm` VALUES ('18052674D26HH32P', '测试歌手名字', 'abc歌曲~~', '\\bgm\\好歌曲.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH33P', '测试歌手名字', 'abc歌曲~~', '\\bgm\\music.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X1', '测试歌手名字', 'abc歌曲~~', '\\bgm\\music.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X2', '测试歌手名字', 'abc歌曲~~', '\\bgm\\music.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X3', '测试歌手名字', 'abc歌曲~~', '\\bgm\\music.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X5', '测试歌手名字', 'abc歌曲~~', '\\bgm\\music.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X6', '测试歌手名字', 'abc歌曲~~', '\\bgm\\music.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X7', '测试歌手名字', 'abc歌曲~~', '\\bgm\\music.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X8', '测试歌手名字', 'abc歌曲~~', '\\bgm\\music.mp3');
INSERT INTO `bgm` VALUES ('18052674D26HH3X9', '测试歌手名字', 'abc歌曲~~', '\\bgm\\music.mp3');
INSERT INTO `bgm` VALUES ('1805290R3WTDMT9P', 'aa', 'aa', '\\bgm\\music.mp3');
INSERT INTO `bgm` VALUES ('180530DXKK4YYGTC', '达瓦', 'dwadw', '\\bgm\\music好歌曲.mp3');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` varchar(20) NOT NULL,
  `father_comment_id` varchar(20) DEFAULT NULL,
  `to_user_id` varchar(20) DEFAULT NULL,
  `video_id` varchar(20) NOT NULL COMMENT '视频id',
  `from_user_id` varchar(20) NOT NULL COMMENT '留言者，评论的用户id',
  `comment` text NOT NULL COMMENT '评论内容',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程评论表';

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('135240CW46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈1', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('18034CW46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈2', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('1803F50CW46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈3', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('18052150CW46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈4', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180522F50626894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈5', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180522F50C126894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈6', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180522F50CW46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈7', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180522F5346894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈8', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180522F54CW46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈9', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180523F533Y0837C', null, null, '180510CD0A6K3SRP', '180425CFA4RB6T0H', 'dwdawdwa', '2018-05-23 19:52:19');
INSERT INTO `comments` VALUES ('180523FATAR6C2Y8', '180523FB1BYS43HH', '180425CFA4RB6T0H', '180522FB4BZ1N9P0', '180518CKMAAM5TXP', '回复评论', '2018-05-23 20:09:30');
INSERT INTO `comments` VALUES ('180523FB1BYS43HH', null, null, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '野马~~', '2018-05-23 20:10:09');
INSERT INTO `comments` VALUES ('180523FC0MKCTS3C', null, null, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', 'dwdw', '2018-05-23 20:13:04');
INSERT INTO `comments` VALUES ('180523FCZM2CTCZC', null, null, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', 'dwqdwqdqw', '2018-05-23 20:15:58');
INSERT INTO `comments` VALUES ('180523FD1H5HG9P0', null, null, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '1fewdew', '2018-05-23 20:16:10');
INSERT INTO `comments` VALUES ('180523FDBT3S3C00', null, null, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '123', '2018-05-23 20:17:16');
INSERT INTO `comments` VALUES ('180523FDFX4HS5P0', null, null, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '43trgtew', '2018-05-23 20:17:36');
INSERT INTO `comments` VALUES ('180523H79060HNHH', null, null, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '哈多好玩聊哦', '2018-05-23 22:47:06');
INSERT INTO `comments` VALUES ('180523HATXR841KP', null, null, '180522FB4BZ1N9P0', '180425CFA4RB6T0H', '大家诶哦大家欧文', '2018-05-23 22:57:42');
INSERT INTO `comments` VALUES ('180523K2DG3SGAA8', null, null, '180522FB4BZ1N9P0', '180518CKMAAM5TXP', 'dwdw', '2018-05-23 23:56:38');
INSERT INTO `comments` VALUES ('180523K2YRF1WNXP', null, null, '180522FB4BZ1N9P0', '180518CKMAAM5TXP', 'ddew', '2018-05-23 23:58:03');
INSERT INTO `comments` VALUES ('180523K3FH1WT7R4', null, null, '180522FB4BZ1N9P0', '180518CKMAAM5TXP', 'tgergre', '2018-05-23 23:59:45');
INSERT INTO `comments` VALUES ('1805240G4G19R0PH', '180523HATXR841KP', '180425CFA4RB6T0H', '180522FB4BZ1N9P0', '180518CKMAAM5TXP', '回复测试，final', '2018-05-24 00:45:31');
INSERT INTO `comments` VALUES ('18055W46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈11', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('180565016894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈22', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('1805650CW46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈33', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('1805twW46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈44', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('280522F50CW46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈55', '2018-05-22 19:52:02');
INSERT INTO `comments` VALUES ('qq1805twW46894', null, null, '180510CD0A6K3SRP', '180518CKMAAM5TXP', 'hhhh 测试啊哈哈哈66', '2018-05-22 19:52:02');

-- ----------------------------
-- Table structure for search_records
-- ----------------------------
DROP TABLE IF EXISTS `search_records`;
CREATE TABLE `search_records` (
  `id` varchar(64) NOT NULL,
  `content` varchar(255) NOT NULL COMMENT '搜索的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='视频搜索的记录表';

-- ----------------------------
-- Records of search_records
-- ----------------------------
INSERT INTO `search_records` VALUES ('1', '慕课网');
INSERT INTO `search_records` VALUES ('18051309YBCMHYRP', '风景');
INSERT INTO `search_records` VALUES ('1805130DAXX58ARP', '风景');
INSERT INTO `search_records` VALUES ('1805130DMG6P0ZC0', '风景');
INSERT INTO `search_records` VALUES ('1805130FNGHD3B0H', '慕课网');
INSERT INTO `search_records` VALUES ('180513C94W152Z7C', 'dwqdwq');
INSERT INTO `search_records` VALUES ('180513DXNT7SY04H', '风景');
INSERT INTO `search_records` VALUES ('2', '慕课网');
INSERT INTO `search_records` VALUES ('3', '慕课网');
INSERT INTO `search_records` VALUES ('4', '慕课网');
INSERT INTO `search_records` VALUES ('5', '慕课');
INSERT INTO `search_records` VALUES ('6', '慕课');
INSERT INTO `search_records` VALUES ('7', 'zookeeper');
INSERT INTO `search_records` VALUES ('8', 'zookeeper');
INSERT INTO `search_records` VALUES ('9', 'zookeeper');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(64) NOT NULL,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `face_image` varchar(255) DEFAULT NULL COMMENT '我的头像，如果没有默认给一张',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `fans_counts` int(11) DEFAULT '0' COMMENT '我的粉丝数量',
  `follow_counts` int(11) DEFAULT '0' COMMENT '我关注的人总数',
  `receive_like_counts` int(11) DEFAULT '0' COMMENT '我接受到的赞美/收藏 的数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1001', 'test-imooc-1111', '9999', '/path000999', '慕课网好牛十分牛~', '123456', '111', '222');
INSERT INTO `users` VALUES ('180425B0B3N6B25P', 'imooc11', 'wzNncBURtPYCDsYd7TUgWQ==', null, 'imooc', '0', '0', '0');
INSERT INTO `users` VALUES ('180425BNSR1CG0H0', 'abc', '4QrcOUm6Wau+VuBX8g+IPg==', null, 'abc', '0', '0', '0');
INSERT INTO `users` VALUES ('180425CFA4RB6T0H', 'imooc', 'kU8h64TG/bK2Y91vRT9lyg==', '/180425CFA4RB6T0H/face/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.W0eLNdT6MIvD3ba01f74ba779caa63d038c3c8200b4a.jpg', 'imooc1', '0', '2', '6');
INSERT INTO `users` VALUES ('180426F4D35R04X4', 'aaa', 'R7zlx09Yn0hn29V+nKn4CA==', null, 'aaa', '0', '0', '0');
INSERT INTO `users` VALUES ('180426F55CZPA9YW', 'aaaa', 'R7zlx09Yn0hn29V+nKn4CA==', null, 'aaaa', '0', '0', '0');
INSERT INTO `users` VALUES ('180426GA3SBB4DP0', '1001', 'bfw1xHdW6WLvBV0QSfH47A==', null, '1001', '0', '0', '0');
INSERT INTO `users` VALUES ('180426GAK87AB0X4', '10401', 'bfw1xHdW6WLvBV0QSfH47A==', null, '10401', '0', '0', '0');
INSERT INTO `users` VALUES ('180426GAWCC17KWH', '104701', 'bfw1xHdW6WLvBV0QSfH47A==', null, '104701', '0', '0', '0');
INSERT INTO `users` VALUES ('180426GBDFKDG5D4', '10re4701', 'bfw1xHdW6WLvBV0QSfH47A==', null, '10re4701', '0', '0', '0');
INSERT INTO `users` VALUES ('180426GBKN0YRFRP', '10rwee4701', 'bfw1xHdW6WLvBV0QSfH47A==', null, '10rwee4701', '0', '0', '0');
INSERT INTO `users` VALUES ('180426GH49XRZHX4', '390213890', 'H9V/tnfgt6nniqH5bDZ0hQ==', null, '390213890', '0', '0', '0');
INSERT INTO `users` VALUES ('180426GHH12WXPZC', '390ewqewq213890', 'H9V/tnfgt6nniqH5bDZ0hQ==', null, '390ewqewq213890', '0', '0', '0');
INSERT INTO `users` VALUES ('180426GHHPZ7NTC0', '390ewqewq21ewqe3890', 'H9V/tnfgt6nniqH5bDZ0hQ==', null, '390ewqewq21ewqe3890', '0', '0', '0');
INSERT INTO `users` VALUES ('180426H0GWP0C3HH', 'jdiowqjodij', 'wEmTz54sy+StEzB+TrtGSQ==', null, 'jdiowqjodij', '0', '0', '0');
INSERT INTO `users` VALUES ('180518CHS7SXMCX4', 'aaaaa', 'WU+AOzgKQTlu1j3KOVA1Qg==', null, 'aaaaa', '0', '0', '0');
INSERT INTO `users` VALUES ('180518CKMAAM5TXP', 'abc123', '6ZoYxCjLONXyYIU2eJIuAw==', '/180518CKMAAM5TXP/face/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.Q27j7DxNKKk07adf242959818c45238b8f11b64cc255.png', 'abc123', '0', '0', '1');

-- ----------------------------
-- Table structure for users_fans
-- ----------------------------
DROP TABLE IF EXISTS `users_fans`;
CREATE TABLE `users_fans` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL COMMENT '用户',
  `fan_id` varchar(64) NOT NULL COMMENT '粉丝',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`fan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户粉丝关联关系表';

-- ----------------------------
-- Records of users_fans
-- ----------------------------

-- ----------------------------
-- Table structure for users_like_videos
-- ----------------------------
DROP TABLE IF EXISTS `users_like_videos`;
CREATE TABLE `users_like_videos` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL COMMENT '用户',
  `video_id` varchar(64) NOT NULL COMMENT '视频',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_video_rel` (`user_id`,`video_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户喜欢的/赞过的视频';

-- ----------------------------
-- Records of users_like_videos
-- ----------------------------
INSERT INTO `users_like_videos` VALUES ('180520HBA054FPPH', '180518CKMAAM5TXP', '180510CCX05TABHH');
INSERT INTO `users_like_videos` VALUES ('180520HSBDW6M0SW', '180518CKMAAM5TXP', '180510CD0A6K3SRP');

-- ----------------------------
-- Table structure for users_report
-- ----------------------------
DROP TABLE IF EXISTS `users_report`;
CREATE TABLE `users_report` (
  `id` varchar(64) NOT NULL,
  `deal_user_id` varchar(64) NOT NULL COMMENT '被举报用户id',
  `deal_video_id` varchar(64) NOT NULL,
  `title` varchar(128) NOT NULL COMMENT '类型标题，让用户选择，详情见 枚举',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `userid` varchar(64) NOT NULL COMMENT '举报人的id',
  `create_date` datetime NOT NULL COMMENT '举报时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='举报用户表';

-- ----------------------------
-- Records of users_report
-- ----------------------------
INSERT INTO `users_report` VALUES ('180521FZ501ABDYW', '180425CFA4RB6T0H', '180510CD0A6K3SRP', '引人不适', '不合时宜的视频', '180518CKMAAM5TXP', '2018-05-21 20:58:35');
INSERT INTO `users_report` VALUES ('180521FZK44ZRWX4', '180425CFA4RB6T0H', '180510CD0A6K3SRP', '引人不适', '不合时宜的视频', '180518CKMAAM5TXP', '2018-05-21 20:59:53');
INSERT INTO `users_report` VALUES ('180521FZR1TYRTXP', '180425CFA4RB6T0H', '180510CD0A6K3SRP', '辱骂谩骂', 't4t43', '180518CKMAAM5TXP', '2018-05-21 21:00:18');

-- ----------------------------
-- Table structure for videos
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL COMMENT '发布者id',
  `audio_id` varchar(64) DEFAULT NULL COMMENT '用户使用音频的信息',
  `video_desc` varchar(128) DEFAULT NULL COMMENT '视频描述',
  `video_path` varchar(255) NOT NULL COMMENT '视频存放的路径',
  `video_seconds` float(6,2) DEFAULT NULL COMMENT '视频秒数',
  `video_width` int(6) DEFAULT NULL COMMENT '视频宽度',
  `video_height` int(6) DEFAULT NULL COMMENT '视频高度',
  `cover_path` varchar(255) DEFAULT NULL COMMENT '视频封面图',
  `like_counts` bigint(20) NOT NULL DEFAULT '0' COMMENT '喜欢/赞美的数量',
  `status` int(1) NOT NULL COMMENT '视频状态：\r\n1、发布成功\r\n2、禁止播放，管理员操作',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='视频信息表';

-- ----------------------------
-- Records of videos
-- ----------------------------
INSERT INTO `videos` VALUES ('180510CC3819RHBC', '180425CFA4RB6T0H', '', '风景', '/180425CFA4RB6T0H/video/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.R5zVt7RTx6Vv6ee923498030ecd9328acf709bb3a278.mp4', '10.05', '960', '540', '/180425CFA4RB6T0H/video/wxa2049f5aead89372o6zAJs5sm5bPFcTzKXp_5wXsWusoR5zVt7RTx6Vv6ee923498030ecd9328acf709bb3a278.jpg', '0', '1', '2018-05-10 17:25:13');
INSERT INTO `videos` VALUES ('180510CCCK8A6S14', '180425CFA4RB6T0H', '', '夏天夏天', '/180425CFA4RB6T0H/video/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.upJlpa1Oc99Zaf561ddc63a69c13472506f586cda815.mp4', '10.00', '960', '540', '/180425CFA4RB6T0H/video/wxa2049f5aead89372o6zAJs5sm5bPFcTzKXp_5wXsWusoupJlpa1Oc99Zaf561ddc63a69c13472506f586cda815.jpg', '0', '1', '2018-05-10 17:26:13');
INSERT INTO `videos` VALUES ('180510CCK95WNG7C', '180425CFA4RB6T0H', '', '海贼王', '/180425CFA4RB6T0H/video/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.nPTyoc9tyI3kabf2c7ceeb9b446b60b47b1705668857.mp4', '10.02', '544', '960', '/180425CFA4RB6T0H/video/wxa2049f5aead89372o6zAJs5sm5bPFcTzKXp_5wXsWusonPTyoc9tyI3kabf2c7ceeb9b446b60b47b1705668857.jpg', '0', '1', '2018-05-10 17:26:43');
INSERT INTO `videos` VALUES ('180510CCNC7C9FCH', '180425CFA4RB6T0H', '', '吃饭吃饭', '/180425CFA4RB6T0H/video/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.uG2pt2vkkRI586933d88b91b9577ff8d2d4864443a50.mp4', '6.02', '960', '544', '/180425CFA4RB6T0H/video/wxa2049f5aead89372o6zAJs5sm5bPFcTzKXp_5wXsWusouG2pt2vkkRI586933d88b91b9577ff8d2d4864443a50.jpg', '0', '1', '2018-05-10 17:26:57');
INSERT INTO `videos` VALUES ('180510CCSFC45A5P', '180425CFA4RB6T0H', '', '风景可以', '/180425CFA4RB6T0H/video/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.L5WSh3OtMAgf9e6b52aed5830d1bfcfdcb98b2600280.mp4', '9.90', '960', '404', '/180425CFA4RB6T0H/video/wxa2049f5aead89372o6zAJs5sm5bPFcTzKXp_5wXsWusoL5WSh3OtMAgf9e6b52aed5830d1bfcfdcb98b2600280.jpg', '0', '1', '2018-05-10 17:27:17');
INSERT INTO `videos` VALUES ('180510CCX05TABHH', '180425CFA4RB6T0H', '', '变魔术', '/180425CFA4RB6T0H/video/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.yptyFK8MwgrL9e2d3e37c168928a9db960e3b24f782b.mp4', '6.02', '540', '960', '/180425CFA4RB6T0H/video/wxa2049f5aead89372o6zAJs5sm5bPFcTzKXp_5wXsWusoyptyFK8MwgrL9e2d3e37c168928a9db960e3b24f782b.jpg', '1', '1', '2018-05-10 17:27:33');
INSERT INTO `videos` VALUES ('180510CD0A6K3SRP', '180425CFA4RB6T0H', '', '来一场说走就走的旅行', '/180425CFA4RB6T0H/video/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.qtm2zeEgenrf7993bfb60dbac65af7b7847d51ee4445.mp4', '5.02', '960', '544', '/180425CFA4RB6T0H/video/wxa2049f5aead89372o6zAJs5sm5bPFcTzKXp_5wXsWusoqtm2zeEgenrf7993bfb60dbac65af7b7847d51ee4445.jpg', '3', '1', '2018-05-10 17:27:54');
INSERT INTO `videos` VALUES ('180513FW054FFRAW', '180425CFA4RB6T0H', '', '复用上传测试', '/180425CFA4RB6T0H/video/wxa2049f5aead89372.o6zAJs5sm5bPFcTzKXp_5wXsWuso.Bc21hNytcS0M2da7b7e0f5cc83d362eba78aec81adb9.mp4', '7.52', '544', '960', '/180425CFA4RB6T0H/video/wxa2049f5aead89372o6zAJs5sm5bPFcTzKXp_5wXsWusoBc21hNytcS0M2da7b7e0f5cc83d362eba78aec81adb9.jpg', '0', '1', '2018-05-13 20:49:03');
INSERT INTO `videos` VALUES ('180522FB4BZ1N9P0', '180425CFA4RB6T0H', '', '骑着野马出去浪………~~', '/180425CFA4RB6T0H/video/tmp_5e574148aa8356149758ec969b108886.mp4', '9.00', '540', '960', '/180425CFA4RB6T0H/video/tmp_5e574148aa8356149758ec969b108886.jpg', '0', '1', '2018-05-22 20:10:28');
