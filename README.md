
![Programação-Desafío](https://github.com/genesysR-dev/2066-desafio-persistiendo-datos-artistas-canciones/assets/91544872/6675312c-06e9-4a44-a869-683c332dcd71)

# Desafío
Vamos a implementar una aplicación para almacenar datos de nuestros artistas y canciones preferidas en una base de datos relacional, pudiendo buscar información por artistas y consultar datos sobre los mismos a través de integración con la API de ChatGPT.

Necesitarás una clase Artista, con los datos para representar el mismo;
También será necesario una clase específica para representar las canciones;
Para el artista, puedes practicar la implementación de un enum, para definir el tipo de artista, por ejemplo: solista, dúo o banda;
Recuerda crear el proyecto a través del sitio [Spring Initializr](https://start.spring.io/), donde ya es posible añadir las dependencias de Spring Data JPA y PostgreSQL;
Crea una clase principal con el menú, con las opciones deseadas, como: registrar artista, registrar canción, buscar canciones por artistas, etc;
Recuerda extender CommandLineRunner en la clase de Spring, sobrescribiendo el método run para llamar al menú creado.

## 🔨 Objetivos del proyecto

- El objetivo del proyecto es practicar la modelización de clases y relaciones utilizando Spring Data JPA;
- Es importante describir e implementar correctamente la relación entre Artista y Canción, dado que un artista puede estar asociado a más de una canción;
- Una canción solo debe ser guardada en la base de datos si el Artista ha sido previamente registrado;
- Practicaremos consultas derivadas y JPQL para verificar si el artista ya está registrado y buscar canciones por un determinado artista;
- Realizaremos la integración con la API de ChatGPT para buscar información sobre un determinado artista.

### ¡Buen desafío! 



