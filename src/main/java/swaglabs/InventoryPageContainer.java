package swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class InventoryPageContainer {

    private final WebDriver driver;
    private final LogInObject logInObject;

    public InventoryPageContainer(WebDriver driver) {
        this.driver = driver;
        this.logInObject = new LogInObject(this.driver);
    }

    public void addItems() {
        this.logInObject.logIn();
        this.driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        this.driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        this.driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        this.driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        this.driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
        String itemsAmount = this.driver.findElement(By.className("shopping_cart_badge")).getText();
        assertEquals("3", itemsAmount);
    }
}
