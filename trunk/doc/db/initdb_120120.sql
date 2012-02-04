--------------------------------------------
-- Export file for user CFW               --
-- Created by road on 2012/1/20, 15:59:59 --
--------------------------------------------

spool initdb_120120.log

prompt
prompt Creating table SYS_ACCOUNT
prompt ==========================
prompt
create table CFW.SYS_ACCOUNT
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
  OWNERID       NUMBER(4),
  OWNERTYPE     NUMBER(2),
  NOTE          VARCHAR2(20)
)
tablespace SZHLEEMAS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table CFW.SYS_ACCOUNT
  is '系统用户账号表';
comment on column CFW.SYS_ACCOUNT.ACCOUNT
  is '用户账号';
comment on column CFW.SYS_ACCOUNT.NAME
  is '用户名称';
comment on column CFW.SYS_ACCOUNT.PASSWORD
  is '用户密码';
comment on column CFW.SYS_ACCOUNT.ROLEID
  is '角色编码';
comment on column CFW.SYS_ACCOUNT.SEX
  is '用户性别';
comment on column CFW.SYS_ACCOUNT.TELEPHONE
  is '联系电话';
comment on column CFW.SYS_ACCOUNT.POSITION
  is '职务';
comment on column CFW.SYS_ACCOUNT.CREATETIME
  is '创建时间';
comment on column CFW.SYS_ACCOUNT.CREATEACCOUNT
  is '创建者';
comment on column CFW.SYS_ACCOUNT.HOMEPAGE
  is '登录信息';
comment on column CFW.SYS_ACCOUNT.EMAIL
  is '电子邮件';
comment on column CFW.SYS_ACCOUNT.OWNERID
  is '所属对象编码';
comment on column CFW.SYS_ACCOUNT.OWNERTYPE
  is '所属对象类型';
comment on column CFW.SYS_ACCOUNT.NOTE
  is '备注';
alter table CFW.SYS_ACCOUNT
  add constraint PK_SYS_ACCOUNT primary key (ACCOUNT)
  using index 
  tablespace SZHLEEMAS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_DEPARTMENT
prompt =============================
prompt
create table CFW.SYS_DEPARTMENT
(
  DEPARTMENTID  NUMBER(4) not null,
  DISC          VARCHAR2(20) not null,
  OWNERTYPE     NUMBER(4) not null,
  OWNERID       NUMBER(4) not null,
  CREATETIME    DATE not null,
  CREATEACCOUNT VARCHAR2(20) not null
)
tablespace SZHLEEMAS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table CFW.SYS_DEPARTMENT
  is '部门定义表';
comment on column CFW.SYS_DEPARTMENT.DEPARTMENTID
  is '部门编码';
comment on column CFW.SYS_DEPARTMENT.DISC
  is '部门名称';
comment on column CFW.SYS_DEPARTMENT.OWNERTYPE
  is '上级部门类别';
comment on column CFW.SYS_DEPARTMENT.OWNERID
  is '上级部门编码';
comment on column CFW.SYS_DEPARTMENT.CREATETIME
  is '创建时间';
comment on column CFW.SYS_DEPARTMENT.CREATEACCOUNT
  is '创建者';
alter table CFW.SYS_DEPARTMENT
  add constraint SYS_SYS_DEPARTMENT primary key (DEPARTMENTID)
  using index 
  tablespace SZHLEEMAS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_MODULEDEF
prompt ============================
prompt
create table CFW.SYS_MODULEDEF
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
)
tablespace SZHLEEMAS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table CFW.SYS_MODULEDEF
  is '系统功能模块定义表';
comment on column CFW.SYS_MODULEDEF.MODULEID
  is '模块编码';
comment on column CFW.SYS_MODULEDEF.SYSTEMID
  is '子系统编码';
comment on column CFW.SYS_MODULEDEF.NAME
  is '模块名称';
comment on column CFW.SYS_MODULEDEF.MASK
  is '操作掩码';
comment on column CFW.SYS_MODULEDEF.IPGROUPID
  is 'IP限制';
comment on column CFW.SYS_MODULEDEF.URL
  is '对应URL';
comment on column CFW.SYS_MODULEDEF.PARENTMODULEID
  is '上级模块编码';
comment on column CFW.SYS_MODULEDEF.SORTNO
  is '模块排序号';
comment on column CFW.SYS_MODULEDEF.ICON
  is '菜单图标';
comment on column CFW.SYS_MODULEDEF.NOTE
  is '模块备注,用于注释';
alter table CFW.SYS_MODULEDEF
  add constraint PK_SYS_MODULEDEF primary key (MODULEID)
  using index 
  tablespace SZHLEEMAS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_ROLE
prompt =======================
prompt
create table CFW.SYS_ROLE
(
  ROLEID        NUMBER(4) not null,
  NAME          VARCHAR2(20) not null,
  CREATETIME    DATE not null,
  CREATEACCOUNT VARCHAR2(20) not null,
  ROLECOMMENT   VARCHAR2(200)
)
tablespace SZHLEEMAS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table CFW.SYS_ROLE
  is '系统角色表';
comment on column CFW.SYS_ROLE.ROLEID
  is '角色编码';
comment on column CFW.SYS_ROLE.NAME
  is '角色名称';
comment on column CFW.SYS_ROLE.CREATETIME
  is '创建时间';
comment on column CFW.SYS_ROLE.CREATEACCOUNT
  is '创建者';
comment on column CFW.SYS_ROLE.ROLECOMMENT
  is '备注';
alter table CFW.SYS_ROLE
  add constraint PK_SYS_ROLE primary key (ROLEID)
  using index 
  tablespace SZHLEEMAS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYS_ROLEMODULE
prompt =============================
prompt
create table CFW.SYS_ROLEMODULE
(
  ROLEID   NUMBER(4) not null,
  MODULEID VARCHAR2(8) not null,
  MASK     NUMBER(2) not null
)
tablespace SZHLEEMAS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table CFW.SYS_ROLEMODULE
  is '角色功能模块表';
comment on column CFW.SYS_ROLEMODULE.ROLEID
  is '角色编码';
comment on column CFW.SYS_ROLEMODULE.MODULEID
  is '模块编码';
comment on column CFW.SYS_ROLEMODULE.MASK
  is '操作掩码';
alter table CFW.SYS_ROLEMODULE
  add constraint PK_SYS_ROLEMODULE primary key (ROLEID, MODULEID)
  using index 
  tablespace SZHLEEMAS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence SEQ_SYS_ROLE
prompt ==============================
prompt
create sequence CFW.SEQ_SYS_ROLE
minvalue 1
maxvalue 9999
start with 261
increment by 1
cache 20;


spool off
