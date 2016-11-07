CREATE DATABASE  IF NOT EXISTS `available_user`;
USE `available_user`;

--Table structure for table restricted_words

DROP TABLE IF EXISTS `restricted_words`;
CREATE TABLE `restricted_words` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


select * from restricted_words

-- Table structure for table `role`
--
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

select * from user