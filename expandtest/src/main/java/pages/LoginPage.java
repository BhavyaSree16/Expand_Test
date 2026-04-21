package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By errorMsg = By.id("flash");
    By logoutBtn = By.xpath("//a[@href='/logout']");

    public void enterUsername(String user) {
        if (user != null && !user.isEmpty()) {
            System.out.println("Entering username: " + user);
            sendKeys(username, user);
        } else {
            System.out.println("Username is empty");
        }
    }

    public void enterPassword(String pass) {
        if (pass != null && !pass.isEmpty()) {
            System.out.println("Entering password");
            sendKeys(password, pass);
        } else {
            System.out.println("Password is empty");
        }
    }

    public void clickLogin() {

        System.out.println("Clicking login button");

        try {

            driver.findElement(loginBtn).click();

        } catch (Exception e) {

            System.out.println("Normal click failed we are using JavaScript click");

            org.openqa.selenium.JavascriptExecutor js =
                    (org.openqa.selenium.JavascriptExecutor) driver;

            js.executeScript("arguments[0].click();", driver.findElement(loginBtn));
        }
    }

    public boolean isLoginSuccessful() {
        boolean status = driver.getCurrentUrl().contains("secure");
        System.out.println("Login success status: " + status);
        return status;
    }

    public void logout() {
        try {
            System.out.println("Attempting logout");
            click(logoutBtn);
            System.out.println("Logout clicked");
        } catch (Exception e) {
            System.out.println("Normal click failed, using JS click");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(logoutBtn));
        }
    }

    public boolean isRedirectedToLogin() {
        boolean status = driver.getCurrentUrl().contains("login");
        System.out.println("Redirected to login page: " + status);
        return status;
    }

    public boolean isInvalidPasswordMessageDisplayed() {
        try {
            if (driver.findElements(errorMsg).size() > 0) {
                String msg = driver.findElement(errorMsg).getText();
                System.out.println("Flash message: " + msg);
                return msg.contains("Your password is invalid!");
            }
        } catch (Exception e) {
            System.out.println("Error checking invalid password message");
        }
        return false;
    }

    public boolean isEmptyFieldErrorDisplayed() {
        try {
            if (driver.findElements(errorMsg).size() > 0) {
                String msg = driver.findElement(errorMsg).getText();
                System.out.println("Flash message: " + msg);
                return msg.length() > 0;
            }
        } catch (Exception e) {
            System.out.println("No error message found");
        }
        return false;
    }
}