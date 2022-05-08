@US016
Feature: Room creation by Admin. View, Update, Delete.

  Background:User sign in as an admin and navigate to Create or edit a Room page
    Given BS navigate to Medduna Home Page
    And BS Click on Account DropDownMenu button
    When BS Click on Sign in
    Then BS Click on Username input box.
    Then BS Enter Valid "Team92Admin" Username
    Then BS Click on Password input box.
    Then BS Enter Valid "Batch44+" Password
    Then BS Click on Sign in button
    And BS Click on Items&Titles
   And BS select Room from drop down menu and click


  @US016_TC01
  Scenario: User (Admin) can create new rooms for impatients. Created date as MM/DAY/YEAR and cannot be typed earlier
    When BS user clicks on Create a new Room button
    Then BS verify that user on the "Create or edit a Room" page
    Given BS user provides a Room Number
    And BS user provides a Price
    And BS user sets date as "03/12/2022"
    When BS user clicks on the Save button
    Then BS user should see the "A new Room is created"
    And BS verify that Created Date is updated automatically
  @US016_TC02
  Scenario: When creating a room, there should be room number (required field),room type as TWIN, DELUXE, PREMIUM_DELUXE, SUIT and DAYCARE, Current status can be set for the room,Price can be added and cannot be blank,Description can be provided optionally
    Given BS user leave blank Room Number field and click enter
    And BS user should see "This field is required." feedback twice
    When BS user clicks on the Room Type dropdown
    Then BS user should see options like "TWIN", "DELUXE", "PREMIUM_DELUXE", "SUITE" and "DAYCARE"
    And BS user can set current status for the room

  @US016_TC03
  Scenario:Admin can view all rooms with same items,Admin can edit(update) existing rooms,Rooms can be Deleted by admin
    Given BS user on the Rooms page
    And BS user should see all rooms on the same page
    When BS user clicks on "edit" button for last created room
    Then BS verify that user on the "Create or edit a Room" page
    And BS user provides "Room without TV" as description
    When BS user clicks on the Save button
    Then BS user should see the "Room is updated"
    When BS user clicks on "delete" button for last created room
    And BS user confirms delete operation
    Then BS user should see the "Room is deleted"