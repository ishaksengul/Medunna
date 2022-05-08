package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.checkerframework.checker.units.qual.A;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Appointments;
import pages.Physicians;
import pages.Registration;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class US_014 {

    Appointments appointments = new Appointments();
    SignInPage signInPage= new SignInPage();
    Physicians physicians = new Physicians();
    ReusableMethods reusableMethods;
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());



    @Given("doktor {string} adresine gider")
    public void doktor_adresine_gider(String MedunnaURL) {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));
    }
    @Given("Doktor Sign in  butonuna tiklar")
    public void doktor_sign_in_butonuna_tiklar() throws InterruptedException {
       signInPage.dropDownElementi.click();

        Thread.sleep(2000);

        signInPage.dropDownSignInButton.click();
        Thread.sleep(2000);

    }
    @Then("Doktor positive log-in yapar")
    public void doktor_positive_log_in_yapar() throws InterruptedException {
        signInPage.usernameTextBox.sendKeys("murateminkara1"+ Keys.ENTER);
        signInPage.passwordTextBox.sendKeys("Muratemin!23"+ Keys.ENTER);
        signInPage.SignInButton.click();
        Thread.sleep(2000);
    }
    @Then("Doktor MY PAGES  My Inpatients butonuna tiklar")
    public void doktor_my_pages_my_inpatients_butonuna_tiklar() throws InterruptedException {
        appointments.myPagesDropdown.click();
        Thread.sleep(2000);
        appointments.MyInpatients.click();
        Thread.sleep(2000);

    }

    @Then("Doktor hasta bilgilerini key-value olarak gorur")
    public void doktor_hasta_bilgilerini_key_value_olarak_gorur() {

    Assert.assertTrue(appointments.inpatientsPageTable.isDisplayed());
       }


    @Then("Doktor Edit tusuna basar ve edit sayfasina yonlendirilir")
    public void doktor_edit_tusuna_basar_ve_edit_sayfasina_yonlendirilir() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        appointments.editButonu.click();
        Thread.sleep(2000);
    }

    @Then("Doktor hasta bilgilerini gunceller")
    public void doktor_hasta_bilgilerini_gunceller() {
        actions.sendKeys(Keys.PAGE_DOWN);
        Select select= new Select(appointments.InpatientStatusDropdown);
        Select select1= new Select(appointments.inPatientRoomDropdown);

        select.selectByValue("STAYING");
        select1.selectByIndex(4);


    }
    @Then("Doktor save butonuna basar")
    public void doktor_save_butonuna_basar() {
        appointments.InpatientSaveButton.click();
    }
}