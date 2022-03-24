package applicationComponents.pages;

import base.ApplicationComponents;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigFileReader;

public class InventoryPage extends ApplicationComponents {

    private final static String INVENTORYPAGEURL = ConfigFileReader.getInstance().getUrl("base.url") + "/inventory.html";

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingKartLink;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    public boolean inventoryPageIsDisplayed() {
        return shoppingKartLink.isDisplayed();
    }

    public void clickMenuButton() {
        menuButton.click();
    }
}
