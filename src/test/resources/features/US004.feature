@SignInPage
Feature: Login page should accessible only with valid credentials

  @login
  Scenario Outline: Verifying user login with correct username and password

    Given BS navigate to Medduna Home Page
    When BS Verify that home page is visible successfully
    When BS Click on Account DropDownMenu button
    When BS Click on Sign in
    And BS Verify Sign in Header is visible
    Then BS Click on Username input box.
    Then BS Enter Valid "<username>" Username
    Then BS Click on Password input box.
    Then BS Enter Valid "<password>" Password
    Then BS Click on Sign in button
    When BS Click on Account DropDownMenu button
    And Verify that Sign Out  is displayed
    Examples:
      | username    | password        |
      | adminburocan | A1!b2c3 |

  @cancelLogin
  Scenario Outline: There should be a cancel login option
    Given BS navigate to Medduna Home Page
    When  BS Verify that home page is visible successfully
    When BS Click on Account DropDownMenu button
    When BS Click on Sign in
    And BS Verify Sign in Header is visible
    Then BS Click on Username input box.
    Then BS Enter Valid "<username>" Username
    Then BS Click on Password input box.
    Then BS Enter Valid "<password>" Password
    Then BS Verify that Cancel button is enable

    Examples:
      | username    | password        |
      | adminburocan | A1!b2c3 |

  @rememberMe
  Scenario Outline: There should be a remember me option

    Given BS navigate to Medduna Home Page
    When  BS Verify that home page is visible successfully
    When BS Click on Account DropDownMenu button
    When BS Click on Sign in
    And BS Verify Sign in Header is visible
    Then BS Click on Username input box.
    Then BS Enter Valid "<username>" Username
    Then BS Click on Password input box.
    Then BS Enter Valid "<password>" Password
    And BS Verify that remember me checkbox is clickable
    Examples:
      | username    | password        |
      | adminburocan | A1!b2c3 |

  @didYouForget
  Scenario Outline: There should be an option to update password if forgotten 'Did you forget your password'

    Given BS navigate to Medduna Home Page
    When  BS Verify that home page is visible successfully
    When BS Click on Account DropDownMenu button
    When BS Click on Sign in
    And BS Verify Sign in Header is visible
    And BS Click on Did you forget your password? text box
    And BS Verify that Reset your password? Header is visible
    And BS Click on email text box
    And BS Enter the "<email>" address you used to register
    And BS Click on Reset password button
    And BS Verify Alert Check your emails for details on how to reset your password is visible

    Examples:
      | email                 |
      | burolabi@yopmail.com |


  @registration
  Scenario: There should be an option to navigate to registration page if not registered yet

    Given BS navigate to Medduna Home Page
    When  BS Verify that home page is visible successfully
    When BS Click on Account DropDownMenu button
    When BS Click on Sign in
    And BS Verify Sign in Header is visible
    And BS Verify You don't have an account yet? Register a new account is visible
    And BS Click on Register a new account
    And BS Verify that  Registration Page is visible

  @loginWrongPassword @Negative
  Scenario Outline: Verifying user login with correct username and wrong password
    Given BS navigate to Medduna Home Page
    When  BS Verify that home page is visible successfully
    When BS Click on Account DropDownMenu button
    When BS Click on Sign in
    And BS Verify Sign in Header is visible
    Then BS Click on Username input box.
    Then BS Enter Valid "<username>" Username
    Then BS Click on Password input box.
    Then BS Enter wrong "<wpassword>" Password
    Then BS Click on Sign in button
    Then Verify that Authentication information not correct  is displayed
    Examples:
      | username    | wpassword |
      | adminburocan | Admin123! |

  @loginWrongUsername @Negative
  Scenario Outline: Verifying user login with wrong username and correct password

    Given BS navigate to Medduna Home Page
    When  BS Verify that home page is visible successfully
    When BS Click on Account DropDownMenu button
    When BS Click on Sign in
    And BS Verify Sign in Header is visible
    Then BS Click on Username input box.
    Then BS Enter wrong "<wusername>" Username
    Then BS Click on Password input box.
    Then BS Enter Valid "<password>" Password
    Then BS Click on Sign in button
    And Verify that Authentication information not correct  is displayed
    Examples:
      | wusername | password        |
      | admin     | A1!b2c3 |

  @loginWrongUsernameAndWrongPassword @Negative
  Scenario Outline: Verifying user login with wrong username and wrong password

    Given BS navigate to Medduna Home Page
    When  BS Verify that home page is visible successfully
    When BS Click on Account DropDownMenu button
    When BS Click on Sign in
    And BS Verify Sign in Header is visible
    Then BS Click on Username input box.
    Then BS Enter wrong "<wusername>" Username
    Then BS Click on Password input box.
    Then BS Enter wrong "<wpassword>" Password
    Then BS Click on Sign in button
    And Verify that Authentication information not correct  is displayed
    Examples:
      | wusername | wpassword |
      | admin     | Admin123! |