DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `menu_code` varchar(60) NOT NULL DEFAULT '' COMMENT '菜单码（唯一性）',
  `menu_name` varchar(100) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `menu_link` varchar(100) NOT NULL DEFAULT '' COMMENT '菜单链接',
  `menu_desc` varchar(200) NOT NULL DEFAULT '' COMMENT '描述',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_operator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_operator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建者',
  PRIMARY KEY (`id`),
	UNIQUE KEY `unq_menu_code` (`menu_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单信息';