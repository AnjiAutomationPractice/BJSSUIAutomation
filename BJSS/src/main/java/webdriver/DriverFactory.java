package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import webdriver.configuration.LocalDriverConfiguration;
import webdriver.configuration.RemoteDriverConfiguration;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private WebDriver driver;
    private DesiredCapabilities capabilities;

    public WebDriver createLocalDriver(LocalDriverConfiguration configuration) {
        switch (configuration.browser) {
            case "chrome":
                createChromeDriver();
                break;
            case "firefox":
                createFirefoxDriver();
                break;
            case "internet explorer":
                createInternetExplorerDriver();
                break;
        }

        return driver;
    }

    public WebDriver createRemoteDriver(RemoteDriverConfiguration configuration) {
        switch (configuration.browser) {
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                break;
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                break;
            case "internet explorer":
                capabilities = DesiredCapabilities.internetExplorer();
                break;
        }

        capabilities.setCapability(CapabilityType.PLATFORM, configuration.platform);
        capabilities.setCapability(CapabilityType.VERSION, configuration.browserVersion);

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    private WebDriver createChromeDriver() {
        String projectDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectDirectory + "/tools/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    private WebDriver createFirefoxDriver() {
        String projectDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", projectDirectory + "/tools/firefoxdriver/geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }

    private WebDriver createInternetExplorerDriver() {
        String projectDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.ie.driver", projectDirectory + "/tools/iedriver/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        return driver;
    }
}
