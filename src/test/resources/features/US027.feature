@mesaj
  Feature:Medunna Health US027 Messages by Admin  Validate with API and DB
    Background: Medunna sayfasina gitme
      When kullanici 'medunnaUrl' sayfasina gider
      Given Insan figurune tiklar
      And Sign in butonuna tiklar.
      And "adminfadime" kutusuna gecerli bir username girer
      And "Batch44+" kutusuna gecerli  bir  password girer
      And Sing in1 butonuna tiklar
      And Items&Titles  menusune  tiklar
      And Messages menusune tiklar

 Scenario: Admin, mesaj portalına gidebilir ve tüm mesajları, yazarlarını ve e-postalarını görüntüleyebilir.


      And Messages yazisinin goruntulendigini test eder
      And Account menuye tiklar
      Then  Sign out butonuna tiklar

   Scenario Outline: Admin, mesajları oluşturabilir.

     And Create a new message butonuna tiklar
     And "<name>"  name giriniz
     And "<email>" email giriniz
     And "<Subject>" Subject giriniz
     And "<Message>"  Message giriniz
     And save buttonuna tiklar
     And A new message is created with identifier 43764 yazisini dogrulayin
     And Account menuye tiklar
     Then Sign out butonuna tiklar

     Examples:
       | name   | email          | Subject | Message |
       | fadime | gg@medunna.com | temizlik | temizlik sifir|

    @mesaj1
   Scenario Outline: Admin mesajlari güncelleyebilir.

     And edit butonuna tiklar
     And "<name>"  name yaziniz
     And "<email>" email yaziniz
     And "<Subject>" Subject yaziniz
     And "<Message>" Massage yaziniz
     And save buttonuna tiklar
     And  message is updated with identifier 43764 mesayini dogrulayin
     And Account menuye tiklar
     Then Sign out butonuna tiklar

     Examples:
        | name  | email      | Subject | Message |
        | yasin | yy@medunna.com | randevu | randevu alamiyorum|

   Scenario: :  Admin mesajlari silebilir.
     And Delete butonuna tiklar
     And Acilan menuden delete butonuna tiklar
     And A message is deleted with identifier 43765 mesajini dogrulayin
     And Account menuye tiklar
     Then Sign out butonuna tiklar
