package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Appointments;
import pages.Physicians;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

import static utilities.ReusableMethods.getScreenshot;

public class US_011 {
    Appointments appointments = new Appointments();
    Physicians physicians = new Physicians();
    ReusableMethods reusableMethods;

    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());

    @Given("user clicks edit button for a patient")
    public void user_clicks_edit_button_for_a_patient() {

        Driver.waitAndClick(appointments.editPatientButton);


    }
    @Given("user asserts that he can go to create and edit appointment page")
    public void user_asserts_that_he_can_go_to_create_and_edit_appointment_page() {
        appointments.createOrEditAppointmentTextEl.isDisplayed();
    }

    @Given("user asserts the visibility of the appointment table")
    public void user_asserts_the_visibility_of_the_appointment_table() throws InterruptedException, IOException {

        getScreenshot("webTable");

    }

    @Given("user sends text for anamnesis textbox")
    public void user_sends_text_for_anamnesis_textbox() {

        Driver.waitAndSendText(appointments.anamnesisTextArea, ("Head trauma in the past"));
    }
    @Given("user sends text for treatment textbox")
    public void user_sends_text_for_treatment_textbox() {

        Driver.waitAndSendText(appointments.treatmentTextArea, ("use aspirin"));
    }
    @Given("user send text for diagnosis textbox")
    public void user_send_text_for_diagnosis_textbox() {
        Driver.waitAndSendText(appointments.diagnosisTextArea, ("blood test and xray"));

    }

    @Given("user clicks anamnesis textbox but doesn't send text")
    public void user_clicks_anamnesis_textbox_but_doesn_t_send_text() {


        Driver.waitAndSendText(appointments.anamnesisTextArea, (""));

    }
    @Given("user gets invalid feedback warning anamnesis")
    public void user_gets_invalid_feedback_warning_anamnesis() {
        appointments.bosluk.click();
        appointments.anamnesisThisFieldisRequiredText.isDisplayed();
    }
    @Given("user clicks treatment textbox but doesn't send text")
    public void user_clicks_treatment_textbox_but_doesn_t_send_text() {

        Driver.waitAndSendText(appointments.treatmentTextArea, (""));

    }
    @Given("user gets invalid feedback warning treatment")
    public void user_gets_invalid_feedback_warning_treatment() {
        appointments.bosluk.click();
        appointments.treatmentThisFieldisRequiredText.isDisplayed();
    }
    @Given("user clicks diagnosis textbox  but doesn't send text")
    public void user_clicks_diagnosis_textbox_but_doesn_t_send_text() {

        Driver.waitAndSendText(appointments.diagnosisTextArea, (""));

    }
    @Given("user gets invalid feedback warning diagnosis")
    public void user_gets_invalid_feedback_warning_diagnosis() {
        appointments.bosluk.click();
        appointments.diagnosisThisFieldisRequiredText.isDisplayed();
    }
    @Given("user clicks prescription text box but doesn't send text")
    public void user_clicks_prescription_text_box_but_doesn_t_send_text() {

        Driver.waitAndSendText(appointments.prescriptionTextArea, (""));

    }

    @Given("user clicks description text box but doesn't send text")
    public void user_clicks_prescription_and_description_text_box_but_doesn_t_send_text() {

        Driver.waitAndSendText(appointments.descriptionTextArea, (""));
    }
    @Given("user asserts that they did not receive invalid feedback warnings")
    public void user_asserts_that_they_did_not_receive_invalid_feedback_warnings() {

    }

    @And("user clicks the status text box and asserts that PENDING, COMPLETED and CANCELLED is selectable")
    public void userClicksTheStatusTextBoxAndAssertsThatPENDINGCOMPLETEDAndCANCELLEDIsSelectable() throws InterruptedException, IOException {
        WebElement dropdownEl= appointments.statusTextBox;
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.waitForVisibility(dropdownEl, 5);
        Select select = new Select(dropdownEl);
        Thread.sleep(3000);
        select.selectByValue("PENDING");
        getScreenshot("pending");

        Thread.sleep(3000);
        select.selectByValue("COMPLETED");
        getScreenshot("completed");

        Thread.sleep(3000);
        select.selectByValue("CANCELLED");
        getScreenshot("cancelled");
    }


}
