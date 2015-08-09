#Library APP

A simple library web application that uses Spring Boot Mvc, AngularJS and MongoDB

## Access
Use a browser to access to the app

http://localhost:8080/

## Heroku

You can access to the web app that is deployed on heroku

https://n11-library.herokuapp.com/

## Docker

You can also run it in your docker machine.

* First pull docker image from with "docker pull bilalalp/libraryapp"

* Then fetch & up mongodb instance on docker "docker run -p 27017:27017 --name mymongodb -d mongo"

* Finally run the application by typing "docker run -d -p 8080:8080 --name myapp -e spring.data.mongodb.host=192.168.59.103 -e spring.data.mongodb.port=27017 -e spring.data.mongodb.database=bookstore bilalalp/libraryapp"

If you want to build docker image by your own, you should type mvn package docker:build
