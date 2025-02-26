package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BodyMassIndexTestPage;

import static supports.Browser.openBrowser;

public class BodyMassIndexTest {
    /*
    TC10: Page Object Model - Body Mass Index Page
        Open browser
            Navigate to https://www.calculator.net/bmi-calculator.html
            Select metric unit tab
            Fill calculator with age, gender, weight, height
            Validate result is correct
    * */
    BodyMassIndexTestPage bodyMassIndexTestPage;

    @Test
    void bodyMassIndexCalculator() {

        openBrowser("Chrome");
        bodyMassIndexTestPage = new BodyMassIndexTestPage();
        bodyMassIndexTestPage.open();

        bodyMassIndexTestPage.fillForm("20", "male", 170, 65);

        String actualResult = bodyMassIndexTestPage.calculatorBMI(170, 65);
        String expectResult = bodyMassIndexTestPage.getResult();

        Assert.assertEquals(expectResult,actualResult);
        System.out.println(actualResult);
    }
}

