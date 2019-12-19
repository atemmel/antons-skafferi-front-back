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

```
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
```

## Dinnertable

```
Path: /dinnertables
Returns all dinnertables
Example: http://localhost:8080/dinnertables

Path: /dinnertables/{id}, Params: id
Returns a specified dinnertable by id
Example: http://localhost:8080/dinnertables/1

Path: /dinnertables/{id}, Params: id     
Deletes a specified dinnertable by id
Example: http://localhost:8080/dinnertables/1

Path: /dinnertables/booking, Params: date
Returns all unbooked dinnertables by date
Example: http://localhost:8080/dinnertables/booking?date=

Path: /post/active/true, Params: dinnertable
Updates attribute “active” of specified dinner table to true
Example: http://localhost:8080/post/active/true?dinnertable=

Path: /post/active/false, Params: dinnertable
Updates attribute “active” of specified dinner table to false
Example: http://localhost:8080/post/active/false?dinnertable=

Path: /dinnertables/active, Params: dinnertable
Returns if specified dinner table is active or not (true or false)
Example: http://localhost:8080/dinnertables/active?dinnertable=
```

## Employee

```
Path: /employees
Returns all employees
Example: http://localhost:8080/employees

Path: /employees, Params: name
Returns a specified employee by name 
Example: http://localhost:8080/employees?name=
```

## Employee Schedule

```
Path: /empschedules
Returns all employee schedules
Example: http://localhost:8080/empschedules

Path: /empschedules/post/employeesechedual, Params: employeeid, date, start, end
Posts a new employee schedule and can also create a new working schedule if missing
Example:  http://localhost:8080/empschedules/post/employeesechedual?employeeid=&date=&start=
&end

Path: /empschedules/post/switchemployeesecheduals, Params: empone, emptwo, scheduleone, scheduletwo
Updates two employee schedule so that they switch employeeid
Example: http://localhost:8080/empschedules/post/switchemployeesecheduals?empone=&emptwo=
&scheduleone=&scheduletwo=

Path: /empschedules/delete/employeesechedual, Params: employeeid, workscheduleid
Deletes a employee schedule on employeeid and workscheduleid
Example: 
http://localhost:8080/empschedules/delete/employeesechedual?employeeid=
&workscheduleid=

Path: /empschedules/username, Params: workscheduleid 
Returns username by workscheduleid
Example: http://localhost:8080/empschedules/username?workscheduleid=
```

## Event

```
Path: /events
Returns a list of all events
Example: http://localhost:8080/events

Path: /events/orderd
Returns a list of all evetnts in order by date
Example: http://localhost:8080/events/orderd

Path: /events/event, Params: date 
Returns a specific event by date
Example: http://localhost:8080/events/event?date=

Path: /post/events, Params: event 
Updates an event
Example: http://localhost:8080/post/events?event

Path: /upload
Creates a new event that gets posted
Example: http://localhost:8080/upload
```

## Image

```
Path: /images
Gets a image
Example: http://localhost:8080/images
```

## Item Category

```
Path: /itemcategorys
Returns all item categories
Example: http://localhost:8080/itemcategorys

Path: /itemcategorys/itemcategory, Params: name
Returns specific item category by name
Example: http://localhost:8080/itemcategorys/itemcategory?name=

Path: /post/itemcategorys, Params: itemCategory
Posts a new item category
Example: http://localhost:8080/post/itemcategorys?itemCategory=

Path: /itemcategorys/delete/itemcategory, Params: id
Deletes a specified item category by id
Example: http://localhost:8080/itemcategorys/delete/itemcategory?id=

Path: /itemcategorys/delete/all
Deletes all item categories
Example: http://localhost:8080/itemcategorys/delete/all
```

## Item

```
Path: /items
Returns all items
Example: http://localhost:8080/items

Path: /items/item, Params: title
Returns all items with matching title
Example: http://localhost:8080/items/item?title=

Path: /items/item, Params: type
Returns all items with matching type
Example: http://localhost:8080/items/item?type=

Path: /items/item, Params: description
Returns all items with matching description
Example: http://localhost:8080/items/item?description=

Path: /items/item, Params: price
Returns all items with matching price
Example: http://localhost:8080/items/item?price=

Path: /post/items, Params: item
Saves a new item
Example: http://localhost:8080/post/items?item=

Path: /items/delete/item
Deletes specific item
Example: http://localhost:8080/items/delete/item?

Path: /items/delete/all
Deletes all items
Example: http://localhost:8080/items/delete/all
```

## Item Order

```
Path: /orders
Returns all orders
Example: http://localhost:8080/orders

Path: /orders/table, Params: dinnertable
Returns all orders to a specific dinner table
Example: http://localhost:8080/orders/table

Path: /post/orders, Params: order
Posts a new order
Example: http://localhost:8080/post/orders/?order=

Path: /orders/unready
Returns all unready orders
Example: http://localhost:8080/orders/unready

Path: /orders/ready
Returns all ready orders
Example: http://localhost:8080/orders/ready

Path: /orders/sorted
Returns all orders sorted
Example: http://localhost:8080/orders/sorted

Path: /orders/prepare
Returns all orders that are to be prepared
Example: http://localhost:8080/orders/prepare

Path: /post/ready, Params: dinnertable
Updates all orders to ready for specific dinner table
Example: http://localhost:8080/post/ready?dinnertable=

Path: /post/delivered, Params: dinnertable
Updates all orders to delivered for a specific dinner table
Example: http://localhost:8080/post/delivered?dinnertable=

Path: /orders/sum, Params: dinnertable
Gets the sum of all orders to specific dinner table
Example: http://localhost:8080/orders/sum?dinnertable=

Path: /orders/delete, Params: dinnertable
Deletes all orders to specific dinner table
Example: http://localhost:8080/orders/delete?dinnertable=
```

## Todays Lunch
 
```
Path: /lunches
Return all lunches.
Example: http://localhost:8080/lunches

Path: /post/todayslunch, Params = todayslunch 
Post a new lunch.
Example: http://localhost:8080/post/todayslunch?todayslunch=

Path: /lunches/delete/all
Deletes all lunches
Example: http://localhost:8080/lunches/delete/all
```

## User

```
Path: /users
Return all users.
Example: http://localhost:8080/users 

Path: /users/login, Params = username, password
Return users login info.
Example: http://localhost:8080/users/login?username=&password=

Path: /post/users Params = user Body
Post a new user, you need a userBody in JSON to do this.
Example: http://localhost:8080/post/users?user=

Path: /post/newuser Params = firstname, lastname, password, admin
Create a new user according to the firstname and lastname.
Example: http://localhost:8080/post/newuser?firstname=fredrik&lastname=sellgren&password=hej123&admin=1
```

## Working Schedule

```
Path: /schedules
Returns all schedules
Example: http://localhost:8080/schedules

Path: /schedules/schedule/date, Params: dateTime
Returns a schedule for a specific dateTime
Example: http://localhost:8080/schedules/schedule/date?dateTime=

Path: /post/schdedules, Params: schedule
Posts a new schedule
Example: http://localhost:8080/post/schdedules?schedule=

Path: /schedules/delete/schedule, Params: id
Deletes a schedule by id
Example: http://localhost:8080/schedules/delete/schedule?id=

Path: /schedules/delete/all
Deletes all schedules
Example: http://localhost:8080/schedules/delete/all

Path: /schedules/schedule/getid, Params: date, start, end
Returns a schedule id by date, start and end
Example: http://localhost:8080/schedules/schedule/getid?date=&start=&end=

Path: /schedules/schedule, Params: employeeid, date
Returns all work schedules for a employee on a specific date
Example: http://localhost:8080/schedules/schedule?employeeid=&date=
```
