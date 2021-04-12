package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class CheckOutPage {

    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterData() {
        WebElement firstName = this.driver.findElement(By.id("first-name"));
        firstName.click();
        firstName.sendKeys("test");
        WebElement lastName = this.driver.findElement(By.id("last-name"));
        lastName.click();
        lastName.sendKeys("test");
        WebElement zipCode = this.driver.findElement(By.id("postal-code"));
        zipCode.click();
        zipCode.sendKeys("123");
    }

    public void cancelButton() {
        this.driver.findElement(By.id("cancel")).click();
        String url = this.driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/cart.html", url);
    }

    public void continueButton() {
        this.driver.findElement(By.id("continue")).click();
        String url = this.driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/checkout-step-two.html", url);

    }
}
