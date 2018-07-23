package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BaseObject {
    public PaymentPage(WebDriver driver) {super(driver);}

    private static String paymentPageTitle = "My Store";
    private static By payByBankWireButton = By.xpath(".//*[@id='HOOK_PAYMENT']/div[1]/div/p/a");
    private static By confirmMyOrderButton = By.xpath(".//*[@id='cart_navigation']/button");
    private static By orderSuccessMassage = By.xpath(".//*[@id='center_column']/div/p/strong");

    public void clickPayByBankWireButton(){
        waitForElementToBeClickable(payByBankWireButton);
        click(payByBankWireButton);
    }

    public void clickConfirmMyOrderButton(){
        waitForElementToBeClickable(confirmMyOrderButton);
        click(confirmMyOrderButton);
    }

    public String getOrderSuccessMessage(){
        waitForElementToBeVisible(orderSuccessMassage);
        return getElementText(orderSuccessMassage);
    }

    public String expectedPaymentPageTitle(){
        return paymentPageTitle;
    }
}

