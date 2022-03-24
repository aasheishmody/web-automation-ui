package applicationComponents.pages;

import base.ApplicationComponents;
import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigFileReader;

public class HomePage extends ApplicationComponents {

    private final static String HOMEPAGEURL = ConfigFileReader.getInstance().getUrl("base.url");

    @FindBy(id = "user-name")
    private WebElement userNameTextbox;
    @FindBy(id = "password")
    private WebElement passwordTextBox;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void navigateToHomePage() {
        DriverFactory.getDriver().get(HOMEPAGEURL);
    }

    public void enterUsername(String username) {
        userNameTextbox.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean homePageIsDisplayed() {
        return userNameTextbox.isDisplayed();
    }
}
