Feature: US015

  @US015TC01 @US015TC03
  Scenario: TC01 Yeni hastalar yalnızca yönetici tarafından oluşturulabilir

    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "AdminEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG admin items&titles ikonuna tiklar
    And EG admin patient e girer
    And EG admin Create a new user secenegine tiklar
    And EG admin yeni kullanici olusturmak icin gerekli bilgileri girer
    And EG admin save butonuna tiklar
    And EG admin yeni hasta olusturuldu bildirimini gorur
    Then EG kullanici uygulamayi kapatir

  @US015TC0101
  Scenario:
    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "PatientEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG kullanici yeni hasta olusturma sayfasina erisemez
    Then EG kullanici uygulamayi kapatir

  @US015TC02
  Scenario: TC02 Yönetici "SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address,
  Description, Created Date, User, Country and state / City" gibi hasta bilgilerini görebilir.

    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "AdminEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG admin items&titles ikonuna tiklar
    And EG admin patient e girer
    And EG admin hastanin id ve adresini gorur
    Then EG kullanici uygulamayi kapatir

  @US015TC05
  Scenario: "State", "US state" olmalı ve boş bırakılmamalı
    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "AdminEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG admin items&titles ikonuna tiklar
    And EG admin patient e girer
    And EG admin Create a new user secenegine tiklar
    And EG admin yeni kullanici olusturmak icin State haric gerekli bilgileri girer
    And EG admin save butonuna tiklar
    And EG admin yeni hasta olusturuldu bildirimini goremez
    #Bug
    Then EG kullanici uygulamayi kapatir


  @US015TC06
  Scenario: Yönetici herhangi bir hastayı silebilir
    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "AdminEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG admin administration secenegine tiklar
    And EG admin usermanagement sayfasina gider
    And EG admin bir hastayi silmek icin delete e tiklar
    And EG admin hastanin silindigi mesajini alir
    Then EG kullanici uygulamayi kapatir
      #Bug