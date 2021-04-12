import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import swaglabs.*;
import swaglabs.utils.CartController;
import swaglabs.utils.LogInController;

public class Main {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPageDropMenuTest inventoryPageDropMenuTest;
    private InventoryPageContainer inventoryPageContainer;
    private InventoryPageCart inventoryPageCart;
    private LogInController logInController;
    private CartPage cartPage;
    private CartController cartController;

    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.loginPage = new LoginPage(driver);
        this.inventoryPageDropMenuTest = new InventoryPageDropMenuTest(driver);
        this.inventoryPageContainer = new InventoryPageContainer(driver);
        this.inventoryPageCart = new InventoryPageCart(driver);
        this.logInController = new LogInController(driver);
        this.cartPage = new CartPage(driver);
        this.cartController = new CartController(driver);
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
        this.logInController.logIn();
        this.inventoryPageCart.enterCart();
        this.cartPage.continueShopping();
        this.cartController.inventoryToCart();
        this.cartPage.hamburgerMenu();
        this.cartPage.clearingCart();
        this.cartPage.checkOut();
    }

    @After
    public void end() {
        this.driver.quit();
    }
}
