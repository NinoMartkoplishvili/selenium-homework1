package pages;

import org.openqa.selenium.By;

public class AlertPage {

    public By alertMenu = By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a");
    public By promptButton = By.xpath("//*[@id=\"Textbox\"]/button");
    public By resultText = By.id("demo1");
}
