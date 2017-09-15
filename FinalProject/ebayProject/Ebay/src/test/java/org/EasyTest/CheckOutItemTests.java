package org.EasyTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.BaseAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ProductPage;
import pageobjects.SignInPage;

public class CheckOutItemTests extends BaseAPI {


    @Test
    public void verifyUserCanableToaddItemIntocart() {
        driver.get("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=");
        SignInPage signin = PageFactory.initElements(driver, SignInPage.class);
        signin.userSignin("jaimelanniester40@gmail.com", "azorhai2018");
        driver.get(
                "http://www.ebay.com/itm/Barnett-Raptor-FX2-Crossbow-Manufacturer-Refurbished-78063-/362100961654?epid=2238733324&hash=item544ee63176:g:P-YAAOSw9sJZuCBa");
        ProductPage product = PageFactory.initElements(driver, ProductPage.class);
        AssertJUnit.assertTrue(product.IsAddtoCartButtonsEnabled());
    }
}
