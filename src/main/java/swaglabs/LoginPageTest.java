package swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class LoginPageTest {

    private WebDriver driver;
    private LogIn logIn;

    public LoginPageTest(WebDriver driver) {
        this.driver = driver;
        this.logIn = new LogIn(this.driver);
    }

    public void test(boolean typeOfLoginCheck, String login, String password) {
        this.logIn.logIn(login, password);
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
