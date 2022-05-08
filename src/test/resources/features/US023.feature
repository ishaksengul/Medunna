Feature:UC 23
  Background:
    Given Kullanici anasayfaya gider
    Then Kullanici Account Menu iconuna tiklar
    And Kullanici Sign in butonuna tiklar
    And Kullanici Username kismina valid staff deger girer.
    And Kullanici Password kismina valid staff deger girer ve Sign In butonua tiklar.
    And Kullanici Kullanici My Pages yazisina tiklar.
    And Kullanici acilan alt menude Seach Patient yazisina tiklar.

  Scenario: TC01 Kullanici(Staff) fatura olusturabilmeli

    And Kullanici Patients SSN kismina Patient SSN degeri girer.
    And Kullanici acilan sayfada Patient icin Show Appointments kismina tiklar.
    And Kullanici acilan sayfada Payment Invoice Process butonuna tiklar.
    And Kullanici Payment Detail ekranindan Creat Invoice kismina tiklar.
    And Kullanici Create or Edit a Bill sayfasinda patient odeme turunu secer ve Save tusuna basar.
    And Kullanici A Bill is updated with identifier mesajini aldigini dogrular.


  Scenario: TC02 Bu portalda, hastanın fatura oluşturabilmesi için durumu tamamlandı veya İptal edildi olması gerekir.

    And Kullanici Patients SSN kismina Patient SSN degeri girer.
    And Kullanici acilan sayfada Patient icin Show Appointments kismina tiklar.
    Then Kullanici Appointments sayfasinda Status kisminda Completed ya da Cancelled yazisinin goruldugunu dogrular.


  Scenario: TC03 Kullanıcı, Muayene ücreti, test ürün fiyatları gibi tüm faturaları görüntüleyebilir ve  hasta için yeni bir fatura oluşturabilir.

    And Kullanici Patients SSN kismina Patient SSN degeri girer.
    And Kullanici acilan sayfada Patient icin Show Appointments kismina tiklar.
    And Kullanici acilan sayfada Payment Invoice Process butonuna tiklar.
    And Kullanici Payment Detail sayfasindan test ve muayene ucretlerinin goruldugunu dogrular.


  Scenario: TC04 Kullanıcı daha sonra hastaya gönderilen faturayı görebilir

    And Kullanici Patients SSN kismina Patient SSN degeri girer.
    And Kullanici acilan sayfada Patient icin Show Appointments kismina tiklar.
    And Kullanici acilan sayfada Payment Invoice Process butonuna tiklar.
    And Kullanici Patient Detail sayfasinda Show Invoice yazisina tiklar.
    Then Kullanici acilan sayfada INVOICE yazisinin oldugunu dogrular.

