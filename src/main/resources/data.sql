--------------------------------------------------------
--  TRACK
--------------------------------------------------------

insert into TRACK (TRACK_ID, TITLE, IS_ACTIVE) VALUES (51, 'Java', 1);
insert into TRACK (TRACK_ID, TITLE, IS_ACTIVE) VALUES (52, '.NET', 1);

--------------------------------------------------------
--  CATEGORY
--------------------------------------------------------
insert into category (category_id, category_description, is_active) values (404, 'OOP', true);
insert into category (category_id, category_description, is_active) values (407, 'Basic Java', true);
insert into category (category_id, category_description, is_active) values (406, 'Advanced Java', true);
insert into category (category_id, category_description, is_active) values (410, 'Web', true);
insert into category (category_id, category_description, is_active) values (411, 'SQL', true);
insert into category (category_id, category_description, is_active) values (412, 'Basic C#', true);
insert into category (category_id, category_description, is_active) values (413, 'Advanced C#', true);

--------------------------------------------------------
--  WEIGHT
--------------------------------------------------------
-- OOP
insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, CATEGORY_ID, TRACK_ID) values (51404, 30, 404, 51);
insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, CATEGORY_ID, TRACK_ID) values (52404, 30, 404, 52);

-- WEB
insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, CATEGORY_ID, TRACK_ID) values (53404, 10, 410, 51);
insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, CATEGORY_ID, TRACK_ID) values (54405, 10, 410, 52);

-- SQL
insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, CATEGORY_ID, TRACK_ID) values (53405, 10, 411, 51);
insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, CATEGORY_ID, TRACK_ID) values (55405, 10, 411, 52);

-- JAVA
insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, CATEGORY_ID, TRACK_ID) values (56406, 30, 407, 51);
insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, CATEGORY_ID, TRACK_ID) values (56407, 20, 406, 51);

-- C#
insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, CATEGORY_ID, TRACK_ID) values (56408, 30, 412, 52);
insert into WEIGHT (WEIGHT_ID, WEIGHT_VALUE, CATEGORY_ID, TRACK_ID) values (56409, 20, 413, 52);

--------------------------------------------------------
--  QUESTION
--------------------------------------------------------
-- OOP
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10000, 404, true, 'What are the Four Pillars of OOP?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10001, 404, true, 'What is the difference between an object and a class?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10002, 404, true, 'Explain Abstraction.', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10003, 404, true, 'Explain Polymorphism.', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10004, 404, true, 'Explain Inheritance.', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10005, 404, true, 'Explain Encapsulation.', 'Sample Answer');

-- BASIC JAVA
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10100, 407, true, 'What are the JVM, JDK, and JRE?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10101, 407, true, 'What are the primitive datatypes in Java?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10102, 407, true, 'What are wrapper classes?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10103, 407, true, 'How do constructors work in Java?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10104, 407, true, 'What is the difference between == and .equals()?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10105, 407, true, 'What is the difference between heap memory and stack memory?', 'Sample Answer');

-- ADVANCED JAVA
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10200, 406, true, 'What does it mean for Java strings to be immutable?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10201, 406, true, 'What is constructor chaining?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10202, 406, true, 'What is a singleton and how can I create one?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10203, 406, true, 'What is thread safety?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10204, 406, true, 'Explain the Java collection framework.', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10205, 406, true, 'How do Maps in Java work?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10206, 406, true, 'What is a marker interface?', 'Sample Answer');

-- BASIC C#
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10300, 412, true, 'What is the difference between managed and unmanaged code?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10301, 412, true, 'What is the difference between a class and a struct?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10302, 412, true, 'What is boxing?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10303, 412, true, 'What is the constant keyword?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10304, 412, true, 'What is the difference between String and StringBuilder?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10305, 412, true, 'What is a sealed class?', 'Sample Answer');

-- ADVANCED C#
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10400, 413, true, 'What are delegates and how are they used?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10401, 413, true, 'What is a partial class?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10402, 413, true, 'What is the IEnumerable interface?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10403, 413, true, 'What is a jagged array?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10404, 413, true, 'How do the “is” and “as” operators work?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10405, 413, true, 'What is the object pool?', 'Sample Answer');

-- WEB
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10500, 410, true, 'What is HTML?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10501, 410, true, 'What is the structure of an HTML document? ', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10502, 410, true, 'List some HTML tags.', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10503, 410, true, 'What is <head> used for? <body>?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10504, 410, true, 'What is a doctype?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10505, 410, true, 'What is the tag for an ordered list? Unordered list?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10506, 410, true, 'What are some HTML5 tags?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10507, 410, true, 'What is the syntax for a comment in HTML?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10508, 410, true, 'Give me the HTML markup for a table.', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10509, 410, true, 'What are some tags you would use in a form?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10510, 410, true, 'What is CSS?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10511, 410, true, 'What are the different ways of styling an HTML page?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10512, 410, true, 'Describe the CSS box model.', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10513, 410, true, 'What are the different types of CSS selectors?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10514, 410, true, 'What is the relationship between HTML, CSS, and JavaScript?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10515, 410, true, 'What is JavaScript? What do we use it for?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10516, 410, true, 'Where is the best place to put a script tag in your HTML document?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10517, 410, true, 'What are the data types in JS?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10518, 410, true, 'What are the variable scopes in JS?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10519, 410, true, 'What are JS objects?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10520, 410, true, 'What is JSON?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10521, 410, true, 'How to convert JS object to/from JSON?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10522, 410, true, 'What does truthy/falsy mean?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10523, 410, true, 'What is type coercion?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10524, 410, true, 'What is the difference between == and === ?', 'Sample Answer');

-- SQL
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10600, 411, true, 'What is SQL?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10601, 411, true, 'What are the sub-languages in SQL?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10602, 411, true, 'What commands do we see in these sub-languages?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10603, 411, true, 'What is a Primary Key?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10604, 411, true, 'What is a Composite Key?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10605, 411, true, 'What is a Foreign Key?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10606, 411, true, 'What are the different types of joins?', 'Sample Answer');
insert into QUESTION (QUESTION_ID, CATEGORY_ID, IS_ACTIVE, QUESTION_TEXT, SAMPLE_ANSWER) values(10607, 411, true, 'What is the difference between Group By and Order By?', 'Sample Answer');
