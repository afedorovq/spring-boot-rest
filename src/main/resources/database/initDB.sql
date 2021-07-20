create database spring_rest_db;

use spring_rest_db;

create table users (
    id       int          not null primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null
);