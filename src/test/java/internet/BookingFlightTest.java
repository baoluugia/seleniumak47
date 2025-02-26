package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class BookingFlightTest {
    /*
    * */

    @Test
    void verifyAbleSelectDepartDate() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://www.vietnamairlines.com/vn/en/home");
        driver.findElement(By.id("cookie-agree")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("roundtrip-date-depart")).click();

        driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();


        driver.findElements(By.cssSelector(".ui-datepicker-calendar"))
                .get(0)
                .findElements(By.tagName("a"))
                .stream()
                .filter(d -> d.getText().contains("28"))
                .findFirst()
                .get()
                .click();

        driver.findElement(By.className("confirm-dates")).click();
    }

}
