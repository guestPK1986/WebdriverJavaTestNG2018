package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrames2 extends BaseTest {

    @Test
    public void testIFrames2() {

        String url = "http://the-internet.herokuapp.com/tinymce";
        setUpBrowser();
        navigateToUrl(url);

        driver.switchTo().frame("mce_0_ifr");

        WebElement editor = driver.findElement(By.id("tinymce"));

        editor.clear();
        editor.sendKeys("My text");

        String text = "My text";
        Assert.assertEquals(editor.getText(), text);
        driver.close();
    }
}





    /*@Test
    public void NestedFrames2(){

    String url = "http://the-internet.herokuapp.com/nested_frames";
        setUpBrowser();
        navigateToUrl(url);

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        String middleContent = driver.findElement(By.id("content")).getText();

        Assert.assertEquals(middleContent, "MIDDLE");

        System.out.println(middleContent);
    }*/
//}
