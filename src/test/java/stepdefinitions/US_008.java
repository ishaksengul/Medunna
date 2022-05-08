package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import pages.Password;
import utilities.ConfigReader;
import utilities.Driver;

public class US_008 {
    Password pass = new Password();
    Actions actions = new Actions(Driver.getDriver());

    @Given("Kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));


    }

    @Then("Kullanici Account Menu iconuna tiklar")
    public void kullanici_account_menu_iconuna_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        pass.iconDD1.click();


    }

    @Then("Kullanici Sign in butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() throws InterruptedException {
       Thread.sleep(2000);
       pass.loginItem.click();

    }

    @Then("Kullanici username girer {string}")
    public void kullanici_username_girer(String string) throws InterruptedException {
        pass.usernameBox.sendKeys(ConfigReader.getProperty("US_008Username"));
        Thread.sleep(1000);
    }

    @Then("Kullanici password girer {string}")
    public void kullanici_password_girer(String string) throws InterruptedException {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US_008Password")).sendKeys(Keys.ENTER).perform();

    }

    @Then("Kullanici Password butonuna tiklar")
    public void kullanici_password_butonuna_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        pass.passwordDD.click();
    }

    @Then("Kullanici gecerli sifreyi girer {string}")
    public void kullanici_gecerli_sifreyi_girer(String string) throws InterruptedException {
        Thread.sleep(1000);
        pass.currentPassBox.sendKeys(ConfigReader.getProperty("US_008Password"));
    }

    @Then("Kulanici yeni sifre girer")
    public void kulanici_yeni_sifre_girer() throws InterruptedException {
        Thread.sleep(1000);
        // actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("uS_008PassKucukHarf")).perform();

        pass.newPassBox.sendKeys(ConfigReader.getProperty("US_008PassKucukHarf"));
        Thread.sleep(1000);
    }

    @Then("Kulanici tekrar yeni sifreyi girer")
    public void kulanici_tekrar_yeni_sifreyi_girer() throws InterruptedException {
        pass.confirmPassBox.sendKeys(ConfigReader.getProperty("US_008PassKucukHarf"));
        Thread.sleep(1000);

    }

    @Then("New password confirmation onaylanabilmelidir")
    public void new_password_confirmation_onaylanabilmelidir() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(pass.confirmPassText.isDisplayed());
        //Assert.assertFalse(pass.generalInvalidFeedback.isDisplayed());

        signOut();
    }


    @Then("Kullanici en az {int} küçük harf iceren yeni sifre girer")
    public void kullanici_en_az_küçük_harf_iceren_yeni_sifre_girer(Integer int1) {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US_008PassKucukHarf")).perform();
    }

    @Then("Kullanici {string} seviyesinin değiştiğini dogrular")
    public void kullanici_seviyesinin_değiştiğini_dogrular(String string) throws InterruptedException {
        Assert.assertTrue(pass.strengthPoint2.isDisplayed());
        signOut();
    }

    @Then("Kullanici en az {int} büyük harf içeren yeni sifre girer")
    public void kullanici_en_az_büyük_harf_içeren_yeni_sifre_girer(Integer int1) {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US_008PassBuyukHarf")).perform();
    }

    @And("Kullanici {string} {int} seviyesinin değiştiğini dogrular")
    public void kullaniciSeviyesininDeğiştiğiniDogrular(String arg0, int arg1) throws InterruptedException {
        Assert.assertTrue(pass.strengthPoint4.isDisplayed());
        signOut();
    }

    @Then("Kullanici en az {int} rakam içeren yeni sifre girer")
    public void kullanici_en_az_rakam_içeren_yeni_sifre_girer(Integer int1) {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US_008PassEnAz1Rakam")).perform();
    }

    @Then("Kullanici en az {int} özel karakter içeren yeni sifre girer")
    public void kullanici_en_az_özel_karakter_içeren_yeni_sifre_girer(Integer int1) {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US_008PassOzelK")).perform();
    }

    @Then("Kullanici en az {int} karakterden oluşan yeni sifre girer")
    public void kullanici_en_az_karakterden_oluşan_yeni_sifre_girer(Integer int1) {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US_008Pass7")).perform();
    }


    @And("Kullanici {string} son seviyesinin değiştiğini dogrular")
    public void kullaniciSonSeviyesininDeğiştiğiniDogrular(String arg0) throws InterruptedException {
        Assert.assertTrue(pass.strengthPoint5.isDisplayed());
        signOut();
    }

    public void signOut() throws InterruptedException {
        Thread.sleep(1000);
        pass.iconDD1.click();
        pass.passwordDD.click();


    }

    @Then("Kullanici tekrar yeni sifreyi girer")
    public void kullaniciTekrarYeniSifreyiGirer() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("US_008Pass7")).perform();
    }

    @And("Save Butonuna tiklar")
    public void saveButonunaTiklar() {
    pass.saveButton.click();
    }

    @And("Kullanici Sign out butonuna tiklar")
    public void kullaniciSignOutButonunaTiklar() {
    pass.signOutButton.click();
    }

    @And("Sign in butonuna tiklarr")
    public void signInButonunaTiklar() {
    pass.signInButton.click();
    }

    @Then("Failed to Sign yazisinin gorunurlugunu dogrular")
    public void failedToSignYazisininGorunurlugunuDogrular() {
    Assert.assertTrue(pass.failedText.isDisplayed());
    }
}
