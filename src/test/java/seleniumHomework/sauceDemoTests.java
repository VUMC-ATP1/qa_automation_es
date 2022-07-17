package seleniumHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class sauceDemoTests {
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckoutPage checkoutPage;
    CartPage cartPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;

    private final String SAUCE_URL = "https://www.saucedemo.com/";

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initializing ChromeDriver");
        driver = new ChromeDriver();
        driver.get(SAUCE_URL);

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
    }

    @Test
    public void testScenario1() {
        //Navigēt uz saiti https://www.saucedemo.com/
        driver.get(SAUCE_URL);

        //Ielogoties ar pareizu lietotājvārdu un paroli
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        loginPage.setLoginButton();

        //Pārbaudīt, ka lietotājs ir ielogojies
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

        //Ievietot grozā 1 produktu un pārbaudīt tā esamību grozā
        inventoryPage.setAddSauceLabsOnesie();
        inventoryPage.setShoppingCartIcon();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

        WebElement itemInCart = driver.findElement(By.linkText("Sauce Labs Onesie"));
        Assert.assertEquals(itemInCart.getText(), "Sauce Labs Onesie");
        cartPage.setCheckoutButton();

        //Doties uz Checkout, ievadīt datus. Checkout overview pārbaudīt datus un pabeigt pasūtījumu
        checkoutPage.setFirstNameField("Evita");
        checkoutPage.setLastNameField("Savicka");
        checkoutPage.setPostalCodeField("LV-1234");
        checkoutPage.setContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        checkoutOverviewPage.setFinishButton();
        Assert.assertEquals(checkoutSuccessPage.getThankYouTitle().getText(),"THANK YOU FOR YOUR ORDER");
        checkoutSuccessPage.setBackHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testScenario2() {
        //Navigēt uz saiti https://www.saucedemo.com/
        driver.get(SAUCE_URL);

        //Ielogoties ar pareizu lietotājvārdu un paroli
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("secret_sauce");
        loginPage.setLoginButton();

        // Doties uz grozu/Checkout
        inventoryPage.setShoppingCartIcon();
        cartPage.setCheckoutButton();
        checkoutPage.setContinueButton();

        //Pārbaudīt, ka FirstName/LastName/ZipCode i ogligāts
        //pārbaudīt, ka forma parāda pareizu paziņojumu pie katra neievadītā lauka
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3"));
        Assert.assertEquals(errorMessage.getText(), "Error: First Name is required");

        checkoutPage.setFirstNameField("Evita");
        checkoutPage.setContinueButton();
        Assert.assertEquals(errorMessage.getText(), "Error: Last Name is required");

        checkoutPage.setLastNameField("Savicka");
        checkoutPage.setContinueButton();
        Assert.assertEquals(errorMessage.getText(), "Error: Postal Code is required");

        checkoutPage.setPostalCodeField("LV-1234");
        checkoutPage.setContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing ChromeDriver");
        driver.quit();
    }
}
