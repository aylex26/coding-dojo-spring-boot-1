Spring Boot Coding Dojo-1
---
###How to run the application
If we have a Postgres Database
If we have a Postgres database setup and running and want to use it, you need to change the application configuration.

We should edit the application.yml file into the following folder src/main/resources/application.yml.

Change the following values with your Postgres information:

datasource:
password: .....
username: postgres
url: jdbc:postgresql://localhost:5432/postgres



###How to use the application
To use the application with PostMan or Insomnia:

POST - for save the data for the city
localhost:8080/weather?city={CITY_NAME}
Replace the {CITY_NAME} with London

GET - for get the data for the city
localhost:8080/weather?city={CITY_NAME}
Replace the {CITY_NAME} with London
An example of the response:

{
"coord": {
"lon": -0.1257,
"lat": 51.5085
},
"weather": [
{
"id": 804,
"main": "Clouds",
"description": "overcast clouds",
"icon": "04d"
}
],
"base": "stations",
"main": {
"temp": 281.32,
"pressure": 1035,
"humidity": 68
},
"visibility": 10000,
"wind": {
"speed": 4.63,
"deg": 260
},
"clouds": {
"all": 100
},
"dt": 1676033400,
"sys": {
"type": 2,
"id": 2075535,
"country": "GB",
"sunrise": 1676013877,
"sunset": 1676048698
},
"id": 2643743,
"name": "London",
"cod": 200
}

### Dependencies added
* Postgresql
* Lombok
* Junit5


### the requirement:


Welcome to the Spring Boot Coding Dojo!

### Introduction

This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the result in a database. The current implementation has quite a few problems making it a non-production ready product.

### The task

As the new engineer leading this project, your first task is to make it production-grade, feel free to refactor any piece
necessary to achieve the goal.

### How to deliver the code

Please send an email containing your solution with a link to a public repository.

>**DO NOT create a Pull Request with your solution** 

### Footnote
It's possible to generate the API key going to the [OpenWeather Sign up](https://openweathermap.org/appid) page.


