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
