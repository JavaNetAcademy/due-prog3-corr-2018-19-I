CREATE TABLE `speciesspecialproperty` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `speciesid` bigint(20) NOT NULL,
  `level` int(11) NOT NULL,
  `damage` int(11) NOT NULL,
  `defense` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ssp_1_idx` (`speciesid`),
  CONSTRAINT `fk_ssp_1` FOREIGN KEY (`speciesid`) REFERENCES `species` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;