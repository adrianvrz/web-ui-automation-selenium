package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.LoginPage;
import pages.SecurePage;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private SecurePage securePage;

    @Before
    public void setUp() {
        //Inisialisasi Browser Driver (Chrome driver, Gecko driver, etc.)
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I enter a very long username and password {string}")
    public void i_enter_a_very_long_username_and_password(String password) {
        String longUsername = "a".repeat(1000);
        loginPage.enterUsername(longUsername);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        securePage = new SecurePage(driver);
        String message = securePage.getSuccessMessage();
        Assert.assertTrue(message.contains("You logged into a secure area!"));
    }

    @Then("I should see an error message containing {string}")
    public void i_should_see_an_error_message_containing(String expectedError) {
        String actualError = loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains(expectedError));
    }
}