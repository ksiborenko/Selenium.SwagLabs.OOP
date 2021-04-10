package swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void continueShopping() {
        this.driver.findElement(By.name("continue-shopping")).click();
        WebElement element = this.driver.findElement(By.id("inventory_container"));
        assertTrue(element.isDisplayed());
    }
}
