create database App_cadastro;

use App_cadastro;

create table Usuario (
    Id_usu int primary key auto_increment,
    Nome varchar(50),
    Sobrenome varchar(50),
    email nvarchar(50) unique
);


