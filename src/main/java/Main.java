import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import tests.cart.CartPage;
import tests.checkout.CheckOutPage;
import tests.inventory.InventoryPageCart;
import tests.inventory.InventoryPageContainer;
import tests.inventory.InventoryPageDropMenuTest;
import tests.login.LoginPage;
import utils.CartController;
import utils.LogInController;

public class Main {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPageDropMenuTest inventoryPageDropMenuTest;
    private InventoryPageContainer inventoryPageContainer;
    private InventoryPageCart inventoryPageCart;
    private LogInController logInController;
    private CartPage cartPage;
    private CartController cartController;
    private CheckOutPage checkOutPage;

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
        this.checkOutPage = new CheckOutPage(this.driver);
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

    @Test
    public void checkOutPage() {
        this.logInController.logIn();
        this.cartController.inventoryToCart();
        this.cartController.cartToCheckout();
        this.checkOutPage.cancelButton();
        this.cartController.cartToCheckout();
        this.checkOutPage.noDataCheck();
        this.checkOutPage.enterData();
        this.checkOutPage.continueButton();
    }

    @After
    public void end() {
        //   this.driver.quit();
    }
}
