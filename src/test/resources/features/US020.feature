Feature: US020 Admin kullanici active testi testi

  @US020
  Scenario: TC20_01 Admin, kayitli kisilerin "firstname, lastname, email... Gibi bilgilerini görebilmeli.
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng admin girisi yapilir
    And ng admin sifre girisi yapilir
    And ng admin menü girisi yapilir
    And ng view girisi yapilir
    And ng admin view bilgilerini görür
    Then ng sayfayi kapatir

  @US020
  Scenario: TC20_02 Admin, kayitli kisilerin bilgilerini degistirebilmeli.
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng admin girisi yapilir
    And ng admin sifre girisi yapilir
    And ng admin menü girisi yapilir
    And ng admin Edit girisi yapar
    And ng admin RoleUser secimi yapar
    Then ng sayfayi kapatir

  @US020
  Scenario: TC20_03 Admin, kullanıcıları silebilir.
    Given ng kullanici medunna sayfasina gider
    And ng Register bölümüne gelir
    And ng admin girisi yapilir
    And ng admin sifre girisi yapilir
    And ng admin menü girisi yapilir
    And ng admin Delete secimi yapar
    Then ng sayfayi kapatir





