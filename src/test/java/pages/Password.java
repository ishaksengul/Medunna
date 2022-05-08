package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Password {
    public Password(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    //Rozimurat


    @FindBy(id = "account-menu")
    public WebElement iconDD;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement iconDD1;

    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement loginItem;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//a[@class='dropdown-item'][2]")
    public WebElement passwordDD;

    @FindBy(xpath = "//input[@id='currentPassword']")
    public WebElement currentPassBox;

    @FindBy(xpath = "//input[@id='newPassword']")
    public WebElement newPassBox;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    public WebElement confirmPassBox;

    @FindBy(xpath = "(//*[@class='invalid-feedback'])")
    public WebElement generalInvalidFeedback;

    @FindBy(xpath = "//label[@for='confirmPassword']")
    public WebElement confirmPassText;

    @FindBy(xpath = "//*[@id='strengthBar']")
    public WebElement strengthBar;

    @FindBy(xpath = "(//*[@class='point'])[1]")
    public WebElement strengthPoint1;

    @FindBy(xpath = "(//*[@class='point'])[2]")
    public WebElement strengthPoint2;

    @FindBy(xpath = "(//*[@class='point'])[3]")
    public WebElement strengthPoint3;

    @FindBy(xpath = "(//*[@class='point'])[4]")
    public WebElement strengthPoint4;

    @FindBy(xpath = "(//*[@class='point'])[5]")
    public WebElement strengthPoint5;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//a[@class='dropdown-item'][2]")
    public WebElement signOutButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "(//div[@role='alert'])[1]")
    public WebElement failedText;
}
