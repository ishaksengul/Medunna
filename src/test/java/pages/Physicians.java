package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Physicians {

        // Fadime Hanim
  public Physicians() {

    PageFactory.initElements(Driver.getDriver(),this);

  }

  @FindBy(id="account-menu")
  public WebElement insanFiguru;

  @FindBy(id="login-item")
  public WebElement singInButonu ;

  @FindBy(xpath = " //input[@name='username']  ")
  public WebElement drUserName ;

    @FindBy(xpath = " //input[@id='password']  ")
    public WebElement drPassword ;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement singInButonu1 ;


  @FindBy(xpath = "//li[@id='entity-menu']")
  public WebElement drMyPage ;

    @FindBy(xpath = " //a[@class='dropdown-item']  ")
    public WebElement drMyAppointment ;

  @FindBy(xpath = " //a[@class='btn btn-primary btn-sm'] ")
  public WebElement drEdit ;


  @FindBy(xpath = " //a[@class='btn btn-success btn-sm'] ")
  public WebElement drRequestATest ;

  @FindBy(xpath = " //h2[@id='c-test-item-heading'] ")
  public WebElement drTestItemYazisi ;

  @FindBy(xpath = "//li[@id='account-menu']")
  public WebElement draccountMenu;

  @FindBy(xpath = " //input[@id='1401'] ")
    public WebElement drGlucose ;

  @FindBy (id="1401")
  public WebElement glucoseBox;


  @FindBy(xpath = "  //input[@id='1402']")
  public WebElement drUrea ;

  @FindBy(xpath = "   //input[@id='1403']")
  public WebElement drCreatine ;

  @FindBy(xpath = "  //input[@id='1404']")
  public WebElement drSodium ;

  @FindBy(xpath = "  //input[@id='1405']")
  public WebElement drPotassium ;

  @FindBy(xpath = "  //input[@id='1406']")
  public WebElement drTotalProtein ;

  @FindBy(xpath = "  //input[@id='1407']")
  public WebElement drAlbumin;

  @FindBy(xpath = "  //input[@id='1408']")
  public WebElement drHemoglobin;

  @FindBy(xpath = "  //button[@type='submit']")
  public WebElement drSaveButonu;

  @FindBy(xpath = "  //li[@id='account-menu'] ")
  public WebElement drinsanFiguru1;

  @FindBy(xpath = "//span[text()='Sign out']")
  public WebElement drSignOut;

  @FindBy(id = "app-view-container")
  public WebElement drFineText;


  public  void scrollToWebelementVisible(WebElement webElement){
    JavascriptExecutor jss= (JavascriptExecutor) Driver.getDriver();
    jss.executeScript("arguments[0].scrollIntoView(true);",webElement);
  }
//us013
  @FindBy(xpath = "//span[text()='Search Patient']")
  public WebElement us013searchPatient;

  @FindBy(xpath = " //input[@class='form-control']")
  public WebElement us013PsssKutusu ;

  @FindBy(xpath = " //a[@class='btn btn-warning btn-sm']")
  public WebElement us013showAppointments ;

  @FindBy(xpath = "//a[@href='/tests/appointment/64813']")
  public WebElement us013ShowTests ;

  @FindBy(xpath = "//a[@href='/testresult/test/62995']")
  public WebElement us013ViewResults ;

  @FindBy(xpath = "//a[@href='/c-test-result-update/64954']")
  public WebElement us013edit1;

  @FindBy(xpath = "//a[@href='/c-test-result-update/64957']")
  public WebElement us013edit2;

  @FindBy(xpath = "//a[@href='/c-test-result-update/64958']")
  public WebElement us013edit3;

  @FindBy(xpath = "//a[@href='/c-test-result-update/64954']")
  public WebElement us013edit4;

  @FindBy(xpath = "//a[@href='/c-test-result-update/64956']")
  public WebElement us013edit5;

  @FindBy(xpath = "//button[@type='submit']")
  public WebElement us013Save ;

  @FindBy(xpath = "//a[text()='Show Test Results']")
  public WebElement us013showTestResults;

  @FindBy(xpath = "//span[text()='Test Results']")
  public WebElement us013verifyTestResults;

  @FindBy(xpath = "//button[text()='Request Inpatient']")
  public WebElement us013requestInpatient;

























































































  //

}
