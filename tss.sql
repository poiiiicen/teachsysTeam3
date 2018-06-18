create database tss;

use tss;

create table adm(
  id char(5) primary key,
  password  varchar (30)
);

insert into adm(id, password) values ("admin","admin");

create  table classroom(
  place varchar(20);
  roomNumber varchar(20),
  capacity int,
  equipment varchar(20)

);

create table teacher(
  id varchar(20),
  name varchar(20),
  place varchar(20)
);

create table class(
  id varchar(20),
  teacherId varchar(20),
  name varchar(20),
  length int,
  equipment varchar(20),
  classinfo varchar(128)
);





