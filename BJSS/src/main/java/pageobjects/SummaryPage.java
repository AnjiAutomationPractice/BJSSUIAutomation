package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Wait;

//import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;


public class SummaryPage extends BaseObject {
    private static By totalProductsPrice = By.id("total_product");
    private static By totalShipping = By.id("total_shipping");
    private static By total = By.id("total_price");
    private static By proceedToCheckOutButton = By.xpath(".//*[@id='center_column']/p[2]/a[1]/span");


    public SummaryPage(WebDriver driver) {super(driver);}

    public String getTotalProductsPrice(){
        return getElementText(totalProductsPrice).substring(1);
    }

    public String getTotalShipping(){
        return getElementText(totalShipping).substring(1);
    }

    public String getTotal(){
        return getElementText(total).substring(1);
    }

    public String getSize(String number){
        By dressSize = By.xpath(".//*[@id='product_"+number+"']/td[2]/small[2]/a");
        waitForElementToBeVisible(dressSize);
        return getElementText(dressSize);
    }

    public String getUnitPrice(String number){
        By dressPrice = By.xpath(".//*[@id='product_price_"+number+"']/span");
        return getElementText(dressPrice).substring(1);
    }

    public String getTotalPrice(String number){
        By totalPrice = By.xpath(".//*[@id='total_product_price_"+number+"']");
        return getElementText(totalPrice).substring(1);
    }

    public void clickProceedToCheckOutButton(){
        waitForElementToBeClickable(proceedToCheckOutButton);
        click(proceedToCheckOutButton);
    }





}

