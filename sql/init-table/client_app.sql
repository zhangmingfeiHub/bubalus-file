DROP TABLE IF EXISTS `client_app`;
CREATE TABLE IF NOT EXISTS `client_app` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `app_id` varchar(60) NOT NULL DEFAULT '' COMMENT '应用唯一标识',
  `app_name` varchar(20) NOT NULL DEFAULT '' COMMENT '应用名称',
  `app_desc` varchar(100) NOT NULL DEFAULT '' COMMENT '应用描述',
  `pub_secret` varchar(60) NOT NULL DEFAULT '' COMMENT '公钥',
  `pri_secret` varchar(60) NOT NULL DEFAULT '' COMMENT '私钥',
  `token` varchar(200) NOT NULL DEFAULT '' COMMENT 'token',
  `app_status` int(4) NOT NULL DEFAULT '1' COMMENT '状态，1-有效，0-无效',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_operator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建者',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_operator` varchar(100) NOT NULL DEFAULT '' COMMENT '创建者',
  PRIMARY KEY (`id`),
	UNIQUE KEY `unq_app_id` (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户端应用信息';