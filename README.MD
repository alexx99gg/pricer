# Pricer
Pricer is a demo project to showcase my spring capabilities.\
`pricer-api` is a microservice that exposes an api to get prices for a specific product from a specific brand at the given time.


This microservice connects to a postgreSQL database to obtain the price information, it doesn't need write permission to the DB as it doesn't make any write operation.\
For testing, it uses a H2 database where a set of sample prices are stored.

To deploy the project and the necessary DB, please follow the Dockerized deployment instructions:
1. `cd pricer-api`
2. `mvn clean package`
3. `cd ..`
4. `docker-compose build`
5. `docker-compose up`

pricer-api exposed at http://localhost:8080\
Swagger available at http://localhost:8080/swagger-ui/index.html\
postgreSQL exposed at localhost:5432 (user: `postgres` password: `admin123`, db: `postgres`)\
Pgadmin exposed at http://localhost:5050 (user: `admin@admin.com`, password: `root`)

This application uses Java 17 version.