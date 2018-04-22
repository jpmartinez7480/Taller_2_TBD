# README #

Grupo 0 - Taller 2, Taller de Base de Datos 1-2018.

En este taller se agregó la base de datos de prueba "sakila".

Se agregaron los servicios GET y POST para la tabla film_actor.

Se corrigió el taller 1. La lista de actores se lee desde la base de 
datos sakila y no desde el archivo db.json. Además al crear un actor, 
este es agregado a la base de datos sakila, y no al archivo db.json.

Cabe destacar que en el archivo .gitignore se agregó la carpeta 
node_modules, así que para ejecutar el frontend se debe ejecutar
npm install.

Para correr la aplicación en el boot de spring ejecutar "gradle bootrun"

Para correr el frontend se debe ejecutar npm dev run desde la carpeta plantilla-vue, la cual se encuentra en la carpeta frontend del proyecto.
