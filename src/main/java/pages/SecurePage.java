package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage {
    @FindBy(id = "flash")
    private WebElement successMessage;

    public SecurePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}