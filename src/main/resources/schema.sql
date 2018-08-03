create table question(
    question_id number(10) primary key,
    bucket_id number (10) not null,
    is_active number(1) not null,
    question_text varchar2(500) not null,
    sample_answer_1 varchar2(500) not null,
    sample_answer_2 varchar2(500) not null,
    sample_answer_3 varchar2(500) not null,
    sample_answer_4 varchar2(500) not null,
    sample_answer_5 varchar2(500) not null
);

create table bucket(
    bucket_id number(10) primary key,
    category_id number(10) not null,
    bucket_description varchar2(100) not null,
    is_active number(1) not null,
    skill_type_id number(10) not null
);

create table skill_type(
    skill_type_id number(10) primary key,
    title varchar2(100) not null
);

create table category(
    category_id number(10) primary key,
    title varchar2(100) not null,
    is_active number(1) not null
);

create table weight(
    weight_id number(10) primary key,
    weight number(10) not null,
    category_id number(10) not null,
    skill_type_id number(10) not null
);

CREATE SEQUENCE IF NOT EXISTS QUESTION_SEQUENCE MINVALUE 100001 INCREMENT BY 1 START WITH 100001;

CREATE SEQUENCE IF NOT EXISTS BUCKET_SEQUENCE MINVALUE 100001 INCREMENT BY 1 START WITH 100001;

CREATE SEQUENCE IF NOT EXISTS SKILL_TYPE_SEQUENCE MINVALUE 100001 INCREMENT BY 1 START WITH 100001;

CREATE SEQUENCE IF NOT EXISTS CATEGORY_SEQUENCE MINVALUE  100001 INCREMENT BY 1 START WITH  100001;