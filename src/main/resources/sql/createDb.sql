CREATE TABLE `miaosha_user` (
  `id` BIGINT(20) NOT NULL COMMENT '用户ID, 手机号码',
	`nickname` VARCHAR(255) NOT NULL,
	`password` VARCHAR(32) DEFAULT NULL,
	`salt` VARCHAR(10),
	`head` VARCHAR(128),
	`register_date` DATETIME,
	`last_login_date` DATETIME,
	`login_count` INT(11) DEFAULT '0',
	PRIMARY KEY (`id`)
)