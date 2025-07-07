package framework;

import com.microsoft.playwright.Page;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.Key;
import org.sikuli.script.Button;

public class ccpLAPBatchChallan {

    static Screen screen = new Screen();
    static String basePath = "D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources";

    public static void runCashBatchAndChallan(Page page) throws Exception {
        runBatch("batch\\batch.png", "batch\\NewBatch.png", "batch\\CashCard.png");
        System.out.println("Waiting before running Cash Challan...");
        Thread.sleep(2000);
        runCashChallan(page);
        Thread.sleep(2000);
    }

    public static void runChequeBatchAndChallan(Page page) throws Exception {
        runBatch("batch\\batch.png", "batch\\NewBatch.png", "batch\\CashCard.png");
        System.out.println("Waiting before running Cheque Challan...");
        Thread.sleep(2000);
        runChequeDraftChallan(page);
        Thread.sleep(2000);
    }

    public static void runDraftBatchAndChallan(Page page) throws Exception {
        runBatch("batch\\batch.png", "batch\\NewBatch.png", "batch\\CashCard.png");
        System.out.println("Waiting before running Draft Challan...");
        Thread.sleep(2000);
        runChequeDraftChallan(page);
        Thread.sleep(2000);
    }

    private static void runBatch(String batchScreen, String newBatchBtn, String submitBtn) throws Exception {
        screen.click(new Pattern(basePath + "\\" + batchScreen));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\" + newBatchBtn));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\" + submitBtn).targetOffset(140, 90));
        Thread.sleep(1000);
        
        //screen.click(new Pattern(basePath + "\\batch\\ToastClose.png"));
        //Thread.sleep(1000);
        
        toastclose();
        

    }

    private static void runCashChallan(Page page) throws Exception {
        screen.click(new Pattern(basePath + "\\challan\\Challan.png"));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\challan\\NewChallan.png"));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\challan\\BankDeposit.png").targetOffset(110, 90));
        Thread.sleep(1000);

        // Paste Challan No (Random 10-digit)
        screen.click(new Pattern(basePath + "\\challan\\ChallanNo.png"));
        Thread.sleep(1000);
        String challanNo = RandomNumberUtil.generateTenDigitChallanNumber();
        screen.paste(challanNo);
        System.out.println("Generated Challan No (Cash): " + challanNo);

        screen.click(new Pattern(basePath + "\\challan\\BankName.png"));
        page.keyboard().press("Enter");
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\challan\\ChallanUpload.png").targetOffset(-47, 0));
        Thread.sleep(1500);
        screen.paste(basePath + "\\challan\\testupload.png");
        Thread.sleep(1500);
        screen.type(Key.ENTER);
        Thread.sleep(1500);

        screen.wheel(Button.WHEEL_DOWN, 5);
        Thread.sleep(1500);

        // Denomination – check if available
        Pattern denomPattern = new Pattern(basePath + "\\challan\\Denomination.png").targetOffset(0, 45);
        if (screen.exists(denomPattern, 3) != null) {
            screen.paste(denomPattern, "1");
            Thread.sleep(1000);
        }

        screen.click(new Pattern(basePath + "\\challan\\ChallanSubmit.png"));
        Thread.sleep(1000);
        toastclose();
    }

    private static void runChequeDraftChallan(Page page) throws Exception {
    	
        screen.click(new Pattern(basePath + "\\challan\\Challan.png"));
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\challan\\NewChallan.png"));
        Thread.sleep(1000);
          	
        screen.click(new Pattern(basePath + "\\challan\\ChequeBankDeposit.png").targetOffset(110, 90));
        Thread.sleep(1000);

        // Paste Challan No (Random 10-digit)
        screen.click(new Pattern(basePath + "\\challan\\ChequeDraftChallanNo.png"));
        Thread.sleep(1000);
        String challanNo = RandomNumberUtil.generateTenDigitChallanNumber();
        screen.paste(challanNo);
        System.out.println("Generated Challan No (Cheque/Draft): " + challanNo);

        screen.click(new Pattern(basePath + "\\challan\\BankName.png"));
        page.keyboard().press("Enter");
        Thread.sleep(1000);

        screen.click(new Pattern(basePath + "\\challan\\ChequeDraftUpload.png").targetOffset(-47, 0));
        Thread.sleep(1500);
        screen.paste(basePath + "\\challan\\testupload.png");
        Thread.sleep(1500);
        screen.type(Key.ENTER);
        Thread.sleep(1500);

        screen.wheel(Button.WHEEL_DOWN, 5);
        Thread.sleep(1500);

        screen.click(new Pattern(basePath + "\\challan\\ChallanSubmit.png"));
        Thread.sleep(1000);
        toastclose();
    }

public static void toastclose() throws Exception {
    SikuliHelper.click(SikuliElements.TOAST_CLOSE);
}
}

