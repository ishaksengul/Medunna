package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Staff;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class US_022 {

    Staff staff = new Staff();
    Actions actions = new Actions(Driver.getDriver());

    @Given("EG staff myPages e tiklar")
    public void eg_staff_my_pages_e_tiklar() {
        staff.MyPageButton.click();
    }
    @Given("EG staff search patient sayfasina gider")
    public void eg_staff_search_patient_sayfasina_gider() {
        staff.SearchPatientButton.click();
    }
    @Given("EG staff search ssn kutusuna hastanin ssn ini yazar")
    public void eg_staff_search_ssn_kutusuna_hastanin_ssn_ini_yazar() {
        staff.SsnAramaTextbox.sendKeys("119-99-9962");
    }
    @Given("EG staff ssn ini girdigi hastayi bulur")
    public void eg_staff_ssn_ini_girdigi_hastayi_bulur() {
        Assert.assertTrue(staff.EditButton.isDisplayed());
    }
    @Given("EG staff edit butonuna tiklar")
    public void eg_staff_edit_butonuna_tiklar() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT).perform();
        ReusableMethods.waitFor(5);
       staff.editButtonE.click();
    }
    @Given("EG staf ciyesiyeti other yapar ve kaydeder")
    public void eg_staf_ciyesiyeti_other_yapar() {

        actions.sendKeys(Keys.PAGE_DOWN,Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(3);
        WebElement genderDropdown = staff.genderDropdownElement;
        Select select = new Select(genderDropdown);
        select.selectByVisibleText("OTHER");
        staff.genderDropdownElement.sendKeys(Keys.TAB);

        actions.sendKeys(Keys.TAB,Keys.TAB,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.waitFor(3);
        staff.saveButtonE.click();
    }
    @Given("EG degisikligin onaylandigini gorur")
    public void eg_degisikligin_onaylandigini_gorur() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(staff.toastAlert.isDisplayed());
    }


}
