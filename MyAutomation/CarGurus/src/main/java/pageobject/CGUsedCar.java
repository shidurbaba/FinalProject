package pageobject;

import common.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CGUsedCar extends CommonAPI{

    @FindBy (how = How.ID, using = "carPickerUsed_makerSelect")
    public static WebElement allmakes;

 @FindBy (how = How.ID, using = "carPickedUsed_modelSelect")
    public static WebElement models;

    @FindBy (how = How.ID, using = "dealFinderForm_0")
    public  static WebElement search;

    @FindBy (how = How.ID, using = "dealFinderZipUsedId")
    public static WebElement zipcode;

    public void selectAllMakes() throws InterruptedException {
        Select sel = new Select(allmakes);
        sel.selectByVisibleText("Cadillac");
        }
/*public void selectAllModels(){
    WebDriverWait wait = new WebDriverWait(driver,3);
    WebElement allmodels = wait.until(ExpectedConditions.visibilityOf(models));
    Select sel = new Select(allmodels);
    sel.selectByVisibleText("ATS");
}*/
   public void searchCar(){
    zipcode.sendKeys("07306");
    search.click();
   }

}
