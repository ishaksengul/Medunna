Feature: US024  Test Data
  @TC001
  Scenario: Hasta hesabina girdiginde test sonuclarini gorebilmelidir
    Given hasta "{MedunnaUrl}" adresine gider
    Given hasta Sign in  butonuna basar
    And hasta positive_login yapar
    And hasta MyAppointments sayfasina gider
    And hasta ShowTests butonuna tiklar
    And hasta ViewResults butonuna tiklar
    Then hasta test sonuclarini gorur


  @TC002
  Scenario: Hasta faturasini gorebilmelidir
    Given hasta fatura icin "{MedunnaUrl}" adresine gider
    And hasta fatura icin Sign in  butonuna basar
    And hasta positive login yapar
    And hasta MyAppointments sayfasina gider
    And hasta showInvoice butonuna tiklar
    Then hasta faturasini  gorur