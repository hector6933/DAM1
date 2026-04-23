DROP DATABASE IF EXISTS ConcesionarioHector;

CREATE DATABASE ConcesionarioHector;

USE ConcesionarioHector;


CREATE TABLE usuario(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20) UNIQUE,
	passwd VARCHAR(100),
	rol VARCHAR(20),
	CONSTRAINT ck_rol_usuario CHECK (rol IN ('empleado','gerente','admin'))
);

CREATE TABLE departamento(
	numDep INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50)
);

CREATE TABLE cliente(
	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL,
	apellidos VARCHAR(50) NOT NULL,
	telefono NUMERIC(9) NOT NULL
);

CREATE TABLE empleado(
	numEmpleado INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL,
	apellidos VARCHAR(50) NOT NULL,
	telefono NUMERIC(9) NOT NULL,
	fechaNacimiento DATE,
	numGerente INT,
	numDep INT,
	id_usuario INT NOT NULL,
	CONSTRAINT fk_id_usuario_empleado FOREIGN KEY (id_usuario) REFERENCES usuario (id) ON DELETE CASCADE,
	CONSTRAINT fk_departamento_empleado FOREIGN KEY (numDep) REFERENCES departamento (numDep) ON DELETE SET NULL,
	CONSTRAINT fk_gerente_empleado FOREIGN KEY (NumGerente) REFERENCES empleado (NumEmpleado) ON DELETE SET NULL
);

CREATE TABLE vehiculo(
	matricula CHAR(8) PRIMARY KEY,
	marca VARCHAR(15) NOT NULL,
	modelo VARCHAR(15) NOT NULL,
	tipoCombustible VARCHAR(20),
	precio DOUBLE(10,2),
	dni_cliente CHAR(9),
	numEmpleado INT,
	CONSTRAINT fk_dni_cliente_vehiculo FOREIGN KEY (dni_cliente) REFERENCES cliente (dni) ON DELETE CASCADE,
	CONSTRAINT fk_empleado_vehiculo FOREIGN KEY (NumEmpleado) REFERENCES empleado (NumEmpleado) ON DELETE CASCADE
);

-- FALTA LA ISA DE VEHICULO DE COCHE MOTO Y CAMIÓN
INSERT INTO departamento (numDep, nombre) VALUES
(1, 'Ventas'),
(2, 'Marketing'),
(3, 'Finanzas'),
(4, 'Recursos Humanos'),
(5, 'IT');

INSERT INTO usuario (nombre, passwd, rol) VALUES
('carlos.ramirez', 'pass123', 'gerente'),
('pedro.herrera', 'pass123', 'gerente'),
('ana.lopez', 'pass123', 'empleado'),
('luis.martinez', 'pass123', 'empleado'),
('marta.gomez', 'pass123', 'empleado'),
('jorge.fernandez', 'pass123', 'empleado'),
('lucia.sanchez', 'pass123', 'empleado'),
('laura.diaz', 'pass123', 'empleado'),
('miguel.torres', 'pass123', 'empleado'),
('sara.ruiz', 'pass123', 'empleado'),
('david.morales', 'pass123', 'empleado'),
('pruebaBorrar', 'pass123', 'Admin'),
('hecprooll', 'admin123', 'Admin'),
('elena.navarro', 'pass123', 'empleado');

/*


-- GERENTES
INSERT INTO empleado (nombre, apellidos, telefono, fechaNacimiento, numGerente, numDep, id_usuario) VALUES
('Carlos', 'Ramirez', 600111111, '1980-05-12', NULL, 1, 1),
('Pedro', 'Herrera', 600777777, '1978-02-18', NULL, 2, 2);

-- EMPLEADOS
INSERT INTO empleado (nombre, apellidos, telefono, fechaNacimiento, numGerente, numDep, id_usuario) VALUES
('Ana', 'Lopez', 600222222, '1985-07-20', 1, 1, 3),
('Luis', 'Martinez', 600333333, '1990-03-15', 1, 2, 4),
('Marta', 'Gomez', 600444444, '1988-11-02', 1, 3, 5),
('Jorge', 'Fernandez', 600555555, '1992-01-25', 1, 1, 6),
('Lucia', 'Sanchez', 600666666, '1995-09-10', 2, 2, 7),
('Laura', 'Diaz', 600888888, '1993-06-30', 2, 2, 8),
('Miguel', 'Torres', 600999999, '1987-04-12', 2, 3, 9),
('Sara', 'Ruiz', 601000000, '1991-08-21', 1, 1, 10),
('David', 'Morales', 601111111, '1989-12-05', 2, 2, 11),
('Elena', 'Navarro', 601222222, '1994-10-17', 1, 3, 12);


INSERT INTO cliente (dni, nombre, apellidos, telefono) VALUES
('11111111A', 'Pedro', 'Hernandez', '611111111'),
('22222222B', 'Laura', 'Diaz', '622222222'),
('33333333C', 'Miguel', 'Torres', '633333333'),
('44444444D', 'Sara', 'Ruiz', '644444444'),
('55555555E', 'David', 'Morales', '655555555');

INSERT INTO vehiculo (matricula, marca, modelo, tipoCombustible, precio, dni_cliente, numEmpleado) VALUES

('1111-BBB', 'Toyota', 'Corolla', 'Gasolina', 18000, '11111111A', 2),
('2222-CCC', 'Ford', 'Focus', 'Diesel', 20000, '22222222B', 3),
('3333-DDD', 'Seat', 'Ibiza', 'Gasolina', 15000, '33333333C', 2),
('4444-FFF', 'BMW', 'X1', 'Diesel', 35000, '44444444D', 4),
('5555-GGG', 'Audi', 'A3', 'Gasolina', 30000, '55555555E', 5),
('6666-HHH', 'Kia', 'Sportage', 'Hibrido', 28000, '11111111A', 6),

('1234-BCD', 'Toyota', 'Corolla', 'Gasolina', 18000, '11111111A', 3),
('2345-DFG', 'Ford', 'Focus', 'Diesel', 20000, '22222222B', 4),
('3456-HJK', 'SEAT', 'Ibiza', 'Gasolina', 15000, '33333333C', 3),
('4567-LMN', 'BMW', 'X1', 'Diesel', 35000, '44444444D', 5),
('5678-PRS', 'Audi', 'A3', 'Gasolina', 30000, '55555555E', 6),
('6789-TVW', 'Kia', 'Sportage', 'Hibrido', 28000, '11111111A', 7),
('7890-XYZ', 'Hyundai', 'Tucson', 'Diesel', 27000, '22222222B', 8),
('8901-BCF', 'Volkswagen', 'Golf', 'Gasolina', 25000, '33333333C', 9),
('9012-DGH', 'Peugeot', '308', 'Diesel', 22000, '44444444D', 10),
('1123-JKL', 'Renault', 'Megane', 'Hibrido', 26000, '55555555E', 11);*/


-- INSERTS MASIVOS IA:

-- USUARIOS
SET @row := 0;

INSERT INTO usuario (nombre, passwd, rol)
SELECT 
    CONCAT('user', @row := @row + 1),
    'pass123',
    CASE 
        WHEN @row <= 20 THEN 'gerente'
        ELSE 'empleado'
    END
FROM 
    (SELECT 0 FROM dual LIMIT 200) t1,
    (SELECT 0 FROM dual LIMIT 200) t2
LIMIT 200;

-- EMPLEADOS:
SET @row := 0;

INSERT INTO empleado (nombre, apellidos, telefono, fechaNacimiento, numGerente, numDep, id_usuario)
SELECT 
    CONCAT('Nombre', @row := @row + 1),
    CONCAT('Apellido', @row),
    600000000 + @row,
    DATE_ADD('1980-01-01', INTERVAL @row DAY),
    CASE 
        WHEN @row <= 20 THEN NULL
        ELSE FLOOR(1 + RAND()*20)
    END,
    FLOOR(1 + RAND()*3),
    @row
FROM 
    (SELECT 0 FROM dual LIMIT 200) t1,
    (SELECT 0 FROM dual LIMIT 200) t2
LIMIT 200;

-- CLIENTES
SET @row := 0;

INSERT INTO cliente (dni, nombre, apellidos, telefono)
SELECT 
    CONCAT(LPAD(@row := @row + 1,8,'0'), CHAR(65 + (@row % 26))),
    CONCAT('Cliente', @row),
    CONCAT('Apellido', @row),
    610000000 + @row
FROM 
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 
     UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) t1,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 
     UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) t2,
    (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 
     UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) t3
LIMIT 200;

-- VEHÍCULOS
SET @row := 0;

INSERT INTO vehiculo (matricula, marca, modelo, tipoCombustible, precio, dni_cliente, numEmpleado)
SELECT
    CONCAT(
        LPAD(@row := @row + 1,4,'0'), '-',
        SUBSTRING('BCDFGHJKLMNPQRSTVWXYZ', FLOOR(1 + RAND()*21), 1),
        SUBSTRING('BCDFGHJKLMNPQRSTVWXYZ', FLOOR(1 + RAND()*21), 1),
        SUBSTRING('BCDFGHJKLMNPQRSTVWXYZ', FLOOR(1 + RAND()*21), 1)
    ),
    ELT(FLOOR(1 + RAND()*10), 
        'Toyota','Ford','BMW','Audi','Kia',
        'Hyundai','Seat','Renault','Peugeot','Volkswagen'),
    CONCAT('Modelo', @row),
    ELT(FLOOR(1 + RAND()*3), 'Gasolina','Diesel','Hibrido'),
    FLOOR(15000 + RAND()*20000),

    -- cliente válido
    (SELECT dni FROM cliente ORDER BY RAND() LIMIT 1),

    -- empleado válido 🔥
    (SELECT numEmpleado FROM empleado ORDER BY RAND() LIMIT 1)

FROM 
    (SELECT 0 FROM dual LIMIT 300) t1,
    (SELECT 0 FROM dual LIMIT 300) t2
LIMIT 300;

-- FIN IA