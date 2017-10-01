package testcases;

import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobjects.HomePage;





public class TestLogin extends CommonAPI {

    @Test
    public void testLoginPage() throws InterruptedException {
        HomePage test1 = PageFactory.initElements(driver, HomePage.class);
        test1.clickSignInHomePage();

    }
   /* @Test
    public void testLoginPage2() throws InterruptedException {
        HomePage test1 = PageFactory.initElements(driver, HomePage.class);
        test1.waitSignInHomePageButton();

    }*/
}
