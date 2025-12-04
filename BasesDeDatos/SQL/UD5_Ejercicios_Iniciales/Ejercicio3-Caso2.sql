-- Borramos la base de datos para hacer pruebas
DROP DATABASE IF EXISTS pacientes;

-- Creamos la base de datos
CREATE DATABASE pacientes;

-- Nos posicionamos en ella
USE pacientes;

-- Creamos la tabla enfermedad
CREATE TABLE enfermedad (
	id_enfermedad NUMERIC(6),
	nombre VARCHAR(20) UNIQUE NOT NULL,
	descripcion VARCHAR(50),
	t_recuperacion INTEGER,
	CONSTRAINT pk_id_enfermedad PRIMARY KEY (id_enfermedad)
);

-- Creamos la tabla paciente
CREATE TABLE paciente (
	id_paciente NUMERIC(6),
	nombre VARCHAR(25),
	apellidos VARCHAR(25),
	f_nacimiento DATE,
	poblacion VARCHAR(25),
	id_medico NUMERIC(6),
	CONSTRAINT pk_id_paciente PRIMARY KEY (id_paciente),
	CONSTRAINT fk_id_medico FOREIGN KEY (id_medico) REFERENCES paciente(id_paciente)
);

-- Creamos la tabla historial
CREATE TABLE historial (
	id_historial NUMERIC(6),
	grupo_sanguineo CHAR(2),
	id_paciente NUMERIC(6),
	CONSTRAINT fk_id_paciente_h FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente),
	CONSTRAINT pk_id_historial PRIMARY KEY (id_historial)
);

-- Creamos la tabla linea_historial
CREATE TABLE linea_historial (
	num_linea NUMERIC(6),
	id_historial NUMERIC(6),
	id_enfermedad NUMERIC(6) NOT NULL,
	f_inicio DATE,
	f_fin DATE,
	sintomas VARCHAR(50),
	observaciones VARCHAR(50),
	CONSTRAINT ck_fecha_fin_mayor_que_inicio CHECK (f_fin > f_inicio),
	CONSTRAINT pk_linea_historial PRIMARY KEY (num_linea,id_historial,id_enfermedad),
	CONSTRAINT fk_id_historial FOREIGN KEY (id_historial) REFERENCES historial (id_historial),
	CONSTRAINT fk_id_enfermedad_h FOREIGN KEY (id_enfermedad) REFERENCES enfermedad (id_enfermedad)
);

-- Creamos la tabla localizacion
CREATE TABLE localizacion (
	id_localizacion NUMERIC(6),
	cp NUMERIC(6),
	ciudad VARCHAR(20),
	riesgo VARCHAR(30) DEFAULT '1',
	CONSTRAINT pk_id_localizacion PRIMARY KEY (id_localizacion)
);

-- Creamos la tabla estancias_pacientes
CREATE TABLE estancias_pacientes (
	id_paciente NUMERIC(6),
	id_localizacion NUMERIC(6),
	f_entrada DATE,
	f_salida DATE,
	CONSTRAINT pk_id_paciente_id_localiz PRIMARY KEY (id_paciente,id_localizacion,f_entrada),
	CONSTRAINT fk_id_paciente FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente),
	CONSTRAINT fk_id_localizacion FOREIGN KEY (id_localizacion) REFERENCES localizacion (id_localizacion)
);