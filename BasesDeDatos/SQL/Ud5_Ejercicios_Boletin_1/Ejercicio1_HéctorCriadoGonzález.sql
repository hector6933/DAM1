-- Borramos la base de datos en caso de que exista para hacer pruebas
DROP DATABASE IF EXISTS clinica_salud;

-- Creamos la base de datos
CREATE DATABASE clinica_salud;

-- Usamos la base de datos
USE clinica_salud;

-- Creamos la tabla especialidades
CREATE TABLE especialidades (
	cod_especialidad NUMERIC(3),
	nombre_especialidad VARCHAR(50) NOT NULL,
	area_medica VARCHAR(30),
	disponible CHAR(1) DEFAULT 'S',
	CONSTRAINT pk_cod_especialidad PRIMARY KEY (cod_especialidad),
	CONSTRAINT ck_nombre_especialidad CHECK (nombre_especialidad IN ('Medicina','General','Cirugia','Pediatria','Cardiologia')),
	CONSTRAINT ck_disponible CHECK (disponible IN ('S','N'))
);

CREATE TABLE medicos (
	num_colegiado VARCHAR(15),
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	telefono NUMERIC(12),
	email VARCHAR(80) NOT NULL,
	fecha_y_hora_alta DATETIME DEFAULT NOW(),
	anos_experiencia INTEGER,
	cod_especialidad NUMERIC(3),
	CONSTRAINT pk_num_colegiado PRIMARY KEY (num_colegiado),
	CONSTRAINT ck_anos_experiencia CHECK (anos_experiencia>=0 AND anos_experiencia<50),
	CONSTRAINT fk_cod_especialidad FOREIGN KEY (cod_especialidad) REFERENCES especialidades (cod_especialidad) ON DELETE RESTRICT
);

CREATE TABLE pacientes (
	num_historial INTEGER AUTO_INCREMENT,
	dni CHAR(10) NOT NULL UNIQUE,
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	fecha_nacimiento DATE,
	grupo_sanguineo CHAR(3),
	alergias VARCHAR(200),
	telefono_contacto CHAR(12),
	CONSTRAINT pk_num_historial PRIMARY KEY (num_historial),
	CONSTRAINT ck_grupo_sanguineo CHECK (grupo_sanguineo IN ('A+','A-','B+','B-','AB+','AB-','O+','O-'))
); 

CREATE TABLE consultas (
	cod_consulta INTEGER AUTO_INCREMENT,
	num_historial_paciente INTEGER,
	num_colegiado_medico VARCHAR(15),
	fecha_consulta DATETIME,
	diagnostico VARCHAR(200),
	precio DECIMAL(6,2),
	pagado CHAR(1) DEFAULT 'N',
	CONSTRAINT pk_cod_consulta PRIMARY KEY (cod_consulta),
	CONSTRAINT fk_num_historial_paciente FOREIGN KEY (num_historial_paciente) REFERENCES pacientes (num_historial) ON DELETE CASCADE,
	CONSTRAINT fk_colegiado_medico FOREIGN KEY (num_colegiado_medico) REFERENCES medicos (num_colegiado) ON DELETE RESTRICT,
	CONSTRAINT ck_precio CHECK (precio>0 AND precio<5000),
	CONSTRAINT ck_pagado CHECK (pagado IN ('S','N'))
);

/*
Inserta en ESPECIALIDADES la especialidad con código 101, nombre 'CARDIOLOGIA', área
'CARDIOLOGIA' y disponible 'S'
*/
INSERT INTO especialidades VALUES (101,'Cardiologia','Cardiologia','S');

/*
 Intenta insertar en MEDICOS el médico con número de colegiado '28-4567890', nombre
'Carlos', apellidos 'Fernández Ruiz', email 'cfernandez@clinica.es', años de experiencia 5 y
código de especialidad 999. ¿Qué ocurre? ¿Por qué?
*/
-- Esa insercción da un error ya que la especialidad 999 no existe
-- Así está insertado correctamente:

INSERT INTO medicos (num_colegiado,nombre,apellidos,email,anos_experiencia,cod_especialidad) VALUES ('28-4567890','Carlos','Fernández Ruiz','cfernandez@clinica.es',5,101);

/*
Inserta en PACIENTES un paciente con DNI '12345678A', nombre 'María', apellidos 'García
López', fecha de nacimiento '1990-05-15', grupo sanguíneo 'A+' y teléfono '666777888'.
*/

INSERT INTO pacientes (dni,nombre,apellidos,fecha_nacimiento,grupo_sanguineo,telefono_contacto) VALUES ('12345678A','María','García López','1990-06-15','A+','666777888');

/*
Inserta en CONSULTAS una consulta del paciente anterior con el médico Carlos Fernández,
precio 75.50 y estado de pago 'N'.
*/

INSERT INTO consultas (num_historial_paciente,num_colegiado_medico,precio,pagado) VALUES (1,'28-4567890',75.50,'N');

/*
Añade un campo horario_consulta en la tabla MEDICOS que sea de tipo texto de 20
caracteres (valores permitidos: 'MAÑANA', 'TARDE', 'COMPLETO').
*/

ALTER TABLE medicos ADD horario_consulta VARCHAR(20);
ALTER TABLE medicos ADD CONSTRAINT ck_horario_consulta CHECK (horario_consulta IN ('MAÑANA','TARDE','COMPLETO'));

/*
Modifica el campo email de la tabla MEDICOS para que tenga una longitud de 100
caracteres.
*/

ALTER TABLE medicos MODIFY email VARCHAR(100);

/*
Añade un campo mutua en la tabla PACIENTES de tipo texto de 50 caracteres con valor por
defecto 'PARTICULAR'
*/

ALTER TABLE pacientes ADD mutua VARCHAR(50) DEFAULT 'PARTICULAR';

/*
Elimina el campo alergias de la tabla PACIENTES
*/

ALTER TABLE pacientes DROP alergias;

/*
Añade una restricción CHECK a la tabla CONSULTAS para que el campo precio no pueda
superar los 1000 euros (modifica la restricción existente).
*/
ALTER TABLE consultas DROP CONSTRAINT ck_precio;
ALTER TABLE consultas ADD CONSTRAINT ck_precio_consultas CHECK (precio>=0 AND precio<=1000);

-- Creo una restriccion UNIQUE en la tabla medicos para el campo email
ALTER TABLE medicos ADD CONSTRAINT uq_email_medicos UNIQUE (email);