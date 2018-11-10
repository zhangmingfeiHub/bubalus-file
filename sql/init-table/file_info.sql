DROP TABLE IF EXISTS `file_info`;
CREATE TABLE IF NOT EXISTS `file_info` (
	`id` BIGINT(20) NOT NULL auto_increment COMMENT '主键ID',
	`origin_name` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '文件原始名称',
	`transfer_name` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '转换后的名称',
	`suffix` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '文件后缀',
	`size` INT(10) NOT NULL DEFAULT '0' COMMENT '文件大小（byte）',
	`from_source` VARCHAR(10) NOT NULL DEFAULT '' COMMENT '文件来源（看码表）',
	`path` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '文件路径',
	`url` VARCHAR(500) NOT NULL DEFAULT '' COMMENT '文件访问url',
	`create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_operator` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_operator` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建者',
	PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='文件信息表';