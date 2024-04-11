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

create table customer (       
  id int not null auto_increment,     
  email varchar(100) not null,      
  pwd varchar(200) not null,      
  role varchar(100) not null,     
  primary key(id)     
);        

insert into customer (email, pwd, role)       
  values('john@example.com', '1111', 'admin');      