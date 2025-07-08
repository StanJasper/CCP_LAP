package CCP_LAP.PlaywrightAutomation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import framework.SikuliElements;
import framework.SikuliHelper;
import framework.ccpLAPApprovalExecutor;
import framework.ccpLAPpartPaymentApproval;
import framework.ConfigReader;
import framework.RandomNumberUtil;
import org.sikuli.script.*;

import java.util.Arrays;
import java.util.List;

public class ccpLAPpartPayment {
    public static void main(String[] args) throws Exception {
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
            page.navigate(ConfigReader.get("url"));

            page.locator("xpath = //h3[contains(text(),'Loan Against Property')]").click();
            page.locator("xpath=//input[@name='username']").fill(ConfigReader.get("username"));
            page.locator("xpath=//input[@name='password']").fill(ConfigReader.get("password"));
            page.click("xpath=(//input[@id='kc-login'])");

            Thread.sleep(5000);

            SikuliHelper.click(SikuliElements.AGREEMENTS);
            Thread.sleep(2000);
            SikuliHelper.paste(SikuliElements.SEARCHBAR, ConfigReader.get("agreement_no"));
            page.keyboard().press("Enter");
            Thread.sleep(1000);
            SikuliHelper.click(SikuliElements.AGREEMENT_NO);
            
         // Raise Approval before proceeding to receipting
            String approvalType = ConfigReader.get("approval_type"); // Should be either "tenure" or "emi"
            ccpLAPpartPaymentApproval.raiseApproval(approvalType);
            Thread.sleep(3000); // 
            
         // Approve as first approver
            ccpLAPApprovalExecutor.approveAs(
                ConfigReader.get("approver1_username"),
                ConfigReader.get("approver1_password")
            );

            // Approve as second approver
            ccpLAPApprovalExecutor.approveAs(
                ConfigReader.get("approver2_username"),
                ConfigReader.get("approver2_password")
            );

            // Continue with receipting...

            // Get mode and approval type from config
            String ppMode = ConfigReader.get("pp_mode").toLowerCase(); // cheque/draft/rtgs

            if (!ppMode.matches("cheque|draft|rtgs")) {
                throw new IllegalArgumentException("Invalid pp_mode in config. Must be cheque, draft, or rtgs.");
            }

           // reselectAgreement(page);

            switch (ppMode) {
                case "cheque":
                    fillChequeReceiptFlow(page);
                    break;
                case "draft":
                    fillDraftReceiptFlow(page);
                    break;
                case "rtgs":
                    fillRTGSReceiptFlow(page);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startCommonReceiptFlow(String mode) throws Exception {
        SikuliHelper.click(SikuliElements.NEW_RECEIPT);
        Thread.sleep(1000);
        SikuliHelper.click(SikuliElements.RECEIPT_TYPE);
        SikuliHelper.click(SikuliElements.SELECT_PP);
        Thread.sleep(1000);
        SikuliHelper.click(SikuliElements.CONTINUE);
        SikuliHelper.click(SikuliElements.CONSENT_UPLOAD);
        Thread.sleep(2000);
        SikuliHelper.pasteWithoutTarget("D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\email-example.jpg");
        Thread.sleep(1500);

        if (mode.equals("Cheque")) {
            SikuliHelper.click(SikuliElements.CHEQUE_MODE);
        } else if (mode.equals("Draft")) {
            SikuliHelper.click(SikuliElements.DRAFT_MODE);
        } else if (mode.equals("RTGS")) {
            SikuliHelper.click(SikuliElements.RTGS_MODE);
        }
    }

    public static void fillChequeReceiptFlow(Page page) throws Exception {
        startCommonReceiptFlow("Cheque");
        SikuliHelper.paste(SikuliElements.MOBILE_NO, ConfigReader.get("mobile_no"));
        Thread.sleep(1000);
        SikuliHelper.paste(SikuliElements.AMOUNT, "1");
        generatepartpayment();
        SikuliHelper.scrollDown(1);
        Thread.sleep(1000);
        SikuliHelper.paste(SikuliElements.ACC_NO, "12345678901");
        Thread.sleep(1000);
        SikuliHelper.paste(SikuliElements.MICR, "520002007");
        page.keyboard().press("Tab");

        SikuliHelper.scrollDown(4);

        String instNo = RandomNumberUtil.generateSixDigitNumber();
        System.out.println("Generated Cheque Instrument No: " + instNo);
        SikuliHelper.paste(SikuliElements.INSTRUMENT_NO, instNo);

        uploadAttachment();
        Thread.sleep(2000);
        finishReceiptFlow();
    }

    public static void fillDraftReceiptFlow(Page page) throws Exception {
        startCommonReceiptFlow("Draft");
        SikuliHelper.paste(SikuliElements.MOBILE_NO, ConfigReader.get("mobile_no"));
        Thread.sleep(1000);
        SikuliHelper.paste(SikuliElements.AMOUNT, "1");
        generatepartpayment();
        SikuliHelper.scrollDown(1);
        Thread.sleep(1000);
        SikuliHelper.paste(SikuliElements.MICR, "520002008");
        page.keyboard().press("Tab");

        SikuliHelper.scrollDown(4);

        String instNo = RandomNumberUtil.generateSixDigitNumber();
        System.out.println("Generated Draft Instrument No: " + instNo);
        SikuliHelper.paste(SikuliElements.INSTRUMENT_NO, instNo);

        uploadAttachment();
        Thread.sleep(2000);
        finishReceiptFlow();
    }

    public static void fillRTGSReceiptFlow(Page page) throws Exception {
        startCommonReceiptFlow("RTGS");
        SikuliHelper.paste(SikuliElements.MOBILE_NO, ConfigReader.get("mobile_no"));
        Thread.sleep(1000);
        SikuliHelper.scrollDown(1);
        Thread.sleep(1000);

        Match match = SikuliHelper.find(SikuliElements.UTR_NO, 5);
        if (match != null) {
            SikuliHelper.click(match);
            SikuliHelper.pasteWithoutTarget(ConfigReader.get("utr_no"));
            Thread.sleep(1500);
            SikuliHelper.clickOffset(match, 0, 35);
        }

        SikuliHelper.scrollUp(1);
        generatepartpayment();

        SikuliHelper.scrollDown(3);

        uploadAttachment();
        Thread.sleep(2000);
        finishReceiptFlow();
    }

    public static void generatepartpayment() throws Exception {
        SikuliHelper.click(SikuliElements.GENERATE_PP);
        Thread.sleep(1500);
        SikuliHelper.paste(SikuliElements.PP_AMOUNT, ConfigReader.get("agreement_no"));
        SikuliHelper.click(SikuliElements.CALCULATE_PP);
        SikuliHelper.click(SikuliElements.PROCEED);
    }

    public static void reselectAgreement(Page page) throws Exception {
        SikuliHelper.click(SikuliElements.AGREEMENTS);
        Thread.sleep(2000);
        SikuliHelper.paste(SikuliElements.SEARCHBAR, ConfigReader.get("agreement_no"));
        page.keyboard().press("Enter");
        Thread.sleep(1500);
        SikuliHelper.click(SikuliElements.AGREEMENT_NO);
    }

    public static void uploadAttachment() throws Exception {
        SikuliHelper.click(SikuliElements.UPLOAD);
        Thread.sleep(2000);
        SikuliHelper.pasteWithoutTarget("D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\email-example.jpg");
        Thread.sleep(1500);
        SikuliHelper.pressEnter();
        Thread.sleep(1500);
        SikuliHelper.scrollDown(1);
    }

    public static void finishReceiptFlow() throws Exception {
        SikuliHelper.click(SikuliElements.PREVIEW);
        Thread.sleep(1500);
        SikuliHelper.click(SikuliElements.SAVE);
        SikuliHelper.scrollDown(3);
        SikuliHelper.click(SikuliElements.RECEIPT);
        SikuliHelper.scrollDown(10);
        SikuliHelper.click(SikuliElements.RECEIPT_CLOSE);
        SikuliHelper.click(SikuliElements.TOAST_CLOSE);
    }
    
    

}
