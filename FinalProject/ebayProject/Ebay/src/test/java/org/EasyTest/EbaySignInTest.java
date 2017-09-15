package org.EasyTest;

import org.BaseAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageobjects.EbayHomePage;
import pageobjects.SignInPage;

public class EbaySignInTest extends BaseAPI {


    @Test(priority = 8)
    public void verifyLogin() throws InterruptedException {

        SignInPage signin = PageFactory.initElements(driver, SignInPage.class);
        Assert.assertTrue(signin.IsLoginSuccessfull(), "unsuccessfull login");
    }

    @Test(priority = 9)
    public void verifyUserSignOut() throws InterruptedException {
        SignInPage signin = PageFactory.initElements(driver, SignInPage.class);
        Thread.sleep(3000);
        signin.userSignout();
        AssertJUnit.assertEquals(driver.getCurrentUrl(),
                "https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&lgout=1");
    }

    @Test(priority = 3)
    public void verifyErrorMessageforValidEmailnadINvalidPassword() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        homepage.clickOnSignInLink();
        SignInPage signin = PageFactory.initElements(driver, SignInPage.class);
        signin.userSignin("jaimelanniester40@gmail.com", "azorhai2017");
        AssertJUnit.assertTrue(signin.isErrorMessageDispayed());
    }

    @Test(priority = 4)
    public void verifyErrorMessageforInValidEmailnadValidPassword() {
        SignInPage signin = PageFactory.initElements(driver, SignInPage.class);
        signin.userSignin("jaimelanniester41@gmail.com", "azorhai2018");
        AssertJUnit.assertTrue(signin.isErrorMessageDispayed());
    }

    @Test(priority = 5)
    public void verifyErrorMessageforInValidEmailnadINValidPassword() {
        SignInPage signin = PageFactory.initElements(driver, SignInPage.class);
        signin.userSignin("jaimelanniester41@gmail.com", "azorhai2017");
        AssertJUnit.assertTrue(signin.isErrorMessageDispayed());
    }

    @Test(priority = 6)
    public void verifyErrorMessageforEmptyLOgin() {
        SignInPage signin = PageFactory.initElements(driver, SignInPage.class);
        signin.userSignin(" ", " ");
        AssertJUnit.assertTrue(signin.isErrorMessageDispayed());
    }

    @Test(priority = 7)
    public void verifyGiftCardOptionsPresentAfterLogin() throws InterruptedException {
        SignInPage signin = PageFactory.initElements(driver, SignInPage.class);
        signin.userSignin("jaimelanniester40@gmail.com", "azorhai2018");
        AssertJUnit.assertTrue(signin.isGiftcardOptionPresent());
    }


}
