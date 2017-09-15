package pageobjects;

import org.BaseAPI;

public class FashionPage extends BaseAPI {

    public String getTitlePage() {
        return driver.getTitle();
    }
}
