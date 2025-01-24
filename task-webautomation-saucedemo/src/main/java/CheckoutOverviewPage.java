import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isItemInCheckoutOverview(String itemName) {
        return driver.findElements(By.xpath("//div[@class='cart_item']//a[text()='" + itemName + "']")).size() > 0;
    }

    public void clickFinish() {
        driver.findElement(By.id("finish")).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(By.className("complete-header")).getText();
    }
}
