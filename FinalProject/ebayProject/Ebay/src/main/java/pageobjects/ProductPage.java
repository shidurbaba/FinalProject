package pageobjects;

import org.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BaseAPI {

    @FindBy(xpath = "//*[@id='binBtn_btn']")
    private WebElement buy_it_now_button;

    @FindBy(xpath = ".//*[@id='isCartBtn_btn']")
    private WebElement add_to_cart;

    public boolean IsAddtoCartButtonsEnabled() {
        if (add_to_cart.isEnabled()) {
            return true;
        }
        return false;
    }

}
