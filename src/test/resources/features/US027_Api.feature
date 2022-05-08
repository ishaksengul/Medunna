@ApiRegistrant
Feature:
  Scenario:
    Given Kullanici gerekli path parametrelerini ayarlar
    And Kullanici "id", "name", "email", "subject" "message" bilgileri ile expected datayi olusturur
    And Kullanici GET islemi gonderir ve yanit alir
    Then Kullanici api verilerini dogrular

  Scenario:
    Given Kullanici gerekli POST islemi icin path parametrelerini ayarlar
    And Kullanici "name", "email", "subject" "message" bilgileri ile POST islemi icin expected datayi olusturur
    And Kullanici POST islemi gonderir ve yanit alir
    Then Kullanici Post islemi icin api verilerini dogrular
