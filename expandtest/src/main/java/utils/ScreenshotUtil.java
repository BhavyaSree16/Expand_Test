package utils;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String name) {

        try {

            // Absolute project path
            String projectPath = System.getProperty("user.dir");

            // Folder path
            String folderPath = projectPath + "/screenshots/";

            // Create folder if not exists
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            // File path
            String filePath = folderPath + name + "_" + timestamp + ".png";

            // Take screenshot
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File dest = new File(filePath);

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved at: " + filePath);

        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
}