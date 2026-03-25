-- 1:
UPDATE cliente SET Direccion = 'Mayor, 10 Teruel'
WHERE 'DNI' LIKE '022222222R';

-- 2:
UPDATE cliente SET Nombre = UPPER(Nombre);

-- 3:
INSERT INTO pelicula 
(CodPeli,Titulo,CodGenero,SegundaParte,CodActor) 
VALUES
(6,'Lo que el agua se llevó',(SELECT CodGenero FROM genero WHERE Descripcion LIKE 'Drama'),(SELECT p.CodPeli FROM pelicula p WHERE p.Titulo LIKE 'Lo que el viento se llev�'),(SELECT CodActor FROM actor WHERE Nombre LIKE 'Eva'));

-- 4:
INSERT INTO copia VALUES (1,6);

-- 5:
INSERT INTO factura ()
VALUES
(4,CURDATE(),0, (SELECT DNI FROM cliente WHERE Nombre LIKE 'PEDRO MARTINEZ ROY'));

-- 6:
INSERT INTO detallefactura ()
VALUES
(4,1,'Piel 1',4.50,1),(4,2,'Refresco',2.50,2);

UPDATE factura SET 
importe = importe + ((SELECT SUM(d1.PrecioUnitaro * d1.NumeroUnidades) FROM detallefactura d1 WHERE CodFactura = 4));

-- Probatinas
-- UPDATE factura SET importe = 0 WHERE CodFactura = 4;
-- SELECT * FROM factura WHERE CodFactura = 4;

-- 7:
INSERT INTO prestamo ()
VALUES (6,1,CURDATE(),(SELECT DNI FROM cliente WHERE Nombre LIKE 'PEDRO MARTINEZ ROY')); 

-- 8:
INSERT INTO interpretada ()
VALUES (6,(SELECT CodActor FROM pelicula WHERE CodPeli = 6));

-- 9:
DELETE FROM pelicula WHERE CodPeli = 6;





