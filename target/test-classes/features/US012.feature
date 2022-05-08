@zor
Feature: Medunna Health US012 Physician (Doktor) test isteyebilmeli
  (My Appointments/Edit/Request A Test)
  Background: Medunna sayfasina gitme
    When kullanici 'medunnaUrl' sayfasina gider
    Given Insan figurune tiklar
    And Sign in butonuna tiklar.


  Scenario Outline: TC_01201 Doctor test isteyebilmeli "Request A Test"
  (My Appointments/Edit/Request A Test)
    And "<Username>" kutusuna gecerli bir us012Ph_username girer
    And "<Password>" kutusuna gecerli bir us012Ph_password girer
    And  singInButonu1  butonuna tiklar
    And My page menusune tiklar
    And My appointements butonuna tiklar
    And Hastasini secip Edit butonuna tiklar
    And Request a test butonuna tiklar
    And Test Items yazisinin goruldugunu test eder
    And Account menuye tiklar
    And Sign out butonuna tiklar


    Examples:
      | Username | Password |
      | drfadime | Batch44+ |

 Scenario Outline: TC_01202 Test içeriğinde "Glucose, Urea, Creatinine, Sodium
 Potassium, Total protein, Albumin, Hemoglobin" seçenekleri olmalı

   And "<Username>" kutusuna gecerli bir us012Ph_username girer
   And "<Password>" kutusuna gecerli bir us012Ph_password girer
   And  singInButonu1  butonuna tiklar
   And My page menusune tiklar
   And My appointements butonuna tiklar
   And Hastasini secip Edit butonuna tiklar
   And Request a test butonuna tiklar
    And Secilen testlerin sag taraftaki butonlarina tiklar
    And Save butonuna tiklar
    And "A new is created with identifier 42799" yazisinin goruldugunu test eder
   And Account menuye tiklar
   Then  Sign out butonuna tiklar

   Examples:
     | Username | Password |
     | drfadime | Batch44+ |



