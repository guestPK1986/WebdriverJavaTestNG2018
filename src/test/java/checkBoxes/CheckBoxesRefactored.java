package checkBoxes;

import Day4.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import static day2.Day2Browser.sleepFor;
import static java.lang.System.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CheckBoxesRefactored {
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/checkboxes";
    WebElement checkBox1;
    WebElement checkBox2;
    String link = "elementalselenium.com";
    WebElement element;

    @Test
    public void TestCheckBoxes(){
        setUpBrowser();
        navigateToUrl(url);
        sleepFor(2);
        assertImage();
        findCheckbox1();
        clickCheckbox1();
        assertNotNull();
        findCheckbox2();
        assertTrue();
        assertLinkPresent(link);
        WebElement element = waitForElementVisible();
        sleepFor(1);
        //assertElement();
        quitBrowser();
    }
    private void assertImage() {
        WebElement imageStatus = driver.findElement(By.cssSelector("div.row:nth-child(2) > a:nth-child(1) > img:nth-child(1)"));
        System.out.println(imageStatus);
        String imageTitle = driver.findElement(By.cssSelector("div.row:nth-child(2) > a:nth-child(1) > img:nth-child(1)")).getAttribute("title");
        System.out.println(imageTitle);
    }

    public WebElement waitForElementVisible() {
        try{
            WebDriverWait wait = new WebDriverWait(driver,1);
            element = wait.until(visibilityOfElementLocated(By.cssSelector("div.row:nth-child(2) > a:nth-child(1) > img:nth-child(1)")));
            return element;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void assertLinkPresent(String link) {
        Assert.assertTrue(link.matches(link));
        System.out.println(link);
    }
    private void findCheckbox2() {
        checkBox2 = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(3)")); }

    private void assertTrue() {
        Assert.assertTrue(checkBox2.isSelected());
        System.out.println(); }

    private void quitBrowser() {
        driver.quit(); }

    private void assertNotNull() {
        String attributeValue = checkBox1.getAttribute("checked");
        Assert.assertNotNull(attributeValue);
        System.out.println(attributeValue); }

    private void clickCheckbox1() {
        checkBox1.click(); }

    private void findCheckbox1() {
        checkBox1 = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(1)")); }

    private void setUpBrowser() {
        setProperty("webdriver.gecko.driver", getProperty("user.dir") + "/src/test/resouces/geckodriver");
        driver = new FirefoxDriver(); }

    private void navigateToUrl(String url) {
        driver.get(url); }



}
