SELECT ci.*, co.* FROM city ci CROSS JOIN country co;

SELECT * FROM city CROSS JOIN country;

SELECT ci.*, co.* FROM city ci INNER JOIN country co ON ci.CountryCode=co.Code;

SELECT ci.CountryCode, NAME, cl.CountryCode, LANGUAGE 
FROM city ci INNER JOIN countrylanguage cl ON ci.CountryCode=cl.CountryCode;

