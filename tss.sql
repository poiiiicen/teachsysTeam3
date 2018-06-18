create database tss;

use tss;

create table adm(
  id char(5) primary key,
  password  varchar (30)
);

insert into adm(id, password) values ("admin","admin");

create  table classroom(
  id varchar(20),
  place varchar(20),
  roomnumber varchar(20),
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
  teacherid varchar(20),
  name varchar(20),
  length int,
  equipment varchar(20),
  classinfo varchar(128)
);

insert into class values("123456","0123","计算机基础",2,null,null);
insert into class values("654321","3210","计算机进阶",2,"processor","easy class");



insert into teacher values("0123","陈毅","玉泉");
insert into teacher values("3210","陈毅","玉泉");


insert into classroom values("123","玉泉","曹西11",100,null);
insert into classroom values("123","紫金港","曹西11",100,null);

truncate table teacherCourseClassRoomRelation

