package ozon.util;

import org.openqa.selenium.WebDriver;

public class TestDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        TestDriver.driver = driver;
    }

    private TestDriver() {

    }
}
