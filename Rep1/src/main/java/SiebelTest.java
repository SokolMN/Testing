import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SiebelTest {
    WebDriver driver;


    @BeforeClass
    public void getStartPage(){
        System.setProperty("webdriver.chrome.driver", "C:\\Repository\\Rep1\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://192.168.15.201/express_oui";
        driver.get(baseURL);
    }

    @Test
    public void login(){
        LoginPage logpage = new LoginPage(driver);
        logpage.login("MSOKOLOV", "MSOKOLOV");
    }

    @AfterClass
    public void CloseDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
