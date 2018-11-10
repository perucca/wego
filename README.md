# Wego Project

Wego stands for Week-End GO. Its aims at providing the user with good tips for the week-end based on his/her favorite places, sports and the weather forecast.
After signing-in, the user can choose and sort a list of up to 5 favorite places and up to 5 favorite sports. He/she can specify which sport is practiced in which place to tune the week-end tips finely.
Each thursday Wego connects to weather forecast services and searchs for the best compromise for the week-end. A notification is send to the user by email.

## Getting Started

A docker version of the project is available. Please refer to the installing section of this document.
Otherwise, the project could be run using Eclipse and NPM. 
On Eclipse, run the file WegoApplication.java as SpringBoot project. Then, from the reactapp folder :
```
npm install
npm start
```

### Prerequisites


```
In order to start the Wego Application, you have to install Docker and Docker-compose on your server.
```

### Installing


```
sudo docker-compose up
```
## Trying it out
Please use the following account to get an example of the app filled up by a user :
```
username: foo@bar.baz
password: password
```

## Built With

* [React.js](https://reactjs.org/docs/getting-started.html) - The web framework used
* [Bootstrap](https://getbootstrap.com/docs/4.0/getting-started/introduction/) - The CSS framework used
* [Spring Boot](https://spring.io/guides) - The application / inversion of control framework 
* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Michel Perucca**
* **Dorian Screm**
* **Angélique Montuwy**

## What could be improved ?
* Security: by using JWT token
* Search for places: by providing the user with a leaflet map
* Additonal sports: the list of sport is new limited and the user cannot add sports to the database
* Communication: by pushing the user a notification to his/her smartphone 
* Layout customization: choice of profile picture, accessibility for visualy impaired people
* Smart app: more control of the user's input (ex: should we really accept that the user choose Saint Brieuc as a place for skying?) 

## Acknowledgments

* Thanks to Stack Overflow!

