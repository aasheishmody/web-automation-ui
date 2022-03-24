package applicationComponents.sections;

import base.ApplicationComponents;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuSection extends ApplicationComponents {

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public void clickLogoutLink() {
        logoutLink.click();
    }
}
