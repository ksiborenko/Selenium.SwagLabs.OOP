package tests.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckOutPage {

    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterData() {
        WebElement firstName = this.driver.findElement(By.id("first-name"));
        firstName.click();
        firstName.sendKeys("test");
        String firstNameCheck = this.driver.findElement(By.id("first-name")).getAttribute("value");
        assertEquals("test", firstNameCheck);
        WebElement lastName = this.driver.findElement(By.id("last-name"));
        lastName.click();
        lastName.sendKeys("test");
        String lastNameCheck = this.driver.findElement(By.id("last-name")).getAttribute("value");
        assertEquals("test", lastNameCheck);
        WebElement zipCode = this.driver.findElement(By.id("postal-code"));
        zipCode.click();
        zipCode.sendKeys("123");
        String zipCheck = this.driver.findElement(By.id("postal-code")).getAttribute("value");
        assertEquals("123", zipCheck);
    }

    public void noDataCheck() {
        this.driver.findElement(By.id("continue")).click();
        WebElement errorButton = this.driver.findElement(By.className("error-button"));
        errorButton.isDisplayed();
        errorButton.click();
        WebElement errorContainer = this.driver.findElement(By.className("error-message-container"));
        assertTrue(errorContainer.isDisplayed());

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
