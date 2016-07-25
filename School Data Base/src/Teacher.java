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
 */
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
			 */
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