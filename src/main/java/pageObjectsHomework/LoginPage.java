package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    public WebElement getUsernameField() {
        return driver.findElement(username);
    }

    public void setUsernameField(String value) {
        getUsernameField().sendKeys(value);
    }

    public WebElement getPasswordField() {
        return driver.findElement(password);
    }

    public void setPasswordField(String value) {
        getPasswordField().sendKeys(value);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }
     public void setLoginButton() {
        getLoginButton().click();
     }
}
