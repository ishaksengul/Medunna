package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.interactions.Actions;
import pages.Admin;
import pages.Password;
import utilities.Driver;

import javax.security.auth.Subject;

public class US_027 {

    Admin admin = new Admin();
    Actions actions = new Actions(Driver.getDriver());


    @Given("Username kutusuna gecerli bir username girer")
    public void username_kutusuna_gecerli_bir_username_girer() {
        admin.us027userName.sendKeys("adminfadime");
    }

    @Given("Password kutusuna gecerli  bir  password girer")
    public void password_kutusuna_gecerli_bir_password_girer() {
        admin.us027password.sendKeys("Batch44+");
    }

    @Given("Sing in1 butonuna tiklar")
    public void sing_in1_butonuna_tiklar() {
        admin.us027singInButonu1.click();
    }

    @Given("Items&Titles  menusune  tiklar")
    public void items_titles_menusune_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        admin.us027itemsTitle.click();
        Thread.sleep(1000);
    }

    @Given("Messages menusune tiklar")
    public void messages_menusune_tiklar() {
        admin.us027messagesButonu.click();
    }


    @And("Messages yazisinin goruntulendigini test eder")
    public void messagesYazisininGoruntulendiginiTestEder() {
        Assert.assertTrue(admin.us027messagesYazisi.isDisplayed());
    }

    @And("Create a new message butonuna tiklar")
    public void createANewMessageButonunaTiklar() {
        admin.us027createAnewMessage.click();
    }

    @And("{string} kutusuna gecerli  bir  password girer")
    public void kutusunaGecerliBirPasswordGirer(String Password) {
        admin.us027password.sendKeys(Password);
    }

    @And("{string}  name giriniz")
    public void nameGiriniz(String string) {
        Driver.wait(2);
        admin.us027nameCreateAnewMessage.sendKeys("fadime");

    }

    @And("{string} email giriniz")
    public void emailGiriniz(String email) {

        admin.us027emailCreateAnewMessage.sendKeys(email);
    }

    @And("{string} Subject giriniz")
    public void subjectGiriniz(String Subject) {

        admin.us027subjectCreateAnewMessage.sendKeys(Subject);
    }

    @And("{string}  Message giriniz")
    public void messageGiriniz(String Message) {
        admin.us027messageCreateAnewMessage.sendKeys(Message);
    }


    @And("save buttonuna tiklar")
    public void saveButtonunaTiklar() {

        admin.us027saveCreateAnewMessage.click();
    }

    @And("A new message is created with identifier {int} yazisini dogrulayin")
    public void aNewMessageIsCreatedWithIdentifierYazisiniDogrulayin(int arg0) {
      Driver.wait(2);
        Assert.assertTrue(admin.saveButtonOnayYazisi.isDisplayed());
    }

//mesaj update

    @And("edit butonuna tiklar")
    public void editButonunaTiklar() {
      //  admin.us027editButonu.click();
       Driver.wait(2);
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();",admin.us027editButonu);


    }

    @And("{string}  name yaziniz")
    public void nameYaziniz(String name) {
        Driver.wait(2);
        admin.us027nameEditButonu.clear();
        Driver.wait(2);
        admin.us027nameEditButonu.sendKeys(name);
    }

    @And("{string} email yaziniz")
    public void emailYaziniz(String email) {
        Driver.wait(2);
        admin.us027emailEditButonu.clear();
        Driver.wait(2);
        admin.us027emailEditButonu.sendKeys(email);
    }

    @And("{string} Subject yaziniz")
    public void subjectYaziniz(String Subject) {
        Driver.wait(2);
        admin.us027subjectEditButonu.clear();
        Driver.wait(2);
        admin.us027subjectEditButonu.sendKeys(Subject);
    }

    @And("{string} Massage yaziniz")
    public void massageYaziniz(String Message) {
        Driver.wait(2);
        admin.us027messageEditButonu.clear();
        Driver.wait(2);
        admin.us027messageEditButonu.sendKeys(Message);
    }

    @And("message is updated with identifier {int} mesayini dogrulayin")
    public void messageIsUpdatedWithIdentifierMesayiniDogrulayin(int arg0) {
      Driver.wait(2);
       Assert.assertTrue(admin.guncellendiMesaji.isDisplayed());
    }

    // mesaj  delete

    @And("Delete butonuna tiklar")
    public void deleteButonunaTiklar() {
        Driver.wait(2);
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();",admin.us027deleteButonu);


    }

    @And("Acilan menuden delete butonuna tiklar")
    public void acilanMenudenDeleteButonunaTiklar() {
        Driver.wait(2);
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();",admin.us027messajeDeleteButonu);


    }

    @And("A message is deleted with identifier {int} mesajini dogrulayin")
    public void aMessageIsDeletedWithIdentifierMesajiniDogrulayin(int arg0) {
       Driver.wait(2);
        Assert.assertTrue(admin.silindiMesaji.isDisplayed());
    }




    // @And("{string}  giriniz")
   // public void giriniz(String name) {
     //  Driver.wait(2);

       // admin.us027nameEditButonu.clear();
     //  Driver.wait(2);

     //   admin.us027nameEditButonu.sendKeys(name);

   // }


}