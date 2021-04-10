import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import swaglabs.*;

public class Main {

    private WebDriver driver;
    private Actions action;
    private LoginPage loginPage;
    private InventoryPageDropMenuTest inventoryPageDropMenuTest;
    private InventoryPageContainer inventoryPageContainer;
    private InventoryPageCart inventoryPageCart;
    private LogInObject logInObject;
    private CartPage cartPage;

    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.action = new Actions(this.driver);
        this.loginPage = new LoginPage(this.driver);
        this.inventoryPageDropMenuTest = new InventoryPageDropMenuTest(this.driver);
        this.inventoryPageContainer = new InventoryPageContainer(this.driver);
        this.inventoryPageCart = new InventoryPageCart(this.driver);
        this.logInObject = new LogInObject(this.driver);
        this.cartPage = new CartPage(this.driver);
    }

    @Test
    public void loginPage() {
        this.loginPage.loginCheck(false, "", "");
        this.loginPage.loginCheck(true, "standard_user", "secret_sauce");
    }

    @Test
    public void inventoryPageDropDownMenu() {
        this.inventoryPageDropMenuTest.testAllOptions();
    }

    @Test
    public void inventoryPageContainerTest() {
        this.inventoryPageContainer.addItems();
    }

    @Test
    public void cart() {
        this.logInObject.logIn();
        this.inventoryPageCart.enterCart();
        this.cartPage.continueShopping();
    }

    @After
    public void end() {
        this.driver.quit();
    }
}
