USE hoe;

DROP TABLE IF EXISTS naturaldisaster;

CREATE TABLE naturaldisaster (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(200) NOT NULL,
	effect  VARCHAR(200) NOT NULL,
	deadlyto VARCHAR(200) NOT NULL,	
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO vehicle (name, description, effect, deadlyto)
VALUES ('cyclone', 'A system of winds rotating inwards', 'Destroy small settlements','settlements');

INSERT INTO vehicle (name, description, effect, deadlyto)
VALUES ('sleet', 'Make the roads very slippy', 'Make veichles uncontrolable','veichles');

INSERT INTO vehicle (name, description, effect, deadlyto)
VALUES ('epidemic', 'Make the living things sick', 'Kill living things','heros,pets');

INSERT INTO vehicle (name, description, effect, deadlyto)
VALUES ('conflagration', 'Can burn down big provinces', 'Can burn down a whole empire','empires');


