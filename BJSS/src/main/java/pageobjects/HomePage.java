package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import setup.TestConfiguration;
import utilities.Wait;



public class HomePage extends BaseObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private static String homePageTitle = "My Store";
    private static By signInButton = By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a");
    private static By dressesButton = By.xpath(".//*[@id='block_top_menu']/ul/li[2]/a");
    private static By casualDressesButton = By.linkText("Casual Dresses");
    private static By eveningDressesButton = By.linkText("Evening Dresses");



    public void clickSignInButton() {
        waitForElementToBeClickable(signInButton);
        click(signInButton);
    }

    public void clickDressesButton() {
        waitForElementToBeClickable(dressesButton);
        click(dressesButton);
    }

    public void clickCasualDressesButton() {
        waitForElementToBeClickable(casualDressesButton);
        click(casualDressesButton);
    }

    public void clickEveningDressesButton() {
        waitForElementToBeClickable(eveningDressesButton);
        click(eveningDressesButton);
    }

    public String expectedHomePageTitle(){
        return homePageTitle;
    }


}


