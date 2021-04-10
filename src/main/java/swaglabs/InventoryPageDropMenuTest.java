package swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class InventoryPageDropMenuTest {

    private final WebDriver driver;
    private final LogIn logIn;

    public InventoryPageDropMenuTest(WebDriver driver) {
        this.driver = driver;
        this.logIn = new LogIn(this.driver);
    }

    public void testAllOptions() {
        this.logIn.logIn("standard_user", "secret_sauce");
        this.testOption1();
        this.testOption2();
        this.testOption3();
        this.testOption4();
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
