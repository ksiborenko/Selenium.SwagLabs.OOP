package swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartController {
    WebDriver driver;

    public CartController(WebDriver driver) {
        this.driver = driver;
    }

    public void inventoryToCart() {
        this.driver.findElement(By.id("shopping_cart_container")).click();
    }

    public void cartToInventory() {
        this.driver.findElement(By.id("continue-shopping_cart_container")).click();
    }
}
