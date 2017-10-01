package pageobjects;

import common.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends CommonAPI {

    @FindBy (how = How.XPATH, using = "//a[@id='nav-link-accountList']")
    public static WebElement sigin;

    @FindBy (how = How.ID, using = "ap_email")
    public static WebElement email;

    @FindBy (how = How.ID, using = "ap_password")
    public static WebElement password;

    @FindBy (how = How.XPATH, using = "//input[@id = 'signInSubmit']")
    public static WebElement sigin1;

    @FindBy (how = How.XPATH, using = ".//*[@id='nav-flyout-ya-signin']/a/span")
    public static WebElement frontsign;


    public void clickSignInHomePage() throws InterruptedException {
        sigin.click();
        Thread.sleep(1000);
    }

    public void waitSignInHomePageButton() throws InterruptedException {
        System.out.println("Click On Sign In");
        Actions action = new Actions(driver);
        action.moveToElement(frontsign).click();
        Thread.sleep(1000);
    }


}
