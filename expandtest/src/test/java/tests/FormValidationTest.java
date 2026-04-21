package tests;

import org.testng.annotations.*;

import base.BaseTest;
import pages.FormValidationPage;
import utils.ScreenshotUtil;

public class FormValidationTest extends BaseTest {

    FormValidationPage form;

    @BeforeMethod
    public void init() {

        form = new FormValidationPage(driver);
        form.openFormPageDirect();
    }

    @Test
    public void testFormFill() {

        form.enterName("bhavya");

        form.enterPhone("8919187174");

        form.enterDate("2026-05-01");

        form.selectPayment();

        ScreenshotUtil.captureScreenshot(driver, "Form_Filled");

        System.out.println("Form filled successfully");
    }
}