package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_004 {
    SignInPage singninPage = new SignInPage();

    @Given("BS navigate to Medduna Home Page")
    public void bs_navigate_to_medduna_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));
    }

    @When("BS Verify that home page is visible successfully")
    public void bs_verify_that_home_page_is_visible_successfully() {
        Driver.waitForVisibility(singninPage.mainPageLogo, 5);
    }

    @When("BS Click on Account DropDownMenu button")
    public void bs_click_on_account_drop_down_menu_button() {
        Driver.wait(3);
        Driver.waitAndClick(singninPage.dropDownmenu);
    }

    @When("BS Click on Sign in")
    public void bs_click_on_sign_in() {
        Driver.wait(3);
        Driver.waitAndClick(singninPage.signIn);
        Driver.wait(3);
    }

    @When("BS Click on Username input box.")
    public void bs_click_on_username_input_box() {
        Driver.wait(2);
        Driver.waitAndClick(singninPage.userNameInputBox);
        Driver.wait(3);
    }

    @Then("BS Enter Valid {string} Username")
    public void bsEnterValidUsername(String username) {
        singninPage.userNameInputBox.sendKeys(username);
    }

    @Then("BS Click on Password input box.")
    public void bs_click_on_password_input_box() {
        Driver.wait(3);
        singninPage.userNameInputBox.sendKeys(Keys.TAB);
        Driver.wait(3);
    }

    @Then("BS Enter Valid {string} Password")
    public void bsEnterValidPassword(String pasw) {
        singninPage.passwordInputBox.sendKeys(pasw);
        Driver.wait(3);
    }

    @And("Verify that Sign Out  is displayed")
    public void verifyThatSignOutIsDisplayed() {
        Driver.waitAndClick(singninPage.accountName);
        Driver.wait(3);
        Assert.assertTrue(singninPage.signOut.isDisplayed());
    }

    @And("BS Verify Sign in page header is visible")
    public void bsVerifySignInPageHeaderIsVisible() {
        Assert.assertTrue(singninPage.signInHeader.isDisplayed());
        Driver.wait(3);
    }

    @And("BS Verify Sign in Header is visible")
    public void bsVerifySignInHeaderIsVisible() {
        Driver.waitForVisibility(singninPage.signInHeader, 3);
    }

    @Then("BS Click on Sign in button")
    public void bsClickOnSignInButton() {
        Driver.waitAndClick(singninPage.signInButton);
        Driver.wait(3);
    }

    @Then("BS Verify that Cancel button is enable")
    public void bsVerifyThatCancelButtonIsEnable() {
        Assert.assertTrue(singninPage.cancelButton.isEnabled());
    }

    @And("BS Verify that remember me checkbox is clickable")
    public void bsVerifyThatRememberMeCheckoutIsClickable() {
        singninPage.rememberMeCheckbox.click();
        Assert.assertTrue(singninPage.rememberMeCheckbox.isSelected());
        Driver.wait(3);
    }

    @And("BS Click on Did you forget your password? text box")
    public void bsClickOnDidYouForgetYourPasswordTextBox() {
        singninPage.didYouForgetYourPassword.click();
        Driver.wait(3);
        singninPage.didYouForgetYourPassword.click();
    }

    @And("BS Verify that Did you forget your password? Header is visible")
    public void bsVerifyThatDidYouForgetYourPasswordHeaderIsVisible() {
        Assert.assertTrue(singninPage.container.isDisplayed());
    }

    @And("BS Click on email text box")
    public void bsClickOnEmailTextBox() {
        singninPage.emailInputBox.sendKeys(Keys.ENTER);
    }

    @And("BS Enter the {string} address you used to register")
    public void bsEnterTheAddressYouUsedToRegister(String email) {
        singninPage.emailInputBox.sendKeys(email);
        singninPage.emailInputBox.sendKeys(Keys.TAB);
    }

    @And("BS Click on Reset password button")
    public void bsClickOnResetPasswordButton() {
        Driver.wait(3);
        singninPage.resetYourPasswordButton.click();
        Driver.wait(3);
    }

    @And("BS Verify Alert Check your emails for details on how to reset your password is visible")
    public void bsVerifyAlertCheckYourEmailsForDetailsOnHowToResetYourPasswordIsVisible() {
        String toasterText = singninPage.toaster.getText();
        String expectedData = "Check your emails for details on how to reset your password.";
        Assert.assertEquals(expectedData, toasterText);
        //Assert.assertTrue(singninPage.toaster.isDisplayed());
    }

    @And("BS Verify You don't have an account yet? Register a new account is visible")
    public void bsVerifyYouDonTHaveAnAccountYetRegisterANewAccountIsVisible() {
        Assert.assertTrue(singninPage.registerNewAccount.isDisplayed());
    }

    @And("BS Click on Register a new account")
    public void bsClickOnRegisterANewAccount() {

        singninPage.registerNewAccount.click();
        singninPage.registerNewAccount.click();
        Driver.wait(3);
    }

    @And("BS Verify that Reset your password? Header is visible")
    public void bsVerifyThatResetYourPasswordHeaderIsVisible() {
        Driver.wait(3);
        Assert.assertTrue(singninPage.resetYourPasswordHeader.isDisplayed());
    }

    @And("BS Verify that  Registration Page is visible")
    public void bsVerifyThatRegistrationPageIsVisible() {

        Assert.assertTrue(singninPage.registrationPage.isDisplayed());
    }

    @And("Verify that Failed to sign in!  is displayed")
    public void verifyThatFailedToSignInIsDisplayed() {
        String toasterText = singninPage.containerDidYouForget.getText();
        String expectedData = "Authentication information not correct.";
        Assert.assertEquals(expectedData, toasterText);

    }

    @Then("BS Enter wrong {string} Password")
    public void bsEnterWrongPassword(String wpassword) {
        singninPage.passwordInputBox.sendKeys(wpassword);
        Driver.wait(3);
    }

    @Then("BS Enter wrong {string} Username")
    public void bsEnterWrongUsername(String wusername) {
        singninPage.userNameInputBox.sendKeys(wusername);
        Driver.wait(3);
    }

    @Then("Verify that Authentication information not correct  is displayed")
    public void verifyThatAuthenticationInformationNotCorrectIsDisplayed() {
        String toasterText = singninPage.containerDidYouForget.getText();
        String expectedData = "Authentication information not correct.";
        Assert.assertEquals(expectedData, toasterText);
    }
}
