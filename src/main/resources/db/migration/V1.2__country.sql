CREATE TABLE country (
   id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
   country_name varchar(255) not null,
   country_code varchar(20) not null
);


create sequence country_sequence start with 5 increment by 1;


insert into country (country_name, country_code) values ('Lithuania', 'LT');
insert into country (country_name, country_code) values ('Latvia', 'LV');
insert into country (country_name, country_code) values ('Estonia', 'EE');
insert into country (country_name, country_code) values ('Sweden', 'SE');




