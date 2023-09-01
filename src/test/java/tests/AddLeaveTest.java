package tests;

import Factory.PageFactory;
import core.BasePage;
import core.common.Actions;
import core.common.CommonMethods;
import core.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddLeaveTest {
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

    @Test(description = "Add user leave valid scenario", priority = 1)
    public void addUserLeaveWithValidFData() {

        //Login with valid Creds
        LoginPage.ValidLogin(driver);

        // Locate and click the 'Leave' section
        actions.findElementByXpath("//span[normalize-space()='Leave']").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList"));

        // Locate and send from date [2022-01-01].
        actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input").clear();
        actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input").sendKeys("2022-01-01");

        // Locate and send to date [2023-09-01].
        actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input").clear();
        actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input").sendKeys("2022-01-01");

        // Locate and click the 'Search' button
        actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[3]/div/label/span").click();

        // Locate and click the 'Include Past Employees' trigger
        actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[3]/button[2]").click();


        // Get all post to assert on them
        WebElement approveButton = driver.findElement(By.className("oxd-button--label-success"));
        approveButton.click();

        //assert from successfully message is appeared
        Assert.assertEquals(actions.findElementByXpath("/html/body/div/div[2]/div/div[1]/div[2]/p[1]").getText(), "Success");

    }
}
