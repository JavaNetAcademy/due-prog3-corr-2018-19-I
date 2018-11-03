CREATE TABLE `weapons` (
 `id` int(20) NOT NULL AUTO_INCREMENT,
 `name` varchar(255) COLLATE utf8_bin NOT NULL,
 `description` text COLLATE utf8_bin,
 `price` int(11) NOT NULL,
 `userid` bigint(20) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Fegyverek'

CREATE TABLE `weapon_properties` (
 `weapon_id` int(20) NOT NULL,
 `property_id` int(20) NOT NULL,
 PRIMARY KEY (`weapon_id`,`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1