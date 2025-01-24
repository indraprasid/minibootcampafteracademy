// package main.java;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isItemInCart(String itemName) {
        return driver.findElements(By.xpath("//div[@class='cart_item']//a[text()='" + itemName + "']")).size() > 0;
    }

    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }
}
