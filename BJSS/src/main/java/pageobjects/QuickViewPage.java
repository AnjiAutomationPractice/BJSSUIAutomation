package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class QuickViewPage extends BaseObject {

    public QuickViewPage(WebDriver driver) {  super(driver);    }
    private static By sizeDropDown = By.id("group_1");
    private static By productAddedSuccessText = By.xpath(".//*[@id='layer_cart']/div[1]/div[1]/h2");
    private static By addToCartButton = By.name("Submit");
    private static By itemsInCartText = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/h2/span[2]");
    private static By proceedToCheckOutButton = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");
    private static By continueShoppingButton = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span");


    public WebElement selectSizeDropDown(){
        waitForElementToBeVisible(sizeDropDown);
        return getElement(sizeDropDown);
    }

    public void clickAddToCartButton() {
        waitForElementToBeClickable(addToCartButton);
        click(addToCartButton);
    }

    public String VerifyProductAddedSuccessText(){
        waitForElementToBeVisible(productAddedSuccessText);
        return getElementText(productAddedSuccessText);
    }

    public String VerifyItemsInCartText(){
        waitForElementToBeVisible(itemsInCartText);
        return getElementText(itemsInCartText);
    }

    public void clickContinueShoppingButton(){
        waitForElementToBeClickable(continueShoppingButton);
        click(continueShoppingButton);
    }

    public void clickProceedToCheckoutButton(){
        waitForElementToBeClickable(proceedToCheckOutButton);
        click(proceedToCheckOutButton);
    }
}
