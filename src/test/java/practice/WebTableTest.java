package practice;

import internet.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableTest {

    /*
        Web Table: Validate largest due person from a table
            Open browser
            Navigate to https://the-internet.herokuapp.com/tables
            Focus on table 1
            The person who has largest due is "Doe Jacson"
    * */

    @Test
    void validateLargestDuePerson() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Double> dueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cell -> Double.parseDouble(cell.getText().replace("$", " ")))
                .collect(Collectors.toList());

        dueValue.forEach(e -> System.out.println(dueValue));
        Double maxDueValue = dueValue.stream().max(Comparator.naturalOrder()).get();
        System.out.println(maxDueValue);

        int maxDueValueIndex = dueValue.indexOf(maxDueValue);
        System.out.println("Index of max due value is " + maxDueValueIndex);

        String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]", maxDueValueIndex + 1))).getText();
        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]", maxDueValueIndex + 1))).getText();

        Assert.assertEquals(String.format("%s %s", lastName, firstName), "Doe Jason");
        System.out.println(String.format("%s %s", lastName, firstName));
        driver.quit();
    }

    @Test
    void tc05() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<Person> person = new ArrayList<>();
        //read data from web
        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).forEach(
                row -> {
                    System.out.println(row.getText());
                    String[] rowContent = row.getText().split(" ");
                    person.add(new Person(rowContent[0], rowContent[1], rowContent[3]));
                }
        );

        String maxDuePerson = person.stream().max(Comparator.comparing(Person::getDue)).get().getFullName();
        Assert.assertEquals(maxDuePerson, "Doe Jason");

        driver.quit();
    }
}
