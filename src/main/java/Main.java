import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import swaglabs.InventoryPageDropMenu;
import swaglabs.LoginPage;

public class Main {

    private WebDriver driver;
    private Actions action;
    private LoginPage loginPage;
    private InventoryPageDropMenu inventoryPageDropMenu;

    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.action = new Actions(this.driver);
        this.loginPage = new LoginPage(this.driver);
        this.inventoryPageDropMenu = new InventoryPageDropMenu(this.driver);
    }

    @Test
    public void loginPage() {
        this.loginPage.test(false, "", "");
        this.loginPage.test(true, "standard_user", "secret_sauce");
    }

    @Test
    public void inventoryPageDropDownMenu() {
        this.inventoryPageDropMenu.testAllOptions();

    }

    @After
    public void end() {
        this.driver.quit();
    }
}
