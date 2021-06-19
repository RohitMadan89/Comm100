package PageClass;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    public BasePage(WebDriver webDriver){
        this.driver=webDriver;
    }

    public boolean isDisplayed(WebElement element){
        boolean flag = false;
        try{
            element.isDisplayed();
            flag  =true;
        }catch(NoSuchElementException ex){
            flag = false;
        }
        return  flag;
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getAttribute(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }

    public void sendKeys(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public void waitForWebElementPresent(WebElement element){
        WebDriverWait wait = new WebDriverWait(this.driver,10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }



}
