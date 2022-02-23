package util;

import java.lang.reflect.Method;
import resourses.Keyword;
import test.Function;
import util.Driver;

public class Driver {
	public static Function Action;
	public static String sActionKeyword;
	public static Method method[];
		
	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;
	public static String sData;
	public static boolean result;
	


	
public static void execute_TestCase() throws Exception {
	Action = new Function();
	method = Action.getClass().getMethods();
	XLSReader.setExcelFile(Keyword.Path_TestData);
	System.out.println("Starting execution...");
	int iTotalTestCases = XLSReader.getRowCount(Keyword.Sheet_TestCases);
	for(int iTestcase=1;iTestcase<iTotalTestCases;iTestcase++){
		result = false;
		sTestCaseID = XLSReader.getCellData(iTestcase, Keyword.Col_TestCaseID, Keyword.Sheet_TestCases); 
		sRunMode = XLSReader.getCellData(iTestcase, Keyword.Col_RunMode,Keyword.Sheet_TestCases);
		if (sRunMode.equals("Y")){
			System.out.println("Starting TestCase: " +sTestCaseID);
			iTestStep = XLSReader.getRowContains(sTestCaseID, Keyword.Col_TestCaseID, Keyword.Sheet_TestSteps);
			iTestLastStep = XLSReader.getTestStepsCount(Keyword.Sheet_TestSteps, sTestCaseID, iTestStep);
			result=true;
			for (;iTestStep<iTestLastStep;iTestStep++){
	    		sActionKeyword = XLSReader.getCellData(iTestStep, Keyword.Col_TestScenarioID,Keyword.Sheet_TestSteps);
	    		sData = XLSReader.getCellData(iTestStep, Keyword.Col_DataSet, Keyword.Sheet_TestSteps);
	    		execute_Actions();
				if(result==false){
					System.out.println("Ending TestCase: " +sTestCaseID);
					break;
					}						
				}
			if(result==true){
			System.out.println("Ending TestCase: " +sTestCaseID);	
				}					
			}
		}
	}	
 
public static void execute_Actions() throws Exception {
	try {
	 
	for(int i=0;i<method.length;i++){
		
		if(method[i].getName().equals(sActionKeyword)){
			method[i].invoke(Action);
			if(result==true){
				XLSReader.setCellData(Keyword.KEYWORD_PASS, iTestStep, Keyword.Col_TestStepResult, Keyword.Sheet_TestSteps);
				break;
			}else{
				XLSReader.setCellData(Keyword.KEYWORD_FAIL, iTestStep, Keyword.Col_TestStepResult, Keyword.Sheet_TestSteps);
				
				break;
				}
			}
		}
 }catch(Exception e) {
	 System.out.println("Error occured " + e.getMessage());
 }
}

}
