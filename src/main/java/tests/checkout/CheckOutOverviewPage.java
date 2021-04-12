package tests.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CheckOutOverviewPage {

    private WebDriver driver;

    public CheckOutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cancelButton() {
        this.driver.findElement(By.id("cancel")).click();
        String utl = this.driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", utl);
    }

    public void finnishButton() {
        this.driver.findElement(By.id("finish")).click();
        String url = this.driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/checkout-complete.html", url);
    }
}
