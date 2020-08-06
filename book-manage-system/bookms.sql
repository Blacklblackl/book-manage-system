

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `book_id` VARCHAR(20) NOT NULL COMMENT '图书ID',
  `book_name` VARCHAR(100) NOT NULL COMMENT '图书名称',
  `author_name` VARCHAR(50) NOT NULL COMMENT '作者名称',
  `status` INT(11) NOT NULL COMMENT '状态：0外借，1在馆，2遗失',
  `keyword` VARCHAR(150) DEFAULT NULL COMMENT '关键词',
  `introduction` TEXT COMMENT '简介',
  `isbn` VARCHAR(30) DEFAULT NULL COMMENT 'ISBN',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_bookid` (`book_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='图书表';

insert into `book` (`id`, `book_id`, `book_name`, `author_name`, `status`, `keyword`, `introduction`, `isbn`, `create_time`, `update_time`) values('1','0002','软件架构设计','温昱','1','软件','介绍软件架构设计','0001','2020-08-05 10:19:45','2020-08-05 11:45:12');
insert into `book` (`id`, `book_id`, `book_name`, `author_name`, `status`, `keyword`, `introduction`, `isbn`, `create_time`, `update_time`) values('2','0001','代码整洁之道','Robert C.Martin','0','软件','介绍代码编写','0002','2020-08-05 14:34:45','2020-08-05 14:34:45');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
 `id` INT(11) NOT NULL AUTO_INCREMENT,
 `username` VARCHAR(255) NOT NULL COMMENT '用户名',
 `password` VARCHAR(255) NOT NULL COMMENT '加密后的用户密码',
 `locked_flag` BIT(1) NOT NULL COMMENT '用户状态',
 PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';

insert into `user` (`id`, `username`, `password`, `locked_flag`) values('1','admin','202cb962ac59075b964b07152d234b70','');


