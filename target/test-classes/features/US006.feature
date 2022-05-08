Feature:06_TC_01_Kullanıcı bilgileri


@006TC01
  Scenario Outline:  "firstname, lastname, email" girerken doldurulan kullanıcı bilgileri olmalıdır
    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "<username>" girer
    And EG Kullanici Password kutusuna "<password>" girer
    And EG Kullanici sign in butonuna tiklar
    And EG Kullanici sag ust kosede bulunan kullanici ismine tiklar
    And EG Kullanici settings secenigine tiklar
    And EG Firstname kutusundaki isim kayit olurken girilen "<firstname>" olmali
    And EG last name  kutusundaki soy isim kayit olurken girilen "<lastname>" olmali
    And EG email kutusundaki mail adresi  kayit olurken girilen "<email>" olmali
    And EG kullanici uygulamayi kapatir



    Examples:test_data
      |username|password|firstname|lastname|email|
      |DoctorEmr |Asdf1!|Doctor |Emr       |asdf@gmail.com|
      |PatientEmr|Asdf1!|Patient|Emr       |asdfg1@gmail.com|
      |StaffEmr|Asdf1!|Staff    |Emr       |asdfghjk@gmail.com|

  @006TC02 @006TC03 @006TC04
  Scenario Outline:
    Given EG Kullanici medunna.com adresine gider
    And EG Kullanici Account Menu ikonuna tiklar
    And EG Kullanici sign in secenegine tiklar
    And EG Kullanici username kutusuna "<username>" girer
    And EG Kullanici Password kutusuna "<password>" girer
    And EG Kullanici sign in butonuna tiklar
    And EG Kullanici sag ust kosede bulunan kullanici ismine tiklar
    And EG Kullanici settings secenigine tiklar
    And EG kullanici firstname kutusuna yeni "<newFirstname>" yazar
    And EG kullanici lastname kutusuna yeni "<newLastname>" yazar
    And EG kullanici email kutusuna yeni "<newEmail>" yazar
    And EG kullanici save butonuna basar ve degisiklikleri kaydeder
    Then EG kullanici uygulamayi kapatir


    Examples: test-data
      |username|password|newFirstname|newLastname|newEmail|
      |DoctorEmr |Asdf1!|Doctor |Emr       |asdf@gmail.com|
      |PatientEmr|Asdf1!|Patient|Emr       |asdfg1@gmail.com|
      |StaffEmr|Asdf1!|Staff    |Emr       |asdfghjk@gmail.com|