package cases;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.TestConfiguration;
import utilities.CaptureScreenShot;

public class CaptureImageTest extends BaseTest{


    @BeforeMethod
    public void testSetup(){
        super.testSetup();
        signIn.clickSignInButton();
        signIn.setEmailField(TestConfiguration.email);
        signIn.setPasswordField(TestConfiguration.password);
        signIn.clickSubmitButton();

    }

    @Test
    public void captureScreenShotOnFailure(){
        Assert.assertTrue(myAccount.isMyAccountPageIsDisplayed(), "unable to display my account page" );
        myAccount.clickOrderHistoryAndDetailsButton();
        Assert.assertEquals(orderHistory.getOrderHistoryText(), "Failed For Screenshot" , "The order history page is not displayed");
    }



}
