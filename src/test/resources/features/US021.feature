Feature: US021 Staff hastalar için randevuları görür


  @US021
  Scenario: TC21_01 Staff sadece randevuları güncelleyebilir.
    Given ng kullanici medunna sayfasina gider
    And ng staff girisi yapilir
    And ng staff myPages girisi yapilir
    And ng staff Randevulari guncelleyebilir
    # And ng staff Randevu isimleri guncelleyebilir

  @US021
  Scenario: TC21_02 Staff hasta durumunu (status) degisiklik yapmalı.
    Given ng kullanici medunna sayfasina gider
    And ng staff girisi yapilir
    And ng staff myPages girisi yapilir
    And ng staff Randevulari guncelleyebilir
   # And ng staff Status guncelleyebilir





