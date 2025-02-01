# Bootcamp PowerUp API Pragma

Este proyecto es el backend desarrollado durante el Bootcamp OnClass de Pragma en 2024. Proporciona una API RESTful construida con [especificar tecnología, por ejemplo, Spring Boot] para [describir brevemente la funcionalidad principal, por ejemplo, "gestionar un sistema de reservas", "administrar un catálogo de productos", etc.].

## Características

- **Gestión de [especificar recursos, por ejemplo, "usuarios", "productos", "pedidos"]**: [Describir brevemente las operaciones principales, por ejemplo, "crear, leer, actualizar y eliminar registros de usuarios."].
- **Autenticación y Autorización**: [Describir el método utilizado, por ejemplo, "implementación de JWT para la autenticación de usuarios."].
- **Validación de Datos**: [Mencionar si se utilizan validaciones, por ejemplo, "validación de entradas del usuario para garantizar la integridad de los datos."].
- **Manejo de Errores**: [Describir cómo se manejan los errores, por ejemplo, "gestión centralizada de excepciones para respuestas coherentes."].

## Requisitos Previos

- **Java 17**: Asegúrate de tener instalada la versión 17 de Java.
- **Gradle**: Utilizado como herramienta de construcción del proyecto.
- **Base de Datos**: MySQL para creación de tablas y gestión de datos.

## Instalación

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/Calvinnn23/Bootcamp-PowerUp-API-Pragma.git
   cd Bootcamp-PowerUp-API-Pragma
   ```

2. **Configuración de la Base de Datos**:

   - Crea una base de datos llamada `db_onclass`.
   - Configura las credenciales de la base de datos en el archivo `src/main/resources/application.properties`:

     ```properties
     spring.datasource.url=jdbc:[tipo_bd]://localhost:5432/db_onclass
     spring.datasource.username=root
     spring.datasource.password=1234
     ```

3. **Construir y Ejecutar la Aplicación**:

   - Compila el proyecto:

     ```bash
     ./gradlew build
     ```

   - Ejecuta la aplicación:

     ```bash
     ./gradlew bootRun
     ```

   La API estará disponible en `http://localhost:8080`.

## Uso

Proporciona ejemplos de cómo interactuar con la API, por ejemplo, utilizando herramientas como Postman.



