DELIMITER //
DROP PROCEDURE IF EXISTS world.cursores1; // 
CREATE PROCEDURE world.cursores1(IN codPais CHAR(3))
BEGIN 	-- Mostrar ciudades por país
	
	DECLARE ciudad VARCHAR(50);
	DECLARE ultima_fila BOOL DEFAULT 0;
	
	DECLARE cursor_ciudades CURSOR FOR 
		SELECT Name FROM city WHERE codPais = CountryCode;
	
	-- Declaro el manejador para el final del cursor
	-- Cuando salta una "excepción" porque no encuentra algo pone ultima_fila a 1 y se acaba el programa
	DECLARE CONTINUE HANDLER FOR NOT FOUND 
	SET ultima_fila=1;
	
	OPEN cursor_ciudades;
	-- Bucle para recorrer el cursor
	bucle: LOOP
		FETCH cursor_ciudades INTO ciudad;
		
		-- Condición para salir del bucle
		IF ultima_fila = 1 THEN 
		
			LEAVE bucle;
			
		END IF;
		SELECT CONCAT('Ciudad de ',codPais, ' es ', ciudad);
		
	END LOOP;
	
	CLOSE cursor_ciudades;
	
END //

-- Procedimiento que nos muestre el continente el, número de idiomas y el porcentaje de hablantes de esos idiomas
DELIMITER //
DROP PROCEDURE IF EXISTS world.cursores2; // 
CREATE PROCEDURE world.cursores2()
BEGIN 
	
	-- TODO EN ESTE ORDEN O SI NO DA UN ERROR (según Celia)
	
	-- Declaramos variables
	DECLARE v_continente VARCHAR(67);
	DECLARE v_cant_idiomas INT;
	DECLARE v_porcentaje FLOAT;
	
	-- Declaramos variable ultima filaaa del cursor 
	DECLARE v_ultima_fila BOOLEAN DEFAULT FALSE;
	
	-- Declaramos el cursor
	DECLARE cursor_continente CURSOR FOR 
		SELECT DISTINCT Continent FROM country;
	
	-- Declaramos el manejador de errores para el cursor
	DECLARE CONTINUE HANDLER FOR NOT FOUND -- Para cuando NO encuentra la fila en el cursor
		SET v_ultima_fila = TRUE; -- Ponemos que la última fila es TRUE
	-- Osea que es un try catch que cuando atrapa el error pone la variable a true
	
	-- Nos creamos una tabla temporal, dios sabe por qué
	CREATE TEMPORARY TABLE temporal_continente (
		continente VARCHAR(67),
		num_idiomas INT,
		porcentaje FLOAT
		
	);
	
	-- Abrir el cursor (surrealista)
	OPEN cursor_continente;
	
	-- Usamos un bucle para recorrer el cursor
	bucle_cursor:LOOP
		-- Procesar un cursor (aimai)
		FETCH cursor_continente INTO v_continente;
	
		-- Condición de salida del bucle 
		IF v_ultima_fila THEN
			LEAVE bucle_cursor; -- Si NO hay más filas te las piras
		END IF; 
		
		SELECT COUNT(cl.Language), AVG(cl.percentage)
		INTO v_cant_idiomas, v_porcentaje
		FROM country c INNER JOIN countrylanguage cl ON c.Code=cl.CountryCode WHERE c.Continent LIKE v_continente;
		
		INSERT INTO temporal_continente VALUES (v_continente,v_cant_Idiomas,v_porcentaje);
		
	END LOOP;
	
	-- Cerramos el cursor (flipalo)
	CLOSE cursor_continente; 
	
	SELECT * FROM temporal_continente;
	
END //

-- Para cada actor cuantas peliculas tiene
DELIMITER //
DROP PROCEDURE IF EXISTS sakila.cursores3; // 
CREATE PROCEDURE sakila.cursores3()
BEGIN 
	
	-- Declarar las variables
	-- id_actor, nombre, cantidad_peliculas
	DECLARE v_id_actor INT;
	DECLARE v_nombre VARCHAR(67);
	DECLARE v_cant_peliculas INT;
	
	-- Variable del final del cursor
	DECLARE v_ultima_fila BOOLEAN DEFAULT FALSE;
	
	-- Declaramos el cursor
	DECLARE cursor_actores CURSOR FOR
		SELECT actor_id FROM actor;
	-- Declaramos el manejador
	DECLARE CONTINUE HANDLER FOR NOT FOUND 
		SET v_ultima_fila = TRUE;
	
	OPEN cursor_actores;
	
	bucle_actores:LOOP
		
		FETCH cursor_actores INTO v_id_actor;
		
		IF v_ultima_fila THEN
			LEAVE bucle_actores;
		END IF;
		
		SELECT first_name, COUNT(fa.film_id) AS peliculas
		INTO v_nombre, v_cant_peliculas
		FROM actor a INNER JOIN film_actor fa 
		ON a.actor_id=fa.actor_id GROUP BY a.actor_id;
		
		SELECT CONCAT(v_nombre,' ',v_cant_peliculas);
		
	END LOOP;
	

END //

CALL sakila.cursores3();

SELECT first_name, COUNT(fa.film_id) AS peliculas
		FROM actor a INNER JOIN film_actor fa
		ON a.actor_id=fa.actor_id GROUP BY a.actor_id;







