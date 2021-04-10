package swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInObject {
    private final WebDriver driver;

    public LogInObject(WebDriver driver) {
        this.driver = driver;
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

    public void logIn(String login, String password) {
        this.driver.get("https://www.saucedemo.com/");
        WebElement loginTab = this.driver.findElement(By.id("user-name"));
        loginTab.click();
        loginTab.sendKeys(login);
        WebElement passwordTab = this.driver.findElement(By.id("password"));
        passwordTab.click();
        passwordTab.sendKeys(password);
        this.driver.findElement(By.id("login-button")).click();
    }
}
