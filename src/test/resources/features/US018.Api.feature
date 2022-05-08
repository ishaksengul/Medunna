@ApiRegistrant
Feature: US_018 Medunna Api
  Scenario: API kullanarak doktorları doğrulayın
    Given Admin, doktor okuması için path parametrelerini ayarlar
    And Admin, "birthDate", "firstName", "id", "lastName" bilgileri ile expected datayi olusturur
    And Admin, doktor okuması için request gönderir ve responce alır
    Then Admin, doktor okuması için API kayıtlarını doğrular
