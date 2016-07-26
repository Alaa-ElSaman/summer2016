

public class App {
	public static void main (String[] args) throws Exception {
		Student student = new Student();
		Teacher teacher=new Teacher();

		String studentFile = "Student.xlsx";
		student.updateStudent(studentFile);

		String teacherFile = "Teacher.xlsx";
		teacher.updateTeacher(teacherFile);

		
	}

}