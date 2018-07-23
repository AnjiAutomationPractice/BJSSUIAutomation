package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BaseObject {
    public ShippingPage(WebDriver driver) {super(driver);}

    private static String shippingPageTitle = "Order - My Store";
    private static By termsOfServiceCheckBox=By.xpath(".//*[@id='form']/div/p[2]/label");
    private static By proceedToCheckOutButton = By.name("processCarrier");

    public void selectTermsOfServieCheckBox(){
        waitForElementToBeClickable(termsOfServiceCheckBox);
        click(termsOfServiceCheckBox);
    }

    public void clickProceedToCheckOutButton(){
        waitForElementToBeClickable(proceedToCheckOutButton);
        click(proceedToCheckOutButton);
    }

    public String expectedShippingPageTitle(){
        return shippingPageTitle;
    }

}


