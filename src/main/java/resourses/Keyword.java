package resourses;

public class Keyword {

	public static final String URL = "http://shop.mercedes-benz.com/en-th/shop/vehicle/srp";
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
}
