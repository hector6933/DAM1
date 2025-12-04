-- Borramos la base de datos para hacer pruebas
DROP DATABASE restricciones;

-- Creamos la base de datos
CREATE DATABASE restricciones;

-- Nos posicionamos en ella
USE restricciones;

-- Creamos la tabla provincias
CREATE TABLE provincias (
	cod_provi NUMERIC(2),
	nombre VARCHAR(25) NOT NULL,
	pais VARCHAR(25),
	CONSTRAINT pk_cod_provi PRIMARY KEY(cod_provi),
	CONSTRAINT ck_provincias_pais CHECK (pais IN ('España','Portugal','Italia'))
);

-- Insertamos valores en la tabla provincias
INSERT INTO provincias VALUES (1,'Ávila','España');

-- Creamos la tabla empresas
CREATE TABLE empresas (
	cod_empresa NUMERIC(2),
	nombre VARCHAR(25) NOT NULL DEFAULT 'empresa1',
	fecha_creacion DATE,
	CONSTRAINT pk_cod_empresa PRIMARY KEY (cod_empresa)
);

-- Creamos la tabla continentes
CREATE TABLE continentes (
	cod_continente NUMERIC(2),
	nombre VARCHAR(20) NOT NUll DEFAULT 'EUROPA',
	CONSTRAINT pk_cod_continente PRIMARY KEY (cod_continente)
);

-- Creamos la tabla alumnos
CREATE TABLE alumnos (
	codigo NUMERIC(3),
	nombre VARCHAR(21) NOT NULL,
	apellido VARCHAR(30) NOT NULL,
	curso NUMERIC(1),
	fecha DATETIME DEFAULT NOW(),
	CONSTRAINT ck_curso CHECK (curso>=1 AND curso<=3),
	CONSTRAINT pk_codigo PRIMARY KEY (codigo)
);

-- Creamos la tabla empleado
CREATE TABLE empleado(
	cod_empleado NUMERIC(2),
	nombre VARCHAR(20) NOT NULL,
	apellido VARCHAR(25),
	salario DOUBLE(7,2),
	provincia NUMERIC(2),
	empresa NUMERIC(2),
	CONSTRAINT pk_cod_empleado PRIMARY KEY (cod_empleado),
	CONSTRAINT ck_salario_mayor0 CHECK (salario>0),
	CONSTRAINT fk_emp_provincia FOREIGN KEY (provincia) REFERENCES provincias (cod_provi) ON DELETE CASCADE,
	CONSTRAINT fk_emp_empresa FOREIGN KEY (empresa) REFERENCES empresas (cod_empresa)
);

-- Creamos la tabla personas
CREATE TABLE personas(
	dni CHAR(9),
	nombre VARCHAR(20),
	direccion VARCHAR(100),
	codprovin NUMERIC(2),
	CONSTRAINT fk_codprovin FOREIGN KEY (codprovin) REFERENCES provincias (cod_provi) ON DELETE CASCADE,
	CONSTRAINT pk_dni PRIMARY KEY (dni)
);

-- Creamos la tabla ejemplo1
CREATE TABLE ejemplo1 (
	dni VARCHAR(10),
	nombre VARCHAR(30),
	edad NUMERIC(2),
	fecha DATE,
	CONSTRAINT pk_dni PRIMARY KEY (dni)
);

-- Creamos la tabla ejemplo2
CREATE TABLE ejemplo2 (
	dni VARCHAR(10),
	nombre VARCHAR(30),
	edad NUMERIC(2),
	curso NUMERIC,
	CONSTRAINT ck_edad CHECK (edad>=5 AND edad<=20),
	CONSTRAINT ck_curso_ejemplo3 CHECK (curso IN (1,2,3))
);

-- Creamos la tabla alumnos2
CREATE TABLE alumnos2 (
	codigo NUMERIC(2),
	nombre VARCHAR(25) NOT NULL,
	CONSTRAINT codigo PRIMARY KEY (CODIGO)
);

-- Creamos la tabla modulos
CREATE TABLE modulos (
	codigo INTEGER,
	nombre VARCHAR(25),
	CONSTRAINT pk_codigo_modulos PRIMARY KEY (codigo)

);
-- Creamos la tabla notas
CREATE TABLE notas (
	cod_alumno NUMERIC(2),
	cod_modulo INTEGER,
	nota NUMERIC(2),
	CONSTRAINT pk_cod_al_mod PRIMARY KEY (cod_alumno,cod_modulo),
	CONSTRAINT fk_cod_modulo_notas FOREIGN KEY (cod_modulo) REFERENCES modulos (codigo),
	CONSTRAINT fk_cod_alumnos_notas FOREIGN KEY (cod_alumno) REFERENCES alumnos2 (codigo)
);