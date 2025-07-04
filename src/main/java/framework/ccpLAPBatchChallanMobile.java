package framework;

import com.microsoft.playwright.Page;
import org.sikuli.script.*;

public class ccpLAPBatchChallanMobile {

    static Screen screen = new Screen();
    static String basePath = "D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources";

    public static void runMobileBatchAndChallan(Page page) throws Exception {
        runMobileBatch();
        System.out.println("Waiting before running mobile challan...");
        Thread.sleep(2000);
        runMobileChallan(page);
        Thread.sleep(2000);
    }

    private static void runMobileBatch() throws Exception {
        screen.click(new Pattern(basePath + "\\mobilebatch\\Menu.png"));
        Thread.sleep(1000);
        
        screen.click(new Pattern(basePath + "\\mobilebatch\\Collection.png"));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\mobilebatch\\Batch.png"));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\mobilebatch\\NewMenu.png"));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\mobilebatch\\New.png"));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\mobilebatch\\BatchSubmit.png").targetOffset(140, 90));
        Thread.sleep(1000);
    }

    private static void runMobileChallan(Page page) throws Exception {
        screen.click(new Pattern(basePath + "\\mobilebatch\\Menu.png"));
        Thread.sleep(1000);
                
        screen.click(new Pattern(basePath + "\\mobilebatch\\Collection.png"));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\mobilechallan\\Challan.png"));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\mobilebatch\\NewMenu.png")); // Assuming reused image
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\mobilebatch\\New.png"));
        Thread.sleep(5000);

        screen.click(new Pattern(basePath + "\\mobilechallan\\DepositBank.png").targetOffset(100, 85));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\mobilechallan\\ChallanNo.png"));
        Thread.sleep(1000);
        String challanNo = RandomNumberUtil.generateTenDigitChallanNumber();
        screen.paste(challanNo);
        System.out.println("Generated Challan No (Mobile): " + challanNo);

        screen.click(new Pattern(basePath + "\\mobilechallan\\Bank.png"));
        page.keyboard().press("Enter");
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\mobilechallan\\ChallanUpload.png").targetOffset(-48, 0));
        Thread.sleep(1000);
        screen.paste(basePath + "\\images\\email-example.jpg");
        screen.type(Key.ENTER);
        Thread.sleep(1500);

        screen.wheel(Button.WHEEL_DOWN, 5);
        Thread.sleep(1500);

        Pattern denomPattern = new Pattern(basePath + "\\mobilechallan\\Denomination.png").targetOffset(0, 135);
        if (screen.exists(denomPattern, 3) != null) {
            screen.paste(denomPattern, "1");
            Thread.sleep(1000);
        }

        screen.click(new Pattern(basePath + "\\mobilechallan\\SubmitChallan.png").targetOffset(45, 0));
        Thread.sleep(1000);
    }
}
