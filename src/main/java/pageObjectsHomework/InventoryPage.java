package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final By addSauceLabsOnesie = By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]");

    private static final By shoppingCartIcon = By.id("shopping_cart_container");

    public WebElement getAddSauceLabsOnesie() {
        return driver.findElement(addSauceLabsOnesie);
    }

    public void setAddSauceLabsOnesie() {
        getAddSauceLabsOnesie().click();
    }

    public WebElement getShoppingCartIcon() {
        return driver.findElement(shoppingCartIcon);
    }

    public void setShoppingCartIcon() {
        getShoppingCartIcon().click();
    }
}
