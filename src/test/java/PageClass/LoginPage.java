package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id="txtEmail")
    private WebElement username;

    @FindBy(id="txtPassword")
    private  WebElement password;

    @FindBy(id="lblLogin")
    private WebElement loginButton;

    @FindBy(id="chkAutoLogin")
    private WebElement checkAutoLogin;

    @FindBy(css="a[class*='aforgotpassword']")
    private WebElement forgotPassword;

    @FindBy(css="div[class*='comm100-global-ui-icon']")
    private WebElement idPasswordVisibleIcon;

    @FindBy(css="label[class='error'][for='txtEmail']")
    public WebElement emailEmptyError;

    @FindBy(css="label[class='error'][for='txtPassword']")
    public WebElement passwordEmptyError;

    @FindBy(css="#ajaxError .dialogtext")
    public WebElement invalidEmailOrPassword;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean verifyEmailMandatoryError(){
        waitForWebElementPresent(emailEmptyError);
        return isDisplayed(emailEmptyError);
    }

    public boolean verifyPasswordMandatoryError(){
        waitForWebElementPresent(passwordEmptyError);
        return isDisplayed(passwordEmptyError);
    }

    public void performLoginWithoutSendingData(){
        loginButton.click();
    }

    public void login(String user, String pwd){
        waitForWebElementPresent(username);
        sendKeys(username,user);
        sendKeys(password,pwd);
        loginButton.click();
    }


    public String getInvalidCredErrorMessage(){
        waitForWebElementPresent(invalidEmailOrPassword);
        return  getText(invalidEmailOrPassword);
    }





}
