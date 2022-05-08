Feature: US028
  @Us28
  Scenario:Admin yeni bir ulke olusturabilir
    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "AdminEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG admin items&titles ikonuna tiklar
    And EG admin contry sayfasina gider
    And EG admin create a new country e tiklar
    And EG admin yeni bir ulke adi girer
    And EG admin ulkeyi kayit etmek icin save butonuna basar
    Then EG kullanici uygulamayi kapatir

@emr1
  Scenario:Admin yeni bir ulke silebilir
    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "AdminEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG admin items&titles ikonuna tiklar
    And EG admin contry sayfasina gider
    Then EG kullanici uygulamayi kapatir




