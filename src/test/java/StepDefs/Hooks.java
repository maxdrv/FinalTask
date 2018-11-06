package StepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ozon.util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static ozon.util.TestDriver.getDriver;
import static ozon.util.TestDriver.setDriver;

public class Hooks {

    public static Properties properties = TestProperties.INSTANCE.getProperties();
    public static String baseUrl;

    @Before
    public void setUp() throws Exception {
        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                setDriver(new FirefoxDriver());
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                setDriver(new ChromeDriver());
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                setDriver(new ChromeDriver());
                break;
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        //getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        baseUrl = properties.getProperty("url");
        getDriver().get(baseUrl);
    }

    @After
    public void clearData() {
        getDriver().quit();
    }
}


