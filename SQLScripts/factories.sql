CREATE TABLE `factories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL DEFAULT '',
  `description` varchar(300) NOT NULL DEFAULT '',
  `userid` bigint(20) DEFAULT NULL,
  `empireid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `factories_user_id_fk` (`userid`),
  KEY `factories_empires_id_fk` (`empireid`),
  CONSTRAINT `factories_empires_id_fk` FOREIGN KEY (`empireid`) REFERENCES `empires` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `factories_user_id_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;