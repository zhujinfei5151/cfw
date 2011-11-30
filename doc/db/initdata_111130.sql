prompt PL/SQL Developer import file
prompt Created on 2011年11月30日 by road
set feedback off
set define off
prompt Disabling triggers for SYS_ACCOUNT...
alter table SYS_ACCOUNT disable all triggers;
prompt Disabling triggers for SYS_DEPARTMENT...
alter table SYS_DEPARTMENT disable all triggers;
prompt Disabling triggers for SYS_MODULEDEF...
alter table SYS_MODULEDEF disable all triggers;
prompt Disabling triggers for SYS_ROLE...
alter table SYS_ROLE disable all triggers;
prompt Disabling triggers for SYS_ROLEMODULE...
alter table SYS_ROLEMODULE disable all triggers;
prompt Deleting SYS_ROLEMODULE...
delete from SYS_ROLEMODULE;
commit;
prompt Deleting SYS_ROLE...
delete from SYS_ROLE;
commit;
prompt Deleting SYS_MODULEDEF...
delete from SYS_MODULEDEF;
commit;
prompt Deleting SYS_DEPARTMENT...
delete from SYS_DEPARTMENT;
commit;
prompt Deleting SYS_ACCOUNT...
delete from SYS_ACCOUNT;
commit;
prompt Loading SYS_ACCOUNT...
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('admin', '系统管理员', 1234, 1, 1, null, null, to_date('29-11-2011', 'dd-mm-yyyy'), 'admin', null, null, 1, 1, null);
commit;
prompt 1 records loaded
prompt Loading SYS_DEPARTMENT...
prompt Table is empty
prompt Loading SYS_MODULEDEF...
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('01010000', 1, '权限管理', 2, 0, 'tab.action', '01000000', 1, ' ', null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('01010200', 1, '角色管理', 2, 0, 'sys/roles_init.action', '01010000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('01010300', 1, '帐号管理', 2, 0, 'sys/account_init.action', '01010000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('01010900', 1, '系统帐号查询', 2, 0, 'sys/accountQuery_init.action', '01010000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('01000000', 1, '系统管理', 2, 0, null, '01000000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('02000000', 1, '演示功能', 2, 0, null, '02000000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('02010000', 1, '对象树', 2, 0, 'objtree.action', '02000000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('02020000', 1, '菜单树', 2, 0, 'menutree.action', '02000000', 1, null, null);
commit;
prompt 8 records loaded
prompt Loading SYS_ROLE...
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT)
values (1, 'test', to_date('08-11-2011', 'dd-mm-yyyy'), 'admin');
commit;
prompt 1 records loaded
prompt Loading SYS_ROLEMODULE...
prompt Table is empty
prompt Enabling triggers for SYS_ACCOUNT...
alter table SYS_ACCOUNT enable all triggers;
prompt Enabling triggers for SYS_DEPARTMENT...
alter table SYS_DEPARTMENT enable all triggers;
prompt Enabling triggers for SYS_MODULEDEF...
alter table SYS_MODULEDEF enable all triggers;
prompt Enabling triggers for SYS_ROLE...
alter table SYS_ROLE enable all triggers;
prompt Enabling triggers for SYS_ROLEMODULE...
alter table SYS_ROLEMODULE enable all triggers;
set feedback on
set define on
prompt Done.
