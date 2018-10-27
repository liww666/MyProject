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

CREATE TABLE `sys_auth` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限表';

CREATE TABLE `sys_role_auth` (
  `id` int(11) NOT NULL DEFAULT '0',
  `sys_role_id` int(11) DEFAULT NULL,
  `sys_auth_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色权限表';

insert into SYS_USER (id,username, password) values (1,'admin', 'admin');
insert into SYS_USER (id,username, password) values (2,'abel', 'abel');

insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

insert into SYS_ROLE_USER  values(1,1,1);
insert into SYS_ROLE_USER values(2,2,2);

