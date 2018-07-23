package cases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.SignInPage;

import java.util.Collection;

import static org.junit.Assert.assertTrue;
import static utilities.DataFiles.csvFileAsCollectionOfStringArrays;

@RunWith(Parameterized.class)
public class SignInTest extends BaseTest {
    private String email;
    private String password;

    public SignInTest(String username, String password) {
        this.email = username;
        this.password = password;}

    @Parameterized.Parameters
    public static Collection data() {
        String projectDirectory = System.getProperty("user.dir");
        return csvFileAsCollectionOfStringArrays(projectDirectory + "/src/test/resources/data/" + "SignInTest.csv");}

    @Before
    public void testSetup(){ createDriver(); }

    @Test
    public void signInTest(){
        signIn = new SignInPage(driver);
        home=new HomePage(driver);
        myAccount = new MyAccountPage(driver);

        signIn.get();
        driver.manage().window().maximize();
        home.clickSignInButton();
        signIn.setEmailField(this.email);
        signIn.setPasswordField(this.password);
        signIn.clickSubmitButton();
        assertTrue("Unsuccessful login", myAccount.isMyAccountPageIsDisplayed());

    }

    @After
    public void testTeardown() {
        destroyDriver();
    }
}






