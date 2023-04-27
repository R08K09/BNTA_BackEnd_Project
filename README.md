# ToDo-OrNot-ToDo - "Better than Notion"

### Summary:
This project outlines the backend code of a to-do list, designed to be used for everyday activities. 
By using our API you can organise all types of tasks into suitable lists and utilise them to manage your day-to-day life.

## Diagrams:
### UML diagram: 
![UML diagram](BackEnd.jpg)

### ERD diagram:
![ERD diagram](erdForBackEnd.png)

### Dummy data:
![ERD dummy data](ERD%20Dummy%20data.png)

## Relationships
There are one-to-many and many-to-many relationships:
* Many users to many lists
* One list to many items

## API Description
This API will allow multiple users to create lists which can then be populated with items that they need to complete.
This section will describe out models and what they will do:

### User <br/>
This represents the user that will be allocated to a list.
- Properties of 'User':
    - Name
    - masterList which is a list of toDoLists

### UserDTO <br/>
This DTO allows us to use 'User' without exposing the properties of 'User'
- Properties of 'UserDTO':
    - Name
    - List of 'to-do list IDs'

### List: <br/>
This represents the to-do list, which will be populated with 'Item's
- Properties of 'List':

### ListDTO: <br/>
This DTO allows us to use 'List' without exposing the properties of 'List'
- Properties of 'ListDTO':

### Item: <br/>
This represents tasks that would be added to a to-do list.
- Properties of 'Item':
    - Name
    - Due date
    - Priority
    - isCompleted
    - To-do list

### ItemDTO: <br/>
This DTO allows us to use 'Item' without exposing the properties of 'Item'
- Properties of 'ItemDTO':
    - Name
    - Due date
    - Priority
    - isCompleted
    - List of 'to-do list IDs'

### Priority(Enum) <br/>
This enum represents the different priority levels of the 'Item'
- Constants:
    - HIGH
    - MEDIUM
    - LOW


## Tech Stack
- IntelliJ IDEA (JDK 17)
- PostgresSQL
- Postico
- Postman
- Spring Boot

## Dependencies:
IntelliJ will need following dependencies to run the application:
  - Spring Data JPA
  - Spring Boot DevTools
  - Spring Web

## SetUp Instructions
Users of the application will need to do the following:
1. Ensure that the following are installed on your machine:
   - IntelliJ (JDK 17) - with Maven
   - PostgresSQL
   - Postman
   - Postico
2. Clone the repository from GitHub. At the top of the page, click on the green Code button. Make sure that SSH is selected and then copy the link provided. Within your terminal, enter the following command:
    <pre><code> git clone git@github.com:R08K09/BNTA_BackEnd_Project.git </code></pre>
3. Create a new database by running the following line anywhere in your terminal: `createdb todolist_db`
   * In resources.application.properties, copy in the following:
     <pre><code>spring.datasource.url=jdbc:postgresql://localhost:5432/todolist_db
     spring.datasource.username=
     spring.datasource.password=
     spring.datasource.driver-class-name=org.postgresql.Driver
     spring.jpa.hibernate.ddl-auto=create-drop
     spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true </code></pre>
4. Once you have installed all the necessary applications and dependencies for this project, run the BackendCodeApplication via Intellij IDEA. Ensure that there are no errors and that the API is running on port 8080.
5. In Postico, check that the database has been populated, according to the data created in the DataLoader.
6. Via Postman, create a new collection called ToDo List Project and add the following requests in Postman.

## PostMan Instructions
All request URLs will start with the following:
`http://localhost:8080...`
To perform a specific request, add the request path Endpoint to the URL.

Example URL: `http://localhost:8080/lists`

For any request that requires a Request Body to input required details, teh request body must be in JSON format in the raw section. 

| Action                               | Method | Request Path (Endpoint)                         | Request Body Required and Example Request Bodies                                                                               | Expected return from Postman                                                                                                                                                                                                                   |  
|--------------------------------------|--------|-------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GetAllLists                          | Get    | `/lists`                                        |                                                                                                                                | This endpoint should return all the lists from the DataLoader, including the users, that own that list, and the items included in that list.                                                                                                   |
| FilteringListsByCompletion           | Get    | `/lists?completed={Boolean}`                    |                                                                                                                                | This endpoint should return the lists based on whether they are completed or not, i.e. if the endpoint is `completed=true`, Postman will return all the lists which have been completed.                                                       |
| GetListById                          | Get    | `/lists/{id}`                                   |                                                                                                                                | This endpoint should return the list of the ID that has been passed in, with the items contained in that list and the users who own that list.                                                                                                 |
| CreateNewList                        | Post   | `/lists`                                        | ✅ : <br/> `{"listName" : "Gifts",`<br/> `"isCompleted" : "false",`<br/> `"itemIds" : [2],`<br/> `"userIds" : [1]}`             | This endpoint should post a new item, which can be viewed either in Postico, or using the GetAllLists or GetListsByID endpoints.                                                                                                               |
| UpdateList                           | Patch  | `/lists/{id}`                                   | ✅ : <br/> `{"listName" : "Gifts",`<br/> `"isCompleted" : "false",`<br/> `"itemIds" : [2],`<br/> `"userIds" : [1]}`             | This endpoint should allow you to update a property of a specific list, and this change can be viewed in Postico or using the GetAllLists or GetListById endpoints.                                                                            |
| SetListCompletion                    | Patch  | `/lists/complete/{id}?completed={Boolean}`      |                                                                                                                                | This endpoint should allow you to update the isComplete property of a to-do list, and this change can be viewed through Postico or the following endpoints; GetAllLists, GetListById or FilteringListsByCompletion.                            |
| DeleteList                           | Delete | `/lists/{id}`                                   |                                                                                                                                | This endpoint should allow you to delete a list, based on the ID, which can be viewed in Postico or using the GetAllLists or GetListById endpoints.                                                                                            |
| GetAllItems                          | Get    | `/items`                                        |                                                                                                                                | This endpoint should return all the items from the DataLoader, including the to-do list they are in and the users who own those lists.                                                                                                         |
| FilteringItemsByPriorityOrCompletion | Get    | `items?completed={Boolean}&priority={Priority}` |                                                                                                                                | This endpoint should return items based on their completion status and/or their priority i.e. if the endpoint is `completed=true` and `priority=HIGH`, Postman will return all the items which have been completed and are of `HIGH` priority. |
| GetItemsByID                         | Get    | `/items/{id}`                                   |                                                                                                                                | This endpoint should return the item based on their ID, including the to-do list they are in and the users who own those lists.                                                                                                                |
| CreateNewItem                        | Post   | `/items`                                        | ✅ : <br/>  `{"taskName" : "eggs",`<br/> ` "dueDate" : "2022-06-23",`<br/>  `"priority": "HIGH",`<br/> `"isCompleted" : false}` | This endpoint should allow you to post a new item, which can be viewed either in Postico, or using the GetAllItems or GetItemsByID endpoints.                                                                                                  |
| UpdateItem                           | Patch  | `/items/update/{id}`                            | ✅ : <br/>  `{"taskName" : "eggs",`<br/> ` "dueDate" : "2022-06-23",`<br/>  `"priority": "HIGH",`<br/> `"isCompleted" : false}` | This endpoint should allow you to update a property of a specific item, and this change can be viewed in Postico or using the GetAllItems or GetItemById endpoints.                                                                            | 
| SetItemCompletion                    | Patch  | `/items/{id}?completed=true`                    |                                                                                                                                | This endpoint should allow you to update the isComplete property of an item, and this change can be viewed through Postico or the following endpoints; GetAllItems, GetItemById or FilteringItemsByPriorityOrCompletion.                       |
| DeleteItem                           | Delete | `/items/{id}`                                   |                                                                                                                                | This endpoint should allow you to delete a item, based on the ID, which can be viewed in Postico or using the GetAllItems or GetItemById endpoints.                                                                                            |
| GetAllUsers                          | Get    | `/users`                                        |                                                                                                                                | This endpoint should return all the users from the DataLoader, including the lists that the users own and the items included in that list.                                                                                                     |
| GetUserById                          | Get    | `/users/{id}`                                   |                                                                                                                                | This endpoint should return the user based on their ID, including the lists that the users own and the items included in that list.                                                                                                            |
| GetUserByName                        | Get    | `/users/by-name/{name}`                         |                                                                                                                                | This endpoint should return the user based on their name, including the lists that the users own and the items included in that list.                                                                                                          |
| CreateNewUsers                       | Post   | `/users`                                        | ✅ : <br/> `{"name" : "Tim"}`                                                                                                   | This endpoint should post a new user, which can be viewed either in Postico, or using the following endpoints; GetAllUsers, GetUseRByID or GetUserByName endpoints.                                                                            |
| UpdateUser                           | Patch  | `/users/{id}`                                   | ✅ : <br/> `{"name" : "Tim"}`                                                                                                   | This endpoint should allow you to update a property of a specific user, and this change can be viewed in Postico or using the following endpoints; GetAllUsers, GetUseRByID or GetUserByName endpoints.                                        |
| RemoveListFromUser                   | Patch  | `/remove-list/{id}/{listId}`                    |                                                                                                                                | This endpoint should allow you to remove a list that is currently assigned to a user, based on the IDs of the list and user.                                                                                                                   |
| DeleteUser                           | Delete | `/users/{id}`                                   |                                                                                                                                | This endpoint should allow you to delete a user, based on their ID.                                                                                                                                                                            |


## Quirks
One quirk of our application is the 'Reminder' functionality; '@Scheduled' annotation allows for a function of be run at
a specific time or at specific intervals.<br />

Currently, the item reminder function is to set to run every day at 9:00am. When the function runs it checks if the current local date is equal to any of the "dueDate" of any items currently in the database, if the current date and dueDate match it will print the task name to the console, reminding the user that a specific task needs to be done.

In the future this function could be built upon to create push notifications to send to the user.

## Aspirational Extensions
If we had more time we would try to implement the following functionality:
* Filtering the to-do lists by due date
* Having an enum for list topic

## Collaborators
- Vincent - (GitHub: [dir-V](https://github.com/dir-V))
- Rada - (GitHub: [R08K09](https://github.com/R08K09))
- Hayan - (GitHub: [HayanButt](https://github.com/HayanButt))
- Maryan - (GitHub: [maryan-axmed](https://github.com/maryan-axmed))



