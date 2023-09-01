package core.pages;

import core.BasePage;
import core.common.Actions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BuzzPage extends BasePage {


    public BuzzPage(WebDriver driver) {
        super(driver);

    }

    public static void validBuzzPost(WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);

        // Locate and click the 'Admin' section
        actions.findElementByXpath("//span[normalize-space()='Admin']").click();
        Assert.assertEquals(actions.currentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        // Locate and click the 'Add' button
        actions.findElementByXpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']").click();
        Assert.assertEquals(actions.currentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser");

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

        // Locate the 'Employee Name' input field and enter 'Haitham Alulaimi' as the name
        actions.findElementByXpath("//input[@placeholder='Type for hints...']").sendKeys("h");
        Thread.sleep(5000);

        // Locate the parent <div> element with role="listbox"
        actions.findElementByXpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").isDisplayed();

        // Click on the enable optiaon from the 'Status' list
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]").click();


        // Locate the 'Username' input field and enter 'Haitham' as the Username
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]").sendKeys(BasePage.generateRandomText(10));

        // Locate the 'Username' input field and enter 'Password' as the password
        actions.findElementByXpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]").sendKeys("Test@123456");

        // Locate the 'Username' input field and enter 'Confirm Password' as the password
        actions.findElementByXpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input").sendKeys("Test@123456");

        // Locate and click the 'save' button
        actions.findElementByXpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]").click();


        //assert from successfully message is appeared
        Assert.assertEquals(actions.findElementByXpath("/html/body/div/div[2]/div/div[1]/div[2]/p[1]").getText(), "Success");

    }
}
