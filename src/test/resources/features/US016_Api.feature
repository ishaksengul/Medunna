@US016_API
Feature:Validate Room creation by Admin. Create View, Update, Delete with API
  @US016_API_TC01
    @ApiRegistrant
  Scenario Outline: Validate rooms with API creating
    Given BS set the expected data "<description>", <price>, "<roomType>" and "<status>"
    When BS user sends the "POST" request
    Then BS status code should be 201 for rooms
    Then BS verify that the response body should be as an expected data
    Examples:
      |description|price|roomType|status|
      |With TV    |200  |DELUXE  |false |

  @US016_API_TC02
    @ApiRegistrant
  Scenario Outline: Validate all rooms with API reading
    Given BS set the expected data "<description>", <price>, <roomNumber>, "<roomType>" and "<status>"
    When BS user sends the "GET" request
    Then BS status code should be 200 for rooms
    Then BS verify that the response body contains all expected data
    Examples:
      |description|price|roomNumber|roomType|status|
      |critical   |100  |3626      |DAYCARE |true  |
      |mus        |111  |1111      |TWIN    |true  |
  @US016_API_TC03
    @ApiRegistrant
  Scenario Outline: Validate rooms with API updating
    Given BS set the expected data "<description>", <price>, <roomNumber>, "<roomType>" and "<status>" for <roomId>
    When BS user sends the "PUT" request
    Then BS status code should be 200 for rooms
    Then BS verify that the response body should be as an expected
    Examples:
      |description|price|roomNumber|roomType|status|roomId|
      |critic     |120  |3626      |DAYCARE |true  |31701 |
  @US016_API_TC04
  @ApiRegistrant
  Scenario: Validate rooms with API deleting
    Given BS user sends the delete request
    Then BS status code should be 204 for rooms