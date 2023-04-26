# ToDoOrNotToDo- Better than Notion

### Summary:
This project outlines the backend code of a to-do list, designed to be used for everyday activities.
The languages and technologies that we used are: Java, Spring Boot, postgreSQL, IntelliJ, PostMan and Postico.

### Description:
This application will allow a user to create a list and populate their list with items that they need to complete.

## Installation instructions: needs more specficity
Users of the application will need the following __applications(?)__:
- IntelliJ- with Maven and Java17
- IntelliJ will need specific dependencies to run Spring Boot:
- insert_dependencies_here
- Postman
- Postico

## Running our To-Do List application:needs more specficity
* In your computer terminal, run the following line: `createdb todolist_db`
* Once you have installed all the necessary applications for this project, run the application on IntelliJ and ensure you have no errors.
* In Postico, check that the database has __been populated(?)__
* You can now send the following requests in Postman working in the `localhost:8080` port:

| Action                               | Request type | Request Path                                     | Request Body Required and Example Request Bodies                                                        |    
|--------------------------------------|--------------|--------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| GetAllList                           | Get          | `/lists`                                         |                                                                                                         |
| GetListById                          | Get          | `/list/{id}`                                     |                                                                                                         |
| CreateNewList                        | Post         | `/lists`                                         | ✅ :  <br/> `{ "listName" :  "Gifts", "isCompleted" : "false","itemIds" : [2],"userIds" : [1]}`          |
| DeleteList                           | Delete       | `/list/{id}`                                     |                                                                                                         |
| UpdateList                           | Put          | `/list/{id}`                                     | ✅ : <br/>                                                                                               |
| SetListToComplete                    | Patch        | `/list/{id}?complete=true`                       |                                                                                                         |
| GetAllItems                          | Get          | `/items`                                         |                                                                                                         |
| FilteringItemsByPriorityOrCompletion | Get          | `items?completion={Boolean}&priority={Priority}` |                                                                                                         |
| GetItemsByID                         | Get          | `/items/{id}`                                    |                                                                                                         |
| AddNewItem                           | Post         | `/items`                                         | ✅ : <br/>  `{"taskName" : "eggs", "dueDate" : "2022-06-23", "priority": "HIGH", "isCompleted" : false}` |
| UpdateItem                           | Put          | `/items/{id}`                                    | ✅                                                                                                       |
| DeleteItem                           | Delete       | `/items/{id}`                                    |                                                                                                         |
| SetItemToComplete                    | Patch        | `/items/{id}?complete=true`                      |                                                                                                         |
| GetAllUsers                          | Get          | `/users`                                         |                                                                                                         |
| GetUserById                          | Get          | `/users/{id}`                                    |                                                                                                         |
| GetUserByName                        | Get          | `/users/by-name/{name}`                          |                                                                                                         |
| AddNewUsers                          | Post         | `/users`                                         | ✅                                                                                                       |
| UpdateUser                           | Put          | `/users/{id}`                                    | ✅                                                                                                       |
| DeleteUser                           | Delete       | `/users/{id}`                                    |                                                                                                         |

## API Description
This section will describe out models and what they will do:

  - Item
    - This represents tasks that would be added to a to-do list
    - Properties of 'Item':
      - Name
      - Due date
      - Priority 
      - isCompleted
      - To-do list
  - ItemDTO 
    - This ...
    - Properties of 'ItemDTO':
        - Name
        - Due date
        - Priority
        - isCompleted
        - List of 'to-do list IDs'
  - List
    - This represents the to-do list, which will be populated with 'Item's
    - Properties of 'List':
  - ListDTO
    - This ...
    - Properties of 'ListDTO':
  - User
    - This represents the user that will be allocated to a list/
    - Properties of 'User':
      - Name
  - UserDTO
    - This ...
    - Properties of 'UserDTO':
      - Name
      - List of 'to-do list IDs'
  - Priority(Enum)
    - This enum represents the different priority levels of the 'Item'
    - Constants:
      - HIGH
      - MEDIUM 
      - LOW




## Aspirational Extensions 
if we had more time we would try to implement the following functionality:
* Filtering the to-do lists by completion and priority
* 

## any other quirks/bugs that users need to be made 



