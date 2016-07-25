import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Student {
	static String fileName = "Student.xlsx";
	File ReadXLXS = new File(fileName);

	public void ReadXLXS(String fileName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(ReadXLXS);

			XSSFWorkbook wb = new XSSFWorkbook(fis);// Creating a workbook
													// instance that refers to
													// .xlsx file
			XSSFSheet sheet = wb.getSheetAt(0);// creating a sheet object to
												// retreive the sheet

			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				Cell StudentName = row.getCell(0);
				System.out.println(StudentName.getStringCellValue()+ "\t");

				Cell StudentID = row.getCell(1);
				System.out.print(StudentID.getNumericCellValue() + "\n");

				Cell Crn1 = row.getCell(2); 
				Integer CRN1 = (int) Crn1.getNumericCellValue();
				
				
				Cell Crn2 = row.getCell(3); 
				Integer CRN2 = (int) Crn2.getNumericCellValue();
				
				// Trying to display the class for which the student is taking:
				
//				if (Crn1.getStringCellValue().equals("1225")  || Crn2.getStringCellValue().equals("1225")) {
				
				if ( ( CRN1 == 1225) || CRN2 == 1225 ) {
				
					System.out.println("Student " + StudentName
							+ " is taking Math 1225"); // add the student name
														// to the class excel
														// sheet if the name
														// isn't in it

				}
				if (CRN1== 1106 || CRN2==1106 ) {
					System.out.println("Student " + StudentName + " is taking English 1106");
				}
			
			 if (CRN1 ==1226 || CRN2==1226 ) {
				System.out.println("Student " + StudentName + " is taking Math 1226");
			}

			/*
			 * 
			 * // Trying to display the class for which the student is taking:
			 * if (CRN.equals("1225") ) { System.out.println("Student "+
			 * StudentName + " is taking Math 1225"); // add the student name to
			 * the class excel sheet if the name isn't in it } if
			 * (CRN.equals("1106")) { System.out.println("Student " +
			 * StudentName + " is taking English 1106"); } if
			 * (CRN.equals("1226")) { System.out.println("Student " +
			 * StudentName + " is taking Math 1226"); } } /* /*FormulaEvaluator
			 * formulaEvaluator =
			 * wb.getCreationHelper().createFormulaEvaluator();// that is for
			 * evaluate the cell type for (Row row : sheet) { for (Cell cell :
			 * row) { switch
			 * (formulaEvaluator.evaluateInCell(cell).getCellType()) { case
			 * Cell.CELL_TYPE_NUMERIC: // if cell is a numeric format /* When
			 * you deal with dates if (DateUtil.isCellDateFormatted(cell)) {
			 * System.out.println(cell.getDateCellValue()+"\t\t"); } else {
			 */
			/*
			 * System.out.print(cell.getNumericCellValue() + "\t\t"); // }
			 * break; case Cell.CELL_TYPE_STRING:// if cell is a string format
			 * System.out.print(cell.getStringCellValue() + "\t\t"); break; } }
			 */
			System.out.println();
			// }

		}
		}catch (IOException e) {
			System.out.println("You miss typed the location");
		}
	}

	public static void main(String args[]) {
		Student readExcel = new Student();
		readExcel.ReadXLXS(fileName);

	}
}

/*
 * public void writeSubjects(String sb) throws FileNotFoundException{
 * PrintWriter pw = new PrintWriter(new File("Subject.csv")); StringBuilder sb =
 * new StringBuilder();
 * 
 * pw.write(sb.toString()); pw.close(); }
 * 
 * public void readStudentCSV(String fileName2) {
 * 
 * try { Scanner inputStream = new Scanner(file); inputStream.nextLine();//
 * ignore the first line
 * 
 * Map<Double, String> nameID = new LinkedHashMap<Double, String>(); Map<Double,
 * String> idCRN1 = new LinkedHashMap<Double, String>(); Map<Double, String>
 * idCRN2 = new LinkedHashMap<Double, String>();
 * 
 * while (inputStream.hasNext()) {
 * 
 * // This is the entire line which we will split by columns: String data =
 * inputStream.nextLine();
 * 
 * // Splitting and reading each column seperatly: String[] key =
 * data.split(",");
 * 
 * String StudentName = key[0]; double StudentID = Double.parseDouble(key[1]);
 * String Classes = key[2]; // Trying to Split the different classes the student
 * might be taking . String[] CRN = Classes.split(" "); String CRN1 = CRN[0];
 * String CRN2 = CRN[1];
 * 
 * // Trying to display the class for which the student is taking: if
 * (CRN1.equals("1225") || CRN2.equals("1225")) { System.out.println("Student "
 * + StudentName + " is taking Math 1225"); // add the student name to the class
 * excel sheet if the name isn't in it } if (CRN1.equals("1106") ||
 * CRN2.equals("1106")) { System.out.println("Student " + StudentName +
 * " is taking English 1106"); } if (CRN1.equals("1226") || CRN2.equals("1226"))
 * { System.out.println("Student " + StudentName + " is taking Math 1226"); }
 * 
 * 
 * 
 * // Setting Hashmaps: nameID.put(StudentID, StudentName);
 * idCRN1.put(StudentID, CRN1); idCRN2.put(StudentID, CRN2);
 * 
 * }
 * 
 * // Printing the Data: System.out.println(nameID); // 1st method of printing
 * System.out.println(idCRN1); System.out.println(idCRN2);
 * 
 * /* // This is the 2nd method for printing Set setOfKeys=map.keySet();
 * Iterator iterator= setOfKeys.iterator(); while(iterator.hasNext()){ String
 * key=(String)iterator.next(); String value=(String)map.get(key);
 * System.out.println("Key: "+key+"		Value:"+value);
 * 
 * }
 * 
 * 
 * inputStream.close(); } catch (FileNotFoundException e) {
 * System.out.println("Could not find the file"); } }
 * 
 * public static void main(String[] args) { Student student = new Student();
 * student.readStudentCSV(studentFile); }
 * 
 * }
 */