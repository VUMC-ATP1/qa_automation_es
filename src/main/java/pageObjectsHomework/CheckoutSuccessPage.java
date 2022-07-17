package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSuccessPage {

    private WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final By backHomeButton = By.id("back-to-products");
    private final By thankYouTitle = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButton);
    }
    public void setBackHomeButton() {
        getBackHomeButton().click();
    }
    public WebElement getThankYouTitle() {
        return driver.findElement(thankYouTitle);
    }
}
