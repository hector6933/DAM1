SELECT NomDep
FROM departamento
WHERE PreAnu > (SELECT AVG(PresuCentro)
					FROM (SELECT SUM(PreAnu) AS PresuCentro
						FROM departamento
						GROUP BY CodCen) AS PresuCentro
					);