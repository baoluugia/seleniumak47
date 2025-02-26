package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLinkTest {
    /*
    TC04: Hyper link : Hyperlink - link text

    Open browser

    Navigate to https://the-internet.herokuapp.com/status_codes

    Click on "200"

    Then "200 status code" page appear

    Click on "go here"

    Click on "301"

    Then "301 status code" page appear

    Click on "go here"

    Click on "404"

    Then "404 status code" page appear

    Click on "go here"

    Click on "500"

    Then "500 status code" page appear

    Click on "go here"
    * */

    @Test
    void verifyStatusCodeOfHyperlink(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/status_codes");
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/200");

        driver.findElement(By.linkText("here")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/301");

        driver.findElement(By.linkText("here")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/404");

        driver.findElement(By.linkText("here")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/500");

//        driver.findElement(By.linkText("here")).click();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");

//        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));
        Assert.assertTrue(driver.findElement(By.className("example")).getText().contains("This page returned a 500 status code."));
        System.out.println(driver.findElement(By.className("example")).getText());

        driver.quit();

    }
}
