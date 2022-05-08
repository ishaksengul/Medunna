package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPage {
    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Burak Bey

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement dropDownmenu;

    @FindBy(xpath = "//img[@alt='Logo']")
    public WebElement mainPageLogo;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[1]")
    public WebElement signIn;

    @FindBy(xpath = "//div[@id='login-title']")
    public WebElement signInHeader;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameInputBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOut;

    @FindBy(id = "rememberMe")
    public WebElement rememberMeCheckbox;

    @FindBy(xpath = " //span[text()='Did you forget your password?']")
    public WebElement didYouForgetYourPassword;

    @FindBy(xpath = "//span[text()='Cemile Turkmen']")
    public WebElement accountName;

    @FindBy(xpath = "//span[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement resetYourPasswordButton;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//*[contains(text(),'Check your email for details on how to reset your password.')]")
    public WebElement container;
    @FindBy(xpath = "//div[text()='Check your emails for details on how to reset your password.']")
    public WebElement toaster;

    @FindBy(xpath = "//strong[text()='Failed to sign in!']")
    public WebElement failedToSignIn;

    @FindBy(xpath = "//span[text()='Register a new account']")
    public WebElement registerNewAccount;

    @FindBy(xpath = "//span[text()='Reset your password']")
    public WebElement resetYourPasswordHeader;

    @FindBy(xpath = "//span[text()='Registration']")
    public WebElement registrationPage;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement containerDidYouForget;

    //Murat Emin
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement dropDownElementi;
    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement dropDownSignInButton;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameTextBox;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SignInButton;
    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement MyAppointmentsDropDown;
    @FindBy(xpath = "//a[@class='dropdown-item active']")
    public WebElement myInpatients;
    //MuratEmin Sprint  2
    @FindBy(xpath = "//a[@class='dropdown-item'][1]")
    public WebElement MyAppointmentsDropDownItem;
}