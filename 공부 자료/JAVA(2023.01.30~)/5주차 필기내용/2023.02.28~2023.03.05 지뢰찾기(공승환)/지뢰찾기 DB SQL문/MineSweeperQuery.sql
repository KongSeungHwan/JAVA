CREATE DATABASE `minesweeper`;
CREATE TABLE `client` (
  `client_name` varchar(45) NOT NULL,
  `client_id` varchar(45) NOT NULL,
  `client_pw` varchar(45) NOT NULL,
  `total_rounds` double DEFAULT '0',
  `victory_rounds` double DEFAULT '0',
  PRIMARY KEY (`client_id`)
);
