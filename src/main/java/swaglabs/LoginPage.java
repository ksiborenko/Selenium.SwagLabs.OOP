package swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void test(boolean typeOfLoginCheck, String login, String password) {
        this.driver.get("https://www.saucedemo.com/");
        WebElement loginTab = this.driver.findElement(By.id("user-name"));
        loginTab.click();
        loginTab.sendKeys(login);
        WebElement passwordTab = this.driver.findElement(By.id("password"));
        passwordTab.click();
        passwordTab.sendKeys(password);
        this.driver.findElement(By.id("login-button")).click();
        if (typeOfLoginCheck) {
            this.correctLoginDataCheck();
        }
        if (!typeOfLoginCheck) {
            this.incorrectLoginDataCheck();
        }
    }

    private void correctLoginDataCheck() {
        WebElement check = this.driver.findElement(By.id("shopping_cart_container"));
        assertTrue(check.isDisplayed());
    }

    private void incorrectLoginDataCheck() {
        WebElement check = this.driver.findElement(By.className("error"));
        assertTrue(check.isDisplayed());
    }
}
