package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

public class NestedFrames {
    String url = "http://the-internet.herokuapp.com/nested_frames";
    WebDriver driver;


    private void setUpBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resouces/geckodriver");

    }
    private void navigateToURL(String url) {
        driver = new FirefoxDriver();
        driver.navigate().to(url);
    }

    @Test
    public void testNestedFrames() {
        //int size = By.name("frame-top").findElements(driver).size();
       //System.out.println("Total Frames --" + size);

        driver.findElement(By.xpath("/html/frameset/frame[1]")).getText();

        //driver.switchTo().frame("frame-top");
       //driver.switchTo().frame("<frame src=\"/frame_middle\" scrolling=\"no\" name=\"frame-middle\">");

        //String middleContent = driver.findElement(By.id("content")).getText();

        //Assert.assertEquals(middleContent, "MIDDLE");

    }
}
