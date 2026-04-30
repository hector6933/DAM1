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

SELECT e.*,h.* FROM empleado e INNER JOIN hijo h ON e.CodEmp = h.CodEmp;
SELECT e.*,h.* FROM empleado e LEFT JOIN hijo h ON e.CodEmp = h.CodEmp;
































































