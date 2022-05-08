package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.Registration;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_026 {

Registration registration=new Registration();

    @Given("Kullanici Medunna sitesine gider")
    public void kullanici_medunna_sitesine_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));

       }
    @Given("Kullanici Contact Butonuna tiklar ve contact sayfasina yonlenirilir")
    public void kullanici_contact_butonuna_tiklar_ve_contact_sayfasina_yonlenirilir() {
registration.mainPageContactButton.click();
registration.contactPageBasariliGirisSonucContactYazisi.isDisplayed();

    }
    @Given("Kullanici verilerini girer ve mesajini yazip gonder butonuna basar")
    public void kullanici_verilerini_girer_ve_mesajini_yazip_gonder_butonuna_basar() throws InterruptedException {
registration.contactPageNameTextBox.sendKeys("Ismim"+ Keys.ENTER);
registration.contactPageEmailTextBox.sendKeys("mailim@gmail.com"+Keys.ENTER);
registration.contactPageSubjectTextBox.sendKeys("konum sudur"+Keys.ENTER);
registration.contactPageMessageTextBox.sendKeys("Mesajim'da bu"+Keys.TAB);
        ReusableMethods.waitFor(3);
registration.contactPageSubmitButton.click();
       }
    @Then("Kullanici mesajinin basarili bir sekilde gonderildiginin onaylamasini gorur")
    public void kullanici_mesajinin_basarili_bir_sekilde_gonderildiginin_onaylamasini_gorur() {
  //String expectedToastify="Your message has been received";
 String actualToastify= registration.contactPageBasariliMesajBildirim.getText();
  //      Assert.assertTrue(actualToastify.contains(expectedToastify));

 Assert.assertTrue(registration.contactPageBasariliMesajBildirim.isDisplayed());
   }
}
