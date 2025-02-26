package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {
    /*
         Checkboxes : Check to a box
            Open browser

            Navigate to https://the-internet.herokuapp.com/checkboxes

            Check on checkbox1

            Verify checkbox1 is checked

            Check on checkbox2

            Verify checkbox2 is checked
    * */
    @Test
    void theCheckboxesShouldSelectedTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        Assert.assertFalse( driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());
        Assert.assertTrue( driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected());

        WebElement checkbox1 =  driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        check(checkbox1);
        Assert.assertTrue((checkbox1).isSelected());

        WebElement checkbox2 =  driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        check(checkbox2);
        Assert.assertTrue((checkbox2).isSelected());
    }

    @Test
    void theCheckboxesShouldDeSelectedTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 =  driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 =  driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        Assert.assertFalse( driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected());
        Assert.assertTrue( driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected());

        checkbox1.click();
        Assert.assertTrue((checkbox1).isSelected());

        checkbox2.click();
        Assert.assertTrue((checkbox2).isSelected());
    }


    void check(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    void uncheck(WebElement checkbox) {
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }
}

