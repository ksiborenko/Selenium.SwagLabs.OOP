import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import swaglabs.InventoryPageDropMenuTest;
import swaglabs.LoginPageTest;

public class Main {

    private WebDriver driver;
    private Actions action;
    private LoginPageTest loginPageTest;
    private InventoryPageDropMenuTest inventoryPageDropMenuTest;

    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.action = new Actions(this.driver);
        this.loginPageTest = new LoginPageTest(this.driver);
        this.inventoryPageDropMenuTest = new InventoryPageDropMenuTest(this.driver);
    }

    @Test
    public void loginPage() {
        this.loginPageTest.test(false, "", "");
        this.loginPageTest.test(true, "standard_user", "secret_sauce");
    }

    @Test
    public void inventoryPageDropDownMenu() {
        this.inventoryPageDropMenuTest.testAllOptions();
    }

    @After
    public void end() {
        this.driver.quit();
    }
}
