-- 1:
SELECT nombre, apellidos FROM clientes 
	WHERE padrino IN (SELECT padrino FROM clientes WHERE edad > 18)
	AND tarifa IN (SELECT id_tarifa FROM tarifas 
					WHERE nombre LIKE 'Barata');
-- 2:
SELECT nombre, descuento FROM promociones 
	WHERE CURDATE() BETWEEN fecha_inicio AND fecha_fin 
	AND descuento = (SELECT MAX(descuento) FROM promociones);

-- 3:
SELECT c.nombre, c.apellidos, f.nombre, f.establecimiento, COUNT(l.id_llamada)
FROM 
llamadas l INNER JOIN clientes c ON l.id_cliente=c.id_cliente
INNER JOIN tarifas f ON c.tarifa=f.id_tarifa
WHERE f.establecimiento = (SELECT MAX(establecimiento) FROM tarifas) GROUP BY c.id_cliente;

-- 4:
SELECT t.nombre FROM tarifas t INNER JOIN clientes c ON c.tarifa=t.id_tarifa
WHERE c.id_cliente NOT IN (SELECT id_cliente FROM llamadas WHERE tipo LIKE 'I' AND tipo LIKE 'R');

-- 5:
SELECT DISTINCT l.* FROM 
llamadas l INNER JOIN clientes c ON l.id_cliente=c.id_cliente 
INNER JOIN tarifas t ON c.tarifa=t.id_tarifa 
INNER JOIN promociones p ON p.id_tarifa=t.id_tarifa
WHERE CURDATE() BETWEEN p.fecha_inicio AND p.fecha_fin;

-- 6:
SELECT c.nombre, c.apellidos FROM 
clientes c INNER JOIN tarifas t ON c.tarifa=t.id_tarifa 
	WHERE (t.nombre LIKE 'Normal' OR t.nombre LIKE 'Buena')
	AND
	NOT EXISTS (SELECT 1 FROM llamadas WHERE id_cliente=c.id_cliente AND tipo LIKE 'N');

-- 7:
SELECT c.*, COUNT(l.id_llamada) FROM 
llamadas l INNER JOIN clientes c ON l.id_cliente=c.id_cliente 
INNER JOIN tarifas t ON c.tarifa=t.id_tarifa
GROUP BY c.id_cliente 
HAVING COUNT(l.id_llamada) > (SELECT AVG(conteo) FROM (SELECT COUNT(l2.id_llamada) AS conteo FROM llamadas l2 INNER JOIN clientes c2 ON l2.id_cliente=c2.id_cliente WHERE c2.tarifa=c.tarifa) AS tabla);























