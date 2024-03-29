package base;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    // To quit the drivers and browsers at the end only.
    private static final List<WebDriver> storedDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                storedDrivers.forEach(WebDriver::quit);
            }
        });
    }

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void addDriver(WebDriver driver) {
        storedDrivers.add(driver);
        drivers.set(driver);
    }

    public static void removeDriver() {
        storedDrivers.remove(drivers.get());
        drivers.remove();
    }
}
