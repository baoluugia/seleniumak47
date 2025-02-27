package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.TodoMVCTestPage;

public class TodoMVCTest {
    /*
    TC11: Page Object Model- Todo MVC : Verify user able create a new todo
        Open browser
        Navigate to https://todomvc.com/examples/react/dist/
        Enter a new todo name
        Verify a todo added

    * */
    WebDriver driver;
    @Test
    void ableCreateNewTodo() {
        driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        TodoMVCTestPage todoMVCTestPage = new TodoMVCTestPage(actions, driver);

        todoMVCTestPage.navigateToTodoMVC();
        int numberItemLeftBefore = todoMVCTestPage.getItemLeft();
        String todo1 = "Write a letter for my future";
        todoMVCTestPage.createNewTodo(todo1);
        int numberItemLeftAfter = todoMVCTestPage.getItemLeft();

        Assert.assertEquals(todoMVCTestPage.getTaskName(todo1), todo1);
        Assert.assertEquals(numberItemLeftBefore, numberItemLeftAfter - 1);
    }

    @Test
    void ableMarkCompleteTodo() {
        /*
        TC12: Page Object Model- Todo MVC : Verify user able mark complete a todo
            Open browser
            Navigate to https://todomvc.com/examples/react/dist/
            Mark completed a exist todo
            Verify a todo is marked completed
        * */

        driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        TodoMVCTestPage todoMVCTestPage = new TodoMVCTestPage(actions, driver);

        todoMVCTestPage.navigateToTodoMVC();
        String todo1 = "Write a letter for my future";
        todoMVCTestPage.createNewTodo(todo1);

        int numberItemLeftBefore = todoMVCTestPage.getItemLeft();
        todoMVCTestPage.markToComplete(todo1);
        int numberItemLeftAfter = todoMVCTestPage.getItemLeft();

        Assert.assertTrue(todoMVCTestPage.getTask(todo1).getAttribute("class").contains("completed"));
        Assert.assertEquals(numberItemLeftAfter, numberItemLeftBefore - 1);
    }

    @Test
    void ableDeleteTodo() {
        /*
        TC13: Page Object Model- Todo MVC : Verify user able delete a todo
            Open browser
            Navigate to https://todomvc.com/examples/react/dist/
            Delete a exist todo
            Verify a todo deleted
        * */

        driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        TodoMVCTestPage todoMVCTestPage = new TodoMVCTestPage(actions, driver);
        todoMVCTestPage.navigateToTodoMVC();

        String todo1 = "Write a letter for my future1";
        todoMVCTestPage.createNewTodo(todo1);

        String todo2 = "Write a letter for my future2";
        todoMVCTestPage.createNewTodo(todo2);

        int sizeBefore = todoMVCTestPage.getItemLeft();

        Assert.assertTrue(todoMVCTestPage.getTask(todo1).isDisplayed());
        Assert.assertTrue(todoMVCTestPage.getTask(todo2).isDisplayed());

        todoMVCTestPage.deleteTask(todo1);

        int sizeAfter = todoMVCTestPage.getItemLeft();
        Assert.assertEquals(sizeBefore - sizeAfter , 1);
        Assert.assertFalse(todoMVCTestPage.isTaskExist(todo1));
    }

    @Test
    void ableUpdateTodoName() {
        /*
                TC14: Page Object Model- Todo MVC : Verify user able update a todo name
                    Open browser
                    Navigate to https://todomvc.com/examples/react/dist/
                    Update a existed todo name
                    Verify a todo updated name successfully
        * */
        driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        TodoMVCTestPage todoMVCTestPage = new TodoMVCTestPage(actions, driver);

        todoMVCTestPage.navigateToTodoMVC();

        String todo1 = "Write a letter for my future1";
        todoMVCTestPage.createNewTodo(todo1);

        String todo2 = "Write a letter for my future2";
        todoMVCTestPage.createNewTodo(todo2);

        String updateTaskName = "update todo1";
       todoMVCTestPage.updateTaskName(todo1,updateTaskName);

        Assert.assertTrue(todoMVCTestPage.isTaskExist(updateTaskName));
        System.out.println(todoMVCTestPage.getTask(updateTaskName).getText());

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
