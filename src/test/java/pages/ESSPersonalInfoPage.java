package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class ESSPersonalInfoPage extends CommonMethods {

    @FindBy(xpath = "//a[@id=\"welcome\"]")
    public WebElement welcomeMSG;

    @FindBy(xpath = "//input[@id=\"personal_txtEmployeeId\"]")
    public WebElement employeeID;

    @FindBy(id = "menu_pim_viewMyDetails")
    public WebElement MyInfoLink;

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement PersonalFirstName;

    @FindBy(id = "personal_txtEmpMiddleName")
    public WebElement PersonalMiddleName;


    @FindBy(id = "personal_txtEmpLastName")
    public WebElement PersonalLastName;

    @FindBy(xpath = "//label[@for=\"personal_optGender\"]")
    public WebElement genderOpt;

    @FindBy(xpath = "//label[text()='Male']")
    public WebElement MaleRB;

    @FindBy(id = "personal_optGender_1")
    public WebElement MaleRBID;

    @FindBy(xpath = "//label[@for='personal_optGender_1' and text()='Male']/following-sibling::input[@value='2']")
    public WebElement FemaleRB;

    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    public WebElement nationalityDD;

    @FindBy(xpath = "//label[@for=\"personal_cmbMarital\"]")
    public WebElement maritalStatus;

    @FindBy(xpath = "//select[@id=\"personal_cmbMarital\"]")
    public WebElement maritalStatusDD;

    @FindBy(xpath = "//input[@type=\"button\" and @id=\"btnSave\"]")
    public WebElement saveBTN;

    @FindBy(xpath = "//input[@type=\"button\" and @value=\"Edit\"]")
    public WebElement editBTN;

    @FindBy(xpath = "//span[@class=\"validation-error\"]")
    public WebElement validationErr;

    @FindBy(xpath = "//script[@type=\"text/javascript\" and @src=\"/humanresources/symfony/web/webres_5acde3dbd3adc6.90334155/orangehrmPimPlugin/js/viewPersonalDetailsSuccess.js\"]")
    public WebElement sucessMsg;

    public ESSPersonalInfoPage(){
        PageFactory.initElements(driver,this);
    }
}
