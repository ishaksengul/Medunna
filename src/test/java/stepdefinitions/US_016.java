package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.Admin;
import pojos.Room;
import pojos.RoomPost;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static utilities.WriteToTxt.saveRoomData;

public class US_016 {
    Admin admin= new Admin();

    Faker faker=new Faker();
    Room room;
    Response response;
    RoomPost roomPost;
    static String roomNumber="";
    static int price=0;
    static String createdDate="";
    String query="";


    @And("BS Click on Items&Titles")
    public void bsClickOnItemsTitles() {
        Driver.waitAndClick(admin.itemsTitlesDropdown);
    }

    @And("BS select Room from drop down menu and click")
    public void bsSelectRoomFromDropDownMenuAndClick() {

        Driver.waitAndClick(admin.roomDropdown);

    }
    @And("BS user navigates page to Rooms page")
    public void bsUserNavigatesPageToRoomsPage() {
        //  Driver.waitAndClick(createOrEditARoomByAdminPage.itemsTitlesDropdown);
        Driver.clickWithJS(admin.roomDropdown);
        assertTrue(Driver.waitForVisibility(admin.roomsHeading,1).isDisplayed());
    }

    @When("BS user clicks on Create a new Room button")
    public void bsUserClicksOnCreateANewRoomButton() {
        Driver.waitAndClick(admin.createANewRoomButton);
    }

    @Then("BS verify that user on the {string} page")
    public void bsVerifyThatUserOnThePage(String arg0) {
        assertTrue(Driver.waitForVisibility(admin.createOrEditARoomHeading, 1).isDisplayed());
    }
    @Given("BS user provides a Room Number")
    public void bsUserProvidesARoomNumber() {
        roomNumber=String.valueOf(faker.number().numberBetween(100,300));
        Driver.waitAndSendText(admin.roomNumberTextBox,roomNumber );
    }

    @And("BS user provides a Price")
    public void bsUserProvidesAPrice() {
        price=faker.number().numberBetween(100,500);
        Driver.waitAndSendText(admin.priceTextBox,String.valueOf(price));

    }

    @And("BS user sets date as {string}")
    public void bsUserSetsDateAs(String arg0) {
        createdDate=arg0;
        Driver.waitAndSendText(admin.createdDateTextBox,createdDate);
        saveRoomData(roomNumber,price,createdDate);
    }

    @And("BS verify that Created Date is updated automatically")
    public void bsVerifyThatCreatedDateIsUpdatedAutomatically() {

        Driver.waitForVisibility(admin.roomsHeading,1);
        Driver.clickWithJS(admin.lastPage);
        Driver.wait(1);
        String lastRow=
                admin.allRows.get(admin.allRows.size()-1).getText();

        System.out.println(lastRow);
        Driver.wait(1);
        assertTrue(lastRow.contains(roomNumber));
        assertTrue(lastRow.contains(String.valueOf(price)));
        assertFalse(lastRow.contains(createdDate));

    }


    @Given("BS user leave blank Room Number field and click enter")
    public void bsUserLeaveBlankRoomNumberFieldAndClickEnter() {
        Driver.waitAndSendText(admin.roomNumberTextBox,""+ Keys.ENTER);

    }

    @And("BS user should see {string} feedback twice")
    public void bsUserShouldSeeFeedbackTwice(String arg0) {
        assertEquals(arg0,Driver.waitAndGetText(admin.invalidFeedbacks.get(0),1));
        assertEquals(arg0,Driver.waitAndGetText(admin.invalidFeedbacks.get(1),1));

    }

    @When("BS user clicks on the Room Type dropdown")
    public void userClicksOnTheRoomTypeDropdown() {
        Driver.waitAndClick(admin.roomTypeSelect);
    }

    @Then("BS user should see options like {string}, {string}, {string}, {string} and {string}")
    public void bsUserShouldSeeOptionsLikeAnd(String arg0, String arg1, String arg2, String arg3, String arg4) {
        Select options=new Select(admin.roomTypeSelect);
        List<String > expectedData=new ArrayList<>();
        expectedData.add(arg0);
        expectedData.add(arg1);
        expectedData.add(arg2);
        expectedData.add(arg3);
        expectedData.add(arg4);
        List<String> actualData=new ArrayList<>();
        for (WebElement w:options.getOptions()
        ) {
            actualData.add(w.getText());
        }

        assertTrue(actualData.containsAll(expectedData));

    }

    @And("BS user can set current status for the room")
    public void bsUserCanSetCurrentStatusForTheRoom() {
        Driver.waitAndClick(admin.statusCheckBox);
        assertTrue(admin.statusCheckBox.isSelected());
    }


    @Given("BS user on the Rooms page")
    public void bsUserOnTheRoomsPage() {
        Driver.getDriver().navigate().back();
        assertTrue(Driver.waitForVisibility(admin.roomsHeading,1).isDisplayed());
    }

    @And("BS user should see all rooms on the same page")
    public void bsUserShouldSeeAllRoomsOnTheSamePage() {
        Driver.wait(1);
        assertEquals(20, admin.allRows.size());
        System.out.println(admin.allRows.size());
    }

    @When("BS user clicks on {string} button for last created room")
    public void bsUserClicksOnButtonForRoomWithIdNumber(String arg0) {
        Driver.waitAndClick(admin.lastPage);
        Driver.wait(1);
        if(arg0.equals("edit"))  {
            Driver.waitAndClick(admin.editElements.get(admin.allRows.size()-1));
        }else if (arg0.equals("delete")){
            Driver.waitAndClick(admin.deleteElements.get(admin.allRows.size()-1));
        }


    }

    @And("BS user provides {string} as description")
    public void bsUserProvidesAsDescription(String arg0) {
        Driver.waitAndSendText(admin.descriptionTextBox,arg0);
    }

    @And("BS user confirms delete operation")
    public void bsUserConfirmsDeleteOperation() {
        Driver.waitAndClick(admin.deleteConfirm);
    }

    @When("BS user clicks on the Save button")
    public void bsUserClicksOnTheSaveButton() {
    }

    @Then("BS user should see the {string}")
    public void bsUserShouldSeeThe(String arg0) {
    }
}
