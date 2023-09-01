package core.pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class AddLeavePage extends BasePage {
    static WebDriver driver;

    public AddLeavePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
