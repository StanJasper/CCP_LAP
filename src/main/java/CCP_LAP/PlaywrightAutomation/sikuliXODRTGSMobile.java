package CCP_LAP.PlaywrightAutomation;

import java.util.Arrays;
import java.util.List;

import org.sikuli.script.Button;
import org.sikuli.script.Key;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.LoadState;

public class sikuliXODRTGSMobile {
	public static void main(String[] args) throws Exception {

		Playwright playwright = null;
		Browser browser = null;

		try {
			playwright = Playwright.create();

			browser = playwright.chromium().launch(
					new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));

			System.out.println("New");

			// Create browser context with no viewport restrictions
			Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setViewportSize(400, 564)
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
			page.locator("xpath=//input[@name='password']").fill("Jas$098098");
			page.click("xpath=(//input[@id='kc-login'])");

			context.grantPermissions(List.of("geolocation"));

			Thread.sleep(5000);

			// Use SikuliX to find and click an image
			Screen screen = new Screen();

			// CLICKING SEARCH BAR AND SEARCH AGREEMENT

			Pattern searchbutton = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\searchbar.png");
			screen.paste(searchbutton, "HE01WFC00000103029");
			page.keyboard().press("Enter");
			Thread.sleep(1000);

			// CLICKING ON NEW RECEIPT BUTTON

			Pattern NewReceipt = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\newreceipt.png");
			screen.click(NewReceipt);
			
			Thread.sleep(1000);

//			// CLICKING ON CONTACT RECORDING BUTTON
//
//			Pattern ContactRecording = new Pattern(
//					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\contactrecording.png");
//			screen.click(ContactRecording);
//			
//			Thread.sleep(1000);	
//			
//			//CONTACT SURVEY TYPE
//			Pattern surveytype = new Pattern(
//					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\surveytype.png");
//			screen.click(surveytype);
//			
//			Thread.sleep(1000);	
//			
//			for (int i = 1; i < 3; i++) {
//			    page.keyboard().press("ArrowDown");
//			}
//			
//			page.keyboard().press("Enter");
//			
//			//SELECT Q1
//			Pattern Q1 = new Pattern(
//					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Q1.png");
//			screen.click(Q1);
//			
//			page.keyboard().press("Enter");
//
//			
//			Thread.sleep(1000);	
//			
//			//SELECT Q2
//			Pattern Q2 = new Pattern(
//					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Q2.png");
//			screen.click(Q2);
//			
//			page.keyboard().press("Enter");
//
//			
//			Thread.sleep(1000);	
//			
//			//SELECT Q3
//			Pattern Q3 = new Pattern(
//					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Q3.png");
//			screen.paste(Q3,"Loan Cancelation");
//			
//			Thread.sleep(1000);	
//			
//			//CLICK NEXT BUTTON
//			Pattern next = new Pattern(
//					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Next.png");
//			screen.click(next);
//			Thread.sleep(1000);	
//			
//			//CLICK SUBMIT BUTTON
//			Pattern submit = new Pattern(
//					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\submit.png");
//			screen.click(submit);
//			Thread.sleep(1000);	

//			// CLICKING ON NEW RECEIPT BUTTON AGAIN
//
//			Pattern NewReceiptclick = new Pattern(
//					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\newreceiptbutton.png");
//			screen.click(NewReceiptclick);
//
//			Thread.sleep(1000);

			// CLICKING ON RECEIPT TYPE DROPDOWN

			Pattern ReceiptType = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\ReceiptType.png")
					.targetOffset(0, -50);
			screen.click(ReceiptType);

			Thread.sleep(1500);

			// SELECT OVERDUE RECEIPT TYPE

			Pattern SelectOverdue = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\SelectReceiptType.png")
					.targetOffset(-140, -70);
			screen.click(SelectOverdue);

			Thread.sleep(1000);

			// CLICK CONTINUE BUTTON

			Pattern Continue = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Continue.png");
			screen.click(Continue);

			Thread.sleep(1000);

			// CLICK CUSTOMER BUTTON

			Pattern Customer = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Customer.png");
			screen.click(Customer);

			Thread.sleep(1000);

			screen.wheel(Button.WHEEL_DOWN, 1);



			// CLICK RTGS

			Pattern RTGSmode = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\RTGS.png");
			screen.click(RTGSmode);

			// ENTER MOBILE NO

			Pattern MobileNo = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\MobileNo.png");
			screen.paste(MobileNo, "9566090276");

			screen.wheel(Button.WHEEL_DOWN, 1);

			Thread.sleep(1000);

			// ENTER UTR NO

			Pattern UTRNofield = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\UTRNo.png");

			Match match = screen.exists(UTRNofield, 5);
			if (match != null) {
				screen.click(match);
				screen.paste("TestAuto07");

				Thread.sleep(1500);

				Location belowField = match.getTarget().offset(0, 35);
				screen.click(belowField);

				System.out.println("Clicked the suggestion below UTR field.");
			} else {
				System.out.println("UTR field not found on screen.");
			}
			
			screen.wheel(Button.WHEEL_DOWN, 1);


			// UPLOAD ATTACHMENT

			Pattern uploadButton = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Upload.png")
					.targetOffset(-52, 12);
			;
			screen.click(uploadButton);

			Thread.sleep(2000);

			screen.paste(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\email-example.jpg");

			screen.type(Key.ENTER); // or screen.click(openButton);

			Thread.sleep(1500);

			screen.wheel(Button.WHEEL_DOWN, 5);

			// ENTER ADVANCE EMI

			Pattern AdvanceEMI = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\AdvanceEMI.png")
					.targetOffset(135, 0);

			screen.paste(AdvanceEMI, "1");

			Thread.sleep(1000);

			screen.wheel(Button.WHEEL_DOWN, 1);

			// CLICK PREVIEW

			Pattern Preview = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Preview.png");
			screen.click(Preview);

			Thread.sleep(2000);

			// CLICK SAVE

			Pattern Save = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Save.png");
			screen.click(Save);

			Thread.sleep(2000);

			// RECEIPT VIEW

			Pattern Receipt = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Receipt.png");
			screen.click(Receipt);

			screen.wheel(Button.WHEEL_DOWN, 10);

			// RECEIPT CLOSE

			Pattern ReceiptClose = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\Close.png");
			screen.click(ReceiptClose);

		} catch (Exception e) {
			e.printStackTrace();
		} /*
			 * finally { if (browser != null) { browser.close(); } if (playwright != null) {
			 * playwright.close(); } }
			 */
	}
}
