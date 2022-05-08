package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Staff;
import utilities.Driver;

public class US_023 {

    Staff staff = new Staff();
    Actions actions = new Actions(Driver.getDriver());

    @Given("Kullanici Username kismina valid staff deger girer.")
    public void kullanici_username_kismina_valid_staff_deger_girer() {
        staff.userNameButton.sendKeys("staff.murattm");
    }
    @Given("Kullanici Password kismina valid staff deger girer ve Sign In butonua tiklar.")
    public void kullanici_password_kismina_valid_staff_deger_girer_ve_sign_in_butonua_tiklar() throws InterruptedException {
        staff.passButton.sendKeys("Batch44+");
        staff.signInButton2.click();
        Thread.sleep(1500);
    }

    @And("Kullanici Kullanici My Pages yazisina tiklar.")
    public void kullaniciKullaniciMyPagesYazisinaTiklar() {
        staff.myPagesButton.click();
    }
    @Given("Kullanici acilan alt menude Seach Patient yazisina tiklar.")
    public void kullanici_acilan_alt_menude_seach_patient_yazisina_tiklar() throws InterruptedException {
        staff.searchPatientButton.click();
        Thread.sleep(1500);
    }
    @Given("Kullanici Patients SSN kismina Patient SSN degeri girer.")
    public void kullanici_patients_ssn_kismina_patient_ssn_degeri_girer() throws InterruptedException {
        staff.patientsSSNtextBox.sendKeys("001-01-0004");
        Thread.sleep(1500);

    }
    @Given("Kullanici acilan sayfada Patient icin Show Appointments kismina tiklar.")
    public void     kullanici_acilan_sayfada_patient_icin_show_appointments_kismina_tiklar() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1500);
        staff.showAppointmentsButton.click();
        Thread.sleep(1500);
    }
    @Given("Kullanici acilan sayfada Payment Invoice Process butonuna tiklar.")
    public void kullanici_acilan_sayfada_payment_invoice_process_butonuna_tiklar() throws InterruptedException {
        Thread.sleep(1500);
        staff.paymentInvoiceProcessButton.click();



    }
    @Given("Kullanici Payment Detail ekranindan Creat Invoice kismina tiklar.")
    public void kullanici_payment_detail_ekranindan_creat_invoice_kismina_tiklar() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        staff.createInvoiceButton.click();
        Thread.sleep(3000);

    }
    @Given("Kullanici Create or Edit a Bill sayfasinda patient odeme turunu secer ve Save tusuna basar.")
    public void kullanici_create_or_edit_a_bill_sayfasinda_patient_odeme_turunu_secer_ve_save_tusuna_basar() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        Thread.sleep(3000);
        staff.descriptionText.sendKeys("asedefegeheje");
        Thread.sleep(2000);
        // actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        staff.saveButton.click();
    }


    @Given("Kullanici Payment Detail sayfasinda Show Invoice yazisina tiklar.")
    public void kullanici_payment_detail_sayfasinda_show_invoice_yazisina_tiklar() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        staff.showInvoiceButton.click();
    }
    @Given("Kullanici acilan sayfada INVOICE yazisinin oldugunu dogrular.")
    public void kullanici_acilan_sayfada_invoice_yazisinin_oldugunu_dogrular() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue("Fatura gozukmuyor.",staff.ınvoiceText.isDisplayed());
    }


    @And("Kullanici Payment Detail sayfasindan test ve muayene ucretlerinin goruldugunu dogrular.")
    public void kullaniciPaymentDetailSayfasindanTestVeMuayeneUcretlerininGoruldugunuDogrular() throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertTrue("Exam Fee gorunmuyor",staff.examFeeText.isDisplayed());
       // Assert.assertTrue("Na111 item fee gorunmuyor.",staff.na111FeeText.isDisplayed());
       // Assert.assertTrue("Urea item fee gorunmuyor.",staff.ureaFeeText.isDisplayed());
       // Assert.assertTrue("Creatinine item fee gorunmuyor.",staff.creatinineFeeText.isDisplayed());

    }

    @Then("Kullanici Appointments sayfasinda Status kisminda Completed ya da Cancelled yazisinin goruldugunu dogrular.")
    public void kullaniciAppointmentsSayfasindaStatusKismindaCompletedYaDaCancelledYazisininGoruldugunuDogrular() {
        Assert.assertEquals("COMPLETED",staff.statusTextCompleted.getText());

    }

    @And("Kullanici A Bill is updated with identifier mesajini aldigini dogrular.")
    public void kullaniciABillIsUpdatedWithIdentifierMesajiniAldiginiDogrular() throws InterruptedException {
        //  JSUtils.clickElementByJS(us23_page.toastify);
        Thread.sleep(1500);
        Assert.assertTrue("Fatura olusturulamadi.",staff.toastify.isDisplayed());

    }

    @And("Kullanici Patient Detail sayfasinda Show Invoice yazisina tiklar.")
    public void kullaniciPatientDetailSayfasindaShowInvoiceYazisinaTiklar() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(4000);
        staff.showInvoicePaymentButton.click();
    }
}