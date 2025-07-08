package framework;

import org.sikuli.script.*;

public class ccpLAPpartPaymentApproval {
    static Screen screen = new Screen();
    static String basePath = "D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources";

    public static void raiseApproval(String approvalType) throws Exception {
 //       Pattern agreements = new Pattern(basePath + "\\images\\Agreements.png");
 //       Pattern searchBar = new Pattern(basePath + "\\images\\AgreementSearch.png").targetOffset(297, 0);
 //       Pattern agreementNo = new Pattern(basePath + "\\images\\AgreementNo.png");
        Pattern more = new Pattern(basePath + "\\ppapproval\\More.png");
        Pattern ppApproval = new Pattern(basePath + "\\ppapproval\\PPApproval.png").targetOffset(0, -20);
        Pattern ppAmount = new Pattern(basePath + "\\ppapproval\\PPAmount.png");
        Pattern uploadFile = new Pattern(basePath + "\\ppapproval\\UploadPPFile.png");
        Pattern submit = new Pattern(basePath + "\\ppapproval\\PPSubmit.png").targetOffset(45, 0);

        // Choose appropriate option based on approval type
        Pattern ppType;
        if (approvalType.equalsIgnoreCase("tenure")) {
            ppType = new Pattern(basePath + "\\ppapproval\\PPTenureOption.png");
        } else {
            ppType = new Pattern(basePath + "\\ppapproval\\PPEMIOption.png");
        }
/*
        screen.click(agreements);
        Thread.sleep(2000);
        screen.paste(searchBar, ConfigReader.get("agreement_no"));
        screen.type(Key.ENTER);
        Thread.sleep(2000);
        screen.click(agreementNo);
        Thread.sleep(1000);
*/
        screen.click(more);
        Thread.sleep(1000);
        screen.click(ppApproval);
        Thread.sleep(1000);
        screen.click(ppType);
        Thread.sleep(1000);

        screen.paste(ppAmount, "300000");
        screen.type(Key.TAB);
        screen.type(Key.TAB);
        screen.type("4"); // EMI count
        screen.type(Key.TAB);
        screen.type("PP " + approvalType.substring(0, 1).toUpperCase() + approvalType.substring(1).toLowerCase());

        screen.click(uploadFile);
        Thread.sleep(3000);
        screen.paste(basePath + "\\images\\email-example.jpg");
        screen.type(Key.ENTER);
        Thread.sleep(2000);

        screen.wheel(Button.WHEEL_DOWN, 10);
        screen.click(submit);
        Thread.sleep(2000);
    }
}
