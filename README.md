# Building

To build the module, use Maven's ```package``` goal:

```bash
mvn clean package
```

# Running 

To run the application, use Spring Boot's ```run```:

```
mvn spring-boot:run
```

# Authentication

Authentication was not included in the project. Can implement a ```OAuth2``` based authentication if little more time is given. 

# Documentation

Swagger documentation is enabled. Once the server is up and running, copy the contents of ```SwaggerDocumentation.json``` and 
use Swagger-Editor(https://editor.swagger.io) to view the UI documentation:

Note: Error in SwaggerUI after building the project. Hence the above workaround. 


