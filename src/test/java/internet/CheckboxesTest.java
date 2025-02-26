package internet;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxTestPage;

import static supports.Browser.*;

public class CheckboxesTest {
    CheckBoxTestPage checkBoxTestPage;

    @BeforeMethod
    void reloadPage() {
        openBrowser("Chrome");
        checkBoxTestPage = new CheckBoxTestPage();
        checkBoxTestPage.open();

    }
    @Test
    void theCheckboxesShouldSelected() {

        checkBoxTestPage.check("1");
        Assert.assertTrue(checkBoxTestPage.isCheckboxSelected("1"));

        checkBoxTestPage.check("2");
        Assert.assertTrue(checkBoxTestPage.isCheckboxSelected("2"));
    }

    @Test
    void theCheckboxesShouldDeSelected() {

        checkBoxTestPage.unCheck("1");
        Assert.assertFalse(checkBoxTestPage.isCheckboxSelected("1"));

        checkBoxTestPage.unCheck("2");
        Assert.assertFalse(checkBoxTestPage.isCheckboxSelected("2"));
    }

    @AfterMethod
    void tearDown() {
        quit();
    }
}