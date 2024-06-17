-- 2. listar todos los tratamientos que tiene un paciente en una determinada cara en una determinada pieza dentaria

SELECT t.CODIGO, t.DESCRIPCION
FROM TRATAMIENTOS t
JOIN PIEZASDENT_CARAS_TRAT pdct ON t.ID = pdct.ID_TRATAMIENTO
JOIN ODONTOGRAMA_PIEZAS_DENTARIAS opd ON pdct.ID_PIEZA_DENTARIA = opd.ID_PIEZA_DENTARIA
JOIN ODONTOGRAMA o ON opd.ID_ODONTOGRAMA = o.ID
JOIN PACIENTES p ON O.ID_PACIENTE = p.ID
WHERE p.ID = ? AND opd.ID_PIEZA_DENTARIA = ? AND pdct.ID_CARA = ?;