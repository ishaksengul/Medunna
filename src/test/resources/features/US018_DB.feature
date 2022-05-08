Feature: US018 DB
  @data
  Scenario: DB ile doktor dogrulama
    Given Kullanici bilgileri kullanarak Medunna DB baglanti kurarr.
    And Query ve column data gonderirr.
    Then doktor bilgisini dogrularr.