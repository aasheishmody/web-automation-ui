package base;

import org.openqa.selenium.support.PageFactory;

public class ApplicationComponents {
    public <TPage extends ApplicationComponents> TPage GetInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(DriverFactory.getDriver(), pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}