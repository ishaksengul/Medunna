package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Staff;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.List;

public class US_009 {
    Staff staff = new Staff();
    Select select;
    Select select1;
    Select select2;
    Select select3;
    Select select4;
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
    String ssn="123-56-9424";

    //BAckground
    @Given("Personel {string} URL'ye gideer")
    public void personel_url_ye_gider(String Medunna_URL) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Given("Personel Kayit menusuundeki Sign in butonuna tiiklar")
    public void personel_kayit_menusundeki_sign_in_butonuna_tiiklar() {
        staff.AccountMenu.click();
        staff.SignIn.click();
    }

    @Given("Personel olaraak Login islemi gerceklestirilir")
    public void personel_olarak_login_islemi_gerceklestirilir() {
        staff.UsernameTextbox.sendKeys(ConfigReader.getProperty("US09staffUsername"));
        staff.PasswordTextbox.sendKeys(ConfigReader.getProperty("US09staffPassword"));
        staff.SignInButton.click();
    }

    @Then("Personel My Page sekmesiine tiklar")
    public void personel_my_page_sekmesine_tiklar() {
        Driver.waitAndClick(staff.MyPageButton);
        //staff.MyPageButton.click();
    }

    @Given("My Page sekmesinin aaltindaki Search Patient sekmesine tiklanir")
    public void my_page_sekmesinin_altindaki_search_patient_sekmesine_tiklanir() {

        staff.SearchPatientButton.click();
    }

    //TC01
    @Then("Hasta bilgiilerini olusturan Tablo basliklariyla dogrulama yapilir")
    public void hasta_bilgilerini_olusturan_tablo_basliklariyla_dogrulama_yapilir() {

/*
        for (WebElement w:staff.allHeaders) {
            System.out.println(w.getText());
        }
*/
        for (int i = 0; i < staff.allHeaders.size(); i++) {
            System.out.println(staff.allHeaders.get(i).getText());
            Assert.assertEquals(staff.allHeaders.get(0).getText(), "ID");
            Assert.assertEquals(staff.allHeaders.get(1).getText(), "SSN");

        }
        System.out.println("TEST PASSED");
    }

    //TC03
    @And("Search Patient sekmesine tiklaniir ve SSN numarasiyla hasta aratilir.")
    public void search_patient_sekmesine_tiklanir_ve_ssn_numarasiyla_hasta_aratilir() throws InterruptedException {
        Thread.sleep(2000);
        staff.SearchPatientButton.click();
        Thread.sleep(3000);
        staff.SsnAramaTextbox.sendKeys(ConfigReader.getProperty("US09hastanSSN"));

    }

    @Given("Search Patient sayfasinda aratilan hasta iciin Edit butonuna tiklanir.")
    public void search_patient_sayfasinda_aratilan_hasta_icin_Edit_butonuna_tiklanir() {
        staff.EditButton.click();

    }

    @Then("Farkli bilesenlerde duzenleme yapilir vee kaydedilir")
    public void farkli_bilesenlerde_duzenleme_yapilir_ve_kaydedilir() throws InterruptedException {

        Thread.sleep(2000);
        staff.firstnameTextbox.click();
        staff.firstnameTextbox.clear();
        staff.firstnameTextbox.click();
        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys("01.04.2020"+Keys.TAB).sendKeys("12:00").sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys("123-999-9999"+Keys.TAB).perform();
        Thread.sleep(1000);


        select = new Select(staff.genderDropdownElement);
        select.selectByIndex(0);

        Thread.sleep(3000);

        select1 = new Select(staff.bloodGroupDropdownElement);
        select1.selectByIndex(1);

        Thread.sleep(3000);
        staff.addressTextbox.sendKeys(ConfigReader.getProperty("US09hastaAddress"));
        staff.descriptionTextbox.sendKeys(ConfigReader.getProperty("US09hastaDescription"));

        select2 = new Select(staff.userDropdownElement);
        select2.selectByIndex(8);

        select3 = new Select(staff.countryDropdownElement);
        select3.selectByIndex(3);
        staff.countryDropdownElement.click();
        actions.sendKeys(Keys.TAB).perform();

        select4 = new Select(staff.stateDropdownElement);
        staff.stateDropdownElement.click();
        //Driver.waitAndClick(staff.stateDropdownElement);
        select4.selectByIndex(2);
        Driver.waitAndClick(staff.stateDropdownElement);
        staff.stateDropdownElement.click();
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Thread.sleep(2000);
        //staff.saveButton.click();
        Driver.waitAndClick(staff.saveButton);

    }

    @Then("Sayfanin sol uust kosesinde dogrulama gozlemlenebilmelidir.")
    public void sayfanin_sol_ust_kosesinde_dogrulama_gozlemlenebilmelidir() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(staff.saveToastify.isDisplayed());

    }

    //TC03
    @Then("Kullanici  girilen  SSN  tuum bilgilerinin dolduruldugunu gorur")
    public void kullaniciGirilenSSNTumBilgilerininDolduruldugunuGorur() throws IOException {
        // WebElement satirelementi=myPages.tumHucreDegerleri(1);
        //  System.out.println("satirelementi = " + satirelementi.getText());
        //Assert.assertTrue(myPages.satirElementi.isDisplayed());

        List<WebElement> satirelementi = staff.tumHucreDegerleri();
        for (int i = 0; i < satirelementi.size(); i++) {
            if (satirelementi.isEmpty()) {
                ReusableMethods.getScreenshot("HELLO");
            } else {
                Assert.assertFalse(satirelementi.isEmpty());

            }
            System.out.println(i + ".satirelementi = " + satirelementi.get(i).getText());
        }
    }


    //TC04
    @Given("Bilesenlerden biri\\(firstname) silinir ve Save butonuna tiiklanir.")
    public void bilesenlerdenBiriFirstnameSilinirVeSaveButonunaTiklanir() throws InterruptedException {
        Thread.sleep(5000);
        staff.firstnameTextbox.clear();
        Thread.sleep(2000);
        staff.firstnameTextbox.sendKeys(Keys.TAB);
        staff.lastnameTextbox.sendKeys(Keys.TAB);
        staff.birthdateTextbox.sendKeys(Keys.TAB);
        staff.emailTextbox.sendKeys(Keys.TAB);
        staff.phoneTextbox.sendKeys(Keys.TAB);
        staff.genderDropdownElement.sendKeys(Keys.TAB);
        staff.bloodGroupDropdownElement.sendKeys(Keys.TAB);
        staff.descriptionTextbox.sendKeys(Keys.TAB);
        staff.userDropdownElement.sendKeys(Keys.TAB);
        staff.countryDropdownElement.sendKeys(Keys.TAB);
        staff.stateDropdownElement.sendKeys(Keys.TAB);
        staff.backButton.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        staff.saveButton.click();
        Assert.assertTrue(staff.deleteHataYazisi.isDisplayed());


    }

    //TC05
    @And("Hasta bilgisindee Delete butonunun olmadigi gozlemlenmelidir.")
    public void hastaBilgisindeDeleteButonununOlmadigiGozlemlenmelidir() throws IOException {
        Driver.waitAndClick(staff.tableTablosu);
        actions.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
        ReusableMethods.getScreenshot("Delete");

        System.out.println(staff.deleteButton.getText());
        Assert.assertFalse(staff.deleteButton.getText().contains("Delete"));


    }

    //TC06
    @Given("Search Patient seekmesine tiklanir.")
    public void searchPatientSekmesineTiklanir() {
        staff.SearchPatientButton.click();
        
    }
    // TC_006 İCİN
    @And("Patient SSN textbox ina SSN numaarasi girilir.")
    public void kullaniciPatientTextboxaSNNBilgisiGirer() {

        Driver.waitAndSendText(staff.SsnAramaTextbox,ssn);


    }

    @Then("Kullanici girilen SNN ile bilgilerin ciktigini teest eder")
    public void kullaniciGirilenSNNIleBilgilerinCiktiginiTestEder() {

        ReusableMethods.waitFor(2);
        Assert.assertTrue(staff.tumHucreDegerleri().get(1).getText().equals(ssn));

    }


}

