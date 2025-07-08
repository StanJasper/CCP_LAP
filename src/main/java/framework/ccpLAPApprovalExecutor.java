package framework;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Arrays;
import java.util.List;

public class ccpLAPApprovalExecutor {
    static String basePath = "D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources";

    public static void approveAs(String username, String password) throws Exception {
        Playwright playwright = null;
        Browser browser = null;

        try {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));

            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null)
                    .setGeolocation(new Geolocation(13.0827, 80.2707))
                    .setTimezoneId("Asia/Kolkata"));

            context.grantPermissions(List.of("geolocation"));
            context.clearCookies();

            Page page = context.newPage();
            page.navigate("https://ccppreprod02.chola.murugappa.com");

            // Login
            page.locator("xpath=//input[@name='username']").fill(username);
            page.locator("xpath=//input[@name='password']").fill(password);
            page.click("xpath=(//input[@id='kc-login'])");

            Thread.sleep(5000);

            // Sikuli-based approval steps
            Screen screen = new Screen();

            Pattern MyApprovals = new Pattern(basePath + "\\ppapproval\\MyApprovals.png");
            screen.click(MyApprovals);
            Thread.sleep(2000);

            Pattern AssignedTo = new Pattern(basePath + "\\ppapproval\\AssignedTo.png");
            screen.click(AssignedTo);

            Pattern ApprovalName = new Pattern(basePath + "\\ppapproval\\ApprovalName.png");
            screen.click(ApprovalName);
            Thread.sleep(1000);

            Pattern ApproveButton = new Pattern(basePath + "\\ppapproval\\ApproveButton.png");
            screen.click(ApproveButton);
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
        }
    }
}