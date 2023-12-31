package Factory;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

import static core.common.ConfigKey.BASE_URL;

public class PageFactory extends BasePage {
    static WebDriver driver;

    public PageFactory(WebDriver driver) {
        super(driver);
        PageFactory.driver = driver;
    }

    public static void invokeBrowser(WebDriver driver) {
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL.getKey());
    }

    public static void waitByThreadSleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            System.err.println(
                    "Error upon calling waitByThreadSleep: line 59, WebCommon.java: "
                            + Arrays.toString(ex.getStackTrace()));
            Thread.currentThread().interrupt();
        }
    }
}
