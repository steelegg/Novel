-- book表
CREATE TABLE `db_book`.`book_date` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) NOT NULL,
  `author` varchar(20) NOT NULL DEFAULT '未知',
  `type` varchar(20) NOT NULL DEFAULT '未知',
  `introduction` varchar(4000) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `click` int(11) NOT NULL DEFAULT '0',
  `chapter_number` int(11) NOT NULL DEFAULT '0',
  `collection` int(11) NOT NULL DEFAULT '0',
  `recommended` int(11) NOT NULL DEFAULT '0',
  `cover` varchar(100) DEFAULT NULL,
  `level` tinyint(4) NOT NULL DEFAULT '0',
  `last_update_time` varchar(100) NOT NULL DEFAULT '未知',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
  `start_id` int(11) NOT NULL DEFAULT '0' COMMENT '起始位置',
  `end_id` int(11) NOT NULL DEFAULT '0' COMMENT '结束位置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- 章节表

CREATE TABLE `db_book`.`chapter` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `chapter_name` varchar(400) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `update_time` varchar(10) NOT NULL,
  `content` varchar(20000) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

--用户表

CREATE TABLE `db_book`.`user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '无名者' COMMENT '昵称',
  `mobile` bigint(11) NOT NULL,
  `password` varchar(32) NOT NULL,
  `declaration` varchar(200) COMMENT '宣言',
  `portrait` varchar(50) COMMENT '头像',
  `status` tinyint COMMENT '用户状态',
  `level` tinyint COMMENT '用户等级',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY(`id`)
)ENGINE=InnoDB CHARSET=utf8;