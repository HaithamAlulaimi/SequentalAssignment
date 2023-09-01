package tests;

import core.common.Actions;
import core.pages.*;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TheFullScenarioTest {
    LoginPage login;
    AddUserPage addUser;
    Actions actions;
    SoftAssert softAssert;

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        addUser=new AddUserPage(driver);
        actions = new Actions(driver);
        softAssert = new SoftAssert();
        actions.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // It ensures the browser is closed after each test method
        driver.quit();
    }

    @Test(description = "Add Info Page", priority = 1)
    public void TestingTheFullScenario() throws InterruptedException {
        LoginPage.ValidLogin(driver);
        AddUserPage.validAddUser(driver);
        MyInfoPage.validAddImmigrationAttachment(driver);
        BuzzPage.validBuzzPost(driver);
        LogoutPage.ValidLogout(driver);
    }
}
