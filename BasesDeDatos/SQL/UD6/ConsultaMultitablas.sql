SELECT ci.*, co.* FROM city ci CROSS JOIN country co;

SELECT * FROM city CROSS JOIN country;

SELECT ci.*, co.* FROM city ci INNER JOIN country co ON ci.CountryCode=co.Code;

SELECT ci.CountryCode, NAME, cl.CountryCode, LANGUAGE 
FROM city ci INNER JOIN countrylanguage cl ON ci.CountryCode=cl.CountryCode;

-- Paises que tengan ciudades
SELECT NAME FROM country co
WHERE EXISTS (SELECT * FROM city ci WHERE ci.CountryCode=co.Code);

-- Paises que NO tengan ciudades
SELECT NAME FROM country co
WHERE NOT EXISTS (SELECT * FROM city ci WHERE ci.CountryCode=co.Code);

-- Subconsultas correlacionadas en el SELECT 
-- Mostrar el nombre del los países junto con su ciudad más poblada
SELECT NAME, (SELECT MAX(Population) 
FROM city ci WHERE ci.CountryCode=co.Code)
FROM country co;

-- Paisees con población mayor al promedio de su continente
SELECT NAME FROM country co1
WHERE Population>
(SELECT AVG(Population) FROM country co2 WHERE co2.Continent=co1.Continent);

-- Multi tabla
-- Mostrar el nombre de las ciudades de más de 1000000 de habitantes 
-- junto con el nombre del país donde se encuentran
SELECT ci.Name AS Ciudad, Co.Name AS Pais
FROM city ci INNER JOIN country co
ON ci.CountryCode=co.Code
WHERE ci.Population > 1000000;

-- Nombre del país junto con el nombre de sus ciudades
SELECT ci.Name AS Ciudad, Co.Name AS Pais
FROM country co LEFT JOIN city ci
ON ci.CountryCode=co.Code
WHERE ci.ID IS NULL;

SELECT ci.Name AS Ciudad, Co.Name AS Pais
FROM country co RIGHT JOIN city ci
ON ci.CountryCode=co.Code
WHERE co.Code IS NULL;
