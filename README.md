# ToDo-OrNot-ToDo - "Better than Notion"

### Summary:
This project outlines the backend code of a to-do list, designed to be used for everyday activities.
The languages and technologies that we used are: Java, Spring Boot, postgreSQL, IntelliJ, PostMan and Postico.

### Description:
This application will allow a user to create a list and populate their list with items that they need to complete.

## UML and ERD:
### UML diagram: 
![UML diagram](BackEnd.jpg)

### ERD diagram:
![ERD diagram](erdForBackEnd.png)

### Dummy data:
![ERD dummy data](ERD%20Dummy%20data.png)

## Installation instructions:
Users of the application will need the following:
- IntelliJ - with Maven and Java17
  - IntelliJ will need following dependencies to run the application:
    - Spring Boot DevTools
    - Spring Web 
- Postman
- Postico

## Running our To-Do List application:
* In your computer terminal, run the following line: `createdb todolist_db`
  * In resources.application.properties, copy in the following:
    * `spring.datasource.url=jdbc:postgresql://localhost:5432/todolist_db`<br/>
      `spring.datasource.username=`<br/>
      `spring.datasource.password=`<br/>
      `spring.datasource.driver-class-name=org.postgresql.Driver`<br/>
      `spring.jpa.hibernate.ddl-auto=create-drop`<br/>
      `spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true`<br/>
* Once you have installed all the necessary applications and dependencies for this project, run the application on IntelliJ and ensure there are no errors.
* In Postico, check that the database has been populated, according to the data created in the dataloader.
* You can now send the following requests in Postman, working in the `localhost:8080` port:

| Action                               | Request type | Request Path                                    | Request Body Required and Example Request Bodies                                                                               |    
|--------------------------------------|--------------|-------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| GetAllLists                          | Get          | `/lists`                                        |                                                                                                                                |
| FilteringListsByCompletion           | Get          | `/lists?completed={Boolean}`                    |                                                                                                                                |
| GetListById                          | Get          | `/lists/{id}`                                   |                                                                                                                                |
| CreateNewList                        | Post         | `/lists`                                        | ✅ : <br/> `{"listName" : "Gifts",`<br/> `"isCompleted" : "false",`<br/> `"itemIds" : [2],`<br/> `"userIds" : [1]}`             |
| UpdateList                           | Patch        | `/lists/{id}`                                   | ✅ : <br/> `{"listName" : "Gifts",`<br/> `"isCompleted" : "false",`<br/> `"itemIds" : [2],`<br/> `"userIds" : [1]}`              |                                   |                                                                                                         |
| SetListCompletion                    | Patch        | `/lists/complete/{id}?completed={Boolean}`      |                                                                                                                                |
| DeleteList                           | Delete       | `/lists/{id}`                                   |                                                                                                                                |
| GetAllItems                          | Get          | `/items`                                        |                                                                                                                                |
| FilteringItemsByPriorityOrCompletion | Get          | `items?completed={Boolean}&priority={Priority}` |                                                                                                                                |
| GetItemsByID                         | Get          | `/items/{id}`                                   |                                                                                                                                |
| CreateNewItem                        | Post         | `/items`                                        | ✅ : <br/>  `{"taskName" : "eggs",`<br/> ` "dueDate" : "2022-06-23",`<br/>  `"priority": "HIGH",`<br/> `"isCompleted" : false}` |
| UpdateItem                           | Patch        | `/items/update/{id}`                            | ✅ : <br/>  `{"taskName" : "eggs",`<br/> ` "dueDate" : "2022-06-23",`<br/>  `"priority": "HIGH",`<br/> `"isCompleted" : false}`  |                               |                                                                                                         |
| SetItemCompletion                    | Patch        | `/items/{id}?completed=true`                    |                                                                                                                                |
| DeleteItem                           | Delete       | `/items/{id}`                                   |                                                                                                                                |
| GetAllUsers                          | Get          | `/users`                                        |                                                                                                                                |
| GetUserById                          | Get          | `/users/{id}`                                   |                                                                                                                                |
| GetUserByName                        | Get          | `/users/by-name/{name}`                         |                                                                                                                                |
| CreateNewUsers                       | Post         | `/users`                                        | ✅ : <br/> `{"name" : "Tim"}`                                                                                                   |
| UpdateUser                           | Patch        | `/users/{id}`                                   | ✅ : <br/> `{"name" : "Tim"}`                                                                                                   |
| DeleteUser                           | Delete       | `/users/{id}`                                   |                                                                                                                                |

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
    - This DTO allows us to use 'Item' without exposing the properties of 'Item'
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
    - This DTO allows us to use 'List' without exposing the properties of 'List'
    - Properties of 'ListDTO':
  - User
    - This represents the user that will be allocated to a list/
    - Properties of 'User':
      - Name
  - UserDTO
    - This DTO allows us to use 'User' without exposing the properties of 'User'
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
If we had more time we would try to implement the following functionality:
* Filtering the to-do lists by due date


## Quirks and/or bugs
One quirk of our application is the 'Reminder' functionality; '@Scheduled' annotation allows for a function of be run at
a specific time or at specific intervals.<br />

Currently, the item reminder function is to set to run every day at 9:00am. When the function runs it checks if the current local date is equal to any of the "dueDate" of any items currently in the database, if the current date and dueDate match it will print the task name to the console, reminding the user that a specific task needs to be done.

In the future this function could be built upon to create push notifications to send to the user.

## Coders
- Hayan 
- Vincent 
- Rada 
- Maryan




