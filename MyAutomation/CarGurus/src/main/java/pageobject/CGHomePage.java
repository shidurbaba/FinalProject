package pageobject;

import common.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static common.CommonAPI.driver;

public class CGHomePage extends CommonAPI {
    @FindBy(how = How.ID, using = "toolsMenu")
    public static WebElement myaccount;

    @FindBy(how = How.XPATH, using = "//ul[@id='dropdown-toolsMenu']//a[@title='Sign in']")
    public static WebElement signin;


    @FindBy (how = How.ID, using = "registerEmail")
    public static WebElement email;

    public void siginUser() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(myaccount).perform();
        Thread.sleep(2000);
        act.moveToElement(signin).click();
        Thread.sleep(2000);
        enterEmail();
    }

    public void enterEmail(){
        email.sendKeys("abcd123@gmail.com");
    }
}