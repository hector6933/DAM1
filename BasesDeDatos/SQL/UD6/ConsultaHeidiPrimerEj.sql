SELECT * FROM investigadores ORDER BY facultad DESC;

SELECT nombre AS NomInvestigador,apellidos AS ApellInvestigador,dni AS DNI FROM investigadores ORDER BY apellidos;

SELECT * FROM facultades WHERE NomFacultad LIKE '%Ciencias%';

SELECT * FROM equipos WHERE IdFacultad=2;

SELECT * FROM equipos WHERE IdEquipo LIKE 'H%';

SELECT * FROM equipos WHERE IdEquipo NOT LIKE 'H%';

SELECT * FROM investigadores WHERE facultad=2 OR facultad=4;

-- SELECT * FROM reservas WHERE FInicio LIKE '2024-11-%';
SELECT * FROM reservas WHERE FInicio>='2024-11-01' AND FInicio<='2024-11-30';

SELECT * FROM investigadores WHERE apellidos LIKE '%O%Z' ORDER BY apellidos;

SELECT nombre,apellidos FROM investigadores WHERE beca>8000;

SELECT DNI FROM reservas WHERE FInicio LIKE '%-09-%';

SELECT DNI,beca,beca * 1.05 AS Nueva_cuantia FROM investigadores ORDER BY Nueva_cuantia DESC;

SELECT Descripcion FROM equipos WHERE IdEquipo='H555';

-- SUBCONSULTAS

SELECT nombre,facultad FROM investigadores WHERE facultad = ANY (SELECT IdFacultad FROM facultades WHERE IdFacultad=1);

SELECT * FROM reservas WHERE IdEquipo = ALL (SELECT IdEquipo FROM equipos WHERE Descripcion='Telemetro Laser SICK');

SELECT * FROM reservas WHERE DNI = ANY (SELECT DNI FROM investigadores WHERE facultad = ANY (SELECT IdFacultad FROM facultades WHERE NomFacultad='Ciencias Geologicas'));

SELECT * FROM reservas WHERE DNI = ANY (SELECT DNI FROM investigadores WHERE beca>=2000 AND beca<=6000 AND facultad = ANY (SELECT IdFacultad FROM facultades WHERE NomFacultad='Ciencias Geologicas'));

SELECT * FROM reservas WHERE DNI = ANY (SELECT DNI FROM investigadores WHERE facultad = ANY (SELECT IdFacultad FROM facultades WHERE NomFacultad='Ciencias Geologicas') AND DNI = ANY (SELECT DNI FROM reservas WHERE IdEquipo = 'H222'));

SELECT * FROM reservas WHERE DNI = ANY (SELECT DNI FROM investigadores WHERE facultad = ANY (SELECT IdFacultad FROM facultades WHERE NomFacultad='Ciencias Geologicas') AND DNI = ANY (SELECT DNI FROM reservas WHERE IdEquipo = ANY (SELECT IdEquipo FROM equipos WHERE IdFacultad = ANY (SELECT IdFacultad FROM facultades WHERE NomFacultad='Ciencias Quimicas'))));

-- PROBATINAS
-- --------------------------
SELECT * FROM equipos;
SELECT * FROM facultades;
SELECT * FROM investigadores;
SELECT * FROM reservas;

SELECT * FROM equipos;
SELECT * FROM equipos;
-- --------------------------

-- MULTITABLAS

