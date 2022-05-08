package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Patients {
    public Patients() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//img[@alt='Logo'])")
    public WebElement homePageLogo;
    @FindBy(xpath = "(//span[text()='Make an'])")
    public WebElement makeAnAppointmentButton;

    @FindBy(xpath = "//h2[text()='Make an Appointment']")
    public WebElement makeAppoinmentTitle;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameInputBox;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameInputBox;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssnInputBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneInputBox;

    @FindBy(xpath = "//input[@name='appoDate']")
    public WebElement dateTimeInputBox;

    @FindBy(xpath = "//button/span[text()='Send an Appointment Request']")
    public WebElement appointmentRequestButton;

    @FindBy(id = "app-view-container")
    public WebElement appointmentSavedToast;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;
    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement signInButton;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement signInUsername;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement signInPassword;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInSubmit;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOut;

    @FindBy(xpath = "//span[text()='Burak Sari']")
    public WebElement burakSariAccount;

    //Murat Emin
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm'][1]")
    public WebElement ShowTests;
    @FindBy(xpath = "//span[text()='Tests']")
    public WebElement testsText;
    @FindBy(xpath = "//a[@class='btn btn-info btn-sm'][1]")
    public WebElement viewResultButton;
    @FindBy(xpath = "//div[@class='table-responsive']")
    public WebElement viewResultsTable;
    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/table/thead/tr[7]/th[3]")
    public WebElement totalCostAmount;
    @FindBy(xpath = "//a[@href='/patient-invoice-show/75349']")
    public WebElement showInvoiceButton;
    @FindBy(xpath = "//span[text()='Show Invoice']")
    public WebElement showInvoiceButton2;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement faturaSonucElementi;
    @FindBy(xpath = "//div[@class='container-fluid view-container']")
    public WebElement viesSayfasi;

}