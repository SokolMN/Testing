import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {
    WebDriver driver;
    LoginPageTest(WebDriver driver){
        this.driver = driver;
    }


    public WebDriver login(String loginName, String loginPass){
        driver.findElement(By.id("s_swepi_1")).sendKeys(loginName);
        driver.findElement(By.id("s_swepi_2")).sendKeys(loginPass);
        driver.findElement(By.id("s_swepi_22")).submit();
        return (driver);
    }
}
