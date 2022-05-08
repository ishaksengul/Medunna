
  Feature:DataBase cmessage test



    Scenario: user must validations   messages with DataBase
      Given user creates a connection with DataBase using
      And user sends the query to DataBase and gets the column data query and columnName
      Then validates messages.

