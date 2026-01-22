package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage {

    WebDriver driver;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By enableButton = By.xpath("//button[text()='Enable']");
    private By inputField = By.xpath("//input[@type='text']");
    private By message = By.id("message");

    public void open() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    public void clickEnable() {
        driver.findElement(enableButton).click();
    }

    public boolean isInputEnabled() {
        return driver.findElement(inputField).isEnabled();
    }

    public String getMessageText() {
        return driver.findElement(message).getText();
    }

    public String getButtonText() {
        return driver.findElement(enableButton).getText();
    }

    public void typeText(String text) {
        driver.findElement(inputField).sendKeys(text);
    }

    public void clearText() {
        driver.findElement(inputField).clear();
    }
}
