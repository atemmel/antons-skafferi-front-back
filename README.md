# Antons Skafferi angular/java project. Course: Applikationsutveckling i java projektkurs.

# Setup

Make sure that `maven`, `npm` and `angular-cli` is installed.
`angular-cli` can be installed with:
```sh
npm i -g @angular/cli
```

Once the prerequisites are installed, the project can be cloned.
```sh
git clone https://github.com/atemmel/antons-skafferi-front-back.git
cd antons-skafferi-front-back/frontend
npm install
```

# Starting the server

To start the frontend component, enter the respective directory (`frontend`) and execute:
```sh
ng serve
```
The website will be available at `localhost:4200`.

To start the backend component, open the project in netbeans and select `run`. 
Netbeans should solve most problems, but you may have to right-click the project and select `resolve-problems`.
You can also start the backend via the command line:
```sh
cd backend
./start-backend
```
# Database Schema
![Repo List](/backend/src/main/resources/images/DatabaseSchema.png) 

# Developers

## Frontend (Web)

- Elias Berglin [Github Page Overview](https://github.com/typelias)
- Gustav Nilsson [Github Page Overview](https://github.com/JohnGNilsson)

## Backend (API)

- Allamo Olsson [Github Page Overview](https://github.com/Ninhow)
- Isak Kjellhard [Github Page Overview](https://github.com/kjellhard)

## Backend (Database)

- William Takolander [Github Page Overview](https://github.com/Takolander)
- Fredrik Sellgren [Github Page Overview](https://github.com/iSellgren)

# API 

## Customer

Path: /customers
Returns all customers
Exampel: http://locahost:8080/customers 

Path: /customers/customer, Params: id
Returns specific customer by id
Example: http://locahost:8080/customers/customer?id=

Path: /customers/customer, Params: firstName
Returns specific customer by first name 
Example: http://locahost:8080/customers/customer?firstName=

Path: /customers/customer, Params: lastName
Returns specific customer by last name
Example: http://locahost:8080/customers/customer?lastName=

Path: /customers/customer, Params: email
Returns specific customer by email.
Example: http://locahost:8080/customers/customer?email=

Path: /customers/customer/today
Returns all customers that are supposed to come in today
Example: http://locahost:8080/customers/customer/today

Path: /customers/dinnertable, Params: dinnerTable
Returns all customers that are booked on a specified table
Example: http://locahost:8080/customers/dinnertable?dinnertable=

Path: /customers/customer/date, Params: dateTime
Returns all customers that are booked a specific time
Example: http://locahost:8080/customers/customer/date?dateTime=

Path: /post/customers, Params: customer body
Posts a new customer, you need a customer body
Example: http://locahost:8080/post/customers?customer=

Path: /post/customers/table, Params: date, firstname, secondname
Changes a customer in table, you need a customer body
Example:
http://localhost:8080/post/customers/table?date=&time=&firstname=&secondname=


Path: /customers/delete/customer, Params: id
Deletes specific customer by id
Example: http://localhost:8080/customers/delete/customer?id=

Path: /customers/delete/all
Deletes all customers
Example: http://localhost:8080/customers/delete/all

