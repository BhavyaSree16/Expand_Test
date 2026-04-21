package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseTest;
import pages.NotesLoginPage;
import pages.NotesPage;
import utils.ConfigReader;
import utils.ScreenshotUtil;

import java.time.Duration;

public class NotesTest extends BaseTest {

    WebDriverWait wait;
    NotesPage notes;

    By notesLoginBtn = By.xpath("//a[@href='/notes/app/login']");

    String title = "Test Note";
    String desc = "First Description";
    String updatedTitle = "bhavyasreekasa";

    @BeforeMethod
    public void setupNotes() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://practice.expandtesting.com/notes/app");

        WebElement loginBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(notesLoginBtn));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", loginBtn);

        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));

        try {
            loginBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", loginBtn);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        NotesLoginPage login = new NotesLoginPage(driver);

        login.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );

        Assert.assertTrue(login.isLoginSuccessful(), "Login failed");

        wait.until(ExpectedConditions.urlContains("notes"));

        notes = new NotesPage(driver);
    }

    // CREATE
    @Test
    public void createNoteTest() {

        notes.createNote(title, desc, "Home");

        boolean result = notes.isNotePresent(title);

        if (!result) {
            ScreenshotUtil.captureScreenshot(driver, "Create_Failed");
        }

        Assert.assertTrue(result);
    }

    // EDIT
    @Test(dependsOnMethods = "createNoteTest")
    public void editNoteTest() {

        notes.editFirstCard(updatedTitle);

        boolean result = notes.isNotePresent(updatedTitle);

        if (!result) {
            ScreenshotUtil.captureScreenshot(driver, "Edit_Failed");
        }

        Assert.assertTrue(result);
    }

    // DELETE
    @Test(dependsOnMethods = "editNoteTest")
    public void deleteNoteTest() {

        notes.deleteFirstCard(updatedTitle);

        boolean result = notes.isNotePresent(updatedTitle);

        if (result) {
            ScreenshotUtil.captureScreenshot(driver, "Delete_Failed");
        }

        Assert.assertFalse(result);
    }
}