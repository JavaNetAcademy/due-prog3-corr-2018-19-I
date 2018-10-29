CREATE TABLE `settlements` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `empireid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `empireid` (`empireid`),
  CONSTRAINT `fk_empire_1` FOREIGN KEY (`empireid`) REFERENCES `empires` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1