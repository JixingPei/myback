TRUNCATE "sd"."sd_user" RESTART IDENTITY;
INSERT INTO "sd"."sd_user"("user_id", "user_name", "password", "use_ldap", "pre_pwd_chg_date", "lock_flg", "pwd_failed_count", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('admin', '管理员', '$2a$10$szgZ9WnOksrFfQt3Q76dSuZl70GOn/k901JDOiadmKDv6GsICGWAK', '0', now(), '0', 0, '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_user"("user_id", "user_name", "password", "use_ldap", "pre_pwd_chg_date", "lock_flg", "pwd_failed_count", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('jixing.pei', '裴', '$2a$10$szgZ9WnOksrFfQt3Q76dSuZl70GOn/k901JDOiadmKDv6GsICGWAK', '0', now(), '0', 0, '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_user"("user_id", "user_name", "password", "use_ldap", "pre_pwd_chg_date", "lock_flg", "pwd_failed_count", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('lei.zhou', '周', '$2a$10$szgZ9WnOksrFfQt3Q76dSuZl70GOn/k901JDOiadmKDv6GsICGWAK', '0', now(), '0', 0, '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_user"("user_id", "user_name", "password", "use_ldap", "pre_pwd_chg_date", "lock_flg", "pwd_failed_count", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('xianchao.deng', '邓', '$2a$10$szgZ9WnOksrFfQt3Q76dSuZl70GOn/k901JDOiadmKDv6GsICGWAK', '0', now(), '0', 0, '1', 'system', now(), 'system', now());


TRUNCATE "sd"."sd_role" RESTART IDENTITY;
INSERT INTO "sd"."sd_role"("role_code", "role_name", "description", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('ROLE_ADMIN', '管理员', '管理员', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_role"("role_code", "role_name", "description", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('ROLE_NORMAL', '普通用户', '普通用户', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_role"("role_code", "role_name", "description", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('ROLE_DM', '部门经理', '部门经理', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_role"("role_code", "role_name", "description", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('ROLE_PM', '项目经理', '项目经理', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_role"("role_code", "role_name", "description", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('ROLE_PG', '程序员', '程序员', '1', 'system', now(), 'system', now());


TRUNCATE "sd"."sd_menu" RESTART IDENTITY;
INSERT INTO "sd"."sd_menu"("menu_id", "menu_name", "path", "parent_id", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU', '菜单', '/', '', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu"("menu_id", "menu_name", "path", "parent_id", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_SCHEDULE', '进度管理', '/schedule', 'MENU', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu"("menu_id", "menu_name", "path", "parent_id", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_SYSTEM', '系统管理', '/system', 'MENU', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu"("menu_id", "menu_name", "path", "parent_id", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_USER', '用户管理', '/user', 'MENU_SYSTEM', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu"("menu_id", "menu_name", "path", "parent_id", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_ROLE', '角色管理', '/role', 'MENU_SYSTEM', '1', 'system', now(), 'system', now());


TRUNCATE "sd"."sd_user_role" RESTART IDENTITY;
INSERT INTO "sd"."sd_user_role"("user_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('admin', 'ROLE_ADMIN', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_user_role"("user_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('lei.zhou', 'ROLE_DM', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_user_role"("user_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('xianchao.deng', 'ROLE_PM', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_user_role"("user_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('jixing.pei', 'ROLE_PG', '1', 'system', now(), 'system', now());


TRUNCATE "sd"."sd_menu_role" RESTART IDENTITY;
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_SCHEDULE', 'ROLE_ADMIN', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_SYSTEM', 'ROLE_ADMIN', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_USER', 'ROLE_ADMIN', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_ROLE', 'ROLE_ADMIN', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_SCHEDULE', 'ROLE_NORMAL', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_SCHEDULE', 'ROLE_DM', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_SYSTEM', 'ROLE_DM', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_USER', 'ROLE_DM', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_ROLE', 'ROLE_DM', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_SCHEDULE', 'ROLE_PM', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_SYSTEM', 'ROLE_PM', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_USER', 'ROLE_PM', '1', 'system', now(), 'system', now());
INSERT INTO "sd"."sd_menu_role"("menu_id", "role_code", "active_flg", "sys_insert_id", "sys_insert_date", "sys_update_id", "sys_update_date") VALUES ('MENU_SCHEDULE', 'ROLE_PG', '1', 'system', now(), 'system', now());


