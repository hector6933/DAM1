-- Creación de una base de datos
CREATE DATABASE prueba;

-- Nos posicionamos
USE prueba;

-- Creación de una tabla
CREATE TABLE uno (
	a int PRIMARY KEY,
	b int,
	c VARCHAR(20)
);

CREATE TABLE dos (
	e int PRIMARY KEY,
	f int,
	a int,
	CONSTRAINT pk_dos_e_f PRIMARY KEY (e,f),
	CONSTRAINT fk_dos_a FOREIGN KEY (a) REFERENCES uno(a) ON DELETE CASCADE
);

