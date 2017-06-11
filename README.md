# Tickets-Server

Server of a movie tickets system powered by Spring & Thymeleaf.

## Build & Run

1. Download [Maven](http://maven.apache.org/download.cgi).

2. Run commands below:

    ```bash
    $ mvn clean
    $ mvn compile
    $ mvn tomcat7:run
    ```

    or

    ```bash
    $ python server.py
    ```

3. The application should be available at `http://localhost:8082/tickets`.

## the application contains basic functions of register and login user, add cinema or movie and search them by name
## remember to change the MySQL database user and password in SpringBusinessConfig
