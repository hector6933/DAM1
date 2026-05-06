-- Ej5:

USE world;
DELIMITER //
DROP PROCEDURE IF EXISTS world.ej5; // 
CREATE PROCEDURE world.ej5(INOUT palabra VARCHAR(500))
BEGIN
	-- Declaro variables (Celi a)
	DECLARE reversed VARCHAR(500) DEFAULT '';
	DECLARE caracter CHAR(1);
	DECLARE i INT DEFAULT 0;
	DECLARE longitud INT DEFAULT LENGTH(palabra);

	-- Bucle
	WHILE i <= longitud DO
		SET caracter = SUBSTRING(palabra, longitud-i, 1);
		SET reversed = CONCAT(reversed, caracter);
		SET i = i + 1;
	END WHILE;
	SET palabra = reversed;
END //

SET @pablada = 'Alonso Gitano';

-- 6:

DELIMITER //
DROP PROCEDURE IF EXISTS sakila.ej6; //
USE sakila;//
CREATE PROCEDURE sakila.ej6(IN id INT,IN email VARCHAR(100))
BEGIN
	UPDATE customer c SET c.email = email WHERE c.customer_id=id;
END //

CALL ej6(1,'email@email.email');//

-- 7:

DROP FUNCTION IF EXISTS sakila.ej7;//
USE sakila;//
CREATE FUNCTION sakila.ej7(nombre VARCHAR(100), apellidos VARCHAR(100))
RETURNS INT DETERMINISTIC
BEGIN
	DECLARE num INT DEFAULT 0;
	SELECT a.actor_id INTO num FROM actor a WHERE a.first_name=nombre AND a.last_name=apellidos;
	RETURN num;
END //

SELECT ej7('Santiago','Abascal');//

-- 8:
DELIMITER //
DROP PROCEDURE IF EXISTS sakila.ej8; //
USE sakila;//
CREATE PROCEDURE sakila.ej8(IN categoria VARCHAR(100))
BEGIN
	SELECT * FROM film WHERE film_id 
		IN (SELECT film_id FROM film_category WHERE category_id 
				IN (SELECT category_id FROM category WHERE name LIKE categoria));
END //

CALL ej8('Action'); //









