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
	fecha_prestamo DATETIME DEFAULT NOW(),
	fecha_devolucion_prevista DATE NOT NULL,
	fecha_devolucion_real DATE,
	estado VARCHAR(20) DEFAULT 'EN_PRESTAMO',
	renovaciones INTEGER DEFAULT 0,
	CONSTRAINT ck_fechas_prestamos CHECK (fecha_devolucion_prevista>fecha_devolucion_real),
	CONSTRAINT ck_renovaciones_prestamos CHECK (renovaciones>=0 AND renovaciones<=3),
	CONSTRAINT ck_estado_prestamos CHECK (estado IN ('EN_PRESTAMO','DEVUELTO','RETRASADO','PERDIDO')),
	CONSTRAINT fk_isbn_prestamos FOREIGN KEY (isbn) REFERENCES libros (isbn) ON DELETE RESTRICT,
	CONSTRAINT fk_num_socio_prestamos FOREIGN KEY (num_socio) REFERENCES socios (num_socio) ON DELETE RESTRICT,
	CONSTRAINT pk_id_prestamo PRIMARY KEY (id_prestamo)
);

-- Inserto una editorial
INSERT INTO editoriales (cif,nombre,pais_origen,anio_fundacion) VALUES ('A12345678','Editorial Planeta','España',1949);

-- Inserto un autor
INSERT INTO autores (nombre_completo,nacionalidad,fecha_nacimiento,fecha_fallecimiento) VALUES ('abriel García Márquez','Colombia','1927-03-06','2014-04-17');

-- Intento insertar un libros
INSERT INTO libros (isbn,titulo,anio_publicacion,num_pagina,idioma,genero,cif_editorial) VALUES ('978-84-08-12345-6','Cien años de soledad',1967,500,'ESPAÑOL','POESIA','A12345678');
-- Da un error si pongo que el año es mayor al año actual

-- Inserto un socios
INSERT INTO socios (dni,nombre,apellidos,email,tipo_socio,cuota_pagada) VALUES ('11223344B','Ana','Martínez González','ana.martinez@email.com','PREMIUM','S');
INSERT INTO socios (dni,nombre,apellidos,email,tipo_socio,cuota_pagada) VALUES ('sdad213','Ana','Martínez González','ana.ma211rtinez@email.com','VIP','S');

-- Intento insertar un prestamo con fecha de devolucion prevista anterior a la fecha de prestamo
-- INSERT INTO prestamos (fecha_devolucion_real,fecha_devolucion_prevista) VALUES ('2020-04-17','2013-04-17');
-- Evidentemente da error, ya que me contradigo con la restricción

-- Añado un campo sinopsis
ALTER TABLE libros ADD sinopsis LONGTEXT;

-- Modifico el campo genero de la tabla libros
ALTER TABLE libros ADD CONSTRAINT ck_genero_libros CHECK (genero IN('NOVELA','ENSAYO','POESIA','CIENCIA','HISTORIA','BIOGRAFIA','INFANTIL'));

-- Añado un nuevo campo a libros y le meto su restricción correspondiente
ALTER TABLE libros ADD valoracion_media DECIMAL(4,2);
ALTER TABLE libros ADD CONSTRAINT ck_valoracion_media_libros CHECK (valoracion_media>=0 AND valoracion_media<=5);

-- Elimino la restricción de la tabla socios y la creo de nuevo pero con distintos parámetros
ALTER TABLE socios DROP CONSTRAINT ck_penalizaciones_socios;
ALTER TABLE socios ADD CONSTRAINT ck_penalizaciones_socios CHECK (penalizaciones>=0 AND penalizaciones<=20);

-- Añado un campo en la tabla prestamos
ALTER TABLE prestamos ADD observaciones VARCHAR(300);

-- Modifico la restricción de la tabla socios para que permita un nuevo valoracion_media
ALTER TABLE socios DROP CONSTRAINT ck_tipo_socio_socios;
ALTER TABLE socios ADD CONSTRAINT ck_tipo_socio_socios CHECK (tipo_socio IN ('BASICO','PREMIUM','VIP','CORPORTAIVO'));

-- Elimino el campo web de la tabla editoriales
ALTER TABLE editoriales DROP web;

-- Añado una nueva restricción a la tabla préstamos
ALTER TABLE prestamos ADD CONSTRAINT ck_socio_prestamos UNIQUE (id_prestamo,num_socio,isbn);

-- Creo un nuevo campo en la tabla Socios 
ALTER TABLE socios ADD descuento_socio INTEGER;
ALTER TABLE socios ADD CONSTRAINT ck_descuento_socio CHECK (descuento_socio>=0 AND descuento_socio<=50);

-- Añado una restricción a la tabla socios 
ALTER TABLE socios ADD CONSTRAINT ck_tipo_socio_cuota CHECK ((tipo_socio<>'VIP') OR (tipo_socio='VIP' AND cuota_pagada='S'));


