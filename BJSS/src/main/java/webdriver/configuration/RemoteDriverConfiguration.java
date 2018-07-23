package webdriver.configuration;

public class RemoteDriverConfiguration {
    public String browser;
    public String platform;
    public String browserVersion;

    public RemoteDriverConfiguration(String browser, String platform, String browserVersion) {
        this.browser = browser;
        this.platform = platform;
        this.browserVersion = browserVersion;
    }
}
