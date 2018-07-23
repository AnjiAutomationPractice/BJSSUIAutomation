package cases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.*;
import setup.TestDriverFactory;
import utilities.CaptureScreenShot;

import java.io.IOException;

public abstract class BaseTest {
    ExtentHtmlReporter reporter;
    ExtentReports extent;
    ExtentTest logger;
    public  WebDriver driver;
    protected SignInPage signIn;
    protected MyAccountPage myAccount;
    protected HomePage home;
    protected QuickViewPage quickView;
    protected PaymentPage payment;
    protected Actions actions;
    protected CommonActionsPage commonActions;
    protected CasualDressesPage casualDresses;
    protected EveningDressesPage eveningDresses;
    protected SummaryPage summary;
    protected AddressPage address;
    protected ShippingPage ship;
    protected OrderHistoryPage orderHistory;
    protected ViewBasketPage viewBasket;



    public void createDriver() {
        driver = new TestDriverFactory().createDriver();
    }

    public void destroyDriver() {
        driver.quit();
    }


    public void signIn()  {
        signIn = new SignInPage(driver);
        myAccount = new MyAccountPage(driver);
        home = new HomePage(driver);
        quickView = new QuickViewPage(driver);
        actions = new Actions(driver);
        commonActions = new CommonActionsPage(driver);
        casualDresses = new CasualDressesPage(driver);
        eveningDresses = new EveningDressesPage(driver);
        summary = new SummaryPage(driver);
        address = new AddressPage(driver);
        ship = new ShippingPage(driver);
        payment=new PaymentPage(driver);
        orderHistory = new OrderHistoryPage(driver);
        viewBasket = new ViewBasketPage(driver);
        signIn.get();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void testSetup() {
        reporter = new ExtentHtmlReporter("./Reports/AutomationPractice.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        logger=extent.createTest("BJJSTesting");
        extent.flush();
        createDriver();
        signIn();
    }

    @AfterMethod
    public void testTeardown(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE)
        {
            String temp = CaptureScreenShot.getScreenshot(driver);
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }
        extent.flush();
        destroyDriver();
    }

}
