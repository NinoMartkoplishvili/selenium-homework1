package steps;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FormPage;

import java.time.Duration;

@Epic("Forms")
@Feature("Form Tests")
public class FormSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private FormPage formPage;

    public FormSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.formPage = new FormPage();
    }

    @Step("Open form page")
    public FormSteps openPage() {
        driver.get("https://demoqa.com/automation-practice-form");
        return this;
    }

    @Step("Fill personal details")
    public FormSteps fillPersonalDetails(String first, String last, String mail) {
        driver.findElement(formPage.firstName).sendKeys(first);
        driver.findElement(formPage.lastName).sendKeys(last);
        driver.findElement(formPage.email).sendKeys(mail);
        return this;
    }

    @Step("Select gender")
    public FormSteps selectGender() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(formPage.genderFemale));
        return this;
    }

    @Step("Fill mobile")
    public FormSteps fillMobile(String number) {
        driver.findElement(formPage.mobileNumber).sendKeys(number);
        return this;
    }

    @Step("Set birth date")
    public FormSteps setBirthDate(String month, String year) {
        WebElement dobField = wait.until(ExpectedConditions.elementToBeClickable(formPage.dobInput));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dobField);

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(formPage.monthSelect))).selectByVisibleText(month);
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(formPage.yearSelect))).selectByVisibleText(year);

        WebElement dayToSelect = driver.findElement(formPage.day15);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dayToSelect);

        return this;
    }

    @Step("Set subject and hobby")
    public FormSteps setSubjectAndHobby(String subject) {
        driver.findElement(formPage.subjectsInput).sendKeys(subject);
        driver.findElement(formPage.subjectsInput).sendKeys(Keys.ENTER);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(formPage.hobbyMusic));
        return this;
    }

    @Step("Set address")
    public FormSteps setAddress(String address) {
        driver.findElement(formPage.currentAddress).sendKeys(address);
        return this;
    }

    @Step("Click Submit")
    public FormSteps clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(formPage.submitButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
        return this;
    }



    @Step("Get modal text")
    public String getModalText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(formPage.modalContent)).getText();
    }
}
