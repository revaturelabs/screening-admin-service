
create table BUCKET(
    bucket_id number(10) primary key,
    category_id number(10) not null,
    bucket_description varchar2(100) not null,
    skill_type_id number(10) not null,
      is_active number(1) not null
)

