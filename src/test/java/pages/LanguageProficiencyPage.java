package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;

import java.time.Duration;

public class LanguageProficiencyPage extends CommonMethods {


    @FindBy(id = "menu_pim_viewMyDetails")
    public WebElement MyInfoLink;

    // Locating "Qualifications" link
    @FindBy(css = "#sidenav > li:nth-child(10) > a")
    public WebElement qualificationsLink;

    @FindBy(id = "addLanguage")
    public WebElement addLanguageButton;

    @FindBy(id = "frmLanguage")
    public WebElement languageInputField;

    // Locators for the language proficiency section
    @FindBy(id = "language_code")
    public WebElement languageDropdown;

    @FindBy(xpath= "//select[@id='language_code']/option[text()='German']")
    public WebElement German;

    @FindBy(xpath= "//select[@id='language_code']/option[text()='French']")
    public WebElement French;

    @FindBy(xpath= "//select[@id='language_lang_type']/option[text()='Writing']")
    public WebElement Writing;

    @FindBy(xpath= "//select[@id='language_lang_type']/option[text()='Speaking']")
    public WebElement Speaking;


    @FindBy(xpath= "//select[@id='language_competency']/option[text()='Good']")
    public WebElement Good;

    @FindBy(xpath= "//select[@id='language_competency']/option[text()='Basic']")
    public WebElement Basic;





    @FindBy(id = "language_lang_type")
    public WebElement fluencyDropdown;

    @FindBy(id = "language_competency")
    public WebElement competencyDropdown;

    @FindBy(id="language_comments")
    public WebElement commentsTextbox;

    @FindBy(id = "btnLanguageSave")
    public WebElement saveButton;


    @FindBy(xpath = "//input[@type='button' and @value='Delete' and @class='delete' and @id='delLanguage']")
    public WebElement deleteButton;


    @FindBy(xpath = "//input[@class='chkbox' and @value='2283_1']")
    public WebElement languageCheckbox;


    @FindBy(xpath="//div[@class='message success fadable']")
    public WebElement successMessage;



    @FindBy(id = "language_proficiency_section")
    public WebElement languageProficiencySection;

    @FindBy(xpath = "//a[@class='edit' and text()='German']")
    public WebElement visibleGerman;




    // Initialize elements
    public LanguageProficiencyPage() {
        PageFactory.initElements(driver, this);
    }

    // Method to check if the language proficiency details are visible for a given language
    public boolean areDetailsVisible(String language) {
        try {
            // Dynamically building the ID based on the provided language
            WebElement languageElement = driver.findElement(By.id("language_" + language));
            return languageElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to check if the details are saved successfully
    public boolean areDetailsSaved() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }








    // Method to select language for editing
    public void selectLanguageForEdit(String language) {
        WebElement editButton = driver.findElement(By.id("edit_" + language));
        click(editButton);
    }

    // Method to select language for deletion
    public void selectLanguageForDelete(String language) {
        WebElement deleteButton = driver.findElement(By.id("delete_" + language));
        click(deleteButton);
    }

    // Method to check if the language proficiency details are updated
    public boolean isDetailsUpdated() {
        try {
            WebElement updatedLanguageElement = driver.findElement(By.id("updated_language"));
            return updatedLanguageElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to check if the details for a specific language are deleted
    public boolean isDetailsDeleted() {
        try {
            WebElement deletedLanguageElement = driver.findElement(By.id("deleted_language"));
            return !deletedLanguageElement.isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }
}
