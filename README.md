# LiterAlura

LiterAlura es un catálogo de libros en el cual la persona usuaria puede registrar libros en una base de datos y recibir información sobre estos libros que ya están registrados. Esta aplicación es una aplicación de consola desarrollada en Java utilizando Spring Boot y PostgreSQL.

## Requisitos

- Java 17
- Maven 3.6.0 o superior
- PostgreSQL

## Configuración del Proyecto

1. Clonar el repositorio:

   ```sh
   git clone https://github.com/tu-usuario/literalura.git
   cd literalura

Configurar la base de datos PostgreSQL. Asegúrate de tener PostgreSQL instalado y funcionando. Crea una base de datos llamada literalura.

Configurar las credenciales de la base de datos en src/main/resources/application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

Ejecutar la aplicación:

Desde IntelliJ IDEA:
Abre el proyecto en IntelliJ. Navega hasta la clase LiteraluraApplication. Haz clic derecho y selecciona Run 'LiteraluraApplication.main()'.

Desde la línea de comandos:
Navega al directorio raíz del proyecto (donde está ubicado el archivo pom.xml).Ejecuta mvn spring-boot:run.

Funcionalidades
La aplicación de consola LiterAlura permite las siguientes operaciones:

Buscar y registrar libro por título:
La persona usuaria ingresa el título del libro que desea buscar. La aplicación busca el libro en la API de Gutendex y, si lo encuentra, lo registra en la base de datos. Si el libro ya está registrado, informa a la persona usuaria que no puede registrar el mismo libro más de una vez.

Listar todos los libros registrados:
Muestra una lista de todos los libros que han sido registrados en la base de datos.

Listar autores vivos en un determinado año:
La persona usuaria ingresa un año y la aplicación muestra una lista de autores que estaban vivos en ese año.

Listar libros por idioma:
La persona usuaria ingresa un código de idioma (ES, EN, FR, PT) y la aplicación muestra una lista de libros registrados en ese idioma.

Salir:
Finaliza la ejecución de la aplicación.

Uso
Al ejecutar la aplicación, se mostrará un menú interactivo en la consola:

Seleccione una opción:
1. Buscar y registrar libro por título
2. Listar todos los libros registrados
3. Listar todos los autores registrados
4. Listar autores vivos en un determinado año
5. Listar libros por idioma
6. Salir
   
Ingrese el número de la opción que desea seleccionar y siga las instrucciones que se muestran en pantalla.

API de Gutendex
Esta aplicación utiliza la API de Gutendex para buscar libros por título. Para más información sobre la API de Gutendex, visite gutendex.com.

Contribuir

Las contribuciones son bienvenidas. Para contribuir, siga estos pasos:

Fork el repositorio.

Cree una nueva rama (git checkout -b feature-nueva-funcionalidad).
Realice los cambios necesarios y haga commit (git commit -am 'Agregar nueva funcionalidad').
Push a la rama (git push origin feature-nueva-funcionalidad).
Cree un nuevo Pull Request.

Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulte el archivo LICENSE para más detalles.

Este README incluye una descripción del proyecto, instrucciones de configuración y ejecución, una explicación de las funcionalidades, y detalles sobre cómo contribuir al proyecto. Puedes ajustarlo según tus necesidades y agregar cualquier información adicional que consideres relevante.
