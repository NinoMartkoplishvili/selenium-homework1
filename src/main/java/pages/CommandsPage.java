package pages;

import org.openqa.selenium.By;

public class CommandsPage {
    public By enableButton = By.xpath("//button[contains(text(),'Enable')]");
    public By disableButton = By.xpath("//button[contains(text(),'Disable')]");

    public By inputField = By.cssSelector("#input-example input");
    public By messageText = By.id("message");
    public By columnA = By.id("column-a");
    public By columnB = By.id("column-b");
}