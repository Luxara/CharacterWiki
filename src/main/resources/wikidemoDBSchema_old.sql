SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS characters;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS users;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE location
(locationid BIGINT NOT NULL AUTO_INCREMENT
, name VARCHAR(150) NOT NULL
, text LONGTEXT
, PRIMARY KEY (locationid);

INSERT INTO location (name, text)
VALUES ("Unknown", "It's a mystery!")
, ("Lolesantana", "A meltingpot of cultures and races. There's always something fun around the corner just waiting to happen.")
,("Eden city", "A technological haven ruled by those with money and connections.");

CREATE TABLE characters
(id BIGINT NOT NULL AUTO_INCREMENT
, name VARCHAR(150) NOT NULL
, age VARCHAR(150) NOT NULL
, gender VARCHAR(150)
, race VARCHAR(150)
, origin VARCHAR(150)
, story LONGTEXT
, home BIGINT
, PRIMARY KEY (id)
, FOREIGN KEY (home) REFERENCES location(locationid));

INSERT INTO characters (name, age, gender, race, origin, story, home)
VALUES ("Hanako-Sakura", "???", "female", "vampire", "Japan", "Hanako is a elegant but merciless ruler from ancient Japan.", 2)
, ("Freya", "old", "female", "vampire", "Norway", "Freya hails from ancient Norway and has a thing for strawberry cake.", 2);

CREATE TABLE users
(id BIGINT NOT NULL AUTO_INCREMENT
, username VARCHAR(200) NOT NULL
, password VARCHAR(200) NOT NULL
, role VARCHAR(150) NOT NULL
PRIMARY KEY(id);

INSERT INTO users (name, password, role)
VALUES ("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","USER")
,("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","ADMIN");