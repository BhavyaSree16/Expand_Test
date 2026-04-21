package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtil;
import utils.ScreenshotUtil;
import listeners.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return ExcelUtil.getLoginData();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String type) {

        System.out.println("Running test type: " + type);

        LoginPage login = new LoginPage(driver);

        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();

        if ("valid".equalsIgnoreCase(type)) {

            System.out.println("Valid login test");

            Assert.assertTrue(login.isLoginSuccessful(), "Login failed");

            login.logout();

            Assert.assertTrue(login.isRedirectedToLogin(),
                    "Logout failed or not redirected");

        } else if ("invalid".equalsIgnoreCase(type)) {

            System.out.println("Invalid login test");

            boolean error = login.isInvalidPasswordMessageDisplayed();

            if (error) {
                ScreenshotUtil.captureScreenshot(driver, "Invalid_Login");
            }

            Assert.assertTrue(error, "Invalid password message not shown");

        } else {

            System.out.println("Empty login test");

            boolean error = login.isEmptyFieldErrorDisplayed();

            if (error) {
                ScreenshotUtil.captureScreenshot(driver, "Empty_Login");
            }

            Assert.assertTrue(error, "Empty field validation not shown");
        }
    }
}