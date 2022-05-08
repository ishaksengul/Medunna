Feature: US07 TC01

  @007TC01
  Scenario Outline: hasta randevu alirken gecerli tarih girmelidir

    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "PatientEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG hasta MY PAGES elementine tiklar
    And EG hasta Make an appointment secenegine tiklar
    And EG hasta telefon numarasi girer
    And EG hasta EG hasta tarih olarak eski tarih "<eskiTarih>" girer
    And EG hasta Appointment date can not be past date! yazisini gorunur
    And EG hasta tarih olarak guncel tarih "<guncelTarih>" girer
    And EG hasta send an appointment request secenegine tiklar
    Then EG kullanici uygulamayi kapatir

    Examples: test-data
      |eskiTarih|guncelTarih|
      |01.01.1995  |02.02.2023|
      |02.14.1914  |06.08.2022 |


@007TC02
  Scenario: HastaTarih sırası gün/ay/yıl  formatinda guncel tarih girer

    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "PatientEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG hasta MY PAGES elementine tiklar
    And EG hasta Make an appointment secenegine tiklar
    And EG hasta telefon numarasi girer
    And EG hasta tarih olarak guncel tarih "02.02.2023" girer
    Then EG kullanici uygulamayi kapatir


  @007TC02
  Scenario: Hasta Tarih sırası gün/ay/yıl  formatinda guncel tarih girer
    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "PatientEmr" girer
    And EG Kullanici Password kutusuna "Asdf1!" girer
    And EG Kullanici sign in butonuna tiklar
    And EG hasta MY PAGES elementine tiklar
    And EG hasta Make an appointment secenegine tiklar
    And EG hasta telefon numarasi girer
    And EG hasta yil-ay-gun formatinda tarih girer
    And EG hasta Appointment date can not be past date! yazisini gorunur
    Then EG kullanici uygulamayi kapatir
