-- Borro la base de datos si existe

DROP DATABASE IF EXISTS BIBLIOTECA_DIGITAL;

-- Creo la base de datos 
CREATE DATABASE BIBLIOTECA_DIGITAL;

-- Uso la base de datos
USE BIBLIOTECA_DIGITAL;

-- Creo la tabla editoriales
CREATE TABLE editoriales(
	cif VARCHAR(12),
	nombre VARCHAR(80) UNIQUE NOT NULL,
	pais_origen VARCHAR(50),
	anio_fundacion INT(4),
	web VARCHAR(150),
	activa CHAR(1) DEFAULT 'S',
	CONSTRAINT ck_activa_editoriales CHECK (activa IN ('S','N')),
	CONSTRAINT ck_anio_fundacion_edit CHECK (anio_fundacion>=1800 AND anio_fundacion<=2026),
	CONSTRAINT ck_cif_editoriales CHECK (cif = UPPER(cif)),
	CONSTRAINT pk_cif_editoriales PRIMARY KEY (cif)
);

-- Creo la tabla autores
CREATE TABLE autores(
	id_autor INTEGER AUTO_INCREMENT,
	nombre_completo VARCHAR(100) NOT NULL,
	nacionalidad VARCHAR(50),
	fecha_nacimiento DATE,
	fecha_fallecimiento DATE,
	biografia LONGTEXT,
	premios VARCHAR(200),
	CONSTRAINT ck_fecha CHECK (fecha_fallecimiento is null or (fecha_fallecimiento>fecha_nacimiento)),
	CONSTRAINT pk_id_autor PRIMARY KEY (id_autor)
);

-- Creo la tabla libros
CREATE TABLE libros(
	isbn VARCHAR(17),
	titulo VARCHAR(150) NOT NULL,
	anio_publicacion INT(4),
	num_pagina INT,
	idioma VARCHAR(20),
	genero VARCHAR(30) NOT NULL,
	formato VARCHAR(15) DEFAULT 'DIGITAL',
	precio_compra DECIMAL(6,2),
	disponible CHAR(1) DEFAULT 'S',
	cif_editorial VARCHAR(12),
	CONSTRAINT fk_cif_editorial_libros FOREIGN KEY (cif_editorial) REFERENCES editoriales (cif),
	CONSTRAINT ck_disponible CHECK (disponible IN ('S','N')),
	CONSTRAINT ck_precio_compra CHECK (precio_compra>0),
	CONSTRAINT ck_formato_libros CHECK (formato IN ('DIGITAL','FISICO','AMBOS')),
	CONSTRAINT ck_idioma_libro CHECK (idioma IN ('ESPAÑOL','INGLES','FRANCES','ALEMAN','ITALIANO','PORTUGUES')),
	CONSTRAINT ck_num_pagina CHECK (num_pagina>0),
	CONSTRAINT ck_anio_pub CHECK (anio_publicacion>=1000 AND anio_publicacion<=2027),
	CONSTRAINT pk_isbn PRIMARY KEY (isbn)
);

-- Creo la tabla libros_autores

CREATE TABLE libros_autores(
	isbn_la VARCHAR(17),
	id_autor_la INTEGER,
	orden_autor_la INT DEFAULT 1,
	CONSTRAINT pk_libros_autores_isbn_idAutor PRIMARY KEY (isbn_la,id_autor_la),
	CONSTRAINT ck_orden_autor_la CHECK (orden_autor_la>0),
	CONSTRAINT fk_id_autor_la FOREIGN KEY (id_autor_la) REFERENCES autores (id_autor) ON DELETE CASCADE,
	CONSTRAINT fk_isbn_la FOREIGN KEY (isbn_la) REFERENCES libros (isbn) ON DELETE CASCADE
);

-- Creo la tabla socios

CREATE TABLE socios(
	num_socio INTEGER AUTO_INCREMENT,
	dni CHAR(10) UNIQUE NOT NULL,
	nombre VARCHAR(40) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	telefono CHAR(12),
	fecha_alta DATETIME DEFAULT NOW(),
	tipo_socio VARCHAR(15) DEFAULT 'BASICO',
	cuota_pagada CHAR(1) DEFAULT 'N',
	penalizaciones INTEGER DEFAULT 0,
	CONSTRAINT ck_penalizaciones_socios CHECK (penalizaciones>=0 AND penalizaciones<=10),
	CONSTRAINT ck_cuota_pagada CHECK (cuota_pagada IN ('S','N')),
	CONSTRAINT ck_tipo_socio_socios CHECK (tipo_socio IN ('BASICO','PREMIUM','VIP')),
	CONSTRAINT pk_num_socio PRIMARY KEY (num_socio)
);

-- Creo la tabla prestamos

CREATE TABLE prestamos(
	id_prestamo INTEGER AUTO_INCREMENT,
	num_socio INTEGER,
	isbn VARCHAR(17),
	CONSTRAINT fk_isbn_prestamos FOREIGN KEY (isbn) REFERENCES libros (isbn),
	CONSTRAINT fk_num_socio_prestamos FOREIGN KEY (num_socio) REFERENCES socios (num_socio),
	CONSTRAINT pk_id_prestamo PRIMARY KEY (id_prestamo)
);