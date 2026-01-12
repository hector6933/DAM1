-- Ejercicio 2

-- Borramos la base de datos
DROP DATABASE IF EXISTS ACADEMIA_VIRTUAL;

-- Creamos la base de datos
CREATE DATABASE ACADEMIA_VIRTUAL;

-- Usamos la base de datos
USE ACADEMIA_VIRTUAL;

-- Creamos la tabla categoria
CREATE TABLE categorias(
	id_categoria INTEGER AUTO_INCREMENT,
	nombre_categoria VARCHAR(40) UNIQUE NOT NULL,
	descripcion VARCHAR(150),
	activa CHAR(1) DEFAULT 'S',
	CONSTRAINT pk_id_categoria PRIMARY KEY (id_categoria),
	CONSTRAINT ck_activa CHECK (activa IN ('S','N'))
);

-- Creamos la tabla instructores
CREATE TABLE instructores (
	email VARCHAR(100),
	nombre_completo VARCHAR(80) NOT NULL,
	biografia LONGTEXT,
	fecha_registro DATETIME DEFAULT NOW(),
	puntuacion_media DECIMAL(3,2),
	certificado CHAR(1),
	linkedin VARCHAR(150),
	CONSTRAINT ck_certificado CHECK (certificado IN ('S','N')),
	CONSTRAINT ck_puntuacion_media CHECK(puntuacion_media>=0 AND puntuacion_media<=5),
	CONSTRAINT pk_email PRIMARY KEY (email)
);

-- Creamos la tabla cursos

CREATE TABLE cursos(
	cod_curso VARCHAR(10),
	titulo VARCHAR(100) NOT NULL,
	descripcion TEXT,
	nivel VARCHAR(15),
	duracion_horas INT,
	precio DECIMAL(6,2),
	fecha_creacion DATETIME DEFAULT NOW(),
	plaza_max INT,
	id_categoria INTEGER,
	email_instructor VARCHAR(100),
	CONSTRAINT fk_email_instructor_cursos FOREIGN KEY (email_instructor) REFERENCES instructores (email) ON DELETE CASCADE,
	CONSTRAINT fk_id_categoria_cursos FOREIGN KEY (id_categoria) REFERENCES categorias (id_categoria) ON DELETE RESTRICT,
	CONSTRAINT ck_plazas_max CHECK (plaza_max>0 AND plaza_max<=100),
	CONSTRAINT ck_precio CHECK (precio>=0),
	CONSTRAINT ck_duracion_horas CHECK (duracion_horas>0 AND duracion_horas <500),
	CONSTRAINT ck_nivel CHECK (nivel IN ('BASICO','INTERMEDIO','AVANZADO','EXPERTO')),
	CONSTRAINT pk_cod_curso PRIMARY KEY (cod_curso)
);

-- Creamos la tabla estudiantes

CREATE TABLE estudiantes(
	id_estudiante INT AUTO_INCREMENT,
	email VARCHAR(100) UNIQUE NOT NULL,
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	pais VARCHAR(50),
	fecha_nacimiento DATE,
	premiun CHAR(1) DEFAULT 'N',
	CONSTRAINT ck_premiun CHECK (premiun IN ('S','N')),
	CONSTRAINT pk_id_estudiante PRIMARY KEY (id_estudiante)
);

-- Creamos la tabla matriculas

CREATE TABLE matriculas(
	id_matricula INT AUTO_INCREMENT,
	id_estudiante INT,
	cod_curso VARCHAR(10),
	fecha_matricula DATETIME DEFAULT NOW(),
	progreso INT DEFAULT 0,
	calificacion_final DECIMAL(4,2),
	completado CHAR(1) DEFAULT 'N',
	CONSTRAINT ck_completado CHECK (completado IN ('S','N')),
	CONSTRAINT ck_calificacion CHECK (calificacion_final>=0 AND calificacion_final<=100),
	CONSTRAINT ck_progreso CHECK (progreso>=0 AND progreso<=100),
	CONSTRAINT fk_cod_curso_matriculas FOREIGN KEY (cod_curso) REFERENCES cursos (cod_curso) ON DELETE RESTRICT,
	CONSTRAINT fk_id_estudiante_matriculas FOREIGN KEY (id_estudiante) REFERENCES estudiantes (id_estudiante) ON DELETE CASCADE,
	CONSTRAINT pk_id_matricula PRIMARY KEY (id_matricula),
	-- RESTRICCION ADICIONAL
	CONSTRAINT uq_curso_matric UNIQUE(id_matricula, cod_curso)
);

-- Pruebas de inserción:

-- Inserto una categoria 
INSERT INTO categorias (nombre_categoria,descripcion,activa) VALUES ('PROGRAMACION','Categoria de programacion','S');

-- Inserto un instructor
-- INSERT INTO instructores (email,nombre_completo,puntuacion_media,certificado) VALUES ('juan.perez@academia.com','Juan Pérez Sánchez',4.75,'S');
-- Comento esto para el que la modificacion del Ejercicio 12 funcione

-- Modificaciones avanzadas:

-- 11
-- Añado un nuevo campo a la tabla cursos
ALTER TABLE cursos ADD idioma VARCHAR(20) DEFAULT 'ESPAÑOL';

ALTER TABLE cursos ADD CONSTRAINT ck_idioma_cursos CHECK (idioma IN ('ESPAÑOL','INGLES','FRANCES','ALEMAN'));

-- 12
-- Modifico el campo biografia de la tabla instructores
ALTER TABLE instructores MODIFY biografia LONGTEXT NOT NULL;

-- 13
-- Añado un nuevo campo a la tabla matriculas
ALTER TABLE matriculas ADD descuento_aplicado DECIMAL(5,2);

ALTER TABLE matriculas ADD CONSTRAINT ck_descuento_aplicado_matriculas CHECK (descuento_aplicado>=0 AND descuento_aplicado<=100);

-- 14
-- Modifico la tabla instructores para eliminar la restriccion de puntuacion media
ALTER TABLE instructores DROP CONSTRAINT ck_puntuacion_media;

ALTER TABLE instructores ADD CONSTRAINT ck_puntuacion_media CHECK (puntuacion_media>=0 AND puntuacion_media<=10);

-- 15
-- Añado dos campos de fecha a la tabla cursos
ALTER TABLE cursos ADD fecha_inicio DATE, ADD fecha_fin DATE;

-- 16
-- Creo una restriccion el la tabla cursos para que la fecha fin sea posterior a la fecha inicio
ALTER TABLE cursos ADD CONSTRAINT ck_fechas_cursos CHECK (fecha_inicio>fecha_fin);

-- 17
-- Elimino el campo Linkedin de la tabla instructores
ALTER TABLE instructores DROP linkedin;

-- 18 
-- Añado una restriccion en la tabla matriculas
ALTER TABLE matriculas ADD CONSTRAINT ck_completado_progreso CHECK (completado='S' AND progreso=100);