package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Browser {
    private static WebDriver driver;
    private static int MAX_TIMEOUT_SECOND = 20;
    private static WebDriverWait wait;
    public static Actions actions;

    public static void openBrowser(String name) {
        switch (name) {
            case "Chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "Edge": {
                driver = new EdgeDriver();
                break;
            }
            case "Safari": {
                driver = new SafariDriver();
                break;
            }
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT_SECOND));
        actions = new Actions(driver);
    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static void quit() {
        driver.quit();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void click (By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public static void fill (By locator,CharSequence... withText){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(withText);
    }

    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public static void check (By locator){
        if(!driver.findElement(locator).isSelected()) click(locator);
    }

    public static void unCheck (By locator){
        if(driver.findElement(locator).isSelected()) click(locator);
    }

    public static boolean isSelected(By locator){
        return driver.findElement(locator).isSelected();
    }

    public static void fillToNewTask(By locator,String taskName) {
        driver.findElement(locator).sendKeys(taskName + Keys.RETURN);
    }

    public static void  captureScreen(String name ){

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", name, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
