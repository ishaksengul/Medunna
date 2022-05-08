@ApiRegistration
Feature: US15 Api

  Scenario:Us api kullanarak hasta bilgilerini dogrulama

    Given hastalar icin path param ayarlanir
    And "id" "firstName" "lastName" ile expected datalari olusturur
    And hasta icin response alir
    And hasta icin api kaydi dogrulanir
