import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import swaglabs.SwagLabsLoginPageTest;

public class Main {

    private WebDriver driver;
    private Actions action;
    private SwagLabsLoginPageTest swagLabsLoginPageTest;

    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.action = new Actions(this.driver);
        this.swagLabsLoginPageTest = new SwagLabsLoginPageTest(this.driver);
    }

    @Test
    public void swagLabsLoginPage() {
        this.swagLabsLoginPageTest.fullTest(false, "", "");
        this.swagLabsLoginPageTest.fullTest(true, "standard_user", "secret_sauce");
    }

    @After
    public void end() {
        this.driver.quit();
    }
}
