package CCP_LAP.PlaywrightAutomation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import framework.SikuliElementsMobile;
import framework.SikuliHelperMobile;
import framework.RandomNumberUtil;
import org.sikuli.script.Match;

import java.util.Arrays;
import java.util.List;

public class ccpLAPODMobile {
    public static void main(String[] args) throws Exception {
        Playwright playwright = null;
        Browser browser = null;

        try {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized")));

            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(400, 564)
                    .setGeolocation(new Geolocation(13.0827, 80.2707))
                    .setTimezoneId("Asia/Kolkata"));

            context.grantPermissions(List.of("geolocation"));
            context.clearCookies();

            Page page = context.newPage();
            page.navigate("https://ccppreprod02.chola.murugappa.com");

            page.locator("xpath = //h3[contains(text(),'Loan Against Property')]").click();
            page.locator("xpath=//input[@name='username']").fill("jasperrajkumar");
            page.locator("xpath=//input[@name='password']").fill("Jas$098098");
            page.click("xpath=(//input[@id='kc-login'])");

            Thread.sleep(5000);

            SikuliHelperMobile.paste(SikuliElementsMobile.SEARCHBAR, "HE01WFC00000103029");
            page.keyboard().press("Enter");
            Thread.sleep(1000);

            SikuliHelperMobile.click(SikuliElementsMobile.CONTACT_RECORDING);
            SikuliHelperMobile.click(SikuliElementsMobile.SURVEY_TYPE);
            SikuliHelperMobile.pressArrowDown(2);
            SikuliHelperMobile.pressEnter();
            SikuliHelperMobile.click(SikuliElementsMobile.Q1);
            SikuliHelperMobile.pressEnter();
            SikuliHelperMobile.click(SikuliElementsMobile.Q2);
            SikuliHelperMobile.pressEnter();
            SikuliHelperMobile.paste(SikuliElementsMobile.Q3, "Loan Cancelation");
            SikuliHelperMobile.click(SikuliElementsMobile.NEXT);
            SikuliHelperMobile.click(SikuliElementsMobile.SUBMIT);

            fillCashReceiptFlow();
            fillChequeReceiptFlow(page);
            fillDraftReceiptFlow(page);
            fillRTGSReceiptFlow(page);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startCommonReceiptFlow(String mode) throws Exception {
        SikuliHelperMobile.click(SikuliElementsMobile.NEW_RECEIPT);
        Thread.sleep(1000);
        SikuliHelperMobile.click(SikuliElementsMobile.RECEIPT_TYPE);
        SikuliHelperMobile.click(SikuliElementsMobile.SELECT_OVERDUE);
        Thread.sleep(1000);
        SikuliHelperMobile.click(SikuliElementsMobile.CONTINUE);
        Thread.sleep(1000);
        SikuliHelperMobile.click(SikuliElementsMobile.CUSTOMER);
        SikuliHelperMobile.scrollDown(1);

        if (mode.equals("Cheque")) {
            SikuliHelperMobile.click(SikuliElementsMobile.CHEQUE_MODE);
        } else if (mode.equals("Draft")) {
            SikuliHelperMobile.click(SikuliElementsMobile.DRAFT_MODE);
        } else if (mode.equals("RTGS")) {
            SikuliHelperMobile.click(SikuliElementsMobile.RTGS_MODE);
        }
    }

    public static void fillCashReceiptFlow() throws Exception {
        startCommonReceiptFlow("Cash");
        SikuliHelperMobile.paste(SikuliElementsMobile.MOBILE_NO, "9566090276");
        Thread.sleep(1000);
        SikuliHelperMobile.paste(SikuliElementsMobile.AMOUNT, "1");
        SikuliHelperMobile.scrollDown(5);
        SikuliHelperMobile.paste(SikuliElementsMobile.ADVANCE_EMI, "1");
        SikuliHelperMobile.scrollDown(4);
        finishReceiptFlow();
    }

    public static void fillChequeReceiptFlow(Page page) throws Exception {
        startCommonReceiptFlow("Cheque");
        SikuliHelperMobile.paste(SikuliElementsMobile.MOBILE_NO, "9566090276");
        SikuliHelperMobile.paste(SikuliElementsMobile.AMOUNT, "1");
        SikuliHelperMobile.scrollDown(1);
        SikuliHelperMobile.paste(SikuliElementsMobile.ACC_NO, "12345678901");
        SikuliHelperMobile.paste(SikuliElementsMobile.MICR, "520002007");
        page.keyboard().press("Tab");
        SikuliHelperMobile.scrollDown(1);

        String instNo = RandomNumberUtil.generateSixDigitNumber();
        System.out.println("Generated Cheque Instrument No: " + instNo);
        SikuliHelperMobile.paste(SikuliElementsMobile.INSTRUMENT_NO, instNo);
        uploadAttachment();
        SikuliHelperMobile.scrollDown(4);
        SikuliHelperMobile.paste(SikuliElementsMobile.ADVANCE_EMI, "1");

        

        finishReceiptFlow();
    }

    public static void fillDraftReceiptFlow(Page page) throws Exception {
        startCommonReceiptFlow("Draft");
        SikuliHelperMobile.paste(SikuliElementsMobile.MOBILE_NO, "9566090276");
        SikuliHelperMobile.paste(SikuliElementsMobile.AMOUNT, "1");
        SikuliHelperMobile.scrollDown(1);
        SikuliHelperMobile.paste(SikuliElementsMobile.MICR, "520002008");
        page.keyboard().press("Tab");
        SikuliHelperMobile.scrollDown(1);
        String instNo = RandomNumberUtil.generateSixDigitNumber();
        System.out.println("Generated Draft Instrument No: " + instNo);
        SikuliHelperMobile.paste(SikuliElementsMobile.INSTRUMENT_NO, instNo);
        uploadAttachment();
        SikuliHelperMobile.scrollDown(4);
        SikuliHelperMobile.paste(SikuliElementsMobile.ADVANCE_EMI, "1");


        finishReceiptFlow();
    }

    public static void fillRTGSReceiptFlow(Page page) throws Exception {
        startCommonReceiptFlow("RTGS");
        SikuliHelperMobile.paste(SikuliElementsMobile.MOBILE_NO, "9566090276");
        SikuliHelperMobile.scrollDown(1);

        Match match = SikuliHelperMobile.find(SikuliElementsMobile.UTR_NO, 5);
        if (match != null) {
            SikuliHelperMobile.click(match);
            SikuliHelperMobile.pasteWithoutTarget("TestAuto09");
            Thread.sleep(1500);
            SikuliHelperMobile.clickOffset(match, 0, 35);
        }
        SikuliHelperMobile.scrollDown(1);
        uploadAttachment();
        SikuliHelperMobile.scrollDown(4);
        SikuliHelperMobile.paste(SikuliElementsMobile.ADVANCE_EMI, "1");
        SikuliHelperMobile.scrollDown(3);
 

        finishReceiptFlow();
    }

    public static void uploadAttachment() throws Exception {
        SikuliHelperMobile.click(SikuliElementsMobile.UPLOAD);
        Thread.sleep(2000);
        SikuliHelperMobile.pasteWithoutTarget("D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\email-example.jpg");
        Thread.sleep(1500);
        SikuliHelperMobile.pressEnter();
        Thread.sleep(1500);
        SikuliHelperMobile.scrollDown(1);
    }

    public static void finishReceiptFlow() throws Exception {
        SikuliHelperMobile.click(SikuliElementsMobile.PREVIEW);
        Thread.sleep(3000);
        SikuliHelperMobile.click(SikuliElementsMobile.SAVE);
        SikuliHelperMobile.scrollDown(3);
        Thread.sleep(3000);
        SikuliHelperMobile.click(SikuliElementsMobile.RECEIPT);
        SikuliHelperMobile.scrollDown(10);
        SikuliHelperMobile.click(SikuliElementsMobile.RECEIPT_CLOSE);
    }
}
