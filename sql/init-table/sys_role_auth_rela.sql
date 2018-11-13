DROP TABLE IF EXISTS `sys_role_auth_rela`;
CREATE TABLE IF NOT EXISTS `sys_role_auth_rela` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_code` varchar(60) NOT NULL DEFAULT '' COMMENT '角色码（唯一性）',
  `auth_code` varchar(60) NOT NULL DEFAULT '' COMMENT '权限码（唯一性）',
  PRIMARY KEY (`id`),
	KEY `key_role_code` (`role_code`),
	KEY `key_auth_code` (`auth_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联表';