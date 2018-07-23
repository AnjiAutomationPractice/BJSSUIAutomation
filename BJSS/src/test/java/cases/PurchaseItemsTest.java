package cases;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import setup.TestConfiguration;
import utilities.MultipleFramesHandle;
import utilities.Wait;
import java.text.DecimalFormat;
import java.util.Collection;
import static java.lang.System.getProperty;
import static org.testng.Assert.assertEquals;
import static utilities.DataFiles.csvFileAsCollectionOfStringArrays;

@RunWith(Parameterized.class)
public class PurchaseItemsTest extends BaseTest {
    private String inputSize;
    private String expectedcasualDressSize;
    private String expectedeveningDressSize;
    private String expectedcasualDressUnitPrice;
    private String expectedeveningDressUnitPrice;
    private String expectedOrderSuccessMessage;


    public PurchaseItemsTest(String inputSize, String expectedcasualDressSize, String expectedeveningDressSize, String expectedcasualDressUnitPrice, String expectedeveningDressUnitPrice, String expectedOrderSuccessMessage ) {
        this.inputSize = inputSize;
        this.expectedcasualDressSize = expectedcasualDressSize;
        this.expectedeveningDressSize = expectedeveningDressSize;
        this.expectedcasualDressUnitPrice = expectedcasualDressUnitPrice;
        this.expectedeveningDressUnitPrice = expectedeveningDressUnitPrice;
        this.expectedOrderSuccessMessage = expectedOrderSuccessMessage;

    }

    @Parameterized.Parameters
    public static Collection data() {
        String projectDirectory = getProperty("user.dir");
        return csvFileAsCollectionOfStringArrays(projectDirectory + "/src/test/resources/data/" + "PurchaseItemsTest.csv");
    }

    @Before
    public void testSetup(){
        super.testSetup();
    }

    @Test
    public void canAbleToPurchaseItems() {
        double casualDressTotalPrice=0;
        double eveningDressTotalPrice=0;
        double totalProductsPrice=0;
        double totalShippingPrice=0;
        double total=0;

        //Quick view an item
        assertEquals(home.getPageTitle(), home.expectedHomePageTitle());
        Wait.wait1sec();
        home.clickDressesButton();
        Wait.wait5sec();
        home.clickCasualDressesButton();
        actions.moveToElement(commonActions.mouseOverAction()).perform();
        commonActions.clickQuickViewButton();
        Wait.wait5sec();
        MultipleFramesHandle.switchToFrame(0);
        Wait.wait1sec();

        //Change the size of the item
        Select select = new Select(quickView.selectSizeDropDown());
        select.selectByVisibleText(inputSize);

        //Add the item to the basket
        quickView.clickAddToCartButton();
        MultipleFramesHandle.switchToDefaultWindow();

        //Continue shopping
        quickView.clickContinueShoppingButton();
        Wait.wait1sec();
        home.clickDressesButton();
        Wait.wait5sec();
        home.clickEveningDressesButton();
        Wait.wait5sec();
        actions.moveToElement(commonActions.mouseOverAction()).perform();

        //Quick view a different item
        commonActions.clickQuickViewButton();
        Wait.wait5sec();
        MultipleFramesHandle.switchToFrame(0);

        //Add the item to your basket
        quickView.clickAddToCartButton();
        driver.switchTo().defaultContent();
        Wait.wait1sec();
        quickView.clickProceedToCheckoutButton();
        Wait.wait1sec();

        //View basket - Check the Size and peice is correct
        actions.moveToElement(viewBasket.mouseOverAction()).perform();
        String casualDressSizeInBasket = viewBasket.getSize("1");
        Assert.assertTrue(casualDressSizeInBasket.endsWith("L"), "The dress size does not match" );
        String eveningDressSizeInBasket = viewBasket.getSize("2");
        Assert.assertTrue(eveningDressSizeInBasket.endsWith("S"), "The dress size does not match" );
        String casualDressUnitPriceInBasket = viewBasket.getUnitPrice("1");
        assertEquals(casualDressUnitPriceInBasket, expectedcasualDressUnitPrice);
        String eveningDressUnitPriceInBasket = viewBasket.getUnitPrice("2");
        assertEquals(eveningDressUnitPriceInBasket, expectedeveningDressUnitPrice );

        //Summary page - Check the Size is correct
        String casualDressSize = summary.getSize("3_15_0_0");
        Assert.assertTrue(casualDressSize.contains(expectedcasualDressSize), "The dress size does not match" );
        String eveningDressSize = summary.getSize("4_16_0_0");
        Assert.assertTrue(eveningDressSize.contains(expectedeveningDressSize), "The dress size does not match" );

        //Summary page - Check the price is correct
        String casualDressUnitPrice = summary.getUnitPrice("3_15_0");
        assertEquals(casualDressUnitPrice, expectedcasualDressUnitPrice);
        String eveningDressUnitPrice = summary.getUnitPrice("4_16_0");
        assertEquals(eveningDressUnitPrice, expectedeveningDressUnitPrice );

        //Summary page - Check the total products price is equal to sum of individual products
        String casualTotalPrice = summary.getTotalPrice("3_15_0");
        try {
            casualDressTotalPrice = Double.parseDouble(casualTotalPrice);
        } catch (Exception e) {
            System.out.println(e);
        }
        String eveningTotalPrice = summary.getTotalPrice("4_16_0");
        try {
            eveningDressTotalPrice = Double.parseDouble(eveningTotalPrice);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            totalProductsPrice = Double.parseDouble(summary.getTotalProductsPrice());
        } catch (Exception e) {
            System.out.println(e);
        }
        DecimalFormat decimalFormat = new DecimalFormat(".##");
        double sumOfIndividualItems= (eveningDressTotalPrice+casualDressTotalPrice);
        assertEquals(Double.parseDouble(decimalFormat.format(sumOfIndividualItems)),totalProductsPrice);


        //Summary page - Check the total is equal to the sum of individual products + shipping price
        try{
            totalShippingPrice = Double.parseDouble(summary.getTotalShipping());
        }catch (Exception e) {
            System.out.println(e);
        }
        try{
            total = Double.parseDouble(summary.getTotal());
        }catch (Exception e) {
            System.out.println(e);
        }
        assertEquals(totalShippingPrice+totalProductsPrice,total );
        summary.clickProceedToCheckOutButton();
        Wait.wait5sec();

        //Signin Page
        signIn.setEmailField(TestConfiguration.email);
        signIn.setPasswordField(TestConfiguration.password);
        signIn.clickSubmitButton();
        Wait.wait5sec();

        //Address page
        assertEquals(address.getPageTitle(), address.expectedAddressPageTitle());
        address.clickProceedToCheckOutButton();
        Wait.wait5sec();

        //Shipping page
        assertEquals(ship.getPageTitle(), ship.expectedShippingPageTitle() );
        Wait.wait5sec();
        ship.selectTermsOfServieCheckBox();
        ship.clickProceedToCheckOutButton();

        //Payment page
        payment.clickPayByBankWireButton();
        assertEquals(payment.getPageTitle(), payment.expectedPaymentPageTitle() );
        payment.clickConfirmMyOrderButton();
        assertEquals(payment.getOrderSuccessMessage(), expectedOrderSuccessMessage  );
        signIn.clickSignOutButton();

    }
    @After
    public void testTearDown(){
        destroyDriver();
    }

}












