package base;


import io.cucumber.java8.Scenario;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private final Map<String, Object> scenarioContext;
    public ApplicationComponents applicationComponents;
    public SharedDriver driver;
    public Scenario scenario;

    public TestContext(SharedDriver driver, ApplicationComponents applicationComponents) {
        scenarioContext = new HashMap<>();
        this.driver = driver;
        this.applicationComponents = applicationComponents;
    }

    public void setScenarioContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getScenarioContext(String key) {
        return scenarioContext.get(key);
    }

    public Boolean scenarioContextContains(String key) {
        return scenarioContext.containsKey(key);
    }

    public Scenario getScenario() {
        return scenario;
    }
}
