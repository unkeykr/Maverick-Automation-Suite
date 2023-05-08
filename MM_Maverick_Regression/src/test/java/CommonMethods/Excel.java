package CommonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	String xlfilepath = "";
	XSSFWorkbook wb;
	XSSFSheet sheet;
	HashMap<String, Integer> colNums = null;
	FileInputStream fis = null;
	int testRowNo;
	
	//Method for Initializing Excel
	public Excel(String xlfilepath)
	{
		
		try {
			
		this.xlfilepath = xlfilepath;
		fis = new FileInputStream(new File(this.xlfilepath));
		wb = new XSSFWorkbook(fis);
		
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	//Method for Setting SheetName
	public void setSheet(String SheetName) {
		sheet = wb.getSheet(SheetName);
		populateColumnNums();
	}
	
	//Method for getting Column numbers for fetching column names
	
	public void populateColumnNums() 
	{
		colNums = new HashMap<String,Integer>();
		int colIndex=0;
		Row row =sheet.getRow(0);
		Iterator<Cell> cells = row.cellIterator();
		while(cells.hasNext()) {
			Cell cell = cells.next();
			String colName = cell.getStringCellValue();
			colNums.put(colName, colIndex);
			colIndex++;
		}
		
	}
	
	//Method to get colname with column Number
	public int getColNumber(String colName) {
		return colNums.get(colName);
	}
	
	//Overloaded Method for getting Column name instead of Column Number
	
	public String getCellData(int rowNum, String colName)
	{
		String ret = "";
		int colNum = getColNumber(colName);
		ret = getCellData(rowNum, colNum);
		return ret;
	}
	
	// Method to return row number of a specific cell data
	public int getRowNum(String FieldName)
	{
		int rnum=0;
		Row row=null;
		int totalRow=sheet.getLastRowNum();
		for(int rowNo=1;rowNo<=totalRow;rowNo++)
		{
			row=sheet.getRow(rowNo);
			rnum=rnum+1;
			if((row.getCell(0).getStringCellValue()).equalsIgnoreCase(FieldName))
			{
				break;
			}			
		}
		return rnum;
	}
	//Method for Fetching Data from Specific cell by using rownum and col num
	
	public String getCellData(int rowNum, int colNum)
	{
		String ret="";
		try {
			
		
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		if (cell.getCellType()==CellType.STRING) {
			ret = cell.getStringCellValue();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	//Constructor for reading Data from Specific Cell 
	public void readSheetData()
	{
		Iterator<Row> rows = sheet.iterator();
		while(rows.hasNext()) 
		{
			Row currRow = rows.next();
			Iterator<Cell> cells = currRow.cellIterator();
			while(cells.hasNext()) {
				Cell currCell = cells.next();
				CellType cType = currCell.getCellType();
				String CellValue="";
				if(cType==CellType.STRING){
					CellValue = currCell.getStringCellValue();
				}
				else if(cType==CellType.NUMERIC){
					CellValue = "" + currCell.getNumericCellValue();
				}
				
				 
				System.out.println(CellValue);
			}
		}
	}
	
	public void close() {
		try
		{
			if(fis!=null) {
				fis.close();
				wb.close();
			}
		}
			catch(Exception e){
				e.printStackTrace();
				
			}
		
		}
	
}
//	public int getrowNumber(String sheetName, String cellData,String excelPath)
//    {
////        String projectPath = System.getProperty("user.dir");
////        String excelPath = projectPath + "/TestSet.xlsx";
//        File excel = new File(excelPath);
//        FileInputStream fis = null;
//         wb = null;
//        //String cellValue = null;
//        try
//        {
//            fis = new FileInputStream(excel);
//            wb = new XSSFWorkbook(fis);
//            
//            Sheet sheet = wb.getSheet(sheetName);
//            int totalRows = sheet.getLastRowNum();
//            Row row = null;
//            int testRowNo = 0;
//            for(int rowNo =1; rowNo<=totalRows; rowNo++)
//            {
//                row = sheet.getRow(rowNo);
//                testRowNo = testRowNo +1;
//                if(row.getCell(0).getStringCellValue().equalsIgnoreCase(cellData))
//                {
//                    break;
//                }
//            }
//
//
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }finally
//        {
//            try
//            {
//                fis.close();
//            } catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//       
//		return testRowNo;
//    }
//
//	}

