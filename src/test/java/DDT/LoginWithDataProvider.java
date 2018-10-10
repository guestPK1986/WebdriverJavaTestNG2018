package DDT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginWithDataProvider{

    @Test(dataProvider = "LoginData")
    public void LoginWithData(String ID, String email,String password) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://52.9.182.211:3001/v1/log-in");
        driver.findElement(By.name("restaurant_id")).sendKeys(ID);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div/div/form/div/div[4]/button")).click();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
    }

    @DataProvider(name = "LoginData")
    public Object[][] passData() {
        return new Object[][] {"Rest_003", "Rest_003@gmail.com", "12345678"};


    }
}