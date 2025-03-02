package pages.myInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeDependentsPage extends CommonMethods {

    @FindBy(id = "btnAddDependent")
    public WebElement addDependentButton;

    @FindBy(id = "btnSaveDependent")
    public WebElement addSaveButton;

    @FindBy(xpath = "//input[@id='dependent_name']")
    public WebElement dependentNameInputField;

    @FindBy(xpath = "//select[@id='dependent_relationshipType']")
    public WebElement dependentRelationshipDropdown;

    @FindBy(xpath = "//input[@id='dependent_dateOfBirth']")
    public WebElement dependentDateOfBirthInputField;

    @FindBy(xpath = "//span[text()='Required']")
    public WebElement errorMessageRequiredField;

    @FindBy(xpath = "//input[@id='delDependentBtn']")
    public WebElement deleteField;

    public String dependentTableIdValue="dependent_list";

    public EmployeeDependentsPage() {
        PageFactory.initElements(driver, this);
    }

}
