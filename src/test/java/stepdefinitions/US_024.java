package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import pages.Patients;
import pages.Registration;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;
import java.sql.DriverAction;
import java.util.List;

public class US_024 {
Actions actions=new Actions(Driver.getDriver());
    SignInPage signInPage = new SignInPage();
    Patients patients = new Patients();

    @Given("hasta {string} adresine gider")
    public void hasta_adresine_gider(String MedunnaUrl) {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));

    }

    @Given("hasta Sign in  butonuna basar")
    public void hasta_sign_in_butonuna_tiklar() {
        signInPage.dropDownElementi.click();
        signInPage.signIn.click();

    }

    @Given("hasta positive_login yapar")
    public void hasta_positive_login_yapar() {
        signInPage.userNameInputBox.sendKeys(ConfigReader.getProperty("muratHastaId"));
        signInPage.passwordInputBox.sendKeys(ConfigReader.getProperty("muratHastaPassword"));
        signInPage.signInButton.click();
    }

    @Given("hasta MyAppointments sayfasina gider")
    public void hasta_my_appointments_sayfasina_gider() throws InterruptedException {
        Thread.sleep(1000);
        signInPage.MyAppointmentsDropDown.click();
        signInPage.MyAppointmentsDropDownItem.click();
    }

    @Given("hasta ShowTests butonuna tiklar")
    public void hasta_show_tests_butonuna_tiklar() throws InterruptedException {
        ReusableMethods.waitFor(1);
    //    actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(1500);
        jse1.executeScript("arguments[0].scrollIntoView(true);", patients.ShowTests);
      ReusableMethods.waitForClickablility(patients.ShowTests,2);
        patients.ShowTests.click();

    }

    @Given("hasta ViewResults butonuna tiklar")
    public void hasta_view_results_butonuna_tiklar() throws InterruptedException {

        ReusableMethods.waitFor(1);

        patients.viewResultButton.click();

    }

    @Then("hasta test sonuclarini gorur")
    public void hasta_test_sonuclarini_gorur() {

        patients.viewResultsTable.isDisplayed();
        patients.viewResultsTable.getCssValue("btn btn-link btn-sm");
    }

    @Given("hasta fatura icin {string} adresine gider")
    public void hasta_fatura_icin_adresine_gider(String MedunnaUrl) {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));

    }


    @Given("hasta fatura icin Sign in  butonuna basar")
    public void hasta_fatura_icin_sign_in_butonuna_tiklar() {
        signInPage.dropDownElementi.click();
        signInPage.signIn.click();

    }

    @Then("hasta faturasini  gorur")
    public void hasta_faturasini_gorur() {
        String basarisizSonuc = "Not found";
        String actualFaturaSonuc = patients.faturaSonucElementi.getText();
        Assert.assertFalse(basarisizSonuc.equals(actualFaturaSonuc));

    }

    @And("hasta showInvoice butonuna tiklar")
    public void hastaShowInvoiceButonunaTiklar() throws InterruptedException { Thread.sleep(2000);
        //  patients.showInvoiceButton.isDisplayed();
        //  actions.sendKeys(Keys.PAGE_DOWN).perform();

        patients.showInvoiceButton2.click();
        //      patients.showInvoiceButton.click();
    }
}