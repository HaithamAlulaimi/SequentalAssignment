package tests;

import Factory.PageFactory;
import core.common.Actions;
import core.pages.BuzzPage;
import core.pages.LoginPage;
import core.pages.LogoutPage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest {

    WebDriver driver;
    LoginPage loginpage;
    Actions actions;


    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        actions = new Actions(driver);
        PageFactory.invokeBrowser(driver);

    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // It ensures the browser is closed after each test method
        driver.quit();
    }

    @Test(description = "Logout Valid Scenario", priority = 1)
    public void AddAttachmentsToTheImmigrationSection() {
        //Login with valid Creds
        LoginPage.ValidLogin(driver);
        String CookieBeforeLogout = driver.manage().getCookieNamed("orangehrm").getValue();

        actions.findElementByXpath("//p[@class='oxd-userdropdown-name']").click();
        actions.findElementByXpath("//a[normalize-space()='Logout']").click();

        String CookieAfterLogout = driver.manage().getCookieNamed("orangehrm").getValue();
        // Check if a specific cookie exists
        Assert.assertFalse(CookieBeforeLogout.equals(CookieAfterLogout));
    }
}
