Feature: US002 Medunna Sayfası Username e-mail testi

  @US002
  Scenario:TC_01 Gecerli bir "Username" olmalı
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng Username girisi yapilir
    Then ng Ekran Fotografi Cekilir


  @US002
  Scenario:TC_02 "@" ve "." olmadan email girilir
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng email alma bölümüne gelir gecersiz e mail girilir
    And ng e mail sonuclarin hata mesajı içerip icermedigini icerdigini test eder

  @US002
  Scenario:TC_03 e mail alanı boş bırakılamaz
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng email bos girilir
    Then ng sonuclarin bos email mesajı içerip icermedigini test eder




