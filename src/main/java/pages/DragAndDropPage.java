package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage {

    WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    private By columnA = By.id("column-a");
    private By columnB = By.id("column-b");

    public void open() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
    }

    public int getColumnAY() {
        return driver.findElement(columnA).getLocation().getY();
    }

    public int getColumnBY() {
        return driver.findElement(columnB).getLocation().getY();
    }
}
