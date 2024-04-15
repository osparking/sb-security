drop database easybank;

create database easybank;

use easybank;
CREATE TABLE users (		
    id int not null auto_increment,
	username VARCHAR(50) NOT NULL,	
	password VARCHAR(100) NOT NULL,	
	enabled TINYINT NOT NULL DEFAULT 1,	
	PRIMARY KEY (id)
);

CREATE INDEX username_idx ON users (username);

CREATE TABLE authorities (		
    id int not null auto_increment,
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	primary key(id),
	FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username
  on authorities (username,authority);

show indexes from easybank.authorities;  

insert ignore into users values(null, 'happy', '1111', '1');      
insert ignore into authorities values(null, 'happy', 'write');      

create table customer (       
  id int not null auto_increment,     
  email varchar(100) not null,      
  pwd varchar(200) not null,      
  role varchar(100) not null,     
  primary key(id)     
);        

insert into customer (email, pwd, role)       
  values('john@example.com', '1111', 'admin');   
  
drop table `authorities`;
drop table `users`;
drop table `customer`;

CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `pwd` varchar(500) NOT NULL,
  `role` varchar(100) NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
);

INSERT INTO `customer` (`name`,`email`,`mobile_number`, `pwd`, `role`,`create_dt`)
 VALUES ('happy','happy@example.com','9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',CURDATE());

CREATE TABLE `accounts` (
  `customer_id` int NOT NULL,
   `account_number` int NOT NULL,
  `account_type` varchar(100) NOT NULL,
  `branch_address` varchar(200) NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`account_number`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_id`) 
    REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

INSERT INTO `accounts` (`customer_id`, `account_number`, `account_type`, 
  `branch_address`, `create_dt`)
 VALUES (1, 1865764534, 'Savings', '서울 강남구 강남대로 125번길 101호', CURDATE());
 
CREATE TABLE `account_transactions` (
  `transaction_id` varchar(200) NOT NULL,
  `account_number` int NOT NULL,
  `customer_id` int NOT NULL,
  `transaction_dt` date NOT NULL,
  `transaction_summary` varchar(200) NOT NULL,
  `transaction_type` varchar(100) NOT NULL,
  `transaction_amt` int NOT NULL,
  `closing_balance` int NOT NULL,
  `create_dt` date DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `customer_id` (`customer_id`),
  KEY `account_number` (`account_number`),
  CONSTRAINT `accounts_ibfk_2` FOREIGN KEY (`account_number`) 
    REFERENCES `accounts` (`account_number`) ON DELETE CASCADE,
  CONSTRAINT `acct_user_ibfk_1` FOREIGN KEY (`customer_id`) 
    REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, 
  `customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,
  `transaction_amt`,
`closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, 
  DATE_SUB(CURDATE(), INTERVAL 7 DAY), '백다방', '출금', 30,34500,
  DATE_SUB(CURDATE(), INTERVAL 7 DAY));

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, 
`customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,
`transaction_amt`,
`closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, 
DATE_SUB(CURDATE(), INTERVAL 6 DAY), '택시', '출금', 100,34400,
DATE_SUB(CURDATE(), INTERVAL 6 DAY));

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, 
`customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,
`transaction_amt`,
`closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, 
DATE_SUB(CURDATE(), INTERVAL 5 DAY), '직접입금', '입금', 500,34900,
DATE_SUB(CURDATE(), INTERVAL 5 DAY));

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, 
`customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,
`transaction_amt`,
`closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, 
DATE_SUB(CURDATE(), INTERVAL 4 DAY), '네이버쇼핑', '출금', 600,34300,
DATE_SUB(CURDATE(), INTERVAL 4 DAY));

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, 
`customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,
`transaction_amt`,
`closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, 
DATE_SUB(CURDATE(), INTERVAL 2 DAY), '온라인송금', '입금', 700,35000,
DATE_SUB(CURDATE(), INTERVAL 2 DAY));

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, 
`customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`,
`transaction_amt`,
`closing_balance`, `create_dt`)  VALUES (UUID(), 1865764534, 1, 
DATE_SUB(CURDATE(), INTERVAL 1 DAY), 'paris.co.kr', '출금', 100,34900,
DATE_SUB(CURDATE(), INTERVAL 1 DAY));

 
 