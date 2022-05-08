Feature: US_026 Contact Page Basarili mesaj gonderimi



  Scenario: kullanici bilgi almak için "Contact portal" üzerinden istek gönderebilmeli.

    Given Kullanici Medunna sitesine gider
    And Kullanici Contact Butonuna tiklar ve contact sayfasina yonlenirilir
    And Kullanici verilerini girer ve mesajini yazip gonder butonuna basar
    Then Kullanici mesajinin basarili bir sekilde gonderildiginin onaylamasini gorur


