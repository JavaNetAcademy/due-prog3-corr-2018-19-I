CREATE TABLE `culturalbuilding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL DEFAULT '',
  `description` varchar(300) NOT NULL DEFAULT '',
  `empireid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `culturalbuildings_empires_id_fk` (`empireid`),
  CONSTRAINT `culturalbuildings_empires_id_fk` FOREIGN KEY (`empireid`) REFERENCES `empires` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;