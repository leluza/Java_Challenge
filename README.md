# Java_Challenge

Implementacion de API REST en Java Spring Boot.

Objetivo
Desarrollar una API para explorar el mundo de Disney, la cual permitirá conocer y modificar los
personajes que lo componen y entender en qué películas estos participaron. Por otro lado, deberá
exponer la información para que cualquier frontend pueda consumirla.

 Modelado de Base de Datos
● Personaje : deberá tener,
○ Imagen.
○ Nombre.
○ Edad.
○ Peso.
○ Historia.
○ Películas o series asociadas.

 Listado de Personajes
El listado deberá mostrar:
● Imagen.
● Nombre.
El endpoint deberá ser:
● /characters

Creación, Edición y Eliminación de Personajes (CRUD)
Deberán existir las operaciones básicas de creación, edición y eliminación de personajes.
5. Detalle de Personaje
En el detalle deberán listarse todos los atributos del personaje, como así también sus películas o
series relacionadas.

Búsqueda de Personajes
Deberá permitir buscar por nombre, y filtrar por edad, peso o películas/series en las que participó.
Para especificar el término de búsqueda o filtros se deberán enviar como parámetros de query:
● GET /characters?name=nombre
● GET /characters?age=edad
● GET /characters?movies=idMovie
