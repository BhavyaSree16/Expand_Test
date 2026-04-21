package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.AlertsPage;
import utils.ScreenshotUtil;

public class AlertsTest extends BaseTest {

    AlertsPage alert;

    @BeforeMethod
    public void init() {
        alert = new AlertsPage(driver);
        alert.openAlertPage();
    }

    @Test
    public void testCookieAlertAndHomeNavigation() {

        alert.acceptCookies();

        alert.clickHome();

        boolean result = alert.isHomePage();

        if (!result) {
            ScreenshotUtil.captureScreenshot(driver, "Home_Navigation_Failed");
        }

        Assert.assertTrue(result, "Not navigated to Home page");
    }
}