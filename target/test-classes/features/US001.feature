Feature: US001 Medunna Sayfası SSN FirstName LastName testi

  @US001
  Scenario: TC01_01 SSN 9 rakam ve iki"-" den oluşmalı
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng SSN girisi yapilir
    Then ng Ekran Fotografi Cekilir


  @US001
  Scenario: TC01_02 Hatalı SSN girişi
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng hatali SSN girisi yapilir
    Then ng sonuclarin hata mesajı içerip icermedigini icerdigini test eder

  @US001
  Scenario: TC02 SSN alani bos birakilamaz
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng SSN alanı bos birakilir
    Then ng sonuclarin bos hata mesajı içerip icermedigini icerdigini test eder

  @US001
  Scenario: TC03 geçerli bir "First Name" olmalı
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng Veri girisi yapilir
    Then ng Ekran Fotografi Cekilir

  @US001
  Scenario: TC04 geçerli bir "lAST Name" olmalı
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng Veri girisi yapilir
    Then ng Ekran Fotografi Cekilir

