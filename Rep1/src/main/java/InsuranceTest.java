import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InsuranceTest {
    WebDriver driver;
    String baseURL;

    @BeforeClass
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Repository\\Rep1\\chromedriver.exe");
        //baseURL = "https://www.rgs.ru";
        baseURL = "https://192.168.15.201/express_oui";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test
    public void testInsurance(){
        /* Это из курсов
        WebElement rgsIMG = driver.findElement(By.xpath("//href[@class='container-rgs-logo-logo']"));
        System.out.println(rgsIMG.isEnabled());
        //Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        //wait.until(ExpectedConditions.visibilityOf(rgsIMG));
        rgsIMG.click();
*/
       // driver.findElement(By.xpath("//img[@src='/media/sys-ng/dist/images/brand/logo.svg']")).click();
       // driver.findElement(By.xpath("//ol[contains(@class, 'nav navbar-nav navbar-nav-rgs-menu pull-left']/li/*[contains(text(), 'Страхование')]")).click();
       // driver.findElement(By.xpath("//div[contains(@class, '/rgs-main-menu-category')]/a[contains(text(), 'ДМС')]")).click();

        //Зибель
        WebElement login_form = driver.findElement(By.id("s_swepi_1"));
        WebElement pass_form = driver.findElement(By.id("s_swepi_2"));

        login_form.sendKeys("MSOKOLOV");
        pass_form.sendKeys("MSOKOLOV");

        WebElement login_btn = driver.findElement(By.id("s_swepi_22"));
        login_btn.click();

        //Добавляем неявное ожидание, в течение которого драйвер будет пытаться искать элемент
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //А можно добавить ожидание загрузки страницы
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Экспресс");

        //Простой поиск элемента
        WebElement new_act = driver.findElement(By.id("s_5_1_2_0"));

        WebElement new_act2  = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("s_5_1_2_0")));

        new_act.click();
        try {
            Thread.sleep(100000);
        }catch (InterruptedException q){
            q.printStackTrace();
        }


    }


    @AfterClass
    public void afterTest(){
        driver.quit();
    }
}
