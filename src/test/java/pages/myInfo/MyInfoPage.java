package pages.myInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class MyInfoPage extends CommonMethods {

    @FindBy(id = "menu_pim_viewMyDetails")
    public WebElement myInfoTab;

    @FindBy(xpath = "//a[text()='Dependents']")
    public WebElement dependents;

    public MyInfoPage() {
        PageFactory.initElements(driver, this);
    }

}
