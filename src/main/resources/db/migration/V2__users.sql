create table user(
	username varchar(255) primary key,
	password varchar(255) not null
);

insert into user(username,password) values('rob','password');
insert into user(username,password) values('joe','password');