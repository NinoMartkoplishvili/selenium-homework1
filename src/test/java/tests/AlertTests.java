package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.AlertSteps;

@Epic("Alerts")
@Feature("Alert Tests")
public class AlertTests extends BaseTest {

    @Test(description = "Prompt alert test")
    @Story("Alert prompt")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify alert prompt accepts text")
    public void alertTest() {

        AlertSteps steps = new AlertSteps(driver);

        steps.openPage();
        steps.openPromptAlert();
        steps.enterTextAndAccept("Nino Martkoplishvili");

        String result = steps.getResultText();

        Assert.assertTrue(result.contains("Nino Martkoplishvili"));
    }
}
