import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        // driver.findElement(By.xpath("//button[text()='Add to cart' and following-sibling::h4[text()='" + itemName + "']]")).click();
    }

    public void clickCartLink() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
