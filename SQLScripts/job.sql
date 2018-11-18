CREATE TABLE `job` (
 
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
 
	`name` varchar(20) NOT NULL,

	`description` varchar(20) NOT NULL,

	PRIMARY KEY (`id`)

)ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `jobxhero` (
 
	`id` bigint(20) NOT NULL AUTO_INCREMENT,

	`jobid` bigint(20) NOT NULL,

	`heroid` bigint(20) NOT NULL,

	`level` bigint(20) NOT NULL,

	`xp` bigint(20) NOT NULL,
	PRIMARY KEY (`id`),

    KEY `job_id` (`jobid`),

    KEY `hero_id` (`heroid`),

	CONSTRAINT `JOBXHERO_CONSTRAINT` FOREIGN KEY (`jobid`) REFERENCES `job` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT `JOBXHERO_HERO_CONSTRAINT` FOREIGN KEY (`heroid`) REFERENCES `hero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE

)ENGINE=InnoDB DEFAULT CHARSET=latin1;