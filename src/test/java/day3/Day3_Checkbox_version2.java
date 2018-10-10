package day3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

import static day2.Day2Browser.sleepFor;

public class Day3_Checkbox_version2 {
    WebDriver driver;

    @BeforeTest
    private void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resouces/geckodriver");
        driver = new FirefoxDriver();
    }
    @Test
    public void testWindows() {
        String url = "http://the-internet.herokuapp.com/windows";
        By link = By.linkText("Click Here");
        String textToBeChecked = "New Window";
        setupBrowser();
        navigateToURL(url);
        clickOnLink(link);
        sleepFor(3);
        assertTextPresented(textToBeChecked);
        printOutAllTitles();
        closeLastWindowOpened();
    }
    private void navigateToURL(String url) { driver.get(url); }

    private void clickOnLink(By element) { driver.findElement(element).click(); }

    private void printOutAllTitles() {
        for(String eachWindowHandle : driver.getWindowHandles()){
            String currentWindowHandle = eachWindowHandle;
            driver.switchTo().window(currentWindowHandle);
            String windowTitle = driver.getTitle();
            System.out.println(windowTitle);
        }
    }
    private void assertTextPresented(String textToBeChecked) {
        Set<String> allWindows = driver.getWindowHandles();
        for(String curWindow : allWindows){
            driver.switchTo().window(curWindow);
        }
        boolean isTextPresented = driver.getPageSource().contains(textToBeChecked);
        Assert.assertTrue(isTextPresented);
    }
    @AfterTest
    private void closeLastWindowOpened() { driver.quit(); }
}