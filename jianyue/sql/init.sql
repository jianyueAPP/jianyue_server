drop  database if exists jianyue;
create database jianyue;
use jianyue;
create table t_article (
	article_id int(10) primary key auto_increment,
	title char(50),
	author char(10),
	link char(100),
	tag char(100),
	status int
);

create table t_admin (
	admin_id int(10) primary key auto_increment,
	adminname char(20),
	password char(10)
);
Grant all on jianyue  to 'jianyue'@'localhost' identified by '123456789';