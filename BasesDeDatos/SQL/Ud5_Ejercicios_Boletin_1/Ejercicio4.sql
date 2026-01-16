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
	CONSTRAINT ck_codigo_doctor PRIMARY KEY (codigo)
);

-- Creo la tabla unidades
CREATE TABLE unidades(
	id INTEGER AUTO_INCREMENT,
	nombre VARCHAR(25),
	planta INTEGER,
	codigo_doc INTEGER,
	CONSTRAINT fk_codigo_doctor_unidades FOREIGN KEY (codigo_doc) REFERENCES doctor (codigo) ON DELETE CASCADE,
	CONSTRAINT pk_id_unidades PRIMARY KEY(id)
);

CREATE TABLE paciente(
	nuss VARCHAR(15),
	nombre VARCHAR(25),
	edad INT,
	fecha_ingreso DATE,
	id INTEGER,
	CONSTRAINT fk_id_paciente_unidad FOREIGN KEY (id) REFERENCES unidades (id),
	CONSTRAINT pk_nuss_paciente PRIMARY KEY (nuss)
);

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

