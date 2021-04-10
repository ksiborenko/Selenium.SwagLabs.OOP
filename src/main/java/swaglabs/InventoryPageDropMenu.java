package swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class InventoryPageDropMenu {

    private WebDriver driver;

    public InventoryPageDropMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void testAllOptions() {
        this.logIn();
        this.testOption1();
        this.testOption2();
        this.testOption3();
        this.testOption4();
    }

    public void logIn() {
        this.driver.get("https://www.saucedemo.com/");
        WebElement loginTab = this.driver.findElement(By.id("user-name"));
        loginTab.click();
        loginTab.sendKeys("standard_user");
        WebElement passwordTab = this.driver.findElement(By.id("password"));
        passwordTab.click();
        passwordTab.sendKeys("secret_sauce");
        this.driver.findElement(By.id("login-button")).click();
    }

    public void testOption1() {
        this.driver.findElement(By.className("product_sort_container")).click();
        this.driver.findElement(By.xpath("//*[contains(text(),'Name (Z to A)')]")).click();
        String activeOption = this.driver.findElement(By.className("active_option")).getText();
        assertEquals("NAME (Z TO A)", activeOption);
    }

    public void testOption2() {
        this.driver.findElement(By.className("product_sort_container")).click();
        this.driver.findElement(By.xpath("//*[contains(text(),'Name (A to Z)')]")).click();
        String activeOption = this.driver.findElement(By.className("active_option")).getText();
        assertEquals("NAME (A TO Z)", activeOption);
    }

    public void testOption3() {
        this.driver.findElement(By.className("product_sort_container")).click();
        this.driver.findElement(By.xpath("//*[contains(text(),'Price (low to high)')]")).click();
        String activeOption = this.driver.findElement(By.className("active_option")).getText();
        assertEquals("PRICE (LOW TO HIGH)", activeOption);
    }

    public void testOption4() {
        this.driver.findElement(By.className("product_sort_container")).click();
        this.driver.findElement(By.xpath("//*[contains(text(),'Price (high to low)')]")).click();
        String activeOption = this.driver.findElement(By.className("active_option")).getText();
        assertEquals("PRICE (HIGH TO LOW)", activeOption);
    }


}
