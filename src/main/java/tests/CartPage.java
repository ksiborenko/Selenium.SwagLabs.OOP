package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void continueShopping() {
        this.driver.findElement(By.name("continue-shopping")).click();
        WebElement element = this.driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        assertTrue(element.isDisplayed());
    }

    public void hamburgerMenu() {
        this.driver.findElement(By.id("react-burger-menu-btn")).click();
        WebElement allItems = this.driver.findElement(By.id("inventory_sidebar_link"));
        WebElement about = this.driver.findElement(By.id("about_sidebar_link"));
        WebElement logout = this.driver.findElement(By.id("logout_sidebar_link"));
        WebElement resetAppState = this.driver.findElement(By.id("reset_sidebar_link"));
        assertTrue(allItems.isDisplayed());
        assertTrue(about.isDisplayed());
        assertTrue(logout.isDisplayed());
        assertTrue(resetAppState.isDisplayed());
        this.driver.findElement(By.id("react-burger-cross-btn")).click();
    }

    public void clearingCart() {
        this.driver.findElement(By.id("continue-shopping")).click();
        this.driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        this.driver.findElement(By.id("shopping_cart_container")).click();
        String shoppingCartBadge = this.driver.findElement(By.className("shopping_cart_badge")).getText();
        assertEquals("1", shoppingCartBadge);
        this.driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    public void checkOut() {
        this.driver.findElement(By.id("checkout")).click();
        String url = this.driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/checkout-step-one.html", url);
    }
}
