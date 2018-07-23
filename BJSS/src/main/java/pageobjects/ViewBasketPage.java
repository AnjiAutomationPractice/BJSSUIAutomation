package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ViewBasketPage extends BaseObject {
    public ViewBasketPage(WebDriver driver) {super(driver);}
    private static By mouseOverAction = By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a");


    public WebElement mouseOverAction() {
        waitForElementToBeVisible(mouseOverAction);
        return getElement(mouseOverAction);
    }

    public String getSize(String number){
        By dressSize = By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt["+number+"]/div/div[2]/a");
        waitForElementToBeVisible(dressSize);
        return getElementText(dressSize).substring(4);
    }

    public String getUnitPrice(String number){
        By dressPrice = By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt["+number+"]/div/span");
        return getElementText(dressPrice).substring(1);
    }




}
