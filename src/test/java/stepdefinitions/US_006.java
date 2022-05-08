package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.Appointments;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_006 {

        Appointments appointments;

        @Given("EG Kullanici medunna.com adresine gider")
        public void eg_kullanici_medunna_com_adresine_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        appointments = new Appointments();
        Assert.assertTrue(appointments.welcomeToMedunna.isEnabled());

    }


        @Given("EG Kullanici Account Menu ikonuna tiklar")
        public void eg_kullanici_account_menu_ikonuna_tiklar() {
        appointments = new Appointments();
        appointments.girisIkonu.click();

    }

        @Given("EG Kullanici sign in secenegine tiklar")
        public void eg_kullanici_sign_in_secenegine_tiklar() {
        appointments = new Appointments();
        appointments.anaSayfaSignIn.click();
        Assert.assertTrue(appointments.signInMenusu.isEnabled());
    }

        @Given("EG Kullanici username kutusuna {string} girer")
        public void eg_kullanici_username_kutusuna_girer(String username) {
        appointments = new Appointments();
        appointments.girisUsernameTextBox.sendKeys(username);
    }

        @Given("EG Kullanici Password kutusuna {string} girer")
        public void eg_kullanici_password_kutusuna_girer(String password) {
        appointments = new Appointments();
        appointments.girisPasswordTextBox.sendKeys(password);

        ReusableMethods.waitFor(2);
    }

        @Given("EG Kullanici sign in butonuna tiklar")
        public void eg_kullanici_sign_in_butonuna_tiklar() {
        appointments = new Appointments();
        appointments.girisSignInButton.click();
        //Assert.assertTrue(appointments.myPagesElementi.isEnabled());
        ReusableMethods.waitFor(3);

    }

        @Given("EG Kullanici sag ust kosede bulunan kullanici ismine tiklar")
        public void eg_kullanici_sag_ust_kosede_bulunan_kullanici_ismine_tiklar() {
        appointments = new Appointments();
        appointments.sagUstKullaniciAdi.click();
        Assert.assertTrue(appointments.settingsButton.isEnabled());
    }

        @Given("EG Kullanici settings secenigine tiklar")
        public void eg_kullanici_settings_secenigine_tiklar() {
        appointments = new Appointments();
        appointments.settingsButton.click();
        ReusableMethods.waitFor(2);

    }

        @Given("EG Firstname kutusundaki isim kayit olurken girilen {string} olmali")
        public void eg_firstname_kutusundaki_isim_kayit_olurken_girilen_olmali(String firstname) {
        appointments = new Appointments();
        String actualFirstname = appointments.settingsFirstnameTextBox.getAttribute("value");
        System.out.println(actualFirstname);
        Assert.assertEquals(actualFirstname, firstname);
    }

        @Given("EG last name  kutusundaki soy isim kayit olurken girilen {string} olmali")
        public void eg_last_name_kutusundaki_soy_isim_kayit_olurken_girilen_olmali(String lastname) {
        appointments = new Appointments();
        String actualLastname = appointments.settingsLastnameTextBox.getAttribute("value");
        Assert.assertEquals(actualLastname, lastname);
    }

        @Given("EG email kutusundaki mail adresi  kayit olurken girilen {string} olmali")
        public void eg_email_kutusundaki_mail_adresi_kayit_olurken_girilen_olmali(String email) {
        appointments = new Appointments();
        String actualEmail = appointments.settingsEmailTextBox.getAttribute("value");
        Assert.assertEquals(actualEmail, email);
    }

        @Given("EG kullanici uygulamayi kapatir")
        public void eg_kullanici_uygulamayi_kapatir() {
        Driver.closeDriver();
    }


        @Given("EG kullanici firstname kutusuna yeni {string} yazar")
        public void eg_kullanici_firstname_kutusuna_yeni_yazar(String newFirstname) {
        appointments = new Appointments();
        appointments.settingsFirstnameTextBox.click();
        appointments.settingsFirstnameTextBox.clear();
        appointments.settingsFirstnameTextBox.sendKeys(newFirstname);

    }

        @Given("EG kullanici lastname kutusuna yeni {string} yazar")
        public void eg_kullanici_lastname_kutusuna_yeni_yazar(String newLastname) {
        appointments = new Appointments();
        appointments.settingsLastnameTextBox.click();
        appointments.settingsLastnameTextBox.clear();
        appointments.settingsLastnameTextBox.sendKeys(newLastname);
    }

        @Given("EG kullanici email kutusuna yeni {string} yazar")
        public void eg_kullanici_email_kutusuna_yeni_yazar(String newEmail) {
        appointments = new Appointments();
        appointments.settingsEmailTextBox.click();
        appointments.settingsEmailTextBox.clear();
        appointments.settingsEmailTextBox.sendKeys(newEmail);
    }
        @Given("EG kullanici save butonuna basar ve degisiklikleri kaydeder")
        public void eg_kullanici_save_butonuna_basar_ve_degisiklikleri_kaydeder() {
        appointments = new Appointments();
        appointments.settingsSaveButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(appointments.settingsDegisikliklerKaydedildiElement.isEnabled());
    }
    }

