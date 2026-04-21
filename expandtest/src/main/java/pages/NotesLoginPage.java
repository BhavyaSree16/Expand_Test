package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class NotesLoginPage extends BasePage {

    public NotesLoginPage(WebDriver driver) {
        super(driver);
    }

    By email = By.id("email");
    By password = By.id("password");
    By loginBtn = By.xpath("//button[@type='submit']");

    public void login(String user, String pass) {

        System.out.println("Logging in...");

        sendKeys(email, user);
        sendKeys(password, pass);

        WebElement btn = driver.findElement(loginBtn);

        try {
            btn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", btn);
        }
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("notes");
    }
}