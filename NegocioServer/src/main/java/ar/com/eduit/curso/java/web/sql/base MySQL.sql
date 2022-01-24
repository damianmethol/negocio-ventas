drop database if exists javaWebNoviembre;
create database javaWebNoviembre;
use javaWebNoviembre;

drop table if exists clientes;
drop table if exists articulos;

create table articulos(
    id int auto_increment primary key,
    descripcion varchar(25) not null,
    precio double not null,
    stock int not null
);

create table clientes(
    id int auto_increment primary key,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    edad int not null,
    idArticulo int not null
);

alter table clientes
    add constraint FK_clientes_idArticulos
    foreign key(idArticulo)
    references articulos(id);





