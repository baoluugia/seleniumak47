package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverElementTest {
    /*
    *        Hover elements

                Open browser

                Navigate to https://the-internet.herokuapp.com/hovers

                When user hover on user 1 avatar

                Then the "name: user1" label is present.
    * */

    @Test
    void hoverVerifyUserName(){
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/hovers");

        actions.moveToElement(driver.findElement(By.xpath("//div[@class='figure'][1]"))).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='figure'][1]/div[@class='figcaption']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//div[@class='figure'][1]/div[@class='figcaption']")).getText());


    }
}
