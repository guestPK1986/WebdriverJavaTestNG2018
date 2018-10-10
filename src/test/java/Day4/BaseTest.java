package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

public class BaseTest {

    public static WebDriver driver;
    //WebDriver driver;

    public void setUpBrowser() {
        //setProperty("webdriver.gecko.driver", getProperty("user.dir") + "/src/test/resouces/geckodriver");
        setProperty("webdriver.chrome.driver", getProperty("user.dir") + "/src/test/resouces/chromedriver");
        driver = new ChromeDriver(); }

    public void navigateToUrl(String url){
        //driver.get(url);
        driver.navigate().to(url);
    }

    public void waitFor(By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement myDynamicElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void sendKeysTo(By element, String keysToSend){
        driver.findElement(element).sendKeys(keysToSend);
    }

    public void clickOnLink (By element){
        driver.findElement(element).click();
    }

    public void switchOverToLatestWindow (String originalHandle) {
        for (String each : driver.getWindowHandles()) {

            if (!each.contains(originalHandle)) {
                driver.switchTo().window(each);
            }
        }
    }

    public void printOutAllTitles () {
         for (String currentWindowHandle : driver.getWindowHandles()) {
                    driver.switchTo().window(currentWindowHandle);
                    String windowTitle = driver.getTitle();
                    System.out.println(windowTitle);
                }
    }
    public void assertTextPresented (String textToBeChecked){
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        boolean isTextPresented = driver.getPageSource().contains(textToBeChecked);
        Assert.assertTrue(isTextPresented);
    }

    public void closeLastWindowOpened () {
                driver.quit();
            }
}
