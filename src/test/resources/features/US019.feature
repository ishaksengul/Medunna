Feature:US_019 Admin olarak; Yeni Staff (Personel) Olusturma / Guncelleme / Goruntuleme ve Silme



  Background:
    Given Kullanici anasayfaya gider
    Then Kullanici Account Menu iconuna tiklar
    And Kullanici Sign in butonuna tiklar
    Then Kullanici Username ve password bilgileriyle giris yapar
    And Item Titles linkine tiklar
    And Staff linkine tiklar

  Scenario:TC_01 Admin SSN kullanarak; kayitli kisiler arasında Staff arayabilir

    And Create a new butonuna tiklar
    Then Create or edit a staff yazisini dogrular
    Then Use Search radio butonunu tiklar
    And Aratmak istedigi SSN numarasini girer
    Then Search User butonuna tiklar
    And User found with search SSN yazisini dogrular
    Then Sayfayi kapatir

  Scenario: TC_02 Tüm bilgileri doldurulmalidir

    Then Create a new butonuna tiklar
    And Olusturmak istedigi Staff in SSN-FirstName-LastName-Birth Date -Phone-Gender-Blood Group-Address-Description: bilgilerini girer
   #Then User seciminde ilgi secimi yapar
   #And Country ve State city secmini yapar
    Then Kullanici Save butonuna tiklar
    And Kaydin yapildigina dair yaziyi dogrular
    Then Sayfayi kapatir

  Scenario: TC_03 Admin kayitli kisilerden bir kullanici secebilir

    Then Secmek istedigi kisinin ID numarasina tiklar
    And Gelen sayfada Staff yazisini dogrular
    Then Sayfayi kapatir

  Scenario: TC_04 Admin kullanici bilgilerini duzenleyebilir

    Then Duzenlemek istedigi kullanicinin Edit butonuna tiklar
    And Guncellemek istedigi bilgileri girer
    Then Kullanici Save butonuna tiklar
    And Staff is updates with identifier yazisi goruntulendigi dogrulanir
    Then Sayfayi kapatir


  Scenario: TC_05 Admin kullanici bilgilerini silebilir

    Then Silmek istedigi staffi DELETE butonuna tiklar
    And  Confirm delete operation yazisi dogrulanir
    Then Delete butonu tiklani
    And staff is deleted identifier yazisi dogrulanir
    Then Sayfayi kapatir

  Scenario: TC_06 API ile dogrulayin

  Scenario: TC_07 DB ile dogrulayin


