/*id,név,(tulajdonságok), ár*/
CREATE TABLE `properties_codebook`( 
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(20) NOT NULL,
  `offensive_value` bigint(20) NOT NULL DEFAULT 0,
  `defensive_value` bigint(20) NOT NULL DEFAULT 0,
  `dexterity` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
  /*STB....*/
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Páncél(Armor) tábla*/
CREATE TABLE `armor` ( 
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`code` varchar(20) NOT NULL,
	`name` varchar(20) NOT NULL,
	`description` varchar(20) NOT NULL,
    `price` bigint(20) NOT NULL DEFAULT 1,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `armor_hero_xref` ( 
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
    `armor_id` bigint(20) NOT NULL,
    `hero_id` bigint(20) NOT NULL,
	PRIMARY KEY (`id`),
    KEY `armor_id` (`armor_id`),
    KEY `hero_id` (`hero_id`),
	CONSTRAINT `AHX_ARMOR_CONSTRAINT` FOREIGN KEY (`armor_id`) REFERENCES `armor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `AHX_HERO_CONSTRAINT` FOREIGN KEY (`hero_id`) REFERENCES `hero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `armor_properties_codebook_xref` ( 
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
    `armor_id` bigint(20) NOT NULL,
    `properties_codebook_id` bigint(20) NOT NULL,
	PRIMARY KEY (`id`),
	KEY `armor_id` (`armor_id`),
    KEY `properties_codebook_id` (`properties_codebook_id`),
	CONSTRAINT `APCX_ARMOR_CONSTRAINT` FOREIGN KEY (`armor_id`) REFERENCES `armor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `APCX_PROPERTIES_CODEBOOK_CONSTRAINT` FOREIGN KEY (`properties_codebook_id`) REFERENCES `properties_codebook` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;