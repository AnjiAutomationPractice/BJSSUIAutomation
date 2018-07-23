package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class AddressPage extends BaseObject {
    public AddressPage(WebDriver driver) {super(driver);}

    private static String addressPageTitle = "Order - My Store";
    private static By proceedToCheckOutButton = By.name("processAddress");

    public void clickProceedToCheckOutButton(){
        waitForElementToBeClickable(proceedToCheckOutButton);
        click(proceedToCheckOutButton);
    }

    public String expectedAddressPageTitle(){
        return addressPageTitle;
    }

}
