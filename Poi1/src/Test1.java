import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.*;

public class Test1 {

	public static void main(String[] args) throws Exception {
		//create workbook
		
		/*XSSFWorkbook excell = new XSSFWorkbook();
		FileOutputStream fos = new FileOutputStream(new File ("test.xlsx"));
		excell.write(fos);
		fos.close();
		System.out.println("file created");*/
		//to open existing workbook
		/*File f = new File("file to open");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook dd = new XSSFWorkbook (fis);
		
		if (f.isFile() && f.exists()){
			System.out.println("file opened");
			
		}else {
			
			System.out.println("error");
		}
		*/
		//create sheet
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("sheet name");
		XSSFRow row ;
		//put data in the tree map
		Map < String, Object []> student = new TreeMap<String, Object[]>();
		student.put("1", new Object[]{"id","name","grade"});
		student.put("2", new Object[]{"1","ahmed","excellent"});
		student.put("3", new Object[]{"2","mohamed","good"});
		student.put("4", new Object[]{"3","ali","v.good"});
		student.put("5", new Object[]{"4","osama","pass"});
		//put keys in set
		Set <String> key = student.keySet();
		
		int rowid = 0;
		//iterate for adding data on the sheet
	      for (String keyid : key)
	      {
	         row = sheet.createRow(rowid++);
	         Object [] Arr = student.get(keyid);
	         int cellid = 0;
	         for (Object obj : Arr)
	         {
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue(obj.toString());
	         }
	      }
	      //write data in file system
	      FileOutputStream fos = new FileOutputStream(new File ("student.xlsx"));
			wb.write(fos);
			fos.close();
			System.out.println("file written"); 
	}

}
