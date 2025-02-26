package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class CheckBoxTestPage {

    private By getCheckbox (String checkboxName){
        String checkboxLocator = String.format("//form[@id='checkboxes']/input[%s]", checkboxName);
        return By.xpath(checkboxLocator);
    }

    public void check(String checkboxName) {
        if (!isCheckboxSelected(checkboxName)) {
            click(getCheckbox(checkboxName));
        }
    }

    public void unCheck(String checkboxName) {
        if (isCheckboxSelected(checkboxName)) {
            click(getCheckbox(checkboxName));
        }
    }

    public boolean isCheckboxSelected(String checkboxName){
        return isSelected(getCheckbox(checkboxName));
    }

    public void open (){
      visit("https://the-internet.herokuapp.com/checkboxes");
    }
}
