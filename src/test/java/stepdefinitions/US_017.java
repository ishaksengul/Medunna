package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.Admin;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
import static Hooks.Hooks.spec;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.interactions.Actions;
import pojos.TestItem;
import utilities.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.deleteRequest;
import static utilities.Authentication.generateToken;
//import static utilities.ReadTxt.getTestItemIDs;



import static utilities.ReusableMethods.getScreenshot;

public class US_017 {

    Admin admin = new Admin();
    ReusableMethods reusableMethods;
    TestItem testItem=new TestItem();
    Response response;
    List< Object> allDBItemIds;

    @Given("is kullanici medunna sayfasina gider")
    public void is_kullanici_medunna_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));
    }

    @Given("is kullanici admin olarak giris yapar")
    public void is_kullanici_admin_olarak_giris_yapar() {
        admin.ilkGirisButton.click();
        admin.signInButton.click();
        admin.userNameBox.sendKeys(ConfigReader.getProperty("Admin_username"));
        admin.passBox.sendKeys(ConfigReader.getProperty("Admin_pass")+ Keys.ENTER);
    }

    @Given("is items&title butonuna tiklar")
    public void is_items_title_butonuna_tiklar() {
        Driver.waitAndClick(admin.testItemButton);
    }

    @Given("is test item linkine tiklar")
    public void is_test_item_linkine_tiklar() {
        admin.testItemLink.click();
    }

    @Given("is create a new item buttonuna tiklar")
    public void is_create_a_new_item_buttonuna_tiklar() {
        admin.createItemButton.click();
    }

    @Given("is test olusturma ekraninda name box a isim girer")
    public void is_test_olusturma_ekraninda_name_box_a_isim_girer() {
        admin.testCreateNameBox.sendKeys(ConfigReader.getProperty("Test_adi"));
    }

    @Given("is description box a test aciklamasini girer")
    public void is_description_box_a_test_aciklamasini_girer() {
        admin.testCreateDescriptionBox.sendKeys(ConfigReader.getProperty("Test_descrp"));
    }

    @Given("is test fiyat kutusuna ucreti girer")
    public void is_test_fiyat_kutusuna_ucreti_girer() {
        admin.testCreatePriceBox.sendKeys(ConfigReader.getProperty("Test_fiyat"));
    }

    @Given("is testin min. deger boxina min degeri girer")
    public void is_testin_min_deger_boxina_min_degeri_girer() {
        admin.testCreateMinValueBox.sendKeys(ConfigReader.getProperty("Test_Min_Deger"));
    }

    @Given("is testin max. deger boxina max degeri girer")
    public void is_testin_max_deger_boxina_max_degeri_girer() {
        admin.testCreateMaxValueBox.sendKeys(ConfigReader.getProperty("Test_Max_Deger"));
    }

    @Given("is save button a tiklar")
    public void is_save_button_a_tiklar() {
        Driver.waitAndClick(admin.testCreateSaveButton);
    }

    @Given("is testlerin bulundugu tabloda created date buttonuna tiklar")
    public void is_testlerin_bulundugu_tabloda_created_date_buttonuna_tiklar() {
        Driver.waitAndClick(admin.createDateButton);
    }

    @Then("ilk satirda Ure testinin oldugunu dogrular")
    public void ilk_satirda_ure_testinin_oldugunu_dogrular() {
        Driver.wait(3);
        Assert.assertEquals(ConfigReader.getProperty("Test_adi"), admin.newTestItem.getText());

    }

    @And("is test ogelerinin goruntulenebildigini dogrular")
    public void isTestOgelerininGoruntulenebildiginiDogrular() throws IOException {
        Driver.wait(2);
        getScreenshot("test_Items");
    }

    @And("is ilk satirda gelen Ure testinin edit buttonuna tiklar")
    public void isIlkSatirdaGelenUreTestininEditButtonunaTiklar() {
        Driver.waitAndClick(admin.testEditButton);
    }

    @And("is test guncelleme ekraninda name box a guncellenecek isim girer")
    public void isTestGuncellemeEkranindaNameBoxAGuncellenecekIsimGirer() {
        admin.testCreateNameBox.clear();
        admin.testCreateNameBox.sendKeys(ConfigReader.getProperty("New_Test_Name"));
    }

    @And("is description box a guncellenecek test aciklamasini girer")
    public void isDescriptionBoxAGuncellenecekTestAciklamasiniGirer() {
        admin.testCreateDescriptionBox.clear();
        admin.testCreateDescriptionBox.sendKeys(ConfigReader.getProperty("New_Test_descrp"));
    }

    @And("is test fiyat kutusuna guncellenecek ucreti girer")
    public void isTestFiyatKutusunaGuncellenecekUcretiGirer() {
        admin.testCreatePriceBox.clear();
        admin.testCreatePriceBox.sendKeys(ConfigReader.getProperty("New_Test_fiyat"));
    }

    @And("is testin min. deger boxina guncellenecek min degeri girer")
    public void isTestinMinDegerBoxinaGuncellenecekMinDegeriGirer() {
        admin.testCreateMinValueBox.clear();
        admin.testCreateMinValueBox.sendKeys(ConfigReader.getProperty("New_Test_Min_Deger"));
    }

    @And("is testin max. deger boxina guncellenecek max degeri girer")
    public void isTestinMaxDegerBoxinaGuncellenecekMaxDegeriGirer() {
        admin.testCreateMaxValueBox.clear();
        admin.testCreateMaxValueBox.sendKeys(ConfigReader.getProperty("New_Test_Max_Deger"));
    }

    @Then("is ilk satirda gelen Ure_New testini dogrular")
    public void isIlkSatirdaGelenUre_NewTestiniDogrular() {
        Driver.wait(3);
        Assert.assertEquals(ConfigReader.getProperty("New_Test_Name"), admin.newTestItem.getText());
    }

    @And("is ilk satirda gelen Ure testinin delete ikonuna tiklar")
    public void isIlkSatirdaGelenUreTestininDeleteIkonunaTiklar() {
        admin.testDeleteIkon.click();
    }

    @And("is acilan ekranda delete buttonuna tiklar")
    public void isAcilanEkrandaDeleteButtonunaTiklar() {
        admin.deleteButton.click();
    }

    @Then("is silinen ogeyi dogrular")
    public void isSilinenOgeyiDogrular() {
        Assert.assertTrue(admin.popUp.isDisplayed());
    }


}
