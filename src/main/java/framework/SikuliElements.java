package framework;

import org.sikuli.script.Pattern;

public class SikuliElements {
    private static final String BASE_PATH = "D:\\1_Jasper\\Automation\\workspace\\PlaywrightAutomation\\src\\main\\java\\resources\\images\\";

    public static final Pattern AGREEMENTS = new Pattern(BASE_PATH + "Agreements.png");
    public static final Pattern SEARCHBAR = new Pattern(BASE_PATH + "AgreementSearch.png").targetOffset(297, 0);
    public static final Pattern AGREEMENT_NO = new Pattern(BASE_PATH + "AgreementNo.png");

    public static final Pattern NEW_RECEIPT = new Pattern(BASE_PATH + "NewReceipt.png");
    public static final Pattern RECEIPT_TYPE = new Pattern(BASE_PATH + "ReceiptType.png").targetOffset(100, 0);
    public static final Pattern SELECT_OVERDUE = new Pattern(BASE_PATH + "SelectReceiptType.png").targetOffset(-100, -80);
    public static final Pattern CONTINUE = new Pattern(BASE_PATH + "Continue.png");

    public static final Pattern CASH_MODE = new Pattern(BASE_PATH + "CashMode.png");
    public static final Pattern CHEQUE_MODE = new Pattern(BASE_PATH + "ChequeMode.png");
    public static final Pattern DRAFT_MODE = new Pattern(BASE_PATH + "DraftMode.png");
    public static final Pattern RTGS_MODE = new Pattern(BASE_PATH + "RTGSMode.png");

    public static final Pattern MOBILE_NO = new Pattern(BASE_PATH + "MobileNo.png");
    public static final Pattern AMOUNT = new Pattern(BASE_PATH + "Amount.png");
    public static final Pattern ADVANCE_EMI = new Pattern(BASE_PATH + "AdvanceEMI.png").targetOffset(135, 0);
    public static final Pattern ACC_NO = new Pattern(BASE_PATH + "AccNo.png");
    public static final Pattern MICR = new Pattern(BASE_PATH + "MICR.png");
    public static final Pattern INSTRUMENT_NO = new Pattern(BASE_PATH + "InstrumentNo.png");

    public static final Pattern UTR_NO = new Pattern(BASE_PATH + "UTRNo.png");

    public static final Pattern UPLOAD = new Pattern(BASE_PATH + "Upload.png").targetOffset(-46, 0);
    public static final Pattern PREVIEW = new Pattern(BASE_PATH + "Preview.png");
    public static final Pattern SAVE = new Pattern(BASE_PATH + "Save.png");

    public static final Pattern RECEIPT = new Pattern(BASE_PATH + "ReceiptPrint.png");
    public static final Pattern RECEIPT_CLOSE = new Pattern(BASE_PATH + "Close.png");
    public static final Pattern TOAST_CLOSE = new Pattern(BASE_PATH + "ToastClose.png");
    
    public static final Pattern CONSENT_UPLOAD = new Pattern(BASE_PATH + "ConsentUpload.png");
    public static final Pattern GENERATE_PP = new Pattern(BASE_PATH + "GeneratePP.png");
    public static final Pattern PP_ALLOCATION = new Pattern(BASE_PATH + "PPAllocation.png").targetOffset(-140, 50);
    public static final Pattern CALCULATE_PP = new Pattern(BASE_PATH + "PPCalculate.png").targetOffset(0, 45);
    public static final Pattern PROCEED = new Pattern(BASE_PATH + "Proceed.png").targetOffset(-35, 50);
    
    public static final Pattern SELECT_PP_TENURE = new Pattern(BASE_PATH + "PPTenureSelection.png").targetOffset(-80, 75);
    public static final Pattern SELECT_PP_EMI = new Pattern(BASE_PATH + "PPTenureSelection.png").targetOffset(-80, 122);
    

	public static Pattern CONTACT_RECORDING;

	public static Pattern SURVEY_TYPE;
}
