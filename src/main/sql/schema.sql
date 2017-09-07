-- 数据库初始化脚本
-- 创建数据库
CREATE DATABASE seckill;
user seckill;
CREATE TABLE seckill(
  `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  `name` VARCHAR (120) NOT NULL COMMENT '商品名称',
  `number` int NOT NULL COMMENT '库存数量',
  `start_time` TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
  `end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  key idx_end_time(end_time),
  KEY idx_create_time(create_time)

)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表'

INSERT INTO
  seckill(name,number,start_time,end_time)
VALUES
  ('1000元秒杀iPhone8',100,'2017-9-8 00:00:00','2017-9-9 00:00:00'),
  ('500元秒杀iPadPro',200,'2017-9-8 00:00:00','2017-9-9 00:00:00'),
  ('300元秒杀小米MIX2',300,'2017-9-8 00:00:00','2017-9-9 00:00:00'),
  ('200元秒杀小米6s',400,'2017-9-8 00:00:00','2017-9-9 00:00:00'),

--秒杀成功明细表
--用户登录认证相关信息
CREATE TABLE success killed(
`seckill_id` bigint not null comment '',
`user_phone`bigint not null comment '',
`state` tinyint NOT NULL DEFAULT -1 comment '状态标示：-1：无效 0：成功 1：已付款',
`create_time` TIMESTAMP NOT NULL comment '创建时间',
PRIMARY KEY (seckill_id,user_phone), /*联合主键**/
KEY idx_create_time(create_time)

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细'

--连接数据控制台
mysql -uroot -p

--为什么要手写DDL
--记录每次上线的DDL修改
--上线v1.1