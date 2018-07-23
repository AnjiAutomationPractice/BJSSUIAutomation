package utilities;

import org.openqa.selenium.WebDriver;
import pageobjects.BaseObject;

import java.util.Set;

public class MultipleFramesHandle extends BaseObject {

    //private static WebDriver driver;
    //public static String defaultFrame =driver.getWindowHandle();

    public MultipleFramesHandle(WebDriver driver) {super(driver); }

    public static void switchToFrame(int frameIndex){
        driver.switchTo().frame(frameIndex);
    }

    public static void switchToDefaultWindow(){
        driver.switchTo().defaultContent();
    }

}
