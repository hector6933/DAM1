-- 1:
SELECT UPPER(NomDep), PreAnu FROM departamento;

-- 2:
SELECT LOWER(NomEmp), SalEmp FROM empleado;

-- 3:
SELECT NomEmp, UPPER(SUBSTRING(CodDep, 1, 2)) AS 'Departamento' FROM empleado;

-- 4:
SELECT CodEmp, CodDep, CONCAT(CodEmp,' ',CodDep,' ',IFNULL(ExTelEmp,'XXX')) AS 'Codigo Compuesto' FROM empleado;

-- 5:
SELECT SUBSTRING(NomEmp, LOCATE(',',NomEmp) + 2) AS 'Nombre', SUBSTRING(NomEmp, 1,LOCATE(',',NomEmp)-1)  AS 'Apellidos' FROM empleado;

-- 6:
SELECT NomEmp, SalEmp, ROUND(SalEmp * 1.12,2) AS 'Salario 12%' FROM empleado;

-- 7:
SELECT NomEmp, SalEmp, TRUNCATE(SalEmp * 1.12,1) AS 'Salario 12%' FROM empleado;

-- 8:
SELECT NomEmp, 
CASE 
	WHEN NumHi = 0 THEN 'No tiene hijos' 
	WHEN NumHi = 1 THEN 'Ordinaria' 
	WHEN NumHi = 2 THEN 'Semi Numerosa' 
	WHEN NumHi >= 3 THEN 'Numerosa' 
	END AS 'Tipo familia' 
FROM empleado;

-- 9:
SELECT NomEmp, EXTRACT(DAY FROM FecNaEmp) AS 'Dia' , EXTRACT(MONTH FROM FecNaEmp) AS 'Mes' , EXTRACT(YEAR FROM FecNaEmp) AS 'Año' FROM empleado;

-- 10:
SELECT SUBSTRING(NomEmp, LOCATE(',',NomEmp) + 2) AS 'Nombre', FecNaEmp, TIMESTAMPDIFF(YEAR, FecNaEmp, CURDATE()) FROM empleado;

-- 11:
SELECT SUBSTRING(NomEmp, LOCATE(',',NomEmp) + 2) AS 'Nombre', FecInEmp, FLOOR(TIMESTAMPDIFF(YEAR, FecNaEmp, CURDATE()) / 4) FROM empleado;

-- 12:
SELECT NomDep, CONCAT(CodDep,' ', FLOOR(10 + (RAND() * 90)),' ',CodCen) FROM departamento;

-- CONSULTAS AGRUPACIÓN
-- 1:
SELECT COUNT(*) FROM empleado WHERE NumHi = 2 GROUP BY NumHi;

-- 2:
SELECT COUNT(*) FROM empleado WHERE ExTelEmp IS NULL GROUP BY ExTelEmp;

-- 3:
SELECT AVG(TIMESTAMPDIFF(YEAR, FecNaEmp, CURDATE())) AS 'Edad Media' FROM empleado;

-- 4:
SELECT AVG(TIMESTAMPDIFF(YEAR, FecNaEmp, CURDATE())) AS 'Edad Media' 
FROM empleado WHERE CodEmp != ALL (SELECT CodEmpDir FROM departamento) AND CodEmp != ALL (SELECT CodEmpDir FROM centro);

-- 5:
SELECT AVG(TIMESTAMPDIFF(YEAR, FecNaEmp, CURDATE())) 
FROM empleado emp WHERE CodDep = ANY (SELECT CodDep 
FROM departamento WHERE CodCen = (SELECT CodCen FROM centro WHERE PobCen LIKE 'Murcia'));

-- 6:
SELECT SUM(PreAnu) FROM departamento WHERE CodCen IN (SELECT CodCen FROM centro WHERE PobCen LIKE 'Cartagena');

-- 7:
SELECT COUNT(*) FROM empleado WHERE CodEmp IN (SELECT CodEmp FROM habemp);

-- 8:
SELECT COUNT(*) FROM empleado WHERE CodEmp NOT IN (SELECT CodEmp FROM habemp);

-- 9:
SELECT CodDep, NomDep, MAX(e.SalEmp) AS 'Salario máximo', MIN(e.SalEmp) AS 'Salario mínimo', AVG(e.SalEmp) AS 'Salario medio' FROM departamento dep NATURAL JOIN empleado e GROUP BY dep.CodDep;

-- 10:
SELECT CodEmp, NomEmp, COUNT(*) AS 'Habilidades' FROM empleado emp NATURAL JOIN habemp hemp GROUP BY emp.CodEmp;

-- 11:
SELECT CodDep, NomDep, COUNT(*) AS 'Número de habilidades' FROM departamento dep NATURAL LEFT JOIN empleado emp NATURAL RIGHT JOIN habemp hemp GROUP BY dep.CodDep;

-- 12:
SELECT cen.CodCen, cen.NomCen, COUNT(*) FROM 
centro cen LEFT JOIN departamento dep ON cen.CodCen=dep.CodCen
NATURAL LEFT JOIN empleado emp NATURAL RIGHT JOIN habemp hemp 
GROUP BY cen.CodCen;

-- 13:
SELECT dep.CodDep, dep.NomDep, cen.CodCen, cen.NomCen, COUNT(*) FROM centro cen LEFT JOIN departamento dep ON dep.CodCen=cen.CodCen NATURAL LEFT JOIN empleado emp NATURAL RIGHT JOIN habemp hemp GROUP BY dep.CodDep;

-- 14:
SELECT cen.NomCen, AVG(dep.PreAnu) FROM centro cen LEFT JOIN departamento dep ON cen.CodCen=dep.CodCen WHERE dep.PreAnu > 25000000 GROUP BY cen.CodCen ORDER BY AVG(dep.PreAnu) DESC;

-- 15:
SELECT cen.PobCen, SUM(emp.SalEmp) AS 'Total Salarios' FROM centro cen LEFT JOIN departamento dep ON cen.CodCen=dep.CodCen NATURAL LEFT JOIN empleado emp GROUP BY cen.PobCen;

-- 16:
SELECT dep.NomDep, (SELECT COUNT(*) FROM empleado emp WHERE dep.CodDep=emp.CodDep) AS 'Numero empleados' FROM departamento dep WHERE (SELECT COUNT(*) FROM empleado emp WHERE dep.CodDep=emp.CodDep) > 3;

-- 17:
SELECT cen.NomCen, (SELECT COUNT(*) FROM empleado NATURAL LEFT JOIN departamento dep WHERE dep.CodCen=cen.CodCen) FROM centro cen WHERE (SELECT COUNT(*) FROM empleado NATURAL LEFT JOIN departamento dep WHERE dep.CodCen=cen.CodCen) > 3;

-- 18:

-- 20:
SELECT c.* FROM 
centro c INNER JOIN departamento d ON d.CodCen = c.CodCen 
INNER JOIN empleado e ON e.CodDep = d.CodDep GROUP BY c.CodCen 
HAVING AVG(DATEDIFF(NOW(),e.FecInEmp)/365) > 10;

SELECT * FROM centro;
SELECT * FROM departamento;
SELECT DATEDIFF(NOW(),FecNaEmp)/365 FROM empleado;
SELECT * FROM habemp;







