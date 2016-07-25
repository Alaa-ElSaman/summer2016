import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class Test2 {
	static XSSFRow row ;
	public static void main(String[] args) throws Exception {
		
		//read excel file
		FileInputStream fis = new FileInputStream(new File("student.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		//return the first page in the sheet
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator <Row> rowit = sheet.iterator(); 
		while (rowit.hasNext()) {
			row = (XSSFRow) rowit.next();
		Iterator<Cell> cellit = row.cellIterator();
		while (cellit.hasNext()) {
			Cell cell =  cellit.next();
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC :
				System.out.print(cell.getNumericCellValue()+ "\t \t");
				
				break;
			case Cell.CELL_TYPE_STRING:
				System.out.print(cell.getStringCellValue() +"\t \t");
				break;
			}
		}
		System.out.println();
		}
		fis.close();
	}

}
