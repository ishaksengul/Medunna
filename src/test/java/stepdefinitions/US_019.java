package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Password;
import pages.Staff;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_019 {
    Password pass = new Password();
    Staff staff = new Staff();
    Actions actions = new Actions(Driver.getDriver());
    Select select;
    Select select1;
    Select select2;
    Select select3;
    Select select4;
    Select select5;
    String sSNNo = "001-01-0002";
    //murat_tm	874-56-8785	sdsasdd@gmail.com		en
    //ROLE_USER  47038id no
    //01/04/22 21:00	murat_tm	18/04/22 05:32

    @Then("Kullanici Username ve password bilgileriyle giris yapar")
    public void kullaniciUsernameVePasswordBilgileriyleGirisYapar() throws InterruptedException {
        pass.usernameBox.sendKeys(ConfigReader.getProperty("Admin_username"));
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("Admin_pass")).sendKeys(Keys.ENTER).perform();

    }

    @And("Item Titles linkine tiklar")
    public void itemTitlesLinkineTiklar() {
        ReusableMethods.waitFor(3);
        staff.itemTitlelink.click();

    }

    @And("Staff linkine tiklar")
    public void staffLinkineTiklar() {
        ReusableMethods.waitForClickablility(staff.staffLink, 2);
        staff.staffLink.click();


    }

    @And("Create a new butonuna tiklar")
    public void createANewButonunaTiklar() {
        staff.createStaff.click();
    }

    @Then("Create or edit a staff yazisini dogrular")
    public void createOrEditAStaffYazisiniDogrular() throws InterruptedException {
        Thread.sleep(1200);
        Assert.assertTrue(staff.createOrEditText.getText().contains("Create or edit a Staff"));

    }

    @And("Search User butonuna tiklar")
    public void searchUserButonunaTiklar() {
        staff.searchUserButton.click();
    }

    @Then("Sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @And("Olusturmak istedigi Staff in SSN-FirstName-LastName-Birth Date -Phone-Gender-Blood Group-Address-Description: bilgilerini girer")
    public void olusturmakIstedigiStaffInSSNFirstNameLastNameBirthDatePhoneGenderBloodGroupAddressDescriptionBilgileriniGirer() throws InterruptedException {
        Faker faker = new Faker();
        String dName = faker.name().firstName();
        String dLastName = faker.name().lastName();
        Driver.waitAndClick(staff.phoneButton);
        staff.phoneButton.click();
        staff.phoneButton.sendKeys(faker.phoneNumber().cellPhone());
        staff.firstnameTextbox.click();
        actions.sendKeys(dName + Keys.TAB)
                .sendKeys(dLastName + Keys.TAB)
                .sendKeys(Keys.TAB)
                // .sendKeys("12:00")
                .sendKeys(Keys.TAB)
                // .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys("123456789")
                .sendKeys(Keys.TAB)
                .perform();
        //Thread.sleep(1000);
        //staff.genderDropdownElement.click();
        select = new Select(staff.genderDropdownElement);
        select.selectByValue("MALE");
        Thread.sleep(1500);
        //actions.sendKeys(Keys.TAB);
        //staff.bloodGroupDdElement.click();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(1500);
        jse.executeScript("arguments[0].scrollIntoView(true);", staff.bloodGroupDdElement);
        select1 = new Select(staff.bloodGroupDdElement);
        Thread.sleep(1500);
        select1.selectByValue("Onegative");
        actions.sendKeys(Keys.TAB)
                //.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(faker.job().title())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)

                .perform();
        Thread.sleep(1500);

        //staff.addressTextbox.sendKeys(faker.address().fullAddress());
        //staff.descriptionTextbox.sendKeys("Staff");
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(1500);
        jse1.executeScript("arguments[0].scrollIntoView(true);", staff.countryDdElement);
        select5=new Select(staff.countryDdElement);
        staff.countryDdElement.click();
        select5.selectByValue("3805");
       // select4 = new Select(staff.stateDropdownElement);
       // staff.stateDropdownElement.click();
       // //Driver.waitAndClick(staff.stateDropdownElement);
       // select4.selectByValue("France");
       // Driver.waitAndClick(staff.stateDropdownElement);
       // staff.stateDropdownElement.click();

    }

    @Then("Use Search radio butonunu tiklar")
    public void useSearchRadioButonunuTiklar() {
        staff.useSSNSearchButton.click();


    }

    @Then("User seciminde ilgi secimi yapar")
    public void userSecimindeIlgiSecimiYapar() {
        select2 = new Select(staff.userDropdownElement);
        select2.selectByIndex(0);
    }

    @And("Country ve State city secmini yapar")
    public void countryVeStateCitySeominiYapar() {
        select3 = new Select(staff.countryDropdownElement);
        select3.selectByIndex(3);
        staff.countryDropdownElement.click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Kullanici Save butonuna tiklar")
    public void kullaniciSaveButonunaTiklar() throws InterruptedException {
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(1500);
        jse1.executeScript("arguments[0].scrollIntoView(true);", staff.saveButton);
        Driver.waitAndClick(staff.saveButton);
        //staff.saveButton.click();
    }

    @Then("Secmek istedigi kisinin ID numarasina tiklar")
    public void secmekIstedigiKisininIDNumarasinaTiklar() {
        Driver.waitForClickablility(staff.firstStaffId,2);
        staff.firstStaffId.click();

    }

    @And("Gelen sayfada Staff yazisini dogrular")
    public void gelenSayfadaStaffYazisiniDogrular() {
        ReusableMethods.waitForVisibility(staff.staffText, 2);
        Assert.assertTrue(staff.staffText.isDisplayed());
    }

    @Then("Duzenlemek istedigi kullanicinin Edit butonuna tiklar")
    public void duzenlemekIstedigiKullanicininEditButonunaTiklar() throws InterruptedException {
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(1500);
        jse1.executeScript("arguments[0].scrollIntoView(true);", staff.editButton);
        staff.editButton.click();
    }

    @And("Guncellemek istedigi bilgileri girer")
    public void guncellemekIstedigiBilgileriGirer() {
        Faker faker = new Faker();
        Driver.waitForClickablility(staff.firstnameTextbox,2);
        staff.firstnameTextbox.click();
        staff.firstnameTextbox.clear();
        staff.firstnameTextbox.sendKeys(faker.name().firstName());
        //actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).perform();


    }

    @And("Staff is updates with identifier yazisi goruntulendigi dogrulanir")
    public void staffIsUpdatesWithIdentifierYazisiGoruntulendigiDogrulanir() throws InterruptedException {
       // ReusableMethods.waitForVisibility(staff.updateText, 2);
        Thread.sleep(2000);
        Assert.assertTrue(staff.updateText.isDisplayed());
    }

    @And("Kaydin yapildigina dair yaziyi dogrular")
    public void kaydinYapildiginaDairYaziyiDogrular() throws InterruptedException {
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(1500);
        jse1.executeScript("arguments[0].scrollIntoView(true);", staff.updateText);
        //ReusableMethods.waitForVisibility(staff.updateText, 2);
        Assert.assertTrue(staff.updateText.isDisplayed());
    }

    @And("User found with search SSN yazisini dogrular")
    public void userFoundWithSearchSSNYazisiniDogrular() {
        ReusableMethods.waitForVisibility(staff.updateText, 2);
        Assert.assertTrue(staff.updateText.isDisplayed());
    }

    @And("Aratmak istedigi SSN numarasini girer")
    public void aratmakIstedigiSSNNumarasiniGirer() throws InterruptedException {
        staff.sSnButton.click();
        Thread.sleep(1500);
        actions.sendKeys(sSNNo + Keys.ENTER).perform();
        Thread.sleep(1500);
    }

    @Then("Silmek istedigi staffi DELETE butonuna tiklar")
    public void silmekIstedigiStaffiDELETEButonunaTiklar() throws InterruptedException {
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(1500);
        jse1.executeScript("arguments[0].scrollIntoView(true);", staff.deleteButton);
        staff.deleteButton.click();
        ReusableMethods.waitFor(2);
    }

    @And("Confirm delete operation yazisi dogrulanir")
    public void confirmDeleteOperationYazisiDogrulanir() {
        Assert.assertTrue(staff.confirmDeleteText.isDisplayed());
    }

    @Then("Delete butonu tiklani")
    public void deleteButonuTiklani() throws InterruptedException {
        Thread.sleep(1000);
        staff.enSondeleteButonu.click();
    }

    @And("staff is deleted identifier yazisi dogrulanir")
    public void staffIsDeletedIdentifierYazisiDogrulanir() throws InterruptedException {
       Thread.sleep(1500);
        Assert.assertTrue(staff.updateText.isDisplayed());
    }


}
