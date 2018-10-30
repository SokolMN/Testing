import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class GetBook {

    WebDriver driver;
    String str;
    String topicName;

    @BeforeClass
    public void getStartPage(){
        System.setProperty("webdriver.chrome.driver", "C:\\Repository\\Rep1\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "https://w-bf.livejournal.com/198496.html";
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public static void writeTextInFile(String str, FileWriter writer) throws IOException {

        writingText(writer, str);
    }

    public static void writingText(FileWriter writer, String str) throws IOException {
        writer.append(str);
        writer.flush();
    }

    @Test
    public void login(){

        BookPage bookPage = new BookPage(driver);

        try (FileWriter writer = new FileWriter("Book.txt")) {

            do{
                str = bookPage.getTextFromElement();
                System.out.println(str);
                //this.driver = bookPage.clickNextPage();
                bookPage.driver = bookPage.clickNextPage();

                writeTextInFile(str, writer);
                topicName = bookPage.getTopicName();
            }while(topicName != "Lesson 293");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }



    @AfterClass
    public void CloseDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
