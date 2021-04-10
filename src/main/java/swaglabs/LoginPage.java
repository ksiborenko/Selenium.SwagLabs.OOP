package swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class LoginPage {

    private final WebDriver driver;
    private final LogInObject logInObject;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.logInObject = new LogInObject(this.driver);
    }

    public void loginCheck(boolean typeOfLoginCheck, String login, String password) {
        this.logInObject.logIn(login, password);
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
