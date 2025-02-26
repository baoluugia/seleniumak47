package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingFlightTest {

    /*
            /**
     * Open Chrome
     * Navigate https://www.vietnamairlines.com/vn/en/home
     * Select Depart date is 10/1/2025
     * Verify Depart Date value is 10/1/2025
     */
    @Test
    void bookingFlightTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.vietnamairlines.com/vn/en/home");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='cookie-agree']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='roundtrip-date-depart']")).click();
        driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']"))
                .get(0)
                .findElements(By.tagName("a"))
                .stream()
                .filter(d -> d.getText().contains("28"))
                .findAny()
                .get()
                .click();

        driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']"))
                .get(1)
                .findElements(By.tagName("a"))
                .stream()
                .filter(d -> d.getText().contains("4"))
                .findFirst()
                .get()
                .click();

        driver.findElement(By.xpath("//button[@class='datepicker-ctrl confirm-dates']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='roundtrip-date-depart']")).getDomProperty("value"),"28/02/2025");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='roundtrip-date-return']")).getDomProperty("value"),"04/03/2025");

        driver.quit();
    }
}
