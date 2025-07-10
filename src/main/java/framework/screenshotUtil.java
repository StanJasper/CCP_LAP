package framework;

import com.microsoft.playwright.Page;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenshotUtil {

    public static void capture(Page page) {
        try {
            String baseFolder = ConfigReader.get("screenshot_path"); // e.g., D:\\Screenshots
            String runFolder = "CCP_LAP_" + runContext.runTimestamp;
            String fullFolderPath = Paths.get(baseFolder, runFolder).toString();

            File folder = new File(fullFolderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Automatically get the method that called this
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();

            String fileName = methodName + "_" + timestamp + ".png";
            String fullPath = Paths.get(fullFolderPath, fileName).toString();

            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(fullPath)));
            System.out.println("🖼️ Screenshot taken: " + fullPath);

        } catch (Exception e) {
            System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
        }
    }
}
