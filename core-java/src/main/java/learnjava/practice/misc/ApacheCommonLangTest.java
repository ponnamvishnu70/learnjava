package learnjava.practice.misc;

import org.apache.commons.lang3.math.NumberUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ApacheCommonLangTest {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		String wage ="3.94614744E8";
		BigDecimal multiplicand = new BigDecimal(100);
		String scl = String.valueOf(new BigDecimal(wage).setScale(2, BigDecimal.ROUND_HALF_UP).multiply(multiplicand).longValue());
		System.out.println(scl);
		System.out.println(NumberUtils.isNumber("3.94614744E8"));
		readfromexcel();
	}



		
		public static void readfromexcel() throws EncryptedDocumentException, InvalidFormatException, IOException {
			   final String FILE_NAME = "T:\\data\\EOD-Data\\interned_home_20191.xlsx";
			   
			   Workbook workbook = WorkbookFactory.create(new File(FILE_NAME));
			  // workbook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			   System.out.println(workbook.getNumberOfSheets());
			   System.out.println(workbook.getSheetName(0));
			   Sheet sheet = workbook.getSheetAt(0);
			   
			   
			   int rowStart = sheet.getFirstRowNum();
			    int rowEnd =  sheet.getLastRowNum();
			  try { 
				  Row firstRow = sheet.getRow(1);
					if (firstRow == null ||(firstRow != null && firstRow.getPhysicalNumberOfCells()==0)) {
					System.out.println("test");	
					} 
				
			Iterator<Row> r=sheet.iterator();
			 if(r.hasNext()) {
				 
				   //blank row- 09
				   //or
				   //invalid header - 08
				 r.next();
			 }
			   
			
			   while(r.hasNext()) {
				   
				   
				   
				   Row row=r.next();
				   for(int i=0; i<6;i++){
						 Cell cell = row.getCell(i,Row.CREATE_NULL_AS_BLANK);
						 Cell s =cell;
					
							 System.out.println(cell.toString());
						 //		String cellStringValue = cell.getNumericCellValue();
						 
						}
				   int i=0;
				   
				   
			   }
			   
			   workbook.close();}catch(Exception ex) {
				   
			   }

		}
	


}
