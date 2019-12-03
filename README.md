# spring-boot-mysql-docker-rest-api
Building RESTFul API Services using spring boot, MySQL and Swagger Documentation with containerization using Docker

Steps for executing :

1. Clone/Download the repository.

2. Open the project in the IDE (Netbeans/Intellij Idea/Eclipse) and generate the executable .jar file for the application. The alternate method to generate the .jar file is through Maven.
   
3. Open **docker-compose.yml** file and add the MySQL (db) environment parameter values and Spring REST API environment parameter values for database connection from the the application.

4. Open the terminal and go to the directory where docker-compose.yml is located and run the below command in -d (Detach Mode) and will build the MySQL and Spring Boot Rest API Containers.

   		docker-compose up -d

6. Run the below command to get the list of running containers :

		  docker ps
    
7. After executing above steps without any errors and docker containers are up and running, open the browser and navigate to below url:
    
		  http://localhost:8080/swagger-ui.html#/

**Troubleshooting**
1. Any errors related to "connection link failure" is seen while starting/running containers then it might be due to the  MySQL hostname use in the application database connection. Run the below command to get the hostname of the MySQL and replace it

  		  docker inspect {CONTAINER-ID}
2. Get image of Java,Mysql,Docker-Compose	
	
**References**
1. https://start.spring.io/ 
2. https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
3. https://docs.docker.com/compose/
4. https://swagger.io/tools/swagger-ui/
5. https://spring.io/guides/gs/rest-service/

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.1.11.BUILD-SNAPSHOT/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)





