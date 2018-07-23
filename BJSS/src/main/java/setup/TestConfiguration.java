package setup;

import java.io.IOException;

import static setup.LoadProperties.getPropertyValue;

public class TestConfiguration {
    public static boolean remote;
    public static String browser;
    public static String platform;
    public static String browserVersion;
    public static String applicationURL;
    public static String email;
    public static String password;


    static {
        try {
            remote = Boolean.parseBoolean(getPropertyValue("test.properties", "Remote"));
            browser = getPropertyValue("test.properties", "Browser");
            platform = getPropertyValue("test.properties", "Platform");
            browserVersion = getPropertyValue("test.properties", "BrowserVersion");
            applicationURL = getPropertyValue("test.properties", "ApplicationURL");
            email = getPropertyValue("test.properties", "Email");
            password = getPropertyValue("test.properties", "Password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
