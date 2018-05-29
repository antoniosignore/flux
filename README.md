# Air Flux Capacity


## Installation
This project requires JDK 8 and maven for building and testing it. 

Install Java on linux using this command:

    sudo apt-get install openjdk-8-jdk
    
Install maven    
    
    sudo apt-get install maven
 
## How to build
 
    mvn clean package

Code coverage is executed by Jacoco in the build process. 

The results are in an HTML page generated under :
    
    target/site/jacoco/index.html

Code coverage that matters are the controller and the service layer :

    com	87% (14/16)	81% (56/69)	79% (197/248)

## How to test

    mvn clean test
    
Test results are located at:
    
    target/surefire-reports    

## Design

The test has been designed pragmatically with few assumptions in order to showcase the
most boilerplate NFR (non functional requirements) as well as provide the expected results, of course.

The feature set includes:

* Swagger definition : 

    http://localhost:8080/swagger-ui.html

* Log aspect: each method is traced with its actual parameters

* Stacked layer design composed of:

    - 2.0.2.RELEASE (Java)
    - controller layer spring MVC with RestControllers
    - service layer
    - spring data repositories
    - hibernate persistence
    - DTO beans for rest i/o
    - Mapper to convert entito/dto

## how to run it:

    java -jar target/tos-0.0.1.jar
    (make sure port 8080 is available)
  
## Assumptions

The test makes some assumptions and has limitations:

    - Swagger definition should be cleaner and better execptions management mapped to proper http status
    - Date management should be improved: no references to old Java Date class should presents. 
    - I assumed the dates were in UTC time but the reports in TimeZOn format CET (with DST). However it is
      possible that London pilot may have wanted the response in London time zone. It was not specified clearly
      in the specs to I decided to stick for time constraints reason to CET formatting only