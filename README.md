<h1 align="center">
User Service Nisum
</h1>

<h4 align="center">Backend Developer Reto.</h4>
<h4 align="center">Claudio Alfredo Palomino Yangua.</h4>

<p align="center">
    <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v17-blue.svg" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/badge/Spring%20Boot-v3.0.2-brightgreen.svg" />
    </a>
    <a alt="H2">
        <img src="https://img.shields.io/badge/H2-v1.4.200-brightgreen.svg" />
    </a>
    <a alt="JPA">
        <img src="https://img.shields.io/badge/JPA-v3.0.2-brightgreen.svg" />
    </a>
    <a alt="OpenApi">
        <img src="https://img.shields.io/badge/Open%20Api-v3-blue.svg" />
    </a>
    <a alt="Jacoco">
        <img src="https://img.shields.io/badge/jacoco-v0.8.6-blue.svg" />
    </a>
    <a alt="Gradle">
        <img src="https://img.shields.io/badge/gradle-v7.6-blue.svg" />
    </a>
</p>

## Tabla de contenido ##

1. [Objetivo](#Objetivo)
2. [Documentación del API](#Documentación-del-API)
3. [Base de datos](#Base-de-datos)
4. [Aplicación](#Aplicación)
5. [Diagrama la solución](#Diagrama-de-la-solución)

## Objetivo

Reto por parte de NISUM para crear un servicio de creación y/o registro de usuarios.

** Las credenciales usadas en este proyecto son de uso de prueba netamente local.

## Documentación del API

Se puede acceder a la documentación del servicio desde el contrato OpenAPI:

> http://localhost:9091/nisum/v1/swagger-ui
> http://localhost:9091/nisum/v1/api-docs

## Base de datos

- Acceso a la consola H2:

> http://localhost:9091/nisum/v1/h2-console
> <br>
> jdbc url = jdbc:h2:mem:userservicedb <br>
> User Name = nisum <br>
> Password = nisum2023

![console-h2](docs/bd/console-h2.png)

- Diagrama BD

![diagrama-bd](docs/bd/user-service-db-diagram.png)

- Script BD [script-bd](docs/bd/scripts.sql)

## Aplicación

### Ejecución del proyecto - local

### Pre- Requisitos

- Jdk 17
- Gradle 7.6

El proyecto maneja un Gradle embebido por tal razón, solo se necesita tener instalar en el entorno
local el JDK 17

### Ejecutando el servicio localmente

1. Realizar un clone del proyecto
   user-service-challenge [git-servicio](https://github.com/cpalominoy/user-service-challenge.git)
2. Importar el proyecto desde el IDE de preferencia, teniendo en consideración que el build es via
   Gradle
3. Ejecutar los comando **./gradlew build **
4. Ejecutar (Run) la clase principal UserServiceChallengeApplication.class o ejecutar **./gradlew
   bootrun **
5. Una vez levantado el servicio, se ejecutará la BD H2 en memoria.

### Ejecutando Pruebas

1. Se puede importar el [colecction postman](docs/postman/Nisum-Challenge.postman_collection.json)

#### 1.- Registrar Cliente

- El correo debe cumplir el formato aaaaaaa@dominio.cl
- La contraseña debe contener:
    - Al menos un carácter en mayúscula
    - Al menos un carácter en minúscula
    - Al menos un carácter especial
    - Al menos un digito
- Todos los campos del Request son requeridos

##### curlRequest

```shell
curl --location 'http://localhost:9091/nisum/v1/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"Alfredo Palomino",
    "email":"alfredo.palomino@gmail.com",
    "password": "Alfredo123**",
    "phones": [
        {
          "number": "987456123",
          "cityCode": "1",
          "countryCode": "2"  
        }
    ]
}'

```

##### Response

```json
{
  "id": "89c4ee97-76f6-42fe-97cb-e0733406c2b0",
  "name": "Alfredo Palomino",
  "email": "alfredo.palomino@gmail.com",
  "phones": [
    {
      "number": "987456123",
      "cityCode": "1",
      "countryCode": "2"
    }
  ],
  "created": "2023-02-25T15:16:29.973255",
  "modified": "2023-02-25T15:16:29.973255",
  "lastLogin": "2023-02-25T15:16:29.973255",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGZyZWRvLnBhbG9taW5vQGdtYWlsLmNvbSIsImlhdCI6MTY3NzM1NjE4OSwiZXhwIjoxNjc3NDQyNTg5fQ.34VcKdyQ5dcQydvzqtNPlfNu5nwWIhKToiAjIIsdlys",
  "active": true
}
```

##### Variantes de respuesta - Error

- Si un usuario ya se encuentra registrado previamente

```json
{
  "message": "El correo ya se encuentra registrado"
}
```

- Cuando el campo email no cumple con el formato válido.

```json
{
  "email": "Email no cumple con el formato valido"
}
```

- Cuando el campo password no cumple con el formato válido.

```json
{
  "password": "Password debe cumplir formato (digito,minúscula,mayúscula,carácter especial y número)"
}
```

## Diagrama de la solución

- Diagrama de componentes del proyecto
  ![diagrama-modulos](docs/diagram/user_service_changelle_module_class.png)

- Diagrama de flujo de la solución
  ![diagrama-flujo](docs/diagram/Diagrama-Flujo-Registro-Usuario.jpg)