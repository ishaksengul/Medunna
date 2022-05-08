@ApiRegistrant
Feature:Test items(öğe) Oluştur / Güncelle / Sil
  @TC005
  Scenario: admin API ile dogrulama yapar
    Given kullanici gerekli items icin path params ayarlamalarini yapar
    And kullanici test items olusturmak icin expected datalari olusturur
    And kullanici items icin request gonderir ve response alir
    Then kullanici API kayitlarini onaylar


  @TC006
  Scenario: admin API ile test item olusturur
    Given Kullanici gerekli POST islemi icin path params ayarlamalarini yapar
    And kullanici post islemi icin expected datalari olusturur
    And Kullanici POST islemi gonderir ve yanit alir
    Then Kullanici Post islemi icin api verilerini dogrular