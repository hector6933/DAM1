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
DROP PROCEDURE IF EXISTS sakila.ej8; //
USE sakila;//
CREATE PROCEDURE sakila.ej8(IN categoria VARCHAR(100))
BEGIN
	SELECT * FROM film WHERE film_id 
		IN (SELECT film_id FROM film_category WHERE category_id 
				IN (SELECT category_id FROM category WHERE name LIKE categoria));
END //

CALL ej8('Action'); //

-- 9:
DROP PROCEDURE IF EXISTS sakila.ej9;//
USE sakila;//
CREATE PROCEDURE sakila.ej9(IN nombre VARCHAR(100), OUT numeroPeliculas INT)
BEGIN
	DECLARE num INT DEFAULT 0;

	SELECT COUNT(*) INTO num FROM film 
		WHERE film_id IN (SELECT film_id FROM film_category 
							WHERE category_id IN (SELECT category_id FROM category WHERE name LIKE nombre));
	
	SET numeroPeliculas = num;
	
END //

CALL ej9('Comedy',@peliculas); //
-- SELECT @peliculas; 

-- 10: 
DROP FUNCTION IF EXISTS sakila.ej10;//
USE sakila;//
CREATE FUNCTION sakila.ej10(fecha1 DATE, fecha2 DATE)
RETURNS INT DETERMINISTIC
BEGIN
	
	RETURN abs (TRUNCATE(DATEDIFF(fecha1,fecha2)/365,0));
	
END //

-- SELECT ej10('2020-11-11','2000-02-06');

-- 11:

DROP PROCEDURE IF EXISTS sakila.ej11;//
USE sakila;//
CREATE PROCEDURE sakila.ej11(IN idActor INT)
BEGIN
	
	DECLARE existe INT DEFAULT NULL;
	
	SELECT actor_id INTO existe FROM actor WHERE actor_id=idActor; 
	
	IF existe IS NULL THEN
	
		SELECT 'Ese actor no existe';
		
	ELSE
	
		DELETE FROM actor WHERE actor_id = idActor;
		
	END IF;
	
END //

CALL ej11(-111); //

-- 12:
DELIMITER //
DROP PROCEDURE IF EXISTS sakila.ej12; //
USE sakila;//
CREATE PROCEDURE sakila.ej12(IN id INT, OUT duracion VARCHAR(50))
BEGIN
	DECLARE	tiempo INT DEFAULT 0;
	SELECT length INTO tiempo FROM film WHERE film_id = id;

	IF tiempo < 50 THEN 
		SET duracion = 'Corta duración';
	ELSEIF tiempo < 120 THEN 
		SET duracion = 'Media duración';
	ELSEIF tiempo > 120 THEN 
		SET duracion = 'Larga duración';
	END IF;
	
END //

CALL ej12(1,@duracionPeli);
-- SELECT @duracionPeli;

-- 13:
DELIMITER //
DROP PROCEDURE IF EXISTS world.ej13; //
USE world;//
CREATE PROCEDURE world.ej13(IN nombre VARCHAR(50))
BEGIN
	
	DECLARE aumento FLOAT DEFAULT 1;
	DECLARE continente VARCHAR(100) DEFAULT NULL;
	SELECT Continent INTO continente FROM country WHERE nombre LIKE Name;
	
	IF continente LIKE 'Africa' THEN
	
		SET aumento = 1.01;
		
	ELSEIF continente LIKE 'Antartida' THEN 
	
		SET aumento = 1.015;
		
	ELSEIF continente LIKE 'Asia' OR continente LIKE 'South America' THEN 
	
		SET aumento = 1.017;
		
	ELSEIF continente LIKE 'Europe' OR continente LIKE 'North America' THEN
	
		SET aumento = 1.019;
		
	ELSEIF continente LIKE 'Oceania' THEN
	
		SET aumento = 1.016;
		
	END IF;
	
	UPDATE country SET GNP = GNP * aumento WHERE Name LIKE nombre;
	
END //

CALL ej13('Spain');
SELECT * FROM country WHERE Name LIKE 'Spain';
