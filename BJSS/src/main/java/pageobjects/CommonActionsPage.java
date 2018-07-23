package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonActionsPage extends BaseObject {
    public CommonActionsPage(WebDriver driver) {
        super(driver);
    }


    private static By quickViewButton = By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[2]/span");
    private static By mouseOverAction = By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");

    public WebElement mouseOverAction() {
        waitForElementToBeVisible(mouseOverAction);
        return getElement(mouseOverAction);
    }

    public void clickQuickViewButton() {
        waitForElementToBeClickable(quickViewButton);
        click(quickViewButton);
    }
}

