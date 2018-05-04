create database tss;

use tss;

create table adm(
  id char(5) primary key,
  password  varchar (30)
);

insert into adm(id, password) values ("admin","admin");