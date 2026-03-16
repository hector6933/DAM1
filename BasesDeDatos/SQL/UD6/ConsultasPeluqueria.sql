-- 1:
SELECT nombre,genero FROM servicio WHERE id IN 
(SELECT id_servicio FROM empleado_servicio WHERE id_empleado IN 
(SELECT id FROM empleado WHERE nombre LIKE 'Rigoberta'));

-- 2:
SELECT * FROM empleado WHERE id NOT IN 
(SELECT id_empleado FROM empleado_servicio);

-- 3:
SELECT * FROM empleado emp WHERE salario > (SELECT salario FROM empleado jefe WHERE emp.id_jefe=jefe.id);

-- 4:
SELECT * FROM empleado WHERE id IN 
(SELECT id_empleado FROM detalle_evento WHERE id_evento IN 
(SELECT id FROM evento WHERE nombre LIKE 'Hamlet')) 
AND id IN (SELECT id_empleado FROM empleado_servicio WHERE id_servicio 
IN (SELECT id FROM servicio WHERE nombre LIKE 'maquillar'));

-- 5:
SELECT nombre FROM empleado WHERE id 
IN (SELECT id_empleado FROM empleado_servicio 
WHERE id_servicio IN
		(SELECT id FROM servicio WHERE nombre LIKE 'cortar' AND genero LIKE 'hombre'))
AND id 
IN (SELECT id_empleado FROM empleado_servicio 
WHERE id_servicio IN
		(SELECT id FROM servicio WHERE nombre LIKE 'cortar' AND genero LIKE 'mujer'));

-- 6:
SELECT SUM(precio) FROM cita WHERE id_empleado 
IN (SELECT id FROM empleado) GROUP BY id_empleado;

-- 7:
SELECT nombre, telefono, COUNT(SELECT ) FROM cliente cli

SELECT * FROM empleado_servicio;
SELECT * FROM servicio;
SELECT * FROM empleado;
SELECT * FROM evento;
SELECT * FROM detalle_evento;
SELECT * FROM cita;
SELECT * FROM cliente;




