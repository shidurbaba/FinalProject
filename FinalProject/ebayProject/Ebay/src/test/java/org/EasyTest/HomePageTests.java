package org.EasyTest;

import org.BaseAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageobjects.EbayHomePage;
import pageobjects.FashionPage;
import pageobjects.SignInPage;

public class HomePageTests extends BaseAPI {



    @Test(priority = 1)
    public void verifyHomePageTitle() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        AssertJUnit.assertEquals(homepage.getPageTitle(),
                "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay");
    }

    @Test(priority = 2)
    public void verifySignInLinkOnEbayHomePage() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        Assert.assertTrue(homepage.isSignInButtonPresent(), "Sign In button not present");
    }

    @Test(priority = 3)
    public void SelectItemByCategoryOnHomePage() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        homepage.SelectCategoryAndSearch("Baby");
    }

    @Test(priority = 4)
    public void searchItembyAllcategory() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        homepage.searchItemsFromSearchBox("Cooler");

    }

    @Test(priority = 5)
    public void verifyByClickingOnEbayLogoTakesToHomePage() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        homepage.clickOnHomePageLogo();
        AssertJUnit.assertEquals(homepage.getPageTitle(),
                "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay");

    }

    @Test(priority = 6)
    public void verifyFashionPageOpened() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        homepage.clickOnFashionTab();
        FashionPage fp = PageFactory.initElements(driver, FashionPage.class);
        AssertJUnit.assertEquals(fp.getTitlePage(),
                "Fall Fashion 2017 – Best Dresses & Outfits for Fall | eBay");
        homepage.clickOnHomePageLogo();

    }

    @Test(priority = 7)
    public void verifySearchButtonIsClickAble() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        AssertJUnit.assertTrue(homepage.IsSearchButtonEnabled());
    }

    @Test(priority = 8)
    public void verifyCartOnHOmePage() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        AssertJUnit.assertTrue(homepage.isCartLogoPresentOnHomePage());
    }

    @Test(priority = 9)
    public void verifySignInLinkNavigatedToSignInPage() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        SignInPage signinpage = homepage.clickOnSignInLink();
        AssertJUnit.assertEquals(signinpage.getTitleOfPage(), "Sign in or Register | eBay");
    }

    @Test(priority = 10)
    public void verifyRegisterLinkOnEbayHomePage() {
        EbayHomePage homepage = PageFactory.initElements(driver, EbayHomePage.class);
        Assert.assertTrue(homepage.isRegistrationLinkPresentOnHomePage(),
                "Sign In button not present");
    }
}
