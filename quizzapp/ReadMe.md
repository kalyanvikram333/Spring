
# SpringBoot Quiz Project
This Git repository contains a Spring Boot project with two modules: Quiz and Questions. This README file serves as a guide to help you understand the project's structure, set it up, and get started.

### Project Overview
This project is a Spring Boot application designed to manage quizzes and questions. It is divided into two modules to promote code modularity and separation of concerns. The Quiz module is responsible for managing quizzes, while the Questions module handles questions and their associations with quizzes.


### Modules
##### 1. Quiz
The Quiz module is responsible for the following features:

Creation, modification, and deletion of quizzes.
Listing available quizzes.
Managing quiz metadata such as title, description, and difficulty level.
Associating questions with quizzes.
##### 2. Questions
The Questions module is responsible for the following features:

Creation, modification, and deletion of questions.
Listing available questions.
Managing question content, options, and correct answers.
Associating questions with quizzes.



#### Usage
You can interact with the API using tools like Postman or by making HTTP requests directly from your applications. The API endpoints are typically available at http://localhost:8080 for the Quiz module and http://localhost:8081 for the Questions module.





create a new repository on the command line
echo "# Spring" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:kalyanvikram333/Spring.git
git push -u origin main
…or push an existing repository from the command line
git remote add origin git@github.com:kalyanvikram333/Spring.git
git branch -M main
git push -u origin main
