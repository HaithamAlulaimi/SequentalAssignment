package core.common;

import core.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IRetryAnalyzer;

import java.time.Duration;

public class Actions extends BasePage {
    WebDriverWait wait;
    WebDriver driver;

    public Actions(WebDriver driver) {
        super(driver);
        this.driver = driver;
        WebDriverManager.firefoxdriver().setup();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void visit(String url) {
        driver.get(url);
        wait.until(webDriver -> {
            String readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
            return "complete".equalsIgnoreCase(readyState);
        });
    }


    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean expectedUrl(String expectedURL) {
        try {
            wait.until(ExpectedConditions.urlToBe(expectedURL));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();

        }
        return false;
    }

    public WebElement findElementById(String id) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();

        }
        return driver.findElement(By.id(id));
    }

    public WebElement findElementByClassName(String className) {

        return driver.findElement(By.className(className));
    }

    public WebElement findElementByXpath(String xpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();
        }
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement findElementByName(String name) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();

        }
        return driver.findElement(By.name(name));
    }

    public WebElement findElementByTagName(String TagName) {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(TagName)));
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();

        }
        return driver.findElement(By.tagName(TagName));
    }

    public WebElement findElementByCssSelector(String cssSelector) {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();

        }
        return driver.findElement(By.tagName(cssSelector));
    }


    public void quit() {
        driver.quit();
    }
}
