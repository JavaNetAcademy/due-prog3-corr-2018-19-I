-- STEP 1: Use the correct database

USE hoe;


-- STEP 2: Drop vehicle table if exists

DROP TABLE IF EXISTS vehicle;


-- STEP 3: Create table for vehicle types.
-- avg_speed: The default speed of the vehicle. (in km/h)
-- max_speed: The maximum (temporary) speed. (in km/h)
-- max_speed_timeout: How long can the maximum speed can be maintained. (in seconds.)
-- max_load: The transportable load weight that can be carried by the vehicle. (in kg.)
-- crew: The default speed of the vehicle.
-- price: The standard price of the vehicle. (in universal gold)

CREATE TABLE vehicle (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(200) NOT NULL,
	avg_speed INT UNSIGNED NOT NULL,
	max_speed INT UNSIGNED NOT NULL,
	max_speed_timeout INT UNSIGNED NOT NULL,
	max_load INT UNSIGNED NOT NULL,
	crew INT UNSIGNED NOT NULL,
	price INT UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- STEP4: Insert default vehicles (sample data)

INSERT INTO vehicle (name, description, avg_speed, max_speed, max_speed_timeout, max_load, crew, price)
VALUES ('bicycle', 'A usual bicycle', 20, 40, 60, 30, 1, 1);

INSERT INTO vehicle (name, description, avg_speed, max_speed, max_speed_timeout, max_load, crew, price)
VALUES ('small truck', 'A usual small truck', 80, 130, 600, 3500, 1, 1000);

INSERT INTO vehicle (name, description, avg_speed, max_speed, max_speed_timeout, max_load, crew, price)
VALUES ('big truck', 'A big truck', 80, 130, 600, 12000, 2, 3000);

INSERT INTO vehicle (name, description, avg_speed, max_speed, max_speed_timeout, max_load, crew, price)
VALUES ('cargo aircraft', 'Antonov AN-225', 700, 900, 7200, 250000, 30, 900000);
