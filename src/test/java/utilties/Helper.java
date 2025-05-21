package utilties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    public static void captureScreenshot(WebDriver driver , String screenshotname)
    {
        Path dest = Paths.get("./Screenshots",screenshotname+".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Excpetion while taking screenshot"+ e.getMessage());
        }
    }
   /* public static void attachScreenshotToAllure(String screenshotName) {
        Path screenshotPath = Paths.get("./Screenshots", screenshotName + ".png");
        if (Files.exists(screenshotPath)) {
            try {
                Allure.addAttachment("Screenshot", Files.newInputStream(screenshotPath));
            } catch (IOException e) {
                System.out.println("Failed to attach screenshot to Allure report: " + e.getMessage());
            }
        }*/
    }


