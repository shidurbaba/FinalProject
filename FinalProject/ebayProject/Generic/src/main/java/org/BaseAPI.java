package org;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseAPI {
    public static WebDriver driver = null;

    @BeforeClass
    public void setUp() throws Throwable {
        System.out.println("Session is going to start");
        getLocalDriver(ReadProperty.getTestProperty("browser"), ReadProperty.getTestProperty("os"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(ReadProperty.getTestProperty("url"));
        driver.manage().window().maximize();
    }


    public WebDriver getLocalDriver(String browserName, String os) {
        browserName = browserName.toLowerCase();
        os = os.toLowerCase();

        if (browserName.contains("chrome")) {
            if (os.contains("win")) {
                System.setProperty("webdriver.chrome.driver", "../Commons/driver/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (os.contains("mac") || os.contains("os x")) {
                System.setProperty("webdriver.chrome.driver", "../Commons/driver/chromedriver");
                driver = new ChromeDriver();
            } else {
                System.err.println("ERROR: Invalid driver path");
            }

        } else if (browserName.contains("firefox")) {
            if (os.contains("win")) {
                System.setProperty("webdriver.gecko.driver", "../Commons/driver/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (os.contains("mac") || os.contains("os x")) {
                System.setProperty("webdriver.gecko.driver", "../Commons/driver/geckodriver");
                driver = new FirefoxDriver();
            } else {
                System.err.println("ERROR: Invalid driver path");
            }
        }
        return driver;
    }


    public WebDriver getCloudDriver() {

        return driver;
    }

    @AfterClass
    public void finishUp() {
        System.out.println("Session is over");
        driver.close();
    }

}

