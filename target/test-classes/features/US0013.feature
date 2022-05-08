
@run
Feature: Medunna Health US0013 Physician (Doktor) "Test Results" işlemleri yapabilmeli
  (My Appointments / Edit / Test Results)
  Background: Medunna sayfasina gitme
    When kullanici 'medunnaUrl' sayfasina gider
    Given Insan figurune tiklar
    And Sign in butonuna tiklar.

  Scenario Outline:  TC_01301 Test sonuçları talep edildikten ve Staff test sonuçlarını güncelledikten sonradoktor "id, name(Urea, Sodium, Glucose etc..),
  default max value, default min value, test, description and the date" bilgilerini görebilmeli
    And "<StaffUsername>" kutusuna gecerli bir username girer
    And "<StaffPassword>" kutusuna gecerli bir password girer
    And  singInButonu1  butonuna tiklar
    And My page menusune tiklar
    And Search patient butonuna tiklar
    And Patient SSN kutucuguna hastanin SSN num yazar
    And Show appointements butonuna tiklar
    And Show tests butonuna tiklar
    And View results butonuna tiklar
    And Urea testin Edit butonuna tiklar Staff guncelleme yapar Save butonuna tiklar
    And Account menuye tiklar
    And Sign out butonuna tiklar
    And Insan figurune tiklar
    And Sign in butonuna tiklar.

    And "<Username>" kutusuna gecerli bir us012Ph_username girer
    And "<Password>" kutusuna gecerli bir us012Ph_password girer
    And  singInButonu1  butonuna tiklar
    And My page menusune tiklar
    And My appointements butonuna tiklar
    And Hastasini secip Edit butonuna tiklar


  And Show Test Results butonuna tiklar
  And Hastanin View Results butonuna tiklar
  And Test Results yazisinin goruldugunu test eder
    And Account menuye tiklar
    Then  Sign out butonuna tiklar

    Examples:
    |StaffUsername | StaffPassword| Username | Password |
      | stafffadime | Batch44+ | drfadime | Batch44+ |

    Scenario:  TC_01302 Doktor "Request Impatient" (hastanın yatılı tedavi görmesi) isteğinde bulunabilmeli

      And "Username" kutusuna gecerli bir us012Ph_username girer
      And "Password" kutusuna gecerli bir us012Ph_password girer
      And  singInButonu1  butonuna tiklar
      And My page menusune tiklar
      And My appointements butonuna tiklar
      And Hastasini secip Edit butonuna tiklar
    And Request inpatient butonuna tiklar
    And "A new in Patient is created with identifier 47768" yazisinin goruldugunu test eder
      And Account menuye tiklar
      Then  Sign out butonuna tiklar

