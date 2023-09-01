package core.common;

import core.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class CommonMethods extends BasePage {

    WebDriverWait wait;
    WebDriver driver;

    public CommonMethods(WebDriver driver) {
        super(driver);
    }


    public static void waitByThreadSleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException ex) {
            System.err.println(
                    "Error upon calling waitByThreadSleep: line 59, WebCommon.java: "
                            + Arrays.toString(ex.getStackTrace()));
            Thread.currentThread().interrupt();
        }
    }
}
