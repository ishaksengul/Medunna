package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Appointments;
import pages.Patients;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_025 {

    SignInPage signInPage = new SignInPage();
    Patients patients = new Patients();
Appointments appointments= new Appointments();

    @Given("hasta appointment olusturmak icin {string} adresine gider")
    public void hasta_appointment_olusturmak_icin_adresine_gider(String MedunnaUrl) {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));

    }

    @Given("hasta appointment olusturmak icin Sign in  butonuna tiklar")
    public void hasta_appointment_olusturmak_icin_sign_in_butonuna_tiklar() {
        signInPage.dropDownElementi.click();
        signInPage.signIn.click();

    }

    @Given("hasta positive login yapar")
    public void hasta_positive_login_yapar() {
        signInPage.userNameInputBox.sendKeys(ConfigReader.getProperty("muratHastaId"));
        signInPage.passwordInputBox.sendKeys(ConfigReader.getProperty("muratHastaPassword"));
        signInPage.signInButton.click();
    }

    @Given("hasta Make an appointment sayfasina gider")
    public void hasta_make_an_appointment_sayfasina_gider() throws InterruptedException {  Thread.sleep(1000);
        signInPage.MyAppointmentsDropDown.click();
        appointments.makeAnAppointment.click();
    }


    @Given("hasta istenilen verileri doldurur ve send a request butonuna tiklar")
    public void hasta_istenilen_verileri_doldurur_ve_send_a_request_butonuna_tiklar() {
//appointments.MakeAppointmentFirstNameTextBox.sendKeys("Murat");
//appointments.settingsLastnameTextBox.sendKeys("Kara");
//appointments.MakeAppointmentSsnTextBox.sendKeys("661-61-6161");
//appointments.MakeAppointmentEmailTextBox.sendKeys("jakarta@gmail.com");
appointments.MakeAppointmentSPhoneTextBox.sendKeys("6161616161");
//appointments.MakeAppointmentDateTimeTextBox.sendKeys("11-10-2018");
appointments.MakeAppointmentregisterSubmitButton.click();

    }
    @Then("hasta kayit basarili bildirimini gorur")
    public void hasta_kayit_basarili_bildirimini_gorur() {
     appointments.positiveAppointmentResultButton.isDisplayed();

    }
}
