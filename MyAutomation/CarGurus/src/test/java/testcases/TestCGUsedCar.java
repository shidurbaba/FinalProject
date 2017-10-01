package testcases;


import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobject.CGUsedCar;


public class TestCGUsedCar extends CommonAPI{


    @Test
    public void testUsedCar() throws InterruptedException {
        CGUsedCar test2 = PageFactory.initElements(driver, CGUsedCar.class );
        test2.selectAllMakes();
      /*  test2.selectAllModels();*/
        test2.searchCar();
    }


}
