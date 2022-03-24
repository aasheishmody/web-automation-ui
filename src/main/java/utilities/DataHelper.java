package utilities;

import java.io.IOException;
import java.util.Properties;

public class DataHelper {

    private static volatile DataHelper dataHelper;

    public static DataHelper getInstance() {
        if (dataHelper == null) {
            synchronized (DataHelper.class) {
                if (dataHelper == null) {
                    dataHelper = new DataHelper();
                }
            }
        }
        return dataHelper;
    }

    public String getValue(String path) {
        return this.getProfileByEnvironment().getProperty(path);
    }

    public Properties getProfileByEnvironment() {
        Properties properties = new Properties();
        try {
            switch (ConfigFileReader.getInstance().getEnvironment()) {
                case STAGING:
                    properties.load(DataHelper.class.getClassLoader().getResourceAsStream("data/staging.properties"));
                    break;
                case DEV:
                    properties.load(DataHelper.class.getClassLoader().getResourceAsStream("data/dev.properties"));
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
