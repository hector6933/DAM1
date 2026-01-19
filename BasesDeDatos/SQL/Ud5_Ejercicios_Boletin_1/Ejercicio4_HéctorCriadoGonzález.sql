-- Elimino la base de datos en caso de que exista
DROP DATABASE IF EXISTS CLINICA;

-- Creo la base de datos
CREATE DATABASE CLINICA;

-- Entro en la base de datos
USE CLINICA;

-- Creo la tabla doctor
CREATE TABLE doctor(
	codigo INTEGER,
	nombre VARCHAR(25),
	especialidad VARCHAR(40),
	CONSTRAINT ck_nombre_doctor_noNulo CHECK (nombre is not null),
	CONSTRAINT ck_nombre_doctor CHECK (nombre = UPPER(nombre)),
	CONSTRAINT ck_codigo_doctor PRIMARY KEY (codigo)
);

-- Creo la tabla unidades
CREATE TABLE unidades(
	id INTEGER AUTO_INCREMENT,
	nombre VARCHAR(25),
	planta INTEGER,
	codigo_doc INTEGER,
	CONSTRAINT uq_nombre_unidad UNIQUE (nombre),
	CONSTRAINT ck_nombre_unidad_not_null CHECK (nombre is not null),
	CONSTRAINT ck_nombre_unidades CHECK (nombre IN ('trauma','quemados','interna','corazón')),
	CONSTRAINT fk_codigo_doctor_unidades FOREIGN KEY (codigo_doc) REFERENCES doctor (codigo) ON DELETE CASCADE,
	CONSTRAINT pk_id_unidades PRIMARY KEY(id)
);

-- Creo la tabla paciente 
CREATE TABLE paciente(
	nuss VARCHAR(15),
	nombre VARCHAR(25),
	edad INT,
	fecha_ingreso DATE,
	id INTEGER DEFAULT 1002,
	CONSTRAINT ck_fecha_ingreso_paciente CHECK (fecha_ingreso>'2010-01-01'),
	CONSTRAINT ck_edad_paciente CHECK (edad>=5 AND edad<=80),
	CONSTRAINT fk_id_paciente_unidad FOREIGN KEY (id) REFERENCES unidades (id) ON DELETE SET DEFAULT,
	CONSTRAINT pk_nuss_paciente PRIMARY KEY (nuss)
);

-- Creo la tabla aitende
CREATE TABLE atiende(
	nuss VARCHAR(15),
	codigo_doctor INTEGER,
	fecha DATE,
	sintoma LONGTEXT,
	tratamiento LONGTEXT,
	CONSTRAINT fk_codigo_doctor_atiende FOREIGN KEY (codigo_doctor) REFERENCES doctor (codigo) ON DELETE CASCADE,
	CONSTRAINT fk_nuss_atiende FOREIGN KEY (nuss) REFERENCES paciente (nuss) ON DELETE CASCADE,
	CONSTRAINT pk_atiende PRIMARY KEY (nuss,codigo_doctor,fecha)
);

-- Creo la tabla enfermería
CREATE TABLE enfermeria (
	codigo INTEGER,
	nombre VARCHAR(25),
	fecha_contrato DATE,
	CONSTRAINT pk_codigo_enfermeria PRIMARY KEY (codigo)
);

-- Añado un nuevo campo en la tabla unidades
-- Y le meto una restricción ya que es una calve ajena
ALTER TABLE unidades ADD encargado INTEGER;
ALTER TABLE unidades ADD CONSTRAINT fk_efermero_encargado FOREIGN KEY (encargado) REFERENCES enfermeria (codigo);

-- Añado un nuevo campo en la tabla atiende
ALTER TABLE atiende ADD precio INTEGER DEFAULT 10;

-- Añado un nuevo campo en la tabla paciente 
ALTER TABLE paciente ADD sexo VARCHAR(3);
ALTER TABLE paciente ADD CONSTRAINT ck_sexo_paciente CHECK (sexo IN ('M,F','SD'));

-- Modifico el campo nombre de la tabla doctor
ALTER TABLE doctor DROP nombre;
ALTER TABLE doctor ADD nombre VARCHAR(50);

-- Borro la columna precio de la tabla atiende
ALTER TABLE atiende DROP precio;

