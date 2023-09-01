package tests;

import Factory.PageFactory;
import core.BasePage;
import core.common.Actions;
import core.pages.BuzzPage;
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

public class BuzzTest {
    WebDriver driver;
    LoginPage loginpage;
    BuzzPage buzzModulePage;
    Actions actions;


    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        buzzModulePage = new BuzzPage(driver);
        loginpage = new LoginPage(driver);
        actions = new Actions(driver);
        PageFactory.invokeBrowser(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // It ensures the browser is closed after each test method
        driver.quit();
    }

    @Test(description = "Add post at Buzz Section Valid Scenario", priority = 1)
    public void AddValidUser() {

        //Login with valid Creds
        LoginPage.ValidLogin(driver);

        // Locate and click the 'Buzz' section
        actions.findElementByXpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[12]").click();
        Assert.assertTrue(actions.expectedUrl("https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz"));

        // assert the 'UserRole' list is displayed
        Assert.assertTrue(actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div[1]/div[2]/form/div/textarea").isDisplayed());

        String postBody = "TestAutomation SequenTal Assignment " + BasePage.generateRandomText(5);
        // Click on the ESS option from the 'UserRole' list
        actions.findElementByClassName("oxd-buzz-post-input").sendKeys(postBody);

        // Close the browser session and quit the WebDriver
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div[1]/div[2]/form/div/div/button").click();

        //assert from successfully message is appeared
        Assert.assertEquals(actions.findElementByXpath("/html/body/div/div[2]/div/div[1]/div[2]/p[1]").getText(), "Success");


        // Get all post to assert on them
        List<WebElement> test = driver.findElements(By.className("orangehrm-buzz-post-body-text"));


        if (!test.isEmpty()) {

            for (WebElement element : test) {
                String elementText = element.getText();
                if (elementText.contains(postBody)) {
                    System.out.println("Found the specific text '" + postBody + "' in an element.");
                    break;
                }
            }
        } else {
            // Handle the case where there are no matching elements
            System.out.println("No matching elements found.");
        }
    }
}
