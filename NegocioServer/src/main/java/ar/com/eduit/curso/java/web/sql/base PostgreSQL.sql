-- postgresql
drop table if exists clientes;
drop table if exists articulos;

create table articulos(
    id serial primary key,
    descripcion varchar(50) not null,
    precio float8 not null,
    stock int not null
);

create table clientes(
    id serial primary key,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    edad int not null,
    idArticulo int not null
);

alter table clientes
    add constraint FK_clientes_idArticulos
    foreign key(idArticulo)
    references articulos(id);

