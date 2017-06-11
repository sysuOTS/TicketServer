 Tickets-Server

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

the server include basic functions of register and login, add movie or cinema, and search a cinema or movie by it's name.

