package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class TodoMVCTestPage {
    Actions actions;
    WebDriver driver;

    public TodoMVCTestPage(Actions actions, WebDriver driver) {
        this.actions = actions;
        this.driver = driver;
    }

    public void navigateToTodoMVC() {
        driver.get("https://todomvc.com/examples/react/dist/");
    }

    public void createNewTodo(String taskName) {
        driver.findElement(By.className("new-todo")).sendKeys(taskName + Keys.RETURN);
    }

    public String getTaskName(String taskName) {
        return getTask(taskName).getText();
    }

    public void markToComplete(String taskName) {
        getTask(taskName).findElement(By.xpath("//input[@data-testid='todo-item-toggle']")).click();
    }

    public void deleteTask(String taskName) {
        actions.moveToElement(getTask(taskName))
                .click(driver.findElement(By.xpath("//button[@class='destroy']")))
                .perform();
    }

    public int getItemLeft() {
        List<WebElement> items = driver.findElements(By.className("todo-count"));
        if (items.isEmpty()) return 0;
        String itemsLeftContext = driver.findElement(By.className("todo-count")).getText();
        return Integer.parseInt(itemsLeftContext.split("")[0]);
    }

    public WebElement getTask(String taskName) {
        List<WebElement> tasks = driver.findElements(By.xpath("//li[@data-testid='todo-item']"));
        return tasks.stream()
                .filter(task -> task.getText().equals(taskName))
                .findFirst()
                .get();
    }

    public boolean isTaskExist(String taskName) {
        List<WebElement> tasks = driver.findElements(By.xpath("//li[@data-testid='todo-item']"));
        for (WebElement task : tasks) {
            if (task.getText().equals(taskName)) {
                return true;
            }
        }
        return false;
    }

    public void updateTaskName(String taskName, String newTaskName) {
        actions.moveToElement(getTask(taskName))
                .doubleClick()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(newTaskName)
                .sendKeys(Keys.ENTER)
                .perform();

    }

}
