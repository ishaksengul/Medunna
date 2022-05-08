package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import pages.Admin;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_015 {

    Admin admin= new Admin();
    Actions actions = new Actions(Driver.getDriver());
    @Given("EG admin items&titles ikonuna tiklar")
    public void eg_admin_items_titles_ikonuna_tiklar() {
        admin.itemsAndTitles.click();
    }
    @Given("EG admin patient e girer")
    public void eg_admin_patient_e_girer() {
        admin.patient.click();
    }
    @Given("EG admin Create a new user secenegine tiklar")
    public void eg_admin_create_a_new_user_secenegine_tiklar() {
        admin.createAnewPatient.click();
    }

    @Given("EG admin yeni kullanici olusturmak icin gerekli bilgileri girer")
    public void eg_admin_yeni_kullanici_olusturmak_icin_gerekli_bilgileri_girer() {
        Faker faker = new Faker();

        admin.newPatientFirstnameTextBox.click();

        actions.sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.date().birthday(12,45).toString())
                .click(admin.newPatientEmailTextBox)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("11111111111")
                .sendKeys(Keys.TAB)
                .perform();

        WebElement genderDropdown = admin.genderDropdownElement;
        admin.genderDropdownElement.click();
        Select select = new Select(genderDropdown);
        select.selectByVisibleText("OTHER");
        admin.genderDropdownElement.sendKeys(Keys.TAB);
        WebElement bloodGroupDropdown = admin.bloodGroupDropdownElement;
        Select select2 = new Select(bloodGroupDropdown);
        select2.selectByVisibleText("O-");

        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.pokemon().name())
                .sendKeys(Keys.TAB,Keys.TAB,Keys.TAB)
                .sendKeys(faker.address().cityName())
                .perform();


    }
    @Given("EG admin save butonuna tiklar")
    public void eg_admin_save_butonuna_tiklar() {
        actions.sendKeys(Keys.DOWN);
        ReusableMethods.waitFor(3);
        admin.adminCreateUserSaveButton.click();
    }
    @Given("EG admin yeni hasta olusturuldu bildirimini gorur")
    public void eg_admin_yeni_hasta_olusturuldu_bildirimini_gorur() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(admin.patientCreatedAlert.isEnabled());

    }

    @Given("EG kullanici yeni hasta olusturma sayfasina erisemez")
    public void eg_kullanici_yeni_hasta_olusturma_sayfasina_erisemez() {
        ReusableMethods.waitFor(3);

        try{
            Assert.assertFalse(admin.patientCreatedAlert.isDisplayed());
        }catch (NoSuchElementException exception){
            Assert.assertEquals("a","a");
        }


    }

    @Given("EG admin hastanin id ve adresini gorur")
    public void eg_admin_hastanin_id_ve_adresini_gorur() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(admin.patientId.isDisplayed());
        Assert.assertTrue(admin.patientAddress.isDisplayed());
    }
    @Given("EG admin yeni kullanici olusturmak icin State haric gerekli bilgileri girer")
    public void eg_admin_yeni_kullanici_olusturmak_icin_State_haric_gerekli_bilgileri_gire() {
        Faker faker = new Faker();

        admin.newPatientFirstnameTextBox.click();

        actions.sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.date().birthday(12,45).toString())
                .click(admin.newPatientEmailTextBox)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("11111111111")
                .sendKeys(Keys.TAB)
                .perform();

        WebElement genderDropdown = admin.genderDropdownElement;
        admin.genderDropdownElement.click();
        Select select = new Select(genderDropdown);
        select.selectByVisibleText("OTHER");
        admin.genderDropdownElement.sendKeys(Keys.TAB);
        WebElement bloodGroupDropdown = admin.bloodGroupDropdownElement;
        Select select2 = new Select(bloodGroupDropdown);
        select2.selectByVisibleText("O-");

        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.pokemon().name())
                .sendKeys(Keys.TAB,Keys.TAB,Keys.TAB)
                .sendKeys(faker.address().cityName())
                .perform();


    }
    @Given("EG admin yeni hasta olusturuldu bildirimini goremez")
    public void eg_admin_yeni_hasta_olusturuldu_bildirimini_goremez() {
        ReusableMethods.waitFor(2);
        Assert.assertFalse(admin.patientCreatedAlert.isEnabled());

    }
    @Given("EG admin administration secenegine tiklar")
    public void eg_admin_administration_secenegine_tiklar() {
        admin.administration.click();
    }
    @Given("EG admin usermanagement sayfasina gider")
    public void admin_usermanagement_sayfasina_gider() {
        admin.userManagement.click();
    }
    @Given("EG admin bir hastayi silmek icin delete e tiklar")
    public void eg_admin_bir_hastayi_silmek_icin_delete_e_tiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(4);
        admin.patientDelete.click();
        ReusableMethods.waitFor(2);
        admin.patientDelete2.click();
    }

    @Given("EG admin hastanin silindigi mesajini alir")
    public void eg_admin_hastanin_silindigi_mesajini_alir() {
        ReusableMethods.waitFor(3);

        Assert.assertFalse(admin.internalServerError.isDisplayed());
    }


}