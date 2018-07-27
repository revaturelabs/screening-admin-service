-- Start IDs for test data lower than sequence start value to avoid PK constraint violations 
insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES (10001, 'Soft Skills', 1);
insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES (10002, 'Tech Skills', 1);
insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES (10003, 'Time Hacking Skills', 1);
insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES (10004, 'Basic Math Skills', 0);
insert into SKILL_TYPE (SKILL_TYPE_ID, TITLE, IS_ACTIVE) VALUES (10006, 'Beta Skills', 0);

--enter some test data for weight
insert into WEIGHT (WEIGHT_ID, WEIGHT, CATEGORY_ID, SKILL_TYPE_ID) values (1, 0, 404, 10001);
insert into WEIGHT (WEIGHT_ID, WEIGHT, CATEGORY_ID, SKILL_TYPE_ID) values (2, 0, 404, 10002);
insert into WEIGHT (WEIGHT_ID, WEIGHT, CATEGORY_ID, SKILL_TYPE_ID) values (3, 0, 404, 10003);
insert into WEIGHT (WEIGHT_ID, WEIGHT, CATEGORY_ID, SKILL_TYPE_ID) values (4, 0, 405, 10001);
insert into WEIGHT (WEIGHT_ID, WEIGHT, CATEGORY_ID, SKILL_TYPE_ID) values (5, 0, 405, 10002);
insert into WEIGHT (WEIGHT_ID, WEIGHT, CATEGORY_ID, SKILL_TYPE_ID) values (6, 0, 405, 10003);
insert into WEIGHT (WEIGHT_ID, WEIGHT, CATEGORY_ID, SKILL_TYPE_ID) values (7, 0, 406, 10001);
insert into WEIGHT (WEIGHT_ID, WEIGHT, CATEGORY_ID, SKILL_TYPE_ID) values (8, 0, 406, 10002);

--enter some test data for category
insert into CATEGORY (CATEGORY_ID, TITLE, IS_ACTIVE) values (404, 'JAVA', 1); 
insert into CATEGORY (CATEGORY_ID, TITLE, IS_ACTIVE) values (405, 'Spring', 1); 
insert into CATEGORY (CATEGORY_ID, TITLE, IS_ACTIVE) values (406, 'SQL', 0); 
insert into CATEGORY (CATEGORY_ID, TITLE, IS_ACTIVE) values (407, 'Hibernate', 0);
insert into CATEGORY (CATEGORY_ID, TITLE, IS_ACTIVE) values (420, 'Webservices', 1); 