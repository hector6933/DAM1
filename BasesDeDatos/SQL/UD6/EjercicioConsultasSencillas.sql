SELECT CONCAT(nombre,apellidos) AS NombreCompleto,ciudad FROM empleados;

SELECT numero_producto,nombre,precio_venta FROM productos WHERE stock >= 10 AND stock <= 50;

SELECT nombre FROM productos WHERE nombre LIKE '%Mountain%' OR nombre LIKE '%Trail%' ORDER BY precio_venta DESC;

SELECT nombre FROM clientes WHERE nombre LIKE '%a' AND provincia NOT LIKE 'MADRID' AND provincia NOT LIKE 'TOLEDO';

SELECT nombre,apellidos,CONCAT(codigo_area,telefono) AS 'Area+Telefono' FROM empleados WHERE cod_postal LIKE '28%';

SELECT precio_venta,precio_venta * 0.80 AS precio_con_descuento FROM productos;

SELECT * FROM productos WHERE precio_venta > (SELECT AVG(precio_venta) FROM productos);

-- FALTA EL 8

SELECT * FROM proveedores WHERE id_prov NOT IN (SELECT id_prov FROM productos_proveedores WHERE numero_producto IN (SELECT numero_producto FROM productos WHERE numero_producto IN (SELECT numero_producto FROM detalles_pedidos WHERE numero_pedido IN (SELECT numero_pedido FROM pedidos WHERE YEAR(fecha_pedido)=2007))));

SELECT * FROM categorias WHERE id_categoria IN (SELECT id_categoria FROM productos WHERE precio_venta>30.0);

SELECT * FROM productos WHERE precio_venta > (SELECT precio_venta FROM productos WHERE numero_producto = 15);

SELECT * FROM proveedores;

SELECT * FROM clientes WHERE provincia IN (SELECT provincia FROM proveedores WHERE nombre LIKE 'Shinoman, Incorporated');

SELECT * FROM clientes WHERE provincia NOT IN (SELECT provincia FROM proveedores);

SELECT * FROM proveedores WHERE id_prov IN (SELECT id_prov FROM productos_proveedores WHERE numero_producto NOT IN (SELECT numero_producto FROM detalles_pedidos));

SELECT * FROM proveedores WHERE id_prov IN (SELECT id_prov FROM productos_proveedores WHERE numero_producto IN (SELECT numero_producto FROM detalles_pedidos));

SELECT * FROM productos WHERE precio_venta > ANY (SELECT precio_venta FROM productos WHERE id_categoria IN (SELECT id_categoria FROM categorias WHERE descripcion LIKE 'Ropa'));

SELECT * FROM pedidos WHERE precio_total < ALL (SELECT precio_total FROM pedidos WHERE id_cliente = 1001);

-- NO SE PUEDE HACER !!!! SELECT * FROM productos WHERE precio_venta < (SELECT precio_venta FROM productos WHERE id_categoria IN (SELECT id_categoria FROM categorias));

SELECT * FROM pedidos WHERE fecha_pedido < ALL (SELECT fecha_pedido FROM pedidos WHERE id_cliente = 1005);

SELECT cli.nombre, cli.apellidos, ped.numero_pedido, ped.fecha_pedido FROM clientes cli NATURAL LEFT JOIN pedidos ped;

-- 21:
SELECT ped.numero_pedido, pro.nombre, (SELECT cantidad FROM detalles_pedidos WHERE numero_producto=pro.numero_producto AND numero_pedido=ped.numero_pedido) AS 'Cantidad en pedido', pro.precio_venta AS 'Precio unitario'
FROM detalles_pedidos ped INNER JOIN productos pro ON ped.numero_producto=pro.numero_producto WHERE ped.numero_pedido = (SELECT numero_pedido FROM pedidos WHERE fecha_pedido>='2008-01-01' AND numero_pedido=ped.numero_pedido) ORDER BY ped.numero_pedido;


-- 22:
SELECT cat.descripcion, (SELECT COUNT(*) FROM productos WHERE cat.id_categoria=id_categoria) AS 'Productos', (SELECT AVG(precio_venta) FROM productos WHERE cat.id_categoria=id_categoria) AS 'Precio promedio'
FROM categorias cat;

-- 23:
SELECT prov.nombre, (SELECT nombre FROM productos WHERE prodprov.numero_producto=numero_producto), precio_por_mayor
FROM proveedores prov NATURAL JOIN productos_proveedores prodprov WHERE prodprov.numero_producto IN (SELECT numero_producto FROM productos WHERE id_categoria IN (SELECT id_categoria FROM categorias WHERE descripcion='Bicicletas'));

-- 24:
SELECT (SELECT nombre FROM clientes WHERE ped.id_cliente=id_cliente) AS 'Cliente',emp.nombre AS 'Empleado', ped.fecha_pedido
FROM pedidos ped NATURAL JOIN empleados emp WHERE ped.id_cliente = (SELECT id_cliente FROM clientes WHERE ciudad='Robledo' AND ped.id_cliente=id_cliente) AND ped.id_empleado = (SELECT id_empleado FROM empleados WHERE ciudad='Robledo' AND emp.id_empleado=id_empleado);

-- 25:
SELECT pro.* 
FROM productos pro WHERE (SELECT COUNT(*) FROM detalles_pedidos WHERE numero_producto=pro.numero_producto) = 0;

-- 26:
SELECT ped.*
FROM pedidos ped WHERE 7 < ped.fecha_envio - ped.fecha_pedido;

-- 27:
SELECT cat.descripcion, pro.nombre, pro.precio_venta
FROM productos pro INNER JOIN categorias cat WHERE pro.precio_venta = (SELECT MAX(precio_venta) FROM productos WHERE id_categoria=cat.id_categoria);

-- 28:
SELECT pro.*
FROM productos pro NATURAL JOIN productos_proveedores proprov
WHERE proprov.id_prov = (SELECT id_prov FROM proveedores WHERE nombre LIKE 'Viscount');

-- 29:
SELECT 
FROM productos pro




