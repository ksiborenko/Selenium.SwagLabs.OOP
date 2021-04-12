package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class InventoryPageCart {

    private final WebDriver driver;

    public InventoryPageCart(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCart() {
        this.driver.findElement(By.className("shopping_cart_container")).click();
        WebElement checkout = this.driver.findElement(By.id("checkout"));
        assertTrue(checkout.isDisplayed());
    }

}
