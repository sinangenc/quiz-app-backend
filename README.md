# Quiz App - Backend

This repository contains the backend API of the "Life in Germany (Leben in Deutschland)" quiz app, designed to help users prepare for the German citizenship test.

<!-- 
The frontend part of this application is maintained in a separate repository. You can find it [here](https://github.com/your-username/frontend-repo-name).
-->

## API Endpoints

| Method | Endpoint                | Description                       |
|--------|-------------------------|-----------------------------------|
| GET    | `/admin/questions`      | Returns all quiz questions.       |
| POST   | `/admin/questions`      | Creates a new quiz question.      |
| GET    | `/admin/questions/{id}` | Returns a specific quiz question. |
| DELETE | `/admin/questions/{id}` | Deletes a specific quiz question. |
| GET    | `/states`               | Returns all states(Bundesländer). |
