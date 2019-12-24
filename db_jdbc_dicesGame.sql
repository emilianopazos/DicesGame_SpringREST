--CREATE DATABASE
CREATE DATABASE `db_jdbc_dicesgame`;
/*
mysql> create database db_example; -- Creates the new database
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
*/

--CREATE TABLES - player and games.

--Create table player
CREATE TABLE `player` (
  `player_id` int(11) NOT NULL,
  `player_log_name` varchar(255) DEFAULT NULL,
  `player_log_pass` varchar(255) DEFAULT NULL,
  `player_name` varchar(255) DEFAULT NULL,
  `player_reg_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


-- Create table games
CREATE TABLE `games` (
  `game_id` int(11) NOT NULL,
  `dice1` int(11) NOT NULL,
  `dice2` int(11) NOT NULL,
  `game_date_time` varchar(255) DEFAULT NULL,
  `is_win` int(11) NOT NULL,
  `player_id` int(11) NOT NULL,
  `player_player_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`game_id`),
  KEY `FK4yxsr8bglovbii1r51mg3l0hl` (`player_player_id`),
  CONSTRAINT `FK4yxsr8bglovbii1r51mg3l0hl` FOREIGN KEY (`player_player_id`) REFERENCES `player` (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci





--PLAYER---
--POST new game for a player_id
INSERT INTO `db_dicesgame`.`games`
(`game_id`,
`dice1`,
`dice2`,
`game_date_time`,
`is_win`,
`player_id`,
`player_player_id`)
VALUES
(<{game_id: }>,
<{dice1: }>,
<{dice2: }>,
<{game_date_time: }>,
<{is_win: }>,
<{player_id: }>,
<{player_player_id: }>);

--PUT (update) a player
UPDATE `db_dicesgame`.`player`
SET
`player_id` = <{player_id: }>,
`player_log_name` = <{player_log_name: }>,
`player_log_pass` = <{player_log_pass: }>,
`player_name` = <{player_name: }>,
`player_reg_date` = <{player_reg_date: }>
WHERE `player_id` = <{expr}>;

--GET all players
SELECT `player`.`player_id`,
    `player`.`player_log_name`,
    `player`.`player_log_pass`,
    `player`.`player_name`,
    `player`.`player_reg_date`
FROM `db_dicesgame`.`player`;





--GAMES---
--POST new player
INSERT INTO `db_dicesgame`.`player`
(`player_id`,
`player_log_name`,
`player_log_pass`,
`player_name`,
`player_reg_date`)
VALUES
(<{player_id: }>,
<{player_log_name: }>,
<{player_log_pass: }>,
<{player_name: }>,
<{player_reg_date: }>);