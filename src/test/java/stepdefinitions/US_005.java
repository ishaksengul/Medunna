package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Patients;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.LocalDate;

public class US_005 {
    Patients patients = new Patients();
    Actions actions=new Actions(Driver.getDriver());

    @Before
    @Given("BS Launch web browser and navigate to the home page")
    public void bs_launch_web_browser_and_navigate_to_the_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));
    }

    @Then("BS Verify the Make an Appointment button is visible and clickable")
    public void bs_verify_the_make_an_appointment_button_is_visible_and_clickable() {
        Assert.assertTrue(patients.makeAnAppointmentButton.isDisplayed());
        Assert.assertTrue(patients.makeAnAppointmentButton.isEnabled());
    }

    @Given("BS Click the Make an Appointment button")
    public void bs_click_the_make_an_appointment_button() {
        Driver.waitAndClick(patients.makeAnAppointmentButton);
        //actions.moveToElement(patients.appointmentRequestForm).perform();
        Driver.wait(1);
    }

    @Then("BS Verify Make an Appointment request form can be seen")
    public void bs_verify_make_an_appointment_request_form_can_be_seen() {
        Assert.assertTrue(patients.makeAppoinmentTitle.isDisplayed());
        Assert.assertTrue(patients.appointmentRequestButton.isDisplayed());
    }

    @Then("BS Click First Name textbox and Enter First Name {string}")
    public void bs_click_first_name_textbox_and_enter_first_name(String US005firstname) {
        patients.lastNameInputBox.click();
        patients.firstNameInputBox.sendKeys(US005firstname);
        //Driver.wait(1);
    }

    @Then("BS Verify First Name textbox is not blank")
    public void bs_verify_first_name_textbox_is_not_blank() {
        Assert.assertFalse(patients.firstNameInputBox.getAttribute("value").isBlank());
    }

    @Then("BS Verify user is using characters for the First Name textbox")
    public void bs_verify_user_is_using_characters_for_the_first_name_textbox() {
        Assert.assertEquals(0,(patients.firstNameInputBox.getAttribute("value").replaceAll("\\w","")).length());
    }

    @Then("BS Click the Last Name textbox and enter Last Name {string}")
    public void bs_click_the_last_name_textbox_and_enter_last_name(String US005lastname) {
        //Driver.wait(1);
        patients.lastNameInputBox.click();
        patients.lastNameInputBox.sendKeys(US005lastname);
    }

    @Then("BS Verify Last Name textbox is not blank")
    public void bs_verify_last_name_textbox_is_not_blank_warning() {
        Assert.assertFalse(patients.lastNameInputBox.getAttribute("value").isEmpty());
    }

    @Then("BS Verify user is using characters for the Last Name textbox")
    public void bs_verify_user_is_using_characters_for_the_last_name_textbox() {
        Assert.assertEquals(0,(patients.lastNameInputBox.getAttribute("value").replaceAll("\\w","")).length());
    }


    @Then("BS Click the SSN textbox and enter SSN number {string}")
    public void bs_click_the_ssn_textbox_and_enter_ssn_number(String US005ssn) {
        //Driver.wait(1);
        patients.ssnInputBox.click();
        patients.ssnInputBox.sendKeys(US005ssn);
    }

    @Then("BS Verify SSN textbox is not blank")
    public void bs_verify_ssn_textbox_is_not_blank() {
        Assert.assertFalse(patients.ssnInputBox.getAttribute("value").isEmpty());
    }

    @Then("BS Verify user is using digits for SSN textbox")
    public void bs_verify_user_is_using_digits_for_ssn_textbox() {
        Assert.assertEquals(0,patients.ssnInputBox.getAttribute("value").replaceAll("[\\d,-]","").length());
        //Assert.assertFalse(patients.ssnInvalidWarning.isDisplayed());
    }

    @Then("BS Verify this SSN is same as a registered SSN")
    public void bs_verify_this_ssn_is_same_as_a_registered_ssn() {
        Assert.assertEquals("425-58-3484",patients.ssnInputBox.getAttribute("value"));
    }

    @Then("BS Click Email textbox and enter a valid Email address {string}")
    public void bs_click_email_textbox_and_enter_a_valid_email_address(String US005email) {
        //actions.moveToElement(patients.appointmentRequestForm).perform();
        patients.emailInputBox.click();
        patients.emailInputBox.sendKeys(US005email);
    }

    @Then("BS Verify Email textbox is not blank")
    public void bs_verify_email_textbox_is_not_blank() {
        Assert.assertFalse(patients.emailInputBox.getAttribute("value").isEmpty());
    }

    @Then("BS Verify user uses @ and . sign")
    public void bs_verify_user_uses_and_sign() {
        Assert.assertTrue(patients.emailInputBox.getAttribute("value").contains("@")&&patients.emailInputBox.getAttribute("value").contains("."));
    }

    @Then("BS Click the Phone textbox and enter a valid Phone number {string}")
    public void bs_click_the_phone_textbox_and_enter_a_valid_phone_number(String US005phone) {
        // Driver.wait(1);
        patients.phoneInputBox.click();
        patients.phoneInputBox.sendKeys(US005phone);
    }

    @Then("BS Verify this number have dash after third and sixth digits")
    public void bs_verify_this_number_have_dash_after_third_and_sixth_digits() {
        System.out.println("patients."+ patients.phoneInputBox.getAttribute("value").substring(3,4));
        System.out.println("patients.phoneInputBox.  : "+ patients.phoneInputBox.getAttribute("value").substring(7,8));
        Assert.assertEquals("-",patients.phoneInputBox.getAttribute("value").substring(3,4));
        Assert.assertEquals("-",patients.phoneInputBox.getAttribute("value").substring(7,8));
    }

    @Then("BS Verify that user is using digits for Phone textbox")
    public void bs_verify_that_user_is_using_digits_for_phone_textbox() {
        Assert.assertEquals(0,patients.phoneInputBox.getAttribute("value").replaceAll("[\\d,-]","").length());
    }

    @Then("BS Verify that this Phone textbox is not blank")
    public void bs_verify_that_this_phone_textbox_is_not_blank() {
        Assert.assertFalse(patients.phoneInputBox.getAttribute("value").isEmpty());
        //Driver.wait(1);
    }

    @Then("BS Click the Appointment DateTime dropbox and select a valid date")
    public void bs_click_the_appointment_datetime_dropbox_and_select_a_valid_date(){
        patients.dateTimeInputBox.click();
        patients.dateTimeInputBox.sendKeys("6"+"25"+ Keys.TAB);
        Driver.wait(1);
    }

    @Then("BS Verify selected date is one of following days")
    public void bs_verify_selected_date_is_one_of_following_days() {
        String date=patients.dateTimeInputBox.getAttribute("value");
        String year=date.substring(0,4);
        String month=date.substring(5,7);
        String day=date.substring(8,10);

        LocalDate actualDate= LocalDate.now();
        if (Integer.parseInt(year)==actualDate.getYear()){
            Assert.assertEquals(Integer.parseInt(year), actualDate.getYear());
            Assert.assertTrue(Integer.parseInt(month)>= actualDate.getMonthValue());
            Assert.assertTrue(Integer.parseInt(day)>= actualDate.getDayOfMonth());
        } else if(Integer.parseInt(year)<actualDate.getYear()){
            Assert.assertTrue(Integer.parseInt(year)>=actualDate.getYear());
        }else{
            Assert.assertTrue(Integer.parseInt(year)>=actualDate.getYear());
        }
    }

    @Then("BS Click Send An Appointment Request button")
    public void bs_click_send_an_appointment_request_button() {
        patients.appointmentRequestButton.click();
    }

    @Then("BS Verify appointment success message which is {string}")
    public void bs_verify_appointment_success_message_which_is(String message)  {
        Driver.wait(1);
        Assert.assertTrue(patients.appointmentSavedToast.isDisplayed());
    }

    @Then("BS Click Account Menu dropbox sign and click Sign In")
    public void bs_click_account_menu_dropbox_sign_and_click_sign_in() {
        patients.accountMenu.click();
        patients.signInButton.click();
        Driver.wait(1);
    }

    @Then("BS Click User Name textbox and enter a valid user name {string}")
    public void bs_click_user_name_textbox_and_enter_a_valid_user_name(String US005username) {
        patients.signInUsername.click();
        patients.signInUsername.sendKeys(US005username);
    }

    @Then("BS Click Password textbox and enter a valid password {string}")
    public void bs_click_password_textbox_and_enter_a_valid_password(String US005password) {
        patients.signInPassword.click();
        patients.signInPassword.sendKeys(US005password);
        Driver.wait(1);
    }

    @Then("BS Click Sign In button")
    public void bs_click_sign_in_button() {
        patients.signInSubmit.click();
    }

    @Then("BS Verify sign in is successfully")
    public void bs_verify_sign_in_is_successfully() {
        Driver.wait(1);
        Assert.assertTrue((patients.burakSariAccount.getText()).contains(patients.firstNameInputBox.getAttribute("value")));
        patients.burakSariAccount.click();
        patients.signOut.click();
        Driver.closeDriver();
    }


    //------------- N e g a t i v e       T e s t s -------------
    @Then("BS Verify user is using non-character for the First Name textbox - Negative")
    public void bsVerifyUserIsUsingNonCharacterForTheFirstNameTextboxNegative() {
        System.out.println(patients.firstNameInputBox.getAttribute("value").replaceAll("\\D", "").length());

        String wrongName= patients.firstNameInputBox.getAttribute("value");
        System.out.println("wrongName = " + wrongName);
        Assert.assertNotEquals(0,(wrongName.replaceAll("\\D", "").length()));
    } //---------

    // ------------- N e g a t i v e       T e s t s -------------
    @Then("BS Verify user is using non-character for the Last Name textbox - Negative")
    public void bsVerifyUserIsUsingNonCharacterForTheLastNameTextboxNegative() {
        Driver.wait(1);
        Assert.assertNotEquals(0, (patients.lastNameInputBox.getAttribute("value").replaceAll("\\D", "")).length());
    } // -------

    @Then("BS Verify that user is also using non-digit for Phone textbox Negative")
    public void bsVerifyThatUserIsAlsoUsingNonDigitForPhoneTextboxNegative() {
        Driver.wait(1);
        Assert.assertTrue(0!=patients.phoneInputBox.getAttribute("value").replaceAll("[\\W,-]","").length());
    }

    @Then("BS Verify user also uses non-digit for SSN textbox Negative")
    public void bsVerifyUserAlsoUsesNonDigitForSSNTextboxNegative() {
        Driver.wait(1);
        Assert.assertTrue(0!=patients.ssnInputBox.getAttribute("value").replaceAll("[\\W,-]","").length());
    }

    @Then("BS Verify user doesn't use @ and . sign Negative")
    public void bsVerifyUserDoesnTUseAndSignNegative() {
        Driver.wait(1);
        Assert.assertFalse(patients.emailInputBox.getAttribute("value").contains("@")&&patients.emailInputBox.getAttribute("value").contains("."));
        Driver.closeDriver();
    }
}
