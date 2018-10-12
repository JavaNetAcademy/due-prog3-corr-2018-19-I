CREATE TABLE `pet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `heroid` bigint(20) NOT NULL,
  `level` int(11) NOT NULL,
  `damage` int(11) NOT NULL,
  `defense` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pet_1_idx` (`heroid`),
  CONSTRAINT `fk_pet_1` FOREIGN KEY (`heroid`) REFERENCES `hero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1
