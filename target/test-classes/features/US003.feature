@US003
Feature: US003 Passwords Strength
  @TC001
  Scenario Outline: TC001_Daha guclu sifre icin en az 1 kucuk harf olmali

    Given kullanici "{MedunnaURL}" adresine gider
    And kullanici giris yapip dropdown una tiklar ve register secenegine tiklar
    Then kullanici password bolumune kucuk harfli  "<Password>" yazarak PasswordStrength in degistigini test eder

    Examples:
    #kullanici kucuk harfi en sonda ve ya ozel karatkerden sonra da yaza bilecegi icin tum sartlar kontrol edilir
    # default olarak sifre kucuk harfle basladiginda "password strength" en kucuk degerini alir.

      |Password|
      |MURATTa|
      |MUrat123|
      |MUrat123!|


  @TC002
  Scenario Outline: Sifre en az 1 buyuk harf icermeli ve  "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Given kullanici "{MedunnaURL}" adresine gider
    And kullanici giris yapip dropdown una tiklar ve register secenegine tiklar
    Then kullanici password bolumune buyuk harfli  "<Password>" yazarak PasswordStrength in degistigini test eder
    Examples:
    #kullanici buyuk harfi en sonda ve ya ozel karakterden sonra da yaza bilecegi icin tum sartlar kontrol edilir
    # default olarak sifre buyuk harfle basladiginda "password strength" en kucuk degerini alir.
      |Password|
      |fsdafasdfaS|
      |asdfAS123|
      |asdsDF123!|

  @TC003
  Scenario Outline: Sifre en az 1 rakam icermeli ve  "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Given kullanici "{MedunnaURL}" adresine gider
    And kullanici giris yapip dropdown una tiklar ve register secenegine tiklar
    Then kullanici password bolumune rakam iceren  "<Password>" yazarak PasswordStrength in degistigini test eder

    Examples:
    #kullanici rakami en sonda ve ya ozel karakterden sonra da yaza bilecegi icin tum sartlar kontrol edilir
    # default olarak sifre rakamla basladiginda "password strength" en kucuk degerini alir.
      |Password|
      |123aaaa |
      |aaAS123!|
      |asA12345|
  @TC004
  Scenario Outline: Sifre en az 1 ozel karakter icermeli ve  "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Given kullanici "{MedunnaURL}" adresine gider
    And kullanici giris yapip dropdown una tiklar ve register secenegine tiklar
    Then kullanici password bolumune ozel karakter iceren  "<Password>" yazarak PasswordStrength in degistigini test eder

    Examples:
    #kullanici ozel karakteri en sonda ve ya ozel karakterden sonra da yaza bilecegi icin tum sartlar kontrol edilir
    # default olarak sifre ozel karakterle basladiginda "password strength" en kucuk degerini alir.
      |Password|
      |!$%aaaa |
      |aaAS123!|
      |asA!!*&^|

  @TC005
  Scenario Outline: Guclu bir parola icin sifre en az 7 karakterden olusmalidir.
    Given kullanici "{MedunnaURL}" adresine gider
    And kullanici giris yapip dropdown una tiklar ve register secenegine tiklar
    Then girilmis "<Password>" karakter sayisinin en az 7 ve uzeri olmasini test eder


    Examples:
      |Password|
      |Murat1! |