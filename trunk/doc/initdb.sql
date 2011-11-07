create table SYS_MODULEDEF
(
  MODULEID       VARCHAR2(8) not null,
  SYSTEMID       NUMBER(1) not null,
  NAME           VARCHAR2(20) not null,
  MASK           NUMBER(2) not null,
  IPGROUPID      NUMBER(4),
  URL            VARCHAR2(100),
  PARENTMODULEID VARCHAR2(8) not null,
  SORTNO         NUMBER(2) not null,
  ICON           VARCHAR2(100),
  NOTE           VARCHAR2(100)
);
-- Add comments to the table 
comment on table SYS_MODULEDEF
  is '系统功能模块定义表';
-- Add comments to the columns 
comment on column SYS_MODULEDEF.MODULEID
  is '模块编码';
comment on column SYS_MODULEDEF.SYSTEMID
  is '子系统编码';
comment on column SYS_MODULEDEF.NAME
  is '模块名称';
comment on column SYS_MODULEDEF.MASK
  is '操作掩码';
comment on column SYS_MODULEDEF.IPGROUPID
  is 'IP限制';
comment on column SYS_MODULEDEF.URL
  is '对应URL';
comment on column SYS_MODULEDEF.PARENTMODULEID
  is '上级模块编码';
comment on column SYS_MODULEDEF.SORTNO
  is '模块排序号';
comment on column SYS_MODULEDEF.ICON
  is '菜单图标';
comment on column SYS_MODULEDEF.NOTE
  is '模块备注,用于注释';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_MODULEDEF
  add constraint PK_SYS_MODULEDEF primary key (MODULEID);  
  
-- Create table
create table SYS_ACCOUNT
(
  ACCOUNT       VARCHAR2(20) not null,
  NAME          VARCHAR2(20) not null,
  PASSWORD      NUMBER(4) not null,
  ROLEID        NUMBER(4) not null,
  SEX           NUMBER(1) not null,
  TELEPHONE     VARCHAR2(30),
  POSITION      VARCHAR2(20),
  CREATETIME    DATE not null,
  CREATEACCOUNT VARCHAR2(20) not null,
  HOMEPAGE      VARCHAR2(100),
  EMAIL         VARCHAR2(50),
  OWNERID       NUMBER(4) not null,
  OWNERTYPE     NUMBER(2) not null
);
-- Add comments to the table 
comment on table SYS_ACCOUNT
  is '系统用户账号表';
-- Add comments to the columns 
comment on column SYS_ACCOUNT.ACCOUNT
  is '用户账号';
comment on column SYS_ACCOUNT.NAME
  is '用户名称';
comment on column SYS_ACCOUNT.PASSWORD
  is '用户密码';
comment on column SYS_ACCOUNT.ROLEID
  is '角色编码';
comment on column SYS_ACCOUNT.SEX
  is '用户性别';
comment on column SYS_ACCOUNT.TELEPHONE
  is '联系电话';
comment on column SYS_ACCOUNT.POSITION
  is '职务';
comment on column SYS_ACCOUNT.CREATETIME
  is '创建时间';
comment on column SYS_ACCOUNT.CREATEACCOUNT
  is '创建者';
comment on column SYS_ACCOUNT.HOMEPAGE
  is '登录信息';
comment on column SYS_ACCOUNT.EMAIL
  is '电子邮件';
comment on column SYS_ACCOUNT.OWNERID
  is '所属对象编码';
comment on column SYS_ACCOUNT.OWNERTYPE
  is '所属对象类型';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ACCOUNT
  add constraint PK_SYS_ACCOUNT primary key (ACCOUNT);
  
-- Create table
create table SYS_DEPARTMENT
(
  DEPARTMENTID  NUMBER(4) not null,
  DISC          VARCHAR2(20) not null,
  OWNERTYPE     NUMBER(4) not null,
  OWNERID       NUMBER(4) not null,
  CREATETIME    DATE not null,
  CREATEACCOUNT VARCHAR2(20) not null
);
-- Add comments to the table 
comment on table SYS_DEPARTMENT
  is '部门定义表';
-- Add comments to the columns 
comment on column SYS_DEPARTMENT.DEPARTMENTID
  is '部门编码';
comment on column SYS_DEPARTMENT.DISC
  is '部门名称';
comment on column SYS_DEPARTMENT.OWNERTYPE
  is '上级部门类别';
comment on column SYS_DEPARTMENT.OWNERID
  is '上级部门编码';
comment on column SYS_DEPARTMENT.CREATETIME
  is '创建时间';
comment on column SYS_DEPARTMENT.CREATEACCOUNT
  is '创建者';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_DEPARTMENT
  add constraint SYS_SYS_DEPARTMENT primary key (DEPARTMENTID);
  
-- Create table
create table SYS_ROLE
(
  ROLEID        NUMBER(4) not null,
  NAME          VARCHAR2(20) not null,
  PARENTROLEID  NUMBER(4) not null,
  CREATETIME    DATE not null,
  CREATEACCOUNT VARCHAR2(20) not null
);
-- Add comments to the table 
comment on table SYS_ROLE
  is '系统角色表';
-- Add comments to the columns 
comment on column SYS_ROLE.ROLEID
  is '角色编码';
comment on column SYS_ROLE.NAME
  is '角色名称';
comment on column SYS_ROLE.PARENTROLEID
  is '所属角色编码';
comment on column SYS_ROLE.CREATETIME
  is '创建时间';
comment on column SYS_ROLE.CREATEACCOUNT
  is '创建者';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLE
  add constraint PK_SYS_ROLE primary key (ROLEID);
  
-- Create table
create table SYS_ROLEMODULE
(
  ROLEID   NUMBER(4) not null,
  MODULEID VARCHAR2(8) not null,
  MASK     NUMBER(2) not null
);
-- Add comments to the table 
comment on table SYS_ROLEMODULE
  is '角色功能模块表';
-- Add comments to the columns 
comment on column SYS_ROLEMODULE.ROLEID
  is '角色编码';
comment on column SYS_ROLEMODULE.MODULEID
  is '模块编码';
comment on column SYS_ROLEMODULE.MASK
  is '操作掩码';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLEMODULE
  add constraint PK_SYS_ROLEMODULE primary key (ROLEID, MODULEID);
  
