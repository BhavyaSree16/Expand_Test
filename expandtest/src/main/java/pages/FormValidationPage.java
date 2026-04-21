package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class FormValidationPage extends BasePage {

    public FormValidationPage(WebDriver driver) {
        super(driver);
    }

    By name = By.id("validationCustom01");
    By phone = By.name("contactnumber");
    By date = By.name("pickupdate");
    By payment = By.id("validationCustom04");

    public void openFormPageDirect() {
        driver.get("https://practice.expandtesting.com/form-validation");
    }

    public void enterName(String value) {
        WebElement element = driver.findElement(name);
        element.clear();
        element.sendKeys(value);
    }

    public void enterPhone(String value) {
        WebElement element = driver.findElement(phone);
        element.clear();
        element.sendKeys(value);
    }

    public void enterDate(String value) {
        driver.findElement(date).sendKeys(value);
    }

    public void selectPayment() {
        Select select = new Select(driver.findElement(payment));
        select.selectByValue("cashondelivery");
    }
}