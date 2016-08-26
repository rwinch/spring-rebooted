create table message (
	id bigint auto_increment primary key,
	text varchar(255) not null
);

insert into message(text) values('Hi MySQL');
insert into message(text) values('Hi Flyway');