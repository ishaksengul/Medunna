Feature:  US_009 Staff Operations

  Background:
    Given Personel "medunnaUrl" URL'ye gideer
    And Personel Kayit menusuundeki Sign in butonuna tiiklar
    And Personel olaraak Login islemi gerceklestirilir
    Then Personel My Page sekmesiine tiklar

  @TC01
  Scenario:TC_01 Personel "MyPage" sekmesinde belirtilen sütunlara sahip bir tabloda hasta bilgilerini görebilmelidir.
    Given My Page sekmesinin aaltindaki Search Patient sekmesine tiklanir
    Then Hasta bilgiilerini olusturan Tablo basliklariyla dogrulama yapilir

  @TC02
  Scenario: TC_02 Personel(Staff), hasta(Patient) bilgilerinin farkli bilesenlerini duzenleyebilmelidir.
    Given Search Patient sekmesine tiklaniir ve SSN numarasiyla hasta aratilir.
    And Search Patient sayfasinda aratilan hasta iciin Edit butonuna tiklanir.
    Then Farkli bilesenlerde duzenleme yapilir vee kaydedilir
    And Sayfanin sol uust kosesinde dogrulama gozlemlenebilmelidir.

  @TC03
  Scenario: TC_003 tüm kayıt bilgilerinin doldurulduğunu gorme
    And Search Patient sekmesine tiklaniir ve SSN numarasiyla hasta aratilir.
    Then  Kullanici  girilen  SSN  tuum bilgilerinin dolduruldugunu gorur

  @TC04
  Scenario: TC_04 Kullanıcı herhangi bir hasta bilgisini silebilirr.
    Given Search Patient sekmesine tiklaniir ve SSN numarasiyla hasta aratilir.
    And Search Patient sayfasinda aratilan hasta iciin Edit butonuna tiklanir.
    Then Bilesenlerden biri(firstname) silinir ve Save butonuna tiiklanir.

  @TC05
  Scenario: TC_05 Personel(Staff) hasta bilgilerini silme fonskiyonunu yerine getirememelidir.
    Given Search Patient sekmesine tiklaniir ve SSN numarasiyla hasta aratilir.
    And Hasta bilgisindee Delete butonunun olmadigi gozlemlenmelidir.

  @TC06
  Scenario: TC_06 Staff, hastaları SSN kimliklerine göre arayabilmelidir.
    Given Search Patient seekmesine tiklanir.
    And Patient SSN textbox ina SSN numaarasi girilir.
    Then Kullanici girilen SNN ile bilgilerin ciktigini teest eder




















