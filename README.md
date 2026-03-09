# 💬 Foro Hub - API RESTful

Foro Hub es una API REST construida con **Spring Boot** que replica el backend de un foro de discusión. Permite a los usuarios crear, visualizar, actualizar y eliminar tópicos (CRUD completo), implementando estrictas reglas de negocio y un sistema de seguridad avanzado basado en tokens.

## 🚀 Funcionalidades Principales

* **CRUD de Tópicos:** Operaciones completas para la gestión de hilos de discusión.
* **Validaciones Integradas:** Uso de Bean Validation para asegurar la integridad de los datos entrantes.
* **Prevención de Duplicados:** Reglas de negocio que impiden registrar tópicos con el mismo título y mensaje.
* **Paginación y Ordenamiento:** Listado de tópicos optimizado y paginado nativamente desde la base de datos.
* **Seguridad Stateless:** Autenticación y autorización mediante **Spring Security y JSON Web Tokens (JWT)**.
* **Migraciones de Base de Datos:** Control de versiones del esquema de base de datos utilizando **Flyway**.
* **Documentación Interactiva:** Interfaz gráfica autogenerada con **Springdoc OpenAPI (Swagger)**.

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot 3
* **Persistencia:** Spring Data JPA / Hibernate
* **Base de Datos:** PostgreSQL
* **Migraciones:** Flyway
* **Seguridad:** Spring Security + Auth0 java-jwt
* **Documentación:** Springdoc OpenAPI

## ⚙️ Arquitectura y Buenas Prácticas

El proyecto sigue un diseño estructurado y orientado a dominio (DDD) de forma simplificada:
* **Separación por Capas:** Controladores, Dominio (Entidades, Repositorios, Records/DTOs) e Infraestructura (Seguridad, Errores, Documentación).
* **Uso de DTOs:** Implementación de `Records` de Java para aislar las entidades de la base de datos de la capa web.
* **Gestión de Transacciones:** Uso de `@Transactional` para garantizar operaciones ACID en la base de datos.
* **Programación Defensiva:** Interceptores (`OncePerRequestFilter`) para la validación de tokens en cada petición.

## 🚦 Configuración Local

1. Clona el repositorio:
   ```bash
   git clone [https://github.com/d27pomaramirez-lab/challenge-forohub.git](https://github.com/d27pomaramirez-lab/challenge-forohub.git)
2. Configura tu base de datos PostgreSQL.
3. Define las siguientes variables de entorno en tu sistema o IDE:
* **DB_NAMES**: Nombre de la base de datos (ej. forohub).
* **DB_USER**: Tu usuario de PostgreSQL.
* **DB_PASSWORD**: Tu contraseña.
* **JWT_SECRET**: Semilla secreta para firmar los tokens (ej. mi_secreto_super_seguro).
4. Ejecuta la aplicación. Flyway creará las tablas automáticamente.
5. Inserta un usuario de prueba en la tabla usuarios (Asegúrate de encriptar la contraseña con BCrypt).
6. Accede a la documentación de la API en: http://localhost:8080/swagger-ui/index.html

### Tecnologías utilizadas
<img width="40" height="40" alt="intellij" src="https://github.com/user-attachments/assets/b0894a96-b4c2-46b9-96f9-407a3fd1caee" /> <img width="40" height="40" alt="java" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJEYp53vIyZaY3wclh9alfY8bK1UxUTFJ6XA&s" /> <img width="80" height="40" alt="spring boot" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFI6sUZcQuM50ahwUCFQCOZFoNLhFXEWRpdg&s"/> <img width="40" height="40" alt="postgresql" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpFeH0JLPMUsGx0884gXEah8T2yibDGtCQiA&s" /> <img width="80" height="40" alt="java" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNSMudxx-dF3ycE2NljBxdQLN7opdhy3PWjQ&s"/>

### Desarrollador

| [<img src="https://avatars.githubusercontent.com/u/224181779?s=400&u=b542509272eef999a81a70ad84b7084ea4ab8740&v=4" width=115><br><sub>Poma Ramirez Diego</sub>](https://github.com/d27pomaramirez-lab) 
