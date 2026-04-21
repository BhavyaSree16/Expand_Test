package pages;

import org.openqa.selenium.*;

import base.BasePage;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    By acceptCookiesBtn = By.id("acceptCookies");
    By homeBtn = By.xpath("//a[@href='/']");

    public void openAlertPage() {
        driver.get("http://practice.expandtesting.com/cookie-alert#google_vignette");
    }

    public void acceptCookies() {

        try {
            driver.findElement(acceptCookiesBtn).click();
            System.out.println("Cookies accepted");
        } catch (Exception e) {
            System.out.println("Cookie popup not displayed");
        }
    }

    public void clickHome() {
        driver.findElement(homeBtn).click();
    }

    public boolean isHomePage() {
        return driver.getCurrentUrl().equals("https://practice.expandtesting.com/");
    }
}