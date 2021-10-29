# Appcent Todo-App REST-API
A todo list API built using Spring Boot. The todo app is implemented using the in memory H2 database. The exposed swagger documented RESTFUL API endpoinds can be accessed via the link "http://localhost:8080/swagger-ui.html". The application provides the authenticate process and todo operations are performed according to the authenticated user. 



## Technology Stack:
*	Java 8+
•	Spring Boot
*	Spring Data
* Spring Security
*	H2 Database
*	Swagger
*	Maven
*	JUnit and Mockito

## Test Scenario:

### First, the user registers.

![1](https://user-images.githubusercontent.com/68387972/139501332-fc0ec5f6-2f78-422a-a988-b1e8d43a895b.png)

### Response: 
![2](https://user-images.githubusercontent.com/68387972/139501360-74d3ffd2-f0d4-4c4b-85de-ac0695113773.png)


### Then he logs in with his registered information.

![3](https://user-images.githubusercontent.com/68387972/139501468-ce57dbd5-e764-4ff4-a238-f451f723efa3.png)

### Response:
![4](https://user-images.githubusercontent.com/68387972/139501491-d3fd945e-43c0-4390-a2c2-02d861b202a4.png)


### After logging in, our user is authenticated.

At this stage the user adds todo. The todos added here are user specific. Todo does not ask for any user number or email to add. Because the todos to be added are added to the account of the user who is currently authenticated in the system.


## Below are CRUD operations for todo.

#### Add todo

![5](https://user-images.githubusercontent.com/68387972/139501616-56764729-8626-43c6-9da3-4411c4d070f9.png)
![6](https://user-images.githubusercontent.com/68387972/139501620-cec7c99f-0aed-418d-9cc3-3b8b69a729d5.png)

#### Get todos:

![7](https://user-images.githubusercontent.com/68387972/139501691-ddea1175-5f82-43f4-9524-2e2ac8014c1e.png)
![8](https://user-images.githubusercontent.com/68387972/139501689-baddd1fd-0713-4ea6-9577-fd19cf04a15d.png)


#### Update todo:

![10](https://user-images.githubusercontent.com/68387972/139501791-f595260a-36ad-4cce-aaa8-05394340b5e5.png)
![11](https://user-images.githubusercontent.com/68387972/139501793-2c741b6c-dc45-4f2e-ba63-df1e3cdd66a3.png)


#### Delete Todo:

![12](https://user-images.githubusercontent.com/68387972/139501876-074cdb98-6858-49eb-8e9b-404ea029f1b1.png)
![13](https://user-images.githubusercontent.com/68387972/139501879-a517e7ce-bb94-4583-9896-70907127ce95.png)


## After all this operations:

![son](https://user-images.githubusercontent.com/68387972/139501978-2087f1db-3cfc-4c1e-92d8-64b2fd0c8736.png)
