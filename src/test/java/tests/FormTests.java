package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.FormSteps;

@Epic("Forms")
@Feature("Form Tests")
public class FormTests extends BaseTest {

    @Test(description = "Fill form and verify modal")
    @Story("Form submission")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify form is submitted and modal contains data")
    public void formTest() {

        FormSteps steps = new FormSteps(driver);

        steps.openPage()
                .fillPersonalDetails("Nino", "Martkoplishvili", "ninoM@example.com")
                .selectGender()
                .fillMobile("1234567891")
                .setBirthDate("February", "2006")
                .setSubjectAndHobby("Quantum programming")
                .setAddress("2, David Agmashenebeli Alley 13 km, 0131")
                .clickSubmit();

        String modalText = steps.getModalText();

        Assert.assertTrue(modalText.contains("Nino Martkoplishvili"));
        Assert.assertTrue(modalText.contains("ninoM@example.com"));
    }
}
