package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.Admin;
import utilities.ReusableMethods;

public class US_028 {

    Admin admin = new Admin();
    @Given("EG admin contry sayfasina gider")
    public void eg_admin_contry_sayfasina_gider() {
       admin.country1.click();
    }
    @Given("EG admin create a new country e tiklar")
    public void eg_admin_create_a_new_country_e_tiklar() {
       admin.CreateANewCountry.click();
    }
    @Given("EG admin yeni bir ulke adi girer")
    public void eg_admin_yeni_bir_ulke_adi_girer() {
        Faker faker = new Faker();
        admin.countryNameTextBox.sendKeys(faker.name().username());

    }
    @Given("EG admin ulkeyi kayit etmek icin save butonuna basar")
    public void eg_admin_ulkeyi_kayit_etmek_icin_save_butonuna_basar() {
        admin.countrySaveButton.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(admin.countrySavedAlert.isDisplayed());

    }
}
