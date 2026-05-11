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