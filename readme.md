#  API REST - Fondo de Bikini

##  Descripción

**API_Bob** es una API REST con temática de Bob Esponja, desarrollada con Spring Boot como proyecto de aprendizaje de backend. El objetivo principal es construir una API sólida que pueda ser consumida por un proyecto de frontend.

---

##  Características

- Arquitectura REST con operaciones CRUD completas
- Respuestas en formato JSON
- Paginación de resultados
- Manejo centralizado de errores con `@ControllerAdvice`
- Limitación de peticiones HTTP (Rate Limiting) con Bucket4j
- Vistas HTML dinámicas con Thymeleaf
- Soporte para múltiples bases de datos simultáneas
- Organización por capas: Controller, Service, Repository y Entity

---

##  Tecnologías utilizadas

| Tecnología | Versión | Uso |
|---|---|---|
| Java | 21 (LTS) | Lenguaje principal |
| Spring Boot | 4.0.6 | Framework backend |
| MySQL | 8 | Base de datos principal |
| Bucket4j | 8.10.1 | Rate Limiting |
| Thymeleaf | - | Plantillas HTML dinámicas |

---

##  Estructura del proyecto

El proyecto sigue una **arquitectura en capas** organizada por módulos o características (**Feature-based Package Structure**):

```
src/main/java/SerieBobEsponja/BobEsponja/
├── bds/
│   ├── FondoBikini/
│   │   ├── Personaje/
│   │   │   ├── PersonajeEntity.java       ← Entidad (modelo de datos)
│   │   │   ├── PersonajeRepository.java   ← Repositorio (acceso a datos)
│   │   │   ├── PersonajeService.java      ← Lógica de negocio
│   │   │   └── RESTPersonajeController.java ← Controlador REST
│   │   ├── Restaurante/
│   │   ├── Producto/
│   │   └── Pedido/
│   └── otro/ (Puedes borrarlo solo es  de prueba)
│       └── Feina/
├── config/
│   ├── MysqlConfig.java       ← Configuración BD principal
│   ├── OtroMysql.java         ← Configuración BD secundaria
│   ├── ApiRoutes.java         ← Centraliza las rutas de la API
│   └── RateLimitFilter.java   ← Filtro de rate limiting 
├── dbconfig/
│   ├── MysqlConfig.java       ← Configuración BD principal
│   └──OtroMysql.java         ← Configuración BD secundaria
│
├── Exception/
│   ├── GlobalExceptionHandler.java
│   └── ...
└── BobEsponjaApplication.java
```

---

##  Cómo ejecutar el proyecto

### Requisitos previos

- Java 21.0.8 LTS instalado
- MySQL Server instalado y corriendo
- IntelliJ IDEA (ide utilizado)

### Pasos

**1. Clona el repositorio:**
```bash
git clone https://github.com/Darwin518429/API_Bob.git
```

**2. Crea la base de datos:**

Con un cliente gráfico (MySQL Workbench) o por CLI ejecuta los scripts que encontrarás en la carpeta `sql/`:

**3. Configura las credenciales:**

Edita `src/main/resources/application-mysql.properties` con tus credenciales:

```properties
spring.datasource.primary.url=jdbc:mysql://localhost:3306/fondodebikini
spring.datasource.primary.username=TU_USUARIO
spring.datasource.primary.password=TU_CONTRASEÑA
```

**4. Ejecuta el proyecto:**

Desde IntelliJ: ejecuta `BobEsponjaApplication.java`


---

## Uso de la API

Una vez iniciada, la API estará disponible en:

```
http://localhost:8080
```

### Endpoints ejemplo 
| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/v1/personajes{?page=2}` | Lista todos los personajes (paginado) o por pagina |
| GET | `/api/v1/personajes/{id}` | Obtiene un personaje por ID |
| POST | `/api/v1/personajes` | Crea un nuevo personaje |
| PUT | `/api/v1/personajes/{id}` | Actualiza un personaje completo |
| DELETE | `/api/v1/personajes/{id}` | Elimina un personaje |

### Herramientas recomendadas para consumir la API

- Postman
- Bruno
- Cualquier aplicación frontend

---

##  Objetivo

Proyecto de aprendizaje de backend con Spring Boot, diseñado para ser consumido por un proyecto de frontend. El objetivo  es practicar conceptos como JPA, paginación, manejo de errores, múltiples bases de datos y Thymeleaf.

---

##  Autor

**Darwin518429**

GitHub: [https://github.com/Darwin518429](https://github.com/Darwin518429)