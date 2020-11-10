DROP TABLE IF EXISTS `order_demo`;
CREATE TABLE `order_demo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `orderSN` varchar(255) DEFAULT NULL,
  `state` integer DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


