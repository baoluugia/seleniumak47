package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrameTest {

    /*
    *
            Open browser

            Navigate to https://the-internet.herokuapp.com/nested_frames

            Verify Text present:
            * */

    @Test
    void nestedFrameTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "LEFT");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Assert.assertEquals(driver.findElement(By.id("content")).getText(), "MIDDLE");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "RIGHT");

        driver.switchTo().alert();
        driver.switchTo().frame("frame-bottom");
        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "BOTTOM");

        driver.quit();
    }
}
