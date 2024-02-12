# AxelTaskApi

Task is to write an application which exposes a simple REST API.

## Features

- The implementation should fetch the data from two or more different REST endpoints.
- It should combine the data and return a single response.

## Getting Started using IDE

To run the application locally, you'll need Java and Maven installed on your system.

1. Clone this repository:

``` https://github.com/NitinKVerma/AxelTaskApi.git ```

2. Navigate to the project directory:
``` AxelTaskApi```

3. Run the application using Maven:

   You can run it directly from IntelliJ IDEA or your preferred IDE, or you can use Maven to package and run the application from the command line.

``` mvn spring-boot:run```


4. Once the application is running, you can access the API at:
``` http://localhost:8080/api/getUserDetails/1 ```

- You can change the Path variable as needed [1..10]
- Other input will show proper validation (as User not Found)


## Getting Started using Docker

To run the application locally, you'll need to have docker installed

1. Clone this repository:

``` https://github.com/NitinKVerma/AxelTaskApi.git ```

2. Navigate to the project directory:
``` AxelTaskApi```

4. Build the application using Docker:
``` docker build -t axelapi-1.0 . ```

5. Run the application using Docker:
``` docker run -p 8080:8080 axelapi-1.0 . ```

6. Once the application is running, you can access the API at:
``` http://localhost:8080/api/getUserDetails/1 ```

- You can change the Path variable as needed [1..10]
- Other input will show proper validation (as User not Found)


## Dependencies

- Spring Boot
- Spring WebFlux
