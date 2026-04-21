package pages;

import org.openqa.selenium.*;

import base.BasePage;

public class FormInteractionsPage extends BasePage {

    public FormInteractionsPage(WebDriver driver) {
        super(driver);
    }

    By greenRadio = By.id("green");
    By footballRadio = By.id("football");

    public void openRadioPageDirect() {
        driver.get("https://practice.expandtesting.com/radio-buttons");
    }

    public boolean clickGreenRadio() {

        WebElement green = driver.findElement(greenRadio);

        if (!green.isEnabled()) {
            System.out.println("Green is disabled");
            return false;
        }

        green.click();
        return true;
    }

    public void selectFootball() {

        WebElement football = driver.findElement(footballRadio);

        if (!football.isSelected()) {
            football.click();
        }
    }

    public boolean isFootballSelected() {
        return driver.findElement(footballRadio).isSelected();
    }
}