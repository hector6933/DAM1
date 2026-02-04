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
SELECT ped.numero_pedido, pro.nombre, ped.cantidad
FROM detalles_pedidos ped INNER JOIN productos pro 
ON ped.numero_producto=pro.numero_producto;

