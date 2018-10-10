package day2;

import Day4.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static day2.Day2Browser.sleepFor;

public class testWindows extends BaseTest {

    @Test
    public void testWindows() {
            setUpBrowser();
            String url = "http://the-internet.herokuapp.com/windows";
            By link = By.linkText("Click Here");
            String textToBeChecked = "New Window";
            navigateToUrl(url);
            clickOnLink(link);
            sleepFor(3);
            assertTextPresented(textToBeChecked);
            printOutAllTitles();
            closeLastWindowOpened();
        }
}

