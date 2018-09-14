drop database if exists shop;
create database shop default character set utf8;
use shop;
drop table if exists product;

create table product
(
   id                  int not null auto_increment,
   name                varchar(20),
   price               decimal(8,2),
   pic                 varchar(100),
   remark              longtext,
   date                timestamp default CURRENT_TIMESTAMP,
   primary key (id)
);

/* 商品测试用例 */
insert into product (name,price,remark) values ('圣得西服',3000.00,'这里是简单介绍');
insert into product (name,price,remark) values ('衫衫西服',3000.00,'这里是简单介绍');
insert into product (name,price,remark) values ('Iphone6',6000.00,'这里是简单介绍');

select * from product;