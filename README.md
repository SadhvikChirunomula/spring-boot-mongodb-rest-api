# Sample Mongo CRUD API

This is a sample Spring Boot project that demonstrates how to create a REST API with CRUD operations for a MongoDB database. The project uses Spring Boot and Spring Data MongoDB to provide a simple and clean API for managing data.

## Technologies Used
* Java
* Mongo

## How to run

Once you have installed these prerequisites, you can clone this repository to your local machine:

* First, clone the github repository
  ```bash
  git clone https://github.com/SadhvikChirunomula/spring-boot-mongodb-rest-api.git
  ```
* Run the below command to create a mongodb Database using Docker

    ```bash
    docker run -d --network host -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=example -e ME_CONFIG_MONGODB_URL=mongodb://root:example@mongo:27017/ -e MONGO_INITDB_DATABASE=test mongo
    ```

    Once done, you can connect to this mongo using the connection string `mongodb://root:example@localhost:27017/admin`

* Now, start this Java Spring Application. Your application has to run now without any issues. If you want to use a differenet mongo db, you can make the required change in resources/appliation.prperties file. THere, you can confiugre the mongo property using the key `spring.data.mongodb.uri`. If you want to run the application using mongo CLI, you can run the command `./mvnw spring-boot:run`


## How to Access

Once you are are able to run the applcation succesfully, you can access the api's in [http://localhost:8080](http://localhost:8080) and you can check the swagger documentation of API's in [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html#)