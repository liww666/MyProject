create table sys_user (
	id int ,
	username  varchar(50),
	password  varchar(50),
	PRIMARY KEY (id)
)COMMENT='系统用户表';

create table sys_role (
	id int,
	name varchar(50),
	primary key (id)
) COMMENT='系统角色表';

create table sys_role_user (
	id int,
	sys_role_id int,
	sys_user_id int,
	primary key (id)
)COMMENT='系统角色用户表';

insert into SYS_USER (id,username, password) values (1,'admin', 'admin');
insert into SYS_USER (id,username, password) values (2,'abel', 'abel');

insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

insert into SYS_ROLE_USER  values(1,1,1);
insert into SYS_ROLE_USER values(2,2,2);

