package pages;

import org.openqa.selenium.By;

public class FormPage {

    public By firstName = By.id("firstName");
    public By lastName = By.id("lastName");
    public By email = By.id("userEmail");
    public By genderFemale = By.cssSelector("label[for='gender-radio-2']");
    public By mobileNumber = By.id("userNumber");

    public By dobInput = By.id("dateOfBirthInput");
    public By monthSelect = By.className("react-datepicker__month-select");
    public By yearSelect = By.className("react-datepicker__year-select");
    public By day15 = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--015']");

    public By subjectsInput = By.id("subjectsInput");
    public By hobbyMusic = By.cssSelector("label[for='hobbies-checkbox-3']");

    public By currentAddress = By.id("currentAddress");
    public By submitButton = By.id("submit");

    public By modalContent = By.className("modal-content");
}
