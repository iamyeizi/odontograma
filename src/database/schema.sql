DROP DATABASE IF EXISTS odontograma;
CREATE DATABASE odontograma;
USE odontograma;

# -----------------------------------------------------------------------
# TABLES
# -----------------------------------------------------------------------

CREATE TABLE CARAS (
	ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,ODONTOGRAMA
    DESCRIPCION VARCHAR(100) NOT NULL,
    TIPO ENUM('Axial Proximal', 'Axial Libre', 'Perpendiculares') NOT NULL
);

CREATE TABLE PIEZAS_DENTARIAS (
    ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    NRO_PIEZA INT NOT NULL,
    DESCRIPCION VARCHAR(100) NOT NULL,
    TIPO_DENTICION ENUM('Primaria', 'Secundaria') NOT NULL,
    GRUPO_DENTARIO ENUM('Anterior', 'Posterior') NOT NULL,
    SUBGRUPO ENUM('Incisivos', 'Caninos', 'Premolares', 'Molares') NOT NULL,
    ARCADA ENUM('Superior Derecha', 'Superior Izquierda', 'Inferior Derecha', 'Inferior Izquierda') NOT NULL
);

CREATE TABLE PIEZAS_DENTARIAS_CARAS (
	ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    ID_PIEZA_DENTARIA INT NOT NULL,
    ID_CARA INT NOT NULL,
    FOREIGN KEY (ID_PIEZA_DENTARIA) REFERENCES PIEZAS_DENTARIAS(ID),
    FOREIGN KEY (ID_CARA) REFERENCES CARAS(ID)
);

CREATE TABLE TRATAMIENTOS (
	ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    CODIGO CHAR(10) NOT NULL,
    DESCRIPCION VARCHAR(150) NOT NULL
);

CREATE TABLE ODONTOGRAMA (
	ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    DESCRIPCION VARCHAR(100) NOT NULL,
    TIPO_ODONTOGRAMA ENUM('Primaria', 'Secundaria') NOT NULL
);

CREATE TABLE ODONTOGRAMA_PIEZAS_DENTARIAS (
	ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    ID_ODONTOGRAMA INT NOT NULL,
    ARCADA ENUM('Superior Derecha', 'Superior Izquierda', 'Inferior Derecha', 'Inferior Izquierda') NOT NULL,
    ID_PIEZA_DENTARIA INT NOT NULL,
    FOREIGN KEY (ID_ODONTOGRAMA) REFERENCES ODONTOGRAMA(ID),
    FOREIGN KEY (ID_PIEZA_DENTARIA) REFERENCES PIEZAS_DENTARIAS(ID)
);


# -----------------------------------------------------------------------
# DATA
# -----------------------------------------------------------------------

-- INSERT INTO USER (USR_FIRST_NAME, USR_LAST_NAME, USR_EMAIL, USR_PASSWORD, USR_CREATED_DATE, USR_MODIFIED_DATE)
-- VALUES('John', 'Miller', 'user@javachap.com', 'javachap', now(), now());
-- INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Insurance', 'Insurance');
