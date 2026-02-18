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

-- 2 ( 67 ):
SELECT NomEmp, SalEmp FROM empleado WHERE SalEmp>(SELECT AVG(SalEmp) FROM empleado WHERE CodDep IN (SELECT CodDep FROM departamento WHERE NomDep LIKE 'Investigación y Diseño'));

-- 3:
-- Yo:
SELECT NomEmp, SalEmp FROM empleado emp WHERE SalEmp>(SELECT AVG(SalEmp) FROM empleado WHERE CodDep LIKE emp.CodDep);

-- Celia:
SELECT NomEmp, SalEmp FROM empleado e1
WHERE SalEmp > (SELECT AVG(SalEmp) FROM empleado e2
						WHERE e2.CodDep=e1.CodDep);

-- 4:
SELECT NomDep FROM departamento WHERE PreAnu>(SELECT AVG(PreAnu) FROM departamento);

-- 5 ( 76 ):
-- Yo (Mal):
SELECT NomDep FROM departamento dep WHERE PreAnu>(SELECT AVG(PreAnu) FROM departamento WHERE CodCen=dep.CodCen);
-- Celia:
SELECT NomDep
FROM departamento
WHERE PreAnu > (SELECT AVG(PresuCentro)
					FROM (SELECT SUM(PreAnu) AS PresuCentro
						FROM departamento
						GROUP BY CodCen) AS PresuCentro
					);
					
SELECT * FROM departamento;

-- De otra manera, me creao la tabla primero para luego usarla en la subconsulta
-- CTE (Common Table Expression)
WITH PresuCentro AS 
(SELECT SUM(PreAnu) AS SumaPresupuesto FROM departamento
	GROUP BY CodCen)
SELECT NomDep
FROM departamento
WHERE PreAnu > (SELECT AVG(SumaPresupuesto) FROM PresuCentro);

-- 6:
SELECT CodHab, DesHab FROM habilidad WHERE CodHab NOT IN (SELECT CodHab FROM habemp);

-- 7:
SELECT NomEmp, SalEmp FROM empleado ORDER BY SalEmp DESC LIMIT 1;

-- 8:
SELECT NomEmp, SalEmp FROM empleado WHERE SalEmp = (SELECT MAX(SalEmp) FROM empleado);

-- 9:
SELECT * FROM empleado WHERE SalEmp > ANY (SELECT SalEmp FROM empleado WHERE CodDep LIKE 'JEFZS');

-- 10:
SELECT * FROM empleado WHERE SalEmp > ALL (SELECT SalEmp FROM empleado WHERE CodDep LIKE 'VENZS');

-- 11:
SELECT * FROM centro WHERE CodCen = ANY (SELECT CodCen FROM departamento WHERE PreAnu>=20000000);

-- 12:
SELECT * FROM departamento WHERE CodDep NOT IN (SELECT CodDep FROM empleado);

-- 13
SELECT * FROM departamento WHERE NOT EXISTS (SELECT CodDep FROM empleado);

-- 14:
SELECT * FROM centro cen WHERE 20000000 > ALL (SELECT PreAnu FROM departamento WHERE CodCen=cen.CodCen);

-- 15:
SELECT * FROM empleado emp WHERE CodDep IN (SELECT CodDep FROM empleado emp2 WHERE emp2.SalEmp>2000000 AND emp.CodEmp!=emp2.CodEmp);

-- 16:
-- SIN EXISTS:
SELECT * FROM empleado WHERE FecInEmp >= ALL (SELECT FecInEmp FROM empleado);

SELECT * FROM empleado emp WHERE NOT EXISTS (SELECT FecInEmp FROM empleado WHERE FecInEmp>emp.FecInEmp);

-- 17:
SELECT * FROM centro cen WHERE CodCen IN (SELECT CodCen FROM departamento WHERE PreAnu>=1000000);

-- 18:
SELECT * FROM departamento dep WHERE EXISTS (SELECT CodDep FROM empleado emp WHERE dep.CodDep=emp.CodDep AND SalEmp > 4000000);

-- 19:
SELECT * FROM empleado emp WHERE NumHi > (SELECT AVG(NumHi) FROM empleado WHERE CodDep=emp.CodDep);

-- 20:
SELECT * FROM empleado emp WHERE SalEmp = (SELECT MAX(SalEmp) FROM empleado WHERE CodDep=emp.CodDep);

-- 21:
SELECT * FROM departamento dep WHERE PreAnu > ALL (SELECT PreAnu FROM departamento WHERE dep.CodCen!=CodCen);

-- MULTITABLAS ----------------------------------------------------------------------------------------------------------

-- 1:
SELECT NomDep, PreAnu, cen.NomCen FROM departamento dep LEFT JOIN centro cen ON dep.CodCen=cen.CodCen;

-- 2:
SELECT NomDep, PreAnu, emp.NomEmp FROM departamento dep LEFT JOIN empleado emp ON dep.CodEmpDir=emp.CodEmp;

-- 3:
SELECT NomDep, PreAnu, cen.NomCen, emp.NomEmp FROM departamento dep LEFT JOIN centro cen ON dep.CodCen=cen.CodCen LEFT JOIN empleado emp ON dep.CodEmpDir=emp.CodEmp;

-- 4:
SELECT NomDep, cen.NomCen, emp.NomEmp FROM departamento dep LEFT JOIN centro cen ON dep.CodCen=cen.CodCen LEFT JOIN empleado emp ON dep.CodEmpDir=emp.CodEmp WHERE dep.PreAnu >= ALL (SELECT PreAnu FROM departamento);

-- 5:
SELECT emp.*, cen.NomCen FROM empleado emp LEFT JOIN departamento dep ON emp.CodDep=dep.CodDep LEFT JOIN centro cen ON cen.CodCen=dep.CodCen WHERE cen.NomCen LIKE 'Fábrica Zona Sur';

-- 6:


