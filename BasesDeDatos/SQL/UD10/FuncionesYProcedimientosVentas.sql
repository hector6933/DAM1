-- 1:
DELIMITER //
DROP PROCEDURE IF EXISTS ventas.ej1; // 
CREATE PROCEDURE ventas.ej1()
BEGIN 	
		
	-- Variables para almacenar valores de cada fila del cursor
	 DECLARE v_apellidos VARCHAR(25);
	 DECLARE v_fecha_pedido DATE;
	 DECLARE fin_cursor BOOLEAN DEFAULT FALSE;
	 -- Cursor que obtiene apellidos y fechas de pedidos
	 DECLARE c_pedido CURSOR FOR
	 SELECT cli.apellidos, ped.fecha_pedido
	 FROM clientes cli
	 JOIN pedidos ped ON ped.id_cliente = cli.id_cliente
	 GROUP BY cli.apellidos, ped.fecha_pedido
	 ORDER BY cli.apellidos, ped.fecha_pedido;
	 -- Manejador para cuando el cursor no tenga más filas
	 DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin_cursor = TRUE;
	 -- Abrir cursor
	 OPEN c_pedido;
	 -- Bucle para recorrer el cursor
	 bucle: LOOP
		 FETCH c_pedido INTO v_apellidos, v_fecha_pedido;
		 IF fin_cursor THEN
		 	LEAVE bucle;
		 END IF;
		 -- Mostrar resultado (una fila por vez)
		 SELECT CONCAT(v_apellidos, ' * ', v_fecha_pedido) AS Resultado;
	 END LOOP;
	 -- Cerrar cursor
	 CLOSE c_pedido;
	
		
END //

-- 2:
DELIMITER //
DROP PROCEDURE IF EXISTS ventas.ej2; // 
CREATE PROCEDURE ventas.ej2()
BEGIN 
	
	DECLARE v_desc VARCHAR(67);
	DECLARE v_num_productos INT;
	
	DECLARE v_fin BOOLEAN DEFAULT FALSE;
	
	DECLARE cursor_categoria CURSOR FOR 
		SELECT c.descripcion, COUNT(p.numero_producto) FROM categorias c 
			JOIN productos p ON c.id_categoria = p.id_categoria
			GROUP BY c.id_categoria;

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_fin = TRUE;

	OPEN cursor_categoria;
	bucle: LOOP
		FETCH cursor_categoria INTO v_desc, v_num_productos;
		IF v_fin THEN
			LEAVE bucle;
		END IF;
	
		SELECT CONCAT(v_desc,' ',v_num_productos);
	
	END LOOP;
	
	CLOSE cursor_categoria;
	
END //

-- CALL ventas.ej2();

-- 3:
DELIMITER //
DROP PROCEDURE IF EXISTS ventas.ej3; // 
CREATE PROCEDURE ventas.ej3(IN cadena VARCHAR(67))
BEGIN 
	
	DECLARE v_apellido VARCHAR(67);
	DECLARE v_id_emp INT;
	DECLARE v_contador INT DEFAULT 0;
	
	DECLARE v_fin BOOLEAN DEFAULT FALSE;
	
	DECLARE cursor_emp CURSOR FOR 
		SELECT apellidos, id_empleado FROM empleados WHERE apellidos LIKE (CONCAT('%',cadena,'%'));

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_fin = TRUE;

	OPEN cursor_emp;
	bucle: LOOP
		
		FETCH cursor_emp INTO v_apellido, v_id_emp;
		IF v_fin THEN
			LEAVE bucle;
		END IF;
	
		SET v_contador = v_contador + 1;
		SELECT CONCAT(v_apellido,' ',v_id_emp);
	
	END LOOP;
	
	SELECT CONCAT('Empleados mostrados: ',v_contador);
	
	CLOSE cursor_emp;
	
END //

-- 4:
DELIMITER //
DROP PROCEDURE IF EXISTS ventas.ej4; // 
CREATE PROCEDURE ventas.ej4()
BEGIN 
	
	DECLARE v_apellido VARCHAR(67);
	DECLARE v_total_gastado FLOAT;
	
	DECLARE v_fin BOOLEAN DEFAULT FALSE;
	
	DECLARE cursor_clientes CURSOR FOR 
		SELECT c.apellidos, SUM(p.precio_total) FROM clientes c 
			JOIN pedidos p ON c.id_cliente = p.id_cliente 
			GROUP BY c.id_cliente
			ORDER BY SUM(p.precio_total) DESC LIMIT 5;

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_fin = TRUE;

	OPEN cursor_clientes;
	bucle: LOOP
		
		FETCH cursor_clientes INTO v_apellido, v_total_gastado;
		IF v_fin THEN
			LEAVE bucle;
		END IF;
	
		SELECT CONCAT(v_apellido,' ',v_total_gastado,'€') AS 'Total gastado';
	
	END LOOP;
	
	CLOSE cursor_clientes;
	
END //

-- 5:
DELIMITER //
DROP PROCEDURE IF EXISTS ventas.ej5; // 
CREATE PROCEDURE ventas.ej5()
BEGIN 
	
	DECLARE v_producto VARCHAR(67);
	
	DECLARE v_fin BOOLEAN DEFAULT FALSE;
	
	DECLARE cursor_producto CURSOR FOR 
		SELECT c.descripcion, COUNT(dp.numero_pedido) AS 'Ventas' FROM detalles_pedidos dp 
		JOIN productos p ON dp.numero_producto = p.numero_producto
		JOIN categorias c ON p.id_categoria = c.id_categoria
		GROUP BY c.id_categoria;

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_fin = TRUE;

	OPEN cursor_producto;
	bucle: LOOP
		
		FETCH cursor_producto INTO v_producto;
		IF v_fin THEN
			LEAVE bucle;
		END IF;
	
		SELECT CONCAT(v_apellido,' ',v_total_gastado,'€') AS 'Total gastado';
	
	END LOOP;
	
	CLOSE cursor_producto;
	
END //

SELECT c.descripcion, COUNT(dp.numero_pedido) AS 'Ventas' FROM detalles_pedidos dp 
	JOIN productos p ON dp.numero_producto = p.numero_producto
	JOIN categorias c ON p.id_categoria = c.id_categoria
	GROUP BY c.id_categoria;

SELECT * FROM detalles_pedidos dp;




