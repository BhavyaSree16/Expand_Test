package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
    }

    // Text Fields
    By inputField1 = By.xpath("//input[@type='text']");
    
    // Dropdown
    By dropdown = By.tagName("select");

    // Checkboxes
    By checkbox1 = By.xpath("(//input[@type='checkbox'])[1]");
    By checkbox2 = By.xpath("(//input[@type='checkbox'])[2]");

    // Radio Buttons
    By radio1 = By.xpath("(//input[@type='radio'])[1]");
    By radio2 = By.xpath("(//input[@type='radio'])[2]");

    
    // TEXT INPUT
    
    public void enterText(String text) {
        sendKeys(inputField1, text);
    }

    public String getEnteredText() {
        return driver.findElement(inputField1).getAttribute("value");
    }

    
    // DROPDOWN
   
    public void selectDropdown(String value) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(value);
    }

    public String getSelectedDropdown() {
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }

    
    // CHECKBOX
   
    public void checkCheckbox(By checkbox) {
        WebElement cb = driver.findElement(checkbox);
        if (!cb.isSelected()) {
            cb.click();
        }
    }

    public void uncheckCheckbox(By checkbox) {
        WebElement cb = driver.findElement(checkbox);
        if (cb.isSelected()) {
            cb.click();
        }
    }

    public boolean isCheckboxSelected(By checkbox) {
        return driver.findElement(checkbox).isSelected();
    }

    public By getCheckbox1() { return checkbox1; }
    public By getCheckbox2() { return checkbox2; }

    
    // RADIO BUTTON
   
    public void selectRadio(By radio) {
        driver.findElement(radio).click();
    }

    public boolean isRadioSelected(By radio) {
        return driver.findElement(radio).isSelected();
    }

    public By getRadio1() { return radio1; }
    public By getRadio2() { return radio2; }
}