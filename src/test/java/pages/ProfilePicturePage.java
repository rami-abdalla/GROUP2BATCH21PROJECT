package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import static utils.CommonMethods.driver;

public class ProfilePicturePage extends CommonMethods {



    @FindBy(id = "menu_pim_viewMyDetails")
    public WebElement MyInfoLink;

    @FindBy(id = "empPic")
    public WebElement empPhoto;

    @FindBy(id = "photofile")
    public WebElement chooseFile;

    @FindBy(xpath = "//input[@value='Upload']")
    public WebElement upload;

    @FindBy(id = "txtUsername")
    public WebElement EssUserName;

    @FindBy(id="txtPassword")
    public WebElement EssPassword;

    @FindBy(id="btnLogin")
    public WebElement EssLoginButton;

    @FindBy(xpath = "//div[@class='message success fadable']")
    public WebElement successMessage;

    @FindBy(xpath = "//div[@class='message warning fadable']")
    public WebElement unSupportedFileTypeWarning;

    @FindBy(xpath = "//div[@class='message warning fadable']")
    public WebElement sizeExceededWarning;

    @FindBy(xpath = "//div[@class='message success fadable']")
    public WebElement incorrectDimensions;

    @FindBy(xpath = "//img[@alt='Employee Photo']")
    public WebElement displayPicture;


    public ProfilePicturePage(){
        PageFactory.initElements(driver,this);
    }







}
