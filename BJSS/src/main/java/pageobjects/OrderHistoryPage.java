package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage extends BaseObject{

    private static By orderHistoryText = By.xpath("//*[@id='center_column']/h1");
    private static By orderReferenceLink = By.xpath("//*[@id='order-list']/tbody/tr[1]/td[1]/a");
    private static By messageTextArea = By.xpath("//*[@id='sendOrderMessage']/p[3]/textarea");
    private static By sendButton = By.xpath("//*[@id='sendOrderMessage']/div/button");
    private static By messageSuccessText = By.xpath("//*[@id='block-order-detail']/p");
    private static By dateText = By.xpath("//*[@id='order-list']/tbody/tr[1]/td[2]");
    private static By fromText = By.xpath("//*[@id='block-order-detail']/div[5]/table/tbody/tr[1]/td[1]");
    private static By messageText = By.xpath("//*[@id='block-order-detail']/div[5]/table/tbody/tr[1]/td[2]");


    public OrderHistoryPage(WebDriver driver){super(driver);}

    public String getOrderHistoryText(){
        waitForElementToBeVisible(orderHistoryText);
        return getElementText(orderHistoryText);
    }

    public void clickOrderReferenceLink(){
        waitForElementToBeClickable(orderReferenceLink);
        click(orderReferenceLink);
    }

    public void addAMessageText(String text){
        waitForElementToBeClickable(messageTextArea);
        sendKeys(messageTextArea, text);
    }

    public void clickSendButton(){
        waitForElementToBeClickable(sendButton);
        click(sendButton);
    }

    public String getMessageSuccessText(){
        waitForElementToBeVisible(messageSuccessText);
        return getElementText(messageSuccessText);
    }

    public String getDateText(){
        waitForElementToBeVisible(dateText);
        return getElementText(dateText);
    }

    public String getFromText(){
        waitForElementToBeVisible(fromText);
        return getElementText(fromText);
    }

    public String getMessageText(){
        waitForElementToBeVisible(messageText);
        return getElementText(messageText);
    }


}
