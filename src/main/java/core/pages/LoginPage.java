package core.pages;

import constants_enums.Credentials;
import core.BasePage;
import core.common.Actions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static void ValidLogin(WebDriver driver) {
        Actions actions = new Actions(driver);

        // Locate the 'Username' input field and enter 'Admin' as the username
        actions.findElementByXpath("//input[@placeholder='Username']").sendKeys(Credentials.Valid_UserName.getKey());

        // Locate the 'Password' input field and enter 'admin123' as the password
        actions.findElementByXpath("//input[@placeholder='Password']").sendKeys(Credentials.Valid_Password.getKey());

        // Locate and click the 'Login' button
        actions.findElementByTagName("button").click();

        // Verify that the current URL matches the expected dashboard URL
        Assert.assertEquals(actions.currentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
}
