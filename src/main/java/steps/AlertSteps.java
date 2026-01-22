package steps;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AlertPage;

import java.time.Duration;

@Epic("Alerts")
@Feature("Alert Tests")
public class AlertSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private AlertPage alertPage;

    public AlertSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.alertPage = new AlertPage();
    }

    @Step("Open alert page")
    public void openPage() {
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }

    @Step("Open prompt alert")
    public void openPromptAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(alertPage.alertMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(alertPage.promptButton)).click();
    }

    @Step("Enter text in alert and accept")
    public void enterTextAndAccept(String text) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    @Step("Get result text")
    public String getResultText() {
        return driver.findElement(alertPage.resultText).getText();
    }
}
