@US017
  Feature: Test items(öğe) Oluştur / Güncelle / Sil

    Background:
      Given is kullanici medunna sayfasina gider
      And is kullanici admin olarak giris yapar
      And is items&title butonuna tiklar
      And is test item linkine tiklar

    @TC001
    Scenario: Admin yeni test öğeleri oluşturabilir

      Given is create a new item buttonuna tiklar
      And is test olusturma ekraninda name box a isim girer
      And is description box a test aciklamasini girer
      And is test fiyat kutusuna ucreti girer
      And is testin min. deger boxina min degeri girer
      And is testin max. deger boxina max degeri girer
      And is save button a tiklar
      And is testlerin bulundugu tabloda created date buttonuna tiklar
      Then ilk satirda Ure testinin oldugunu dogrular


    @TC002
    Scenario: Admin, "test items; Name, Description, price Default min value, Default max value ve
    created date (Gün/Ay/Yıl) oluşturabilir ve güncelleyebilir.

      Given is create a new item buttonuna tiklar
      And is test olusturma ekraninda name box a isim girer
      And is description box a test aciklamasini girer
      And is test fiyat kutusuna ucreti girer
      And is testin min. deger boxina min degeri girer
      And is testin max. deger boxina max degeri girer
      And is save button a tiklar
      And is testlerin bulundugu tabloda created date buttonuna tiklar
      And is ilk satirda gelen Ure testinin edit buttonuna tiklar
      And is test guncelleme ekraninda name box a guncellenecek isim girer
      And is description box a guncellenecek test aciklamasini girer
      And is test fiyat kutusuna guncellenecek ucreti girer
      And is testin min. deger boxina guncellenecek min degeri girer
      And is testin max. deger boxina guncellenecek max degeri girer
      And is save button a tiklar
      Then is ilk satirda gelen Ure_New testini dogrular

    @TC003
    Scenario: Admin test öğelerini görüntüleyebilir.

      Given is test ogelerinin goruntulenebildigini dogrular

    @TC004
    Scenario: Admin test öğelerini silebilir.

      Given is create a new item buttonuna tiklar
      And is test olusturma ekraninda name box a isim girer
      And is description box a test aciklamasini girer
      And is test fiyat kutusuna ucreti girer
      And is testin min. deger boxina min degeri girer
      And is testin max. deger boxina max degeri girer
      And is save button a tiklar
      And is testlerin bulundugu tabloda created date buttonuna tiklar
      And is ilk satirda gelen Ure testinin delete ikonuna tiklar
      And is acilan ekranda delete buttonuna tiklar
      Then is silinen ogeyi dogrular








