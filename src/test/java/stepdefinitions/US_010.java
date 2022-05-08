package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Appointments;
import pages.Physicians;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_010 extends ReusableMethods {
    Appointments appointments = new Appointments();
    Physicians physicians = new Physicians();
    ReusableMethods reusableMethods;

    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());

    @Given("go to Medunna website")
    public void go_to_medunna_website() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));
    }
    @Given("user logins as doctor")
    public void user_logins_as_doctor() {
        appointments.userItem.click();

        Driver.waitAndClick(appointments.loginItem);
        Driver.waitAndSendText(appointments.userNameBox, (ConfigReader.getProperty("Doktor_username")));
        appointments.passBox.sendKeys(ConfigReader.getProperty("Doktor_pass")+Keys.ENTER);
    }
    @Given("user goes to my page and clicks my appointments")
    public void user_goes_to_my_page_and_clicks_my_appointments() {

        Driver.waitAndClick(appointments.myPagesIconDoctor);
       // appointments.myPagesIconDoctor.click();
        Driver.waitAndClick(appointments.myAppointmentsDoctor);

    }
    @Given("user asserts the visibility of appointment list and time slots")
    public void user_asserts_the_visibility_of_appointment_list_and_time_slots() {
        Assert.assertTrue(appointments.tableVisibl.isDisplayed());
        //System.out.println(appointments.tableVisibl.getText());


    }
    @And("user asserts the visibility of patient id, start date, end date, status")

    public void userAssertsTheVisibilityOfPatientIdStartDateEndDateStatus() {
        Driver.waitForVisibility(appointments.idText, 3);
        Assert.assertTrue(appointments.idText.isDisplayed());

        Driver.waitForVisibility(appointments.startDateText, 3);
        Assert.assertTrue(appointments.startDateText.isDisplayed());

        Driver.waitForVisibility(appointments.endDateText, 3);
        Assert.assertTrue(appointments.endDateText.isDisplayed());

        Driver.waitForVisibility(appointments.statusText, 3);
        Assert.assertTrue(appointments.statusText.isDisplayed());
        //System.out.println(appointments.startDateText.getText());
    }
    @Then("close the page")
    public void close_the_page() {
        Driver.closeDriver();
    }


}
