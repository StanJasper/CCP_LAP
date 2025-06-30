package CCP_LAP.PlaywrightAutomation;

import java.util.Arrays;
import java.util.List;

import org.sikuli.script.Button;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.LoadState;

public class sikuliXoverduecash {
	public static void main(String[] args) throws Exception {

		Playwright playwright = null;
		Browser browser = null;

		try {
			playwright = Playwright.create();

			browser = playwright.chromium().launch(
					new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));

			System.out.println("New");

			// Create browser context with no viewport restrictions
			Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setViewportSize(null)
					.setGeolocation(new Geolocation(13.0827, 80.2707)) // Chennai, India
					.setTimezoneId("Asia/Kolkata");
			BrowserContext context = browser.newContext(contextOptions);

			context.grantPermissions(List.of("geolocation"));

			context.clearCookies();

			// Open a new page
			Page page = context.newPage();
		
			page.navigate("https://ccppreprod02.chola.murugappa.com");

			page.locator("xpath = //h3[contains(text(),'Loan Against Property')]").click();

			page.locator("xpath=//input[@name='username']").fill("jasperrajkumar");
			page.locator("xpath=//input[@name='password']").fill("Jas@098098");
			page.click("xpath=(//input[@id='kc-login'])");

			context.grantPermissions(List.of("geolocation"));

			Thread.sleep(5000);
			
			// ✅ Step 4: Wait for page to finish loading before injecting
			page.waitForLoadState(LoadState.NETWORKIDLE);

			// ✅ Step 5: Inject the new token
			String newToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXNpZ25hdGlvbiI6IlRlbGxlciIsInVzZXJJZCI6IkNGMTk0NzMiLCJlbXBsb3llZU5hbWUiOiJBbnVwcml5YSAgUiIsImVtYWlsSWQiOiJhbnVwcml5YXJhbXVAY2hvbGExLm11cnVnYXBwYS5jb20iLCJicmFuY2hJZCI6IjUwMDAwMDIiLCJhcmVhSWQiOiIzMjkiLCJyZWdpb25JZCI6IjIxOCIsInpvbmVJZCI6IjEwMSIsInRlcnJpdG9yeVR5cGUiOiJCUkFOQ0giLCJ2ZXJ0aWNhbCI6ImNzZWwiLCJwZXJtaXNzaW9ucyI6WyJ2aWV3Q3VzdG9tZXIiLCJjYW5WaWV3Q3VzdG9tZXIiLCJ2aWV3Q29udGFjdCIsInZpZXdBZ3JlZW1lbnQiLCJjYW5SYWlzZVNldHRsZW1lbnRXYWl2ZXJBcHByb3ZhbCIsImNhbkdlbmVyYXRlU29hIiwiY2FuRG9Gb3JlY2xvc3VyZVdhaXZlckFwcHJvdmFsIiwiY2FuUmFpc2VEcnRBcHByb3ZhbCIsImNhbkRvUmVjZWlwdCIsImNhbkRvU2VsZnBheSIsImNhblJhaXNlQ2hhcmdlV2FpdmVyQXBwcm92YWwiLCJjYW5Eb1J0Z3NTcGxpdCIsImNhbkRvQ2FuY2VsRU9ERENSIiwiY2FuRG9FT0REQ1IiLCJ2aWV3Q2hhbGxhbiIsImNhblJlYXNzaWduQXV0aG9yaXplQ2hhbGxhbiIsImNhbkF1dGhvcml6ZUNoYWxsYW4iLCJjYW5Eb0VkaXRDaGFsbGFuIiwiY2FuRG9BaXJ0ZWxEZXBvc2l0IiwiY2FuRG9DaGFsbGFuIiwidmlld0JhdGNoIiwiY2FuRG9CYXRjaCIsInZpZXdSZWNlaXB0IiwiY2FuRG9SZXByaW50UmVjZWlwdCIsImNhbkRvQ2FuY2VsUmVjZWlwdCIsImNhbkRvRU1EUmVjZWlwdCIsImNhbkRvUGFydHBheW1lbnRSZWNlaXB0IiwiY2FuRG9Gb3JlY2xvc3VyZVJlY2VpcHQiLCJjYW5Eb092ZXJkdWVSZWNlaXB0IiwiY2FuRG9BbGxvY2F0aW9uIiwidmlld1VzZXJBbGxvY2F0aW9ucyIsImNhblZpZXdBcHByb3ZhbCIsImNhblVwZGF0ZUFwcHJvdmFsIiwiY2FuU2VuZFNlbGZQYXlMaW5rIiwidmlld0NoYXJnZVdhaXZlckFwcHJvdmFsIiwidmlld1J1bGVUZW1wbGF0ZSIsImNhbkRvQnVsa1VwbG9hZCIsImNhblZpZXdVc2VyUHJvZmlsZSIsImNhblNlbmRTbXMiLCJjYW5HZW5lcmF0ZVBhcnRQYXltZW50IiwiY2FuVmlld1NvYUludGVyZmFjZSIsImNhbkNoZWNrUGF5bWVudFN0YXR1cyIsImNhblZlcmlmeVBhbiIsImNhblZpZXdSZXBheW1lbnRTY2hlZHVsZSIsImNhblZpZXdPdGhlckNoYXJnZXMiLCJjcmVhdGVMZWdhbCIsInVwZGF0ZUxlZ2FsIiwiY2FuRG9HbG9iYWxTZWFyY2giLCJjYW5WaWV3VGVsbGVycyIsImNhblVwZGF0ZUFncmVlbWVudCIsImNhbkRvQkJQU1BheW1lbnQiLCJjYW5Eb0FwcHJvdmFsIiwiY2FuVmlld1VzZXJzIiwiY2FuVmlld1NhbGVEZWF0aWwiLCJjYW5Eb1NhbGVFeHRlbnNpb24iLCJjYW5Eb1NldHRsZW1lbnRSZWNlaXB0Iiwidmlld0FwcHJvdmFsIiwiY2FuQ3JlYXRlTm90aWZpY2F0aW9uIiwiY2FuRG9EcnRBcHByb3ZhbCIsImNhblZpZXdOb3RpZmljYWlvbiIsImNhbkNyZWF0ZUJ1eWVyIiwiY2FuRG9TYWxlZGV0YWlsIiwiY2FuRWRpdFNhbGVEZXRhaWwiLCJjYW5Eb0RlYWxDYW5jZWxsYXRpb25SZWNlaXB0IiwiY2FuQ3VzdG9tZXJEb1JlY2VpcHQiLCJjYW5DcmVhdGVTbWVSZXBvIiwiY2FuVXBkYXRlRmxhZ1N0YXR1cyIsInZpZXdCdXNpbmVzc0NvbmZpZyIsInZpZXdBbGxvY2F0aW9uIiwidmlld0NvbnRhY3RSZWNvcmRpbmciLCJjYW5Eb0NvbnRhY3RSZWNvcmRpbmciLCJ2aWV3U2FsZWRldGFpbCIsInZpZXdCdXllciIsInZpZXdTbWVSZXBvIiwiY2FuRG9SdGdzVXBsb2FkRGV0YWlscyIsImNhbkRvUnRnc1JlY2VpcHQiLCJ2aWV3UnRncyIsInZpZXdSdGdzRGV0YWlscyIsImNhblZpZXdDY3BBdXRoZW50aWNhdG9yIiwiY2FuQ3JlYXRlQ2NwQXV0aGVudGljYXRvciIsImNhblZpZXdSbXJSZXBvcnQiLCJ2aWV3QnVsa0RhdGFMb2FkSm9icyIsImNhblZpZXdTZXR0bGVtZW50UmVhc29uIiwiY2FuUmVhZENhc2hMaW1pdCIsImNhbkRvd25sb2FkVGVtcGxhdGUiLCJjYW5WaWV3UmVjZWlwdCIsInZpZXdFT0REQ1IiLCJjYW5DdXN0b21lckNyZWF0ZVJlY2VpcHQiXSwidXNlclR5cGUiOiJlbXBsb3llZSIsInN0YXR1cyI6IkEiLCJwcm9kdWN0IjoiQ1YiLCJicmFuY2hOYW1lIjoiVFJJQ0hZIENTRUwiLCJzZXNzaW9uSWQiOiJDRjE5NDczXzI1MDYyNzExMzE0NDhfcyIsInRva2VuVHlwZSI6ImFjY2VzcyIsImV4cGlyeUF0IjoiMjAyNS0wNy0wMlQxMTozMTo0NC44MTVaIiwiaWF0IjoxNzUxMDIzOTA0LCJleHAiOjE3NTE0NTU5MDR9.RhAkGcyOM47AmU-mv1gpL8rKlYE3qpfCknDsfpwagSk"; // trimmed for brevity

			// Use parameter injection — safer and avoids escape issues
			page.evaluate("token => localStorage.setItem('ccp.authToken', token)", newToken);

			// ✅ Step 6: Reload the page to apply new token
			//page.reload();
			
			page.navigate("https://ccppreprod02.chola.murugappa.com");

			// ✅ Optional: Confirm token was updated
			String appliedToken = page.evaluate("() => localStorage.getItem('ccp.authToken')").toString();
			System.out.println("🔐 Token in browser after reload: " + appliedToken);

			// Wait for the page to load
			Thread.sleep(2000);

			// Use SikuliX to find and click an image
			Screen screen = new Screen();
			
			// CLICKING ON THE AGREEMENT TAB

			Pattern Agreements = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Agreements.png");
			screen.click(Agreements);
			Thread.sleep(2000);

			// CLICKING SEARCH BAR AND SEARCH AGREEMENT

			Pattern searchbutton = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\searchbar.png");
			screen.paste(searchbutton, "HE01MAM00000103840");
			page.keyboard().press("Enter");
			Thread.sleep(1000);

			// CLICKING ON THE AGREEMENT

			Pattern Agreement = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\AgreementNo.png");
			screen.click(Agreement);

			// CLICKING ON NEW RECEIPT BUTTON

			Pattern NewReceipt = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\NewReceipt.png");
			screen.click(NewReceipt);
			
			Thread.sleep(1000);

			// CLICKING ON RECEIPT TYPE DROPDOWN

			Pattern ReceiptType = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\ReceiptType.png")
					.targetOffset(100, 0);
			screen.click(ReceiptType);

			// SELECT OVERDUE RECEIPT TYPE

			Pattern SelectOverdue = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\SelectReceiptType.png")
					.targetOffset(-100, -80);
			screen.click(SelectOverdue);

			Thread.sleep(1000);

			// CLICK CONTINUE BUTTON

			Pattern Continue = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Continue.png");
			screen.click(Continue);
			
			// ENTER MOBILE NO

						Pattern MobileNo = new Pattern(
								"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\MobileNo.png");
						screen.paste(MobileNo, "9566090276");

						Thread.sleep(1000);

						// ENTER AMOUNT

						Pattern Amount = new Pattern(
								"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Amount.png");
						screen.paste(Amount, "1");

						screen.wheel(Button.WHEEL_DOWN, 1);
						
						Thread.sleep(1000);
						
						
						// ENTER ADVANCE EMI

						Pattern AdvanceEMI = new Pattern(
								"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\AdvanceEMI.png")
								.targetOffset(135, 0);

						screen.paste(AdvanceEMI, "1");

						screen.wheel(Button.WHEEL_DOWN, 4);
									
						Thread.sleep(1000);
						
						// CLICK PREVIEW

						Pattern Preview = new Pattern(
								"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Preview.png");
						screen.click(Preview);

						Thread.sleep(2000);

						// CLICK SAVE

						Pattern Save = new Pattern(
								"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Save.png");
						screen.click(Save);
						
						Thread.sleep(1000);

						// RECEIPT VIEW

						Pattern Receipt = new Pattern(
								"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Receipt.png");
						screen.click(Receipt);
						
						
						screen.wheel(Button.WHEEL_DOWN, 10);


						// RECEIPT CLOSE

						Pattern ReceiptClose = new Pattern(
								"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Close.png");
						screen.click(ReceiptClose);



		} catch (Exception e) {
	e.printStackTrace();
} /*
	 * finally { if (browser != null) { browser.close(); } if (playwright != null) {
	 * playwright.close(); } }
	 */
}
}
