CREATE TABLE `skills` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `offensive` tinyint(1) NOT NULL,
  `valueInCombat` bigint(20) DEFAULT 1,
  `reqLevel` bigint(20) DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `skills_of_heroes` (
 	`skill_id` bigint(20) NOT NULL,
	`hero_id` bigint(20) NOT NULL,
	`skill_level` bigint(20) DEFAULT 1,
	PRIMARY KEY (`skill_id`, `hero_id`),
	CONSTRAINT `SKILLS_HERO_CONSTRAINT_1` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `SKILLS_HERO_CONSTRAINT_2` FOREIGN KEY (`hero_id`) REFERENCES `hero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `skills_for_job` (
 	`skill_id` bigint(20) NOT NULL,
	`job_id` bigint(20) NOT NULL,
	PRIMARY KEY (`skill_id`, `job_id`),
	CONSTRAINT `SKILLS_JOB_CONSTRAINT_1` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `SKILLS_JOB_CONSTRAINT_2` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;