package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class BodyMassIndexTestPage {

    private String BASE_URL = "https://www.calculator.net/bmi-calculator.html";
    private By metricTab = By.cssSelector("li#menuon a");
    private By ageTextBox = By.xpath("//table[@id='calinputtable']//input");
    private By maleRadioButton = By.xpath("//table[@id='calinputtable']//label[text()='Male']");
    private By femaleRadioButton = By.xpath("//table[@id='calinputtable']//label[text()='Female']");
    private By heightTextBox = By.xpath("//table[@id='metricheightweight']//input[@id='cheightmeter']");
    private By weightTextBox = By.xpath("//table[@id='metricheightweight']//input[@id='ckg']");
    private By submitButton = By.xpath("//input[@type='submit']");
    private By resultBMI = By.xpath("//div[@class='bigtext']/b");



    public void open() {
        visit(BASE_URL);
    }

    public void selectMetricTab() {
        click(metricTab);
    }

    public void fillForm(String age, String gender, double height, double weight) {
        fill(ageTextBox, age);
        if (gender.equalsIgnoreCase("male")) {
            click(maleRadioButton);
        } else {
            click(femaleRadioButton);
        }
        fill(heightTextBox,String.valueOf(height));
        fill(weightTextBox,String.valueOf(weight));

        click(submitButton);
    }

    public String calculatorBMI(double height, double weight) {
        double BMI = Math.round((weight / Math.pow((height / 100), 2)) * 10.0) / 10.0;
//        String BMIResult = String.format("BMI = %s kg/m2", BMI);
        return String.format("BMI = %s kg/m2", BMI);
    }

    public String getResult() {
        return getText(resultBMI);
    }
}
