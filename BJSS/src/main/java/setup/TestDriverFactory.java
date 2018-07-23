package setup;

import org.openqa.selenium.WebDriver;
import webdriver.DriverFactory;
import webdriver.configuration.LocalDriverConfiguration;
import webdriver.configuration.RemoteDriverConfiguration;

public class TestDriverFactory {
    public WebDriver createDriver() {
        if (TestConfiguration.remote) {
            return new DriverFactory().createRemoteDriver(
                    new RemoteDriverConfiguration(
                            TestConfiguration.browser,
                            TestConfiguration.platform,
                            TestConfiguration.browserVersion));
        }

        return new DriverFactory().createLocalDriver(new LocalDriverConfiguration((TestConfiguration.browser)));
    }
}
