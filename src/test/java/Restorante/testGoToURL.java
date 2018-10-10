package Restorante;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class testGoToURL {
    WebDriver driver;

    @Test
    public void testName() {
        {
            driver= new FirefoxDriver();
            String URL="http://www.google.com";
            driver.navigate().to(URL);
            WebElement element = driver.findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(1)"));
            String strng = element.getText();
            System.out.println(strng);
        }
    }


}
