package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Admin {

    public Admin() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Fadime
    @FindBy(id = "account-menu")
    public WebElement us027accountMenu;
    @FindBy(id = "login-item")
    public WebElement us027singInButonu;
    @FindBy(xpath = " //input[@name='username']  ")
    public WebElement us027userName;
    @FindBy(xpath = " //input[@id='password']  ")
    public WebElement us027password;
    @FindBy(xpath = " //button[@class='btn btn-primary']  ")
    public WebElement us027singInButonu1;
    @FindBy(xpath = " (//li[@class='dropdown nav-item'])[1]")
    public WebElement us027itemsTitle;
    @FindBy(xpath = " (//a[@href='/c-message'])[1]")
    public WebElement us027messagesButonu;
    @FindBy(xpath = " (//span[text( )='Messages'])[2]")
    public WebElement us027messagesYazisi;
    @FindBy(xpath = " //a[@id='jh-create-entity']")
    public WebElement us027createAnewMessage;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement us027nameCreateAnewMessage;
    @FindBy(xpath = "//input[@id='c-message-email'] ")
    public WebElement us027emailCreateAnewMessage;
    @FindBy(xpath = "//input[@id='c-message-subject']")
    public WebElement us027subjectCreateAnewMessage;
    @FindBy(xpath = "//input[@id='c-message-message']")
    public WebElement us027messageCreateAnewMessage;
    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement us027saveCreateAnewMessage;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement saveButtonOnayYazisi;
    @FindBy(xpath = " (//a[@href='/c-message/43766'])[2]")
    public WebElement us027viewButonu;
    // @FindBy(xpath = " //a[@href='/c-message/43766/edit']")
    // public WebElement   us027editButonu;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement us027editButonu;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement us027nameEditButonu;
    @FindBy(xpath = "//input[@id='c-message-email'] ")
    public WebElement us027emailEditButonu;
    @FindBy(xpath = "//input[@id='c-message-subject'] ")
    public WebElement us027subjectEditButonu;
    @FindBy(xpath = "//input[@id='c-message-message']")
    public WebElement us027messageEditButonu;
    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement us027saveEditButonu;
    // @FindBy(xpath = " //a[@href='/c-message/43768/delete']")
    // public WebElement   us027deleteButonu;
    @FindBy(xpath = " //a[@class='btn btn-danger btn-sm']")
    public WebElement us027deleteButonu;
    @FindBy(xpath = "//button[@id='jhi-confirm-delete-cMessage'] ")
    public WebElement us027messajeDeleteButonu;
    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement us027singOut;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement guncellendiMesaji;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement silindiMesaji;


    //Emre
    @FindBy(xpath = "//span[normalize-space()='Items&Titles']")
    public WebElement itemsAndTitles;
    @FindBy(xpath = "(//a[@href=\"/patient\"])[1]")
    public WebElement patient;
    @FindBy(xpath = "//span[normalize-space()='Create a new Patient']")
    public WebElement createAnewPatient;
    @FindBy(xpath = "//input[@id='patient-firstName']")
    public WebElement newPatientFirstnameTextBox;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement newPatientEmailTextBox;
    @FindBy(xpath = "//select[@id='patient-gender']")
    public WebElement genderDropdownElement;
    @FindBy(xpath = "//select[@name='bloodGroup']")
    public WebElement bloodGroupDropdownElement;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement adminCreateUserSaveButton;
    @FindBy(xpath = "//h2[@id='patient-heading']")
    public WebElement patientCreatedAlert;
    @FindBy(xpath = "//span[normalize-space()='ID']")
    public WebElement patientId;
    @FindBy(xpath = "//span[normalize-space()='Address']")
    public WebElement patientAddress;
    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement internalServerError;
    @FindBy(xpath = "//span[normalize-space()='Administration']")
    public WebElement administration;
    @FindBy(xpath = "//span[text()='User management']")
    public WebElement userManagement;
    @FindBy(xpath = "//a[@href='/admin/user-management/systema/delete']")
    public WebElement patientDelete;
    @FindBy(xpath = "(//button[@type='button'])[24]")
    public WebElement patientDelete2;
    @FindBy(xpath = "//span[normalize-space()='Country']")
    public WebElement country1;
    @FindBy(xpath = "//span[normalize-space()='Create a new Country']")
    public WebElement CreateANewCountry;
    @FindBy(xpath = "//input[@id='country-name']")
    public WebElement countryNameTextBox;
    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement countrySaveButton;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement countrySavedAlert;
    @FindBy(xpath = "//span[normalize-space()='State/City']")
    public WebElement stateCity;
    @FindBy(xpath = "//span[normalize-space()='Create a new State/City']")
    public WebElement createAStateCity;

    //Burak
    @FindBy(xpath = "//*[.='Items&Titles']")
    public WebElement itemsTitlesDropdown;

    @FindBy(xpath = "//*[.='Room']")
    public WebElement roomDropdown;

    @FindBy(xpath = "//*[.='Rooms']")
    public WebElement roomsHeading;

    @FindBy(xpath = "//*[.='Create a new Room']")
    public WebElement createANewRoomButton;

    @FindBy(xpath = "//h2[.='Create or edit a Room']")
    public WebElement createOrEditARoomHeading;

    @FindBy(xpath = "//input[@name='roomNumber']")
    public WebElement roomNumberTextBox;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement priceTextBox;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createdDateTextBox;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//a[.='»»']")
    public WebElement lastPage;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public List<WebElement> invalidFeedbacks;

    @FindBy(xpath = "//input[@name='status']")
    public WebElement statusCheckBox;

    @FindBy(tagName = "select")
    public WebElement roomTypeSelect;

    @FindBy(xpath = "//span/span[.='Edit']")
    public List<WebElement> editElements;

    @FindBy(xpath = "//span/span[.='Delete']")
    public List<WebElement> deleteElements;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionTextBox;

    @FindBy(id = "jhi-confirm-delete-room")
    public WebElement deleteConfirm;

    //Ishak
//Ishak
    @FindBy(id = "account-menu")
    public WebElement ilkGirisButton;

    @FindBy(id = "login-item")
    public WebElement signInButton;

    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy(id = "password")
    public WebElement passBox;
    @FindBy(id = "entity-menu")
    public WebElement testItemButton;

    @FindBy(linkText = "Test Item")
    public WebElement testItemLink;

    @FindBy(id = "jh-create-entity")
    public WebElement createItemButton;

    @FindBy(id = "c-test-item-name")
    public WebElement testCreateNameBox;

    @FindBy(id = "c-test-item-description")
    public WebElement testCreateDescriptionBox;

    @FindBy(id = "c-test-item-price")
    public WebElement testCreatePriceBox;

    @FindBy(id = "c-test-item-defaultValMin")
    public WebElement testCreateMinValueBox;

    @FindBy(id = "c-test-item-defaultValMax")
    public WebElement testCreateMaxValueBox;

    @FindBy(id = "save-entity")
    public WebElement testCreateSaveButton;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[2]")
    public WebElement newTestItem;

    @FindBy(xpath = "//table/thead/tr/th[7]")
    public WebElement createDateButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[8]/div/a[2]")
    public WebElement testEditButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[8]/div/a[3]")
    public WebElement testDeleteIkon;

    @FindBy(id = "jhi-confirm-delete-cTestItem")
    public WebElement deleteButton;

    @FindBy(className = "Toastify__toast-body")
    public WebElement popUp;


    //Seyma
//Seyma
    @FindBy(xpath = "//li[@id='account-menu']")// id ="header-tabs"
    public WebElement soAccountMenu;

    @FindBy(id="login-item")
    public WebElement soSignIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement soUsernameTextbox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement soPasswordTextbox;

    @FindBy(xpath = "(//span[text()='Sign in'])[3]")
    public WebElement soSignInButton;

    @FindBy(xpath ="//span[normalize-space()='Items&Titles']" )
    public WebElement soItemsTitles;

    @FindBy(xpath = "//span[normalize-space()='Physician']")
    public WebElement soPhysician;

    @FindBy(xpath = "//span[text()='Create a new Physician']")
    public WebElement soCreteANewPhysician;

    @FindBy(id = "useSSNSearch")
    public WebElement soUseSearchCheckBox;

    @FindBy(id = "searchSSN")
    public WebElement soSSNSearchTextBox;

    @FindBy(xpath = "//button[text()='Search User']")
    public WebElement soSearchUserButton;

    @FindBy(xpath = "//div[@class='Toastify']")
    public WebElement soAramaToastfyYazisi;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement soSignOutButton;

    @FindBy(xpath = "//input[@id='physician-firstName']")
    public WebElement soFirstnameTextBox;

    @FindBy(xpath = "//input[@id='physician-lastName']")
    public WebElement soLastnameTextBox;

    @FindBy(id = "physician1-birthDate")
    public WebElement soBirthDateTextbox;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement soPhoneTextBox;

    @FindBy(xpath = "//input[@id='physician-adress']")
    public WebElement soAddressTextbox;

    @FindBy(xpath = "//input[@id='physician-description']")
    public WebElement soDescriptionTextbox;

    @FindBy(xpath = "//select[@id='physician-country']")
    public WebElement soCountryDropdown;

    @FindBy(xpath = "//select[@id='physician-cstate']")
    public WebElement soStateDropdown;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement soSaveButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement soUpdateToastify;

    @FindBy(xpath = "//input[@id='file_image']")
    public WebElement sofotoUpload;

    @FindBy(xpath = "//select[@id='physician-speciality']")
    public WebElement soSpecialityDropdown;

    @FindBy(xpath = "//input[@id='physician-examFee']")
    public WebElement soExamFeeTextbox;

    @FindBy(xpath = "//span[text()='Physicians']")
    public WebElement soPhysicianText;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement soEditButton;

    @FindBy(xpath = "//div[text()='Internal server error.']")
    public WebElement soInternaErrorToastify;

    @FindBy(id = "jhi-confirm-delete-physician")
    public WebElement soIkinciDeleteButton;

    @FindBy(xpath = "//select[@id='physician-user']")
    public WebElement soUserBox;

    //Nedim
}