package Scripts;

import PageClass.HomePage;
import PageClass.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverManagerSetUp;
import utils.PropertyReader;

import java.io.IOException;

public class Login extends DriverManagerSetUp {

    PropertyReader prop = new PropertyReader();
    LoginPage loginPage ;
    HomePage homePage ;

    @Test(priority = 0)
    public void verifySuccessfulNavigateTo100Comm() throws IOException {
        driver.navigate().to(prop.readPropertyConfig("url"));
        Assert.assertEquals(driver.getTitle(), "Customer Engagement Platform| Comm100");
    }

    @Test(priority = 1)
    public void verifySignInPage() throws IOException {
        homePage =  PageFactory.initElements(driver,HomePage.class);
        loginPage = homePage.navigateToLogin();
        Assert.assertEquals(homePage.getTitle(), "Comm100 - User Sign In");
    }

    @Test(priority = 2)
    public void verifyUserNameAndPasswordIsMandatory() throws IOException {
        loginPage.login("","");
        Assert.assertTrue(loginPage.verifyEmailMandatoryError() && loginPage.verifyPasswordMandatoryError());
        Assert.assertEquals(loginPage.getText(loginPage.emailEmptyError),prop.readPropertyConfig("emailError"));
        Assert.assertEquals(loginPage.getText(loginPage.passwordEmptyError),prop.readPropertyConfig("pwdError"));
    }

    @Test(priority = 3)
    public void unSuccessfulLogin() throws IOException {
        loginPage.login(prop.readPropertyConfig("invalidUsername"), prop.readPropertyConfig("invalidPassword"));
        Assert.assertEquals(loginPage.getInvalidCredErrorMessage(), prop.readPropertyConfig("invalidCredMessage"));
    }

    @Test(priority = 4,enabled = false)
    public void successfulLogin() throws IOException {
        loginPage.login(prop.readPropertyConfig("username"), prop.readPropertyConfig("password"));
        //TO DO:
        //verify user is signed in
    }

}
