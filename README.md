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
