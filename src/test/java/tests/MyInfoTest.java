package tests;

import core.common.Actions;
import core.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyInfoTest {

    WebDriver driver;
    LoginPage loginpage;
    Actions actions;


    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);
        actions = new Actions(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // It ensures the browser is closed after each test method
        driver.quit();
    }

    @Test(description = "Add attachment to the Immigration", priority = 1)
    public void AddAttachmentsToTheImmigrationSectionValidScenario() {
        //Login with valid Creds
        LoginPage.ValidLogin(driver);

        // Locate and click the 'MyInfo' section
        actions.findElementByXpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7"));

        // Locate and click the 'immigration' button
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[5]/a").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewImmigration/empNumber/7"));

        String filePath = "C:\\Users\\halulaimi\\Desktop\\FrontEndTesting\\SequentalAssignment\\AutomationTesting.pdf";

        // Locate and click the 'Add' Button
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[5]/div[1]/div/button").click();
        actions.findElementByClassName("oxd-file-input").sendKeys(filePath);

        // Locate and click the 'save' button
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[5]/div/form/div[3]/button[2]").click();

        //assert from successfully message is appeared
        Assert.assertEquals(actions.findElementByXpath("/html/body/div/div[2]/div/div[1]/div[2]/p[1]").getText(), "Success");
    }


    @Test(description = "Add attachment to the Immigration invalid scenario [WithoutFile]", priority = 2)
    public void AddAttachmentsToTheImmigrationInvalidScenario() {
        //Login with valid Creds
        LoginPage.ValidLogin(driver);

        // Locate and click the 'MyInfo' section
        actions.findElementByXpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7"));

        // Locate and click the 'immigration' button
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[5]/a").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewImmigration/empNumber/7"));

        // Locate and click the 'Add' Button
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[5]/div[1]/div/button").click();

        // Locate and click the 'save' button
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[5]/div/form/div[3]/button[2]").click();

        //assert from successfully message is appeared
        Assert.assertEquals(actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[5]/div/form/div[1]/div/div/div/span").getText(), "Required");
    }
}
