package tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.LogInController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage {

    private final WebDriver driver;
    private final LogInController logInController;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.logInController = new LogInController(this.driver);
    }

    public void loginCheck(boolean typeOfLoginCheck, String login, String password) {
        this.logInController.logIn(login, password);
        if (typeOfLoginCheck) {
            this.correctLoginDataCheck();
        }
        if (!typeOfLoginCheck) {
            this.incorrectLoginDataCheck();
        }
    }

    private void correctLoginDataCheck() {
        String url = this.driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", url);
    }

    private void incorrectLoginDataCheck() {
        WebElement check = this.driver.findElement(By.className("error"));
        assertTrue(check.isDisplayed());
        String url = this.driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/", url);
    }
}
