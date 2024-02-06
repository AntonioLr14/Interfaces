use dentiapp;

/* Inserccion en la tabla Personas */
insert into dentiapp.Personas (DNI, Nombre, Apellidos, Telefono, Correo) values ('12345678A','Prueba','Prueba1 Prueba2','123456789','Prueba@DENTILAX.es');
insert into dentiapp.Personas (DNI, Nombre, Apellidos, Telefono, Correo) values ('23456789B','Prueba1','Prueba2 Prueba3','234567890','Prueba1@DENTILAX.es');
insert into dentiapp.Personas (DNI, Nombre, Apellidos, Telefono, Correo) values ('34567890C','Prueba2','Prueba3 Prueba4','345678901','Prueba2@DENTILAX.es');
insert into dentiapp.Personas (DNI, Nombre, Apellidos, Telefono, Correo) values ('45678901D','Prueba3','Prueba4 Prueba5','456789012','Prueba3@DENTILAX.es');
insert into dentiapp.Personas (DNI, Nombre, Apellidos, Telefono, Correo) values ('56789012E','Prueba4','Prueba5 Prueba6','567890123','Prueba4@DENTILAX.es');

/* Inserccion en la tabla Usuarios */
insert into dentiapp.Usuarios (DNI, Contrasena, Perfil, Estado) values ('12345678A','d760688da522b4dc3350e6fb68961b0934f911c7d0ff337438cabf4608789ba94ce70b6601d7e08a279ef088716c4b1913b984513fea4c557d404d0598d4f2f1','Administrador',1);
insert into dentiapp.Usuarios (DNI, Contrasena, Perfil, Estado) values ('23456789B','d760688da522b4dc3350e6fb68961b0934f911c7d0ff337438cabf4608789ba94ce70b6601d7e08a279ef088716c4b1913b984513fea4c557d404d0598d4f2f1','Doctor',1);
insert into dentiapp.Usuarios (DNI, Contrasena, Perfil, Estado) values ('56789012E','d760688da522b4dc3350e6fb68961b0934f911c7d0ff337438cabf4608789ba94ce70b6601d7e08a279ef088716c4b1913b984513fea4c557d404d0598d4f2f1','Doctor',1);

/* Inserccion en la tabla Pacientes */
insert into dentiapp.Pacientes (DNI) values ('34567890C');

/* Inserccion en la tabla Proveedores */
insert into dentiapp.Proveedores (DNI, Direccion, Empresa) values ('45678901D','Calle Prueba','MEDAC');

/* Inserccion en la tabla Pagos */
insert into dentiapp.Pagos (ID_paciente, Tipo, Duracion, Cantidad_abonada, Cantidad_total_a_pagar) values (1,'Pago unico',null,100,100);

/* Inserccion en la tabla Odontograma */
insert into dentiapp.Odontograma (ID_paciente, Diente, Tratamiento_realizado, Fecha, Ubicacion) values (1,11,'Limpieza general',null,'abajo');
insert into dentiapp.Odontograma (ID_paciente, Diente, Tratamiento_realizado, Fecha, Ubicacion) values (1,21,'Limpieza general',null,'arriba');
insert into dentiapp.Odontograma (ID_paciente, Diente, Tratamiento_realizado, Fecha, Ubicacion) values (1,12,'Limpieza general',null,'izquierda');
insert into dentiapp.Odontograma (ID_paciente, Diente, Tratamiento_realizado, Fecha, Ubicacion) values (1,22,'Limpieza general',null,'derecha');
insert into dentiapp.Odontograma (ID_paciente, Diente, Tratamiento_realizado, Fecha, Ubicacion) values (1,13,'Limpieza general',null,'centro');
insert into dentiapp.Odontograma (ID_paciente, Diente, Tratamiento_realizado, Fecha, Ubicacion) values (1,23,'Limpieza general',null,'centro');

/* Inserccion en la tabla Especialidades */
insert into dentiapp.Especialidades (Nombre, Descripcion) values ('Dentista general',null);
insert into dentiapp.Especialidades (Nombre, Descripcion) values ('Odontopediatra','Dentista pediatrico');
insert into dentiapp.Especialidades (Nombre, Descripcion) values ('Ortodoncista','Especialista en ortodoncia');
insert into dentiapp.Especialidades (Nombre, Descripcion) values ('Periodoncista','Especialista en encias');
insert into dentiapp.Especialidades (Nombre, Descripcion) values ('Endodoncista','Especialista en tratamientos de conducto');
insert into dentiapp.Especialidades (Nombre, Descripcion) values ('Patologo oral','Cirujano oral');
insert into dentiapp.Especialidades (Nombre, Descripcion) values ('Prostodoncista','Especialista en protesis');

/* Inserccion en la tabla Doctores */
insert into dentiapp.Doctores (DNI, ID_especialidad, Salario, Fecha_inicio_contrato, Fecha_fin_contrato) values ('23456789B',1,1000,'2024-1-30',null);
insert into dentiapp.Doctores (DNI, ID_especialidad, Salario, Fecha_inicio_contrato, Fecha_fin_contrato) values ('56789012E',1,1000,'2024-1-30',null);

/* Inserccion en la tabla Tratamientos */
insert into dentiapp.Tratamientos (ID_especialidad, Nombre, Precio, Estado) values (1,'Limpieza general',50,1);

/* Inserccion en la tabla Citas */
insert into dentiapp.Citas (ID_paciente, ID_doctor, ID_tratamiento, Fecha_hora, Observaciones) values (1,2,1,'2024-1-30 10:00','El paciente se le ha realizado una limpieza general');

/* Inserccion en la tabla Materiales */
insert into dentiapp.Materiales (Nombre, Cantidad, Estado) values ('Mascarillas',5,1);

/* Inserccion en la tabla Solicitudes */
insert into dentiapp.Solicitudes (ID_doctor, ID_material, Cantidad, Fecha) values (2,1,5,'2024-1-31');

/* Inserccion en la tabla Precios */
insert into dentiapp.Precios (ID_proveedor, ID_material, Precio_unitario) values (1,1,50);

/* Inserccion en la tabla Pedidos */
insert into dentiapp.Pedidos (ID_proveedor, ID_material, Cantidad, Precio_total, Fecha_inicio_pedido, Fecha_fin_pedido) values (1,1,50,2500,'2024-1-31',null);
