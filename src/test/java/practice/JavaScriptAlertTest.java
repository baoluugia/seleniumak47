package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlertTest {

    /*
    *  Login successful with valid credentials
            Open browser

            Navigate to https://the-internet.herokuapp.com/javascript_alerts

            When click on "Click For JS Alert" button

            Then the Popup is displayed.
    * */
    WebDriver driver;
    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");    }

    @Test
    void ableCloseAlert(){

        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You successfully clicked an alert"));
    }

    @Test
    void ableCloseConfirm(){

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You clicked: Ok"));

    }

    @Test
    void ableCancelConfirm(){

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You clicked: Cancel"));

    }

    @Test
    void ableInputToPrompt(){

        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You entered: Hello"));

    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }


}
