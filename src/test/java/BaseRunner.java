import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseRunner {
    public WebDriver driver;
    public String baseUrl;
    public String browserName;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        baseUrl = "https://www.tinkoff.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/loginov/qa_web/drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/home/loginov/qa_web/drivers/geckodriver");
        try {
            browserName = System.getProperty("browser");
            System.out.println(System.getProperty("browser"));
            BrowserFactory.valueOf(browserName);
        } catch (NullPointerException  e) {
            //System.setProperty("browser", browserName);
        }
        return BrowserFactory.valueOf(browserName).create();
    }

}