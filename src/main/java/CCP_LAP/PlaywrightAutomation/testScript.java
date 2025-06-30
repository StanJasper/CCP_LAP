package CCP_LAP.PlaywrightAutomation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.Geolocation;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class testScript {

    public static void main(String[] args) throws Exception {

        Playwright playwright = null;
        Browser browser = null;
        
        System.out.println("New");

        try {
			playwright = Playwright.create();

			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
					.setArgs(Arrays.asList("--start-maximized")).setChannel("chrome"));
			
		//	browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)
			//		.setArgs(Arrays.asList("--start-maximized")));

			// Create browser context with no viewport restrictions
			Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
	                .setViewportSize(null)
	                .setGeolocation(new Geolocation(13.0827, 80.2707)) // Chennai, India
	                .setTimezoneId("Asia/Kolkata");
			BrowserContext context = browser.newContext(contextOptions);
			
			context.grantPermissions(List.of("geolocation"));
			
			context.clearCookies();

			// Open a new page
			Page page = context.newPage();
		//	page.navigate("https://ccpdev01.chola.murugappa.com/#/agreements/1");
			
			page.navigate("https://ccppreprod02.chola.murugappa.com/#/agreements/148902");
			
			//page.navigate("https://ccppreprod02.chola.murugappa.com");


			page.locator("xpath=//input[@name='username']").fill("jasperrajkumar");
			page.locator("xpath=//input[@name='password']").fill("Jas@098098");
			page.click("xpath=(//input[@id='kc-login'])");
			
			context.grantPermissions(List.of("geolocation"));

			Thread.sleep(2000);
			
            // Wait for the page to load
            Thread.sleep(2000);

            // Locate the region where "New Receipt" is located
            Locator region1 = page.locator(".web-selectable-region-context-menu").first();

            // Wait for the region to be visible
            region1.waitFor();

            // Get the bounding box of the region
            BoundingBox newreceipt = region1.boundingBox();

            if (newreceipt != null) {
                // Define your absolute target coordinates (X: 117, Y: 41)
                double targetX = 755; // Absolute X coordinate on the page
                double targetY = 148;  // Absolute Y coordinate on the page

                // Log mouse hover and click action
                System.out.println("Moving mouse to: (" + targetX + ", " + targetY + ")");

                // Move the mouse to the target point
                page.mouse().move(targetX, targetY);

                // Optional: Wait for some time to simulate hover effect
                page.waitForTimeout(1000);

                // Click at the target position
                System.out.println("Clicking at: (" + targetX + ", " + targetY + ")");
                page.mouse().click(targetX, targetY);
                
                
                
                
                // Take a screenshot for visual confirmation
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot_after_click.png")));

                System.out.println("Hovered and clicked at absolute position (" + targetX + ", " + targetY + ")");
            } else {
                System.out.println("Region not found or not visible.");
            }
            
            Thread.sleep(2000);
         

            // Proceed with the next actions in your script, such as selecting receipt type, filling form, etc.
//            page.locator("xpath=//input[@name='username']").fill("jasperrajkumar");
  //          page.locator("xpath=//input[@name='password']").fill("Jas@2025");
    //        page.click("xpath=(//input[@id='kc-login'])");

            // Additional script steps can follow here...

            Thread.sleep(2000); // Add delays as needed
            
            
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (browser != null) {
                browser.close();
            }
            if (playwright != null) {
                playwright.close();
            }
        }
    }
}
