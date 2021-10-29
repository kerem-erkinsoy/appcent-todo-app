A todo list API built using Spring Boot. The todo app is implemented using the in memory H2 database. The exposed swagger documented RESTFUL API endpoinds can be accessed via the link "http://localhost:8080/swagger-ui.html". The application provides the authenticate process and todo operations are performed according to the authenticated user. 



#Technology Stack:
•	Java 8+
•	Spring Boot
•	Spring Data
• Spring Security
•	H2 Database
•	Swagger
•	Maven
•	JUnit and Mockito

Test Scenario:

First, the user registers.

![1](https://user-images.githubusercontent.com/68387972/139501332-fc0ec5f6-2f78-422a-a988-b1e8d43a895b.png)



Then he logs in with his registered information.

![2](https://user-images.githubusercontent.com/68387972/139501360-74d3ffd2-f0d4-4c4b-85de-ac0695113773.png)


After logging in, our user is authenticated.

At this stage the user adds todo. The todos added here are user specific. Todo does not ask for any user number or email to add. Because the todos to be added are added to the account of the user who is currently authenticated in the system.

Below are CRUD operations for todo.


