@US011
Feature: US11_My Appointments Edit portal by Physician(Doctor)

  Background:
    Given go to Medunna website
    And user logins as doctor
    Then user goes to my page and clicks my appointments

  @TC001
  Scenario: TC001_Create a new appointment
    Given user clicks edit button for a patient
    And user asserts that he can go to create and edit appointment page
    Then close the page


  @TC002
  Scenario: TC002_If you are updating an appointment, then user (doctor) should see patient's info such as
  id, start and end date, Status, physician and patient

    Given user asserts the visibility of the appointment table
    Then close the page

  @TC003
  Scenario: TC003_Doctor should type in Anamnesis, Treatment, and Diagnosis as required fields positive test
    Given user clicks edit button for a patient
    And user sends text for anamnesis textbox
    And user sends text for treatment textbox
    And user send text for diagnosis textbox
    Then close the page

  Scenario: TC003_Doctor should type in Anamnesis, Treatment, and Diagnosis as required fields negative test
    Given user clicks edit button for a patient
    And user clicks anamnesis textbox but doesn't send text
    And user gets invalid feedback warning anamnesis
    And user clicks treatment textbox but doesn't send text
    And user gets invalid feedback warning treatment
    And user clicks diagnosis textbox  but doesn't send text
    And user gets invalid feedback warning diagnosis
    And user clicks prescription text box but doesn't send text
    Then close the page

  @TC004
  Scenario: TC003_"prescription and description" should be optional
    Given user clicks edit button for a patient
    And user clicks description text box but doesn't send text
    And user asserts that they did not receive invalid feedback warnings
    Then close the page

  @TC005
  Scenario: TC005_"Status" can be selected as "PENDING, COMPLETED or CANCELLED" by the doctor
    Given user clicks edit button for a patient
    And user clicks the status text box and asserts that PENDING, COMPLETED and CANCELLED is selectable
    Then close the page