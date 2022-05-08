Feature: US014 Physician Edit Inpatient islemleri


  Scenario: Doktor, Doktor olarak positive giris yapabilmeli
    Given doktor "{MedunnaUrl}" adresine gider
    And Doktor Sign in  butonuna tiklar
    Then Doktor positive log-in yapar
    And Doktor MY PAGES  My Inpatients butonuna tiklar
    And Doktor hasta bilgilerini key-value olarak gorur
    And Doktor Edit tusuna basar ve edit sayfasina yonlendirilir
    And Doktor hasta bilgilerini gunceller
    Then Doktor save butonuna basar

