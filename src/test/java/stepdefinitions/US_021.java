package stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.Appointments;
import pages.Registration;
import pages.Staff;
import utilities.Driver;

public class US_021 {

    Appointments appointments;
    Registration registration = new Registration();
    Staff staff=new Staff();
    @And("ng staff girisi yapilir")
    public void ng_admin_sifre_girisi_yapilir() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        registration.ngregister.click();
        actions.click(registration.nglistElementiSing).perform();

        registration.ngadminusername.click();
        registration.ngadminusername.sendKeys("neodim92");
        registration.ngadminpassword.sendKeys("ab0414675");
        registration.ngadminsingin.click();


    }

    @And("ng staff edit girisi yapilir")
    public void ng_staff_edit_girisi_yapilir() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngStaffEdit);
        registration.ngStaffEdit.click();

    }

    @And("ng staff adres güncelleme yapilir")
    public void ng_staff_adress_girisi_yapilir() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngStaffAdres);
        Thread.sleep(2000);
        registration.ngStaffAdres.sendKeys("YeniAdres");
        registration.ngStaffSave.click();

    }

    @And("ng staff status girisi yapilir")
    public void ng_staff_status_girisi_yapilir() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngStaffMenu);
        registration.ngStaffMenu.click();
        registration.ngStaffListElement4.click();
        Thread.sleep(5000);
    }

    @And("ng staff status edit girisi yapilir")
    public void ng_staff_status_edit_girisi_yapilir() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngStaffHastaStatus);
        Thread.sleep(5000);
        registration.ngStaffHastaStatus.click();


    }

    @And("ng staff myPages girisi yapilir")
    public void ng_staff_myPages_yapilir() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngStaffMyPages);
        registration.ngStaffMyPages.click();
        registration.ngStaffMyPagesInPatiens.click();

    }

    @And("ng staff Randevulari guncelleyebilir")
    public void ng_staff_randevu_guncelleme() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration.ngStaffMyPagesEdit);
        registration.ngStaffMyPagesEdit.click();


    }

    @And("ng staff Randevu isimleri guncelleyebilir")
    public void ng_staff_randevu_isimleri_guncelleme() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        registration.ngStaffMyPagesEditDescription.click();
        actions.click(registration.nglistElementiSing)
                .sendKeys("Ali")
                .perform();

           }
    @And("ng staff Status guncelleyebilir")
    public void ng_staff_status_guncelleme() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", staff.ngStaffMyPagesEditStatus);
        staff.ngStaffMyPagesEditStatus.click();
    }
}