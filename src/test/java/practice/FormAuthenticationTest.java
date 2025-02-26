package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    /*

        Open browser

            Navigate to https://the-internet.herokuapp.com/login

            Fill in username with tomsmith

            Fill in the password with SuperSecretPassword!

            Click on Login button

            And the home page is appear
    * */
    @Test
    void authenticationFormTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[contains(.,Login)]")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
        System.out.println(driver.findElement(By.className("success")).getText());
    }

}
