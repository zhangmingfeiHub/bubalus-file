DROP TABLE IF EXISTS `sys_auth_menu_rela`;
CREATE TABLE IF NOT EXISTS `sys_auth_menu_rela` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `auth_code` varchar(60) NOT NULL DEFAULT '' COMMENT '权限码（唯一性）',
  `menu_code` varchar(60) NOT NULL DEFAULT '' COMMENT '菜单码（唯一性）',
  PRIMARY KEY (`id`),
	KEY `key_auth_code` (`auth_code`),
	KEY `key_menu_code` (`menu_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限菜单关联表';