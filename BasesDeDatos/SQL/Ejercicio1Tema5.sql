-- Borramos la base de datos en caso de que exista

DROP DATABASE IF EXISTS terfrutos;

-- Creamos la base de datos
CREATE DATABASE terfrutos;

-- Usamos la base de datos
USE terfrutos;

-- Creamos una tabla con los campos que nos indican
CREATE TABLE tiendas(
	numero_tienda NUMERIC(2),
	direccion VARCHAR(100),
	cp_tienda VARCHAR(100),
	telefono VARCHAR(9),
	CONSTRAINT pk_tiendas_numero PRIMARY KEY(numero_tienda)
);

-- Creamos otra tabla con los campos que nos indican
CREATE TABLE vendedores(
	NIF VARCHAR(12),
	nombre VARCHAR(90),
	domicilio VARCHAR(100),
	cp_vendedor VARCHAR(5),
	ciudad VARCHAR(20),
	telefono VARCHAR(9),
	fecha_nacimiento DATE,
	estado_civil VARCHAR(100),
	numero_hijos SMALLINT,
	numero_tienda NUMERIC(2),
	CONSTRAINT pk_nif PRIMARY KEY (NIF),
	-- Si se borra una tienda el vendedor se queda sin tienda, por lo que hay que borrar el valor que tenga
	CONSTRAINT fk_numero_tienda_tiendas FOREIGN KEY (numero_tienda) REFERENCES tiendas(numero_tienda) ON DELETE SET NULL
);
-- Modificaciones de una tabla:

-- Alteramos la tabla para insertar un nuevo campo después de numero_hijos
ALTER TABLE vendedores ADD minusvalia ENUM('S','N') AFTER numero_hijos;

-- ALteramos la tabla para insertar un nuevo campo después de numero_tienda
ALTER TABLE vendedores ADD sueldo FLOAT AFTER numero_tienda;

-- Alteramos la tabla para modificar la longitud del estado civil
ALTER TABLE vendedores MODIFY estado_civil CHAR(1);