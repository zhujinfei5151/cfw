prompt PL/SQL Developer import file
prompt Created on 2012年1月20日 by road
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
values ('admin1', '系统管理员', 1234, 0, 2, null, '技术员', to_date('06-12-2011', 'dd-mm-yyyy'), 'admin', null, 'aaaaa', 1, 1, 'jisu');
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('guest', '操作员', 1234, 0, 1, null, '普通员工', to_date('06-12-2011', 'dd-mm-yyyy'), 'admin', null, null, 1, 1, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('aa', 'aa', 1234, 0, 1, null, null, to_date('21-12-2011 16:37:48', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('cc', 'cc', 1234, 224, 1, null, null, to_date('21-12-2011 16:38:19', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('tt', 'tt', 1234, 226, 1, null, null, to_date('21-12-2011 16:40:05', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('yy', 'yy', 1234, 162, 2, null, null, to_date('21-12-2011 16:40:16', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('testZH', 'xiaoxiao', 1234, 224, 1, null, '经理', to_date('22-12-2011 10:50:38', 'dd-mm-yyyy hh24:mi:ss'), 'admin1', null, null, null, null, 'aa');
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('admin', '系统管理员', 1234, 1, 1, null, '经理', to_date('29-11-2011', 'dd-mm-yyyy'), 'admin', null, null, 1, 1, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('admin2', '系统管理员', 1234, 142, 2, null, '程序员', to_date('15-12-2011 11:29:40', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, 'jisuyuan');
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('qq', 'qq', 1234, 162, 1, null, null, to_date('21-12-2011 16:39:24', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('ee', 'ee', 1234, 0, 2, null, null, to_date('21-12-2011 16:39:01', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('gg', 'gg', 1234, 184, 2, null, null, to_date('21-12-2011 16:39:14', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('abc4', 'adc', 1234, 1, 2, null, 'cc', to_date('07-12-2011 13:31:47', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, 'aa');
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('ww', 'ww', 1234, 187, 2, null, null, to_date('21-12-2011 16:39:33', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('rrrrr', 'rr', 1234, 0, 2, null, null, to_date('21-12-2011 16:39:46', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('ii', 'dd', 1234, 187, 2, null, null, to_date('21-12-2011 16:40:51', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('uu', 'uu', 1234, 142, 1, null, null, to_date('21-12-2011 16:41:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('wei', 'xw', 1234, 142, 1, null, '技术yuan', to_date('22-12-2011 11:12:18', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, 'aa');
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('test', 'test', 1234, 2, 1, null, 'cc', to_date('14-12-2011 08:55:46', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, 'cc');
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('cfw', 'ff', 1234, 161, 2, null, 'aa', to_date('14-12-2011 15:31:15', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, 'ss');
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('ff', 'adc', 1234, 142, 1, null, 'cc', to_date('15-12-2011 09:41:50', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, 'ff');
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('admin3', '系统管理员', 1234, 161, 2, null, '技术员', to_date('16-12-2011 10:50:01', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, 'jisu');
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('bb', 'bb', 1234, 1, 1, null, null, to_date('21-12-2011 16:38:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
insert into SYS_ACCOUNT (ACCOUNT, NAME, PASSWORD, ROLEID, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, OWNERID, OWNERTYPE, NOTE)
values ('dd', 'dd', 1234, 162, 1, null, null, to_date('21-12-2011 16:38:34', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null);
commit;
prompt 24 records loaded
prompt Loading SYS_DEPARTMENT...
prompt Table is empty
prompt Loading SYS_MODULEDEF...
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('02030000', 1, '地图', 1, 0, 'menutree.action', '02000000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('02030100', 1, '百度地图', 1, 0, 'demo/baidumap.action', '02030000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('02030200', 1, 'OpenGIS', 1, 0, 'demo/opengis.action', '02030000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('01010000', 1, '权限管理', 0, 0, 'tab.action', '01000000', 1, ' ', null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('01010200', 1, '角色管理', 0, 0, 'sys/roles_init.action', '01010000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('01010300', 1, '帐号管理', 0, 0, 'sys/accounts_init.action', '01010000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('01010900', 1, '系统帐号查询', 0, 0, 'sys/accountQuery_init.action', '01010000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('01000000', 1, '系统管理', 0, 0, null, '01000000', 1, 'xtgl', null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('02000000', 1, '演示功能', 1, 0, null, '02000000', 1, 'bbgl', null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('02010000', 1, '对象树', 1, 0, 'objtree.action', '02000000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('02020000', 1, '菜单树', 1, 0, 'menutree.action', '02000000', 1, null, null);
insert into SYS_MODULEDEF (MODULEID, SYSTEMID, NAME, MASK, IPGROUPID, URL, PARENTMODULEID, SORTNO, ICON, NOTE)
values ('02020100', 1, '主题演示', 1, 0, 'demo/theme.action', '02020000', 1, null, null);
commit;
prompt 12 records loaded
prompt Loading SYS_ROLE...
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (1, 'test', to_date('08-11-2011', 'dd-mm-yyyy'), 'admin', '角色test');
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (2, 'test1', to_date('07-12-2011 16:13:48', 'dd-mm-yyyy hh24:mi:ss'), 'admin', '角色test1');
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (184, 'test111', to_date('11-12-2011 14:47:42', 'dd-mm-yyyy hh24:mi:ss'), 'test1', null);
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (187, 'test111', to_date('11-12-2011 14:50:07', 'dd-mm-yyyy hh24:mi:ss'), 'test1', null);
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (0, 'admin', to_date('01-11-2011', 'dd-mm-yyyy'), 'admin', '管理员');
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (142, 'test2', to_date('08-12-2011 22:04:15', 'dd-mm-yyyy hh24:mi:ss'), 'test1', '该角色由test1创建');
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (161, 'hello tree', to_date('11-12-2011 12:49:59', 'dd-mm-yyyy hh24:mi:ss'), 'test1', null);
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (162, 'hello tree', to_date('11-12-2011 12:50:40', 'dd-mm-yyyy hh24:mi:ss'), 'test1', null);
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (224, 'aiziji', to_date('21-12-2011 10:07:43', 'dd-mm-yyyy hh24:mi:ss'), 'admin', '技术员');
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (226, 'james', to_date('22-12-2011 09:40:08', 'dd-mm-yyyy hh24:mi:ss'), 'admin', '技术员mvp');
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (242, 'efw', to_date('28-12-2011 15:52:05', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 'fe');
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (243, 'wef', to_date('28-12-2011 15:56:23', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 'wef');
insert into SYS_ROLE (ROLEID, NAME, CREATETIME, CREATEACCOUNT, ROLECOMMENT)
values (241, 'efw', to_date('28-12-2011 15:51:50', 'dd-mm-yyyy hh24:mi:ss'), 'admin', 'fe');
commit;
prompt 13 records loaded
prompt Loading SYS_ROLEMODULE...
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (2, '02000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (2, '02020000', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (187, '01000000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (187, '01010000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (2, '01010000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (2, '01010300', 0);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (187, '01010200', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (187, '02000000', 0);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (187, '02010000', 0);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (187, '02020000', 0);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (188, '01000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (188, '01010000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (188, '01010200', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (188, '02000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (188, '02010000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (188, '02020000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (204, '01010200', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (204, '01010300', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (204, '01010900', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (1, '01000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (1, '02010000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (1, '02030000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '01010300', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '01010900', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (204, '01000000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (204, '01010000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '02010000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '02020000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '01000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '01010000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '02030100', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '02030200', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '01010300', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '02000000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '02010000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '02030000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '02030100', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '01000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '01010200', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (189, '01010200', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (189, '02000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (189, '02010000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (189, '02020000', 0);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (142, '01010000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (142, '01010900', 0);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (142, '02010000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (189, '01000000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (189, '01010000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '02030000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '02020000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '02030200', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '01010200', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (224, '02000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (1, '02000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (1, '02020000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '01010000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (226, '01010900', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (2, '01000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (2, '01010200', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (2, '01010900', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (2, '02010000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (243, '01000000', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (243, '02000000', 0);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '01000000', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '01010000', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (142, '01000000', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (142, '01010200', 2);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '01010200', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (142, '02000000', 1);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (142, '02020000', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '01010300', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '01010900', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '02000000', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '02010000', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '02020000', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '02030000', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '02030100', 3);
insert into SYS_ROLEMODULE (ROLEID, MODULEID, MASK)
values (0, '02030200', 3);
commit;
prompt 78 records loaded
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
