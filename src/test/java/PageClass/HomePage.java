package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css="#menu-utility-right a[href*='login'][class*='link']")
    public WebElement signIn;

    public String getTitle(){
        return driver.getTitle();
    }

    public LoginPage navigateToLogin(){
        signIn.click();
        return PageFactory.initElements(driver,LoginPage.class);
    }





}
