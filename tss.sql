create database tss;

use tss;
create table adm(
  id char(5) primary key,
  password  varchar (30)
);
insert into adm(id, password) values ("admin","admin");
insert into adm(id, password) values ("user1", "user1");

create table bbs_user(
  uid int not null primary key,
  uname varchar(20) not nuLl,
  upassword varchar(20) not null,
  uemail varchar(20) not null,
  ubirthday date not null,
  usex int not null,
  uregdata date not null
);
insert into bbs_user values("10001","admin", "admin", "test@zju.edu.com", "2000/1/1", 0, "2000/1/1");
insert into bbs_user values("10002","user1", "user1", "test@zju.edu.com", "2000/1/1", 0, "2000/1/1");

create table bbs_session(
  sid int not null primary key,
  sname  varchar(20)  not null,
  sprofile  varchar(50),
  stopic_count  int,
  sclick_count  int
);
insert into bbs_session values("20001","学习天地", "交流学习中遇到的问题", 0, 0);
insert into bbs_session values("20002","心灵之约", "交流情感上遇到的问题", 0, 0);
insert into bbs_session values("20003","游戏交流", "交流游戏中存在的问题", 0, 0);

create table bbs_topic (
  tid int not null primary key,
  tsid int  not null,
  tuid int  not null,
  treply_count int,
  ttopic varchar(30) not null,
  tcontent varchar(100) not null,
  ttime date not null,
  tclick_count int,
  tlast_reply_user_id int not null,
  tlast_reply_time date,
  foreign key (tsid) references bbs_session(sid),
  foreign key (tuid) references bbs_user(uid),
  foreign key (tlast_reply_user_id) references bbs_user(uid)
);
insert into bbs_topic values(30001, 20001, 10001, 0,  "学习 * 帖子一", "第一个学习帖子", now(), 0, 10001,  now());
insert into bbs_topic values(30002, 20001, 10001, 0,  "学习 * 帖子二", "第二个学习帖子", now(), 0, 10001,  now());
insert into bbs_topic values(30003, 20001, 10001, 0,  "学习 * 帖子三", "第三个学习帖子", now(), 0, 10001,  now());
insert into bbs_topic values(30004, 20001, 10001, 0,  "学习 * 帖子四", "第四个学习帖子", now(), 0, 10001,  now());
insert into bbs_topic values(30005, 20001, 10001, 0,  "学习 * 帖子五", "第五个学习帖子", now(), 0, 10001,  now());
insert into bbs_topic values(30006, 20002, 10001, 0,  "心灵 * 帖子一", "第一个心灵帖子", now(), 0, 10001,  now());
insert into bbs_topic values(30007, 20002, 10001, 0,  "心灵 * 帖子二", "第二个心灵帖子", now(), 0, 10001,  now());
insert into bbs_topic values(30008, 20002, 10001, 0,  "心灵 * 帖子三", "第三个心灵帖子", now(), 0, 10001,  now());
insert into bbs_topic values(30009, 20003, 10001, 0,  "游戏 * 帖子一", "第一个游戏帖子", now(), 0, 10001,  now());
insert into bbs_topic values(30010, 20003, 10001, 0,  "游戏 * 帖子二", "第二个游戏帖子", now(), 0, 10001,  now());
insert into bbs_topic values(30011, 20003, 10001, 0,  "游戏 * 帖子三", "第三个游戏帖子", now(), 0, 10001,  now());

create table bbs_reply (
  rid int  not null,
  rtid int  not null,
  rsid int  not null,
  ruid int not null,
  rcontent varchar(100) not null,
  rtime date not null,
  foreign key (rtid) references bbs_topic(tid),
  foreign key (rsid) references bbs_session(sid),
  foreign key (ruid) references bbs_user(uid)
);
insert into bbs_reply values(40001, 30001, 20001, 10001, "this is a test bbs reply", now());