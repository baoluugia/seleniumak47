package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class WebTableTest {
    /*
            TC05: Web Table: Validate largest due person from a table
                Open browser

                Navigate to https://the-internet.herokuapp.com/tables

                Focus on table 1

                The person who has largest due is "Doe Jason"
    * */
    List<Person> person;
    WebDriver driver;
    @BeforeClass
    void readData(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        person = new ArrayList<>();
        //read data from web
        driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(
                        row -> {
                            String[] rowContent = row.getText().split(" ");
                            person.add(new Person(rowContent[0],rowContent[1],rowContent[3]));
                        }
                );
    }

//    @BeforeMethod
//    void setup(){
//    }

    @Test
    void verifyMaximumDueValuePerson() {

        Double maxDueValue = person
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get()
                .getDue();

        List<String> maxDuePersonList = person
                .stream()
                .filter(maxDuePerSon ->Objects.equals(maxDuePerSon.getDue(),maxDueValue))
                .map(Person::getFullName)
                .toList();

        Assert.assertEquals(maxDuePersonList,List.of("Doe Jason"));
        System.out.println(maxDuePersonList);

//        driver.quit();
    }

    @Test
    void verifyMinimumDueValuePerson() {

        Double minDueValue = person
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .get()
                .getDue();

        List<String> minDuePersonList = person
                .stream()
                .filter(minDuePerson -> Objects.equals(minDuePerson.getDue(), minDueValue))
                .map(Person::getFullName)
                .toList();

        Assert.assertEquals(minDuePersonList, List.of("Smith John", "Conway Tim"));
        System.out.println(minDuePersonList);

//        driver.quit();
    }

    @AfterMethod
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
