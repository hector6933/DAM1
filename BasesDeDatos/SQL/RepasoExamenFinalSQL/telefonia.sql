-- 1:
SELECT e.nombre, e.apellidos FROM clientes e INNER JOIN clientes e2 ON e.padrino = e2.id_cliente 
	INNER JOIN tarifas t ON e.tarifa = t.id_tarifa 
	WHERE e2.edad = (SELECT MAX(edad) FROM clientes) AND t.nombre LIKE 'Barata'

select * from clientes;

-- 2:
SELECT nombre, descuento FROM promociones 
	WHERE CURDATE() BETWEEN fecha_inicio AND fecha_fin
	AND descuento = (SELECT MAX(descuento) FROM promociones WHERE CURDATE() BETWEEN fecha_inicio AND fecha_fin);

-- 3:
SELECT e.nombre, e.apellidos, t.nombre, t.establecimiento, COUNT(l.id_llamada) AS 'Número de llamadas'
	FROM llamadas l INNER JOIN clientes e ON l.id_cliente = e.id_cliente 
	INNER JOIN tarifas t ON e.tarifa = t.id_tarifa 
	WHERE t.establecimiento = (SELECT MAX(establecimiento) FROM tarifas) GROUP BY e.id_cliente;

-- 4:
SELECT t.nombre FROM tarifas t 
	INNER JOIN clientes c ON t.id_tarifa = c.tarifa 
	INNER JOIN llamadas l ON c.id_cliente = l.id_cliente 
	WHERE c.id_cliente NOT IN (SELECT id_cliente FROM llamadas WHERE tipo NOT LIKE 'N');

-- 5:
SELECT l.*, p.nombre AS 'Nombre promocion' FROM llamadas l 
	INNER JOIN promociones p ON l.fecha BETWEEN p.fecha_inicio AND p.fecha_fin;

-- 6:
SELECT c.nombre, c.apellidos FROM clientes c 
	INNER JOIN tarifas t ON c.tarifa = t.id_tarifa 
	WHERE (t.nombre LIKE 'Normal' OR t.nombre LIKE 'Buena')
	AND NOT EXISTS 
		(SELECT * FROM llamadas l WHERE l.id_cliente = c.id_cliente AND l.tipo LIKE 'N');

-- 7:
SELECT c.*, COUNT(l.id_llamada) AS 'Llamadas realizadas', (COUNT(l.id_llamada) - (SELECT AVG(l2.id_llamada) AS media FROM llamadas l2 INNER JOIN clientes c2 ON l2.id_cliente = c2.id_cliente WHERE c2.tarifa = c.tarifa)) AS 'Número de llamadas para superar la media' FROM llamadas l
	INNER JOIN clientes c ON l.id_cliente = c.id_cliente 
	INNER JOIN tarifas t ON c.tarifa = t.id_tarifa
	GROUP BY c.id_cliente 
	HAVING COUNT(l.id_llamada) > 
	(SELECT AVG(l2.id_llamada) AS media FROM llamadas l2 INNER JOIN clientes c2 ON l2.id_cliente = c2.id_cliente WHERE c2.tarifa = c.tarifa);

-- 8:
SELECT nombre, apellidos, SUM(l.duracion) AS 'Duración de la llamada' FROM clientes c 
	INNER JOIN llamadas l ON c.id_cliente = l.id_cliente 
	WHERE l.tipo LIKE 'I' GROUP BY c.id_cliente 
	HAVING SUM(l.duracion) > 5;

-- 9:
SELECT c.nombre, c.apellidos, c.edad, t.nombre, 'Más joven' AS tipo FROM clientes c
	INNER JOIN tarifas t ON c.tarifa = t.id_tarifa
	WHERE c.edad = (SELECT MIN(edad) FROM clientes WHERE tarifa = c.tarifa)
UNION
SELECT c.nombre, c.apellidos, c.edad, t.nombre, 'Más mayor' AS tipo FROM clientes c
	INNER JOIN tarifas t ON c.tarifa = t.id_tarifa
	WHERE c.edad = (SELECT MAX(edad) FROM clientes WHERE tarifa = c.tarifa);

-- 10:
SELECT DISTINCT nombre, apellidos FROM clientes c
	WHERE c.id_cliente NOT IN (SELECT id_cliente FROM llamadas WHERE YEAR(fecha) = 2025);

-- 11:
SELECT c.nombre, c.apellidos, l.duracion, l.fecha, 
	AVG(l.duracion) OVER (PARTITION BY c.id_cliente) AS media_duracion
	FROM llamadas l
	INNER JOIN clientes c ON l.id_cliente = c.id_cliente
	ORDER BY media_duracion DESC;
	
-- 12:
WITH clientes_minutos AS (
	SELECT nombre, apellidos, SUM(l.duracion) AS duracion FROM clientes c
		INNER JOIN llamadas l ON c.id_cliente = l.id_cliente
		GROUP BY c.id_cliente 
)
SELECT * FROM clientes_minutos WHERE duracion > 5;

SELECT 
    c.nombre,
    t.nombre AS tarifa,
    COUNT(l.id_llamada) OVER (PARTITION BY c.id_cliente) AS llamadas_cliente,
    COUNT(l.id_llamada) OVER (PARTITION BY c.tarifa)    AS llamadas_tarifa
FROM llamadas l
INNER JOIN clientes c ON l.id_cliente = c.id_cliente
INNER JOIN tarifas t ON c.tarifa = t.id_tarifa;















