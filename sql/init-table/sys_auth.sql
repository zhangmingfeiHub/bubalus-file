DROP TABLE IF EXISTS `sys_auth`;
CREATE TABLE IF NOT EXISTS `sys_auth` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `auth_code` varchar(60) NOT NULL DEFAULT '' COMMENT '权限码（唯一性）',
  `auth_name` varchar(100) NOT NULL DEFAULT '' COMMENT '权限名称（唯一性）',
  `auth_desc` varchar(200) NOT NULL DEFAULT '' COMMENT '描述',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_operator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_operator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建者',
  PRIMARY KEY (`id`),
	UNIQUE KEY `unq_auth_code` (`auth_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限信息';