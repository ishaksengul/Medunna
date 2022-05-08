Feature:Test items(öğe) Oluştur / Güncelle / Sil DataBase

  Scenario: API ile olusturulan test itemini DB ie dogrula
    Given Kullanici DB kullanarak bir baglanti olusturur
    And Kullanici DataBase e sorgulama yapar ve verileri alir
    Then Gelen test item larini dogrular
