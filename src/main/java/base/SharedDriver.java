package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.ConfigFileReader;

import java.util.concurrent.TimeUnit;

public class SharedDriver {

    private WebDriver driver;
    private ChromeOptions chromeOptions;
    private EdgeOptions edgeOptions;
    private DesiredCapabilities capabilities;

    public SharedDriver() throws Exception {
        if (DriverFactory.getDriver() == null) {
            driver = createDriver();
            switch (ConfigFileReader.getInstance().getScreenSize()){
                case DESKTOP:
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                    break;
                case LAPTOP:
                    driver.manage().window().maximize();
                    break;
                case TABLET:
                    driver.manage().window().setSize(new Dimension(768, 1024));
                    break;
                case MOBILE:
                    driver.manage().window().setSize(new Dimension(375, 812));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ConfigFileReader.getInstance().getScreenSize());
            }
            driver.manage().timeouts().implicitlyWait(ConfigFileReader.getInstance().getImplicitWaitTimeout(), TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(ConfigFileReader.getInstance().getPageLoadTimeout(), TimeUnit.SECONDS);
            DriverFactory.addDriver(driver);
        }
    }

    private WebDriver createDriver() throws Exception {
        switch (ConfigFileReader.getInstance().getHost()) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case CLOUD:
                driver = createCloudDriver();
                break;
        }
        return driver;
    }

    private WebDriver createLocalDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        switch (ConfigFileReader.getInstance().getBrowser()) {
            case CHROME:
                setChromeOptions();
                chromeOptions.merge(capabilities);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case EDGE:
                setEdgeOptions();
                WebDriverManager.edgedriver().setup();
                edgeOptions.merge(capabilities);
                driver = new EdgeDriver(edgeOptions);
                break;
        }
        return driver;
    }

    private WebDriver createCloudDriver() {
        throw new RuntimeException("Cloud run yet to be implemented");
    }

    private void setChromeOptions() {
        chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(Boolean.parseBoolean(ConfigFileReader.getInstance().getHeadlessFlag().toString()));
    }

    private void setEdgeOptions() {
        edgeOptions = new EdgeOptions();
    }
}
