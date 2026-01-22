package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.CommandsSteps;

@Epic("Commands")
@Feature("Commands Tests")
public class CommandsTests extends BaseTest {

    @Test(description = "Dynamic controls and drag and drop test")
    @Story("Dynamic controls + Drag and drop")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify enable/disable and columns alignment")
    public void commandsTest() {

        CommandsSteps steps = new CommandsSteps(driver);

        steps.openDynamicControls();
        steps.clickEnable();

        Assert.assertTrue(steps.isInputEnabled());
        Assert.assertTrue(steps.getMessageText().contains("It's enabled!"));

        Assert.assertTrue(steps.isButtonDisable());

        steps.fillInput("Bootcamp");
        steps.clearInput();

        steps.openDragAndDrop();
        Assert.assertTrue(steps.areColumnsAligned());
    }
}
