Feature: US 22
@US022TC01
Scenario: Kullanıcı (Staff) hastanın SSN id ie arama yapabilir.

    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "StaffEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG staff myPages e tiklar
    And EG staff search patient sayfasina gider
    And EG staff search ssn kutusuna hastanin ssn ini yazar
    And EG staff ssn ini girdigi hastayi bulur
    Then EG kullanici uygulamayi kapatir

  @US022TC02
  Scenario:Kullanıcı (Staff) "ID, Date, Result, description, Created date, ..." gibi sonuç bilgileini görebilmeli ve
  güncelleyebilmelidir.

    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "StaffEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG staff myPages e tiklar
    And EG staff search patient sayfasina gider
    And EG staff edit butonuna tiklar
    And EG staf ciyesiyeti other yapar ve kaydeder
    And EG degisikligin onaylandigini gorur
    Then EG kullanici uygulamayi kapatir









