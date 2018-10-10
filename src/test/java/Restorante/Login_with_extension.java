package Restorante;

import Day4.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Login_with_extension extends BaseTest{

    @Test
    public void testLogin() throws InterruptedException {
        String restID = "Rest_005";
        String password = "12345678";
        String email = "Rest_005@gmail.com";
        String url = "http://52.9.182.211:3001/v1/log-in";

        setUpBrowser();
        deleteAllCookies();
        navigateToUrl (url);
        waitFor(LoginPage.submitButton);
        enterCredentials(restID, password, email);
        clickSubmit();
        driver.navigate().refresh();
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        Assert.assertTrue(isVisible(LoginPage.LogOutButton));
        waitFor(LoginPage.LogOutButton);
        driver.close();

    }
    public void deleteAllCookies() {
    }

    public boolean isVisible(By element) {
        return driver.findElement(element).isDisplayed();
    }

    private void clickSubmit() {
        driver.findElement(LoginPage.submitButton).click();
    }

    public void enterCredentials(String restID, String password, String email){
        //By element = LoginPage.restID;
        //By element1 = LoginPage.password;
        //By element2 = LoginPage.email;

        sendKeysTo(LoginPage.restID, restID);
        sendKeysTo(LoginPage.password, password);
        sendKeysTo(LoginPage.email, email);
    }

}

