-- 小说网站数据表

CREATE TABLE `db_book`.`book_date` (
	`id` int(0) UNSIGNED AUTO_INCREMENT NOT NULL,
	`book_name` varchar(20) NOT NULL,
	`author` varchar(20) NOT NULL,
	`introduction` varchar(20),
	`status` tinyint DEFAULT 1 NOT NULL,
	`click` int DEFAULT 0 NOT NULL,
	`chapter_number` int NOT NULL,
	`collection` int DEFAULT 0 NOT NULL,
	`recommended` int DEFAULT 0 NOT NULL,
	`cover` varchar(100),
	`level` tinyint DEFAULT 0 NOT NULL,
	`last_update_time` varchar(100) NOT NULL,
	`create_at` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' NOT NULL,
	PRIMARY KEY (`id`)
);











-- 求学大作战数据表

-- 学生表
CREATE TABLE `qx_db`.`student`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nick` varchar(50) NOT NULL COMMENT '昵称',
  `alias` varchar(20) COMMENT '用户名',
  `grade` tinyint(0) COMMENT '年纪',
  `mobile` varchar(20) COMMENT '手机',
  `mail` varchar(20) COMMENT '邮箱',
  `img` varchar(100) COMMENT '头像',
  `score` tinyint(0) COMMENT '获得星数',
  `status` tinyint(0) COMMENT '状态',
  PRIMARY KEY (`id`)
);


-- 文档表
CREATE TABLE `qx_db`.`document`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '文档id',
  `title` varchar(50) NOT NULL COMMENT '名称',
  `author` varchar(20)  COMMENT '作者',
  `type` tinyint(0) NOT NULL COMMENT '种类',
  `img` varchar(50) COMMENT '图片',
  `content` varchar(5000) COMMENT '正文',
  `summary` varchar(100) COMMENT '摘要',
  `love` bigint(0) COMMENT '点赞数',
  `collection` bigint(0) COMMENT '收藏数',
   PRIMARY KEY (`id`)
);



-- 视频表
CREATE TABLE `qx_db`.`void`(
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '视频id',
  `title` varchar(50) NOT NULL COMMENT '名称',
  `type` tinyint(0) COMMENT '种类',
  `coverImg` varchar(100) COMMENT '封面图片',
  `summary` varchar(100) COMMENT '摘要',
  `content` varchar(5000) COMMENT '正文',
  `grade` tinyint(0)	COMMENT '年级',
  `subject` tinyint(0) COMMENT '科目',
  `teacherName`	varchar(20) COMMENT '教师名称	',
  `teacherImg`	varchar(100) COMMENT '教师头像',
  `url` varchar(100) COMMENT '视频地址',
  `duration` varchar(50) COMMENT '视频时长'	,
  `code` tinyint(0) COMMENT '状态码',
  `time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
   PRIMARY KEY (`id`)
);

-- 教师
CREATE TABLE `qx_db`.`teacher` (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `name` varchar(20) COMMENT '名称',
  `photo` varchar(50) COMMENT '头像',
  PRIMARY KEY (`id`)
);


-- 帖子
CREATE TABLE `qx_db`.`posts`(
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `uid` bigint(0) NOT NULL COMMENT '帖子作者',
  `grade` varchar(10) NOT NULL COMMENT '板块',
  `sticky` tinyint(0) COMMENT '置顶', 
  `digest` varchar(10) COMMENT '加精', 
  `title` varchar(40) NOT NULL COMMENT '标题',
  `repliesCount` varchar(20) COMMENT '回复数',
  `readCount` bigint(0) COMMENT '阅读数',
  `firstImg` int COMMENT '首图',
  `content` varchar(5000) COMMENT '正文',
  `stickyAt` varchar(50) COMMENT '置顶时间',
  `digesAt` varchar(50) COMMENT '加精时间',
  `author` bigint(0) COMMENT '作者',
  `createAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
);

-- 回帖
CREATE TABLE `qx_db`.`reply`(
  `id` bigint(0) COMMENT '回帖id',
  `uid` bigint(0) COMMENT '回帖作者id',
  `pid` bigint(0) COMMENT '回复帖子id',
  `floor` int(0) COMMENT '回复楼层',
  `content` varchar(500) COMMENT '回帖正文',
  `author` varchar(20) COMMENT '回帖作者名称',
  `createAt` varchar(50) COMMENT '发布时间',
  PRIMARY KEY (`id`)
);

-- 树叶相关








