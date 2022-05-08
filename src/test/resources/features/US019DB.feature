
  Feature: DataBAse testi
    # id no 83559


    Scenario:
      Given Kullanici DB kullanarak baglanti olusturur
      And Kullanici query degeri gonderir ve column degerlerini alir
      Then Kullanici olusturulan staffi dogrular
