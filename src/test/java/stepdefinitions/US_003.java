package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.Registration;
import utilities.ConfigReader;
import utilities.Driver;

public class US_003 {
    Registration registration = new Registration();

    @Given("kullanici {string} adresine gider")
    public void kullanici_adrese_gider(String MedunnaURL) {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }

    @Given("kullanici giris yapip dropdown una tiklar ve register secenegine tiklar")
    public void kullanici_giris_yapip_dropdown_una_tiklar_ve_register_secenegine_tiklar() {
        registration.dropDownElementi.click();
        registration.dropDownRegisterButton.click();

    }


    @Then("kullanici password bolumune kucuk harfli  {string} yazarak PasswordStrength in degistigini test eder")
    public void kullaniciPasswordBolumuneKucukHarfGirerVeYazarakPasswordStrengthInDegistiginiTestEder(String arg0) throws InterruptedException {
        registration.passwordTextBox.sendKeys(arg0 + Keys.PAGE_DOWN);

        String bcolor= registration.defaultStrengthBarColor.getCssValue("background-color");
        String defaultStrengthColor="rgba(221, 221, 221)";

        Assert.assertFalse("Kucuk Harf Test Failed by Assert",bcolor.equals("rgba(255,0,0)"));
        Assert.assertFalse("Kucuk Harf Test Failed by Assert",registration.secondStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Kucuk Harf Test Failed by Assert",registration.thirdStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Kucuk Harf Test Failed by Assert",registration.fourthStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Kucuk Harf Test Failed by Assert",registration.fifthStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));

        Thread.sleep(1000);



    }


    @Then("kullanici password bolumune buyuk harfli  {string} yazarak PasswordStrength in degistigini test eder")
    public void kullaniciPasswordBolumuneBuyukHarfGirerVeYazarakPasswordStrengthInDegistiginiTestEder(String arg0) throws InterruptedException {
        registration.passwordTextBox.sendKeys(arg0+Keys.PAGE_DOWN);
        String bcolor= registration.defaultStrengthBarColor.getCssValue("background-color");
        String defaultStrengthColor="rgba(221, 221, 221)";

        Assert.assertFalse("Buyuk Harf Test Failed by Assert",bcolor.equals("rgba(255,0,0)"));
        Assert.assertFalse("Buyuk Harf Test Failed by Assert",registration.secondStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Buyuk Harf Test Failed by Assert",registration.thirdStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Buyuk Harf Test Failed by Assert",registration.fourthStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Buyuk Harf Test Failed by Assert",registration.fifthStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));

        Thread.sleep(1000);
    }

    @Then("kullanici password bolumune rakam iceren  {string} yazarak PasswordStrength in degistigini test eder")
    public void kullaniciPasswordBolumuneRakamIcerenYazarakPasswordStrengthInDegistiginiTestEder(String arg0) throws InterruptedException {
        registration.passwordTextBox.sendKeys(arg0+Keys.PAGE_DOWN);
        String defaultStrengthColor="rgba(221, 221, 221)";
        String bcolor=registration.defaultStrengthBarColor.getCssValue("background-color");

        Assert.assertFalse("Rakam Test Failed by Assert",bcolor.equals("rgba(255,0,0)"));
        Assert.assertFalse("Rakam Test Failed by Assert",registration.secondStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Rakam Test Failed by Assert",registration.thirdStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Rakam Test Failed by Assert",registration.fourthStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Rakam Test Failed by Assert",registration.fifthStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));

        Thread.sleep(1000);
    }

    @Then("kullanici password bolumune ozel karakter iceren  {string} yazarak PasswordStrength in degistigini test eder")
    public void kullaniciPasswordBolumuneOzelKarakterIcerenYazarakPasswordStrengthInDegistiginiTestEder(String arg0) throws InterruptedException {
        registration.passwordTextBox.sendKeys(arg0+Keys.PAGE_DOWN);
        String defaultStrengthColor="rgba(221, 221, 221)";
        String bcolor=registration.defaultStrengthBarColor.getCssValue("background-color");

        Assert.assertFalse("Ozel Karakter Test Failed by Assert",bcolor.equals("rgba(255,0,0)"));
        Assert.assertFalse("Ozel Karakter Test Failed by Assert",registration.secondStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Ozel Karakter Test Failed by Assert",registration.thirdStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Ozel Karakter Test Failed by Assert",registration.fourthStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));
        Assert.assertFalse("Ozel Karakter Test Failed by Assert",registration.fifthStrengthBarColor.getCssValue("background-color").equals(defaultStrengthColor));

        Thread.sleep(1000);

    }



    @Then("girilmis {string} karakter sayisinin en az {int} ve uzeri olmasini test eder")
    public void girilmisKarakterSayisininEnAzVeUzeriOlmasiniTestEder(String arg0, int arg1) {

        Assert.assertEquals("Yanlis karakter sayisi",arg1,arg0.length());
    }
}