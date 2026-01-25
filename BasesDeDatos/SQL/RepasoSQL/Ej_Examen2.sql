-- Borro la base de datos en caso de que exista
DROP DATABASE IF EXISTS CONCESIONARIO;

-- Creo la base de datos
CREATE DATABASE CONCESIONARIO;

-- Me posiciono en la base de datos
USE CONCESIONARIO;

-- Creo la tabla persona con sus campos, claves y restricciones
CREATE TABLE persona(
    dni CHAR(9),
    nombre VARCHAR(25),
    dir VARCHAR(15),
    cod_postal INT(5),
    CONSTRAINT pk_dni_persona PRIMARY KEY (dni)
);

-- Creo la tabla vehiculo con sus campos, claves y restricciones
CREATE TABLE vehiculo(
    matricula CHAR(7),
    propietario CHAR(9),
    fecha_compra DATE,
    CONSTRAINT fK_propietario_vehiculo FOREIGN KEY (propietario) REFERENCES persona (dni) ON DELETE CASCADE,
    CONSTRAINT pk_matricula PRIMARY KEY (matricula)
);

-- Creo la tabla multa con sus campos, claves y restricciones
CREATE TABLE multa(
    vehiculo CHAR(7),
    propietario CHAR(9),
    fecha DATE,
    euros DECIMAL,
    CONSTRAINT fk_propietario_multa FOREIGN KEY (propietario) REFERENCES persona (dni) ON DELETE CASCADE,
    CONSTRAINT fk_vehiculo_multa FOREIGN KEY (vehiculo) REFERENCES vehiculo (matricula)
);

-- Añado una nueva restricción a la tabla persona
ALTER TABLE persona ADD CONSTRAINT ck_codigo_postal CHECK (cod_postal>=44000 AND cod_postal<=44999);

-- Añado una nueva restricción a la tabla multa
ALTER TABLE multa ADD CONSTRAINT ck_fecha_multa CHECK (fecha>"2010-01-01" AND fecha is not null);

-- Modifico el campo dir de la tabla persona para que permita más carácteres
ALTER TABLE persona MODIFY dir VARCHAR(50);

-- Añado una restricción a la tabla persona para comprobar que el nombre se introduce en mayúsculas
ALTER TABLE persona ADD CONSTRAINT ck_nombre_persona CHECK (nombre = UPPER(nombre));

-- Añado un campo sexo a la tabla persona y pongo una restricción para que solo tome unos valores en específico
ALTER TABLE persona ADD sexo CHAR(3);
ALTER TABLE persona ADD CONSTRAINT ck_sexo_persona CHECK (sexo IN ("M","F","SD"));

-- Borro el campo sexo de la tabla persona
ALTER TABLE persona DROP sexo;
