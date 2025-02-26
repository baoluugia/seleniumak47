package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest {
    /*
        1.Open Chrome browser
        2. Navigate to https://the-internet.herokuapp.com/drag_and_drop
        3. Drag A and drop it to B
        4. Verify text A,B change together
    * */
    @Test
    void dragAndDropTest(){
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement sourceElement = driver.findElement(By.id("column-a"));
        WebElement targetElement = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(sourceElement,targetElement).perform();

        Assert.assertEquals(sourceElement.getText(),"B");
        Assert.assertEquals(targetElement.getText(),"A");

        System.out.println(sourceElement.getText());
        System.out.println(targetElement.getText());

        driver.quit();
    }
}
