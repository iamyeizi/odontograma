# ODONTOGRAMA PARA REGISTRO DE SALUD BUCAL

El objetivo es la creación de una página que permita registrar el odontograma de un paciente.

## 1 - Odontograma
Es un esquema gráfico o mapa de la boca en el que el dentista puede localizar todas

las piezas dentarias del paciente y realizar anotaciones, registrar tratamientos a realizar y tratamientos existentes previos a la consulta del paciente.

### Como se compone un odontograma?

El odontograma esta compuesto por las piezas dentarias que componen la dentadura de una persona Estas piezas pueden pertenecer a una dentición PRIMARIA (20 Piezas) o SECUNDARIA (32 piezas) y cada pieza se identifica con la siguiente numeración:

![](assets/imagen.png)

Piezas de la dentición primaria (del 51 en adelante)  

-INCISIVO CENTRAL  
-INCISIVO LATERAL  
-CANINO  
-PRIMER MOLAR  
-SEGUNDO MOLAR  
  
Piezas dentición secundaria (del 11 hasta el 48)  

-INCISIVO CENTRAL  
-INCISIVO LATERAL  
-CANINO  
-PRIMER PREMOLAR  
-SEGUNDO PREMOLAR  
-PRIMER MOLAR  
-SEGUNDO MOLAR  
-TERCER MOLAR  

La dentadura esta formada por dos grupos de dientes ANTERIORES y POSTERIORES, dentro de la primer clasificación se encuentran los INCISIVOS y LOS CANINOS, y en la segunda los PREMOLARES y MOLARES y estos pueden pertenecer a la arcada SUPERIOR o INFERIOR de la cavidad bucal.

Esta clasificación determina 4 cuadrantes que se representan en un odontograma

-ARCADA SUPERIOR DERECHA  
-ARCADA SUPERIOR IZQUIERDA  
-ARCADA INFERIOR DERECHA  
-ARCADA INFERIOR IZQUIERDA  

Cada registro que se realiza en un odontograma se debe indicar sobre que pieza dentaria y cara se registra la anotación o tratamiento

## 2 - Piezas Dentarias  

Partes: CORONA, RAÍZ Y CUELLO Y CARAS  
  
CARAS AXIALES PROXIMALES:  
-DISTAL  
-MESIAL  

CARAS AXIALES LIBRES:  
-VESTIBULAR  
-PALATINA  
-LINGUAL  
-LABIAL  

CARAS PERPENDICULARES:  
-INCISAL  
-OCLUSAL  

## 3 - Tratamientos/Extracciones

Los tratamientos existentes se registran en color Rojo sobre la cara indicada
Las extracciones o ausencias existentes se indican con una cruz roja sobre toda la pieza

Los tratamientos a realizar se registran en color Azul sobre la cara indicada
Las extracciones a realizar se indican con una cruz Azul sobre toda la pieza

Ejemplos de los tratamientos que se pueden realizar sobre piezas dentarias o caras de las mismas

"02.09" Reconstruccion de angulos: dientes anter  
"02.10" Composite compuesto con tornillo en cond  
"02.16" Lampara luz alogena  
"02.17" Lampara luz halógena  
"03.01" Trat. inflamatorio pulpar:UNIRR. (inc. Rx)  
"03.02" Trat. inflamatorio pulpar: MULTIRR.(inc. Rx)  
"03.05" Biopulpectomia parcial  
"03.06" Necropulpectomia parcial: MOMIFICACION  
"04.01.03" Corona Forjada  
"04.01.04" Corona colada  
"04.01.05" Corona colada con frente estÚtico  
"04.01.06" Corona espiga  
"04.01.07" Corona colada reves. De acrilico  

**ETAPA 1:** realizar el modelo de datos en MYSQL de las TABLAS MAESTRAS para la generación del odontograma.

Realizar el ABM de Piezas dentarias en formato Web con la especificación abajo indicada.

Dicho ABM debe desarrollarse utilizando el patrón MVC y las herramientas: Eclipse, J2EE (Java 8), Struts 1 (Preferentemente) y Tomcat 8.5

**Aclaraciones:** los nombres de campos en las tablas de la base de datos no es obligatorio manternerlos

Si detecta que pueden realizarse mejoras en el análisis y diseño coméntelo

Los tipos de datos Smallint que no pertenecen a una codificación definirlos como enumeraciones

En la segunda etapa se realizara la relación paciente-odontograma por lo que todas las tablas maestras deben estar creadas para seguir avanzando

A futuro las tablas requerirán campos de auditoría evalúe una opción a implementar.

**TABLA CARAS PIEZAS DENTARIAS**

- ID serial de la base de datos
- DESCRIPCION: Distal,Mesial, Vestibular, Palatina etc...
- TIPO: Axial Proximal, Axial Libre, Perpendiculares Smallint (1)

**TABLA y ABM PIEZAS DENTARIA**

- ID: serial de la base de datos
- NRO PIEZA: Entero las piezas se enumeran segun el grafico
- DESCRIPCION: Varchar(100) Por ejemplo INCISIVO CENTRAL
- TIPO DENTICION: Primaria/Secundaria Smallint (1) mostrar como desplegable
- GRUPO DENTARIO: Anterior/Posterior Smallint (1) mostrar como desplegable
- SUBGRUPO: Incisivos y Caninos si seleccion grupo Anterior y Premolares, Molares si selecciono grupo Posterior Smallint (1) mostrar como desplegable
- ARCADA: Arcadas superior/inferior derecha/izquierda Smallint (1) mostrar como desplegable

**TABLA PIEZAS DENTARIAS – CARAS:**

- ID serial de la base de datos
- IDPIEZADENTARIA (fk\_pieza\_dentaria)
- IDCARA (fk\_caras\_piezas\_dentaria)

CARAS (1 a N caras, registrar en una tabla a parte relacionada con piezas dentarias) lista múltiple o check box clasificado por tipo de cara

    CARAS AXIALES PROXIMALES
        DISTAL
        MESIAL
    CARAS AXIALES LIBRES
        VESTIBULAR
        PALATINA
        LINGUAL
        LABIAL
    CARAS PERPENDICULARES
        INCISAL
        OCLUSAL

**TABLA TRATAMIENTOS\_ODONTOLOGICOS**

- ID: (serial)
- CODIGO: char(10)
- DESCRIPCION varchar(150)

**TABLA ODONTOGRAMA**

- ID serial
- DESCRICION: varchar(100)
- TIPO ODONTOGRAMA: Dentición Primaria/Secundaria  Smallint (1)

**TABLA ODONTOGRAMA-PIEZAS DENTARIAS**

- ID serial
- IDODONTOGRAMA (fk\_tabla\_odontograma)
- ARCADA Arcadas superior/inferior derecha/izquierda Smallint (1)
- IDPIEZADENTARIA (fk\_tabla\_pieza\_dentaria)
