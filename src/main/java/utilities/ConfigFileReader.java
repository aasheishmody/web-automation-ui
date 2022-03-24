package utilities;

import ch.qos.logback.classic.Level;
import enums.*;

import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private static final ConfigFileReader configFileReader;
    private final Properties properties;

    static {
        configFileReader = new ConfigFileReader();
    }

    private ConfigFileReader() {

        properties = new Properties();
        try {
            properties.load(ConfigFileReader.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigFileReader getInstance() {
        return configFileReader;
    }

    public String getUrl(String urlKey) {
        return DataHelper.getInstance().getValue(urlKey);
    }

    public Browser getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equalsIgnoreCase("chrome")) return Browser.CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return Browser.FIREFOX;
        else if (browserName.equalsIgnoreCase("edge")) return Browser.EDGE;
        else if (browserName.equalsIgnoreCase("safari")) return Browser.SAFARI;
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public ServerType getserverType() {
        String serverType = properties.getProperty("serverType");
        if (serverType == null || serverType.equalsIgnoreCase("real")) return ServerType.REAL;
        else if (serverType.equalsIgnoreCase("mock"))
            return ServerType.MOCK;
        else
            throw new RuntimeException("Server Type Key value in Configuration.properties is not matched : " + serverType);
    }

    public Host getHost() {
        String host = properties.getProperty("host");
        if (host == null || host.equalsIgnoreCase("local")) return Host.LOCAL;
        else if (host.equalsIgnoreCase("cloud")) return Host.CLOUD;
        else throw new RuntimeException("Host Key value in Configuration.properties is not matched : " + host);
    }

    public int getWiremockPort() {
        return Integer.parseInt(properties.getProperty("wiremockPort"));
    }

    public int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty("pageLoadTimeout"));
    }

    public int getImplicitWaitTimeout() {
        return Integer.parseInt(properties.getProperty("implicitWaitTimeout"));
    }

    public HeadlessFlag getHeadlessFlag() {
        String headlessFlag = properties.getProperty("headlessFlag");
        if (headlessFlag == null || headlessFlag.equalsIgnoreCase("true")) return HeadlessFlag.TRUE;
        else if (headlessFlag.equalsIgnoreCase("false")) return HeadlessFlag.FALSE;
        else
            throw new RuntimeException("Headless Flag Key value in Configuration.properties is not matched : " + headlessFlag);
    }

    public Environment getEnvironment(){
        String environment = properties.getProperty("environment");
        if(environment.equalsIgnoreCase("DEV")) return Environment.DEV;
        else if (environment.equalsIgnoreCase("STAGING")) return Environment.STAGING;
        else
            throw new RuntimeException("Environment Key value in Configuration.properties is not matched : " + environment);
    }

    public AccessibilityStandard getAccessibilityStandard() {
        String accessibilityStandard = properties.getProperty("accessibilityStandard");
        if (accessibilityStandard == null || accessibilityStandard.equalsIgnoreCase("WCAG 2.0 Level A"))
            return AccessibilityStandard.WCAG2LevelA;
        else if (accessibilityStandard.equalsIgnoreCase("WCAG 2.0 Level AA")) return AccessibilityStandard.WCAG2LevelAA;
        else if (accessibilityStandard.equalsIgnoreCase("WCAG 2.1 Level A")) return AccessibilityStandard.WCAG21LevelA;
        else if (accessibilityStandard.equalsIgnoreCase("WCAG 2.1 Level AA"))
            return AccessibilityStandard.WCAG21LevelAA;
        else
            throw new RuntimeException("Accessibility standard Key value in Configuration.properties is not matched : " + accessibilityStandard);
    }

    public String getCloudURL() {
        String cloudURL = properties.getProperty("cloudURL");
        if (cloudURL == null)
            return cloudURL;
        else if (cloudURL.equalsIgnoreCase("https://@hub-cloud.browserstack.com/wd/hub"))
            return cloudURL;
        else
            throw new RuntimeException("Cloud url in config.properties should be " + "https://@hub-cloud.browserstack.com/wd/hub");
    }

    public ScreenSize getScreenSize() {
        String screenSize = properties.getProperty("screenSize");
        if (screenSize == null || screenSize.equalsIgnoreCase("Desktop"))
            return ScreenSize.DESKTOP;
        else if (screenSize.equalsIgnoreCase("Laptop"))
            return ScreenSize.LAPTOP;
        else if (screenSize.equalsIgnoreCase("Tablet"))
            return ScreenSize.TABLET;
        else if (screenSize.equalsIgnoreCase("Mobile"))
            return ScreenSize.MOBILE;
        else
            throw new RuntimeException("Screen Size Key value in Configuration.properties is not matched : " + screenSize);
    }

    public Level getLogLevel() {
        String logLevel = properties.getProperty("logLevel");
        if (logLevel == null || logLevel.equalsIgnoreCase("INFO"))
            return Level.INFO;
        else if (logLevel.equalsIgnoreCase("ERROR"))
            return Level.ERROR;
        else if (logLevel.equalsIgnoreCase("WARN"))
            return Level.WARN;
        else if (logLevel.equalsIgnoreCase("DEBUG"))
            return Level.DEBUG;
        else if (logLevel.equalsIgnoreCase("TRACE"))
            return Level.TRACE;
        else
            throw new RuntimeException("Invalid Log Level - Valid Levels (INFO|DEBUG|ERROR|WARN|TRACE)  Current Value: " + logLevel);
    }
}
