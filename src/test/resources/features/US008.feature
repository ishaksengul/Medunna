

@Rozi
  Feature: US_008 Kullanıcı giriş yaptığında Password sekmesi düzenlenebilir olmalıdır.


    Background:

    #Scenario: Background

      Given Kullanici anasayfaya gider
      Then Kullanici Account Menu iconuna tiklar
      And Kullanici Sign in butonuna tiklar
      And Kullanici username girer "<username>"
      And Kullanici password girer "<password>"
      Then Kullanici Account Menu iconuna tiklar
      And Kullanici Password butonuna tiklar
      And Kullanici gecerli sifreyi girer "<password>"


    Scenario: TC_01 "New password confirmation" onaylanabilmelidir

      Then Kulanici yeni sifre girer
      And Kulanici tekrar yeni sifreyi girer
      Then New password confirmation onaylanabilmelidir



    Scenario: TC_02 Şifre için en az 1 küçük harf olmalı ve "Password strength:" seviyesinin değiştiği görülebilmelidir
      Then Kullanici en az 1 küçük harf iceren yeni sifre girer
      And Kullanici "Password strength:" seviyesinin değiştiğini dogrular


    Scenario: TC_03 Şifre en az 1 büyük harf içermeli ve  "Password strength:" seviyesinin değiştiği görülebilmelidir
      Then Kullanici en az 1 büyük harf içeren yeni sifre girer
      And Kullanici "Password strength:" 4 seviyesinin değiştiğini dogrular


    Scenario: TC_04 Şifre en az 1 rakam içermeli ve "Password strength:" seviyesinin değiştiği görülebilmelidir

    Then Kullanici en az 1 rakam içeren yeni sifre girer
      And Kullanici "Password strength:" seviyesinin değiştiğini dogrular

    Scenario: TC_05 Şifre en az 1 özel karakter içermeli ve "Password strength:" seviyesinin değiştiği görülebilmelidir

      Then Kullanici en az 1 özel karakter içeren yeni sifre girer
      And Kullanici "Password strength:" 4 seviyesinin değiştiğini dogrular

    Scenario: TC_06 Güçlü bir parola için şifre en az 7 karakterden oluşmalıdır

      Then Kullanici en az 7 karakterden oluşan yeni sifre girer
      And Kullanici "Password strength:" son seviyesinin değiştiğini dogrular


    Scenario: TC_07 Eski şifre kullanılmamalıdır

      Then Kullanici en az 7 karakterden oluşan yeni sifre girer
      Then Kullanici tekrar yeni sifreyi girer
      And Save Butonuna tiklar
      Then Kullanici Account Menu iconuna tiklar
      And Kullanici Sign out butonuna tiklar
      Then Kullanici Account Menu iconuna tiklar
      And Kullanici Sign in butonuna tiklar
      Then Kullanici username girer "<username>"
      And Kullanici password girer "<password>"
      And Sign in butonuna tiklarr
      Then Failed to Sign yazisinin gorunurlugunu dogrular


