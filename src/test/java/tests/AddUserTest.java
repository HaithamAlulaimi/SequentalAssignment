package tests;


import Factory.PageFactory;
import core.BasePage;
import core.common.Actions;
import core.common.CommonMethods;
import core.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddUserTest {

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


    @Test(description = "Add system User valid scenario", priority = 1)
    public void addSystemUserWithValidFCred() {

        //Login with valid Creds
        LoginPage.ValidLogin(driver);

        // Locate and click the 'Admin' section
        actions.findElementByXpath("//span[normalize-space()='Admin']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

        // Locate and click the 'Add' button
        actions.findElementByXpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));

        // Locate and click the 'UserRole' list
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]").click();

        // assert the 'UserRole' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]").isDisplayed());

        // Click on the ESS option from the 'UserRole' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[3]").click();

        // Locate and click the 'Status' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[1]").click();

        // assert the 'Status' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]").isDisplayed());

        // Click on the enable option from the 'Status' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]").click();

        // Locate the 'Employee Name' input field and enter 'h' as a char to find a user.
        actions.findElementByXpath("//input[@placeholder='Type for hints...']").sendKeys("h");
        CommonMethods.waitByThreadSleep(3);

        // assert the "Employee Name" list is display.
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").isDisplayed();

        // Click on the Employee Name.
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").click();

        // Locate the 'Username' input field and enter 'Haitham' as the Username
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]").sendKeys(BasePage.generateRandomText(10));

        // Locate the 'Password' input field and enter 'Password'
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]").sendKeys("Test@123456");

        // Locate the 'Password' input field and enter 'Confirm Password'
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input").sendKeys("Test@123456");

        // Locate and click the 'save' button
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]").click();

        //assert from successfully message is appeared
        Assert.assertEquals(actions.findElementByXpath("/html/body/div/div[2]/div/div[1]/div[2]/p[1]").getText(), "Success");
    }


    @Test(description = "Add system User Without add Employee Name", priority = 2)
    public void addSystemUserWithoutEmployeeName() {

        //Login with valid Creds
        LoginPage.ValidLogin(driver);

        // Locate and click the 'Admin' section
        actions.findElementByXpath("//span[normalize-space()='Admin']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

        // Locate and click the 'Add' button
        actions.findElementByXpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));

        // Locate and click the 'UserRole' list
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]").click();

        // assert the 'UserRole' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]").isDisplayed());

        // Click on the ESS option from the 'UserRole' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[3]").click();

        // Locate and click the 'Status' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[1]").click();

        // assert the 'Status' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]").isDisplayed());

        // Click on the enable option from the 'Status' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]").click();

        // Locate the 'Username' input field and enter 'h' as the match for find match system user
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]").sendKeys(BasePage.generateRandomText(10));
        CommonMethods.waitByThreadSleep(3);

        // Locate the 'password' input field and enter 'Password'
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]").sendKeys("Test@123456");

        // Locate the 'password' input field and enter 'Confirm Password'
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input").sendKeys("Test@123456");

        // Locate and click the 'save' button
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]").click();

        //assert from successfully message is appeared
        Assert.assertEquals(actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/span").getText(), "Required");
    }


    @Test(description = "Add system User with Not match Password", priority = 3)
    public void addSystemUserWithNotMatchPassword() {

        //Login with valid Creds
        LoginPage.ValidLogin(driver);

        // Locate and click the 'Admin' section
        actions.findElementByXpath("//span[normalize-space()='Admin']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

        // Locate and click the 'Add' button
        actions.findElementByXpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));

        // Locate and click the 'UserRole' list
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]").click();

        // assert the 'UserRole' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]").isDisplayed());

        // Click on the ESS option from the 'UserRole' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[3]").click();

        // Locate and click the 'Status' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[1]").click();

        // assert the 'Status' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]").isDisplayed());

        // Click on the enable option from the 'Status' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]").click();

        // Locate the 'Employee Name' input field and enter 'h' as a char to find a user.
        actions.findElementByXpath("//input[@placeholder='Type for hints...']").sendKeys("h");
        CommonMethods.waitByThreadSleep(3);

        // assert the "Employee Name" list is display.
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").isDisplayed();

        // Click on the Employee Name.
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").click();

        // Locate the 'Username' input field and enter 'Haitham' as the Username
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]").sendKeys(BasePage.generateRandomText(10));

        // Locate the 'password' input field and enter 'Password'
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]").sendKeys("Test@1234567");

        // Locate the 'password' input field and enter 'wrong Password'
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input").sendKeys("Test@123456");

        // Locate and click the 'save' button
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]").click();

        //assert from alert message is appeared
        Assert.assertEquals(actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/span").getText(), "Passwords do not match");
    }


    @Test(description = "Add system User Without User Name", priority = 4)
    public void addSystemUserWithoutUserName() {

        //Login with valid Creds
        LoginPage.ValidLogin(driver);

        // Locate and click the 'Admin' section
        actions.findElementByXpath("//span[normalize-space()='Admin']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

        // Locate and click the 'Add' button
        actions.findElementByXpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));

        // Locate and click the 'UserRole' list
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]").click();

        // assert the 'UserRole' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]").isDisplayed());

        // Click on the ESS option from the 'UserRole' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[3]").click();

        // Locate and click the 'Status' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[1]").click();

        // assert the 'Status' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]").isDisplayed());

        // Click on the enable option from the 'Status' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]").click();

        // Locate the 'Employee Name' input field and enter 'h' as a char to find a user.
        actions.findElementByXpath("//input[@placeholder='Type for hints...']").sendKeys("h");
        CommonMethods.waitByThreadSleep(3);

        // assert the "Employee Name" list is display.
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").isDisplayed();

        // Click on the Employee Name.
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").click();


        // Locate the 'Password' input field and enter 'Password'
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]").sendKeys("Test@123456");

        // Locate the 'Password' input field and enter 'Confirm Password'
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input").sendKeys("Test@123456");


        // Locate and click the 'save' button
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]").click();

        //assert from alert message is appeared
        Assert.assertEquals(actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/span").getText(), "Required");
    }


    @Test(description = "Add system User Without User role", priority = 5)
    public void addSystemUserWithoutUserRole() {
        //Login with valid Creds
        LoginPage.ValidLogin(driver);

        // Locate and click the 'Admin' section
        actions.findElementByXpath("//span[normalize-space()='Admin']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

        // Locate and click the 'Add' button
        actions.findElementByXpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));

        // Locate and click the 'Status' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[1]").click();

        // assert the 'Status' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]").isDisplayed());

        // Click on the enable option from the 'Status' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]").click();

        // Locate the 'Employee Name' input field and enter 'h' as a char to find a user.
        actions.findElementByXpath("//input[@placeholder='Type for hints...']").sendKeys("h");
        CommonMethods.waitByThreadSleep(3);

        // assert the "Employee Name" list is display.
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").isDisplayed();

        // Click on the Employee Name.
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").click();

        // Locate the 'Username' input field and enter 'Haitham' as the Username
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]").sendKeys(BasePage.generateRandomText(10));

        // Locate the 'Password' input field and enter 'Password'
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]").sendKeys("Test@123456");

        // Locate the 'Password' input field and enter 'Confirm Password'
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input").sendKeys("Test@123456");

        // Locate and click the 'save' button
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]").click();

        //assert from successfully message is appeared
        Assert.assertEquals(actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/span").getText(), "Required");
    }


    @Test(description = "Add system User Without Status", priority = 6)
    public void addSystemUserWithoutStatus() {
        //Login with valid Creds
        LoginPage.ValidLogin(driver);

        // Locate and click the 'Admin' section
        actions.findElementByXpath("//span[normalize-space()='Admin']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));

        // Locate and click the 'Add' button
        actions.findElementByXpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));

        // Locate and click the 'UserRole' list
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]").click();

        // assert the 'UserRole' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]").isDisplayed());

        // Click on the ESS option from the 'UserRole' list
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[3]").click();

        // Locate the 'Employee Name' input field and enter 'h' as a char to find a user.
        actions.findElementByXpath("//input[@placeholder='Type for hints...']").sendKeys("h");
        CommonMethods.waitByThreadSleep(3);

        // assert the "Employee Name" list is display.
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").isDisplayed();

        // Click on the Employee Name.
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").click();

        // Locate the 'Username' input field and enter 'Haitham' as the Username
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]").sendKeys(BasePage.generateRandomText(10));

        // Locate the 'Password' input field and enter 'Password'
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]").sendKeys("Test@123456");

        // Locate the 'Password' input field and enter 'Confirm Password'
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input").sendKeys("Test@123456");

        // Locate and click the 'save' button
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]").click();

        //assert from successfully message is appeared
        Assert.assertEquals(actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/span").getText(), "Required");
    }
}
