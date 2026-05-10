package website.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static website.utils.DriverUtils.getDriver;

public class ScreenshotUtil {

    public static String captureScreenshot() {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        String path = "screenshots/" + "Test" + "_" + timestamp + ".png";

        TakesScreenshot ts = (TakesScreenshot) getDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File(path);

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}