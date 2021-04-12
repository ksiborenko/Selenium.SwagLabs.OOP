package tests.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CheckOutCompletePage {

    private WebDriver driver;

    public CheckOutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void backHomeButton () {
        this.driver.findElement(By.id("back-to-products")).click();
        String url = this.driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", url);
    }
}
