CREATE TABLE SD.SD_MENU (				
UNIQUE_ID	SERIAL		NOT NULL	,
MENU_ID	VARCHAR(30)		NOT NULL	,
MENU_NAME	VARCHAR(50)		NOT NULL	,
PATH	VARCHAR(200)			,
PARENT_ID	VARCHAR(30)			,
ACTIVE_FLG	CHAR(1)	DEFAULT '1'	NOT NULL	,
SYS_INSERT_ID	VARCHAR(30)			,
SYS_INSERT_DATE	TIMESTAMP WITHOUT TIME ZONE			,
SYS_UPDATE_ID	VARCHAR(30)			,
SYS_UPDATE_DATE	TIMESTAMP WITHOUT TIME ZONE			);
				
				
				
ALTER TABLE SD.SD_MENU ADD CONSTRAINT SD_MENU_PK PRIMARY KEY (UNIQUE_ID);				
CREATE  INDEX SD_INDEX_MENUID ON SD.SD_MENU (MENU_ID);				
