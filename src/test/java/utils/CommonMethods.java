package utils;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class CommonMethods extends PageInitializer{

    public static WebDriver driver;
    protected WebElement languageLink;
    protected WebElement addLanguageButton;
    protected WebElement languageInputField;
    protected WebElement proficiencyInputField;
    protected WebElement saveButton;
    protected WebElement languageProficiencySection;

    public static WebDriver openBrowserAndLaunchApplication() throws IOException{

        switch (ConfigReader.read("browser")){
            case "Chrome":

                driver =new ChromeDriver();
                break;


            case "FireFox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Invalid Browser Name");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(ConfigReader.read("url"));
        initializePageObjects();
        return null;
    }

    public static void closeBrowser(){

        if (driver!=null){
            driver.quit();
        }
    }

    public static void sendText(String text, WebElement element){

        element.clear();

        element.sendKeys(text);
    }
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait;
    }


    public static void waitForElementToBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable (WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    public  static byte[] takeScreenshot(String fileName){

        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,new File(Constants.SCREENSHOT_FILEPATH +fileName+"" +getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern){

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(date);

    }

    public static void login(String username, String password) {
        waitForElementToBeClickable(loginPage.usernameField);
        sendText(ConfigReader.read(username), loginPage.usernameField);
        sendText(ConfigReader.read(password), loginPage.passwordField);
        click(loginPage.loginButton);
        Assert.assertTrue(dashboardPage.messageText.isDisplayed());
    }

    public static String getText(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }

    public static void selectFromDropDown(String value, WebElement dropDown) {
        var select = new Select(dropDown);
        select.selectByValue(value);
    }

    // This method retrieves data from a table on a web page and returns it as a list of maps.
    public static List<Map<String, String>> getTable(String tableIdValue) {
        // Create an empty list to store the table data as maps of column name -> value.
        List<Map<String, String>> tableList = new ArrayList<>();

        // Create an XPath to locate the table based on its ID.
        var table = "//table[@id='" + tableIdValue + "']";

        // Define the XPath for the header cells (th) of the table.
        var headers = table + "/thead/tr/th";

        // Define the XPath for the table's first column's cells (td).
        var rows = table + "/tbody/tr/td[1]";

        // Find the number of rows in the table by counting the number of cells in the first column.
        var rowSize = driver.findElements(By.xpath(rows)).size();

        // Loop through each row to extract data.
        for (int i = 1; i <= rowSize; i++) {
            // Create an XPath for the current row's cells (td).
            var rowXpath = table + "/tbody/tr[" + i + "]/td";
            // Create a map to store the data for the current row.
            Map<String, String> record = new LinkedHashMap<>();
            // Find the number of header cells (th) in the table.
            var headersSize = driver.findElements(By.xpath(headers)).size();
            // Loop through each header cell and match it with the corresponding cell in the row.
            for (int j = 1; j <= headersSize; j++) {
                // Get the text of the current header cell (th).
                var header = driver.findElement(By.xpath(headers + "[" + j + "]")).getText().trim();
                // Get the text of the corresponding row cell (td).
                var row = driver.findElement(By.xpath(rowXpath + "[" + j + "]")).getText().trim();
                // If the header is empty, assign a default header and set the first column's value.
                if (header.isEmpty()) {
                    header = "Check Box" + i;  // Default header name if it's empty.
                    row = rowXpath + "[1]";  // The row cell corresponds to the first cell in the row.
                }
                // Put the header and row value into the record map (header -> row value).
                record.put(header, row);
            }
            // Add the current row's map (record) to the list.
            tableList.add(record);
        }
        // Return the list of records (the table data).
        return tableList;


    }

    public void readPdfFromFile(File file) {
        try {

            System.out.println("Reading content from PDF file: " + file.getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error reading the PDF: " + e.getMessage());
        }
    }

    public File getImageFile(String directory, String format) {
        // Try to find an image file with the given format in the specified directory
        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            // List all files in the directory
            File[] files = dir.listFiles((d, name) -> name.toLowerCase().endsWith(format.toLowerCase()));
            if (files != null && files.length > 0) {
                // Return the first matching image file
                return files[0];
            }
        }
        return null;
    }

    public static void verifyInputValue(WebElement element, String expectedValue) {

        String actualValue = element.getAttribute("value");
        Assert.assertEquals(actualValue, expectedValue);
    }

    public static void selectDropdownByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectDropdownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public String getCheckBoxXpathByName(List<Map<String, String>> tableList, String name) {
        // Iterate through each map in the table list
        for (Map<String, String> row : tableList) {
            // Check if the row contains the specified name
            if (row.get("Name").equals(name)) {
                // Iterate through the keys of the map to find the checkbox key (which starts with "CheckBox")
                for (String key : row.keySet()) {
                    // If the key contains "CheckBox", return its corresponding value
                    if (key.contains("Check Box")) {
                        return row.get(key);
                    }
                }
            }
        }
        // Return null if no matching name was found
        return null;
    }

    public static boolean checkIfRecordExistsInTheTable(String tableId, String nameKey, String valueToFind) {
        // Fetch the table data
        List<Map<String, String>> tableData = getTable(tableId);

        // Loop through each row in the table data.
        for (Map<String, String> row : tableData) {
            // Check if the row contains the specified nameKey and its corresponding value.
            if (row.containsKey(nameKey) && row.get(nameKey).equals(valueToFind)) {
                return true;  // Name found, return true.
            }
        }
        // Return false if the name is not found in the table.
        return false;
    }

    public static void selectCheckBox(String checkBoxXpath) {
        waitForElementToBeVisible(driver.findElement(By.xpath(checkBoxXpath)));
        click(driver.findElement(By.xpath(checkBoxXpath)));
    }

    public static void uploadFile(WebElement element, String filePath) {
        element.sendKeys(filePath);
    }



}
