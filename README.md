# Backend MyPlace

Backend de la aplicación MyPlace - Sitio para realizar reservas de alojamiento al estilo AirBnB.

## Compilación

```
mvn clean package
```

## Ejecución

```
java -jar target/myplace-0.0.1-SNAPSHOT.jar --spring.profiles.active=[profile]

Ej. [profile]=dev-h2
```

## Documentación
La aplicación utiliza la siguiente extension para generar documentación en forma online y offline.

```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
</dependency>
```

De forma online, al levantar la aplicación, se puede acceder a `[url]:[puerto]/swagger-ui/index.html`

## Profiles

Ambiente de desarrollo
```
 [profile]=dev-h2
```

Ambiente productivo
```
 [profile]=prod
```
