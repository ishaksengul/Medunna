package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Appointments;
import pages.Registration;
import utilities.Driver;



public class US_020 {

    Appointments appointments;
    Registration registration = new Registration();

// Team92Admin
    // Batch44+


    @And("ng admin girisi yapilir")
    public void ng_admin_girisi_yapilir() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        registration.ngregister.click();
        actions.click(registration.nglistElementiSing).perform();


    }

    @And("ng admin sifre girisi yapilir")
    public void ng_admin_sifre_girisi_yapilir() throws InterruptedException {

        registration.ngadminusername.click();
        registration.ngadminusername.sendKeys("Team92Admin");
        registration.ngadminpassword.sendKeys("Batch44+");
        registration.ngadminsingin.click();


    }

    @And("ng admin menü girisi yapilir")
    public void ng_admin_menu_girisi_yapilir() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngadminmenu);
        registration.ngadminmenu.click();
        registration.ngadminmenuuser.click();
        Thread.sleep(3000);

    }
    @And("ng view girisi yapilir")
    public void ng_view_girisi_yapilir(){
        registration.ngview.click();

    }
    @And("ng admin view bilgilerini görür")
    public void ng_admin_view_bilgileri(){
        System.out.println(registration.ngviewbilgiler.getText());

    }
    @And("ng admin Edit girisi yapar")
    public void ng_admin_Edit_bilgileri() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngviewEdit);
        registration.ngviewEdit.click();

    }
    @And("ng admin RoleUser secimi yapar")
    public void ng_admin_Role_User_secim() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngRoleUser);
        registration.ngRoleUser.click();

    }
    @And("ng admin Delete secimi yapar")
    public void ng_admin_Delete_secim() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngDelete);
        registration.ngDelete.click();

    }
    @Then("ng sayfayi kapatir")
    public void sayfayiKapatir() {

       Driver.getDriver().close();
    }

}


