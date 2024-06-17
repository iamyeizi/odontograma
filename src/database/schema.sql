DROP DATABASE IF EXISTS odontograma;
CREATE DATABASE odontograma;
USE odontograma;

# -----------------------------------------------------------------------
# TABLES
# -----------------------------------------------------------------------

CREATE TABLE PACIENTES (
    ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    NRODOC INT NOT NULL,
    TIPODOC ENUM('DNI', 'L. Enrolamiento', 'L. Civica', 'C. Identidad') NOT NULL,
    NOMBRE VARCHAR(100) NOT NULL,
    APELLIDO VARCHAR(100) NOT NULL,
    FECHA_NACIMIENTO DATE NOT NULL,
    GENERO ENUM('Masculino', 'Femenino', 'Otro') NOT NULL,
    DOMICILIO VARCHAR(150),
    EMAIL VARCHAR(100) NOT NULL,
    TELEFONO VARCHAR(100)
);

CREATE TABLE ODONTOGRAMA (
	ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    DESCRIPCION VARCHAR(100),
    TIPO_ODONTOGRAMA ENUM('Primaria', 'Secundaria') NOT NULL,
    ID_PACIENTE INT NOT NULL,
    FOREIGN KEY (ID_PACIENTE) REFERENCES PACIENTES(ID),
    CONSTRAINT UNIQ_ODONTOGRAMA UNIQUE (ID_PACIENTE, TIPO_ODONTOGRAMA)
);

CREATE TABLE PIEZAS_DENTARIAS (
	ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    NRO_PIEZA INT NOT NULL,
    DETALLE VARCHAR(100) NOT NULL,
    TIPO_DENTICION ENUM('Primaria', 'Secundaria') NOT NULL,
    GRUPO_DENTARIO ENUM('Anterior', 'Posterior') NOT NULL,
    SUBGRUPO ENUM('Incisivos', 'Caninos', 'Premolares', 'Molares') NOT NULL,
    ARCADA ENUM('Superior Derecha', 'Superior Izquierda', 'Inferior Derecha', 'Inferior Izquierda') NOT NULL,
    ESTADO BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE ODONTOGRAMA_PIEZAS_DENT (
	ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    ID_ODONTOGRAMA INT NOT NULL,
    ARCADA ENUM('Superior Derecha', 'Superior Izquierda', 'Inferior Derecha', 'Inferior Izquierda') NOT NULL,
    ID_PIEZA_DENTARIA INT NOT NULL,
    FOREIGN KEY (ID_ODONTOGRAMA) REFERENCES ODONTOGRAMA(ID),
    FOREIGN KEY (ID_PIEZA_DENTARIA) REFERENCES PIEZAS_DENTARIAS(ID)
);

CREATE TABLE CARAS (
	ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    DETALLE ENUM('Distal', 'Mesial', 'Vestibular', 'Lingual/Palatina', 'Labial', 'Incisal', 'Oclusal') NOT NULL,
    TIPO ENUM('Axial Proximal', 'Axial Libre', 'Perpendiculares') NOT NULL,
    CONSTRAINT CHECK_TIPO 
        CHECK (
            (TIPO = 'Axial Proximal' AND DETALLE IN ('Distal', 'Mesial')) OR
            (TIPO = 'Axial Libre' AND DETALLE IN ('Vestibular', 'Lingual/Palatina', 'Labial')) OR
            (TIPO = 'Perpendiculares' AND DETALLE IN ('Incisal', 'Oclusal'))
        )
);

CREATE TABLE TRATAMIENTOS (
	ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
    CODIGO CHAR(10) NOT NULL,
    DESCRIPCION VARCHAR(150) NOT NULL
);

CREATE TABLE PIEZASDENT_CARAS_TRAT (
    ID_PIEZA_DENTARIA INT NOT NULL,
    ID_CARA INT NOT NULL,
    ID_TRATAMIENTO INT NOT NULL,
    FOREIGN KEY (ID_PIEZA_DENTARIA) REFERENCES PIEZAS_DENTARIAS(ID),
    FOREIGN KEY (ID_CARA) REFERENCES CARAS(ID),
	FOREIGN KEY (ID_TRATAMIENTO) REFERENCES TRATAMIENTOS(ID),
	PRIMARY KEY (ID_PIEZA_DENTARIA, ID_CARA, ID_TRATAMIENTO)
);


# -----------------------------------------------------------------------
# DATA
# -----------------------------------------------------------------------

-- INSERT INTO USER (USR_FIRST_NAME, USR_LAST_NAME, USR_EMAIL, USR_PASSWORD, USR_CREATED_DATE, USR_MODIFIED_DATE)
-- VALUES('John', 'Miller', 'user@javachap.com', 'javachap', now(), now());
-- INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Insurance', 'Insurance');
