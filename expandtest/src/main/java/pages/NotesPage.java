package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import base.BasePage;

public class NotesPage extends BasePage {

    public NotesPage(WebDriver driver) {
        super(driver);
    }

    // Buttons
    By addNoteBtn = By.xpath("//button[contains(text(),'Add')]");
    By homeCategoryBtn = By.xpath("//button[@data-testid='category-home']");
    By saveBtn = By.xpath("//button[@data-testid='note-submit']");

    // Fields
    By titleField = By.id("title");
    By descField = By.id("description");
    By categoryDropdown = By.id("category");

    // Modal
    By modal = By.xpath("//div[@role='dialog' and contains(@class,'show')]");

    // Card elements
    By firstCard = By.xpath("(//div[@data-testid='note-card'])[1]");
    By editBtn = By.xpath("(//div[@data-testid='note-card'])[1]//button[@data-testid='note-edit']");
    By deleteBtn = By.xpath("(//div[@data-testid='note-card'])[1]//button[@data-testid='note-delete']");

    // CREATE
    public void createNote(String title, String desc, String category) {

        click(addNoteBtn);

        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

        sendKeys(titleField, title);
        sendKeys(descField, desc);

        new Select(driver.findElement(categoryDropdown))
                .selectByVisibleText(category);

        WebElement createBtn = driver.findElement(saveBtn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", createBtn);
    }

    // CLICK HOME
    public void clickHomeCategory() {

        WebElement home = wait.until(
                ExpectedConditions.elementToBeClickable(homeCategoryBtn));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", home);
    }

    // SELECT CARD
    public void selectFirstCard() {

        WebElement card = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstCard));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", card);
    }

    // EDIT
    public void editFirstCard(String newTitle) {

        clickHomeCategory();
        selectFirstCard();

        WebElement edit = wait.until(
                ExpectedConditions.elementToBeClickable(editBtn));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", edit);

        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

        WebElement title = driver.findElement(titleField);
        title.clear();
        title.sendKeys(newTitle);

        WebElement save = driver.findElement(saveBtn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", save);
    }

    // DELETE (FINAL FIXED)
    public void deleteFirstCard(String textToDelete) {

        System.out.println("Deleting first card");

        // Go to Home
        clickHomeCategory();

        // Wait for card
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstCard));

        // Click delete
        WebElement delete = wait.until(
                ExpectedConditions.elementToBeClickable(deleteBtn));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", delete);

        // Handle alert (if any)
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted");
        } catch (Exception e) {
            System.out.println("No alert present");
        }

        // Refresh to sync UI
        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(homeCategoryBtn));
    }

    // VERIFY
    public boolean isNotePresent(String text) {
        return driver.getPageSource().contains(text);
    }
}