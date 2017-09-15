package pageobjects;

import org.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BaseAPI {

    @FindBy(css = "#userid")
    private WebElement emailid_field;

    @FindBy(css = "#pass")
    private WebElement password;

    @FindBy(css = "#sgnBt")
    private WebElement signin_button;

    @FindBy(id = "gh-ug")
    private WebElement name;

    @FindBy(css = "#gh-ug")
    private WebElement profilename_dropdown;

    @FindBy(xpath = ".//*[@id='gh-uo']/a")
    private WebElement signoutButton;

    @FindBy(id = "errf")
    private WebElement errorMessage;

    @FindBy(xpath = ".//*[@id='gh-p-4']/a")
    private WebElement giftcardlink;

    @FindBy(xpath = ".//*[@id='csi']")
    private WebElement signin_checkbox;

    public boolean isGiftcardOptionPresent() {
        if (giftcardlink.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isErrorMessageDispayed() {
        if (errorMessage.isDisplayed()) {
            return true;
        }
        return false;
    }


    public void userSignout() throws InterruptedException {
        profilename_dropdown.click();
        Thread.sleep(10000);
        Actions hover = new Actions(driver);
        hover.moveToElement(signoutButton).build();
        signin_button.click();
    }

    public void userSignin(String email, String pass) {
        if (signin_checkbox.isSelected()) {
            signin_checkbox.click();
        }
        emailid_field.clear();
        emailid_field.sendKeys(email);
        password.clear();
        password.sendKeys(pass);
        signin_button.click();
    }

    public boolean IsLoginSuccessfull() throws InterruptedException {
        Thread.sleep(10000);
        if (name.isDisplayed()) {
            return true;
        }
        return false;
    }

    public String getTitleOfPage() {
        return driver.getTitle();
    }
}
