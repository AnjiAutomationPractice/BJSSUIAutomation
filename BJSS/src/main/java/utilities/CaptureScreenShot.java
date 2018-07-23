package utilities;


import com.google.common.annotations.VisibleForTesting;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;

public class CaptureScreenShot {
    public static String getScreenshot(WebDriver driver){
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
        File destination = new File(path);

        try
        {
            FileUtils.copyFile(src, destination);
        }
        catch (IOException e)
        {
            System.out.println("Capture Failed"+e.getMessage());
        }
        return path;
    }





}

