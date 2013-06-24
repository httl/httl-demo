CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL COMMENT '书名',
  `author` varchar(32) NOT NULL COMMENT '作者',
  `publisher` varchar(32) NOT NULL COMMENT '出版商',
  `publication` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '出版日期',
  `price` decimal(5,2) NOT NULL COMMENT '价格',
  `discount` tinyint(2) NOT NULL DEFAULT '0' COMMENT '折扣',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='书籍表'
