package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Registration;
import utilities.Driver;

import static utilities.Driver.getDriver;

public class US_002 {

    Registration registration=new Registration();

    @And("ng Register bölümüne gelir")
    public void register_bölümüne_gelir() throws InterruptedException {
        Actions actions=new Actions(Driver.getDriver());
        registration.ngregister.click();
                               actions.click(registration.nglistElementi).perform();
    }
    @And("ng Username girisi yapilir")
    public void username_girisi_yapilir() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
                actions.click(registration.ngusername)
                .sendKeys(faker.name().username()).perform();
    }
    @And("ng email alma bölümüne gelir gecersiz e mail girilir")
    public void randevu_kismina_gelir() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngemail);
        registration.ngemail.sendKeys("medunna");
        registration.ngemail.sendKeys(Keys.TAB);

    }
    @Then("ng e mail sonuclarin hata mesajı içerip icermedigini icerdigini test eder")
    public void sonuclarin_email_hata_mesaji_icerdigini_test_eder() {
        String sonucYazisiStr = registration.ngemailhatamesaji.getText();
        Assert.assertTrue(sonucYazisiStr.contains("This field is invalid"));
        System.out.println(registration.ngemailhatamesaji.getText());


    }
    @And("ng email bos girilir")
    public void gecerli_email() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngemail);
        registration.ngemail.sendKeys("");
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        actions.click(registration.ngemail)
                .sendKeys(Keys.TAB)
                .perform();

    }

}
