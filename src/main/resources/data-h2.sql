-- Start IDs for test data lower than sequence start value to avoid PK constraint violations 
insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES (10001, 'Soft Skills', 1);
insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES (10002, 'Tech Skills', 1);
insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES (10003, 'Time Hacking Skills', 1);
insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES (10004, 'Basic Math Skills', 0);
insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES (10006, 'Beta Skills', 0);