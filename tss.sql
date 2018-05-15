create database tss;

use tss;

create table adm(
  id char(5) primary key,
  password  varchar (30)
);

insert into adm(id, password) values ("admin","admin");

insert into adm(id, password) values ("user1", "user1");

create table Users(
  id varchar(30) primary key,
  password  varchar (30)
);

insert into Users(id, password) values ("admin","admin");

insert into Users(id, password) values ("user1", "user1");

create table Post(
  title varchar(100) primary key,
  creator  varchar (30),
  context varchar(500)
);
insert into Post(title, creator, context) values ("Test Title 1","admin","Test context: I am a good person.");
insert into Post(title, creator, context) values ("Test Title 2","admin","Test context: This module is ok?");
insert into Post(title, creator, context) values ("Test Title 3","admin","Test context: I think it is ok.");