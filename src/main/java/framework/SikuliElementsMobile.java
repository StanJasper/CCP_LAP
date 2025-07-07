// --- SikuliElements.java ---
package framework;

import org.sikuli.script.Pattern;

public class SikuliElementsMobile {
    private static final String BASE_PATH = "D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\mobile\\";

    public static final Pattern SEARCHBAR = new Pattern(BASE_PATH + "searchbar.png");
    public static final Pattern AGREEMENTS = new Pattern(BASE_PATH + "contactrecording.png");
    public static final Pattern MENU = new Pattern(BASE_PATH + "Menu.png");
    public static final Pattern COLLECTION = new Pattern(BASE_PATH + "Collection.png");
    public static final Pattern AGREEMENTSMENU = new Pattern(BASE_PATH + "AgreementsMenu.png");  
    public static final Pattern ALL_AGREEMENTS = new Pattern(BASE_PATH + "AllAgreements.png").targetOffset(0, -40);    
    public static final Pattern CONTACT_RECORDING = new Pattern(BASE_PATH + "contactrecording.png");

    public static final Pattern SURVEY_TYPE = new Pattern(BASE_PATH + "surveytype.png");
    public static final Pattern Q1 = new Pattern(BASE_PATH + "Q1.png");
    public static final Pattern Q2 = new Pattern(BASE_PATH + "Q2.png");
    public static final Pattern Q3 = new Pattern(BASE_PATH + "Q3.png");
    public static final Pattern NEXT = new Pattern(BASE_PATH + "Next.png");
    public static final Pattern SUBMIT = new Pattern(BASE_PATH + "submit.png");

    public static final Pattern NEW_RECEIPT = new Pattern(BASE_PATH + "newreceiptbutton.png");
    public static final Pattern AGG_NEW_RECEIPT = new Pattern(BASE_PATH + "AggNewReceipt.png");
    public static final Pattern RECEIPT_TYPE = new Pattern(BASE_PATH + "ReceiptType.png").targetOffset(0, -50);
    public static final Pattern SELECT_OVERDUE = new Pattern(BASE_PATH + "SelectReceiptType.png").targetOffset(-140, -70);
    public static final Pattern CONTINUE = new Pattern(BASE_PATH + "Continue.png");

    public static final Pattern CHEQUE_MODE = new Pattern(BASE_PATH + "ChequeMode.png");
    public static final Pattern DRAFT_MODE = new Pattern(BASE_PATH + "DraftMode.png");
    public static final Pattern RTGS_MODE = new Pattern(BASE_PATH + "RTGS.png");

    public static final Pattern CUSTOMER = new Pattern(BASE_PATH + "Customer.png");
    public static final Pattern MOBILE_NO = new Pattern(BASE_PATH + "MobileNo.png");
    public static final Pattern AMOUNT = new Pattern(BASE_PATH + "Amount.png");
    public static final Pattern ADVANCE_EMI = new Pattern(BASE_PATH + "AdvanceEMI.png").targetOffset(135, 0);

    public static final Pattern ACC_NO = new Pattern(BASE_PATH + "AccNo.png");
    public static final Pattern MICR = new Pattern(BASE_PATH + "MICR.png");
    public static final Pattern INSTRUMENT_NO = new Pattern(BASE_PATH + "InstrumentNo.png");
    public static final Pattern UTR_NO = new Pattern(BASE_PATH + "UTRNo.png");

    public static final Pattern UPLOAD = new Pattern(BASE_PATH + "Upload.png").targetOffset(-52, 12);

    public static final Pattern PREVIEW = new Pattern(BASE_PATH + "Preview.png");
    public static final Pattern SAVE = new Pattern(BASE_PATH + "Save.png");
    public static final Pattern RECEIPT = new Pattern(BASE_PATH + "ReceiptPrint.png");
    public static final Pattern RECEIPT_CLOSE = new Pattern(BASE_PATH + "Close.png");
    public static final Pattern TOAST_CLOSE = new Pattern(BASE_PATH + "ToastClose.png");


    public static final Pattern AGREEMENT_NO = new Pattern(BASE_PATH + "agreementnumber.png"); // Optional
}