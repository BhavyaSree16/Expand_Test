package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.FormInteractionsPage;
import utils.ScreenshotUtil;

public class FormInteractionsTest extends BaseTest {

    FormInteractionsPage form;

    @BeforeMethod
    public void init() {

        form = new FormInteractionsPage(driver);
        form.openRadioPageDirect();
    }

    @Test
    public void testRadioButtons() {

        boolean greenClicked = form.clickGreenRadio();

        if (!greenClicked) {
            ScreenshotUtil.captureScreenshot(driver, "Green_Disabled");
        }

        form.selectFootball();

        boolean result = form.isFootballSelected();

        if (!result) {
            ScreenshotUtil.captureScreenshot(driver, "Football_Failed");
        }

        Assert.assertTrue(result, "Football not selected");
    }
}