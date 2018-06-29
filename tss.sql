create database tss;

use tss;
create table adm(
  id varchar(10) primary key,
  password  varchar (30) not null
);
insert into adm(id, password) values ("admin","admin");

create table bbsUser(
  uId varchar(10) not null primary key,
  uName varchar(10) not null,
  uPassword varchar(30) not null
);
insert into bbsUser values("U0001", "user1", "user1");
insert into bbsUser values("U0002", "user2", "user2");

create table bbsSession(
  sId varchar(10) not null primary key,
  sName  varchar(10)  not null,
  sProfile  varchar(50),
  stopicCount  int,
  sclickCount  int
);
insert into bbsSession values("S0001", "教师答疑", "您在课程、作业上遇到的问题，可以在本版块向老师提问", 0, 0);
insert into bbsSession values("S0002", "心灵之约", "您在生活、情感上遇到的问题，可以在本版块进行吐槽", 0, 0);
insert into bbsSession values("S0003", "开怀一笑", "您在任何地方发现的一些欢乐，不放在本版块分享给大家", 0, 0);

create table bbsPost (
  pid varchar(10) not null primary key,
  psid varchar(10) not null,
  puid varchar(10) not null,
  ptopic varchar(100) not null,
  pcontent varchar(500) not null,
  pclickCount int,
  preplyCount int,
  pcreateTime datetime not null,
  pmodifiedTime datetime,
  plast_replyUserId varchar(10),
  plast_replyTime datetime,
  foreign key (psid) references bbsSession(sid),
  foreign key (puid) references bbsUser(uid),
  foreign key (plast_replyUserId) references bbsUser(uid)
);
insert into bbsPost values("T0001","S0001","U0001", "topic1", "test context of topic1", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0002","S0001","U0001", "topic1", "test context of topic2", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0003","S0001","U0001", "topic1", "test context of topic3", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0004","S0001","U0001", "topic1", "test context of topic4", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0005","S0002","U0001", "topic1", "test context of topic5", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0006","S0002","U0001", "topic1", "test context of topic6", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0007","S0002","U0001", "topic1", "test context of topic7", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0008","S0002","U0001", "topic1", "test context of topic8", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0009","S0003","U0001", "topic1", "test context of topic9", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0010","S0003","U0001", "topic1", "test context of topic10", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0011","S0003","U0001", "topic1", "test context of topic11", 0, 0, now(),now(),"U0001",now());
insert into bbsPost values("T0012","S0003","U0001", "topic1", "test context of topic12", 0, 0, now(),now(),"U0001",now());

create table bbs_reply (
  rid varchar(10) not null primary key,
  rpid varchar(10) not null,
  rsid varchar(10)  not null,
  ruid varchar(10) not null,
  rcontent varchar(500) not null,
  rtime datetime not null,
  foreign key (rpid) references bbsPost(pid),
  foreign key (rsid) references bbsSession(sid),
  foreign key (ruid) references bbsUser(uid)
);
insert into bbsReply values("R0001", "T0001", "S0001", "U0001", "this is a test bbs reply count 1", now());
insert into bbsReply values("R0002", "T0001", "S0001", "U0001", "this is a test bbs reply count 2", now());
insert into bbsReply values("R0003", "T0001", "S0001", "U0001", "this is a test bbs reply count 3", now());
insert into bbsReply values("R0004", "T0001", "S0001", "U0001", "this is a test bbs reply count 4", now());
insert into bbsReply values("R0005", "T0001", "S0001", "U0001", "this is a test bbs reply count 5", now());

create table bbsMessage(
  mid varchar(10) not null primary key,
  msenderId varchar(10) not null,
  mreceiverId varchar(10) not null,
  mtitle varchar(100) not null,
  mcontent varchar(500) not null,
  msendTime datetime not null,
  foreign key (msenderId) references bbsUser(uid),
  foreign key (mreceiverId) references bbsUser(uid)
);
insert into bbsMessage values("M0001", "U0001", "U0002", "say hello", "hello, user2. I am user1.", now());
insert into bbsMessage values("M0002", "U0002", "U0001", "say hello", "hello, user1. I am user2.", now());

create table bbsNotice(
  nid varchar(10) not null primary key,
  nuid varchar(10) not null,
  ntopic varchar(100) not null,
  ncontent varchar(500) not null,
  ncreateTime datetime not null,
  nmodifiedTime datetime,
  foreign key (nuid) references bbsUser(uid)
);
insert into bbsNotice values("N0001", "U0001", "notice1", "a test content of notice1", now(), now());
insert into bbsNotice values("N0002", "U0001", "notice2", "a test content of notice2", now(), now());
insert into bbsNotice values("N0003", "U0001", "notice3", "a test content of notice3", now(), now());



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
insert into teacher values("3210","刘超","玉泉");


insert into classroom values("123","玉泉","曹西11",100,null);
insert into classroom values("124","紫金港","曹西11",100,null);

truncate table teacher_course_class_room_relation;

CREATE TABLE `teacher_course_class_room_relation` (
  `teacherId` varchar(20) NOT NULL,
  `courseId` varchar(20) NOT NULL,
  `classRoomId` varchar(20) NOT NULL,
  `weekday` int(11) NOT NULL,
  `timePeriod` int(11) NOT NULL,
  UNIQUE KEY `idx` (`teacherId`,`courseId`,`classRoomId`,`weekday`,`timePeriod`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `se2018`.`teacher_course_class_room_relation` (`teacherid`, `courseid`, `classroomid`, `weekday`, `timeperiod`) VALUES ('01234', '123456', '123', '0', '0');
INSERT INTO `se2018`.`teacher_course_class_room_relation` (`teacherid`, `courseid`, `classroomid`, `weekday`, `timeperiod`) VALUES ('01234', '654321', '123', '1', '1');

