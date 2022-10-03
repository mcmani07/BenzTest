package resourses;

public class Keyword {

	public static final String URL = "https://www.amazon.in/";
	public static final String Path_TestData = "C://Users//mcman//eclipse-workspace//MercedesBenzProject//TestCaseSheet.xlsx";
	public static final String File_TestData = "TestCaseSheet.xlsx";
	public static final String KEYWORD_FAIL = "FAIL";
	public static final String KEYWORD_PASS = "PASS";
	
	//Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestScenarioID =1 ;
	public static final int Col_RunMode =1 ;
	public static final int Col_TestStepResult =4 ;
	public static final int Col_DataSet = 3;
	// Excel sheets
	public static final String Sheet_TestSteps = "Keyword";
	public static final String Sheet_TestCases = "Testcase";
	
	
	// Xpath variables
	public static final String bodyType = "//*[contains(text(),'Body Type')]//following::div[1]/div[contains(.,'%s')]/button";
	public static final String firstVehicle = "//div[@id='srp-result']//following::div/div//a[1]";
	public static final String contactMeBtn = "//span[contains(text(),'Contact Me')]//ancestor::button";
	public static final String contactDetailsText = "//*[contains(text(),'Contact details')]";
	public static final String firstNameTextbox = "//label[contains(text(),'First name')]/following::input[1]";
	public static final String lastNameTextbox = "//label[contains(text(),'Last Name')]/following::input[1]";
	public static final String emailTextbox = "//label[contains(text(),'E-mail')]/following::input[1]";
	public static final String mobileNumberTextbox = "//label[contains(text(),'Mobile')]/following::input[1]";
	public static final String commentsTextbox = "//label[contains(text(),'Comment')]/following::textarea";
	public static final String proceedBtn = "//button[text()[contains(.,'Proceed')]]";
	public static final String categoryMobile = "//a[contains(.,'Mobiles')]";
	public static final String categoryMobileAcc = "//a/span[contains(.,'Mobile Accessories')]";
	public static final String pTronPride ="//a[contains(.,'pTron Pride Lite HBE (High Bass Earphones)')]";
	public static final String colorGray =  "//li[@title='Click to select Gray']";
	public static final String AddToCartBtn = "//input[@id='add-to-cart-button']";
}
