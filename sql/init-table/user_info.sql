DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `open_id` varchar(100) NOT NULL DEFAULT '' COMMENT '唯一标识',
  `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号码（唯一性）',
  `account` varchar(60) NOT NULL DEFAULT '' COMMENT '账号（唯一性）',
  `user_name` varchar(60) NOT NULL DEFAULT '' COMMENT '用户名称',
  `nick_name` varchar(60) NOT NULL DEFAULT '' COMMENT '昵称',
  `password` varchar(60) NOT NULL DEFAULT '' COMMENT '密码',
  `delete_status` int(4) NOT NULL DEFAULT '0' COMMENT '状态，0-有效，1-无效',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_operator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_operator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建者',
  PRIMARY KEY (`id`),
	KEY `key_open_id` (`open_id`),
	KEY `key_mobile` (`mobile`),
	KEY `key_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';
