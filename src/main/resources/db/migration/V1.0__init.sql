--Swedbank demo database
--Person table
CREATE TABLE person (
   pid bigint PRIMARY KEY,
   first_name varchar(255) not null,
   middle_name varchar(255),
   last_name varchar(255) not null,
   email varchar(255),
   phone varchar(255),
   country_id bigint
   );

--Person data
insert into person (pid, first_name, middle_name, last_name, email, phone, country_id) values (38202020577,'Testas', '',  'Testauskas', 'test@test.com', '+37060035645', 2 );
insert into person (pid, first_name, middle_name, last_name, email, phone, country_id) values (38202020578,'Testas', '',  'Testauskas1', 'test@test.com', '+37060035645', 1 );
insert into person (pid, first_name, middle_name, last_name, email, phone, country_id) values (38202020579,'Testas', '',  'Testauskas2', 'test@test.com', '+37060035645', 3 );


