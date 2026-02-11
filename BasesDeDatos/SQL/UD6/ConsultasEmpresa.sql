-- CONSULTAS SIMPLES
-- 1:
SELECT NomDep FROM departamento;

-- 2:
SELECT NomDep, PreAnu FROM departamento;

-- 3:
SELECT * FROM departamento;

-- 4:
SELECT NomEmp, SalEmp FROM empleado;

-- 5:
SELECT DISTINCT NumHi FROM empleado;

-- 6:
SELECT NomEmp, (SalEmp * NumHi * 4/100) FROM empleado;

-- 7:
SELECT NomDep, PreAnu, PreAnu*1.19 FROM departamento;

-- 8:
SELECT NomDep AS 'Nombre de departamento', PreAnu AS 'Euros', PreAnu*1.19 AS 'Dólares' FROM departamento;

-- 9:
SELECT NomEmp, SalEmp FROM empleado WHERE SalEmp>3000000;

-- 10:
SELECT NomEmp, SalEmp, NumHi FROM empleado WHERE SalEmp>4000000 AND NumHi>=1;

-- 11:
SELECT NomDep, PreAnu FROM departamento WHERE PreAnu>=10000000 AND PreAnu<=20000000;

-- 12:
SELECT * FROM empleado WHERE CodDep IN (SELECT CodDep FROM departamento WHERE CodDep = 'PROZS' OR CodDep = 'VENZS');
SELECT * FROM empleado WHERE CodDep = 'PROZS' OR CodDep = 'VENZS';

-- 13:
SELECT * FROM departamento WHERE TiDir = 'F' OR PreAnu>20000000;

-- 14:
SELECT * FROM empleado WHERE 1970>YEAR(FecNaEmp) OR 1975<YEAR(FecNaEmp);

-- 15:
SELECT * FROM empleado WHERE (CodDep = 'PROZS' AND SalEmp>2000000) OR (CodDep = 'VENZS' AND NumHi>1);

-- 16:
SELECT * FROM departamento WHERE (CodCen = 'FAZS' AND PreAnu>10000000) OR (CodCen = 'OFZS' AND TiDir='P');

-- 17:
SELECT NomDep, PreAnu FROM departamento WHERE PreAnu NOT BETWEEN 10000000 AND 20000000;

-- 18:
SELECT NomDep FROM departamento WHERE NomDep LIKE '%Zona%';

-- 19:
SELECT NomEmp, SalEmp FROM empleado WHERE (NomEmp LIKE 'M%' OR NomEmp LIKE 'F%') AND SalEmp>3000000;

-- 20:
SELECT * FROM empleado WHERE (YEAR(FecNaEmp) BETWEEN 1970 AND 1979) AND (CodDep NOT LIKE 'PROZS') AND (NomEmp LIKE '%ar%' OR NomEmp LIKE '%o');

-- SUBCONSULTAS ---------------------
-- 1:
SELECT NomEmp, SalEmp FROM empleado WHERE SalEmp>(SELECT AVG(SalEmp) FROM empleado WHERE CodDep LIKE 'PROZS');

-- 2 (67):
SELECT NomEmp, SalEmp FROM empleado WHERE SalEmp>(SELECT AVG(SalEmp) FROM empleado WHERE CodDep IN (SELECT CodDep FROM departamento WHERE NomDep LIKE 'Investigación y Diseño'));

-- 3:
SELECT NomEmp, SalEmp FROM empleado emp WHERE SalEmp>(SELECT AVG(SalEmp) FROM empleado WHERE CodDep LIKE emp.CodDep);

-- 4:
SELECT NomDep FROM departamento WHERE PreAnu>(SELECT AVG(PreAnu) FROM departamento);

-- 5 POR HACER:
SELECT NomDep FROM departamento WHERE PreAnu>(SELECT AVG(SUM(SELECT PreAnu FROM departamento)));

SELECT * FROM departamento;















