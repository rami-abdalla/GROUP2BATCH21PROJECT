package pages;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class LogInDetailsforEmployeePage extends CommonMethods {

        

        // Login Elements
        @FindBy(id = "txtUsername")
        public WebElement usernameField;

        @FindBy(id = "txtPassword")
        public WebElement passwordField;

        @FindBy(id = "btnLogin")
        public WebElement loginButton;

        @FindBy(id = "welcome")
        public WebElement welcome;

        // PIM Navigation
        //@FindBy(id = "menu_pim_viewPimModule")
        //public WebElement pimTab;

        //@FindBy(id = "menu_pim_addEmployee")
        //public WebElement addEmployee;

        // Add Employee Form
        @FindBy(id = "firstName")
        public WebElement firstName;

        @FindBy(id = "middleName")
        public WebElement middleName;

        @FindBy(id = "lastName")
        public WebElement lastName;

        @FindBy(id = "chkLogin")
        public WebElement loginCheckbox;

        @FindBy(id = "user_name")
        public WebElement employeeUsername;

        @FindBy(id = "user_password")
        public WebElement employeePassword;

        @FindBy(id = "re_password")
        public WebElement confirmPassword;

        @FindBy(xpath = "//*[@id='status']")
        public WebElement statusDropdown;

        @FindBy(xpath = "//select[@id='status']/option[text()='Enabled']")
        public WebElement Enabled;

        @FindBy(id = "btnSave")
        public WebElement saveButton;

       public LogInDetailsforEmployeePage (){
               PageFactory.initElements(driver,this);}
    }


