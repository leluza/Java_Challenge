# Java_Challenge

Implementacion de API REST en Java Spring Boot.

Objetivo Desarrollar una API para explorar el mundo de Disney, la cual permitirá conocer y modificar los personajes que lo componen y entender en qué películas estos participaron. Por otro lado, deberá exponer la información para que cualquier frontend pueda consumirla.

Modelado de Base de Datos ● Personaje : deberá tener, ○ Imagen. ○ Nombre. ○ Edad. ○ Peso. ○ Historia. ○ Películas o series asociadas.

Listado de Personajes El listado deberá mostrar: ● Imagen. ● Nombre. El endpoint deberá ser: ● /characters

Creación, Edición y Eliminación de Personajes (CRUD) Deberán existir las operaciones básicas de creación, edición y eliminación de personajes. 5. Detalle de Personaje En el detalle deberán listarse todos los atributos del personaje, como así también sus películas o series relacionadas.

Búsqueda de Personajes Deberá permitir buscar por nombre, y filtrar por edad, peso o películas/series en las que participó. Para especificar el término de búsqueda o filtros se deberán enviar como parámetros de query: ● GET /characters?name=nombre ● GET /characters?age=edad ● GET /characters?movies=idMovie

Nuevas incorporaciones


Modelado de Base de Datos
Película o Serie : deberá tener,
○ Imagen.
○ Título.
○ Fecha de creación.
○ Calificación (del 1 al 5).
○ Personajes asociados.

● Género: deberá tener,
○ Nombre.
○ Imagen.
○ Películas o series asociadas

 Listado de Películas
Deberá mostrar solamente los campos imagen, título y fecha de creación.
El endpoint deberá ser:
● GET /movies

Detalle de Película / Serie con sus personajes
Devolverá todos los campos de la película o serie junto a los personajes asociados a la misma

Creación, Edición y Eliminación de Película / Serie
Deberán existir las operaciones básicas de creación, edición y eliminación de películas o series.

Búsqueda de Películas o Series
Deberá permitir buscar por título, y filtrar por género. Además, permitir ordenar los resultados por
fecha de creación de forma ascendiente o descendiente.
El término de búsqueda, filtro u ordenación se deberán especificar como parámetros de query:
● /movies?name=nombre
● /movies?genre=idGenero
● /movies?order=ASC | DESC
