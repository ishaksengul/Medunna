Feature: US025  Test Data

Scenario: Patient can make a new appointment using their portal
  Given hasta appointment olusturmak icin "{MedunnaUrl}" adresine gider
  And hasta appointment olusturmak icin Sign in  butonuna tiklar
  And hasta positive login yapar
  And hasta Make an appointment sayfasina gider
  And hasta istenilen verileri doldurur ve send a request butonuna tiklar
Then hasta kayit basarili bildirimini gorur