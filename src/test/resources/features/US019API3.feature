@Rm

Feature:US_019 Admin olarak; Yeni Staff (Personel) Olusturma / Guncelleme / Goruntuleme ve Silme

  Scenario:

    Given Kullanıcı staff sorgusu icin get path params ayarını yapar
    And Kullanıcı staff ile alakalı expected dataları olusturur
    And Kullanıcı staff icin request gonderirir ve response alır
    And Kullanıcı  response status sorgusunu yapar
    And Kullanıcı staff dogrulama islemini yapar