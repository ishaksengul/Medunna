package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Staff {

    // Seyma Hanim
    public Staff() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")// id ="header-tabs"
    public WebElement AccountMenu;

    @FindBy(id = "login-item")
    public WebElement SignIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement UsernameTextbox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement PasswordTextbox;

    @FindBy(xpath = "(//span[text()='Sign in'])[3]")
    public WebElement SignInButton;

    @FindBy(partialLinkText = "MY PAGES")
    public WebElement MyPageButton;

    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement SearchPatientButton;

    @FindBy(partialLinkText = "In Patient")
    public WebElement InPatientButton;

    @FindBy(id = "fromDate")
    public WebElement FromDateTextbox;

    @FindBy(id = "toDate")
    public WebElement ToDateTextbox;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> allHeaders;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement SsnAramaTextbox;

    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement EditButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstnameTextbox;

    @FindBy(xpath = "//input[@id='patient-lastName']")
    public WebElement lastnameTextbox;

    @FindBy(xpath = "//input[@id='patient-birthDate']")
    public WebElement birthdateTextbox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='patient-phone']")
    public WebElement phoneTextbox;

    @FindBy(xpath = "//select[@name='gender']")
    public WebElement genderDropdownElement;

    @FindBy(xpath = "//select[@id='patient-bloodGroup']")
    public WebElement bloodGroupDropdownElement;

    @FindBy(xpath = "//input[@id='patient-adress']")
    public WebElement addressTextbox;

    @FindBy(xpath = "//textarea[@id='patient-description']")
    public WebElement descriptionTextbox;

    @FindBy(xpath = "//select[@id='patient-user']")
    public WebElement userDropdownElement;

    @FindBy(xpath = "//select[@id='patient-country']")
    public WebElement countryDropdownElement;

    @FindBy(xpath = "//select[@name='cstate.id']")
    public WebElement stateDropdownElement;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement saveToastify;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    public WebElement viewButton;

    @FindBy(xpath = "//b[text()='51252']")
    public WebElement patientYaziElement;

    @FindBy(xpath = "(//div[text()='This field is required.'])[1]")
    public WebElement deleteHataYazisi;

    @FindBy(id = "cancel-save")
    public WebElement backButton;

    @FindBy(xpath = "(//span[@class='d-none d-md-inline'])[3]")
    public WebElement deleteButton;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement satirElementi;


    public List<WebElement> tumHucreDegerleri() {

        //  //tbody//tr//td[1] butun satırı dınamık yapıcaz
        List<WebElement> tabloSatiri = new ArrayList<>();

        WebElement istenenHucreDegeri = null;
        for (int i = 1; i < 16; i++) {
            String dinamikSatirXpath = "//tbody//tr//td[" + i + "]";
            istenenHucreDegeri = Driver.getDriver().findElement(By.xpath(dinamikSatirXpath));
            tabloSatiri.add(istenenHucreDegeri);

        }

        return tabloSatiri;
    }

    @FindBy(xpath = "//table//tr")
    public WebElement tableTablosu;



    //Nedim

    @FindBy(xpath = "//*[@id=\"in-patient-status\"]")
    public WebElement ngStaffMyPagesEditStatus;


































































































    //Emre
    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPageElementiEG;
    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement SearchPatientButtonEG;
    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement patientSsnSorguBoxEG;
    @FindBy(xpath = "//td[text()='Emr']")
    public WebElement patientEmr;
    @FindBy(xpath = "//tbody/tr[1]/td[16]/div[1]/a[2]/span[1]/span[1]")
    public WebElement editButtonE;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement toastAlert;
    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement saveButtonE;
    @FindBy(xpath = "//textarea[@id='patient-description']")
    public WebElement patientInfoTextBox;

    //RosiMurat
    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement itemTitlelink;

    @FindBy(xpath = "//li[@id='entity-menu']//a[2]")
    public WebElement staffLink;

    @FindBy(id = "jh-create-entity")
    public WebElement createStaff;

    @FindBy(id = "hospitalmsappfrontendApp.staff.home.createOrEditLabel") //span[normalize-space()='Create or edit a Staff']
    public WebElement createOrEditText;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement searchUserButton;

    @FindBy(id = "useSSNSearch")
    public WebElement useSSNSearchButton;

    @FindBy(xpath = "//tbody//tr//td[1]")
    public WebElement firstStaffId;

    @FindBy(xpath = "(//span[text()='Staff'])[2]")
    public WebElement staffText;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement editButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement updateText;

    @FindBy(id = "searchSSN")
    public WebElement sSnButton;

    @FindBy(xpath = "//select[@name='bloodGroup']")
    public WebElement bloodGroupDdElement;

    @FindBy(xpath = "//select[@id='staff-country']")
    public WebElement countryDdElement;

    @FindBy(xpath = "//span[normalize-space()='Confirm delete operation']")
    public WebElement confirmDeleteText;

    @FindBy(xpath = "(//span[text()='Delete'])[21]") //button[@id='jhi-confirm-delete-staff']
    public WebElement enSondeleteButonu;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameButton;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passButton;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement signInButton2;

    @FindBy(xpath = "(//a[@class='btn btn-warning btn-sm'])[1]")
    public WebElement showInvoiceButton;

    @FindBy(id = "entity-menu")
    public WebElement myPagesButton;

    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement searchPatientButton;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement patientsSSNtextBox;

    @FindBy(xpath = "//*[text()='Show Appointments']")
    public WebElement showAppointmentsButton;

    @FindBy(xpath = "(//span[text()='Payment / Invoice Process'])[1]")
    public WebElement paymentInvoiceProcessButton;

    @FindBy(xpath = "//a[@class='btn btn-danger btn-sm']")
    public WebElement createInvoiceButton;

    @FindBy(id = "bill-description")
    public WebElement descriptionText;

    @FindBy(xpath = "//*[text()='Exam Fee:']") //th[normalize-space()='100$']
    public WebElement examFeeText;

    @FindBy(xpath = "//*[text()='50']")
    public WebElement na111FeeText;

    @FindBy(xpath = "//*[text()='12']")
    public WebElement ureaFeeText;

    @FindBy(xpath = "//*[text()='15']")
    public WebElement creatinineFeeText;

    @FindBy(xpath = "(//*[text()='COMPLETED'])[1]")
    public WebElement statusTextCompleted;

    @FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
    public WebElement showInvoicePaymentButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement toastify;

    @FindBy(xpath = "//*[text()='INVOICE']")
    public WebElement ınvoiceText;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneButton;

}