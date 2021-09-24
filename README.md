# Bất động sản (timdatnen.com)

### Environment requirement
- OpenJDK: 1.8.x
- Maven: 3.x.x
- Mysql: 5.x.x

### Install project
- Install project: `mvn clean install`

### Update env variable
- At path `.src/main/resources`, update each file for each environment
- Refer to file:
	+ local: `.src/main/resources/application-local.properties`
	+ develop: `.src/main/resources/application-dev.properties`
	+ staging: `.src/main/resources/application-staging.properties`
	+ production: `.src/main/resources/application-prod.properties`

### Development (For Developer)
- Run: `mvn spring-boot:run -Dspring-boot.run.profiles=local`

### Deploying the application for develop environment
- Run: `mvn spring-boot:run -Dspring-boot.run.profiles=dev`

### Deploying the application for staging environment
- Run: `mvn spring-boot:run -Dspring-boot.run.profiles=staging`

### Deploying the application for production environment
- Run: `mvn spring-boot:run -Dspring-boot.run.profiles=prod`
