package Restorante;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static day2.Day2Browser.sleepFor;

public class RestoranteAuthorization {

    WebDriver driver;
    String url = "http://52.9.182.211:3001/v1/log-in";
    String textToBeChecked = "Log In";
    String RestaurantId = "User_003";
    String Email = "User_003@gmail.com";
    String Password = "12345678";
    //String AdminPage = "http://52.9.182.211:3001/v1/admin/menu";


    @Test
    public void loginToRestorante() {
        setUpBrowser();
        navigateToURL(url);
        assertLogInPage(textToBeChecked);
        printText();//"Log In" text on page
        inputRestaurantId(RestaurantId);
        inputEmail(Email);
        inputPassword(Password);
        submit();
        verifyAdminPage();
        switchToAccountsTab();
        logOut_and_Close();

    }

    private void logOut_and_Close() {
        driver.findElement(By.cssSelector(".MuiButtonBase-root-83")).click();
        sleepFor(2);
        System.out.println("Passed");
        driver.close();

    }

    private void switchToAccountsTab() {
        driver.findElement(By.linkText("Accounts")).click();
    }

    private void verifyAdminPage() {
        WebElement element = driver.findElement(By.cssSelector(".MuiPaper-elevation2-13 > h2:nth-child(1)"));
        System.out.println(element.getText());
    }

    private void submit() {
        driver.findElement(By.cssSelector(".MuiButton-root-127")).click();
        sleepFor(2);
        boolean isTextPresented1 = driver.getPageSource().contains("Admin Portal");
        Assert.assertTrue(isTextPresented1);
    }

    private void inputPassword(String Password) {
        driver.findElement(By.xpath("/html/body/div/div/form/div/div[3]/div/input")).sendKeys(Password);
    }

    private void inputEmail(String Email) {
        driver.findElement(By.cssSelector("div.MuiFormControl-root-96:nth-child(3) > div:nth-child(2) > input:nth-child(1)")).sendKeys(Email);
    }

    private void inputRestaurantId(String RestaurantId) {
        driver.findElement(By.cssSelector("div.MuiFormControl-root-96:nth-child(2) > div:nth-child(2) > input:nth-child(1)")).sendKeys(RestaurantId);
    }

    private void printText() {
        WebElement element = driver.findElement(By.cssSelector(".MuiPaper-elevation2-13 > h1:nth-child(1)"));
        String a = element.getText();
        System.out.println(a);
    }

    private void assertLogInPage(String textToBeChecked) {
        String ParentWindow = driver.getWindowHandle();
        for (String NewWindow : driver.getWindowHandles()) {
            driver.switchTo().window(NewWindow);
        }
        boolean isTextPresented = driver.getPageSource().contains(textToBeChecked);
        Assert.assertTrue(isTextPresented);

    }
    private void setUpBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resouces/geckodriver");

    }
    private void navigateToURL(String url) {
        driver = new FirefoxDriver();
        driver.navigate().to(url);
    }

}

