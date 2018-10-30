import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookPage {

    WebDriver driver;
    WebElement nextPageElement;
    WebElement textElement;
    WebElement topicElement;

    BookPage(WebDriver driver){

        this.driver = driver;
    }

    public void findNextPageElement(){
        driver.findElement(By.className("asset-body"));
    }

    public WebElement getNextPageElement(){
       return(this.nextPageElement =  driver.findElement(By.linkText("Next Entry")));
    }

    public WebDriver clickNextPage(){
        this.nextPageElement = getNextPageElement();
        nextPageElement.click();
        return (driver);
    }

    public WebElement findTextElement(){
        return(driver.findElement(By.className("asset-body ")));
    }

    public String getTextFromElement(){
        String topicName = getTopicName();
        if(topicName.contains("esson") || topicName.contains("лава")){
            textElement = findTextElement();
            return(textElement.getText());
        }else{
            return "";
        }


    }

    public String getTopicName(){
        try {
            this.topicElement = this.driver.findElement(By.className("subj-link"));
            return (topicElement.getText());
        }catch (NoSuchElementException e){
            return "";
        }
    }
}
