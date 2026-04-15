-- 1:
DROP VIEW IF EXISTS v_clientes_contacto;
CREATE VIEW v_clientes_contacto AS
	SELECT id_cliente, CONCAT(nombre," ",apellidos) AS 'Nombre completo', ciudad, provincia FROM clientes;

SELECT * FROM v_clientes_contacto;

-- 2:
DROP VIEW IF EXISTS v_productos_pvp;
CREATE VIEW v_productos_pvp AS
	SELECT numero_producto, nombre, precio_venta, precio_venta * 1,21 AS 'Precio con IVA' FROM productos;

SELECT * FROM v_productos_pvp;

-- 3:
DROP VIEW IF EXISTS v_clientes_madrid;
CREATE VIEW v_clientes_madrid AS 
	SELECT * FROM clientes WHERE provincia LIKE 'madrid' ORDER BY apellidos;

SELECT * FROM v_clientes_madrid;

-- 4:
DROP VIEW IF EXISTS v_productos_rango_precio;
CREATE VIEW v_productos_rango_precio AS
	SELECT nombre, precio_venta FROM productos 
		WHERE precio_venta > 20 AND precio_venta < 150 ORDER BY precio_venta DESC;
SELECT * FROM v_productos_rango_precio;

-- 5:
DROP VIEW IF EXISTS v_proveedores_sin_web;
CREATE VIEW v_proveedores_sin_web AS 
	SELECT nombre, ciudad, telefono FROM proveedores
		WHERE pag_web IS NULL;
SELECT * FROM v_proveedores_sin_web;

-- 6:
DROP VIEW IF EXISTS v_bicicletas_y_ropa;
CREATE VIEW v_bicicletas_y_ropa AS 
	SELECT nombre, descripcion, precio_venta FROM productos
		WHERE (id_categoria = 2 OR id_categoria = 3) AND nombre LIKE '%a%';
SELECT * FROM v_bicicletas_y_ropa;

-- 7:
DROP VIEW IF EXISTS v_pedidos_grandes;
CREATE VIEW v_pedidos_grandes AS
		SELECT p.numero_pedido, p.fecha_pedido, p.precio_total FROM pedidos p
		WHERE p.precio_total > (SELECT AVG(p2.precio_total) FROM pedidos p2);

SELECT * FROM v_pedidos_grandes;

-- 8:
DROP VIEW IF EXISTS v_clientes_activos;
CREATE VIEW v_clientes_activos AS
	SELECT id_cliente, CONCAT(nombre," ", apellidos) AS 'Nombre completo', ciudad FROM clientes
		WHERE id_cliente IN (SELECT id_cliente FROM pedidos);

SELECT * FROM v_clientes_activos;

-- 9:
DROP VIEW IF EXISTS v_pedidos_detallados;
CREATE VIEW v_pedidos_detallados AS
	SELECT p.numero_pedido, p.fecha_pedido, p.precio_total, CONCAT(c.nombre," ",c.apellidos) AS 'Nombre CLIENTE', CONCAT(e.nombre," ",e.apellidos) AS 'Nombre EMPLEADO'
		FROM empleados e RIGHT JOIN pedidos p ON e.id_empleado = p.id_empleado LEFT JOIN clientes c ON c.id_cliente = p.id_cliente;

SELECT * FROM v_pedidos_detallados;

-- 10:
DROP VIEW IF EXISTS v_catalogo_productos;
CREATE VIEW v_catalogo_productos AS
	SELECT p.nombre, p.descripcion, p.precio_venta, p.stock, c.descripcion AS 'Categoria'
		FROM productos p LEFT JOIN categorias c ON p.id_categoria = c.id_categoria;

SELECT * FROM v_catalogo_productos;

-- 11:
DROP VIEW IF EXISTS v_clientes_sin_pedidos;
CREATE VIEW v_clientes_sin_pedidos AS
	SELECT CONCAT(c.nombre," ",c.apellidos) AS 'Nombre completo', c.ciudad, c.provincia
		FROM clientes c LEFT JOIN pedidos p ON c.id_cliente = p.id_cliente
			WHERE p.id_cliente IS NULL;

SELECT * FROM v_clientes_sin_pedidos;

-- 12:
DROP VIEW IF EXISTS v_mejor_precio_proveedor;
CREATE VIEW v_mejor_precio_proveedor AS
	SELECT p.nombre, pp.precio_por_mayor, pro.nombre AS 'Nombre proveedor'
		FROM productos p NATURAL LEFT JOIN productos_proveedores pp 
			LEFT JOIN proveedores pro ON pp.id_prov = pro.id_prov
				WHERE pp.precio_por_mayor = (SELECT MIN(pp2.precio_por_mayor) FROM productos_proveedores pp2 WHERE pp2.numero_producto = p.numero_producto);

SELECT * FROM v_mejor_precio_proveedor;




