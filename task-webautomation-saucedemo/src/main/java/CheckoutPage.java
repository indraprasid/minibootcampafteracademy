import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Prevention of timeout
    }

    public void fillInfo(String firstName, String lastName, String postalCode) {
        // Ensure correct page URL before proceeding
        wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/checkout-step-one.html"));

        // Wait and locate the first name field
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
        firstNameField.sendKeys(firstName);

        // Wait and locate the last name field
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
        lastNameField.sendKeys(lastName);

        // Wait and locate the postal code field
        WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("postalCode")));
        postalCodeField.sendKeys(postalCode);

        // Wait and click the continue button
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        continueButton.click();
    }
}
