package common;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;
    @Parameters ({"browserName", "URL", "os"})
    @BeforeClass
    public void setUp(String browserName, String URL, String os) {
        System.out.println("Session is about to start");
        getLocalDriver(browserName, os);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public WebDriver getLocalDriver(String browserName, String os) {
        browserName = browserName.toLowerCase();
        os = os.toLowerCase();

        if (browserName.contains("chrome")) {
            if (os.contains("win")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver.exe");
            } else if (os.contains("mac") || os.contains(("os x")) || os.contains("linux")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver");
            } else {
                System.err.println("ERROR : Invalid driver path");
            }


            driver = new ChromeDriver();
        }
        return driver;

    }

    @AfterClass
    public void finishUp() {
        System.out.println("Session is over");
        driver.close();
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/shidur/IdeaProjects/MyAutomation/Generic/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

        driver.findElement(By.id("lst-ib")).sendKeys("X-Men");
        driver.findElement(By.className("lsb")).click();
        driver.navigate().back();
        driver.findElement(By.xpath(".//*[@id='gbwa']/div[1]/a")).click();
        driver.findElement(By.xpath(".//*[@id='gb5']/span[1]")).click();

        System.out.println("This will print out my current url : " + driver.getCurrentUrl());
        System.out.println("This will print out my title : " + driver.getTitle());


        driver.close();
    }
}



