package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import setup.TestConfiguration;
import utilities.Wait;

public class SignInPage extends BaseObject {
    private static By signInButton = By.linkText("Sign in");
    private static By signOutButton = By.linkText("Sign out");
    private static By emailField = By.id("email");
    private static By passwordField = By.id("passwd");
    private static By forgotYourPasswordField = By.linkText("Forgot your password?");
    private static By submitButton = By.id("SubmitLogin");


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void get() {
        getURL(TestConfiguration.applicationURL);

    }


    public boolean signInPageIsDisplayed() {
        try {
            waitForElementToBeVisible(emailField);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setEmailField(String email) {
        waitForElementToBeVisible(emailField);
        sendKeys(emailField, email);
    }

    public void setPasswordField(String password) {
        waitForElementToBeVisible(passwordField);
        sendKeys(passwordField, password);
    }

    public void clickSignInButton() {
        click(signInButton);
    }

    public void clickSignOutButton() {
        waitForElementToBeClickable(signOutButton);
        click(signOutButton);
    }

    public void clickSubmitButton(){
        click(submitButton);
    }





}
