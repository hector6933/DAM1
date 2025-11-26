DROP DATABASE restricciones;

CREATE DATABASE restricciones;

USE restricciones;

CREATE TABLE provincias (
	cod_provi NUMERIC(2),
	nombre VARCHAR(25) NOT NULL,
	pais VARCHAR(25),
	CONSTRAINT pk_cod_provi PRIMARY KEY(cod_provi),
	CONSTRAINT ck_provincias_pais CHECK (pais IN ('España','Portugal','Italia'))
);

INSERT INTO provincias VALUES (1,'Ávila','España');

CREATE TABLE empresas (
	cod_empresa NUMERIC(2),
	nombre VARCHAR(25) NOT NULL DEFAULT 'empresa1',
	fecha_creacion DATE,
	CONSTRAINT pk_cod_empresa PRIMARY KEY (cod_empresa)
);

CREATE TABLE continentes (
	cod_continente NUMERIC(2),
	nombre VARCHAR(20) NOT NUll DEFAULT 'EUROPA',
	CONSTRAINT pk_cod_continente PRIMARY KEY (cod_continente)
);

CREATE TABLE alumnos (
	codigo NUMERIC(3),
	nombre VARCHAR(21) NOT NULL,
	apellido VARCHAR(30) NOT NULL,
	curso NUMERIC(1),
	fecha DATETIME DEFAULT NOW(),
	CONSTRAINT ck_curso CHECK (curso>=1 AND curso<=3),
	CONSTRAINT pk_codigo PRIMARY KEY (codigo)
);