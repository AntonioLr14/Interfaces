
/* Creacion de la base de datos */
create database if not exists dentiapp;

/* Creacion de las tablas de la base de datos */

/* Creacion de la tabla Personas */
create table if not exists dentiapp.Personas (
    DNI varchar(255) primary key,
    Nombre varchar(255) not null,
    Apellidos varchar(255) not null,
    Telefono varchar(255) unique not null,
    Correo varchar(255) unique not null
);

/* Creacion de la tabla Usuarios */
create table if not exists dentiapp.Usuarios (
    ID_usuario int primary key auto_increment,
    DNI varchar(255) not null,
    Contrasena varchar(255) not null,
    Perfil varchar(255) not null,
    Estado tinyint not null,
    constraint foreign key (DNI) references Personas(DNI)
);

/* Creacion de la tabla Pacientes */
create table if not exists dentiapp.Pacientes (
    ID_paciente int primary key auto_increment,
    DNI varchar(255) not null,
    constraint foreign key (DNI) references Personas(DNI)
);

/* Creacion de la tabla Proveedores */
create table if not exists dentiapp.Proveedores (
    ID_proveedor int primary key auto_increment,
    DNI varchar(255) not null,
    Direccion varchar(255) null,
    Empresa varchar(255) not null,
    constraint foreign key (DNI) references Personas(DNI)
);

/* Creacion de la tabla Pagos */
create table if not exists dentiapp.Pagos (
    ID_pago int primary key auto_increment,
    ID_paciente int not null,
    Tipo varchar(255) not null,
    Duracion int null,
    Cantidad_abonada float not null,
    Cantidad_total_a_pagar float not null,
    constraint foreign key (ID_paciente) references Pacientes(ID_paciente)
);

/* Creacion de la tabla Odontograma */
create table if not exists dentiapp.Odontograma (
    ID int primary key auto_increment,
    ID_paciente int not null,
    Diente int not null,
    Tratamiento_realizado varchar(255) null,
    Fecha date null,
    Ubicacion varchar(255) not null,
    constraint foreign key (ID_paciente) references Pacientes(ID_paciente)
);

/* Creacion de la tabla Especialidades */
create table if not exists dentiapp.Especialidades (
    ID_especialidad int primary key auto_increment,
    Nombre varchar(255) unique not null,
    Descripcion varchar(255) null
);

/* Creacion de la tabla Doctores */
create table if not exists dentiapp.Doctores (
    ID_doctor int primary key auto_increment,
    DNI varchar(255) not null,
    ID_especialidad int not null,
    Salario float not null,
    Fecha_inicio_contrato date not null,
    Fecha_fin_contrato date null,
    constraint foreign key (DNI) references Personas(DNI),
    constraint foreign key (ID_especialidad) references Especialidades(ID_especialidad)
);

/* Creacion de la tabla Tratamientos */
create table if not exists dentiapp.Tratamientos (
    ID_tratamiento int primary key auto_increment,
    ID_especialidad int not null,
    Nombre varchar(255) unique not null,
    Precio float not null,
    Estado tinyint not null,
    constraint foreign key (ID_especialidad) references Especialidades(ID_especialidad)
);

/* Creacion de la tabla Citas */
create table if not exists dentiapp.Citas (
    ID_cita int primary key auto_increment,
    ID_paciente int not null,
    ID_doctor int not null,
    ID_tratamiento int not null,
    Fecha_hora varchar(255) not null,
    Observaciones varchar(255) null,
    constraint foreign key (ID_paciente) references Pacientes(ID_paciente),
    constraint foreign key (ID_doctor) references Doctores(ID_doctor),
    constraint foreign key (ID_tratamiento) references Tratamientos(ID_tratamiento)
);

/* Creacion de la tabla Materiales */
create table if not exists dentiapp.Materiales (
    ID_material int primary key auto_increment,
    Nombre varchar(255) not null,
    Cantidad int not null,
    Estado tinyint not null
);

/* Creacion de la tabla Solicitudes */
create table if not exists dentiapp.Solicitudes (
    ID_solicitud int primary key auto_increment,
    ID_doctor int not null,
    ID_material int not null,
    Cantidad int not null,
    Fecha date not null,
    constraint foreign key (ID_doctor) references Doctores(ID_doctor),
    constraint foreign key (ID_material) references Materiales(ID_material)
);

/* Creacion de la tabla Precios */
create table if not exists dentiapp.Precios (
    ID int primary key auto_increment,
    ID_proveedor int not null,
    ID_material int not null,
    Precio_unitario float not null,
    constraint foreign key (ID_proveedor) references Proveedores(ID_proveedor),
    constraint foreign key (ID_material) references Materiales(ID_material)
);

/* Creacion de la tabla Pedidos */
create table if not exists dentiapp.Pedidos (
    ID_pedido int primary key auto_increment,
    ID_proveedor int not null,
    ID_material int not null,
    Cantidad int not null,
    Precio_total float not null,
    Fecha_inicio_pedido date not null,
    Fecha_fin_pedido date null,
    constraint foreign key (ID_proveedor) references Proveedores(ID_proveedor),
    constraint foreign key (ID_material) references Materiales(ID_material)
);