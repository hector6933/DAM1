-- Borro la base de datos si existe
DROP DATABASE IF EXISTS RESTAURANTE;

-- Creo la base de datos
CREATE DATABASE RESTAURANTE;

-- Uso la base de datos
USE RESTAURANTE;

-- Creo la tabla categoria con todos sus campos, claves y restricciones
CREATE TABLE categoria(
    cod_categoria CHAR(2),
    nombre_cat VARCHAR (20),
    encargado VARCHAR(20),
    CONSTRAINT ck_nombre_cat CHECK (nombre_cat IN ("postre","primero","segundo","Sin determinar")),
    CONSTRAINT uq_nombre_cat UNIQUE (nombre_cat),
    CONSTRAINT pk_cod_categoria PRIMARY KEY (cod_categoria)
);

-- Creo la tabla plato con todos sus campos, claves y restricciones
CREATE TABLE plato(
    cod_plato VARCHAR(5),
    nombre_plato VARCHAR(35),
    descripcion LONGTEXT,
    nivel VARCHAR(4),
    precio DECIMAL,
    categoria VARCHAR(20) DEFAULT "Sin determinar",
    CONSTRAINT ck_nombre_plato CHECK (nombre_plato is not null AND nombre_plato = UPPER(nombre_plato)),
    CONSTRAINT ck_nivel_plato CHECK (nivel<=4),
    CONSTRAINT ck_precio_plato CHECK (precio >= 8 AND precio <= 50),
    CONSTRAINT pk_cod_plato PRIMARY KEY (cod_plato),
    CONSTRAINT fk_nom_categoria FOREIGN KEY (categoria) REFERENCES categoria (nombre_cat) ON DELETE SET DEFAULT
);

-- Creo la tabla ingredientes con todos sus campos, claves y restricciones
CREATE TABLE ingredientes(
    codigo_ingr VARCHAR(4),
    nombre VARCHAR(15),
    unidades VARCHAR(15),
    almacen INTEGER,
    CONSTRAINT ck_nombre_ingr CHECK (nombre is not null),
    CONSTRAINT uk_nombre_ingr UNIQUE (nombre),
    CONSTRAINT pk_codigo_ingr PRIMARY KEY (codigo_ingr)
);

-- Creo la tabla utiliza con todos sus campos, claves y restricciones
CREATE TABLE utiliza(
    codigo_ingrediente VARCHAR(4),
    codigo_plato VARCHAR(5),
    cantidad INTEGER,
    CONSTRAINT fk_codigo_plato FOREIGN KEY (codigo_plato) REFERENCES plato (cod_plato) ON DELETE CASCADE,
    CONSTRAINT fk_codigo_ingr FOREIGN KEY (codigo_ingrediente) REFERENCES ingredientes (codigo_ingr) ON DELETE CASCADE,
    CONSTRAINT pk_utiliza_cod_plato_cod_ingr PRIMARY KEY (codigo_plato,codigo_ingrediente)
);

-- Creo la tabla cocinero con todos sus campos, claves y restricciones
CREATE TABLE cocinero(
    id_cocinero INTEGER AUTO_INCREMENT,
    nombre VARCHAR(20),
    fecha_contrato DATE,
    CONSTRAINT pk_id_cocinero PRIMARY KEY (id_cocinero)
);

-- Modificaciones de la tabla plato:
-- Añado el campo de ID de cocinero que es una clave ajena de la tabla cocinero
ALTER TABLE plato ADD id_cocinero INTEGER;
ALTER TABLE plato ADD CONSTRAINT fk_cocinero_plato FOREIGN KEY (id_cocinero) REFERENCES cocinero (id_cocinero);

-- Añado un campo de fecha
ALTER TABLE plato ADD fecha_creacion DATETIME DEFAULT NOW();

-- Modificaciones de la tabla cocinero
-- Añado un campo sexo con una restriccion indicando los únicos valores que puede tomar
ALTER TABLE cocinero ADD sexo VARCHAR(3);
ALTER TABLE cocinero ADD CONSTRAINT ck_sexo_cocinero CHECK (sexo IN ("M","F","MD"));

-- Modifico el campo nombre de la tabla ingredientes
ALTER TABLE ingredientes MODIFY nombre VARCHAR(50);

-- Borro el campo nivel de la tabla plato
ALTER TABLE plato DROP nivel;


