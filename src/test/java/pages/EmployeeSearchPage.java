package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.CommonMethods.driver;

public class EmployeeSearchPage {
    @FindBy(id="empsearch_id")
    public WebElement empIDSearchField;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement empNameSearchField;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    public EmployeeSearchPage(){
        PageFactory.initElements(driver,this);
    }

}
