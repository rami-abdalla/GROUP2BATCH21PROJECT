package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployee extends CommonMethods {

  @FindBy(id="firstName")
  public WebElement firstName;

  @FindBy(id="lastName")
  public WebElement lastName;

  @FindBy(id="middleName")
  public WebElement middleName;

  @FindBy(id="btnSave")
  public WebElement btnSave;

  @FindBy(id="employeeId")
  public WebElement employeeId;

  @FindBy(id = "personal_txtEmpFirstName")
   public WebElement ActualNmae;

  @FindBy(id="personal_txtEmployeeId")
  public WebElement existedEmpId;


public AddEmployee(){
    PageFactory.initElements(driver, this);
}
}
