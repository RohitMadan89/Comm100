package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DriverManagerSetUp {

    String browser;
    protected  WebDriver driver;

    public  DriverManagerSetUp() {
            this.browser = System.getProperty("BROWSER");
    }

    @BeforeClass
    public WebDriver setUp() throws Exception {
        if (this.browser == null || this.browser.trim().length() == 0) {
            this.browser = "chrome";
        }

            try {
                switch (this.browser.toLowerCase()) {
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        this.initializeFirefox();
                        break;
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        this.initializeChrome();
                        break;
                    default:
                        throw new Exception("Unrecognized browser: " + this.browser);
                }
            } catch (WebDriverException e) {
                throw e;
            }


        // Maximize window
        this.driver.manage().window().maximize();
        return this.driver;
    }

    private void initializeChrome(){
        try {
            final ChromeOptions options = new ChromeOptions();
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
            this.driver = new ChromeDriver(options);
        } catch (final Exception e) {
            throw e;
        }
    }

    private void initializeFirefox(){
        this.driver = new FirefoxDriver();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
