package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestConfiguration;

import java.util.List;

public abstract class BaseObject {
    public static WebDriver driver;
    private static int timeout = 15;
    public WebDriverWait wait;

    public BaseObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() { return driver.getTitle(); }

    public void getURL(String url) {
        driver.get(url);
    }

    public String getCurrentURL(){
        try {
            return driver.getCurrentUrl();
        } catch (Exception e){
            throw new WebDriverException("Could not get the current URL");
        }
    }

    public WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (Exception e) {
            System.out.println("The element" + selector.toString() + " could not be found");
        }
        return null;
    }

    public List<WebElement> getElements(By selector) {
        try {
            return driver.findElements(selector);
        } catch (Exception e) {
            System.out.println("The elements" + selector.toString() + " could not be found");
        }
        return null;
    }

    public String getElementText(By selector){
        waitForElementToBeVisible(selector);
        try{
            return driver.findElement(selector).getText();
        }catch (Exception e){
            System.out.println("The element " +selector.toString() + " does not exist");
        }
        return null;
    }
    public String getText(By selector){
        waitForElementToBeVisible(selector);
        try{
            return driver.findElement(selector).getText();
        }catch (Exception e){
            System.out.println("The text " +selector.toString() + " does not exist");
        }
        return null;
    }

    public void click(By selector) {
        WebElement element = getElement(selector);
        waitForElementToBeClickable(selector);
        try {
            element.click();
        } catch (Exception e) {
            throw new WebDriverException("The element " + selector.toString() + " is not clickable");
        }

    }

    public void clearField(WebElement element) {
        try {
            element.clear();
            waitForElementTextToBeEmpty(element);
        } catch (Exception e) {
            //System.out.println("The element " + element.toString() + " could not be cleared");
        }
    }

    public void sendKeys(By selector, String value) {
        WebElement element = getElement(selector);
        clearField(element);
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            throw new WebDriverException("Error in sending " + value + " to element " + selector.toString());
        }
    }

    public void selectByValue(By selector, String value) {
        try {
            Select select = new Select(getElement(selector));
            select.selectByValue(value);
        } catch (Exception e) {
            System.out.println("Error selecting value " + value + " from element " + selector.toString());
        }
    }

    public void selectByVisibleText(By selector, String value) {
        try {
            Select select = new Select(getElement(selector));
            select.selectByVisibleText(value);
        } catch (Exception e) {
            System.out.println("Error selecting value " + value + " from element " + selector.toString());
        }
    }

    public void waitForElementToBeVisible(By selector) {
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        } catch (Exception e) {
            throw new NoSuchElementException("The element " + selector.toString() + " did not become visible");
        }
    }

    public void waitForElementToBeClickable(By selector) {
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
        } catch (Exception e) {
            throw new WebDriverException("The element " + selector.toString() + " is not clickable");
        }
    }

    public void waitForElementTextToBeEmpty(WebElement element) {
        String text;
        try {
            text = element.getText();
            int maxRetries = 3;
            int retry = 0;
            while ((text.length() >= 1) || (retry < maxRetries)) {
                retry++;
                text = element.getText();
            }
        } catch (Exception e) {
            System.out.println("The element " + element.toString() + " was not cleared");
        }
    }



    }











