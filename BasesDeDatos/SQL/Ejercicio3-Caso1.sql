-- Ejercicio 3
-- 

DROP DATABASE IF EXISTS logistica;
	
CREATE DATABASE logistica;

USE logistica;

CREATE TABLE proveedores (
	id_prov NUMERIC,
	nombre VARCHAR(30),
	telefono CHAR(9) UNIQUE,
	mail VARCHAR(20),
	CONSTRAINT pk_id_prov PRIMARY KEY (id_prov)
);

CREATE TABLE categorias (
	id_categoria CHAR(2),
	descripcion VARCHAR(50),
	CONSTRAINT pk_id_categoria PRIMARY KEY (id_categoria)
);

CREATE TABLE productos (
	numero_producto INTEGER,
	nombre VARCHAR(30),
	precio_venta DECIMAL,
	stock INTEGER,
	id_categoria CHAR(2),
	CONSTRAINT pk_numero_producto PRIMARY KEY (numero_producto),
	CONSTRAINT fk_id_categoria FOREIGN KEY (id_categoria) REFERENCES categorias (id_categoria)
);

CREATE TABLE productos_proveedores (
	id_prov NUMERIC,
	numero_producto INTEGER,
	CONSTRAINT pk_idprov_numeroproducto_prod_prov PRIMARY KEY (id_prov,numero_producto),
	CONSTRAINT fk_id_prov FOREIGN KEY (id_prov) REFERENCES proveedores (id_prov),
	CONSTRAINT fk_num_producto FOREIGN KEY (numero_producto) REFERENCES productos (numero_producto)
);

CREATE TABLE clientes (
	id_cliente CHAR(3),
	nombre VARCHAR(25),
	apellidos VARCHAR(25),
	direccion VARCHAR(30),
	telefono CHAR(9) UNIQUE,
	CONSTRAINT pk_id_cliente PRIMARY KEY (id_cliente)
);

CREATE TABLE empleados (
	id_empleado CHAR(3),
	nombre VARCHAR(30),
	apellidos VARCHAR(30),
	direccion VARCHAR(30),
	codigo_area CHAR(2),
	CONSTRAINT pk_id_empleado PRIMARY KEY (id_empleado)
);

CREATE TABLE pedidos (
	numero_pedido INTEGER,
	fecha_pedido DATE,
	id_cliente CHAR(3) NOT NULL,
	id_empleado CHAR(3) NOT NULL,
	CONSTRAINT pk_numero_pedido PRIMARY KEY (numero_pedido),
	CONSTRAINT fk_id_cliente FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente),
	CONSTRAINT fk_id_empleado FOREIGN KEY (id_empleado) REFERENCES empleados (id_empleado)
);

CREATE TABLE detalles_pedidos (
	numero_pedido INTEGER,
	numero_producto INTEGER,
	cantidad INTEGER,
	precio DECIMAL(10,2),
	CONSTRAINT pk_num_pedido_num_producto PRIMARY KEY (numero_pedido, numero_producto),
	CONSTRAINT fk_numero_pedido FOREIGN KEY (numero_pedido) REFERENCES pedidos (numero_pedido),
	CONSTRAINT fk_numero_producto FOREIGN KEY (numero_producto) REFERENCES productos (numero_producto),
	CONSTRAINT ck_cantidad_pedidos CHECK (cantidad>=1 AND cantidad<=100)
);