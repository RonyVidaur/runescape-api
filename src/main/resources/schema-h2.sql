--DROP TABLE IF EXISTS Scoreboards;
--
--CREATE TABLE Scoreboards (
--  Id int(11) unsigned NOT NULL AUTO_INCREMENT,
--  PRIMARY KEY (Id),
--  scoreboard_name VARCHAR(20) NOT NULL,
--  description VARCHAR(50) NOT NULL
--);
--
--DROP TABLE IF EXISTS Players;
--CREATE TABLE Players (
--  Id int(11) unsigned NOT NULL AUTO_INCREMENT,
--  scoreboard_id int(11) unsigned NOT NULL,
--  name VARCHAR(20),
--  level INT (9),
--  PRIMARY KEY (Id),
--  id_scoreboard INT not null,
--  FOREIGN KEY (id_scoreboard REFERENCES Scoreboards(Id)
--);
DROP TABLE IF EXISTS Scoreboards;
CREATE TABLE Scoreboards (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) not null,
    description VARCHAR(50) not null,
    UNIQUE (id)
);

DROP TABLE IF EXISTS Players;
CREATE TABLE Players (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) not null,
    player_level INT not null,
    xp INT not null,
    scoreboard_id INT not null,
    UNIQUE (name),
    FOREIGN KEY (scoreboard_id) REFERENCES Scoreboards(Id)
);