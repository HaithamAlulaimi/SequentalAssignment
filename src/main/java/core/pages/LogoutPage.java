package core.pages;

import core.BasePage;
import core.common.Actions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogoutPage extends BasePage {
    static WebDriver driver;

    public LogoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static void ValidLogout(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);

        //Login with valid Creds
        LoginPage.ValidLogin(driver);
        String CookieBeforeLogout = driver.manage().getCookieNamed("orangehrm").getValue();

        actions.findElementByXpath("//p[@class='oxd-userdropdown-name']").click();
        actions.findElementByXpath("//a[normalize-space()='Logout']").click();

        String CookieAfterLogout = driver.manage().getCookieNamed("orangehrms").getValue();
        // Check if a specific cookie exists
        Assert.assertFalse(CookieBeforeLogout.equals(CookieAfterLogout));
    }






}