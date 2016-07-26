import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Teacher {
	
	static String teacherFile = "Teacher.xlsx";

	public void updateTeacher(String fileName) throws Exception {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(teacherFile));

			XSSFWorkbook wb = new XSSFWorkbook(fis);// Creating a workbook
													// instance that refers to
													// .xlsx file
			XSSFSheet sheet = wb.getSheetAt(0);// creating a sheet object to
												// retreive the sheet

			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			EditingAnExistingWorkbook adding= new EditingAnExistingWorkbook ();
			
			ArrayList<Integer> math1Teacher= new ArrayList<Integer>();
			ArrayList<Integer> englishTeacher= new ArrayList<Integer>();
			ArrayList<Integer> math2Teacher= new ArrayList<Integer>();
			
			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				Cell StudentName = row.getCell(0);
				System.out.println(StudentName.getStringCellValue()+ "\t");

				Cell StudentID = row.getCell(1);
				Integer studentID = (int) StudentID.getNumericCellValue();
				System.out.print(studentID + "\n");

				Cell Crn1 = row.getCell(2); 
				Integer CRN1 = (int) Crn1.getNumericCellValue();
				
				
				// Trying to display the class for which the student is taking:
				if ( CRN1 == 1225 )
				{
					System.out.println("Teacher " + StudentName + " is teaching Math 1225"); 
					math1Teacher.add(studentID);

				}
				if (CRN1== 1106) 
				{
					System.out.println("Teacher " + StudentName + " is teaching English 1106");
					englishTeacher.add(studentID);
				
				}
			
				if (CRN1 ==1226 ) 
				{
				System.out.println("Teacher " + StudentName + " is teaching Math 1226");
				math2Teacher.add(studentID);
				}

		
			System.out.println();
		

		}
			
			// Adding to the Subjects: 
			// Math1: 
			for (int i = 0; i < math1Teacher.size(); i++) {
				adding.EditCell("Subjects.xlsx",1,2,(2+i), math1Teacher.get(i));// add the student name to the class excel sheet if the name isn't in it
			}
			// English:
			for (int j = 0; j < englishTeacher.size(); j++) {
				adding.EditCell("Subjects.xlsx",2,2,(2+j), englishTeacher.get(j));// add the student name to the class excel sheet if the name isn't in it
			}
			
			// Math2: 
			for (int i = 0; i < math1Teacher.size(); i++) {
				adding.EditCell("Subjects.xlsx",3,2,(2+i),math2Teacher.get(i));// add the student name to the class excel sheet if the name isn't in it
			}
			
			
		}catch (IOException e) {
			System.out.println("You miss typed the location");
		}
	}

	public static void main(String args[]) throws Exception {
		Teacher readExcel = new Teacher();
		readExcel.updateTeacher(teacherFile);

	}
}

/*public class Teacher {

Teacher teacher = new Teacher() {
	protected int teacherID;
	protected int CRN;
};

public Teacher getTeacher() {
	return teacher;
}

public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
}
 
import java.io.*;
import java.util.*;

public class Teacher {
	static String teacherFile = "Teacher.csv";
	File file = new File(teacherFile);

	public void readTeacherCSV(String fileName2) {
		try {
			Scanner inputStream = new Scanner(file);
			inputStream.nextLine();// ignore the first line

			Map<Double, String> nameID = new LinkedHashMap<Double, String>();
			Map<Double, String> idCRN = new LinkedHashMap<Double, String>();

			while (inputStream.hasNext()) {
				String data = inputStream.nextLine();

				String[] key = data.split(",");

				String TeacherName = key[0];
				double TeacherID = Double.parseDouble(key[1]);
				String CRN = key[2];

				nameID.put(TeacherID, TeacherName);
				idCRN.put(TeacherID, CRN);

			}

			// Printing the Data:
			System.out.println(nameID); // 1st method of printing
			System.out.println(idCRN);

			/*
			 * // This is the 2nd method for printing Set
			 * setOfKeys=map.keySet(); Iterator iterator= setOfKeys.iterator();
			 * while(iterator.hasNext()){ String key=(String)iterator.next();
			 * String value=(String)map.get(key);
			 * System.out.println("Key: "+key+"		Value:"+value);
			 * 
			 * }
			 
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file");
		}

	}
	public static void main(String []args){
		Teacher teacher = new Teacher();
		teacher.readTeacherCSV(teacherFile);
	}
}
*/