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

public class sikuliXOverdueCheque {

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
			page.locator("xpath=//input[@name='password']").fill("Jas$098098");
			page.click("xpath=(//input[@id='kc-login'])");

			context.grantPermissions(List.of("geolocation"));

			Thread.sleep(5000);

			// Wait for the page to load
		
			// Use SikuliX to find and click an image
			Screen screen = new Screen();
			
			// CLICKING ON THE AGREEMENT TAB

			Pattern Agreements = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Agreements.png");
			screen.click(Agreements);
			
			Thread.sleep(2000);

			// CLICKING SEARCH BAR AND SEARCH AGREEMENT

			Pattern searchbutton = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\AgreementSearch.png").targetOffset(297,0);
			screen.paste(searchbutton, "HE01MAM00000103840");
			page.keyboard().press("Enter");

			// CLICKING ON THE AGREEMENT

			Pattern Agreement = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\AgreementNo.png");
			screen.click(Agreement);
			
			Thread.sleep(1000);

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

			// CLICK CHEQUE

			Pattern Chequemode = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\ChequeMode.png");
			screen.click(Chequemode);

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
			
			// ENTER ACC NO

			Pattern AccNo = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\AccNo.png");
			screen.paste(AccNo, "12345678901");
			
			Thread.sleep(1000);

			// ENTER MICR

			Pattern Micr = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\MICR.png");
			screen.paste(Micr, "520002007");
			page.keyboard().press("Tab");

			// ENTER ADVANCE EMI

			Pattern AdvanceEMI = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\AdvanceEMI.png")
					.targetOffset(135, 0);

			screen.paste(AdvanceEMI, "1");

			screen.wheel(Button.WHEEL_DOWN, 4);
						
			Thread.sleep(1000);

			// ENTER INSTRUMENT NO

			Pattern InstNo = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\InstrumentNo.png");
			screen.paste(InstNo, "567005");			

			Thread.sleep(1000);

			// UPLOAD ATTACHMENT

			Pattern uploadButton = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Upload.png")
					.targetOffset(-46, 0);
			;
			screen.click(uploadButton);

			Thread.sleep(2000);

			screen.paste(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\email-example.jpg");

			screen.type(Key.ENTER); // or screen.click(openButton);

			Thread.sleep(1500);

			screen.wheel(Button.WHEEL_DOWN, 1);
						
			// CLICK PREVIEW

			Pattern Preview = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Preview.png");
			screen.click(Preview);

			Thread.sleep(2000);

			// CLICK SAVE

			Pattern Save = new Pattern(
					"D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\Save.png");
			screen.click(Save);
			
			Thread.sleep(2000);

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
