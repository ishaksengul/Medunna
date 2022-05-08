package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;
import java.util.List;

public class Appointments {
    public Appointments() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement girisIkonu;

    @FindBy(xpath = "//h1[text()='Welcome to MEDUNNA']")
    public WebElement welcomeToMedunna;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement anaSayfaSignIn;


    @FindBy(xpath = "//div[@id='login-title']")
    public WebElement signInMenusu;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement girisUsernameTextBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement girisPasswordTextBox;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement girisSignInButton;

    @FindBy(xpath = "//li[@id='entity-menu']//a[@class='d-flex align-items-center dropdown-toggle nav-link']//*[name()='svg']")
    public WebElement myPagesElementi;

    @FindBy(xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[2]")
    public WebElement sagUstKullaniciAdi;

    @FindBy(xpath = "//span[text()='Settings']")
    public WebElement settingsButton;

    @FindBy(xpath = "//span[text()='User settings for [']")
    public WebElement userSettingsFor;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement settingsFirstnameTextBox;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement settingsLastnameTextBox;


    @FindBy(xpath = "//input[@name='email']")
    public WebElement settingsEmailTextBox;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement settingsSaveButton;


    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement settingsDegisikliklerKaydedildiElement;

    @FindBy(xpath = "//span[normalize-space()='Make an Appointment']")
    public WebElement makeAnAppointment;


    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneNumberTextBox;


    @FindBy(xpath = "//span[normalize-space()='Appointment date can not be past date!']")
    public WebElement gecersizTarihUyarisi;

    @FindBy(xpath = "//button[@id='register-submit']")
    public WebElement sendAnAppointmentRequest;

    @FindBy(xpath = "//input[@id='appoDate']")
    public WebElement dateTextBox;


























    // Ishak Bey
    // enter the login
    @FindBy (id = "account-menu")
    public WebElement userItem;

    @FindBy (id = "login-item")
    public WebElement loginItem;

    @FindBy (id = "username")
    public WebElement userNameBox;

    @FindBy (id = "password")
    public WebElement passBox;

    @FindBy (xpath = "//button[@type=\"submit\"]")
    public WebElement signInButton;

    @FindBy (xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/table")
    public WebElement tableVisibl;

    @FindBy (xpath = "//tbody/tr/td[1]")
    public WebElement idText;

    @FindBy (xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/table/tbody/tr/td[2]/span")
    public WebElement startDateText;

    @FindBy (xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/table/tbody/tr/td[3]")
    public WebElement endDateText;

    @FindBy (xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/table/tbody/tr/td[4]/span")
    public WebElement statusText;


    //after log in to go to the "appointments"
    @FindBy (xpath = "//li[@id=\"entity-menu\"]")
    public WebElement myPagesIconDoctor;

    @FindBy (xpath = "//span[text()=\"My Appointments\"]")
    public WebElement myAppointmentsDoctor;

    @FindBy (xpath = "//tbody/tr/td[13]/div/a")
    public WebElement editPatientButton;

    @FindBy (xpath = "//h2[@id=\"hospitalmsappfrontendApp.appointment.home.createOrEditLabel\"]")
    public WebElement createOrEditAppointmentTextEl;


    //Doctor's "appointment" page
    @FindBy (xpath = "//tbody//tr")
    public List<WebElement> appointmentTableList;

    @FindBy (id = "toDate")
    public WebElement timeSlotFrom;

    @FindBy (id = "fromDate")
    public WebElement timeSlotTo;

    @FindBy (xpath = "//tbody//tr//td")
    public List<WebElement> appointmentTableListData;

    //Doctor's "create or edit an appointment" page
    @FindBy (xpath = "//textarea[@name=\"anamnesis\"]")
    public WebElement anamnesisTextArea;

    @FindBy (xpath = "(//div[@class=\"invalid-feedback\"])[1]")
    public WebElement anamnesisThisFieldisRequiredText;

    @FindBy(xpath = "//textarea[@name=\"treatment\"]")
    public WebElement treatmentTextArea;

    @FindBy (xpath = "(//div[@class=\"invalid-feedback\"])[2]")
    public WebElement treatmentThisFieldisRequiredText;

    @FindBy(xpath = "//textarea[@name=\"diagnosis\"]")
    public WebElement diagnosisTextArea;

    @FindBy (xpath = "(//div[@class=\"invalid-feedback\"])[3]")
    public WebElement diagnosisThisFieldisRequiredText;

    @FindBy (xpath = "//textarea[@name=\"prescription\"]")
    public WebElement prescriptionTextArea;

    @FindBy (id = "appointment-description")
    public WebElement descriptionTextArea;

    @FindBy (xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[3]")
    public WebElement bosluk;

    @FindBy (id = "appointment-status")
    public WebElement statusTextBox;

    //Murat Emin
    @FindBy (xpath = "//span[text()='MY PAGES']")
    public WebElement myPagesDropdown;
    @FindBy(xpath = "//span[text()='My Inpatients']")
    public WebElement MyInpatients;
    @FindBy (xpath = "//div[@class='btn-group flex-btn-group-container']")
    public WebElement editButonu;
    public WebElement sonucYazisiElementi;
    @FindBy (xpath = "//input[@name='id']")
    public WebElement idTextBox;
    @FindBy (xpath="//table[@class='table']")
    public WebElement inpatientsPageTable;
    @FindBy (xpath = "//select[@name='status']")
    public WebElement InpatientStatusDropdown;
    @FindBy (xpath = "//span[text()='Save']")
    public WebElement InpatientSaveButton;
    @FindBy(xpath = "//select[@name='room.id']")
    public WebElement inPatientRoomDropdown;
    @FindBy (xpath = "//a[@id='cancel-save']")
    public WebElement InpatientCancelButton;
    //MuratEminUs025
    @FindBy (xpath = "//a[@class='dropdown-item'][2]")
    public WebElement MakeAppointmentDropdown;
    @FindBy (xpath = "//input[@name='firstName']")
    public WebElement MakeAppointmentFirstNameTextBox;
    @FindBy (xpath = "//input[@name='lastName']")
    public WebElement MakeAppointmentLastNameTextBox;
    @FindBy (xpath = "//input[@name='ssn']")
    public WebElement MakeAppointmentSsnTextBox;
    @FindBy (xpath = "//input[@name='phone']")
    public WebElement MakeAppointmentSPhoneTextBox;
    @FindBy (xpath = "//input[@name='email']")
    public WebElement MakeAppointmentEmailTextBox;
    @FindBy (xpath = "//input[@name='appoDate']")
    public WebElement MakeAppointmentDateTimeTextBox;
    @FindBy(xpath = "//button[@id='register-submit']")
    public WebElement MakeAppointmentregisterSubmitButton;
    @FindBy (xpath = "//div[@class='Toastify']")
    public WebElement positiveAppointmentResultButton;

}