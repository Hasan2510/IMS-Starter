drop table if exists `orderinfo`;
drop table if exists `request`;
drop table if exists `item`;
DROP TABLE if exists `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `custID` INT(11) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(40) DEFAULT NULL,
    `lastname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`custID`));

CREATE TABLE IF NOT EXISTS `item` (
	`name` varchar(45) ,
  `itemID` INT NOT NULL Auto_increment,
  `value` float NOT NULL,
   PRIMARY KEY (`itemID`));
   
   CREATE TABLE if not exists `request` (
  `orderID` INT NOT NULL AUTO_INCREMENT,
  `custID` INT NOT NULL,
   PRIMARY KEY (`orderID`),
   FOREIGN KEY (`custID`) REFERENCES customers(`custID`));
   
   
   create table if not exists `orderinfo` (
  `orderinfoID` INT NOT NULL AUTO_INCREMENT,
  `orderID` INT NOT NULL,
  `itemID` INT NOT NULL,
  `quantity` INT NOT NULL,
   PRIMARY KEY (`orderinfoID`),
   Foreign key (`itemID`) References item(`itemID`),
   foreign key (`orderID`) references request(`orderID`)) ;

 
 
 
   
 