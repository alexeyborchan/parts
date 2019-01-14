USE test;

drop table if exists part;
create table part (
  part_id int(8) not null auto_increment primary key,
  part_name varchar(25) not null,
  is_necessary bit(1) not null default b'0',
  amount int(8) not null default '0');

insert into test.part (part_name, is_necessary, amount) values ('процессор', 1, 3);
insert into test.part (part_name, is_necessary, amount) values ('материская плата', 1, 4);
insert into test.part (part_name, is_necessary, amount) values ('видеокарта', 0, 6);
insert into test.part (part_name, is_necessary, amount) values ('мышка', 0, 12);
insert into test.part (part_name, is_necessary, amount) values ('наушники', 0, 6);
insert into test.part (part_name, is_necessary, amount) values ('память', 1, 10);
insert into test.part (part_name, is_necessary, amount) values ('подсветка корпуса', 0, 6);
insert into test.part (part_name, is_necessary, amount) values ('корпус', 1, 5);
insert into test.part (part_name, is_necessary, amount) values ('SSD диск', 1, 9);
insert into test.part (part_name, is_necessary, amount) values ('HHD диск', 0, 9);
insert into test.part (part_name, is_necessary, amount) values ('звуковая карта', 0, 9);
insert into test.part (part_name, is_necessary, amount) values ('звуковая карта2', 0, 4);
insert into test.part (part_name, is_necessary, amount) values ('память2', 1, 1);
insert into test.part (part_name, is_necessary, amount) values ('память3', 1, 3);
insert into test.part (part_name, is_necessary, amount) values ('клавиатура', 0, 6);
insert into test.part (part_name, is_necessary, amount) values ('монитор', 0, 7);
insert into test.part (part_name, is_necessary, amount) values ('монитор4K', 0, 2);
insert into test.part (part_name, is_necessary, amount) values ('материнская плата2', 1, 2);
insert into test.part (part_name, is_necessary, amount) values ('HHD диск2', 0, 2);
insert into test.part (part_name, is_necessary, amount) values ('HHD диск3', 0, 1);
insert into test.part (part_name, is_necessary, amount) values ('корпус2', 1, 1);
insert into test.part (part_name, is_necessary, amount) values ('корпус3', 1, 2);
    
    
    