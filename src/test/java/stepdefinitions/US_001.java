package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.Registration;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

import static utilities.Driver.getDriver;

public class US_001 {

    Registration registration = new Registration();

    @Given("ng kullanici medunna sayfasina gider")
    public void kullanici_medunna_sayfasina_gider() {
        Driver.getDriver().get("https://medunna.com/");
    }

    @And("ng Randevu alma bölümüne gelir")
    public void randevu_kismina_gelir() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngfirstName);
        registration.ngfirstName.sendKeys("");

    }

    @And("ng Veri girisi yapilir")
    public void SSN_girisi_yapilir() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String ssngiris = faker.idNumber().ssnValid();
        actions.click(registration.ngSSN)
                .sendKeys(ssngiris)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().username())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .perform();


    }

    @Then("ng sonuclarin hata mesajı içerip icermedigini icerdigini test eder")
    public void sonuclarin_hata_mesaji_icerdigini_test_eder() {

        String sonucYazisiStr = registration.nghatamesajı.getText();
        Assert.assertTrue(sonucYazisiStr.contains("Your SSN is invalid"));
        System.out.println(registration.nghatamesajı.getText());
    }

    @Then("ng sonuclarin bos hata mesajı içerip icermedigini icerdigini test eder")
    public void sonuclarin_bos_hata_mesaji_icerdigini_test_eder() {
        String sonucYazisiStr = registration.nghatamesajı.getText();
        Assert.assertTrue(sonucYazisiStr.contains("Your SSN is required."));
        System.out.println(registration.nghatamesajı.getText());
    }

    @And("ng hatali SSN girisi yapilir")
    public void hatali_SSN_girisi_yapilir() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        actions.click(registration.ngSSN)
                .sendKeys(faker.numerify("32-1-85"))
                .sendKeys(Keys.TAB)
                .perform();


    }

    @And("ng SSN alanı bos birakilir")
    public void SSN_alani_bos_birakilir() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        actions.click(registration.ngSSN)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().username())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .perform();

    }

    @Then("ng Ekran Fotografi Cekilir")
    public void ekran_fotografi_cekilir() throws IOException {
        TakesScreenshot tss = (TakesScreenshot) Driver.getDriver();
        File tumSayfaSS = new File("target/screenShot/tumsayfa.png");
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim, tumSayfaSS);


    }

    @And("ng SSN girisi yapilir")
    public void ssn_girisi_yapilir() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String ssngiris = faker.idNumber().ssnValid();
        actions.click(registration.ngSSN)
                .sendKeys(ssngiris)
                .sendKeys(Keys.TAB)
                .perform();
    }

    @Then("ng SSN - icerdigini test eder")
    public void ssn_test_eder() {
        String sonucYazisiStr = registration.ngSSN.getText();
        Assert.assertTrue(sonucYazisiStr.contains("-"));
        System.out.println(sonucYazisiStr);
    }

    @Then("ng lastName yazdirilir")
    public void lastname_yazdirma() throws IOException {
        System.out.println(registration.nglastname.getText());

    }

    @Then("ng sonuclarin bos email mesajı içerip icermedigini test eder")
    public void sonuclarin_bos_email_hata_mesaji_icerdigini_test_eder() {
        String sonucYazisiStr = registration.ngemailhatamesaji.getText();
        Assert.assertTrue(sonucYazisiStr.contains("Your email is required."));
        System.out.println(registration.nghatamesajı.getText());
    }
}
