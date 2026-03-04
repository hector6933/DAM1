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
FROM empleado WHERE CodEmp = (SELECT CodEmp 
FROM departamento WHERE CodCen = (SELECT CodCen FROM centro WHERE PobCen LIKE 'Murcia'));

SELECT * FROM departamento;
SELECT * FROM empleado;
SELECT * FROM centro;







