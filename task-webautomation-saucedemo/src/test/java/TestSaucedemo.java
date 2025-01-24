import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSaucedemo {

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\Bootcamp\\AfterOfficeAcademy\\WebAutomation-SeleniumTestNG\\minibootcampafteracademy\\task-webautomation-saucedemo\\webdriver\\chromedriver.exe"); // Update path as needed
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/"); // Navigate to the Sauce Demo site
        softAssert = new SoftAssert();
    }

    @Test
    public void testSauceDemoLoginAndCheckout() {
        try {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        
        Thread.sleep(2000);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCart();
        productsPage.clickCartLink();

        Thread.sleep(2000);

        CartPage cartPage = new CartPage(driver);
        softAssert.assertTrue(cartPage.isItemInCart("Sauce Labs Fleece Jacket"), "Item not found in cart");
        cartPage.clickCheckout();

        Thread.sleep(2000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillInfo("Indra", "Prasetyawan", "60188");

        Thread.sleep(2000);

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        softAssert.assertTrue(checkoutOverviewPage.isItemInCheckoutOverview("Sauce Labs Fleece Jacket"), "Item not found in checkout overview");
        checkoutOverviewPage.clickFinish();

        Thread.sleep(2000);

        softAssert.assertEquals(checkoutOverviewPage.getSuccessMessage(), "Thank you for your order!", "Success message incorrect");

        Thread.sleep(2000);


        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
