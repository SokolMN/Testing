import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

public class SiebelTestingAction {
    WebDriver driver;



    @BeforeClass
    public void getStartPage(){
        System.setProperty("webdriver.chrome.driver", "C:\\Repository\\Rep1\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://192.168.15.201/express_oui";
        driver.get(baseURL);
        System.out.println("Hello");

    }


    @Test
    public void testingAction() throws InterruptedException {
        login();
        newAction();
    }


    @Step("First Step")
    private void login(){
        LoginPage logpage = new LoginPage(driver);
        this.driver = logpage.login("MSOKOLOV", "MSOKOLOV");
    }

    @Step("Second Step")
    private void newAction() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(7000);
        homePage.newAct();
    }



    @AfterClass
    public void CloseDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
