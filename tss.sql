create database tss;

use tss;
create table adm(
  id char(5) primary key,
  password  varchar (30)
);
insert into adm(id, password) values ("admin","admin");
insert into adm(id, password) values ("user1", "user1");

create table bbsuser(
  uid int not null primary key,
  uname varchar(20) not nuLl,
  upassword varchar(20) not null,
  uemail varchar(20) not null,
  ubirthday date not null,
  usex int not null,
  uregdata date not null
);
insert into bbsuser values("10001","admin", "admin", "test@zju.edu.com", "2000/1/1", 0, "2000/1/1");
insert into bbsuser values("10002","user1", "user1", "test@zju.edu.com", "2000/1/1", 0, "2000/1/1");

create table bbssession(
  sid int not null primary key,
  sname  varchar(20)  not null,
  sprofile  varchar(50),
  stopiccount  int,
  sclickcount  int
);
insert into bbssession values("20001","learning part", "ask your problems here", 0, 0);
insert into bbssession values("20002","playing part", "discuss something here", 0, 0);

create table bbstopic (
  tid int not null primary key,
  tsid int  not null,
  tuid int  not null,
  treplycount int,
  ttopic varchar(30) not null,
  tcontents varchar(100) not null,
  ttime date not null,
  tclickcount int,
  tlastreplyuseid int not null,
  tlastreplaytime date,
  foreign key (tsid) references bbssession(sid),
  foreign key (tuid) references bbsuser(uid),
  foreign key (tlastreplyuseid) references bbsuser(uid)
);
insert into bbstopic values(30001, 20001, 10001, 0,  "test bbs topic", "this is a test bbs context", now(), 0, 10001,  now());

create table bbsreply (
  rid int  not null,
  rtid int  not null,
  rsid int  not null,
  ruid int not null,
  rcontent varchar(100) not null,
  rtime date not null,
  foreign key (rtid) references bbstopic(tid),
  foreign key (rsid) references bbssession(sid),
  foreign key (ruid) references bbsuser(uid)
);
insert into bbsreply values(40001, 30001, 20001, 10001, "this is a test bbs reply", now());