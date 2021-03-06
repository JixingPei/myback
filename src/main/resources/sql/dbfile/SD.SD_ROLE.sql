CREATE TABLE SD.SD_ROLE (
UNIQUE_ID	SERIAL		NOT NULL	,
ROLE_CODE	VARCHAR(50)		NOT NULL	,
ROLE_NAME	VARCHAR(50)		NOT NULL	,
DESCRIPTION	VARCHAR(200)			,
ACTIVE_FLG	CHAR(1)	DEFAULT '1'	NOT NULL	,
SYS_INSERT_ID	VARCHAR(30)			,
SYS_INSERT_DATE	TIMESTAMP WITHOUT TIME ZONE			,
SYS_UPDATE_ID	VARCHAR(30)			,
SYS_UPDATE_DATE	TIMESTAMP WITHOUT TIME ZONE			);



ALTER TABLE SD.SD_ROLE ADD CONSTRAINT SD_ROLE_PK PRIMARY KEY (UNIQUE_ID);
CREATE  INDEX SD_INDEX_ROLECODE ON SD.SD_ROLE (ROLE_CODE);
