package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import resourses.Keyword;


public class XLSReader {

	private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static org.apache.poi.ss.usermodel.Cell Cell;
    private static XSSFRow eRow;


public static void setExcelFile(String Path) throws Exception {
	try {
        FileInputStream ExcelFile = new FileInputStream(Path);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
	} catch (Exception e){
		System.out.println("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
		Driver.result = false;
    	}
	}

public static String getCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
    try{
    	ExcelWSheet = ExcelWBook.getSheet(SheetName);
       	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        String CellData = Cell.getStringCellValue();
        if(CellData.isBlank())
        	return "";
        else
        	return CellData;
     }catch (Exception e){
         System.out.println("Class Utils | Method getCellData | Exception desc : "+e.getMessage());
         Driver.result = false;
         return"";
         }
     }


public static int getRowCount(String SheetName){
	int iNumber=0;
	try {
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		iNumber=ExcelWSheet.getLastRowNum();
		return iNumber;
	} catch (Exception e){
		System.out.println("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
		Driver.result = false;
		}
	return iNumber;
	}

public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
	int iRowNum=0;	
	try {
	    //ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int rowCount = XLSReader.getRowCount(SheetName);
		for (; iRowNum<rowCount; iRowNum++){
			if  (XLSReader.getCellData(iRowNum,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
				break;
			}
		}       			
	} catch (Exception e){
		System.out.println("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
		Driver.result = false;
		}
	return iRowNum;
	}

public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
	try {
		for(int i=iTestCaseStart;i<=XLSReader.getRowCount(SheetName);i++){
			if(!sTestCaseID.equals(XLSReader.getCellData(i, Keyword.Col_TestCaseID, SheetName))){
				int number = i;
				return number;      				
				}
			}
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int number=ExcelWSheet.getLastRowNum()+1;
		return number;
	} catch (Exception e){
		System.out.println("Error occured "+e.getMessage());
		Driver.result = false;
		return 0;
    }
}

public static void setCellData(String Result,  int RowNum, int ColNum, String SheetName) throws Exception    {
       try{
    	   
    	   ExcelWSheet = ExcelWBook.getSheet(SheetName);
           eRow  = ExcelWSheet.getRow(RowNum);
           Cell = eRow.getCell(ColNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
           if (Cell == null) {
        	   Cell = eRow.createCell(ColNum);
        	   Cell.setCellValue(Result);
            } else {
                Cell.setCellValue(Result);
            }
             FileOutputStream fileOut = new FileOutputStream(Keyword.Path_TestData);
             ExcelWBook.write(fileOut);
             fileOut.close();
             ExcelWBook = new XSSFWorkbook(new FileInputStream(Keyword.Path_TestData));
         }catch(Exception e){
        	 Driver.result = false;
  
         }
    }
}
