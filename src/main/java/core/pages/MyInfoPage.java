package core.pages;

import core.BasePage;
import core.common.Actions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyInfoPage extends BasePage {


    public MyInfoPage(WebDriver driver) {
        super(driver);
    }


    public static void validAddImmigrationAttachment(WebDriver driver)   {
        Actions actions = new Actions(driver);

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
}
