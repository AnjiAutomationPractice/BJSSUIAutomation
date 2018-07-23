package cases;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import setup.TestConfiguration;
import utilities.Wait;

import java.util.Collection;

import static java.lang.System.getProperty;
import static utilities.DataFiles.csvFileAsCollectionOfStringArrays;
@RunWith(Parameterized.class)
public class ReviewPreviousOrdersTest extends BaseTest {
    private String expectedMessageText;
    public ReviewPreviousOrdersTest(String text) {
            expectedMessageText = text;
        }

        @Parameterized.Parameters
        public static Collection data() {
        String projectDirectory = getProperty("user.dir");
        return csvFileAsCollectionOfStringArrays(projectDirectory + "/src/test/resources/data/" + "ReviewPreviousOrdersTest.csv");
    }

    @Before
    public void testSetup(){
        super.testSetup();
        signIn.clickSignInButton();
        signIn.setEmailField(TestConfiguration.email);
        signIn.setPasswordField(TestConfiguration.password);
        signIn.clickSubmitButton();

    }

    @Test
    public void canReviewTheOrder(){
        Assert.assertTrue(myAccount.isMyAccountPageIsDisplayed(), "unable to display my account page" );
        myAccount.clickOrderHistoryAndDetailsButton();
        Assert.assertEquals(orderHistory.getOrderHistoryText(), "ORDER HISTORY" , "The order history page is not displayed");
        String orderDate = orderHistory.getDateText();
        orderHistory.clickOrderReferenceLink();
        orderHistory.addAMessageText(expectedMessageText);
        orderHistory.clickSendButton();
        Wait.wait5sec();
        Assert.assertEquals("Message successfully sent", orderHistory.getMessageSuccessText(), "Your Comment has not been added");
        String messagesDate = orderHistory.getFromText();
        String actualMessageText = orderHistory.getMessageText();
        Assert.assertTrue(messagesDate.contains(orderDate), "The order date is different from the messages date");
        Assert.assertEquals(actualMessageText, expectedMessageText, "The comment does not match" );
        signIn.clickSignOutButton();

    }

    @After
    public void tearDown(){
        destroyDriver();
    }
}

