Feature: US005:  New customers (patients) should make an appoinment
   to processed in hospital Validate with API and DB

  @US005positive
  Scenario Outline: Test01: Make an Appointment - Verify Phone and Date
    Given BS Launch web browser and navigate to the home page
    And BS Click the Make an Appointment button
    And BS Click First Name textbox and Enter First Name "<US005firstname>"
    And BS Click the Last Name textbox and enter Last Name "<US005lastname>"
    And BS Click the SSN textbox and enter SSN number "<US005ssn>"
    And BS Click Email textbox and enter a valid Email address "<US005email>"
    And BS Click the Phone textbox and enter a valid Phone number "<US005phone>"
    Then BS Verify that this Phone textbox is not blank
    Then BS Verify that user is using digits for Phone textbox
    And BS Click the Appointment DateTime dropbox and select a valid date
    Then BS Verify selected date is one of following days
    And BS Click Send An Appointment Request button
    Then BS Verify appointment success message which is "Appointment Registration saved. We will you call you as soon as possible."
    Examples:
      |US005firstname|US005lastname|US005ssn       |US005email              |US005phone      |
      |Burak         |Sari         |425-58-3484    |burolabi@yopmail.com    |600-300-2000    |

  @US005positive
  Scenario Outline: Test02: Make an Appointment - Verify Sign In Check
    Given BS Launch web browser and navigate to the home page
    And BS Click Account Menu dropbox sign and click Sign In
    And BS Click User Name textbox and enter a valid user name "<US005username>"
    And BS Click Password textbox and enter a valid password "<US005password>"
    And BS Click Sign In button
    Then BS Verify sign in is successfully
    Examples:
      |US005username    |US005password|
      |adminburocan     |A1!b2c3      |

  @US005negative
  Scenario Outline: Test01N : Make an Appointment- Non-character sign used for First Name and Last Name
    Given BS Launch web browser and navigate to the home page
    And BS Click the Make an Appointment button
    And BS Click First Name textbox and Enter First Name "<US005wfirstname>"
    Then BS Verify user is using non-character for the First Name textbox - Negative
    And BS Click the Last Name textbox and enter Last Name "<US005wlastname>"
    Then BS Verify user is using non-character for the Last Name textbox - Negative
    And BS Click the SSN textbox and enter SSN number "<US005wssn>"
    Then BS Verify user also uses non-digit for SSN textbox Negative
    And BS Click Email textbox and enter a valid Email address "<US005wemail>"
    Then BS Verify user doesn't use @ and . sign Negative
    And BS Click the Phone textbox and enter a valid Phone number "<US005wphone>"
    Then BS Verify that user is also using non-digit for Phone textbox Negative
    And BS Click the Appointment DateTime dropbox and select a valid date
    And BS Click Send An Appointment Request button
    Then BS Verify appointment success message which is "Appointment Registration saved. We will you call you as soon as possible."
    Examples: Appointment test data
      |US005wfirstname |US005wlastname|US005wssn        | US005wemail            | US005wphone    |
      |Buro05          |Saro8         |2a-5c-348b       |burolabi^yopmailcom     | 60a-c06-200032d |

