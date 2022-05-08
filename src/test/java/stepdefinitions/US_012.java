/*package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.asynchttpclient.request.body.generator.ReactiveStreamsBodyGenerator;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Physicians;
import pages.Staff;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_012 {

    Physicians physicians = new Physicians();
    Actions actions = new Actions(Driver.getDriver());





    @Given("kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String MedunnaUrl) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));


    }



    @Given("Insan figurune tiklar")
    public void insan_figurune_tiklar() {
      physicians.insanFiguru.click();
    }
    @And("Sign in butonuna tiklar.")

   public void signInButonunaTiklar() { physicians.singInButonu.click();
    }

    @And("{string} kutusuna gecerli bir us{int}Ph_username girer")
    public void kutusunaGecerliBirUsPh_usernameGirer(String arg0, int arg1) {
        physicians.drUserName.sendKeys("drfadime");
    }

    @Given("{string} kutusuna gecerli bir us012Ph_password girer")
    public void kutusuna_gecerli_bir_us012ph_password_girer(String string) {
        physicians.drPassword.sendKeys("Batch44+");
    }
    @And("singInButonu{int}  butonuna tiklar")
    public void singinbutonuButonunaTiklar(int no) throws InterruptedException {
        Thread.sleep(2000);
        physicians.singInButonu1.click();
        Thread.sleep(2000);
    }
    @And("My page menusune tiklar")
    public void myPageMenusuneTiklar() throws InterruptedException {

       Thread.sleep(1000);

        physicians.drMyPage.click();
        Thread.sleep(1000);
    }

    @And("My appointements butonuna tiklar")
    public void myAppointementsButonunaTiklar() {
        physicians.drMyAppointment.click();
    }


    @And("Hastasini secip Edit butonuna tiklar")
    public void hastasiniSecipEditButonunaTiklar() throws InterruptedException {
       Thread.sleep(1000);
        physicians.drEdit.click();
        Thread.sleep(1000);

    }

    @And("Request a test butonuna tiklar")
    public void requestATestButonunaTiklar() {
       ReusableMethods.waitFor(5);
        physicians.drRequestATest.click();
    }


    @And("Test Items yazisinin goruldugunu test eder")
    public void testItemsYazisininGoruldugunuTestEder() {
      ReusableMethods.waitFor(3);
        String sonucStr= physicians.drTestItemYazisi.getText();
        Assert.assertTrue(sonucStr.contains("Test Items"));

    }

    @And("Account menuye tiklar")
    public void accountMenuyeTiklar() {
     ReusableMethods.waitFor(3);
        physicians.draccountMenu.click();
    }

    @Then("Sign out butonuna tiklar")
    public void signOutButonunaTiklar() {
        ReusableMethods.waitFor(4);
       physicians.drSignOut.click();
    }


    @And("Secilen testlerin sag taraftaki butonlarina tiklar")
    public void secilenTestlerinSagTaraftakiButonlarinaTiklar() {
       Actions actions=new Actions(Driver.getDriver());
        ReusableMethods.waitFor(3);
        physicians.drUrea.click();
        ReusableMethods.waitFor(3);

        physicians.drCreatine.click();
        ReusableMethods.waitFor(3);

        physicians.drSodium.click();
        ReusableMethods.waitFor(3);
        physicians.drPotassium.click();
        ReusableMethods.waitFor(3);
        physicians.drTotalProtein.click();

       // ReusableMethods.waitFor(3);
       // physicians.scrollToWebelementVisible(physicians.drHemoglobin);
       // ReusableMethods.waitFor(3);
       // ReusableMethods.waitForVisibility(physicians.drHemoglobin,2);

        // physicians.drHemoglobin.click();
       // ReusableMethods.waitFor(3);
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       // ReusableMethods.waitForVisibility(physicians.drAlbumin,2);
       // physicians.drAlbumin.click();
       // ReusableMethods.waitFor(3);
       // actions.sendKeys(Keys.PAGE_DOWN).perform();
       // ReusableMethods.waitForVisibility(physicians.drGlucose,3);
      //  physicians.drGlucose.click();

    }

    @And("Save butonuna tiklar")
    public void saveButonunaTiklar() {
        ReusableMethods.waitFor(3);


        physicians.scrollToWebelementVisible(physicians.drSaveButonu);
       ReusableMethods.waitFor(3);
        ReusableMethods.waitForVisibility(physicians.drSaveButonu,2);
       physicians.drSaveButonu.click();
    }

  /*  @And("{string} yazisinin goruldugunu test eder")
    public void yazisininGoruldugunuTestEder(String arg0) {


    }



    @And("{string} yazisinin goruldugunu test eder")
    public void yazisininGoruldugunuTestEder(String arg0) {
  Assert.assertTrue(physicians.drFineText.isDisplayed());
        ReusableMethods.waitFor(3);
    }



    Staff staff=new Staff();





    @Given("Patient SSN kutucuguna hastanin SSN num yazar")
    public void patient_ssn_kutucuguna_hastanin_ssn_num_yazar() {

        physicians.us013PsssKutusu.sendKeys("111-44-1212");
    }


    @Given("Show appointements butonuna tiklar")
    public void show_appointements_butonuna_tiklar() {
       ReusableMethods.waitFor(3);
        physicians.us013showAppointments.click();

    }

    @Given("Show tests butonuna tiklar")
    public void show_tests_butonuna_tiklar() {
      ReusableMethods.waitFor(3);
       physicians.us013ShowTests.click();
    }

    @Given("View results butonuna tiklar")
    public void view_results_butonuna_tiklar() {
       actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForVisibility(physicians.us013ViewResults,2);
        physicians.us013ViewResults.click();
    }

    @And("Urea testin Edit butonuna tiklar Staff guncelleme yapar Save butonuna tiklar")
    public void ureaTestinEditButonunaTiklarStaffGuncellemeYaparSaveButonunaTiklar() {
       ReusableMethods.waitFor(3);
        physicians.us013edit1.click();
        ReusableMethods.waitFor(3);
       actions.sendKeys(Keys.PAGE_DOWN).perform();
        physicians.us013Save.click();
        ReusableMethods.waitFor(4);

        physicians.us013edit2.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        physicians.us013Save.click();
        ReusableMethods.waitFor(4);

        physicians.us013edit3.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        physicians.us013Save.click();
        ReusableMethods.waitFor(4);

        physicians.us013edit4.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        physicians.us013Save.click();
        ReusableMethods.waitFor(4);

        physicians.us013edit5.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        physicians.us013Save.click();
        ReusableMethods.waitFor(4);
    }








    @And("{string} kutusuna gecerli bir username girer")
    public void kutusunaGecerliBirUsernameGirer(String Username) {
        physicians.drUserName.sendKeys(Username);
    }

    @And("{string} kutusuna gecerli bir password girer")
    public void kutusunaGecerliBirPasswordGirer(String Password) {
        physicians.drPassword.sendKeys(Password);
    }

    @And("Search patient butonuna tiklar")
    public void searchPatientButonunaTiklar() {
        physicians.us013searchPatient.click();
    }


    @And("Show Test Results butonuna tiklar")
    public void showTestResultsButonunaTiklar() {
        ReusableMethods.waitFor(3);
       physicians.us013showTestResults.click();
    }

    @And("Hastanin View Results butonuna tiklar")
    public void hastaninViewResultsButonunaTiklar() {
        ReusableMethods.waitFor(3);
        physicians.us013ViewResults.click();
    }

    @And("Test Results yazisinin goruldugunu test eder")
    public void testResultsYazisininGoruldugunuTestEder() {
        Assert.assertTrue(physicians.us013verifyTestResults.isDisplayed());

    }

    @And("Request inpatient butonuna tiklar")
    public void requestInpatientButonunaTiklar() {
     ReusableMethods.waitFor(3);
     physicians.us013requestInpatient.click();
    }
}
*/