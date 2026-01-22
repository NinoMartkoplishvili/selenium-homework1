package steps;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommandsPage;

import java.time.Duration;

@Epic("Commands")
@Feature("Commands Tests")
public class CommandsSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private CommandsPage commandsPage;

    public CommandsSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.commandsPage = new CommandsPage();
    }

    @Step("Open dynamic controls page")
    public void openDynamicControls() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Step("Click Enable button")
    public void clickEnable() {
        WebElement enableBtn = wait.until(ExpectedConditions.elementToBeClickable(commandsPage.enableButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", enableBtn);
    }


    @Step("Check input enabled")
    public boolean isInputEnabled() {
        return wait.until(ExpectedConditions.elementToBeClickable(commandsPage.inputField)).isEnabled();
    }

    @Step("Get message text")
    public String getMessageText() {
        return driver.findElement(commandsPage.messageText).getText();
    }

    @Step("Check button changed to Disable")
    public boolean isButtonDisable() {
        return driver.findElement(commandsPage.disableButton).isDisplayed();
    }

    @Step("Fill input")
    public void fillInput(String text) {
        driver.findElement(commandsPage.inputField).sendKeys(text);
    }

    @Step("Clear input")
    public void clearInput() {
        driver.findElement(commandsPage.inputField).clear();
    }

    @Step("Open drag and drop page")
    public void openDragAndDrop() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
    }

    @Step("Check columns aligned by Y")
    public boolean areColumnsAligned() {
        WebElement colA = driver.findElement(commandsPage.columnA);
        WebElement colB = driver.findElement(commandsPage.columnB);

        int yA = colA.getLocation().getY();
        int yB = colB.getLocation().getY();

        return yA == yB;
    }
}
