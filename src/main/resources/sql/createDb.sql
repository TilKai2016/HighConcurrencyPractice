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

CREATE TABLE `goods` (
  `id` BIGINT(20) NOT NULL COMMENT '商品ID',
	`goods_name` VARCHAR(255) DEFAULT NULL,
	`goods_title` VARCHAR(64) DEFAULT NULL,
	`goods_img` VARCHAR(64) DEFAULT NULL,
	`goods_detail` LONGTEXT,
	`goods_price` DECIMAL(10,2) DEFAULT '0.00',
	`goods_stock` INT(11) DEFAULT '0' COMMENT '商品库存, -1表示没有限制' ,
	PRIMARY KEY (`id`)
)

CREATE TABLE `miaosha_goods` (
  `id` BIGINT(20) NOT NULL COMMENT '秒杀商品ID',
	`goods_id` BIGINT(20) DEFAULT NULL,
	`miaosha_price` DECIMAL(10,2) DEFAULT '0.00',
	`stock_count` INT(11) DEFAULT NULL ,
	`start_date` DATETIME DEFAULT NULL COMMENT '秒杀开始时间',
	`end_date` DATETIME DEFAULT NULL COMMENT '秒杀结束时间',
	PRIMARY KEY (`id`)
)

CREATE TABLE `order_info` (
  `id` BIGINT(20) NOT NULL COMMENT '订单ID',
	`user_id` BIGINT(20) DEFAULT NULL COMMENT '用户ID',
	`goods_id` BIGINT(20) DEFAULT NULL COMMENT '商品ID',
	`delivery_addr_id` BIGINT(20) DEFAULT NULL COMMENT '交付地址ID',
	`goods_name` VARCHAR(255) DEFAULT NULL,
	`goods_count` INT(11) DEFAULT NULL ,
	`goods_price` DECIMAL(10,2) DEFAULT '0.00',
	`order_channel` TINYINT(4) DEFAULT '0' COMMENT '1pc, 2android, 3ios' ,
	`status` TINYINT(4) DEFAULT '0' COMMENT '订单状态 0新建未支付, 1已支付, 2已发货, 3已收货, 4已退款, 5已完成' ,
	`create_date` DATETIME DEFAULT NULL COMMENT '订单创建时间',
	`pay_date` DATETIME DEFAULT NULL COMMENT '订单支付时间',
	PRIMARY KEY (`id`)
)

CREATE TABLE `miaosha_order` (
  `id` BIGINT(20) NOT NULL COMMENT '订单ID',
	`user_id` BIGINT(20) DEFAULT NULL COMMENT '用户ID',
	`order_id` BIGINT(20) DEFAULT NULL COMMENT '订单ID',
	`goods_id` BIGINT(20) DEFAULT NULL COMMENT '商品ID',
	PRIMARY KEY (`id`)
)
