package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CasualDressesPage extends BaseObject {
    public CasualDressesPage(WebDriver driver) {super(driver);}
    private static By mouseOverAction = By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");

    public WebElement mouseOverAction() {
        waitForElementToBeVisible(mouseOverAction);
        return getElement(mouseOverAction);
    }




}
