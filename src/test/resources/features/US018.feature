Feature:  US_018 Medunna Admin Operations

  Background:

    Given Admin Personel "medunnaUrl" URL'ye gideer
    And Kayit menusune tiklaar.
    And Sign In butonuuna tiklar.
    And Admin olarak gecerli "Username" ve "Password" ile giris yaapar.
    Then Item&Titles secenegine tiiklar ve Physician butonuna tiklar.

  @TC1
  Scenario: TC001 Admin, SSN kimligine gore kayitli doktoru arayabilir, secebilir.
    Given Admin doktor listesinden rastgele SSN secer.
    And Create a new Phycisian butoonuna tiklar.
    And Use Search checkbox'ina tiklarr.
    And Arama textbox'ina doktor SSN numarasii girer.
    And Search Userr butonuna tiklar.
    And "User found with search SSN" yaziisini gorur.
    Then Admin oturumu kapatirr.

  @TC2
  Scenario: TC002 Admin, doktorun "Firstname, Lastname, Birth Date, Phone, Exam Fee bilgilerini" bilgilerini doldurulabilmelidir.
    Given Doktor listesinden rastgele bir doktor secip edit butonuna tiklar.
    And Firstname, Lastname, Birth Date, Phone,Gender, Blood Group,Address,Description,Created Date,User,Country ve State-City bilgilerini doldurur
    And Save butonuna tiklar.
    And A Physician is updated with identifier yazisi gorunur ve Admin bilgilerin kaydedildigini dogrular.
    Then Admin oturumu kapatirr.

  @TC3
  Scenario: TC003 Admin Doktor için herhangi bir uzmanlık alanı seçebilmelidir.
    Given Doktor listesinden rastgele bir doktor secip edit butonuna tiklar.
    And Admin, doktorun uzmanlik alanini secer.
    And Save butonuna tiklar.
    Then Admin oturumu kapatirr.

  @TC4
  Scenario: TC004 Admin, doktorun profil resmini sağlayabilir.
    Given Doktor listesinden rastgele bir doktor secip edit butonuna tiklar.
    And Admin doktorun profil resmini degistirebilir
    Then Admin oturumu kapatirr.

  @TC5
  Scenario: TC005 Admin mevcut kullanİcilar arasindan doktoru secmelidir
    Given Doktor listesinden rastgele bir doktor secip edit butonuna tiklar.
    And Admin User'dan doktor kullaniciyi secer
    Then Admin oturumu kapatirr.

  @TC6
  Scenario: TC006 Admin, doktorun muayene ucretini girebilmelidir.
    Given Doktor listesinden rastgele bir doktor secip edit butonuna tiklar.
    And Admin, doktorun muayene ucretini girer.
    And Save butonuna tiklar.
    Then A Physician is updated with identifier yazisi gorunur ve Admin bilgilerin kaydedildigini dogrular.

  @TC7
  Scenario: TC007 Admin, bütün doctorların bilgilerini görebilmelidir.
    Given Physicians yazisinin gorundugunu dogrular.

  @TC8
  Scenario: TC008 Admin, Doktorların bilgilerini düzenleyebilir.
    Given Edit butonu erisilebilir olmalidir.

  @TC9
  Scenario: TC009 Admin mevcut doktorları silebilir.
    Given Doktor listesinden rastgele bir doktor secip delete butonuna tiklar.
    And Ekrana cikan Modal-Content teki Delete butonuna tiklar.
    Then Internal server error toastify yazisi gorunur olmamalidir.


