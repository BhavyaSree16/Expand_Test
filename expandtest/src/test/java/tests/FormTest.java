package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.FormPage;
import utils.ScreenshotUtil;

public class FormTest extends BaseTest {

    FormPage form;

    @BeforeMethod
    public void setupForm() {

        driver.get("https://practice.expandtesting.com/form");

        form = new FormPage(driver);
    }

    // TEST 1: Text Input
    
    @Test
    public void testTextInputs() {

        form.enterText("Bhavya");

        String value = form.getEnteredText();

        if (!value.equals("Bhavya")) {
            ScreenshotUtil.captureScreenshot(driver, "Text_Input_Failed");
        }

        Assert.assertEquals(value, "Bhavya");
    }

    
    // TEST 2: Dropdown
    @Test
    public void testDropdown() {

        form.selectDropdown("Option 1");

        String selected = form.getSelectedDropdown();

        if (!selected.equals("Option 1")) {
            ScreenshotUtil.captureScreenshot(driver, "Dropdown_Failed");
        }

        Assert.assertEquals(selected, "Option 1");
    }

    
    //  TEST 3: Checkbox
    
    @Test
    public void testCheckbox() {

        form.checkCheckbox(form.getCheckbox1());

        boolean checked = form.isCheckboxSelected(form.getCheckbox1());

        if (!checked) {
            ScreenshotUtil.captureScreenshot(driver, "Checkbox_Check_Failed");
        }

        Assert.assertTrue(checked);

        form.uncheckCheckbox(form.getCheckbox1());

        boolean unchecked = form.isCheckboxSelected(form.getCheckbox1());

        if (unchecked) {
            ScreenshotUtil.captureScreenshot(driver, "Checkbox_Uncheck_Failed");
        }

        Assert.assertFalse(unchecked);
    }

    
    // TEST 4: Radio Button
    
    @Test
    public void testRadioButtons() {

        form.selectRadio(form.getRadio1());

        boolean firstSelected = form.isRadioSelected(form.getRadio1());
        boolean secondSelected = form.isRadioSelected(form.getRadio2());

        if (!firstSelected || secondSelected) {
            ScreenshotUtil.captureScreenshot(driver, "Radio_Failed");
        }

        Assert.assertTrue(firstSelected);
        Assert.assertFalse(secondSelected);
    }
}