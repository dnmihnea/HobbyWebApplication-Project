Coverage: 94.7%
# HobbyWebApplication-Project

This project contain a simple Movie database, where a user can input a movie's title, release year and director name. The back-end has been written in Java (Spring Boot API) and the front-end has been created using HTML, CSS and JavaScript. The website interface is interactive and a user can add entries to the Movie database, edit them, delete them, or search by a specific title, year or director.

## Technologies Used

* Version Control System - [Git](https://git-scm.com/)
* Agile Board - [Jira](https://www.atlassian.com/software/jira)
* Database - [MySQL](https://www.mysql.com/) (for production), [H2](https://www.h2database.com/html/main.html) for testing
* Back-end - [Java](https://www.java.com/en/) 
* API Development - [Spring Boot](https://spring.io/projects/spring-boot)
* Build Tool - [Maven](https://maven.apache.org/)
* Testing - [JUnit](https://junit.org/junit5/), [Mockito](https://site.mockito.org/)
* Front-end - HTML, CSS , [JavaScript](https://www.javascript.com/)

## Getting Started

This section will provide information on the programs required to get this application up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

These are the programs needed to run this application. I have included links to some setup guides (for Windows).

* [Java](https://www.java.com/en/) - [Guide](https://www.java.com/en/download/help/windows_manual_download.html)
* [mySQL](https://www.mysql.com/) - [Guide](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)
* [Git](https://git-scm.com/) - [Guide](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
* [VSCode](https://code.visualstudio.com/) or any text editor - [Guide](https://code.visualstudio.com/docs/setup/setup-overview)
* [Maven](https://maven.apache.org/) - For testing (Optional) - [Guide](https://maven.apache.org/install.html)

### Installing

After installing the software above, follow these steps to make sure you are ready to run the program.

#### Cloning the repo

Choose the ***directory*** where you would like to save the project. To keep it simple, I will be referring to this ***directory*** by using bold and italics throughout this guide. Open a Git Bash console by right-clicking and choosing *Git Bash*. In the console, copy and paste the following code:

```
git clone https://github.com/dnmihnea/HobbyWebApplication-Project.git
```

#### Setting up your database login details

In order to access your local MySQL server, you will need to make a small change. Navigate to ***directory***\HobbyWebApplication-Backend\src\main\resources and open the *application-prod.properties* file by using VSCode or a text editor. In the file, change the username and password values to match your own.

```
# JDBC Connection URL
spring.datasource.url=jdbc:mysql://localhost:3306/juneenabledb?createDatabaseIfNotExist=true

#Username / Password
spring.datasource.username=root #Make sure this is changed to your username (By default root)
spring.datasource.password=alex #Make sure this is changed to your password (By default root)

# DDL-Auto
spring.jpa.hibernate.ddl-auto=update

# Initialisation Mode
spring.sql.init.mode=always

# Showing hibernate SQL
spring.jpa.show-sql=true
```

## Running tests

In order to run tests, you need to open a terminal window inside of ***directory***\HobbyWebApplication-Backend. You can easily do this by clicking on your address bar, typing in *cmd* and pressing Enter. In the terminal, run the following command:

```
mvn test
```

## Deployment

In order to deploy the program, open a terminal window inside of ***directory*** and run the following command:
```
java -jar HobbyWebApplication.jar
```

Afterwards, in order to access the front-end, open any browser and type http://localhost:8080 in the address bar. *(Note: Port 8080 is the default port, this program might use a different port if port 8080 is already in use)*

## Author

* **Alex Dinu** - [dnmihnea](https://github.com/dnmihnea)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* QA
* Anoush Lowton
* Flexbox Froggy