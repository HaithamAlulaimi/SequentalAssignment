package tests;

import Factory.PageFactory;
import constants_enums.Credentials;
import core.common.Actions;
import core.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {

    LoginPage login;
    Actions actions;
    SoftAssert softAssert;

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        actions = new Actions(driver);
        softAssert = new SoftAssert();
        PageFactory.invokeBrowser(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // It ensures the browser is closed after each test method
        driver.quit();
    }


    @Test(description = "Sign In with valid creds", priority = 1)
    public void signInWithValidCreds() {

        // Locate the 'Username' input field and enter 'Admin' as the username
        actions.findElementByXpath("//input[@placeholder='Username']").sendKeys(Credentials.Valid_UserName.getKey());

        // Locate the 'Password' input field and enter 'admin123' as the password
        actions.findElementByXpath("//input[@placeholder='Password']").sendKeys(Credentials.Valid_Password.getKey());

        // Locate and click the 'Login' button
        actions.findElementByTagName("button").click();

        // Verify that the user profile image is displayed after successful login
        Assert.assertTrue(actions.findElementByXpath("//img[@class='oxd-userdropdown-img']").isDisplayed());

        // Verify that the current URL matches the expected dashboard URL
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
    }

    @Test(description = "Sign In with invalid username", priority = 2)
    public void signInWithInValidUserName() {

        // Locate the 'Username' input field and enter 'Haitham' as the username
        actions.findElementByXpath("//input[@placeholder='Username']").sendKeys(Credentials.Invalid_UserName.getKey());

        // Locate the 'Password' input field and enter 'admin123' as the password
        actions.findElementByXpath("//input[@placeholder='Password']").sendKeys(Credentials.Valid_Password.getKey());

        // Locate and click the 'Login' button
        actions.findElementByTagName("button").click();

        // Verify that the user alert message displayed after click on the login button login
        Assert.assertTrue(actions.findElementByXpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']").isDisplayed());

        // Verify that the current URL matches the expected URL
        Assert.assertEquals(actions.findElementByXpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']").getText(), "Invalid credentials");

        // Verify that the current URL matches the expected dashboard URL
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }


    @Test(description = "Sign In with invalid Password", priority = 3)
    public void signInWithInValidPassword() {

        // Locate the 'Username' input field and enter 'Admin' as the username
        actions.findElementByXpath("//input[@placeholder='Username']").sendKeys(Credentials.Valid_UserName.getKey());

        // Locate the 'Password' input field and enter 'Test@12345' as the password
        actions.findElementByXpath("//input[@placeholder='Password']").sendKeys(Credentials.Invalid_Password.getKey());

        // Locate and click the 'Login' button
        actions.findElementByTagName("button").click();

        // Verify that the user alert message displayed after click on the login button login
        Assert.assertTrue(actions.findElementByXpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']").isDisplayed());

        // Verify that the current URL matches the expected URL
        Assert.assertEquals(actions.findElementByXpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']").getText(), "Invalid credentials");

        // Verify that the current URL matches the expected dashboard URL
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }


    @Test(description = "Sign In with invalid Username and Password", priority = 4)
    public void signInWithInValidUserNameAndPassword() {

        // Locate the 'Username' input field and enter 'Admin' as the username
        actions.findElementByXpath("//input[@placeholder='Username']").sendKeys("test123");

        // Locate the 'Password' input field and enter 'Test@12345' as the password
        actions.findElementByXpath("//input[@placeholder='Password']").sendKeys("test123");

        // Locate and click the 'Login' button
        actions.findElementByTagName("button").click();

        // Verify that the user alert message displayed after click on the login button login
        Assert.assertTrue(actions.findElementByXpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']").isDisplayed());

        // Verify that the current URL matches the expected URL
        Assert.assertEquals(actions.findElementByXpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']").getText(), "Invalid credentials");

        // Verify that the current URL matches the expected dashboard URL
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }


    @Test(description = "signIn With Missing UserName", priority = 5)
    public void signInWithMissingUserName() {

        // Locate the 'Username' input field and enter '' as the username
        actions.findElementByXpath("//input[@placeholder='Username']").sendKeys("");

        // Locate the 'Password' input field and enter 'Test@12345' as the password
        actions.findElementByXpath("//input[@placeholder='Password']").sendKeys(Credentials.Invalid_Password.getKey());

        // Locate and click the 'Login' button
        actions.findElementByTagName("button").click();

        // Verify that the alert message displayed below username field (Required)
        Assert.assertTrue(actions.findElementByXpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']").isDisplayed());

        // Verify that the alert message contain alert message (Required)
        Assert.assertEquals(actions.findElementByXpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']").getText(), "Required");

        // Verify that the current URL matches the expected dashboard URL
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }


    @Test(description = "signIn With Missing Password", priority = 6)
    public void signInWithMissingPassword() {

        // Locate the 'Username' input field and enter 'Admin' as the username
        actions.findElementByXpath("//input[@placeholder='Username']").sendKeys(Credentials.Valid_UserName.getKey());

        // Locate the 'Password' input field and enter '' as the password
        actions.findElementByXpath("//input[@placeholder='Password']").sendKeys("");

        // Locate and click the 'Login' button
        actions.findElementByTagName("button").click();

        // Verify that the alert message displayed below password field (Required)
        Assert.assertTrue(actions.findElementByXpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']").isDisplayed());

        // Verify that the alert message contain alert message (Required)
        Assert.assertEquals(actions.findElementByXpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']").getText(), "Required");

        // Verify that the current URL matches the expected dashboard URL
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }


    @Test(description = "signIn With Missing username and Password", priority = 7)
    public void signInWithMissingUserNameAndPassword() {

        // Locate the 'Username' input field and enter '' as the username
        actions.findElementByXpath("//input[@placeholder='Username']").sendKeys("");

        // Locate the 'Password' input field and enter '' as the password
        actions.findElementByXpath("//input[@placeholder='Password']").sendKeys("");

        // Locate and click the 'Login' button
        actions.findElementByTagName("button").click();

        // Verify that the alert message displayed below username field (Required)
        Assert.assertTrue(actions.findElementByXpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']").isDisplayed());

        // Verify that the alert message contain alert message (Required)
        Assert.assertEquals(actions.findElementByXpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']").getText(), "Required");

        // Verify that the user alert message displayed after click on the login button login
        Assert.assertTrue(actions.findElementByXpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']").isDisplayed());

        // Verify that the current URL matches the expected URL
        Assert.assertEquals(actions.findElementByXpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']").getText(), "Required");

        // Verify that the current URL matches the expected dashboard URL
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }


    @Test(description = "Verify that forget password button redirect user to the Forget password page", priority = 8)
    public void clickOnForgetPasswordButton() {

        // Locate the 'Username' input field and enter '' as the username
        actions.findElementByXpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']").click();

        // Verify that the user alert message displayed after click on the Reset button
        Assert.assertTrue(actions.findElementByXpath("//button[@type='submit']").isDisplayed());

        // Verify that the current URL matches the expected Password Reset Code URL
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode"));

    }
}
