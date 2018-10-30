import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageTest {
    WebDriver driver;

    HomePageTest(WebDriver driver){
        this.driver = driver;
    }


    public void newAct(){
        driver.findElement(By.className("siebui-icon-atc_new_vizit_active")).click();
    }
}
