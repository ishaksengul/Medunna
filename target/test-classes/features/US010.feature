@US010
Feature: US10_Doctor appointments

  @TC001
  Scenario: TC001_The user should be able to see the appointment list and time slots from the "My Appointments" tab
    Given go to Medunna website
    And user logins as doctor
    And user goes to my page and clicks my appointments
    And user asserts the visibility of appointment list and time slots
    Then close the page

  @TC002
  Scenario: TC002_User should be able to see "patient id, start date, end date, status" information

    Given go to Medunna website
    And user logins as doctor
    And user goes to my page and clicks my appointments
    And user asserts the visibility of patient id, start date, end date, status
    Then close the page