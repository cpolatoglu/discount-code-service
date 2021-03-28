# Discount Code Service from ACME

The discount code service exposes two endpoints.

* First endpoint is for companies to generate discount codes. The companies should be added to database manually and the
  id will be shared with customers who are using the endpoint as customerId.
* Second endpoint is for customers to fetch first available discount code.

### Running the application

Run the following command from project root to compile the code, run the tests, and create a jar file under target
directory.

```
* mvnw clean package
```

Run the following command to run the application.

```
* java -jar target/discount-service
```

The application will run on port 18080. If you would like to run it on different port please
edit `src/main/resources/application.yml`.

### Documentation

The API documentation can be accessed through http://localhost:18080/discount-code-service/swagger-ui.html

### Data & Database

The application uses an in-memory database called h2. Since the database is in-memory the data will be erased when the
application stops. The initial data will be loaded when the application starts. The data can be modified by modifying
`src/main/resources/data.sql`

If you would like to access to data any time while application is running you can access it through
http://localhost:18080/discount-code-service/h2-console. Use the following settings to establish a connection.

```
JDBC URL:  jdbc:h2:mem:discountcodedb
User Name: sa
Password:  sa
```

### Notes

* This code implements bare minimum; creating discount codes and fetching the first available code.
* There is no security implemented due to time constraints. It will be weird to go live without any security.
* There is no endpoint to add new companies to database. If you would like to do that do it via console or via initial
  data load.
* [initial_design.io](./initial_design.io) is the high level design of the application. It can be opened
  by https://app.diagrams.net. The diagram can be improved by sequence diagrams but I didn't have time to do it.
* The solution contains a message bus which is not implemented in this application due to time constraints.