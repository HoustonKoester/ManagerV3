# Employee Management and Reimbursement System

### Project discription and overview

This project is a 2 in one employee management and employee reimbursement system. 

Employees and Managers can register to the website on the login page and managers can accept new employees. 
After an employee is accepted they will recieve an email with their username and password.

- Managers have the ability to view all active employees, accept new employees, view all reimbursements, and view an individual employees reimbursement requests.

- Employees have the ability to view and change their account information, create a reimbursement request, and view their individual reimbursement request status.

### List of included features
- An Employee can login/logout
- An Employee can view the Employee Homepage
- An Employee can submit a reimbursement request
- An Employee can view their pending reimbursement requests
- An Employee can view their resolved reimbursement requests
- An Employee can view their information
- An Employee can update their information

- A Manager can login/logout
- A Manager can view the Manager Homepage
- A Manager can approve/deny pending reimbursement requests
- A Manager can view all pending requests from all employees
- A Manager can view all resolved requests from all employees and see which manager resolved it
- A Manager can view all Employees
- A Manager can view reimbursement requests from a single Employee
- A Manager can register an Employee, which sends the Employee an email with their username and temp password (optional)
- An Employee can reset their password (Optional - tied with above functional requirement)


### List of used technologies
- Java 1.8
- Servlets
- JDBC
- SQL
- HTML/CSS/Javascript
- AJAX
- JUnit

### How to setup project
Inside the project folder you must add information to 2 files to be able to have the project work correctly. 

You must add in your database information to the DB.properties file located in the main project folder. 

You must also add in your email information to the genservicesimpl.java file located in src/main/java/services.

The databases must be setup in accordance with how data is accessed throughout the rest of the project.

###### Project Created By: Houston Koester
