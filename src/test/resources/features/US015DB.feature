Feature: Us015Db
@Db
  Scenario: db ile patient dogrulama
    Given Admin bilgileri kullanarak Db ile baglanti kurar
    And admin query ve column data gonderir
    Then admin patient bilgisini dogrular

