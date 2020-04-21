# webservice-springboot2-java11
# My web services project with Spring Boot and JPA / Hibernate
## Goals
1. Create Spring Boot Java project
1. Implement domain model
1. Structure logical layers: resource, service, repository
1. Configure test database (H2)
1. Populate the database
1. CRUD - Create, Retrieve, Update, Delete
1. Exception handling

###
![Screenshot_1](https://user-images.githubusercontent.com/59379254/79910798-b24f7780-83f5-11ea-8fc5-5dde8ecbe7b2.png)
###
![Screenshot_2](https://user-images.githubusercontent.com/59379254/79910801-b2e80e00-83f5-11ea-884a-9180421561f6.png)
###
![Screenshot_3](https://user-images.githubusercontent.com/59379254/79910802-b2e80e00-83f5-11ea-975b-cf5daf0655c0.png)
###
![Screenshot_4](https://user-images.githubusercontent.com/59379254/79910803-b380a480-83f5-11ea-8bfd-ac657e7f3277.png)
###

## Project created
- Checklist:
- [X] File -> New -> Spring Starter Project
1. Maven
1. Java 11
1. Packing JAR
1. Dependencies: Spring Web Starter

## User entity and resource
- Basic entity checklist:
- [X] Basic attributes
- [X] Associations (instantiate collections)
- [X] Constructors
- [X] Getters & Setters (collections: only get)
- [X] hashCode & equals
- [X] Serializable

## H2 database, test profile, JPA
- Checklist:
- [X] JPA & H2 dependencies
- [X] application.properties
- [X] application-test.properties
- [X] Entity: JPA mapping
- Dependencies:
~~~XML
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
~~~
- application.properties:
~~~xml
spring.profiles.active=test
spring.jpa.open-in-view=true
~~~
- application-test.properties:
~~~xml
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
~~~

## JPA repository, dependency injection, database seeding
- Checklist:
- [x] UserRepository extends JPARepository<User, Long>
- [x] Configuration class for "test" profile
- [x] @Autowired UserRepository
- [x] Instantiate objects in memory
- [x] Persist objects
- Objects:
~~~java
User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
~~~

## Service layer, component registration

## Order, Instant, ISO 8601
- Basic new entity checklist:
- [x] Entity
1. "To many" association, lazy loading, JsonIgnore
- [x] Repository
- [x] Seed
- [x] Service
- [x] Resource
- Objects:
~~~java
Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
~~~

## OrderStatus enum

## Category
- Objects:
~~~java
Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
~~~

## Many-to-many association with JoinTable
- in commits

## OrderItem, many-to-many association with extra attributes
- Checklist:
- [x] OrderItemPK
- [x] OrderItem
- [x] Order one-to-many association
- [x] Seed
- Objects:
~~~java
OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
~~~

## Product-OrderItem one-to-many association
- in commits

## Payment, one-to-one association
- in commits

## Subtotal & Total methods
- in commits

## User insert
- Checklist:
- [x] UserService
- [x] UserResource
- Test:
~~~sql
{
	"name": "Bob Brown",
	"email": "bob@gmail.com",
	"phone": "977557755",
	"password": "123456"
}
~~~

## User delete
- Checklist:
- [x] UserService
- [x] UserResource

## User update
- Checklist:
- [x] UserService
- [x] UserResource
- Test:
~~~sql
{
"name": "Bob Brown",
"email": "bob@gmail.com",
"phone": "977557755"
}
~~~

## Exception handling - findById
- Checklist:
- [x] NEW CLASS: services.exceptions.ResourceNotFoundException
- [x] NEW CLASS: resources.exceptions.StandardError
- [x] NEW CLASS: resources.exceptions.ResourceExceptionHandler
- [x] UserService

## Exception handling - delete
- Checklist:
- [x] NEW CLASS: services.exceptions.DatabaseException
- [x] ResourceExceptionHandler
- [x] UserService
1. EmptyResultDataAccessException
1. DataIntegrityViolationException

## Exception handling - update
- Checklist:
- [x] UserService
1. EntityNotFoundException

## Create Heroku app & provision PostgreSQL
- Checklist:
- [x] Heroku Sign Up
- [x] Create app
- [x] Provision PostgreSQL
1. App dashboard -> Resources
1. Search "postgres" -> select "Heroku Postgres"

## Install local PostgreSQL
- Checklist:
- [x] Download and install: https://www.postgresql.org/download/
1. Super user: postgres
1. Password: 1234567
1. Port: 5432
- [x] Start/stop service: Task manager -> Services
- [x] Check instalation
1. Start pgAdmin
1. Databases -> Create -> Database
- [x] Encoding: UTF8

## Dev profile
- Checklist:
- [x] PgAdmin: create local database: create database springboot_course
- [x] Add PostgreSQL Maven dependency
~~~xml
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>
~~~
- [x] Create file: application-dev.properties
~~~xml
spring.datasource.url=jdbc:postgresql://localhost:5432/springboot_course
spring.datasource.username=postgres
spring.datasource.password=1234567

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

jwt.secret=MYJWTSECRET
jwt.expiration=3600000
~~~
- [x] Update application.properties: spring.profiles.active=dev
- [x] Run application

## Get SQL script from local PostgreSQL
- [x] PgAdmin: get SQL script:
1. Select database
1. Tools -> Backup
- [x] Format: Plain
- [x] Encoding: UTF8
- [x] Dump options:
- [x] Only schema: YES
- [x] Blobs: NO
- [x] Do not save: (ALL)
- [x] Verbose messages: NO
- [x] Delete instructions before CREATE statements

## Run SQL Script
- Checklist:
- [x] App dashboard -> Settings - > Config Vars
- EXAMPLE:
~~~XML
postgres://wavglvupbdad:358f443aafe452eca4c58fbc15d02e50b08130c7aaea3aff6c4f59c
13f9abb@ec2-23-21-106-266.compute-1.amazonaws.com:5432/d7u9ub86cdsu
user: wavglvupbdad
password: 358f443aafe452eca4c58fbc15d02e50b08130c7aaea3aff6c4f59c13f9abb
server: ec2-23-21-106-266.compute-1.amazonaws.com
port: 5432
database: d7u9ub86cdsu
~~~
- [x] PgAdmin: Servers -> Create -> Server
1. Advanced -> DB rescriction: (database)
- [x] Database -> Query Tool
1. Load and run SQL Script

## Deploy app to Heroku
- [x] Heroku app dashboard -> Deploy
~~~ts
heroku git:remote -a myapp
git remote -v
~~~
- [x] Setup Heroku app Config Vars
1. DATABASE_URL
1. JWT_EXPIRATION
1. JWT_SECRET
- [x] Create: application-prod.properties
~~~xml
spring.datasource.url=${DATABASE_URL}

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false

jwt.secret=${JWT_SECRET}
jwt.expiration=${JWT_EXPIRATION}
~~~

## Update application.properties: spring.profiles.active=prod
- [x] Create files: system.properties
1. java.runtime.version=11
- [x] Send to Heroku:
1. git add .
1. git commit -m "Deploy app to Heroku"
1. git push heroku master
