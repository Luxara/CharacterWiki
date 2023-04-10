DROP TABLE IF EXISTS `characters`;
CREATE TABLE IF NOT EXISTS `characters` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `age` varchar(150) DEFAULT NULL,
  `gender` varchar(150) DEFAULT NULL,
  `race` varchar(150) NOT NULL,
  `origin` varchar(150) DEFAULT NULL,
  `story` longtext DEFAULT NULL,
  `home` bigint(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `home` (`home`),
  KEY `FK_characters_locations` (`home`),
  CONSTRAINT `FK_characters_locations` FOREIGN KEY (`home`) REFERENCES `locations` (`locationid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


INSERT INTO `characters` (`id`, `name`, `age`, `gender`, `race`, `origin`, `story`, `home`) VALUES
	(1, 'Hanako', '???', 'Female', 'Vampire', 'Japan', 'Hanako is a fierce vampire from feudal Japan.', 2),
	(2, 'Freya', 'old', 'Female', 'Vampire', 'Norway', 'This viking vampire has an appetite for strawberry cake.', 2);

DROP TABLE IF EXISTS `locations`;
CREATE TABLE IF NOT EXISTS `locations` (
  `locationid` bigint(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `text` longtext DEFAULT NULL,
  PRIMARY KEY (`locationid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

INSERT INTO `locations` (`locationid`, `name`, `text`) VALUES
	(1, 'Unknown', 'It\'s a mystery!'),
	(2, 'Lolesantana', 'A fun place to be!'),
	(3, 'Eden City', 'A technological paradice.');

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `password` varchar(250) NOT NULL,
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

INSERT INTO `users` (`id`, `username`, `password`, `role`) VALUES
	(1, 'user', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'USER'),
	(2, 'admin', '$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 'ADMIN');


