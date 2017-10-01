package testcases;

import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobjects.FindItems;

public class TestFindItems extends CommonAPI{

    @Test
    public void testIfItemAvailable() throws InterruptedException {
        FindItems test2 = PageFactory.initElements(driver, FindItems.class);
        test2.searchItem();
    }

}
