package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class AddJobDetailsPage extends CommonMethods{

    @FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
    public WebElement pimOption;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListOption;

    @FindBy(xpath = "//a[contains(@href, '/pim/viewJobDetails')]")
    public WebElement JobElement;

    @FindBy(id="empsearch_id")
    public WebElement empSearch;

    @FindBy(id="searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath="//a[text()='78402380']")
    public WebElement employeeID;

    @FindBy(xpath="//input[@id='btnSave']")
    public WebElement EditBtn;

    @FindBy(id="btnSave")
    public WebElement SaveBtn;

     @FindBy(xpath = "//select[@id='job_job_title']")
     public WebElement JobTitleDropdown;


    @FindBy(xpath = "//select[@id='job_emp_status']")
    public WebElement employmentStatusDropdown;


    //@FindBy(xpath = ""
    public WebElement ErrorMsg;

    @FindBy(xpath = "//div[contains(@class, 'message success fadable')]")
    public WebElement SuccessMsg;


    @FindBy(xpath = "//select[@id='job_sub_unit']")
    public WebElement subUnitDropdown;


    @FindBy(xpath = "//select[@id='job_location']")
    public WebElement locationDropdown;


    @FindBy(xpath = "//input[@id='job_contract_file']")
    public WebElement ContractDetailsDropdown;






    public AddJobDetailsPage(){

        PageFactory.initElements(driver,this);


    }
}
