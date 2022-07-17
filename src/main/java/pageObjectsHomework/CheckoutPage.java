package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final By firstNameField = By.xpath("//*[@id=\"first-name\"]");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
//    private final By errorMessage = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");

    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }
    public void setFirstNameField(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getFirstNameField()));
        getFirstNameField().sendKeys(value);
    }

    public WebElement getLastNameField() {
        return  driver.findElement(lastNameField);
    }
    public void setLastNameField(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getLastNameField()));
        getLastNameField().sendKeys(value);
    }

    public WebElement getPostalCodeField() {
        return driver.findElement(postalCodeField);
    }
    public void setPostalCodeField(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getPostalCodeField()));
        getPostalCodeField().sendKeys(value);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public void setContinueButton() {
        getContinueButton().click();
    }
}
