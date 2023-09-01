package core.pages;

import core.BasePage;
import core.common.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddLeavePage extends BasePage {

    public AddLeavePage(WebDriver driver) {
        super(driver);
    }

    public static void validAddUser(WebDriver driver) {
        Actions actions = new Actions(driver);
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
