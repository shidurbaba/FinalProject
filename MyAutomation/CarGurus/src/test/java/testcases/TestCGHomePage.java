package testcases;

import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobject.CGHomePage;


public class TestCGHomePage extends CommonAPI {

    @Test
    public void testHomePage() throws InterruptedException {
        CGHomePage test1 = PageFactory.initElements(driver, CGHomePage.class);
        test1.siginUser();
    }


    }


