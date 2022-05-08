package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class Registration {
    public Registration() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    public WebElement ngfirstName;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement nghatamesajı;

    @FindBy(xpath = "//*[@id=\"account-menu\"]/a")
    public WebElement ngregister;

    @FindBy(xpath = "//*[@id=\"account-menu\"]/div/a[2]/span")
    public WebElement nglistElementi;
    
     @FindBy(xpath = "//*[@id=\"account-menu\"]/div/a[1]/span")
    public WebElement nglistElementiSing;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement ngusername;

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement ngemail;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[5]/div")
    public WebElement ngemailhatamesaji;

    @FindBy(xpath = "//*[@id=\"ssn\"]")
    public WebElement ngSSN;

    @FindBy(xpath = "//*[@id=\"ssn\"]")
    public WebElement nglastname;
    
     @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement ngadminusername;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement ngadminpassword;
    @FindBy(xpath = "//*[@id=\"login-page\"]/div/form/div[3]/button[2]/span")
    public WebElement ngadminsingin;

    @FindBy(xpath = "//*[@id=\"admin-menu\"]/a")
    public WebElement ngadminmenu;

    @FindBy(xpath = "//*[@id=\"admin-menu\"]/div/a/span")
    public WebElement ngadminmenuuser;

    @FindBy(xpath = "//*[@id=\"systema\"]/td[11]/div/a[1]/span/span")
    public WebElement ngview;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/dl")
    public WebElement ngviewbilgiler;

    @FindBy(xpath = "//*[@id=\"systema\"]/td[11]/div/a[2]")
    public WebElement ngviewEdit;

    @FindBy(xpath = "//*[@id=\"authorities\"]/option[2]")
    public WebElement ngRoleUser;

    @FindBy(xpath = "//*[@id=\"systema\"]/td[11]/div/a[3]")
    public WebElement ngDelete;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]/a/span")
    public WebElement ngStaffMenu;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]/div/a[2]/span")
    public WebElement ngStaffListElement2;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]/div/a[4]/span")
    public WebElement ngStaffListElement4;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[15]/div/a[2]")
    public WebElement ngStaffEdit;

    @FindBy(xpath = "//input[@name='adress']")
    public WebElement ngStaffAdres;

    @FindBy(xpath = "//*[@id=\"save-entity\"]/span")
    public WebElement ngStaffSave;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[5]/td[13]/div/a[2]")
    public WebElement ngStaffHastaStatus;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]/a/span")
    public WebElement ngStaffMyPages;
    @FindBy(xpath = "//*[@id=\"entity-menu\"]/div/a[2]/span")
    public WebElement ngStaffMyPagesInPatiens;
    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/table/tbody/tr[1]/td[10]/div/a")
    public WebElement ngStaffMyPagesEdit;
    @FindBy(xpath = "//input[@name='description']")
    public WebElement ngStaffMyPagesEditDescription;

    //=Murat Emin Bey
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement dropDownElementi;
    @FindBy(xpath = "//span[text()='Register']")
    public WebElement dropDownRegisterButton;
    @FindBy(xpath = "//input[@name='firstPassword']")
    public WebElement passwordTextBox;
    @FindBy(xpath = "//ul[@id='strengthBar']//li[1]")
    public WebElement defaultStrengthBarColor;
    @FindBy(xpath = "//ul[@id='strengthBar']//li[2]")
    public WebElement secondStrengthBarColor;
    @FindBy(xpath = "//ul[@id='strengthBar']//li[3]")
    public WebElement thirdStrengthBarColor;
    @FindBy(xpath = "//ul[@id='strengthBar']//li[4]")
    public WebElement fourthStrengthBarColor;
    @FindBy(xpath = "//ul[@id='strengthBar']//li[5]")
    public WebElement fifthStrengthBarColor;
    //MuratEmin Contact
    @FindBy(xpath = "//li[@class='nav-item'][6]")
    public WebElement mainPageContactButton;
    @FindBy(xpath = "//section[@id='contact']")
    public WebElement contactPageBasariliGirisSonucContactYazisi;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement contactPageNameTextBox;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement contactPageEmailTextBox;
    @FindBy(xpath = "//input[@name='subject']")
    public WebElement contactPageSubjectTextBox;
    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement contactPageMessageTextBox;
    @FindBy(xpath = "//button[@id='register-submit']")
    public WebElement contactPageSubmitButton;
    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement contactPageBasariliMesajBildirim;


}



