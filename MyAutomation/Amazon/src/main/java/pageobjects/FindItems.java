package pageobjects;

import common.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class FindItems extends CommonAPI {

    @FindBy (how = How.ID, using = "twotabsearchtextbox")
    public static WebElement editbox;

    @FindBy (how = How.XPATH, using = "//div[@id='nav-search']//input[@type='submit']")
    public static WebElement submitbtn;

    public void searchItem() throws InterruptedException {
        editbox.sendKeys("Song of Ice And Fire");
        submitbtn.click();
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "http://www.amazon1.com" );
    }


}
