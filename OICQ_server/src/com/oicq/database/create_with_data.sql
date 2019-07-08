-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2019-07-08 17:24:08
-- 服务器版本： 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oicq`
--

-- --------------------------------------------------------

--
-- 表的结构 `dw_group`
--

CREATE TABLE `dw_group` (
  `group_id` int(10) NOT NULL,
  `group_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `group_master` int(10) NOT NULL,
  `group_trades` text COLLATE utf8_unicode_ci NOT NULL,
  `group_registertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `group_avatar` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `dw_group`
--

INSERT INTO `dw_group` (`group_id`, `group_name`, `group_master`, `group_trades`, `group_registertime`, `group_avatar`) VALUES
(10001, 'imqxms', 10001, '这是第一个测试群，都说了是第一个啦~', '2016-11-20 09:14:41', 'http://tva1.sinaimg.cn/crop.0.0.480.480.180/ab72caa0jw8ewkyk6s3ijj20dc0dcabd.jpg'),
(10002, 'Group2', 10002, '我的个性签名去哪里了', '2016-11-20 09:14:49', 'http://tva1.sinaimg.cn/crop.0.0.512.512.50/0069Brjhjw8f9us1mbv2kj30e80e8gm1.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `dw_groupchat`
--

CREATE TABLE `dw_groupchat` (
  `gchat_id` int(10) NOT NULL,
  `gchat_uid` int(10) NOT NULL,
  `gchat_gid` int(10) NOT NULL,
  `gchat_message` text COLLATE utf8_unicode_ci NOT NULL,
  `gchat_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `dw_groupchat`
--

INSERT INTO `dw_groupchat` (`gchat_id`, `gchat_uid`, `gchat_gid`, `gchat_message`, `gchat_datetime`) VALUES
(1, 10003, 10001, '大家好', '2016-11-26 07:12:46'),
(2, 10003, 10001, '我是colorfulshark', '2016-11-26 07:12:58'),
(3, 10001, 10001, '你好', '2016-11-26 07:13:14'),
(4, 10002, 10001, '哇！都在呀', '2016-11-26 07:13:41'),
(5, 10003, 10001, '哇咔咔', '2016-11-26 07:19:55'),
(6, 10003, 10001, '法撒旦法', '2016-11-26 07:51:06'),
(7, 10001, 10001, '哇唔', '2016-11-26 08:08:32'),
(8, 10002, 10001, '444', '2016-11-26 08:10:14'),
(9, 10001, 10001, '我是第一个唉', '2016-11-26 08:38:22'),
(10, 10001, 10001, '好厉害', '2016-11-26 08:38:29'),
(11, 10001, 10001, '1010', '2016-11-26 08:39:24'),
(12, 10003, 10001, '', '2016-11-26 08:42:46'),
(13, 10001, 10001, '1111', '2016-11-26 08:42:48'),
(14, 10003, 10001, '陌生人', '2016-11-26 08:43:02'),
(15, 10003, 10001, '1', '2016-11-26 08:44:07'),
(16, 10001, 10001, '111', '2016-11-26 08:45:22'),
(17, 10003, 10001, '222', '2016-11-26 08:45:27'),
(18, 10003, 10001, '驱蚊器翁', '2016-11-27 07:05:32'),
(19, 10002, 10001, '是是是', '2016-11-28 03:51:30'),
(20, 10003, 10001, '111', '2016-11-28 03:51:35'),
(21, 10002, 10001, '111.1.1.1.', '2016-11-28 03:51:49'),
(22, 10003, 10001, '1111', '2016-11-28 03:51:51'),
(23, 10001, 10001, '1111', '2016-11-28 03:51:53'),
(24, 10002, 10001, '110101', '2016-11-28 03:51:56'),
(25, 10001, 10001, '', '2016-11-30 04:06:36'),
(26, 10001, 10001, '1111122211', '2016-12-02 07:01:37'),
(27, 10003, 10001, '3333\n', '2016-12-02 09:54:49'),
(28, 10003, 10001, '1111\n', '2016-12-02 09:57:32'),
(29, 10001, 10001, '11111', '2016-12-04 11:59:15'),
(30, 10002, 10001, '.1.1.1.1.', '2016-12-04 11:59:24'),
(31, 10002, 10001, '222', '2016-12-04 11:59:26'),
(32, 10001, 10001, '111', '2016-12-04 11:59:30'),
(33, 10001, 10001, '\'dddff', '2016-12-04 12:00:22'),
(34, 10002, 10001, '...\n', '2016-12-04 12:03:07'),
(35, 10002, 10001, '', '2016-12-04 12:03:11'),
(36, 10002, 10001, '', '2016-12-04 12:03:11'),
(37, 10002, 10001, '444242', '2018-06-01 12:56:10'),
(38, 10001, 10001, '444442', '2018-06-01 12:56:14'),
(39, 10002, 10001, '5345343', '2018-06-01 12:56:41'),
(40, 10001, 10001, '你好', '2018-07-02 11:19:51'),
(41, 10002, 10001, '你好吗？', '2018-07-02 11:20:51');

-- --------------------------------------------------------

--
-- 表的结构 `dw_user`
--

CREATE TABLE `dw_user` (
  `user_id` int(10) NOT NULL,
  `user_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `user_password` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `user_email` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `user_sex` char(1) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'M',
  `user_birthday` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `user_avatar` text COLLATE utf8_unicode_ci NOT NULL,
  `user_trades` text COLLATE utf8_unicode_ci NOT NULL,
  `user_registertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `dw_user`
--

INSERT INTO `dw_user` (`user_id`, `user_name`, `user_password`, `user_email`, `user_sex`, `user_birthday`, `user_avatar`, `user_trades`, `user_registertime`) VALUES
(10001, '千千', 'e10adc3949ba59abbe56e057f20f883e', 'test@qq.com', 'M', '1998-01-04', 'http://static.dreamwings.cn/wp-content/uploads/2016/06/10102wq.jpg', 'im0qianqian', '2016-11-20 02:25:12'),
(10002, 'ireson', 'e10adc3949ba59abbe56e057f20f883e', 'i@ireson.cn', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/05/236657.jpg', '这是一个个性签名。This is a character signature.', '2016-11-20 07:33:27'),
(10003, 'colorfulshark', 'e10adc3949ba59abbe56e057f20f883e', 'qian', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/05/color.png', '哈哈哈哈', '2016-11-20 09:13:41'),
(10004, '0page', 'e10adc3949ba59abbe56e057f20f883e', '12223', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/09/u150953173-3.jpg', '', '2016-11-21 13:31:22'),
(10005, 'CSD', 'e10adc3949ba59abbe56e057f20f883e', 'CSD', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/07/FAFAFA.jpg', '', '2016-11-22 09:53:40'),
(10006, 'Hadestack', 'e10adc3949ba59abbe56e057f20f883e', 'Hadestack', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/07/hades.png', '', '2016-11-22 09:53:40'),
(10007, 'Hran', 'e10adc3949ba59abbe56e057f20f883e', 'Hran', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/08/145908560294404_dfbb0aedd561d3011222db097c7c8f1a.jpg', '', '2016-11-22 09:53:40'),
(10008, 'Jrotty', 'e10adc3949ba59abbe56e057f20f883e', 'Jrotty', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/07/3972626619.jpeg', '', '2016-11-22 09:53:40'),
(10009, 'SXB', 'e10adc3949ba59abbe56e057f20f883e', 'SXB', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/07/00367378625f3230316064.jpg', '', '2016-11-22 09:53:40'),
(10010, '点滴回忆', 'e10adc3949ba59abbe56e057f20f883e', '点滴回忆', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/09/100.jpg', '', '2016-11-22 09:53:40'),
(10011, '歇斯底里', 'e10adc3949ba59abbe56e057f20f883e', '歇斯底里', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/07/100-2.jpg', '', '2016-11-22 09:53:40'),
(10012, '兰陵', 'e10adc3949ba59abbe56e057f20f883e', '兰陵', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/05/head.jpg', '', '2016-11-22 09:53:40'),
(10013, '萝卜坑', 'e10adc3949ba59abbe56e057f20f883e', '萝卜坑', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/05/shao.jpg', '', '2016-11-22 09:53:40'),
(10014, '认知', 'e10adc3949ba59abbe56e057f20f883e', '认知', 'M', '', 'http://static.dreamwings.cn/wp-content/uploads/2016/05/xknow.jpg', '', '2016-11-22 09:53:40'),
(10019, '西北风', 'e10adc3949ba59abbe56e057f20f883e', 'test@126.com', 'M', '', '', '西北风', '2016-12-09 08:15:43');

-- --------------------------------------------------------

--
-- 表的结构 `dw_userchat`
--

CREATE TABLE `dw_userchat` (
  `uchat_id` int(10) NOT NULL,
  `uchat_fromid` int(10) NOT NULL,
  `uchat_toid` int(10) NOT NULL,
  `uchat_message` text COLLATE utf8_unicode_ci NOT NULL,
  `uchat_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `dw_userchat`
--

INSERT INTO `dw_userchat` (`uchat_id`, `uchat_fromid`, `uchat_toid`, `uchat_message`, `uchat_datetime`) VALUES
(1, 10002, 10001, '千千 千千', '2016-11-26 07:08:54'),
(2, 10001, 10002, '嗯？', '2016-11-26 07:09:25'),
(3, 10001, 10002, '.', '2016-11-26 07:09:38'),
(4, 10001, 10002, '哈哈哈哈哈', '2016-11-26 07:10:19'),
(5, 10002, 10001, '1111', '2016-11-26 07:10:38'),
(6, 10003, 10004, '24242', '2016-11-26 07:12:32'),
(7, 10002, 10001, '2222', '2016-11-26 07:19:02'),
(8, 10001, 10002, '哈哈', '2016-11-26 07:56:07'),
(9, 10002, 10001, '10', '2016-11-26 07:56:26'),
(10, 10001, 10002, '哈哈', '2016-11-26 08:07:33'),
(11, 10001, 10002, '啦啦啦', '2016-11-26 08:08:24'),
(12, 10002, 10001, '咦', '2016-11-26 08:08:51'),
(13, 10001, 10002, '1', '2016-11-26 08:08:56'),
(14, 10002, 10001, '2', '2016-11-26 08:09:07'),
(15, 10002, 10001, '010011', '2016-11-26 08:09:43'),
(16, 10002, 10001, '111', '2016-11-26 08:09:49'),
(17, 10002, 10001, '1', '2016-11-26 08:09:53'),
(18, 10001, 10002, '....', '2016-11-26 08:09:59'),
(19, 10001, 10002, '哇唔', '2016-11-26 08:37:35'),
(20, 10001, 10002, '...', '2016-11-26 08:37:42'),
(21, 10003, 10001, '咦', '2016-11-26 08:41:44'),
(22, 10001, 10003, '怎么啦', '2016-11-26 08:41:52'),
(23, 10004, 10001, '聊天', '2016-11-26 08:41:59'),
(24, 10001, 10004, '[思考]', '2016-11-26 08:42:09'),
(25, 10001, 10002, 'aaaaaa', '2016-11-28 03:51:01'),
(26, 10002, 10001, '发送到', '2016-11-28 03:51:08'),
(27, 10002, 10001, '试试', '2016-11-28 03:51:11'),
(28, 10001, 10002, '1111', '2016-11-30 05:20:59'),
(29, 10001, 10002, '<img src=\"http://www.dreamwings.cn/queue/wp-content/uploads/2016/10/timg.jpg\">', '2016-11-30 05:24:30'),
(30, 10003, 10011, 'sb\n', '2016-12-02 07:08:23'),
(31, 10001, 10002, '', '2016-12-02 09:03:56'),
(32, 10003, 10001, '111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', '2016-12-02 09:50:03'),
(33, 10003, 10001, '111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n111111111111111111111111111111111111111\n\n111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\n', '2016-12-02 09:51:19'),
(34, 10003, 10001, 'sdfdsvdfb\n', '2016-12-02 10:02:58'),
(35, 10001, 10002, '<img>', '2016-12-04 12:02:05'),
(36, 10001, 10002, '11111', '2016-12-09 05:23:37'),
(37, 10002, 10001, '22222', '2016-12-09 05:23:41'),
(38, 10001, 10002, '1', '2016-12-09 05:25:48'),
(39, 10001, 10002, '1', '2016-12-09 05:25:50'),
(40, 10001, 10003, '...', '2016-12-09 05:34:50'),
(41, 10001, 10003, '大是多少阿萨德', '2016-12-09 05:34:57'),
(42, 10003, 10001, '啊啊啊', '2016-12-09 05:35:00'),
(43, 10001, 10005, '往前', '2016-12-09 05:35:43'),
(44, 10001, 10005, '5785\n709', '2016-12-09 05:36:02'),
(45, 10001, 10005, '我的\n\n875', '2016-12-09 05:36:19'),
(46, 10001, 10005, '1321321<br/>aaaaaf\n', '2016-12-09 05:36:46'),
(47, 10001, 10002, '1111', '2016-12-09 06:33:01'),
(48, 10002, 10001, 'hello\n', '2016-12-09 08:18:12'),
(49, 10001, 10003, '1111', '2018-03-29 02:56:51'),
(50, 10002, 10001, 'Hello World!\n', '2018-03-29 03:02:10'),
(51, 10002, 10001, '<img src=\"http://www.dreamwings.cn/wp-content/uploads/2016/06/10102wq.jpg\"/>', '2018-03-29 03:02:45'),
(52, 10002, 10001, '<img src=\"https://www.dreamwings.cn/wp-content/uploads/2016/06/10102wq.jpg\"/>', '2018-03-29 03:03:07'),
(53, 10002, 10001, '111111', '2018-06-01 12:54:34'),
(54, 10002, 10001, '1111', '2018-06-01 12:55:00'),
(55, 10002, 10001, '1111', '2018-06-01 12:55:04'),
(56, 10002, 10001, '222323', '2018-06-01 12:55:34'),
(57, 10001, 10002, '1111444', '2018-06-01 12:55:40'),
(58, 10001, 10002, '111131313', '2018-06-01 12:55:48'),
(59, 10001, 10002, '哈哈哈', '2018-06-01 12:57:58'),
(60, 10002, 10001, '11111', '2018-07-02 11:17:02'),
(61, 10001, 10002, '1111242', '2018-07-02 11:17:15'),
(62, 10002, 10001, 'hahah', '2018-07-02 11:17:52');

-- --------------------------------------------------------

--
-- 表的结构 `dw_usergroup`
--

CREATE TABLE `dw_usergroup` (
  `user_id` int(10) NOT NULL,
  `group_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `dw_usergroup`
--

INSERT INTO `dw_usergroup` (`user_id`, `group_id`) VALUES
(10001, 10001),
(10001, 10002),
(10002, 10001),
(10002, 10002),
(10003, 10001);

-- --------------------------------------------------------

--
-- 表的结构 `dw_useruser`
--

CREATE TABLE `dw_useruser` (
  `myself` int(10) NOT NULL,
  `myfriend` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `dw_useruser`
--

INSERT INTO `dw_useruser` (`myself`, `myfriend`) VALUES
(10001, 10002),
(10001, 10003),
(10001, 10004),
(10001, 10005),
(10001, 10006),
(10001, 10007),
(10001, 10008),
(10001, 10009),
(10001, 10010),
(10001, 10011),
(10001, 10012),
(10001, 10013),
(10001, 10014),
(10002, 10001),
(10002, 10003),
(10002, 10004),
(10002, 10005),
(10002, 10006),
(10002, 10007),
(10002, 10008),
(10002, 10009),
(10002, 10010),
(10002, 10011),
(10002, 10012),
(10002, 10013),
(10002, 10014),
(10003, 10001),
(10003, 10004),
(10003, 10005),
(10003, 10006),
(10003, 10007),
(10003, 10008),
(10003, 10009),
(10003, 10010),
(10003, 10011),
(10003, 10012),
(10003, 10013),
(10003, 10014),
(10004, 10001),
(10004, 10005),
(10004, 10006),
(10004, 10007),
(10004, 10008),
(10004, 10009),
(10004, 10010),
(10004, 10011),
(10004, 10012),
(10004, 10013),
(10004, 10014),
(10005, 10001),
(10005, 10006),
(10005, 10007),
(10005, 10008),
(10005, 10009),
(10005, 10010),
(10005, 10011),
(10005, 10012),
(10005, 10013),
(10005, 10014),
(10006, 10001),
(10006, 10007),
(10006, 10008),
(10006, 10009),
(10006, 10010),
(10006, 10011),
(10006, 10012),
(10006, 10013),
(10006, 10014);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `view_usergroup`
-- (See below for the actual view)
--
CREATE TABLE `view_usergroup` (
`group_id` int(10)
,`group_name` varchar(20)
,`group_avatar` text
,`group_trades` text
,`user_id` int(10)
);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `view_useruser`
-- (See below for the actual view)
--
CREATE TABLE `view_useruser` (
`myself` int(10)
,`myfriend` int(10)
,`user_name` varchar(20)
,`user_avatar` text
,`user_trades` text
);

-- --------------------------------------------------------

--
-- 视图结构 `view_usergroup`
--
DROP TABLE IF EXISTS `view_usergroup`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_usergroup`  AS  (select `dw_group`.`group_id` AS `group_id`,`dw_group`.`group_name` AS `group_name`,`dw_group`.`group_avatar` AS `group_avatar`,`dw_group`.`group_trades` AS `group_trades`,`dw_usergroup`.`user_id` AS `user_id` from (`dw_group` join `dw_usergroup`) where (`dw_group`.`group_id` = `dw_usergroup`.`group_id`)) ;

-- --------------------------------------------------------

--
-- 视图结构 `view_useruser`
--
DROP TABLE IF EXISTS `view_useruser`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_useruser`  AS  (select `dw_useruser`.`myself` AS `myself`,`dw_useruser`.`myfriend` AS `myfriend`,`dw_user`.`user_name` AS `user_name`,`dw_user`.`user_avatar` AS `user_avatar`,`dw_user`.`user_trades` AS `user_trades` from (`dw_user` join `dw_useruser`) where (`dw_user`.`user_id` = `dw_useruser`.`myfriend`) order by `dw_useruser`.`myself`) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dw_group`
--
ALTER TABLE `dw_group`
  ADD PRIMARY KEY (`group_id`),
  ADD KEY `group_master` (`group_master`);

--
-- Indexes for table `dw_groupchat`
--
ALTER TABLE `dw_groupchat`
  ADD PRIMARY KEY (`gchat_id`),
  ADD KEY `gchat_uid` (`gchat_uid`),
  ADD KEY `gchat_gid` (`gchat_gid`);

--
-- Indexes for table `dw_user`
--
ALTER TABLE `dw_user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_email` (`user_email`);

--
-- Indexes for table `dw_userchat`
--
ALTER TABLE `dw_userchat`
  ADD PRIMARY KEY (`uchat_id`),
  ADD KEY `uchat_fromid` (`uchat_fromid`),
  ADD KEY `uchat_toid` (`uchat_toid`);

--
-- Indexes for table `dw_usergroup`
--
ALTER TABLE `dw_usergroup`
  ADD PRIMARY KEY (`user_id`,`group_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `group_id` (`group_id`);

--
-- Indexes for table `dw_useruser`
--
ALTER TABLE `dw_useruser`
  ADD PRIMARY KEY (`myself`,`myfriend`),
  ADD KEY `myself` (`myself`),
  ADD KEY `myfriend` (`myfriend`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `dw_group`
--
ALTER TABLE `dw_group`
  MODIFY `group_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10003;

--
-- 使用表AUTO_INCREMENT `dw_groupchat`
--
ALTER TABLE `dw_groupchat`
  MODIFY `gchat_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- 使用表AUTO_INCREMENT `dw_user`
--
ALTER TABLE `dw_user`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10020;

--
-- 使用表AUTO_INCREMENT `dw_userchat`
--
ALTER TABLE `dw_userchat`
  MODIFY `uchat_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- 限制导出的表
--

--
-- 限制表 `dw_group`
--
ALTER TABLE `dw_group`
  ADD CONSTRAINT `dw_group_ibfk_1` FOREIGN KEY (`group_master`) REFERENCES `dw_user` (`user_id`) ON DELETE CASCADE;

--
-- 限制表 `dw_groupchat`
--
ALTER TABLE `dw_groupchat`
  ADD CONSTRAINT `dw_groupchat_ibfk_1` FOREIGN KEY (`gchat_uid`) REFERENCES `dw_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dw_groupchat_ibfk_2` FOREIGN KEY (`gchat_gid`) REFERENCES `dw_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `dw_userchat`
--
ALTER TABLE `dw_userchat`
  ADD CONSTRAINT `dw_userchat_ibfk_1` FOREIGN KEY (`uchat_fromid`) REFERENCES `dw_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dw_userchat_ibfk_2` FOREIGN KEY (`uchat_toid`) REFERENCES `dw_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `dw_usergroup`
--
ALTER TABLE `dw_usergroup`
  ADD CONSTRAINT `dw_usergroup_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `dw_user` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `dw_usergroup_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `dw_group` (`group_id`) ON DELETE CASCADE;

--
-- 限制表 `dw_useruser`
--
ALTER TABLE `dw_useruser`
  ADD CONSTRAINT `dw_useruser_ibfk_1` FOREIGN KEY (`myself`) REFERENCES `dw_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dw_useruser_ibfk_2` FOREIGN KEY (`myfriend`) REFERENCES `dw_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
