CREATE TABLE `species` (
 
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
 
	`name` varchar(20) NOT NULL,

	`description` varchar(20) NOT NULL,

	PRIMARY KEY (`id`)

)ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `speciesxhero` (
 
	`id` bigint(20) NOT NULL AUTO_INCREMENT,

	`speciesid` bigint(20) NOT NULL,

	`heroid` bigint(20) NOT NULL,

	PRIMARY KEY (`id`),

    KEY `species_id` (`speciesid`),

    KEY `hero_id` (`heroid`),

	CONSTRAINT `speciesXHERO_CONSTRAINT` FOREIGN KEY (`speciesid`) REFERENCES `species` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT `speciesXHERO_HERO_CONSTRAINT` FOREIGN KEY (`heroid`) REFERENCES `hero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE

)ENGINE=InnoDB DEFAULT CHARSET=latin1;