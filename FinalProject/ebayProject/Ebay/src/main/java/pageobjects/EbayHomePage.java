package pageobjects;

import org.BaseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EbayHomePage extends BaseAPI {



    @FindBy(css = "#gh-ug>a")
    private WebElement signin_link;

    @FindBy(css = "#gh-ug-flex>a")
    private WebElement register_link;

    @FindBy(css = "#gh-cat")
    private WebElement categories_dropdown;

    @FindBy(id = "gh-btn")
    private WebElement searchButtn;

    @FindBy(id = "gh-ac")
    private WebElement searchbox;

    @FindBy(id = "gh-la")
    private WebElement homepageLoago;

    @FindBy(xpath = ".//*[@id='s0-container']/li[5]/a")
    private WebElement fashion_tab;

    @FindBy(id = "gh-cart-i")
    private WebElement cartlogo;

    public boolean isCartLogoPresentOnHomePage() {
        if (cartlogo.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void clickOnFashionTab() {
        fashion_tab.click();
    }

    public void clickOnHomePageLogo() {
        homepageLoago.click();
    }

    public boolean IsSearchButtonEnabled() {
        if (searchButtn.isEnabled()) {
            return true;
        }
        return false;
    }


    public void searchItemsFromSearchBox(String itemname) {
        searchbox.sendKeys(itemname);
        searchButtn.click();
    }


    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isSignInButtonPresent() {
        if (signin_link.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isRegistrationLinkPresentOnHomePage() {
        if (register_link.isDisplayed()) {
            return true;
        }
        return false;
    }

    public SignInPage clickOnSignInLink() {
        signin_link.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public void SelectCategoryAndSearch(String category) {
        Select s = new Select(categories_dropdown);
        s.selectByVisibleText(category);
        searchButtn.click();

    }

    public boolean isCategorySelectedInDropDown() {
        if (categories_dropdown.isSelected()) {
            return true;
        }
        return false;
    }
}

