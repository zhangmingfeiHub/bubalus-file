DROP TABLE IF EXISTS `user_role_rela`;
CREATE TABLE IF NOT EXISTS `user_role_rela` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `open_id` varchar(100) NOT NULL DEFAULT '' COMMENT '唯一标识',
  `role_code` varchar(60) NOT NULL DEFAULT '' COMMENT '角色码（唯一性）',
  PRIMARY KEY (`id`),
	KEY `key_open_id` (`open_id`),
	KEY `key_role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';