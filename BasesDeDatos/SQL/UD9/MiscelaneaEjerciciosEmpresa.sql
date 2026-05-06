-- CONSULTAS CON OPERADORES DE CONJUNTO: UNION, INTERSECT, MINUS
-- 1:
SELECT CodEmpDir FROM departamento 
UNION 
SELECT CodEmpDir FROM centro;

-- 2:
SELECT CodEmpDir FROM departamento 
UNION ALL
SELECT CodEmpDir FROM centro;

-- 3:
SELECT CodDep, NomDep FROM departamento WHERE PreAnu > 20000000
UNION 
SELECT CodDep, NomDep FROM departamento WHERE TiDir LIKE 'F';

-- 4:
SELECT * FROM empleado WHERE CodEmp IN (SELECT CodEmpDir FROM departamento) 
INTERSECT 
SELECT * FROM empleado WHERE CodEmp IN (SELECT CodEmpDir FROM centro);

-- 5:
SELECT * FROM empleado WHERE CodEmp IN (SELECT CodEmpDir FROM departamento)
EXCEPT 
SELECT * FROM empleado WHERE CodEmp IN (SELECT CodEmpDir FROM centro);

-- 6:
SELECT DesHab FROM habilidad WHERE CodHab 
	IN (SELECT CodHab FROM habemp WHERE CodEmp IN (SELECT CodEmp FROM empleado WHERE CodDep LIKE 'PROZS'))
UNION
SELECT DesHab FROM habilidad WHERE CodHab 
	IN (SELECT CodHab FROM habemp WHERE CodEmp IN (SELECT CodEmp FROM empleado WHERE CodDep LIKE 'VENZS'));

-- 7:
SELECT DesHab FROM habilidad WHERE CodHab 
	IN (SELECT CodHab FROM habemp WHERE CodEmp IN (SELECT CodEmp FROM empleado WHERE CodDep LIKE 'PROZS'))
INTERSECT
SELECT DesHab FROM habilidad WHERE CodHab 
	IN (SELECT CodHab FROM habemp WHERE CodEmp IN (SELECT CodEmp FROM empleado WHERE CodDep LIKE 'VENZS'));

-- Manipulación de datos INSERT, UPDATE, DELETE
-- 1:
INSERT INTO centro VALUES ('CENZ',NULL,'Centro Norte','Calle Mayor 1','Zaragoza');

-- 2:
INSERT INTO departamento VALUES ('DEVZS',NULL,NULL,'CENZ','Desarrollo Software',18000000,'F');

-- 3:
INSERT INTO empleado (NomEmp,FecNaEmp,FecInEmp,SalEmp,NumHi,CodDep,ExTelEmp) 
VALUES ('García López, Ana','1990-03-15',CURDATE(),3200000,1,'DEVZS',NULL);

-- 4:
INSERT INTO habilidad VALUES ('PROYE','Gestión de Proyectos');
INSERT INTO habemp VALUES ('PROYE',(SELECT LAST_INSERT_ID(CodEmp) FROM empleado ORDER BY CodEmp DESC LIMIT 1), 3);

-- 5:
DROP TABLE emp_backup;
CREATE TABLE emp_backup LIKE empleado;
INSERT INTO emp_backup SELECT * FROM empleado WHERE CodDep LIKE 'PROZS';

-- 6:
INSERT INTO hijo VALUES ((SELECT CodEmp FROM empleado WHERE NomEmp LIKE 'García López, Ana'), 1,'2015-06-01','García Ruiz, Pablo');

-- 7:
INSERT INTO empleado (NomEmp,CodDep) VALUES ('Pepe','DEVZS'),('Lolo','DEVZS');

-- 8:
UPDATE empleado SET SalEmp = SalEmp * 1.05 WHERE CodDep LIKE 'PROZS';

-- 9:
UPDATE empleado SET SalEmp = SalEmp - 100000 WHERE NumHi = 0;

-- 10:
UPDATE departamento SET CodEmpDir = 
(SELECT CodEmp FROM empleado WHERE NomEmp LIKE 'García López, Ana') 
WHERE CodDep LIKE 'DEVZS';

-- 11:
UPDATE empleado 
SET SalEmp = SalEmp * 1.10 
WHERE SalEmp < (SELECT promedio FROM (SELECT AVG(SalEmp) AS promedio FROM empleado) AS coso);

-- 12:
UPDATE departamento SET PreAnu = PreAnu * 1.08 WHERE CodCen LIKE 'FAZS' 
AND PreAnu < 20000000;

-- 13:
UPDATE empleado SET ExTelEmp = '9999' 
WHERE CodDep IN (SELECT mayorPreAnu FROM (SELECT CodDep AS mayorPreAnu FROM departamento WHERE PreAnu = (SELECT MAX(PreAnu) FROM departamento)) AS cosa);

-- 14:
UPDATE empleado SET SalEmp = SalEmp * 1.03
WHERE CodDep IN (SELECT depart FROM (SELECT CodDep AS depart FROM departamento WHERE CodDep IN (SELECT CodDep FROM empleado WHERE NumHi > 1) ) AS cosa);

-- 15:
UPDATE empleado e LEFT JOIN hijo h ON e.CodEmp = h.CodEmp 
SET NumHi = (SELECT recuento FROM (SELECT COUNT(*) AS recuento FROM hijo WHERE CodEmp = e.CodEmp) AS cosa);

UPDATE empleado e
SET NumHi = (SELECT recuento FROM (SELECT COUNT(*) AS recuento FROM hijo WHERE CodEmp = e.CodEmp) AS cosa);

-- 16:
DELETE FROM habemp WHERE CodHab LIKE 'PROYE';

-- 17:
DELETE FROM habilidad WHERE CodHab LIKE 'PROYE';

-- 18:
DELETE FROM hijo WHERE CodEmp NOT IN (SELECT CodEmp FROM empleado);

-- 19:
DELETE FROM habemp WHERE CodEmp IN (SELECT CodEmp FROM empleado WHERE CodDep LIKE 'DEVZS');
DELETE FROM hijo WHERE CodEmp IN (SELECT CodEmp FROM empleado WHERE CodDep LIKE 'DEVZS');
UPDATE departamento SET CodEmpDir = NULL WHERE CodDep LIKE 'DEVZS';
DELETE FROM empleado WHERE CodDep LIKE 'DEVZS';

-- 20:
DELETE FROM habemp WHERE CodEmp IN (SELECT CodEmp FROM empleado e WHERE SalEmp < (
									SELECT AVG(SalEmp) FROM empleado WHERE CodDep = e.CodDep));

-- 21:
DELETE FROM departamento WHERE CodDep LIKE 'DEVZS';
DELETE FROM centro WHERE CodCen LIKE 'CENZ';

-- VISTAS 
-- 1:
DROP VIEW v_empleados_sobre_media;
CREATE VIEW v_empleados_sobre_media AS 
	SELECT NomEmp, SalEmp, CodDep FROM empleado WHERE SalEmp > (SELECT AVG(SalEmp) FROM empleado);

SELECT * FROM v_empleados_sobre_media;

-- 2:
DROP VIEW v_dep_sin_empleados;
CREATE VIEW v_dep_sin_empleados AS 
	SELECT CodDep, NomDep FROM departamento p WHERE NOT EXISTS (SELECT 1 FROM empleado WHERE CodDep = p.CodDep);

SELECT * FROM v_dep_sin_empleados;

-- 3:
DROP VIEW v_centros_presupuesto;
CREATE VIEW v_centros_presupuesto AS
	SELECT c.CodCen, c.NomCen, SUM(d.PreAnu) FROM centro c INNER JOIN departamento d ON c.CodCen = d.CodCen GROUP BY c.CodCen;

SELECT * FROM v_centros_presupuesto;

-- 4:
DROP VIEW v_directorio;
CREATE VIEW v_directorio AS
	SELECT e.NomEmp, d.NomDep, c.NomCen, e.SalEmp, e.NumHi 
		FROM empleado e INNER JOIN departamento d ON e.CodDep=d.CodDep INNER JOIN centro c ON d.CodCen=c.CodCen;

SELECT * FROM v_directorio;

-- 5:
DROP VIEW v_emp_habilidades;
CREATE VIEW v_emp_habilidades AS
	SELECT e.NomEmp, h.DesHab, he.NivHab 
		FROM empleado e INNER JOIN habemp he ON e.CodEmp=he.CodEmp INNER JOIN habilidad h ON he.CodHab=h.CodHab;

SELECT * FROM v_emp_habilidades;

-- 6:
DROP VIEW v_resumen_dep;
CREATE VIEW v_resumen_dep AS
	SELECT d.NomDep, c.NomCen, (SELECT NomEmp FROM empleado WHERE CodEmp=d.CodEmpDir) AS 'Director', COUNT(e.CodEmp), MIN(e.SalEmp), MAX(e.SalEmp)
		FROM empleado e INNER JOIN departamento d ON e.CodDep=d.CodDep 
			INNER JOIN centro c ON d.CodCen=c.CodCen GROUP BY d.CodDep;

SELECT * FROM v_resumen_dep;

-- 7:
DROP VIEW v_emp_hijos;
CREATE VIEW v_emp_hijos AS
	SELECT NomEmp, NomHi, FecNaHi 
		FROM empleado e NATURAL LEFT JOIN hijo h;

SELECT * FROM v_emp_hijos;

-- 8:
DROP VIEW v_top_sal_centro;
CREATE VIEW v_top_sal_centro AS
	SELECT c.NomCen, 
		(SELECT NomEmp FROM empleado WHERE SalEmp = (SELECT MAX(SalEmp) FROM empleado WHERE CodDep IN (SELECT CodDep FROM departamento WHERE CodCen=c.CodCen))) AS 'Empleado mejor pagado'
		FROM empleado e INNER JOIN departamento d ON e.CodDep=d.CodDep 
			INNER JOIN centro c ON d.CodCen=c.CodCen GROUP BY c.CodCen;
SELECT * FROM v_top_sal_centro;

-- 9:
DROP VIEW v_habilidades_populares;
CREATE VIEW v_habilidades_populares AS
	SELECT DesHab, COUNT(he.CodEmp)
		FROM habilidad h NATURAL JOIN habemp he GROUP BY CodHab HAVING COUNT(he.CodEmp) >= 2;
SELECT * FROM v_habilidades_populares;







































































