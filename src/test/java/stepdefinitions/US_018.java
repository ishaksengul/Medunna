package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Admin;
import pojos.Physician;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
public class US_018 {
    Admin admin=new Admin();
    Actions actions;
    Faker faker;
    Select select;
    String ssn = "";
    List<Object>doktorBilgisi;

    //Backround
    @Given("Admin Personel {string} URL'ye gideer")
    public void admin_personel_url_ye_gideer(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

    }
    @Given("Kayit menusune tiklaar.")
    public void kayit_menusune_tiklar() {
        Driver.wait(1);
        admin.soAccountMenu.click();

    }
    @Given("Sign In butonuuna tiklar.")
    public void sign_in_butonuna_tiklar() {
        Driver.wait(1);
        admin.soSignIn.click();

    }
    @Given("Admin olarak gecerli {string} ve {string} ile giris yaapar.")
    public void admin_olarak_gecerli_ve_ile_giris_yapar(String Username, String Password) {
        Driver.wait(1);
        admin.soUsernameTextbox.sendKeys(ConfigReader.getProperty("US18adminUsername"));
        admin.soPasswordTextbox.sendKeys(ConfigReader.getProperty("US18adminPassword"));
        Driver.wait(1);
        admin.soSignInButton.click();

    }
    @Then("Item&Titles secenegine tiiklar ve Physician butonuna tiklar.")
    public void item_titles_secenegine_tiklar_ve_physician_butonuna_tiklar() {
        Driver.wait(3);
        admin.soItemsTitles.click();
        admin.soPhysician.click();

        Driver.wait(3);

    }

    //TC01
    @Given("Admin doktor listesinden rastgele SSN secer.")
    public void admin_doktor_listesinden_rastgele_ssn_secer() {
        faker = new Faker();
        int random = faker.random().nextInt(1, 20);
        ssn= Driver.getDriver().findElement(By.xpath("//tbody/tr[" + random + "]/td[2]")).getText();

    }
    @Given("Create a new Phycisian butoonuna tiklar.")
    public void create_a_new_phycisian_butonuna_tiklar() {
        Driver.wait(1);
        admin.soCreteANewPhysician.click();

    }
    @Given("Use Search checkbox'ina tiklarr.")
    public void use_search_checkbox_ina_tiklar() {
        Driver.wait(1);
        admin.soUseSearchCheckBox.click();

    }
    @Given("Arama textbox'ina doktor SSN numarasii girer.")
    public void arama_textbox_ina_doktor_ssn_numarasi_girer() {
        admin.soSSNSearchTextBox.sendKeys(ssn);

    }
    @Given("Search Userr butonuna tiklar.")
    public void search_user_butonuna_tiklar() {
        Driver.wait(1);
        admin.soSearchUserButton.click();

    }
    @Given("{string} yaziisini gorur.")
    public void yazisini_gorur(String string) {
        Driver.wait(2);
        Assert.assertTrue(admin.soAramaToastfyYazisi.isDisplayed());


    }
    @Given("Admin oturumu kapatirr.")
    public void admin_oturumu_kapatir() {
        Driver.wait(2);
        admin.soAccountMenu.click();
        admin.soSignOutButton.click();

    }

    //TC02
    @Given("Doktor listesinden rastgele bir doktor secip edit butonuna tiklar.")
    public void doktor_listesinden_rastgele_bir_doktor_secip_edit_butonuna_tiklar() {
        actions=new Actions(Driver.getDriver());
        faker=new Faker();
        Driver.wait(5);

        WebElement clk = Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[11]"));
        actions.click(clk).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
        int satir = faker.random().nextInt(1, 20);

        Driver.wait(2);
        WebElement editButton=Driver.getDriver().findElement(By.xpath("//tbody/tr["+satir+"]/td[18]/div/a[2]"));
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", editButton);
        Driver.wait(2);
        javascriptExecutor.executeScript("arguments[0].click();", editButton);

    }
    @Given("Firstname, Lastname, Birth Date, Phone,Gender, Blood Group,Address,Description,Created Date,User,Country ve State-City bilgilerini doldurur")
    public void firstname_lastname_birth_date_phone_gender_blood_group_address_description_created_date_user_country_ve_state_city_bilgilerini_doldurur() {
        faker=new Faker();

        //fistname
        Driver.wait(3);
        if (admin.soFirstnameTextBox.getAttribute("value").isEmpty()){
            admin.soFirstnameTextBox.sendKeys(faker.name().firstName());
        }else {
            String text = admin.soFirstnameTextBox.getAttribute("value");
            admin.soFirstnameTextBox.clear();
            Driver.wait(1);
            admin.soFirstnameTextBox.sendKeys(text);
        }

        //lastname
        if (admin.soLastnameTextBox.getAttribute("value").isEmpty()){
            admin.soLastnameTextBox.sendKeys(faker.name().lastName());
        }else {
            String text=admin.soLastnameTextBox.getAttribute("value");
            admin.soLastnameTextBox.clear();
            Driver.wait(2);
            admin.soLastnameTextBox.sendKeys(text);
            actions.sendKeys(Keys.PAGE_DOWN);
        }
        //Birthdate
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        admin.soBirthDateTextbox.sendKeys("12.03.1989");
        Driver.wait(1);

        //Phone
        if (admin.soPhoneTextBox.getAttribute("value").isEmpty()){
            admin.soPhoneTextBox.sendKeys("0123456789");
        }else {
            String text = admin.soPhoneTextBox.getAttribute("value");
            admin.soPhoneTextBox.clear();
            Driver.wait(2);
            admin.soPhoneTextBox.sendKeys(text);
        }

        //Address
        Driver.wait(2);
        if (admin.soAddressTextbox.getAttribute("value").isEmpty()){
            admin.soAddressTextbox.sendKeys(faker.address().fullAddress());
        }else {
            String text=admin.soAddressTextbox.getAttribute("value");
            admin.soAddressTextbox.clear();
            Driver.wait(2);
            admin.soAddressTextbox.sendKeys(text);
        }

        //Description
        if (admin.soDescriptionTextbox.getAttribute("value").isEmpty()){
            admin.soDescriptionTextbox.sendKeys(faker.name().title());
        }else{
            String text=admin.soDescriptionTextbox.getAttribute("value");
            admin.soDescriptionTextbox.clear();
            Driver.wait(2);
            admin.soDescriptionTextbox.sendKeys(text);
        }

        //fotochange
        Driver.wait(3);
        admin.sofotoUpload.sendKeys("C:\\\\Users\\\\admin\\\\Desktop\\\\doctor.jpg");

        //Country
        select=new Select(admin.soCountryDropdown);
        select.selectByVisibleText("Turkey");

        /*
        //State
        select=new Select(admin.soStateDropdown);
        Driver.wait(2);
        int city = faker.random().nextInt(1, 15);
        Driver.wait(4);
        select.selectByIndex(city);
        */

    }
    @Given("Save butonuna tiklar.")
    public void save_butonuna_tiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.waitAndClick(admin.soSaveButton);


    }
    @Given("A Physician is updated with identifier yazisi gorunur ve Admin bilgilerin kaydedildigini dogrular.")
    public void a_physician_is_updated_with_identifier_yazisi_gorunur() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(admin.soUpdateToastify.isDisplayed());
    }

    @Given("Admin, doktorun uzmanlik alanini secer.")
    public void admin_doktorun_uzmanlik_alanini_secer() {
        Driver.wait(2);
        admin.soBirthDateTextbox.sendKeys("15.06.1980");
        actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        select=new Select(admin.soSpecialityDropdown);
        select.selectByIndex(5);

    }

    //TC04
    @Given("Admin doktorun profil resmini degistirebilir")
    public void admin_doktorun_profil_resmini_degistirebilir() {
        /*
        actions=new Actions(Driver.getDriver());
        Driver.wait(2);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", admin.sofotoUpload);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(2);
        admin.sofotoUpload.sendKeys("C:\\Users\\admin\\Desktop\\doctor.jpg");
        Driver.wait(2);
        */
         Driver.wait(2);
        admin.sofotoUpload.sendKeys("C:\\Users\\admin\\Desktop\\doctor.jpg");

    }

    //TC05
    @Given("Admin User'dan doktor kullaniciyi secer")
    public void admin_user_dan_doktor_kullaniciyi_secer() {
        Driver.wait(3);
        select=new Select(admin.soUserBox);
        actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", admin.soUserBox);
        for (int i = 0; i < 6; i++) {
            Driver.wait(2);
            select.selectByIndex(Faker.instance().random().nextInt(1,20));
        }
        Driver.wait(2);
        select.selectByValue("43157");
        Driver.wait(1);
    }

    //TC06
    @Given("Admin, doktorun muayene ucretini girer.")
    public void admin_doktorun_muayene_ucretini_girer() {
        Driver.wait(2);
        admin.soExamFeeTextbox.clear();
        Driver.wait(2);
        admin.soExamFeeTextbox.sendKeys("300");
        Driver.wait(2);

    }

    //TC07
    @Given("Physicians yazisinin gorundugunu dogrular.")
    public void physicians_yazisinin_gorundugunu_dogrular() {
        Driver.wait(2);
        Assert.assertTrue(admin.soPhysicianText.isDisplayed());
    }

    //TC08
    @Given("Edit butonu erisilebilir olmalidir.")
    public void edit_butonu_erisilebilir_olmalidir() {
        Driver.wait(2);
        Assert.assertTrue(admin.soEditButton.isDisplayed());

    }

    //TC09
    @Given("Doktor listesinden rastgele bir doktor secip delete butonuna tiklar.")
    public void doktor_listesinden_rastgele_bir_doktor_secip_delete_butonuna_tiklar() {
        actions=new Actions(Driver.getDriver());
        faker=new Faker();
        Driver.wait(5);

        WebElement clk = Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[11]"));
        actions.click(clk).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
        int satir = faker.random().nextInt(1, 20);

        Driver.wait(2);
        WebElement deleteButton=Driver.getDriver().findElement(By.xpath("//tbody/tr["+satir+"]/td[18]/div/a[3]"));
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", deleteButton);
        Driver.wait(2);
        javascriptExecutor.executeScript("arguments[0].click();", deleteButton);

    }
    @Given("Ekrana cikan Modal-Content teki Delete butonuna tiklar.")
    public void ekrana_cikan_modal_content_teki_delete_butonuna_tiklar() {
        Driver.wait(2);
        admin.soIkinciDeleteButton.click();

    }
    @Then("Internal server error toastify yazisi gorunur olmamalidir.")
    public void internal_server_error_toastify_yazisi_gorunur_olmamalidir() {
        Driver.wait(2);
        Assert.assertFalse(admin.soInternaErrorToastify.isDisplayed());

    }

    @Given("Kullanici bilgileri kullanarak Medunna DB baglanti kurarr.")
    public void kullaniciBilgileriKullanarakMedunnaDBBaglantiKurarr() {
        DBUtils.createConnection();

    }

    @And("Query ve column data gonderirr.")
    public void queryVeColumnDataGonderirr() {
        doktorBilgisi=new ArrayList<>();
        doktorBilgisi= DBUtils.getColumnData("select * from physician","first_name");
        System.out.println(doktorBilgisi);

    }

    @Then("doktor bilgisini dogrularr.")
    public void doktorBilgisiniDogrularr() {
        List<String>expectedFirstname=new ArrayList<>();
        expectedFirstname.add("Ferhat");
        expectedFirstname.add("eren");
        Assert.assertTrue(doktorBilgisi.containsAll(expectedFirstname));


    }







}
