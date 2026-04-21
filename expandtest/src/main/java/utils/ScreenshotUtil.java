package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String path = "C:\\Users\\Bhavya Sree\\eclipse-workspace\\expandtest\\screenshot\\"
                + testName + "_" + timestamp + ".png";

        try {

            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            File dest = new File(path);
            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved at: " + path);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}