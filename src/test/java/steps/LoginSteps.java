package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.SecurePage;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private SecurePage securePage;

    @Before
    public void setUp() {
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
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); // Para Jenkins
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
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

    @Given("I have entered a valid username {string}")
    public void i_have_entered_a_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @Given("I have entered a valid password {string}")
    public void i_have_entered_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @Given("I have entered an invalid username {string}")
    public void i_have_entered_an_invalid_username(String username) {
        loginPage.enterUsername(username);
    }

    @Given("I have entered an invalid password {string}")
    public void i_have_entered_an_invalid_password(String password) {
        loginPage.enterPassword(password);
    }

    @Given("I leave the username field empty")
    public void i_leave_the_username_field_empty() {
        loginPage.enterUsername("");
    }

    @Given("I leave the password field empty")
    public void i_leave_the_password_field_empty() {
        loginPage.enterPassword("");
    }

    @Given("I enter a very long username")
    public void i_enter_a_very_long_username() {
        String longUsername = "a".repeat(1000);
        loginPage.enterUsername(longUsername);
    }

    @Given("I enter the password {string}")
    public void i_enter_the_password(String password) {
        loginPage.enterPassword(password);
    }

    @Given("I enter the valid username {string}")
    public void i_enter_the_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        securePage = new SecurePage(driver);
        Assertions.assertTrue(securePage.getSuccessMessage().contains("You logged into a secure area!"));
    }

    @Then("I should see a success message containing {string}")
    public void i_should_see_a_success_message_containing(String expectedMessage) {
        securePage = new SecurePage(driver);
        String message = securePage.getSuccessMessage();
        Assertions.assertTrue(message.contains(expectedMessage), "Success message does not contain: " + expectedMessage);
    }

    @Then("I should see an error message containing {string}")
    public void i_should_see_an_error_message_containing(String expectedError) {
        Assertions.assertTrue(loginPage.getErrorMessage().contains(expectedError));
    }
}