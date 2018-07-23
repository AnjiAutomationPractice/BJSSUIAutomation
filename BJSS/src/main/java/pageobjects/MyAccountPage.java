package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import setup.TestConfiguration;

public class MyAccountPage extends BaseObject {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void get() {
        getURL(TestConfiguration.applicationURL);
    }

    private static By orderHistoryAndDetailsButton = By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[1]/a/span");



    public boolean isMyAccountPageIsDisplayed() {
        try {
            waitForElementToBeVisible(orderHistoryAndDetailsButton);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void clickOrderHistoryAndDetailsButton(){
        waitForElementToBeClickable(orderHistoryAndDetailsButton);
        click(orderHistoryAndDetailsButton);
    }
}