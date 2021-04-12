package tests.inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class InventoryPageCart {

    private final WebDriver driver;

    public InventoryPageCart(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCart() {
        this.driver.findElement(By.className("shopping_cart_container")).click();
        String url = this.driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/cart.html", url);
    }

}
