@US016_DB
Feature: Validate Room creation by Admin with DB

  Scenario Outline: Validate all rooms with DB
    Given  BS user connects to the Database
    When BS user selects "id, room_number,price, room_type, status, description" from the "room" table for "created_by = 'medunnaadmin'"
    And BS verify that the data includes <id>, <roomNumber>, "<price>", "<roomType>", "<status>", "<description>" information
    Then BS user close the database connection

    Examples:
      |description|price|roomNumber|roomType|status|id    |
      |           |299.00  |297       |TWIN    |false |31707 |
      |With TV    |200.00  |590       |DELUXE  |false |32638 |