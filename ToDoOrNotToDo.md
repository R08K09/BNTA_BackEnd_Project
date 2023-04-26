# ToDoOrNotToDo- Better than Notion

Summary:
This project outlines the backend code of a to-do list, designed to be used for everyday activities.
The languages and technologies that we used are: Java, Spring Boot, postgreSQL, IntelliJ, PostMan and Postico.

Description:
This application will allow a user to create a list and populate their list with items that they need to complete.

## Installation instructions:
Users of the application will need the following __applications(?)__:
- IntelliJ- with Maven and Java17
- IntelliJ will need specific dependencies to run Spring Boot:
- insert_dependencies_here
- Postman
- Postico

Running our To-Do List application:
* In your computer terminal, run the following line: `createdb todolist_db`
* Once you have installed all the necessary applications for this project, run the application on IntelliJ and ensure you have no errors.
* In Postico, check that the database has __been populated(?)__
* You can now send the following requests in Postman working in the `localhost:8080` port:

| Action                               | Request type | Request Path                                     | Request Body Required |    
|--------------------------------------|--------------|--------------------------------------------------|-----------------------|
| GetAllList                           | Get          | `/lists`                                         |                       |
| GetListById                          | Get          | `/list/{id}`                                     |                       |
| CreateNewList                        | Post         | `/lists`                                         | ✅                     |
| DeleteList                           | Delete       | `/list/{id}`                                     |                       |
| UpdateList                           | Put          | `/list/{id}`                                     | ✅                     |
| SetListToComplete                    | Patch        | `/list/{id}?complete=true`                       |                       |
| GetAllItems                          | Get          | `/items`                                         |                       |
| GetItemsByID                         | Get          | `/items/{id}`                                    |                       |
| AddNewItem                           | Post         | `/items`                                         | ✅                     |
| UpdateItem                           | Put          | `/items/{id}`                                    | ✅                     |
| DeleteItem                           | Delete       | `/items/{id}`                                    |                       |
| SetItemToComplete                    | Patch        | `/items/{id}?complete=true`                      |                       |
| FilteringItemsByPriorityOrCompletion | Get          | `items?completion={Boolean}&priority={Priority}` |                       |
| GetAllUsers                          | Get          | `/users`                                         |                       |
| GetUserById                          | Get          | `/users/{id}`                                    |                       |
| AddNewUsers                          | Post         | `/users`                                         | ✅                     |
| UpdateUser                           | Put          | `/users/{id}`                                    | ✅                     |
| DeleteUser                           | Delete       | `/users/{id}`                                    |                       |





Aspirational extensions 
any other quirks/bugs that users need to be made 



